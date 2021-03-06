grammar Calculette;

    @parser::members {
        private TableSymboles tableSymboles = new TableSymboles();

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
            if () {
                ;
            }
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

        NEWLINE*

        (instruction { $code += $instruction.code; })*

            { $code += "HALT"; }
        ;

    expression returns [String code]
        :  a=expression op=('*'|'/') b=expression {$code= $a.code +  $b.code + fo($op.text) + "\n";}
        |  a=expression op=('+'|'-') b=expression {$code= $a.code +  $b.code + fo($op.text) + "\n";}
        |  '(' e=expression ')'  { $code=$e.code ;}
        | ENTIER {$code = "PUSHI " + $ENTIER.text +"\n";}
        | IDENTIFIANT 
            {
                AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
                int adr = at.adresse;
                $code = "PUSHG " + adr + "\n";
            }
        ;

    decl returns [ String code ]
        :
            // On place 0 sur la pile & on le stocke à l'emplacement 0
        TYPE IDENTIFIANT finInstruction
            {
                int adr = tableSymboles.getSize();
                tableSymboles.putVar($IDENTIFIANT.text, "int");
                $code = "PUSHI 0 \n";
            }
        | TYPE IDENTIFIANT '=' expression finInstruction
            {
                int adr = tableSymboles.getSize();
                tableSymboles.putVar($IDENTIFIANT.text, "int");
                $code = $expression.code;
            }
        ;

    bloc returns [ String code ] 
        @init{ $code = new String(); }
        : '{' (instruction { $code += $instruction.code; })* '}'
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
                $code = init.code;
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
                AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
                int adr = at.adresse;
                $code = $expression.code;
                $code += "STOREG " + adr + "\n";
            }
        | 'read(' IDENTIFIANT ')'
            {
                AdresseType at = tableSymboles.getAdresseType($IDENTIFIANT.text);
                int adr = at.adresse;
                $code = "READ\n";
                $code += "STOREG " + adr + "\n";
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
    TYPE : 'int' | 'float' ;

    IDENTIFIANT : [a-z]+;

    NEWLINE : '\r'? '\n';

    WS :   (' '|'\t')+ -> skip  ;

    ENTIER : ('0'..'9')+  ;

    UNMATCH : . -> skip ;
