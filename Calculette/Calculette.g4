grammar Calculette;

    @parser::members {
        private TablesSymboles tablesSymboles = new TablesSymboles();

        private String fo (String op) {
            if ( op.equals("*") ) {
                return "MUL";
            } else if ( op.equals("+") ) {
                return "ADD";
            } else if ( op.equals("-")) {
                return "SUB" ;
            } else if(op.equals("/")) {
            return "DIV" ;
            } else {
            System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
            throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
            }
        }

        private String conditionBuilder (String op){
            if ( op.equals("<") || op.equals(">") 
                || op.equals("<=") || op.equals(">=")
                || op.equals("==") || op.equals("!=")) {
                return relOp(op);
            } else if(op.equals("||") || op.equals("&&")
                || op.equals("!")) {
                return logExp(op) ;
            } else {
            System.err.println("Opérateur logique incorrect : '"+op+"'");
            throw new IllegalArgumentException("Opérateur logique incorrect : '"+op+"'");
            }
        }

        private String relOp (String op) {
            if ( op.equals("<") ) {
                return "INF";
            } else if ( op.equals(">") ) {
                return "SUP";
            } else if ( op.equals("<=")) {
                return "INFEQ" ;
            } else if(op.equals(">=")) {
                return "SUPEQ" ;
            } else if(op.equals("==")) {
                return "EQUAL" ;
            } else if(op.equals("!=")) {
                return "NEQ" ;
            } else {
                System.err.println("Opérateur logique incorrect : '"+op+"'");
                throw new IllegalArgumentException("Opérateur logique incorrect : '"+op+"'");
            }
        }

        private String logExp (String op) {
            return null;
        }

        private int _cur_label = 0;
        /** générateur de nom d'étiquettes */
        private int nextLabel() { return _cur_label++; }
    }

    start
        : calcul EOF;

    calcul returns [ String code ]
        @init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
        @after{ System.out.println($code); }
        :   (decl { $code += $decl.code; })*
        {int entry = nextLabel(); $code += "JUMP " + entry + "\n"; }
        NEWLINE*

        (fonction { $code += $fonction.code; })*
        NEWLINE*

        {$code += "LABEL " + entry + "\n"; }
        (instruction { $code += $instruction.code; })*

        { $code += "HALT"; }
        ;

    fonction returns [String code]
        @init { //instancier la table locale
            tablesSymboles.newTableLocale();
        }
        @after { //détruire la table locale
            tablesSymboles.dropTableLocale();
        }
        :TYPE IDENTIFIANT '(' params ? ')'
            {
                int funcLabel = nextLabel();
                $code = "LABEL " + funcLabel + "\n";
                tablesSymboles.newFunction($IDENTIFIANT.text, funcLabel, $TYPE.text);
                // code java pour gérer la déclaration de "la variable" de retour de la fonction
                tablesSymboles.putVar("return", $TYPE.text);
            } 
            bloc
            {
                $code += $bloc.code;
            } 
        ;

    params
        : TYPE IDENTIFIANT
            {
                // code java gérant une variable locale (argi)
                tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
            }
            ( ',' TYPE IDENTIFIANT
                {
                    // code java gérant une variable locale (argi)
                    tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
                }
            )*
        ;

    // init nécessaire à cause du ? final et donc args peut être vide (mais $args sera non null)
    args returns [String code, int size] @init{ $code = new String(); $size = 0;}
    : (arg0 = expression
        {
            // code java pour première expression pour arg
            $size = 1;
            $code = $arg0.code;
        }
        ( ',' argn = expression
            {
                // code java pour expression suivante pour arg
                $size++;
                $code += $argn.code;
            }
        )*
    )?
    ;

    expression returns [String code]
        :  a=expression op=('*'|'/') b=expression {$code= $a.code +  $b.code + fo($op.text) + "\n";}
        |  a=expression op=('+'|'-') b=expression {$code= $a.code +  $b.code + fo($op.text) + "\n";}
        |  '(' e=expression ')'  { $code=$e.code ;}
        | ENTIER {$code = "PUSHI " + $ENTIER.text + "\n";}
        | IDENTIFIANT '(' args ')'                  // appel de fonction  
            {  
                $code = "PUSHI 0\n";
                $code += $args.code;
                AdresseType at = tablesSymboles.getFunction($IDENTIFIANT.text);
                $code += "CALL " + at.adresse + "\n";
                for(int i = 0; i < $args.size; i++){
                    $code += "POP\n";
                }
            }
        | IDENTIFIANT 
            {
                AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
                int adr = at.adresse;
                if (adr < 0) {
                    $code = "PUSHL " + adr + "\n";
                } else {
                    $code = "PUSHG " + adr + "\n";
                }
            }
        ;

    decl returns [ String code ]
        :
            // On place 0 sur la pile & on le stocke à l'emplacement 0
        TYPE IDENTIFIANT finInstruction
            {
                tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
                $code = "PUSHI 0 \n";
            }
        | TYPE IDENTIFIANT '=' expression finInstruction
            {
                tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
                $code = $expression.code + "\n";
            }
        ;

    bloc returns [ String code ] 
        @init{ $code = new String(); }
        : '{' NEWLINE*
        ( instruction { $code += $instruction.code; } )* '}'
        NEWLINE*
        ;

    instruction returns [ String code ]
        : 'write' '(' expression ')' finInstruction
            {
                $code = $expression.code;
                $code += "WRITE\nPOP\n";
            }
        | 'while' '(' c=condition ')' i=instruction
            {
                int blockLabel = _cur_label;
                $code = "LABEL " + blockLabel + "\n";
                $code += $c.code + "\n";
                nextLabel();
                $code += "JUMPF " + _cur_label + "\n";
                $code += $i.code;
                $code += "JUMP " + blockLabel + "\n";
                $code += "LABEL " + _cur_label + "\n";
                nextLabel();
            }
        | 'for' '(' init=assignation ';' c=condition ';' incr=assignation ')' i=instruction
            {
                int blockLabel = _cur_label;
                $code = $init.code;
                $code += "LABEL " + blockLabel + "\n";
                $code += $c.code + "\n";
                nextLabel();
                $code += "JUMPF " + _cur_label + "\n";
                $code += $i.code;
                $code += $incr.code;
                $code += "JUMP " + blockLabel + "\n";
                $code += "LABEL " + _cur_label + "\n";
                nextLabel();
            }
        | 'repeat' i=instruction 'until' '(' c=condition ')'
            {
                int blockLabel = _cur_label;
                $code = "LABEL " + blockLabel + "\n";
                $code += $i.code;
                $code += $c.code + "\n";
                nextLabel();
                $code += "JUMPF " + _cur_label + "\n";
                $code += "JUMP " + blockLabel + "\n";
                $code += "LABEL " + _cur_label + "\n";
                nextLabel();
            }

        | RETURN expression finInstruction 
            {
                $code = $expression.code;
                $code += "STOREL " + "\n";
                $code += "RETURN\n";
            }

        | expression finInstruction
            {
                $code = $expression.code;
            }
        | assignation finInstruction
            {
                $code = $assignation.code;
            }
        | finInstruction
            {
                $code = "";
            }
        ;

    assignation returns [ String code ]
        : IDENTIFIANT '=' expression
            {
                AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
                int adr = at.adresse;
                $code = $expression.code;
                if(adr < 0) {
                    $code += "STOREL " + adr + "\n";
                } else {
                    $code += "STOREG " + adr + "\n";
                }
            }
        | 'read(' IDENTIFIANT ')'
            {
                AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
                int adr = at.adresse;
                $code = "READ\n";
                if(adr < 0) {
                    $code += "STOREL " + adr + "\n";
                } else {
                    $code += "STOREG " + adr + "\n";
                }
            }
        ;
    
    condition returns [String code]
        : 'true' {$code = "PUSHI 1\nPUSHI 0\nEQUAL";}
        | 'false' {$code = "PUSHI 0\nPUSHI 0\nEQUAL";}
        | a=expression op=('==' | '<=' | '>=' | '<' | '>' | '!=') b=expression
            {
                $code = $a.code;
                $code += $b.code;
                $code += conditionBuilder($op.text);
            }
        ;

    finInstruction : ( NEWLINE | ';' )+ ;

    // lexer
    RETURN: 'return';

    TYPE : 'int' | 'float' ;

    IDENTIFIANT : [a-z]+;

    NEWLINE : '\r'? '\n';

    WS :   (' '|'\t')+ -> skip  ;

    ENTIER : ('0'..'9')+  ;

    UNMATCH : . -> skip ;


