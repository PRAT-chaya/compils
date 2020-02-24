// Generated from c:\Users\brioc\Desktop\L3informatique\thLangCompil\tp7\Calculette\Calculette.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, RETURN=26, TYPE=27, IDENTIFIANT=28, NEWLINE=29, WS=30, ENTIER=31, 
		UNMATCH=32;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_fonction = 2, RULE_params = 3, RULE_args = 4, 
		RULE_expression = 5, RULE_decl = 6, RULE_bloc = 7, RULE_instruction = 8, 
		RULE_assignation = 9, RULE_condition = 10, RULE_finInstruction = 11;
	public static final String[] ruleNames = {
		"start", "calcul", "fonction", "params", "args", "expression", "decl", 
		"bloc", "instruction", "assignation", "condition", "finInstruction"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "','", "'*'", "'/'", "'+'", "'-'", "'='", "'{'", "'}'", 
		"'write'", "'while'", "'for'", "';'", "'repeat'", "'until'", "'read('", 
		"'true'", "'false'", "'=='", "'<='", "'>='", "'<'", "'>'", "'!='", "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "RETURN", "TYPE", "IDENTIFIANT", "NEWLINE", "WS", "ENTIER", 
		"UNMATCH"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
	    
	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			calcul();
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public FonctionContext fonction;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(27);
					((CalculContext)_localctx).decl = decl();
					 _localctx.code += ((CalculContext)_localctx).decl.code; 
					}
					} 
				}
				setState(34);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			int entry = nextLabel(); _localctx.code += "JUMP " + entry + "\n"; 
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(36);
					match(NEWLINE);
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(42);
				((CalculContext)_localctx).fonction = fonction();
				 _localctx.code += ((CalculContext)_localctx).fonction.code; 
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(50);
					match(NEWLINE);
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			_localctx.code += "LABEL " + entry + "\n"; 
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER))) != 0)) {
				{
				{
				setState(57);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "HALT"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public BlocContext bloc;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fonction);
		 //instancier la table locale
		            tablesSymboles.newTableLocale();
		        
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			((FonctionContext)_localctx).TYPE = match(TYPE);
			setState(68);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(69);
			match(T__0);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(70);
				params();
				}
			}

			setState(73);
			match(T__1);

			                int funcLabel = nextLabel();
			                ((FonctionContext)_localctx).code =  "LABEL " + funcLabel + "\n";
			                tablesSymboles.newFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), funcLabel, (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
			                // code java pour gérer la déclaration de "la variable" de retour de la fonction
			                tablesSymboles.putVar("return", (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
			            
			setState(75);
			((FonctionContext)_localctx).bloc = bloc();

			                _localctx.code += ((FonctionContext)_localctx).bloc.code;
			            
			}
			_ctx.stop = _input.LT(-1);
			 //détruire la table locale
			            tablesSymboles.dropTableLocale();
			        
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public Token TYPE;
		public Token IDENTIFIANT;
		public List<TerminalNode> TYPE() { return getTokens(CalculetteParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculetteParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculetteParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculetteParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(79);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

			                // code java gérant une variable locale (argi)
			                tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
			            
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(81);
				match(T__2);
				setState(82);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(83);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				                    // code java gérant une variable locale (argi)
				                    tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
				                
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExpressionContext arg0;
		public ExpressionContext argn;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IDENTIFIANT) | (1L << ENTIER))) != 0)) {
				{
				setState(90);
				((ArgsContext)_localctx).arg0 = expression(0);

				            // code java pour première expression pour arg
				            ((ArgsContext)_localctx).size =  1;
				            ((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).arg0.code;
				        
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(92);
					match(T__2);
					setState(93);
					((ArgsContext)_localctx).argn = expression(0);

					                // code java pour expression suivante pour arg
					                _localctx.size++;
					                _localctx.code += ((ArgsContext)_localctx).argn.code;
					            
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext a;
		public ExpressionContext e;
		public Token ENTIER;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(104);
				match(T__0);
				setState(105);
				((ExpressionContext)_localctx).e = expression(0);
				setState(106);
				match(T__1);
				 ((ExpressionContext)_localctx).code = ((ExpressionContext)_localctx).e.code ;
				}
				break;
			case 2:
				{
				setState(109);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) + "\n";
				}
				break;
			case 3:
				{
				setState(111);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(112);
				match(T__0);
				setState(113);
				((ExpressionContext)_localctx).args = args();
				setState(114);
				match(T__1);
				  
				                ((ExpressionContext)_localctx).code =  "PUSHI 0\n";
				                _localctx.code += ((ExpressionContext)_localctx).args.code;
				                AdresseType at = tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				                _localctx.code += "CALL " + at.adresse + "\n";
				                for(int i = 0; i < ((ExpressionContext)_localctx).args.size; i++){
				                    _localctx.code += "POP\n";
				                }
				            
				}
				break;
			case 4:
				{
				setState(117);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				                AdresseType at = tablesSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				                int adr = at.adresse;
				                if (adr < 0) {
				                    ((ExpressionContext)_localctx).code =  "PUSHL " + adr + "\n";
				                } else {
				                    ((ExpressionContext)_localctx).code =  "PUSHG " + adr + "\n";
				                }
				            
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(121);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(122);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(123);
						((ExpressionContext)_localctx).b = expression(7);
						((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code +  ((ExpressionContext)_localctx).b.code + fo((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)) + "\n";
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(127);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(128);
						((ExpressionContext)_localctx).b = expression(6);
						((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code +  ((ExpressionContext)_localctx).b.code + fo((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null)) + "\n";
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_decl);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(137);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(138);
				finInstruction();

				                tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				                ((DeclContext)_localctx).code =  "PUSHI 0 \n";
				            
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(142);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(143);
				match(T__7);
				setState(144);
				((DeclContext)_localctx).expression = expression(0);
				setState(145);
				finInstruction();

				                tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				                ((DeclContext)_localctx).code =  ((DeclContext)_localctx).expression.code + "\n";
				            
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bloc);
		 ((BlocContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__8);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(151);
					match(NEWLINE);
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER))) != 0)) {
				{
				{
				setState(157);
				((BlocContext)_localctx).instruction = instruction();
				 _localctx.code += ((BlocContext)_localctx).instruction.code; 
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
			match(T__9);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(166);
					match(NEWLINE);
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public ConditionContext c;
		public InstructionContext i;
		public AssignationContext init;
		public AssignationContext incr;
		public AssignationContext assignation;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public TerminalNode RETURN() { return getToken(CalculetteParser.RETURN, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instruction);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(T__10);
				setState(173);
				match(T__0);
				setState(174);
				((InstructionContext)_localctx).expression = expression(0);
				setState(175);
				match(T__1);
				setState(176);
				finInstruction();

				                ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				                _localctx.code += "WRITE\nPOP\n";
				            
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(T__11);
				setState(180);
				match(T__0);
				setState(181);
				((InstructionContext)_localctx).c = condition();
				setState(182);
				match(T__1);
				setState(183);
				((InstructionContext)_localctx).i = instruction();

				                int blockLabel = _cur_label;
				                ((InstructionContext)_localctx).code =  "LABEL " + blockLabel + "\n";
				                _localctx.code += ((InstructionContext)_localctx).c.code + "\n";
				                nextLabel();
				                _localctx.code += "JUMPF " + _cur_label + "\n";
				                _localctx.code += ((InstructionContext)_localctx).i.code;
				                _localctx.code += "JUMP " + blockLabel + "\n";
				                _localctx.code += "LABEL " + _cur_label + "\n";
				                nextLabel();
				            
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				match(T__12);
				setState(187);
				match(T__0);
				setState(188);
				((InstructionContext)_localctx).init = assignation();
				setState(189);
				match(T__13);
				setState(190);
				((InstructionContext)_localctx).c = condition();
				setState(191);
				match(T__13);
				setState(192);
				((InstructionContext)_localctx).incr = assignation();
				setState(193);
				match(T__1);
				setState(194);
				((InstructionContext)_localctx).i = instruction();

				                int blockLabel = _cur_label;
				                ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).init.code;
				                _localctx.code += "LABEL " + blockLabel + "\n";
				                _localctx.code += ((InstructionContext)_localctx).c.code + "\n";
				                nextLabel();
				                _localctx.code += "JUMPF " + _cur_label + "\n";
				                _localctx.code += ((InstructionContext)_localctx).i.code;
				                _localctx.code += ((InstructionContext)_localctx).incr.code;
				                _localctx.code += "JUMP " + blockLabel + "\n";
				                _localctx.code += "LABEL " + _cur_label + "\n";
				                nextLabel();
				            
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(T__14);
				setState(198);
				((InstructionContext)_localctx).i = instruction();
				setState(199);
				match(T__15);
				setState(200);
				match(T__0);
				setState(201);
				((InstructionContext)_localctx).c = condition();
				setState(202);
				match(T__1);

				                int blockLabel = _cur_label;
				                ((InstructionContext)_localctx).code =  "LABEL " + blockLabel + "\n";
				                _localctx.code += ((InstructionContext)_localctx).i.code;
				                _localctx.code += ((InstructionContext)_localctx).c.code + "\n";
				                nextLabel();
				                _localctx.code += "JUMPF " + _cur_label + "\n";
				                _localctx.code += "JUMP " + blockLabel + "\n";
				                _localctx.code += "LABEL " + _cur_label + "\n";
				                nextLabel();
				            
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				match(RETURN);
				setState(206);
				((InstructionContext)_localctx).expression = expression(0);
				setState(207);
				finInstruction();

				                ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				                _localctx.code += "STOREL " + "\n";
				                _localctx.code += "RETURN\n";
				            
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(210);
				((InstructionContext)_localctx).expression = expression(0);
				setState(211);
				finInstruction();

				                ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				            
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(214);
				((InstructionContext)_localctx).assignation = assignation();
				setState(215);
				finInstruction();

				                ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				            
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(218);
				finInstruction();

				                ((InstructionContext)_localctx).code =  "";
				            
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignation);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(224);
				match(T__7);
				setState(225);
				((AssignationContext)_localctx).expression = expression(0);

				                AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				                int adr = at.adresse;
				                ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code;
				                if(adr < 0) {
				                    _localctx.code += "STOREL " + adr + "\n";
				                } else {
				                    _localctx.code += "STOREG " + adr + "\n";
				                }
				            
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				match(T__16);
				setState(229);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(230);
				match(T__1);

				                AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				                int adr = at.adresse;
				                ((AssignationContext)_localctx).code =  "READ\n";
				                if(adr < 0) {
				                    _localctx.code += "STOREL " + adr + "\n";
				                } else {
				                    _localctx.code += "STOREG " + adr + "\n";
				                }
				            
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext a;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_condition);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(T__17);
				((ConditionContext)_localctx).code =  "PUSHI 1\nPUSHI 0\nEQUAL";
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(T__18);
				((ConditionContext)_localctx).code =  "PUSHI 0\nPUSHI 0\nEQUAL";
				}
				break;
			case T__0:
			case IDENTIFIANT:
			case ENTIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				((ConditionContext)_localctx).a = expression(0);
				setState(239);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(240);
				((ConditionContext)_localctx).b = expression(0);

				                ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code;
				                _localctx.code += ((ConditionContext)_localctx).b.code;
				                _localctx.code += conditionBuilder((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null));
				            
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(245);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(248); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00fd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3"+
		"\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63\13\3"+
		"\3\3\7\3\66\n\3\f\3\16\39\13\3\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B\13\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\5\4J\n\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\7\5X\n\5\f\5\16\5[\13\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6c\n\6"+
		"\f\6\16\6f\13\6\5\6h\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7z\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7"+
		"\7\u0086\n\7\f\7\16\7\u0089\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u0097\n\b\3\t\3\t\7\t\u009b\n\t\f\t\16\t\u009e\13\t\3\t"+
		"\3\t\3\t\7\t\u00a3\n\t\f\t\16\t\u00a6\13\t\3\t\3\t\7\t\u00aa\n\t\f\t\16"+
		"\t\u00ad\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u00e0\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00eb"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f6\n\f\3\r\6\r\u00f9"+
		"\n\r\r\r\16\r\u00fa\3\r\2\3\f\16\2\4\6\b\n\f\16\20\22\24\26\30\2\6\3\2"+
		"\6\7\3\2\b\t\3\2\26\33\4\2\20\20\37\37\2\u010d\2\32\3\2\2\2\4\"\3\2\2"+
		"\2\6E\3\2\2\2\bP\3\2\2\2\ng\3\2\2\2\fy\3\2\2\2\16\u0096\3\2\2\2\20\u0098"+
		"\3\2\2\2\22\u00df\3\2\2\2\24\u00ea\3\2\2\2\26\u00f5\3\2\2\2\30\u00f8\3"+
		"\2\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34\3\3\2\2\2\35\36\5\16\b\2\36\37\b"+
		"\3\1\2\37!\3\2\2\2 \35\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2"+
		"\2$\"\3\2\2\2%)\b\3\1\2&(\7\37\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3"+
		"\2\2\2*\61\3\2\2\2+)\3\2\2\2,-\5\6\4\2-.\b\3\1\2.\60\3\2\2\2/,\3\2\2\2"+
		"\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\67\3\2\2\2\63\61\3\2\2\2\64"+
		"\66\7\37\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2"+
		"\2\29\67\3\2\2\2:@\b\3\1\2;<\5\22\n\2<=\b\3\1\2=?\3\2\2\2>;\3\2\2\2?B"+
		"\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\b\3\1\2D\5\3\2\2\2"+
		"EF\7\35\2\2FG\7\36\2\2GI\7\3\2\2HJ\5\b\5\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2"+
		"\2KL\7\4\2\2LM\b\4\1\2MN\5\20\t\2NO\b\4\1\2O\7\3\2\2\2PQ\7\35\2\2QR\7"+
		"\36\2\2RY\b\5\1\2ST\7\5\2\2TU\7\35\2\2UV\7\36\2\2VX\b\5\1\2WS\3\2\2\2"+
		"X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\t\3\2\2\2[Y\3\2\2\2\\]\5\f\7\2]d\b\6\1"+
		"\2^_\7\5\2\2_`\5\f\7\2`a\b\6\1\2ac\3\2\2\2b^\3\2\2\2cf\3\2\2\2db\3\2\2"+
		"\2de\3\2\2\2eh\3\2\2\2fd\3\2\2\2g\\\3\2\2\2gh\3\2\2\2h\13\3\2\2\2ij\b"+
		"\7\1\2jk\7\3\2\2kl\5\f\7\2lm\7\4\2\2mn\b\7\1\2nz\3\2\2\2op\7!\2\2pz\b"+
		"\7\1\2qr\7\36\2\2rs\7\3\2\2st\5\n\6\2tu\7\4\2\2uv\b\7\1\2vz\3\2\2\2wx"+
		"\7\36\2\2xz\b\7\1\2yi\3\2\2\2yo\3\2\2\2yq\3\2\2\2yw\3\2\2\2z\u0087\3\2"+
		"\2\2{|\f\b\2\2|}\t\2\2\2}~\5\f\7\t~\177\b\7\1\2\177\u0086\3\2\2\2\u0080"+
		"\u0081\f\7\2\2\u0081\u0082\t\3\2\2\u0082\u0083\5\f\7\b\u0083\u0084\b\7"+
		"\1\2\u0084\u0086\3\2\2\2\u0085{\3\2\2\2\u0085\u0080\3\2\2\2\u0086\u0089"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\r\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u008a\u008b\7\35\2\2\u008b\u008c\7\36\2\2\u008c\u008d\5"+
		"\30\r\2\u008d\u008e\b\b\1\2\u008e\u0097\3\2\2\2\u008f\u0090\7\35\2\2\u0090"+
		"\u0091\7\36\2\2\u0091\u0092\7\n\2\2\u0092\u0093\5\f\7\2\u0093\u0094\5"+
		"\30\r\2\u0094\u0095\b\b\1\2\u0095\u0097\3\2\2\2\u0096\u008a\3\2\2\2\u0096"+
		"\u008f\3\2\2\2\u0097\17\3\2\2\2\u0098\u009c\7\13\2\2\u0099\u009b\7\37"+
		"\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u00a4\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\5\22"+
		"\n\2\u00a0\u00a1\b\t\1\2\u00a1\u00a3\3\2\2\2\u00a2\u009f\3\2\2\2\u00a3"+
		"\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00ab\7\f\2\2\u00a8\u00aa\7\37\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\21\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\r\2\2\u00af\u00b0"+
		"\7\3\2\2\u00b0\u00b1\5\f\7\2\u00b1\u00b2\7\4\2\2\u00b2\u00b3\5\30\r\2"+
		"\u00b3\u00b4\b\n\1\2\u00b4\u00e0\3\2\2\2\u00b5\u00b6\7\16\2\2\u00b6\u00b7"+
		"\7\3\2\2\u00b7\u00b8\5\26\f\2\u00b8\u00b9\7\4\2\2\u00b9\u00ba\5\22\n\2"+
		"\u00ba\u00bb\b\n\1\2\u00bb\u00e0\3\2\2\2\u00bc\u00bd\7\17\2\2\u00bd\u00be"+
		"\7\3\2\2\u00be\u00bf\5\24\13\2\u00bf\u00c0\7\20\2\2\u00c0\u00c1\5\26\f"+
		"\2\u00c1\u00c2\7\20\2\2\u00c2\u00c3\5\24\13\2\u00c3\u00c4\7\4\2\2\u00c4"+
		"\u00c5\5\22\n\2\u00c5\u00c6\b\n\1\2\u00c6\u00e0\3\2\2\2\u00c7\u00c8\7"+
		"\21\2\2\u00c8\u00c9\5\22\n\2\u00c9\u00ca\7\22\2\2\u00ca\u00cb\7\3\2\2"+
		"\u00cb\u00cc\5\26\f\2\u00cc\u00cd\7\4\2\2\u00cd\u00ce\b\n\1\2\u00ce\u00e0"+
		"\3\2\2\2\u00cf\u00d0\7\34\2\2\u00d0\u00d1\5\f\7\2\u00d1\u00d2\5\30\r\2"+
		"\u00d2\u00d3\b\n\1\2\u00d3\u00e0\3\2\2\2\u00d4\u00d5\5\f\7\2\u00d5\u00d6"+
		"\5\30\r\2\u00d6\u00d7\b\n\1\2\u00d7\u00e0\3\2\2\2\u00d8\u00d9\5\24\13"+
		"\2\u00d9\u00da\5\30\r\2\u00da\u00db\b\n\1\2\u00db\u00e0\3\2\2\2\u00dc"+
		"\u00dd\5\30\r\2\u00dd\u00de\b\n\1\2\u00de\u00e0\3\2\2\2\u00df\u00ae\3"+
		"\2\2\2\u00df\u00b5\3\2\2\2\u00df\u00bc\3\2\2\2\u00df\u00c7\3\2\2\2\u00df"+
		"\u00cf\3\2\2\2\u00df\u00d4\3\2\2\2\u00df\u00d8\3\2\2\2\u00df\u00dc\3\2"+
		"\2\2\u00e0\23\3\2\2\2\u00e1\u00e2\7\36\2\2\u00e2\u00e3\7\n\2\2\u00e3\u00e4"+
		"\5\f\7\2\u00e4\u00e5\b\13\1\2\u00e5\u00eb\3\2\2\2\u00e6\u00e7\7\23\2\2"+
		"\u00e7\u00e8\7\36\2\2\u00e8\u00e9\7\4\2\2\u00e9\u00eb\b\13\1\2\u00ea\u00e1"+
		"\3\2\2\2\u00ea\u00e6\3\2\2\2\u00eb\25\3\2\2\2\u00ec\u00ed\7\24\2\2\u00ed"+
		"\u00f6\b\f\1\2\u00ee\u00ef\7\25\2\2\u00ef\u00f6\b\f\1\2\u00f0\u00f1\5"+
		"\f\7\2\u00f1\u00f2\t\4\2\2\u00f2\u00f3\5\f\7\2\u00f3\u00f4\b\f\1\2\u00f4"+
		"\u00f6\3\2\2\2\u00f5\u00ec\3\2\2\2\u00f5\u00ee\3\2\2\2\u00f5\u00f0\3\2"+
		"\2\2\u00f6\27\3\2\2\2\u00f7\u00f9\t\5\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\31\3\2\2\2\26\""+
		")\61\67@IYdgy\u0085\u0087\u0096\u009c\u00a4\u00ab\u00df\u00ea\u00f5\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}