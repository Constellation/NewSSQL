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
		RULE_prefix = 0, RULE_test = 1, RULE_operand = 2, RULE_exdef = 3, RULE_foreach = 4, 
		RULE_function = 5, RULE_expr = 6, RULE_function_name = 7, RULE_database_name = 8, 
		RULE_table_name = 9, RULE_column_alias = 10, RULE_column_name = 11, RULE_table_alias = 12, 
		RULE_index_name = 13, RULE_any_name = 14;
	public static final String[] ruleNames = {
		"prefix", "test", "operand", "exdef", "foreach", "function", "expr", "function_name", 
		"database_name", "table_name", "column_alias", "column_name", "table_alias", 
		"index_name", "any_name"
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
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
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
			setState(30);
			test();
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(31);
				match(T__0);
				setState(32);
				test();
				}
				}
				setState(37);
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

	public static class TestContext extends ParserRuleContext {
		public ForeachContext foreach() {
			return getRuleContext(ForeachContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitTest(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_test);
		try {
			setState(41);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				foreach();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				function();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				expr();
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
		enterRule(_localctx, 4, RULE_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(43);
				table_alias();
				setState(44);
				match(T__1);
				}
				break;
			}
			setState(48);
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
		enterRule(_localctx, 6, RULE_exdef);
		try {
			setState(61);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__2);
				setState(51);
				match(K_IMPORT);
				setState(52);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(T__2);
				setState(54);
				match(K_DEFINE);
				setState(55);
				function_name();
				setState(56);
				any_name();
				setState(57);
				match(OPEN_BRACE);
				setState(58);
				match(DEF);
				setState(59);
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

	public static class ForeachContext extends ParserRuleContext {
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
		public ForeachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).enterForeach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof prefixListener ) ((prefixListener)listener).exitForeach(this);
		}
	}

	public final ForeachContext foreach() throws RecognitionException {
		ForeachContext _localctx = new ForeachContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_foreach);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(63);
			_la = _input.LA(1);
			if ( !(_la==K_FOREACH || _la==K_FOREACH1) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(83);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(64);
				operand();
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(65);
						match(T__0);
						setState(66);
						operand();
						}
						} 
					}
					setState(71);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(72);
				match(OPEN_PARENTHESE);
				setState(73);
				operand();
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(74);
					match(T__0);
					setState(75);
					operand();
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(81);
				match(CLOSE_PARENTHESE);
				}
				break;
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
		enterRule(_localctx, 10, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			function_name();
			setState(86);
			match(OPEN_PARENTHESE);
			setState(87);
			expr();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(88);
				match(T__0);
				setState(89);
				expr();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95);
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
		enterRule(_localctx, 12, RULE_expr);
		try {
			int _alt;
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(STRING_LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(101);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(98);
					table_alias();
					setState(99);
					match(T__1);
					}
					break;
				}
				setState(103);
				column_name();
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(113);
						switch (_input.LA(1)) {
						case T__0:
							{
							setState(105);
							match(T__0);
							setState(106);
							match(STRING_LITERAL);
							}
							break;
						case OPEN_PARENTHESE:
						case IDENTIFIER:
						case STRING_LITERAL:
							{
							{
							setState(110);
							switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
							case 1:
								{
								setState(107);
								table_alias();
								setState(108);
								match(T__1);
								}
								break;
							}
							setState(112);
							column_name();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(117);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 14, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
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
		enterRule(_localctx, 16, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
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
		enterRule(_localctx, 18, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
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
		enterRule(_localctx, 20, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
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
		enterRule(_localctx, 22, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
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
		enterRule(_localctx, 24, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
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
		enterRule(_localctx, 26, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
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
		enterRule(_localctx, 28, RULE_any_name);
		try {
			setState(140);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(IDENTIFIER);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(STRING_LITERAL);
				}
				break;
			case OPEN_PARENTHESE:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(OPEN_PARENTHESE);
				setState(137);
				any_name();
				setState(138);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\u0091\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\5\4\61\n\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5@\n\5\3\6\3\6\3\6\3\6"+
		"\7\6F\n\6\f\6\16\6I\13\6\3\6\3\6\3\6\3\6\7\6O\n\6\f\6\16\6R\13\6\3\6\3"+
		"\6\5\6V\n\6\3\7\3\7\3\7\3\7\3\7\7\7]\n\7\f\7\16\7`\13\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\5\bh\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bq\n\b\3\b\7\bt\n\b"+
		"\f\b\16\bw\13\b\5\by\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u008f\n\20\3\20\2\2"+
		"\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\4\3\2\7\b\3\2\21\22\u0091"+
		"\2 \3\2\2\2\4+\3\2\2\2\6\60\3\2\2\2\b?\3\2\2\2\nA\3\2\2\2\fW\3\2\2\2\16"+
		"x\3\2\2\2\20z\3\2\2\2\22|\3\2\2\2\24~\3\2\2\2\26\u0080\3\2\2\2\30\u0082"+
		"\3\2\2\2\32\u0084\3\2\2\2\34\u0086\3\2\2\2\36\u008e\3\2\2\2 %\5\4\3\2"+
		"!\"\7\3\2\2\"$\5\4\3\2#!\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\3\3\2"+
		"\2\2\'%\3\2\2\2(,\5\n\6\2),\5\f\7\2*,\5\16\b\2+(\3\2\2\2+)\3\2\2\2+*\3"+
		"\2\2\2,\5\3\2\2\2-.\5\32\16\2./\7\4\2\2/\61\3\2\2\2\60-\3\2\2\2\60\61"+
		"\3\2\2\2\61\62\3\2\2\2\62\63\5\30\r\2\63\7\3\2\2\2\64\65\7\5\2\2\65\66"+
		"\7\t\2\2\66@\7\21\2\2\678\7\5\2\289\7\n\2\29:\5\20\t\2:;\5\36\20\2;<\7"+
		"\17\2\2<=\7\6\2\2=>\7\20\2\2>@\3\2\2\2?\64\3\2\2\2?\67\3\2\2\2@\t\3\2"+
		"\2\2AU\t\2\2\2BG\5\6\4\2CD\7\3\2\2DF\5\6\4\2EC\3\2\2\2FI\3\2\2\2GE\3\2"+
		"\2\2GH\3\2\2\2HV\3\2\2\2IG\3\2\2\2JK\7\13\2\2KP\5\6\4\2LM\7\3\2\2MO\5"+
		"\6\4\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\7"+
		"\f\2\2TV\3\2\2\2UB\3\2\2\2UJ\3\2\2\2V\13\3\2\2\2WX\5\20\t\2XY\7\13\2\2"+
		"Y^\5\16\b\2Z[\7\3\2\2[]\5\16\b\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2"+
		"\2\2_a\3\2\2\2`^\3\2\2\2ab\7\f\2\2b\r\3\2\2\2cy\7\22\2\2de\5\32\16\2e"+
		"f\7\4\2\2fh\3\2\2\2gd\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\5\30\r\2ju\3\2\2\2"+
		"kl\7\3\2\2lt\7\22\2\2mn\5\32\16\2no\7\4\2\2oq\3\2\2\2pm\3\2\2\2pq\3\2"+
		"\2\2qr\3\2\2\2rt\5\30\r\2sk\3\2\2\2sp\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3"+
		"\2\2\2vy\3\2\2\2wu\3\2\2\2xc\3\2\2\2xg\3\2\2\2y\17\3\2\2\2z{\5\36\20\2"+
		"{\21\3\2\2\2|}\5\36\20\2}\23\3\2\2\2~\177\5\36\20\2\177\25\3\2\2\2\u0080"+
		"\u0081\t\3\2\2\u0081\27\3\2\2\2\u0082\u0083\5\36\20\2\u0083\31\3\2\2\2"+
		"\u0084\u0085\5\36\20\2\u0085\33\3\2\2\2\u0086\u0087\5\36\20\2\u0087\35"+
		"\3\2\2\2\u0088\u008f\7\21\2\2\u0089\u008f\7\22\2\2\u008a\u008b\7\13\2"+
		"\2\u008b\u008c\5\36\20\2\u008c\u008d\7\f\2\2\u008d\u008f\3\2\2\2\u008e"+
		"\u0088\3\2\2\2\u008e\u0089\3\2\2\2\u008e\u008a\3\2\2\2\u008f\37\3\2\2"+
		"\2\20%+\60?GPU^gpsux\u008e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}