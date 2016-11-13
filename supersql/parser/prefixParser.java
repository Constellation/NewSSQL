// Generated from prefix.g4 by ANTLR 4.5

package supersql.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class prefixParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, DEF=4, K_FOREACH=5, K_FOREACH1=6, K_IMPORT=7, 
		K_DEFINE=8, OPEN_PARENTHESE=9, CLOSE_PARENTHESE=10, OPEN_BRACKET=11, CLOSE_BRACKET=12, 
		OPEN_BRACE=13, CLOSE_BRACE=14, IDENTIFIER=15, STRING_LITERAL=16, MULTI_LINE_COMMENT=17, 
		SINGLE_LINE_COMMENT=18, WS=19, UNEXPECTED_CHAR=20;
	public static final int
		RULE_prefix = 0, RULE_operand = 1, RULE_exdef = 2, RULE_function = 3, 
		RULE_expr = 4, RULE_function_name = 5, RULE_database_name = 6, RULE_table_name = 7, 
		RULE_column_alias = 8, RULE_column_name = 9, RULE_table_alias = 10, RULE_index_name = 11, 
		RULE_any_name = 12;
	public static final String[] ruleNames = {
		"prefix", "operand", "exdef", "function", "expr", "function_name", "database_name", 
		"table_name", "column_alias", "column_name", "table_alias", "index_name", 
		"any_name"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'.'", "'#'", null, null, null, null, null, "'('", "')'", 
		"'['", "']'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "DEF", "K_FOREACH", "K_FOREACH1", "K_IMPORT", 
		"K_DEFINE", "OPEN_PARENTHESE", "CLOSE_PARENTHESE", "OPEN_BRACKET", "CLOSE_BRACKET", 
		"OPEN_BRACE", "CLOSE_BRACE", "IDENTIFIER", "STRING_LITERAL", "MULTI_LINE_COMMENT", 
		"SINGLE_LINE_COMMENT", "WS", "UNEXPECTED_CHAR"
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
	public String getGrammarFileName() { return "prefix.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public prefixParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PrefixContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ExdefContext exdef() {
			return getRuleContext(ExdefContext.class,0);
		}
		public TerminalNode K_FOREACH() { return getToken(prefixParser.K_FOREACH, 0); }
		public TerminalNode K_FOREACH1() { return getToken(prefixParser.K_FOREACH1, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode OPEN_PARENTHESE() { return getToken(prefixParser.OPEN_PARENTHESE, 0); }
		public TerminalNode CLOSE_PARENTHESE() { return getToken(prefixParser.CLOSE_PARENTHESE, 0); }
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitPrefix(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			switch (_input.LA(1)) {
			case K_FOREACH:
			case K_FOREACH1:
				{
				setState(26);
				_la = _input.LA(1);
				if ( !(_la==K_FOREACH || _la==K_FOREACH1) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(46);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(27);
					operand();
					setState(32);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(28);
						match(T__0);
						setState(29);
						operand();
						}
						}
						setState(34);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(35);
					match(OPEN_PARENTHESE);
					setState(36);
					operand();
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(37);
						match(T__0);
						setState(38);
						operand();
						}
						}
						setState(43);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(44);
					match(CLOSE_PARENTHESE);
					}
					break;
				}
				}
				break;
			case OPEN_PARENTHESE:
			case IDENTIFIER:
			case STRING_LITERAL:
				{
				setState(48);
				function();
				}
				break;
			case T__2:
				{
				setState(49);
				exdef();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class OperandContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(52);
				table_alias();
				setState(53);
				match(T__1);
				}
				break;
			}
			setState(57);
			column_name();
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

	public static class ExdefContext extends ParserRuleContext {
		public TerminalNode K_IMPORT() { return getToken(prefixParser.K_IMPORT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(prefixParser.IDENTIFIER, 0); }
		public TerminalNode K_DEFINE() { return getToken(prefixParser.K_DEFINE, 0); }
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode OPEN_BRACE() { return getToken(prefixParser.OPEN_BRACE, 0); }
		public TerminalNode DEF() { return getToken(prefixParser.DEF, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(prefixParser.CLOSE_BRACE, 0); }
		public ExdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterExdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitExdef(this);
		}
	}

	public final ExdefContext exdef() throws RecognitionException {
		ExdefContext _localctx = new ExdefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exdef);
		try {
			setState(70);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(T__2);
				setState(60);
				match(K_IMPORT);
				setState(61);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(T__2);
				setState(63);
				match(K_DEFINE);
				setState(64);
				function_name();
				setState(65);
				any_name();
				setState(66);
				match(OPEN_BRACE);
				setState(67);
				match(DEF);
				setState(68);
				match(CLOSE_BRACE);
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

	public static class FunctionContext extends ParserRuleContext {
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESE() { return getToken(prefixParser.OPEN_PARENTHESE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESE() { return getToken(prefixParser.CLOSE_PARENTHESE, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			function_name();
			setState(73);
			match(OPEN_PARENTHESE);
			setState(74);
			expr();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(75);
				match(T__0);
				setState(76);
				expr();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(CLOSE_PARENTHESE);
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

	public static class ExprContext extends ParserRuleContext {
		public List<TerminalNode> STRING_LITERAL() { return getTokens(prefixParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(prefixParser.STRING_LITERAL, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Table_aliasContext> table_alias() {
			return getRuleContexts(Table_aliasContext.class);
		}
		public Table_aliasContext table_alias(int i) {
			return getRuleContext(Table_aliasContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		try {
			int _alt;
			setState(105);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(STRING_LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(88);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(85);
					table_alias();
					setState(86);
					match(T__1);
					}
					break;
				}
				setState(90);
				column_name();
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(100);
						switch (_input.LA(1)) {
						case T__0:
							{
							setState(92);
							match(T__0);
							setState(93);
							match(STRING_LITERAL);
							}
							break;
						case OPEN_PARENTHESE:
						case IDENTIFIER:
						case STRING_LITERAL:
							{
							{
							setState(97);
							switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
							case 1:
								{
								setState(94);
								table_alias();
								setState(95);
								match(T__1);
								}
								break;
							}
							setState(99);
							column_name();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(104);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
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

	public static class Function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			any_name();
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

	public static class Database_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Database_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterDatabase_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitDatabase_name(this);
		}
	}

	public final Database_nameContext database_name() throws RecognitionException {
		Database_nameContext _localctx = new Database_nameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			any_name();
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

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitTable_name(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			any_name();
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

	public static class Column_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(prefixParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(prefixParser.STRING_LITERAL, 0); }
		public Column_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterColumn_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitColumn_alias(this);
		}
	}

	public final Column_aliasContext column_alias() throws RecognitionException {
		Column_aliasContext _localctx = new Column_aliasContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitColumn_name(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			any_name();
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

	public static class Table_aliasContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterTable_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitTable_alias(this);
		}
	}

	public final Table_aliasContext table_alias() throws RecognitionException {
		Table_aliasContext _localctx = new Table_aliasContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			any_name();
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

	public static class Index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterIndex_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitIndex_name(this);
		}
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			any_name();
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

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(prefixParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(prefixParser.STRING_LITERAL, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitAny_name(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_any_name);
		try {
			setState(127);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(IDENTIFIER);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(STRING_LITERAL);
				}
				break;
			case OPEN_PARENTHESE:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				match(OPEN_PARENTHESE);
				setState(124);
				any_name();
				setState(125);
				match(CLOSE_PARENTHESE);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\u0084\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13"+
		"\2\3\2\3\2\3\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\5\2\61\n\2\3\2\3\2"+
		"\5\2\65\n\2\3\3\3\3\3\3\5\3:\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\5\6[\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6d\n\6\3"+
		"\6\7\6g\n\6\f\6\16\6j\13\6\5\6l\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0082\n\16"+
		"\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\3\2\7\b\3\2\21\22\u0085"+
		"\2\64\3\2\2\2\49\3\2\2\2\6H\3\2\2\2\bJ\3\2\2\2\nk\3\2\2\2\fm\3\2\2\2\16"+
		"o\3\2\2\2\20q\3\2\2\2\22s\3\2\2\2\24u\3\2\2\2\26w\3\2\2\2\30y\3\2\2\2"+
		"\32\u0081\3\2\2\2\34\60\t\2\2\2\35\"\5\4\3\2\36\37\7\3\2\2\37!\5\4\3\2"+
		" \36\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\61\3\2\2\2$\"\3\2\2\2%&"+
		"\7\13\2\2&+\5\4\3\2\'(\7\3\2\2(*\5\4\3\2)\'\3\2\2\2*-\3\2\2\2+)\3\2\2"+
		"\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\f\2\2/\61\3\2\2\2\60\35\3\2\2\2\60"+
		"%\3\2\2\2\61\65\3\2\2\2\62\65\5\b\5\2\63\65\5\6\4\2\64\34\3\2\2\2\64\62"+
		"\3\2\2\2\64\63\3\2\2\2\65\3\3\2\2\2\66\67\5\26\f\2\678\7\4\2\28:\3\2\2"+
		"\29\66\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\5\24\13\2<\5\3\2\2\2=>\7\5\2\2>?"+
		"\7\t\2\2?I\7\21\2\2@A\7\5\2\2AB\7\n\2\2BC\5\f\7\2CD\5\32\16\2DE\7\17\2"+
		"\2EF\7\6\2\2FG\7\20\2\2GI\3\2\2\2H=\3\2\2\2H@\3\2\2\2I\7\3\2\2\2JK\5\f"+
		"\7\2KL\7\13\2\2LQ\5\n\6\2MN\7\3\2\2NP\5\n\6\2OM\3\2\2\2PS\3\2\2\2QO\3"+
		"\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7\f\2\2U\t\3\2\2\2Vl\7\22\2\2W"+
		"X\5\26\f\2XY\7\4\2\2Y[\3\2\2\2ZW\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\5\24"+
		"\13\2]h\3\2\2\2^_\7\3\2\2_g\7\22\2\2`a\5\26\f\2ab\7\4\2\2bd\3\2\2\2c`"+
		"\3\2\2\2cd\3\2\2\2de\3\2\2\2eg\5\24\13\2f^\3\2\2\2fc\3\2\2\2gj\3\2\2\2"+
		"hf\3\2\2\2hi\3\2\2\2il\3\2\2\2jh\3\2\2\2kV\3\2\2\2kZ\3\2\2\2l\13\3\2\2"+
		"\2mn\5\32\16\2n\r\3\2\2\2op\5\32\16\2p\17\3\2\2\2qr\5\32\16\2r\21\3\2"+
		"\2\2st\t\3\2\2t\23\3\2\2\2uv\5\32\16\2v\25\3\2\2\2wx\5\32\16\2x\27\3\2"+
		"\2\2yz\5\32\16\2z\31\3\2\2\2{\u0082\7\21\2\2|\u0082\7\22\2\2}~\7\13\2"+
		"\2~\177\5\32\16\2\177\u0080\7\f\2\2\u0080\u0082\3\2\2\2\u0081{\3\2\2\2"+
		"\u0081|\3\2\2\2\u0081}\3\2\2\2\u0082\33\3\2\2\2\17\"+\60\649HQZcfhk\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}