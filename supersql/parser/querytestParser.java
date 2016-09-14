// Generated from querytest.g4 by ANTLR 4.5

package supersql.parser;

import java.util.*;
import java.io.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class querytestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, K_ABORT=21, K_ADD=22, K_ALL=23, K_AND=24, 
		K_AS=25, K_ASC=26, K_BETWEEN=27, K_BY=28, K_CASE=29, K_CAST=30, K_COLLATE=31, 
		K_CROSS=32, K_CURRENT_DATE=33, K_CURRENT_TIME=34, K_CURRENT_TIMESTAMP=35, 
		K_DESC=36, K_DISTINCT=37, K_ELSE=38, K_END=39, K_ESCAPE=40, K_EXCEPT=41, 
		K_EXISTS=42, K_FAIL=43, K_FULL=44, K_FROM=45, K_GLOB=46, K_GROUP=47, K_HAVING=48, 
		K_IF=49, K_IGNORE=50, K_IN=51, K_INDEXED=52, K_INNER=53, K_INTERSECT=54, 
		K_IS=55, K_ISNULL=56, K_JOIN=57, K_LEFT=58, K_LIKE=59, K_LIMIT=60, K_MATCH=61, 
		K_NATURAL=62, K_NO=63, K_NOT=64, K_NOTNULL=65, K_NULL=66, K_OFFSET=67, 
		K_ON=68, K_OR=69, K_ORDER=70, K_OUTER=71, K_RAISE=72, K_RECURSIVE=73, 
		K_REGEXP=74, K_RIGHT=75, K_ROLLBACK=76, K_SELECT=77, K_THEN=78, K_UNION=79, 
		K_USING=80, K_VALUES=81, K_WHEN=82, K_WHERE=83, K_WITH=84, K_GENERATE=85, 
		K_MAX=86, K_MIN=87, K_AVG=88, K_COUNT=89, K_SUM=90, C0=91, C1=92, C2=93, 
		C3=94, DOT=95, OPEN_PARENTHESE=96, CLOSE_PARENTHESE=97, OPEN_BRACKET=98, 
		CLOSE_BRACKET=99, OPEN_BRACE=100, CLOSE_BRACE=101, SEMICOLON=102, DECOLATOR=103, 
		NUMERIC_LITERAL=104, BLOB_LITERAL=105, BIND_PARAMETER=106, IDENTIFIER=107, 
		STRING_LITERAL=108, MULTI_LINE_COMMENT=109, SINGLE_LINE_COMMENT=110, WS=111, 
		UNEXPECTED_CHAR=112;
	public static final int
		RULE_query = 0, RULE_root = 1, RULE_media = 2, RULE_operand = 3, RULE_grouper = 4, 
		RULE_composite_iterator = 5, RULE_exp = 6, RULE_d_exp = 7, RULE_v_exp = 8, 
		RULE_h_exp = 9, RULE_n_exp = 10, RULE_sorting = 11, RULE_function = 12, 
		RULE_sqlfunc = 13, RULE_aggregate = 14, RULE_if_then_else = 15, RULE_from_where = 16, 
		RULE_error = 17, RULE_sql_stmt_list = 18, RULE_sql_stmt = 19, RULE_factored_select_stmt = 20, 
		RULE_select_core = 21, RULE_where = 22, RULE_result_column = 23, RULE_table_or_subquery = 24, 
		RULE_keyword = 25, RULE_select_stmt = 26, RULE_select_or_values = 27, 
		RULE_compound_operator = 28, RULE_join_clause = 29, RULE_join_operator = 30, 
		RULE_join_constraint = 31, RULE_common_table_expression = 32, RULE_ordering_term = 33, 
		RULE_expr = 34, RULE_literal_value = 35, RULE_unary_operator = 36, RULE_name = 37, 
		RULE_type_name = 38, RULE_function_name = 39, RULE_ag_function_name = 40, 
		RULE_ag_keyword = 41, RULE_collation_name = 42, RULE_database_name = 43, 
		RULE_table_name = 44, RULE_column_alias = 45, RULE_column_name = 46, RULE_table_alias = 47, 
		RULE_index_name = 48, RULE_any_name = 49, RULE_sl = 50, RULE_signed_number = 51, 
		RULE_raise_function = 52, RULE_error_message = 53;
	public static final String[] ruleNames = {
		"query", "root", "media", "operand", "grouper", "composite_iterator", 
		"exp", "d_exp", "v_exp", "h_exp", "n_exp", "sorting", "function", "sqlfunc", 
		"aggregate", "if_then_else", "from_where", "error", "sql_stmt_list", "sql_stmt", 
		"factored_select_stmt", "select_core", "where", "result_column", "table_or_subquery", 
		"keyword", "select_stmt", "select_or_values", "compound_operator", "join_clause", 
		"join_operator", "join_constraint", "common_table_expression", "ordering_term", 
		"expr", "literal_value", "unary_operator", "name", "type_name", "function_name", 
		"ag_function_name", "ag_keyword", "collation_name", "database_name", "table_name", 
		"column_alias", "column_name", "table_alias", "index_name", "any_name", 
		"sl", "signed_number", "raise_function", "error_message"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'||'", "'$'", "'&'", "':'", "'*'", "'/'", "'+'", "'-'", "'<<'", 
		"'>>'", "'|'", "'<'", "'<='", "'>'", "'>='", "'='", "'=='", "'!='", "'<>'", 
		"'~'", null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "'?'", 
		"','", "'!'", "'%'", "'.'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "K_ABORT", "K_ADD", 
		"K_ALL", "K_AND", "K_AS", "K_ASC", "K_BETWEEN", "K_BY", "K_CASE", "K_CAST", 
		"K_COLLATE", "K_CROSS", "K_CURRENT_DATE", "K_CURRENT_TIME", "K_CURRENT_TIMESTAMP", 
		"K_DESC", "K_DISTINCT", "K_ELSE", "K_END", "K_ESCAPE", "K_EXCEPT", "K_EXISTS", 
		"K_FAIL", "K_FULL", "K_FROM", "K_GLOB", "K_GROUP", "K_HAVING", "K_IF", 
		"K_IGNORE", "K_IN", "K_INDEXED", "K_INNER", "K_INTERSECT", "K_IS", "K_ISNULL", 
		"K_JOIN", "K_LEFT", "K_LIKE", "K_LIMIT", "K_MATCH", "K_NATURAL", "K_NO", 
		"K_NOT", "K_NOTNULL", "K_NULL", "K_OFFSET", "K_ON", "K_OR", "K_ORDER", 
		"K_OUTER", "K_RAISE", "K_RECURSIVE", "K_REGEXP", "K_RIGHT", "K_ROLLBACK", 
		"K_SELECT", "K_THEN", "K_UNION", "K_USING", "K_VALUES", "K_WHEN", "K_WHERE", 
		"K_WITH", "K_GENERATE", "K_MAX", "K_MIN", "K_AVG", "K_COUNT", "K_SUM", 
		"C0", "C1", "C2", "C3", "DOT", "OPEN_PARENTHESE", "CLOSE_PARENTHESE", 
		"OPEN_BRACKET", "CLOSE_BRACKET", "OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", 
		"DECOLATOR", "NUMERIC_LITERAL", "BLOB_LITERAL", "BIND_PARAMETER", "IDENTIFIER", 
		"STRING_LITERAL", "MULTI_LINE_COMMENT", "SINGLE_LINE_COMMENT", "WS", "UNEXPECTED_CHAR"
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
	public String getGrammarFileName() { return "querytest.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public int level = 0;
	int i = 0;
	public String media = "";
	List<String> ForeachAtt = new ArrayList<String>();
	boolean ascflag = false;
	boolean descflag = false;


	public querytestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public MediaContext media() {
			return getRuleContext(MediaContext.class,0);
		}
		public RootContext root() {
			return getRuleContext(RootContext.class,0);
		}
		public From_whereContext from_where() {
			return getRuleContext(From_whereContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			media();
			setState(109);
			root();
			setState(111);
			_la = _input.LA(1);
			if (_la==K_FROM || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (K_SELECT - 77)) | (1L << (K_VALUES - 77)) | (1L << (K_WITH - 77)) | (1L << (UNEXPECTED_CHAR - 77)))) != 0)) {
				{
				setState(110);
				from_where();
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

	public static class RootContext extends ParserRuleContext {
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode DECOLATOR() { return getToken(querytestParser.DECOLATOR, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(113);
				operand();
				}
				break;
			case 2:
				{
				setState(114);
				exp();
				}
				break;
			}
			setState(118);
			_la = _input.LA(1);
			if (_la==DECOLATOR) {
				{
				setState(117);
				match(DECOLATOR);
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

	public static class MediaContext extends ParserRuleContext {
		public TerminalNode K_GENERATE() { return getToken(querytestParser.K_GENERATE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(querytestParser.IDENTIFIER, 0); }
		public MediaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_media; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterMedia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitMedia(this);
		}
	}

	public final MediaContext media() throws RecognitionException {
		MediaContext _localctx = new MediaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_media);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(K_GENERATE);
			setState(121);
			match(IDENTIFIER);
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
		public TerminalNode DECOLATOR() { return getToken(querytestParser.DECOLATOR, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public SqlfuncContext sqlfunc() {
			return getRuleContext(SqlfuncContext.class,0);
		}
		public TerminalNode OPEN_BRACE() { return getToken(querytestParser.OPEN_BRACE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(querytestParser.CLOSE_BRACE, 0); }
		public GrouperContext grouper() {
			return getRuleContext(GrouperContext.class,0);
		}
		public Composite_iteratorContext composite_iterator() {
			return getRuleContext(Composite_iteratorContext.class,0);
		}
		public If_then_elseContext if_then_else() {
			return getRuleContext(If_then_elseContext.class,0);
		}
		public SlContext sl() {
			return getRuleContext(SlContext.class,0);
		}
		public TerminalNode NUMERIC_LITERAL() { return getToken(querytestParser.NUMERIC_LITERAL, 0); }
		public AggregateContext aggregate() {
			return getRuleContext(AggregateContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public SortingContext sorting() {
			return getRuleContext(SortingContext.class,0);
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
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_operand);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(123);
				function();
				}
				break;
			case 2:
				{
				setState(124);
				sqlfunc();
				}
				break;
			case 3:
				{
				setState(125);
				match(OPEN_BRACE);
				setState(126);
				exp();
				setState(127);
				match(CLOSE_BRACE);
				}
				break;
			case 4:
				{
				setState(130);
				_la = _input.LA(1);
				if (_la==OPEN_PARENTHESE) {
					{
					setState(129);
					sorting();
					}
				}

				{
				setState(135);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(132);
					table_alias();
					setState(133);
					match(DOT);
					}
					break;
				}
				setState(137);
				column_name();
				}
				}
				break;
			case 5:
				{
				setState(138);
				grouper();
				}
				break;
			case 6:
				{
				setState(139);
				composite_iterator();
				}
				break;
			case 7:
				{
				setState(140);
				if_then_else();
				}
				break;
			case 8:
				{
				setState(141);
				sl();
				}
				break;
			case 9:
				{
				setState(142);
				match(NUMERIC_LITERAL);
				}
				break;
			case 10:
				{
				setState(143);
				aggregate();
				}
				break;
			}
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(146);
					match(T__0);
					setState(147);
					operand();
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(153);
				match(DECOLATOR);
				}
				break;
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

	public static class GrouperContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(querytestParser.OPEN_BRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(querytestParser.CLOSE_BRACKET, 0); }
		public TerminalNode C1() { return getToken(querytestParser.C1, 0); }
		public TerminalNode C2() { return getToken(querytestParser.C2, 0); }
		public TerminalNode C3() { return getToken(querytestParser.C3, 0); }
		public GrouperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterGrouper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitGrouper(this);
		}
	}

	public final GrouperContext grouper() throws RecognitionException {
		GrouperContext _localctx = new GrouperContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_grouper);
		try {
			setState(171);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(OPEN_BRACKET);
				setState(157);
				exp();
				setState(158);
				match(CLOSE_BRACKET);
				setState(159);
				match(C1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(OPEN_BRACKET);
				setState(162);
				exp();
				setState(163);
				match(CLOSE_BRACKET);
				setState(164);
				match(C2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				match(OPEN_BRACKET);
				setState(167);
				exp();
				setState(168);
				match(CLOSE_BRACKET);
				setState(169);
				match(C3);
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

	public static class Composite_iteratorContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(querytestParser.OPEN_BRACKET, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(querytestParser.CLOSE_BRACKET, 0); }
		public TerminalNode C1() { return getToken(querytestParser.C1, 0); }
		public List<TerminalNode> NUMERIC_LITERAL() { return getTokens(querytestParser.NUMERIC_LITERAL); }
		public TerminalNode NUMERIC_LITERAL(int i) {
			return getToken(querytestParser.NUMERIC_LITERAL, i);
		}
		public TerminalNode C2() { return getToken(querytestParser.C2, 0); }
		public TerminalNode C3() { return getToken(querytestParser.C3, 0); }
		public Composite_iteratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composite_iterator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterComposite_iterator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitComposite_iterator(this);
		}
	}

	public final Composite_iteratorContext composite_iterator() throws RecognitionException {
		Composite_iteratorContext _localctx = new Composite_iteratorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_composite_iterator);
		try {
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(OPEN_BRACKET);
				setState(174);
				exp();
				setState(175);
				match(CLOSE_BRACKET);
				setState(176);
				match(C1);
				setState(185);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(177);
					match(NUMERIC_LITERAL);
					setState(178);
					match(C2);
					setState(181);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(179);
						match(NUMERIC_LITERAL);
						setState(180);
						match(C3);
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(183);
					match(NUMERIC_LITERAL);
					setState(184);
					match(C3);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(OPEN_BRACKET);
				setState(188);
				exp();
				setState(189);
				match(CLOSE_BRACKET);
				setState(190);
				match(C2);
				setState(199);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(191);
					match(NUMERIC_LITERAL);
					setState(192);
					match(C1);
					setState(195);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						setState(193);
						match(NUMERIC_LITERAL);
						setState(194);
						match(C3);
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(197);
					match(NUMERIC_LITERAL);
					setState(198);
					match(C3);
					}
					break;
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

	public static class ExpContext extends ParserRuleContext {
		public D_expContext d_exp() {
			return getRuleContext(D_expContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			d_exp();
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

	public static class D_expContext extends ParserRuleContext {
		public V_expContext v_exp() {
			return getRuleContext(V_expContext.class,0);
		}
		public TerminalNode C3() { return getToken(querytestParser.C3, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public D_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_d_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterD_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitD_exp(this);
		}
	}

	public final D_expContext d_exp() throws RecognitionException {
		D_expContext _localctx = new D_expContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_d_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			v_exp();
			setState(208);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(206);
				match(C3);
				setState(207);
				operand();
				}
				break;
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

	public static class V_expContext extends ParserRuleContext {
		public List<H_expContext> h_exp() {
			return getRuleContexts(H_expContext.class);
		}
		public H_expContext h_exp(int i) {
			return getRuleContext(H_expContext.class,i);
		}
		public List<TerminalNode> C2() { return getTokens(querytestParser.C2); }
		public TerminalNode C2(int i) {
			return getToken(querytestParser.C2, i);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public V_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_v_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterV_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitV_exp(this);
		}
	}

	public final V_expContext v_exp() throws RecognitionException {
		V_expContext _localctx = new V_expContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_v_exp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			h_exp();
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(211);
					match(C2);
					setState(214);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						setState(212);
						h_exp();
						}
						break;
					case 2:
						{
						setState(213);
						operand();
						}
						break;
					}
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class H_expContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<N_expContext> n_exp() {
			return getRuleContexts(N_expContext.class);
		}
		public N_expContext n_exp(int i) {
			return getRuleContext(N_expContext.class,i);
		}
		public List<TerminalNode> C1() { return getTokens(querytestParser.C1); }
		public TerminalNode C1(int i) {
			return getToken(querytestParser.C1, i);
		}
		public H_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_h_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterH_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitH_exp(this);
		}
	}

	public final H_expContext h_exp() throws RecognitionException {
		H_expContext _localctx = new H_expContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_h_exp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(221);
				operand();
				}
				break;
			case 2:
				{
				setState(222);
				n_exp();
				}
				break;
			}
			setState(232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(225);
					match(C1);
					setState(228);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(226);
						operand();
						}
						break;
					case 2:
						{
						setState(227);
						n_exp();
						}
						break;
					}
					}
					} 
				}
				setState(234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class N_expContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode C0() { return getToken(querytestParser.C0, 0); }
		public N_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterN_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitN_exp(this);
		}
	}

	public final N_expContext n_exp() throws RecognitionException {
		N_expContext _localctx = new N_expContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_n_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			operand();
			setState(236);
			match(C0);
			setState(237);
			operand();
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

	public static class SortingContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENTHESE() { return getToken(querytestParser.OPEN_PARENTHESE, 0); }
		public TerminalNode K_ASC() { return getToken(querytestParser.K_ASC, 0); }
		public TerminalNode CLOSE_PARENTHESE() { return getToken(querytestParser.CLOSE_PARENTHESE, 0); }
		public TerminalNode K_DESC() { return getToken(querytestParser.K_DESC, 0); }
		public SortingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sorting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterSorting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitSorting(this);
		}
	}

	public final SortingContext sorting() throws RecognitionException {
		SortingContext _localctx = new SortingContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sorting);
		try {
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				match(OPEN_PARENTHESE);
				setState(240);
				match(K_ASC);
				setState(241);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(OPEN_PARENTHESE);
				setState(243);
				match(K_DESC);
				setState(244);
				match(CLOSE_PARENTHESE);
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
		public TerminalNode OPEN_PARENTHESE() { return getToken(querytestParser.OPEN_PARENTHESE, 0); }
		public TerminalNode CLOSE_PARENTHESE() { return getToken(querytestParser.CLOSE_PARENTHESE, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(248);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(247);
				match(T__1);
				}
			}

			setState(250);
			function_name();
			setState(251);
			match(OPEN_PARENTHESE);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__19) | (1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL) | (1L << K_NO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)) | (1L << (OPEN_PARENTHESE - 64)) | (1L << (OPEN_BRACKET - 64)) | (1L << (OPEN_BRACE - 64)) | (1L << (NUMERIC_LITERAL - 64)) | (1L << (BIND_PARAMETER - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (STRING_LITERAL - 64)))) != 0)) {
				{
				{
				setState(255);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(252);
					operand();
					}
					break;
				case 2:
					{
					setState(253);
					exp();
					}
					break;
				case 3:
					{
					setState(254);
					expr(0);
					}
					break;
				}
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(257);
					match(C1);
					setState(261);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						setState(258);
						operand();
						}
						break;
					case 2:
						{
						setState(259);
						exp();
						}
						break;
					case 3:
						{
						setState(260);
						expr(0);
						}
						break;
					}
					}
					}
					setState(267);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
			match(CLOSE_PARENTHESE);
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

	public static class SqlfuncContext extends ParserRuleContext {
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESE() { return getToken(querytestParser.OPEN_PARENTHESE, 0); }
		public TerminalNode CLOSE_PARENTHESE() { return getToken(querytestParser.CLOSE_PARENTHESE, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SqlfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlfunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterSqlfunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitSqlfunc(this);
		}
	}

	public final SqlfuncContext sqlfunc() throws RecognitionException {
		SqlfuncContext _localctx = new SqlfuncContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sqlfunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(275);
			match(T__2);
			setState(276);
			function_name();
			setState(277);
			match(OPEN_PARENTHESE);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__19) | (1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL) | (1L << K_NO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)) | (1L << (OPEN_PARENTHESE - 64)) | (1L << (OPEN_BRACKET - 64)) | (1L << (OPEN_BRACE - 64)) | (1L << (NUMERIC_LITERAL - 64)) | (1L << (BIND_PARAMETER - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (STRING_LITERAL - 64)))) != 0)) {
				{
				{
				setState(281);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(278);
					operand();
					}
					break;
				case 2:
					{
					setState(279);
					exp();
					}
					break;
				case 3:
					{
					setState(280);
					expr(0);
					}
					break;
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(283);
					match(C1);
					setState(287);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						setState(284);
						operand();
						}
						break;
					case 2:
						{
						setState(285);
						exp();
						}
						break;
					case 3:
						{
						setState(286);
						expr(0);
						}
						break;
					}
					}
					}
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
			match(CLOSE_PARENTHESE);
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

	public static class AggregateContext extends ParserRuleContext {
		public Ag_function_nameContext ag_function_name() {
			return getRuleContext(Ag_function_nameContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(querytestParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(querytestParser.CLOSE_BRACKET, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public AggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterAggregate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitAggregate(this);
		}
	}

	public final AggregateContext aggregate() throws RecognitionException {
		AggregateContext _localctx = new AggregateContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_aggregate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			ag_function_name();
			setState(302);
			match(OPEN_BRACKET);
			{
			setState(306);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(303);
				table_alias();
				setState(304);
				match(DOT);
				}
				break;
			}
			setState(308);
			column_name();
			}
			setState(310);
			match(CLOSE_BRACKET);
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

	public static class If_then_elseContext extends ParserRuleContext {
		public TerminalNode K_IF() { return getToken(querytestParser.K_IF, 0); }
		public List<TerminalNode> OPEN_PARENTHESE() { return getTokens(querytestParser.OPEN_PARENTHESE); }
		public TerminalNode OPEN_PARENTHESE(int i) {
			return getToken(querytestParser.OPEN_PARENTHESE, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> CLOSE_PARENTHESE() { return getTokens(querytestParser.CLOSE_PARENTHESE); }
		public TerminalNode CLOSE_PARENTHESE(int i) {
			return getToken(querytestParser.CLOSE_PARENTHESE, i);
		}
		public TerminalNode K_THEN() { return getToken(querytestParser.K_THEN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode K_ELSE() { return getToken(querytestParser.K_ELSE, 0); }
		public If_then_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_then_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterIf_then_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitIf_then_else(this);
		}
	}

	public final If_then_elseContext if_then_else() throws RecognitionException {
		If_then_elseContext _localctx = new If_then_elseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_if_then_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			switch (_input.LA(1)) {
			case K_IF:
				{
				{
				setState(312);
				match(K_IF);
				setState(313);
				match(OPEN_PARENTHESE);
				setState(314);
				expr(0);
				setState(315);
				match(CLOSE_PARENTHESE);
				setState(316);
				match(K_THEN);
				setState(317);
				match(OPEN_PARENTHESE);
				setState(318);
				exp();
				setState(319);
				match(CLOSE_PARENTHESE);
				setState(320);
				match(K_ELSE);
				setState(321);
				match(OPEN_PARENTHESE);
				setState(322);
				exp();
				setState(323);
				match(CLOSE_PARENTHESE);
				}
				}
				break;
			case OPEN_PARENTHESE:
				{
				{
				setState(325);
				match(OPEN_PARENTHESE);
				setState(326);
				expr(0);
				setState(327);
				match(CLOSE_PARENTHESE);
				setState(328);
				match(C0);
				setState(329);
				exp();
				setState(330);
				match(T__3);
				setState(331);
				exp();
				}
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

	public static class From_whereContext extends ParserRuleContext {
		public Sql_stmt_listContext sql_stmt_list() {
			return getRuleContext(Sql_stmt_listContext.class,0);
		}
		public ErrorContext error() {
			return getRuleContext(ErrorContext.class,0);
		}
		public From_whereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterFrom_where(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitFrom_where(this);
		}
	}

	public final From_whereContext from_where() throws RecognitionException {
		From_whereContext _localctx = new From_whereContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_from_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			switch (_input.LA(1)) {
			case K_FROM:
			case K_SELECT:
			case K_VALUES:
			case K_WITH:
				{
				setState(335);
				sql_stmt_list();
				}
				break;
			case UNEXPECTED_CHAR:
				{
				setState(336);
				error();
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

	public static class ErrorContext extends ParserRuleContext {
		public Token UNEXPECTED_CHAR;
		public TerminalNode UNEXPECTED_CHAR() { return getToken(querytestParser.UNEXPECTED_CHAR, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitError(this);
		}
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			((ErrorContext)_localctx).UNEXPECTED_CHAR = match(UNEXPECTED_CHAR);
			 
			  
			  throw new RuntimeException("UNEXPECTED_CHAR=" + (((ErrorContext)_localctx).UNEXPECTED_CHAR!=null?((ErrorContext)_localctx).UNEXPECTED_CHAR.getText():null)); 
			  
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

	public static class Sql_stmt_listContext extends ParserRuleContext {
		public List<Sql_stmtContext> sql_stmt() {
			return getRuleContexts(Sql_stmtContext.class);
		}
		public Sql_stmtContext sql_stmt(int i) {
			return getRuleContext(Sql_stmtContext.class,i);
		}
		public Sql_stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterSql_stmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitSql_stmt_list(this);
		}
	}

	public final Sql_stmt_listContext sql_stmt_list() throws RecognitionException {
		Sql_stmt_listContext _localctx = new Sql_stmt_listContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sql_stmt_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			sql_stmt();
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(344); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(343);
						match(SEMICOLON);
						}
						}
						setState(346); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEMICOLON );
					setState(348);
					sql_stmt();
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(354);
				match(SEMICOLON);
				}
				}
				setState(359);
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

	public static class Sql_stmtContext extends ParserRuleContext {
		public Factored_select_stmtContext factored_select_stmt() {
			return getRuleContext(Factored_select_stmtContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Sql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterSql_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitSql_stmt(this);
		}
	}

	public final Sql_stmtContext sql_stmt() throws RecognitionException {
		Sql_stmtContext _localctx = new Sql_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sql_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(360);
				factored_select_stmt();
				}
				break;
			case 2:
				{
				setState(361);
				select_stmt();
				}
				break;
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

	public static class Factored_select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(querytestParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(querytestParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(querytestParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(querytestParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(querytestParser.K_RECURSIVE, 0); }
		public TerminalNode K_OFFSET() { return getToken(querytestParser.K_OFFSET, 0); }
		public Factored_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factored_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterFactored_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitFactored_select_stmt(this);
		}
	}

	public final Factored_select_stmtContext factored_select_stmt() throws RecognitionException {
		Factored_select_stmtContext _localctx = new Factored_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_factored_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(364);
				match(K_WITH);
				setState(366);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(365);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(368);
				common_table_expression();
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(369);
					match(C1);
					setState(370);
					common_table_expression();
					}
					}
					setState(375);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(378);
			select_core();
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & ((1L << (K_EXCEPT - 41)) | (1L << (K_INTERSECT - 41)) | (1L << (K_UNION - 41)))) != 0)) {
				{
				{
				setState(379);
				compound_operator();
				setState(380);
				select_core();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(397);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(387);
				match(K_ORDER);
				setState(388);
				match(K_BY);
				setState(389);
				ordering_term();
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(390);
					match(C1);
					setState(391);
					ordering_term();
					}
					}
					setState(396);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(405);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(399);
				match(K_LIMIT);
				setState(400);
				expr(0);
				setState(403);
				_la = _input.LA(1);
				if (_la==K_OFFSET || _la==C1) {
					{
					setState(401);
					_la = _input.LA(1);
					if ( !(_la==K_OFFSET || _la==C1) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(402);
					expr(0);
					}
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

	public static class Select_coreContext extends ParserRuleContext {
		public TerminalNode K_FROM() { return getToken(querytestParser.K_FROM, 0); }
		public TerminalNode K_SELECT() { return getToken(querytestParser.K_SELECT, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public TerminalNode K_DISTINCT() { return getToken(querytestParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(querytestParser.K_ALL, 0); }
		public Select_coreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_core; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterSelect_core(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitSelect_core(this);
		}
	}

	public final Select_coreContext select_core() throws RecognitionException {
		Select_coreContext _localctx = new Select_coreContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_select_core);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			_la = _input.LA(1);
			if (_la==K_SELECT) {
				{
				setState(407);
				match(K_SELECT);
				setState(409);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(408);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				setState(411);
				result_column();
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(412);
					match(C1);
					setState(413);
					result_column();
					}
					}
					setState(418);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			{
			setState(421);
			match(K_FROM);
			setState(431);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(422);
				table_or_subquery();
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(423);
					match(C1);
					setState(424);
					table_or_subquery();
					}
					}
					setState(429);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(430);
				join_clause();
				}
				break;
			}
			}
			setState(434);
			_la = _input.LA(1);
			if (_la==K_VALUES || _la==K_WHERE) {
				{
				setState(433);
				where();
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

	public static class WhereContext extends ParserRuleContext {
		public TerminalNode K_WHERE() { return getToken(querytestParser.K_WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_GROUP() { return getToken(querytestParser.K_GROUP, 0); }
		public TerminalNode K_BY() { return getToken(querytestParser.K_BY, 0); }
		public TerminalNode K_HAVING() { return getToken(querytestParser.K_HAVING, 0); }
		public TerminalNode K_VALUES() { return getToken(querytestParser.K_VALUES, 0); }
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitWhere(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_where);
		int _la;
		try {
			setState(483);
			switch (_input.LA(1)) {
			case K_WHERE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(436);
				match(K_WHERE);
				setState(437);
				expr(0);
				}
				setState(453);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(439);
					match(K_GROUP);
					setState(440);
					match(K_BY);
					setState(441);
					expr(0);
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(442);
						match(C1);
						setState(443);
						expr(0);
						}
						}
						setState(448);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(451);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(449);
						match(K_HAVING);
						setState(450);
						expr(0);
						}
					}

					}
				}

				}
				break;
			case K_VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				match(K_VALUES);
				setState(456);
				match(OPEN_PARENTHESE);
				setState(457);
				expr(0);
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(458);
					match(C1);
					setState(459);
					expr(0);
					}
					}
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(465);
				match(CLOSE_PARENTHESE);
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(466);
					match(C1);
					setState(467);
					match(OPEN_PARENTHESE);
					setState(468);
					expr(0);
					setState(473);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(469);
						match(C1);
						setState(470);
						expr(0);
						}
						}
						setState(475);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(476);
					match(CLOSE_PARENTHESE);
					}
					}
					setState(482);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class Result_columnContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_aliasContext column_alias() {
			return getRuleContext(Column_aliasContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(querytestParser.K_AS, 0); }
		public Result_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterResult_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitResult_column(this);
		}
	}

	public final Result_columnContext result_column() throws RecognitionException {
		Result_columnContext _localctx = new Result_columnContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_result_column);
		int _la;
		try {
			setState(497);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(486);
				table_name();
				setState(487);
				match(DOT);
				setState(488);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(490);
				expr(0);
				setState(495);
				_la = _input.LA(1);
				if (_la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(492);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(491);
						match(K_AS);
						}
					}

					setState(494);
					column_alias();
					}
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

	public static class Table_or_subqueryContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public TerminalNode K_INDEXED() { return getToken(querytestParser.K_INDEXED, 0); }
		public TerminalNode K_BY() { return getToken(querytestParser.K_BY, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_NOT() { return getToken(querytestParser.K_NOT, 0); }
		public TerminalNode K_AS() { return getToken(querytestParser.K_AS, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Table_or_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterTable_or_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitTable_or_subquery(this);
		}
	}

	public final Table_or_subqueryContext table_or_subquery() throws RecognitionException {
		Table_or_subqueryContext _localctx = new Table_or_subqueryContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_table_or_subquery);
		int _la;
		try {
			setState(546);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(502);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(499);
					database_name();
					setState(500);
					match(DOT);
					}
					break;
				}
				setState(504);
				table_name();
				setState(509);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(506);
					switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
					case 1:
						{
						setState(505);
						match(K_AS);
						}
						break;
					}
					setState(508);
					table_alias();
					}
					break;
				}
				setState(516);
				switch (_input.LA(1)) {
				case K_INDEXED:
					{
					setState(511);
					match(K_INDEXED);
					setState(512);
					match(K_BY);
					setState(513);
					index_name();
					}
					break;
				case K_NOT:
					{
					setState(514);
					match(K_NOT);
					setState(515);
					match(K_INDEXED);
					}
					break;
				case EOF:
				case K_CROSS:
				case K_EXCEPT:
				case K_FULL:
				case K_GROUP:
				case K_INNER:
				case K_INTERSECT:
				case K_JOIN:
				case K_LEFT:
				case K_LIMIT:
				case K_NATURAL:
				case K_ON:
				case K_ORDER:
				case K_RIGHT:
				case K_UNION:
				case K_USING:
				case K_VALUES:
				case K_WHERE:
				case C1:
				case CLOSE_PARENTHESE:
				case SEMICOLON:
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
				match(OPEN_PARENTHESE);
				setState(528);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(519);
					table_or_subquery();
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(520);
						match(C1);
						setState(521);
						table_or_subquery();
						}
						}
						setState(526);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(527);
					join_clause();
					}
					break;
				}
				setState(530);
				match(CLOSE_PARENTHESE);
				setState(535);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(532);
					switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
					case 1:
						{
						setState(531);
						match(K_AS);
						}
						break;
					}
					setState(534);
					table_alias();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(537);
				match(OPEN_PARENTHESE);
				setState(538);
				select_stmt();
				setState(539);
				match(CLOSE_PARENTHESE);
				setState(544);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(541);
					switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
					case 1:
						{
						setState(540);
						match(K_AS);
						}
						break;
					}
					setState(543);
					table_alias();
					}
					break;
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

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode K_ABORT() { return getToken(querytestParser.K_ABORT, 0); }
		public TerminalNode K_ALL() { return getToken(querytestParser.K_ALL, 0); }
		public TerminalNode K_AND() { return getToken(querytestParser.K_AND, 0); }
		public TerminalNode K_AS() { return getToken(querytestParser.K_AS, 0); }
		public TerminalNode K_ASC() { return getToken(querytestParser.K_ASC, 0); }
		public TerminalNode K_BETWEEN() { return getToken(querytestParser.K_BETWEEN, 0); }
		public TerminalNode K_BY() { return getToken(querytestParser.K_BY, 0); }
		public TerminalNode K_CASE() { return getToken(querytestParser.K_CASE, 0); }
		public TerminalNode K_CAST() { return getToken(querytestParser.K_CAST, 0); }
		public TerminalNode K_COLLATE() { return getToken(querytestParser.K_COLLATE, 0); }
		public TerminalNode K_CROSS() { return getToken(querytestParser.K_CROSS, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(querytestParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(querytestParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(querytestParser.K_CURRENT_TIMESTAMP, 0); }
		public TerminalNode K_DESC() { return getToken(querytestParser.K_DESC, 0); }
		public TerminalNode K_DISTINCT() { return getToken(querytestParser.K_DISTINCT, 0); }
		public TerminalNode K_ELSE() { return getToken(querytestParser.K_ELSE, 0); }
		public TerminalNode K_END() { return getToken(querytestParser.K_END, 0); }
		public TerminalNode K_ESCAPE() { return getToken(querytestParser.K_ESCAPE, 0); }
		public TerminalNode K_EXCEPT() { return getToken(querytestParser.K_EXCEPT, 0); }
		public TerminalNode K_EXISTS() { return getToken(querytestParser.K_EXISTS, 0); }
		public TerminalNode K_FAIL() { return getToken(querytestParser.K_FAIL, 0); }
		public TerminalNode K_FROM() { return getToken(querytestParser.K_FROM, 0); }
		public TerminalNode K_FULL() { return getToken(querytestParser.K_FULL, 0); }
		public TerminalNode K_GLOB() { return getToken(querytestParser.K_GLOB, 0); }
		public TerminalNode K_GROUP() { return getToken(querytestParser.K_GROUP, 0); }
		public TerminalNode K_HAVING() { return getToken(querytestParser.K_HAVING, 0); }
		public TerminalNode K_IF() { return getToken(querytestParser.K_IF, 0); }
		public TerminalNode K_IGNORE() { return getToken(querytestParser.K_IGNORE, 0); }
		public TerminalNode K_IN() { return getToken(querytestParser.K_IN, 0); }
		public TerminalNode K_INDEXED() { return getToken(querytestParser.K_INDEXED, 0); }
		public TerminalNode K_INNER() { return getToken(querytestParser.K_INNER, 0); }
		public TerminalNode K_INTERSECT() { return getToken(querytestParser.K_INTERSECT, 0); }
		public TerminalNode K_IS() { return getToken(querytestParser.K_IS, 0); }
		public TerminalNode K_ISNULL() { return getToken(querytestParser.K_ISNULL, 0); }
		public TerminalNode K_JOIN() { return getToken(querytestParser.K_JOIN, 0); }
		public TerminalNode K_LEFT() { return getToken(querytestParser.K_LEFT, 0); }
		public TerminalNode K_LIKE() { return getToken(querytestParser.K_LIKE, 0); }
		public TerminalNode K_LIMIT() { return getToken(querytestParser.K_LIMIT, 0); }
		public TerminalNode K_MATCH() { return getToken(querytestParser.K_MATCH, 0); }
		public TerminalNode K_NATURAL() { return getToken(querytestParser.K_NATURAL, 0); }
		public TerminalNode K_NO() { return getToken(querytestParser.K_NO, 0); }
		public TerminalNode K_NOT() { return getToken(querytestParser.K_NOT, 0); }
		public TerminalNode K_NOTNULL() { return getToken(querytestParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(querytestParser.K_NULL, 0); }
		public TerminalNode K_OFFSET() { return getToken(querytestParser.K_OFFSET, 0); }
		public TerminalNode K_ON() { return getToken(querytestParser.K_ON, 0); }
		public TerminalNode K_OR() { return getToken(querytestParser.K_OR, 0); }
		public TerminalNode K_ORDER() { return getToken(querytestParser.K_ORDER, 0); }
		public TerminalNode K_OUTER() { return getToken(querytestParser.K_OUTER, 0); }
		public TerminalNode K_RAISE() { return getToken(querytestParser.K_RAISE, 0); }
		public TerminalNode K_RECURSIVE() { return getToken(querytestParser.K_RECURSIVE, 0); }
		public TerminalNode K_REGEXP() { return getToken(querytestParser.K_REGEXP, 0); }
		public TerminalNode K_RIGHT() { return getToken(querytestParser.K_RIGHT, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(querytestParser.K_ROLLBACK, 0); }
		public TerminalNode K_SELECT() { return getToken(querytestParser.K_SELECT, 0); }
		public TerminalNode K_THEN() { return getToken(querytestParser.K_THEN, 0); }
		public TerminalNode K_UNION() { return getToken(querytestParser.K_UNION, 0); }
		public TerminalNode K_USING() { return getToken(querytestParser.K_USING, 0); }
		public TerminalNode K_VALUES() { return getToken(querytestParser.K_VALUES, 0); }
		public TerminalNode K_WHEN() { return getToken(querytestParser.K_WHEN, 0); }
		public TerminalNode K_WHERE() { return getToken(querytestParser.K_WHERE, 0); }
		public TerminalNode K_WITH() { return getToken(querytestParser.K_WITH, 0); }
		public TerminalNode K_GENERATE() { return getToken(querytestParser.K_GENERATE, 0); }
		public TerminalNode K_MAX() { return getToken(querytestParser.K_MAX, 0); }
		public TerminalNode K_MIN() { return getToken(querytestParser.K_MIN, 0); }
		public TerminalNode K_AVG() { return getToken(querytestParser.K_AVG, 0); }
		public TerminalNode K_SUM() { return getToken(querytestParser.K_SUM, 0); }
		public TerminalNode K_COUNT() { return getToken(querytestParser.K_COUNT, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitKeyword(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL) | (1L << K_NO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)))) != 0)) ) {
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

	public static class Select_stmtContext extends ParserRuleContext {
		public List<Select_or_valuesContext> select_or_values() {
			return getRuleContexts(Select_or_valuesContext.class);
		}
		public Select_or_valuesContext select_or_values(int i) {
			return getRuleContext(Select_or_valuesContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(querytestParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(querytestParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(querytestParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(querytestParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(querytestParser.K_RECURSIVE, 0); }
		public TerminalNode K_OFFSET() { return getToken(querytestParser.K_OFFSET, 0); }
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterSelect_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitSelect_stmt(this);
		}
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(550);
				match(K_WITH);
				setState(552);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(551);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(554);
				common_table_expression();
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(555);
					match(C1);
					setState(556);
					common_table_expression();
					}
					}
					setState(561);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(564);
			select_or_values();
			setState(570);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & ((1L << (K_EXCEPT - 41)) | (1L << (K_INTERSECT - 41)) | (1L << (K_UNION - 41)))) != 0)) {
				{
				{
				setState(565);
				compound_operator();
				setState(566);
				select_or_values();
				}
				}
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(583);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(573);
				match(K_ORDER);
				setState(574);
				match(K_BY);
				setState(575);
				ordering_term();
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(576);
					match(C1);
					setState(577);
					ordering_term();
					}
					}
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(591);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(585);
				match(K_LIMIT);
				setState(586);
				expr(0);
				setState(589);
				_la = _input.LA(1);
				if (_la==K_OFFSET || _la==C1) {
					{
					setState(587);
					_la = _input.LA(1);
					if ( !(_la==K_OFFSET || _la==C1) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(588);
					expr(0);
					}
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

	public static class Select_or_valuesContext extends ParserRuleContext {
		public TerminalNode K_FROM() { return getToken(querytestParser.K_FROM, 0); }
		public TerminalNode K_SELECT() { return getToken(querytestParser.K_SELECT, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public TerminalNode K_WHERE() { return getToken(querytestParser.K_WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_GROUP() { return getToken(querytestParser.K_GROUP, 0); }
		public TerminalNode K_BY() { return getToken(querytestParser.K_BY, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public TerminalNode K_HAVING() { return getToken(querytestParser.K_HAVING, 0); }
		public TerminalNode K_DISTINCT() { return getToken(querytestParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(querytestParser.K_ALL, 0); }
		public TerminalNode K_VALUES() { return getToken(querytestParser.K_VALUES, 0); }
		public Select_or_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_or_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterSelect_or_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitSelect_or_values(this);
		}
	}

	public final Select_or_valuesContext select_or_values() throws RecognitionException {
		Select_or_valuesContext _localctx = new Select_or_valuesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_select_or_values);
		int _la;
		try {
			setState(667);
			switch (_input.LA(1)) {
			case K_FROM:
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(605);
				_la = _input.LA(1);
				if (_la==K_SELECT) {
					{
					setState(593);
					match(K_SELECT);
					setState(595);
					switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
					case 1:
						{
						setState(594);
						_la = _input.LA(1);
						if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					setState(597);
					result_column();
					setState(602);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(598);
						match(C1);
						setState(599);
						result_column();
						}
						}
						setState(604);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				{
				setState(607);
				match(K_FROM);
				setState(617);
				switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
				case 1:
					{
					setState(608);
					table_or_subquery();
					setState(613);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(609);
						match(C1);
						setState(610);
						table_or_subquery();
						}
						}
						setState(615);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(616);
					join_clause();
					}
					break;
				}
				}
				setState(621);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(619);
					match(K_WHERE);
					setState(620);
					expr(0);
					}
				}

				setState(637);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(623);
					match(K_GROUP);
					setState(624);
					match(K_BY);
					setState(625);
					expr(0);
					setState(630);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(626);
						match(C1);
						setState(627);
						expr(0);
						}
						}
						setState(632);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(635);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(633);
						match(K_HAVING);
						setState(634);
						expr(0);
						}
					}

					}
				}

				}
				break;
			case K_VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(639);
				match(K_VALUES);
				setState(640);
				match(OPEN_PARENTHESE);
				setState(641);
				expr(0);
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(642);
					match(C1);
					setState(643);
					expr(0);
					}
					}
					setState(648);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(649);
				match(CLOSE_PARENTHESE);
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(650);
					match(C1);
					setState(651);
					match(OPEN_PARENTHESE);
					setState(652);
					expr(0);
					setState(657);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(653);
						match(C1);
						setState(654);
						expr(0);
						}
						}
						setState(659);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(660);
					match(CLOSE_PARENTHESE);
					}
					}
					setState(666);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class Compound_operatorContext extends ParserRuleContext {
		public TerminalNode K_UNION() { return getToken(querytestParser.K_UNION, 0); }
		public TerminalNode K_ALL() { return getToken(querytestParser.K_ALL, 0); }
		public TerminalNode K_INTERSECT() { return getToken(querytestParser.K_INTERSECT, 0); }
		public TerminalNode K_EXCEPT() { return getToken(querytestParser.K_EXCEPT, 0); }
		public Compound_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterCompound_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitCompound_operator(this);
		}
	}

	public final Compound_operatorContext compound_operator() throws RecognitionException {
		Compound_operatorContext _localctx = new Compound_operatorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_compound_operator);
		try {
			setState(674);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(669);
				match(K_UNION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(670);
				match(K_UNION);
				setState(671);
				match(K_ALL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(672);
				match(K_INTERSECT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(673);
				match(K_EXCEPT);
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

	public static class Join_clauseContext extends ParserRuleContext {
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public List<Join_operatorContext> join_operator() {
			return getRuleContexts(Join_operatorContext.class);
		}
		public Join_operatorContext join_operator(int i) {
			return getRuleContext(Join_operatorContext.class,i);
		}
		public List<Join_constraintContext> join_constraint() {
			return getRuleContexts(Join_constraintContext.class);
		}
		public Join_constraintContext join_constraint(int i) {
			return getRuleContext(Join_constraintContext.class,i);
		}
		public List<Join_clauseContext> join_clause() {
			return getRuleContexts(Join_clauseContext.class);
		}
		public Join_clauseContext join_clause(int i) {
			return getRuleContext(Join_clauseContext.class,i);
		}
		public Join_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterJoin_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitJoin_clause(this);
		}
	}

	public final Join_clauseContext join_clause() throws RecognitionException {
		Join_clauseContext _localctx = new Join_clauseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_join_clause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			table_or_subquery();
			setState(686);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(677);
					join_operator();
					setState(680);
					switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
					case 1:
						{
						setState(678);
						join_clause();
						}
						break;
					case 2:
						{
						setState(679);
						table_or_subquery();
						}
						break;
					}
					setState(682);
					join_constraint();
					}
					} 
				}
				setState(688);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
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

	public static class Join_operatorContext extends ParserRuleContext {
		public TerminalNode K_JOIN() { return getToken(querytestParser.K_JOIN, 0); }
		public TerminalNode K_NATURAL() { return getToken(querytestParser.K_NATURAL, 0); }
		public TerminalNode K_LEFT() { return getToken(querytestParser.K_LEFT, 0); }
		public TerminalNode K_RIGHT() { return getToken(querytestParser.K_RIGHT, 0); }
		public TerminalNode K_FULL() { return getToken(querytestParser.K_FULL, 0); }
		public TerminalNode K_INNER() { return getToken(querytestParser.K_INNER, 0); }
		public TerminalNode K_CROSS() { return getToken(querytestParser.K_CROSS, 0); }
		public TerminalNode K_OUTER() { return getToken(querytestParser.K_OUTER, 0); }
		public Join_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterJoin_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitJoin_operator(this);
		}
	}

	public final Join_operatorContext join_operator() throws RecognitionException {
		Join_operatorContext _localctx = new Join_operatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_join_operator);
		int _la;
		try {
			setState(710);
			switch (_input.LA(1)) {
			case C1:
				enterOuterAlt(_localctx, 1);
				{
				setState(689);
				match(C1);
				}
				break;
			case K_CROSS:
			case K_FULL:
			case K_INNER:
			case K_JOIN:
			case K_LEFT:
			case K_NATURAL:
			case K_RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(691);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(690);
					match(K_NATURAL);
					}
				}

				setState(707);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(693);
					match(K_LEFT);
					setState(695);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(694);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_RIGHT:
					{
					setState(697);
					match(K_RIGHT);
					setState(699);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(698);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_FULL:
					{
					setState(701);
					match(K_FULL);
					setState(703);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(702);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(705);
					match(K_INNER);
					}
					break;
				case K_CROSS:
					{
					setState(706);
					match(K_CROSS);
					}
					break;
				case K_JOIN:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(709);
				match(K_JOIN);
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

	public static class Join_constraintContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(querytestParser.K_ON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_USING() { return getToken(querytestParser.K_USING, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Join_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterJoin_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitJoin_constraint(this);
		}
	}

	public final Join_constraintContext join_constraint() throws RecognitionException {
		Join_constraintContext _localctx = new Join_constraintContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_join_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(726);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(712);
				match(K_ON);
				setState(713);
				expr(0);
				}
				break;
			case 2:
				{
				setState(714);
				match(K_USING);
				setState(715);
				match(OPEN_PARENTHESE);
				setState(716);
				column_name();
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(717);
					match(C1);
					setState(718);
					column_name();
					}
					}
					setState(723);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(724);
				match(CLOSE_PARENTHESE);
				}
				break;
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

	public static class Common_table_expressionContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(querytestParser.K_AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Common_table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_table_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterCommon_table_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitCommon_table_expression(this);
		}
	}

	public final Common_table_expressionContext common_table_expression() throws RecognitionException {
		Common_table_expressionContext _localctx = new Common_table_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_common_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
			table_name();
			setState(740);
			_la = _input.LA(1);
			if (_la==OPEN_PARENTHESE) {
				{
				setState(729);
				match(OPEN_PARENTHESE);
				setState(730);
				column_name();
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(731);
					match(C1);
					setState(732);
					column_name();
					}
					}
					setState(737);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(738);
				match(CLOSE_PARENTHESE);
				}
			}

			setState(742);
			match(K_AS);
			setState(743);
			match(OPEN_PARENTHESE);
			setState(744);
			select_stmt();
			setState(745);
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

	public static class Ordering_termContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_COLLATE() { return getToken(querytestParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ASC() { return getToken(querytestParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(querytestParser.K_DESC, 0); }
		public Ordering_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterOrdering_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitOrdering_term(this);
		}
	}

	public final Ordering_termContext ordering_term() throws RecognitionException {
		Ordering_termContext _localctx = new Ordering_termContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_ordering_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			expr(0);
			setState(750);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(748);
				match(K_COLLATE);
				setState(749);
				collation_name();
				}
			}

			setState(753);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(752);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
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

	public static class ExprContext extends ParserRuleContext {
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode BIND_PARAMETER() { return getToken(querytestParser.BIND_PARAMETER, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_CAST() { return getToken(querytestParser.K_CAST, 0); }
		public TerminalNode K_AS() { return getToken(querytestParser.K_AS, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_EXISTS() { return getToken(querytestParser.K_EXISTS, 0); }
		public TerminalNode K_NOT() { return getToken(querytestParser.K_NOT, 0); }
		public TerminalNode K_CASE() { return getToken(querytestParser.K_CASE, 0); }
		public TerminalNode K_END() { return getToken(querytestParser.K_END, 0); }
		public List<TerminalNode> K_WHEN() { return getTokens(querytestParser.K_WHEN); }
		public TerminalNode K_WHEN(int i) {
			return getToken(querytestParser.K_WHEN, i);
		}
		public List<TerminalNode> K_THEN() { return getTokens(querytestParser.K_THEN); }
		public TerminalNode K_THEN(int i) {
			return getToken(querytestParser.K_THEN, i);
		}
		public TerminalNode K_ELSE() { return getToken(querytestParser.K_ELSE, 0); }
		public Raise_functionContext raise_function() {
			return getRuleContext(Raise_functionContext.class,0);
		}
		public TerminalNode K_IS() { return getToken(querytestParser.K_IS, 0); }
		public TerminalNode K_IN() { return getToken(querytestParser.K_IN, 0); }
		public TerminalNode K_LIKE() { return getToken(querytestParser.K_LIKE, 0); }
		public TerminalNode K_GLOB() { return getToken(querytestParser.K_GLOB, 0); }
		public TerminalNode K_MATCH() { return getToken(querytestParser.K_MATCH, 0); }
		public TerminalNode K_REGEXP() { return getToken(querytestParser.K_REGEXP, 0); }
		public TerminalNode K_AND() { return getToken(querytestParser.K_AND, 0); }
		public TerminalNode K_OR() { return getToken(querytestParser.K_OR, 0); }
		public TerminalNode K_BETWEEN() { return getToken(querytestParser.K_BETWEEN, 0); }
		public TerminalNode K_COLLATE() { return getToken(querytestParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ESCAPE() { return getToken(querytestParser.K_ESCAPE, 0); }
		public TerminalNode K_ISNULL() { return getToken(querytestParser.K_ISNULL, 0); }
		public TerminalNode K_NOTNULL() { return getToken(querytestParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(querytestParser.K_NULL, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(813);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				setState(756);
				unary_operator();
				setState(757);
				expr(20);
				}
				break;
			case 2:
				{
				setState(759);
				operand();
				}
				break;
			case 3:
				{
				setState(760);
				match(BIND_PARAMETER);
				}
				break;
			case 4:
				{
				setState(769);
				switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
				case 1:
					{
					setState(764);
					switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
					case 1:
						{
						setState(761);
						database_name();
						setState(762);
						match(DOT);
						}
						break;
					}
					setState(766);
					table_alias();
					setState(767);
					match(DOT);
					}
					break;
				}
				setState(771);
				column_name();
				}
				break;
			case 5:
				{
				setState(772);
				match(OPEN_PARENTHESE);
				setState(773);
				expr(0);
				setState(774);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 6:
				{
				setState(776);
				match(K_CAST);
				setState(777);
				match(OPEN_PARENTHESE);
				setState(778);
				expr(0);
				setState(779);
				match(K_AS);
				setState(780);
				type_name();
				setState(781);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 7:
				{
				setState(787);
				_la = _input.LA(1);
				if (_la==K_EXISTS || _la==K_NOT) {
					{
					setState(784);
					_la = _input.LA(1);
					if (_la==K_NOT) {
						{
						setState(783);
						match(K_NOT);
						}
					}

					setState(786);
					match(K_EXISTS);
					}
				}

				setState(789);
				match(OPEN_PARENTHESE);
				setState(790);
				select_stmt();
				setState(791);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 8:
				{
				setState(793);
				match(K_CASE);
				setState(795);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(794);
					expr(0);
					}
					break;
				}
				setState(802); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(797);
					match(K_WHEN);
					setState(798);
					expr(0);
					setState(799);
					match(K_THEN);
					setState(800);
					expr(0);
					}
					}
					setState(804); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_WHEN );
				setState(808);
				_la = _input.LA(1);
				if (_la==K_ELSE) {
					{
					setState(806);
					match(K_ELSE);
					setState(807);
					expr(0);
					}
				}

				setState(810);
				match(K_END);
				}
				break;
			case 9:
				{
				setState(812);
				raise_function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(915);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(913);
					switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(815);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(816);
						match(T__0);
						setState(817);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(818);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(819);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5 || _la==C3) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(820);
						expr(19);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(821);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(822);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(823);
						expr(18);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(824);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(825);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(826);
						expr(17);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(827);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(828);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(829);
						expr(16);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(830);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(843);
						switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
						case 1:
							{
							setState(831);
							match(T__15);
							}
							break;
						case 2:
							{
							setState(832);
							match(T__16);
							}
							break;
						case 3:
							{
							setState(833);
							match(T__17);
							}
							break;
						case 4:
							{
							setState(834);
							match(T__18);
							}
							break;
						case 5:
							{
							setState(835);
							match(K_IS);
							}
							break;
						case 6:
							{
							setState(836);
							match(K_IS);
							setState(837);
							match(K_NOT);
							}
							break;
						case 7:
							{
							setState(838);
							match(K_IN);
							}
							break;
						case 8:
							{
							setState(839);
							match(K_LIKE);
							}
							break;
						case 9:
							{
							setState(840);
							match(K_GLOB);
							}
							break;
						case 10:
							{
							setState(841);
							match(K_MATCH);
							}
							break;
						case 11:
							{
							setState(842);
							match(K_REGEXP);
							}
							break;
						}
						setState(845);
						expr(15);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(846);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(847);
						match(K_AND);
						setState(848);
						expr(14);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(849);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(850);
						match(K_OR);
						setState(851);
						expr(13);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(852);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(853);
						match(K_IS);
						setState(855);
						switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
						case 1:
							{
							setState(854);
							match(K_NOT);
							}
							break;
						}
						setState(857);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(858);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(860);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(859);
							match(K_NOT);
							}
						}

						setState(862);
						match(K_BETWEEN);
						setState(863);
						expr(0);
						setState(864);
						match(K_AND);
						setState(865);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(867);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(868);
						match(K_COLLATE);
						setState(869);
						collation_name();
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(870);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(872);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(871);
							match(K_NOT);
							}
						}

						setState(874);
						_la = _input.LA(1);
						if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (K_GLOB - 46)) | (1L << (K_LIKE - 46)) | (1L << (K_MATCH - 46)) | (1L << (K_REGEXP - 46)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(875);
						expr(0);
						setState(878);
						switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
						case 1:
							{
							setState(876);
							match(K_ESCAPE);
							setState(877);
							expr(0);
							}
							break;
						}
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(880);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(885);
						switch (_input.LA(1)) {
						case K_ISNULL:
							{
							setState(881);
							match(K_ISNULL);
							}
							break;
						case K_NOTNULL:
							{
							setState(882);
							match(K_NOTNULL);
							}
							break;
						case K_NOT:
							{
							setState(883);
							match(K_NOT);
							setState(884);
							match(K_NULL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(887);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(889);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(888);
							match(K_NOT);
							}
						}

						setState(891);
						match(K_IN);
						setState(911);
						switch (_input.LA(1)) {
						case OPEN_PARENTHESE:
							{
							setState(892);
							match(OPEN_PARENTHESE);
							setState(902);
							switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
							case 1:
								{
								setState(893);
								select_stmt();
								}
								break;
							case 2:
								{
								setState(894);
								expr(0);
								setState(899);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==C1) {
									{
									{
									setState(895);
									match(C1);
									setState(896);
									expr(0);
									}
									}
									setState(901);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
								break;
							}
							setState(904);
							match(CLOSE_PARENTHESE);
							}
							break;
						case K_ABORT:
						case K_ALL:
						case K_AND:
						case K_AS:
						case K_ASC:
						case K_BETWEEN:
						case K_BY:
						case K_CASE:
						case K_CAST:
						case K_COLLATE:
						case K_CROSS:
						case K_CURRENT_DATE:
						case K_CURRENT_TIME:
						case K_CURRENT_TIMESTAMP:
						case K_DESC:
						case K_DISTINCT:
						case K_ELSE:
						case K_END:
						case K_ESCAPE:
						case K_EXCEPT:
						case K_EXISTS:
						case K_FAIL:
						case K_FULL:
						case K_FROM:
						case K_GLOB:
						case K_GROUP:
						case K_HAVING:
						case K_IF:
						case K_IGNORE:
						case K_IN:
						case K_INDEXED:
						case K_INNER:
						case K_INTERSECT:
						case K_IS:
						case K_ISNULL:
						case K_JOIN:
						case K_LEFT:
						case K_LIKE:
						case K_LIMIT:
						case K_MATCH:
						case K_NATURAL:
						case K_NO:
						case K_NOT:
						case K_NOTNULL:
						case K_NULL:
						case K_OFFSET:
						case K_ON:
						case K_OR:
						case K_ORDER:
						case K_OUTER:
						case K_RAISE:
						case K_RECURSIVE:
						case K_REGEXP:
						case K_RIGHT:
						case K_ROLLBACK:
						case K_SELECT:
						case K_THEN:
						case K_UNION:
						case K_USING:
						case K_VALUES:
						case K_WHEN:
						case K_WHERE:
						case K_WITH:
						case K_GENERATE:
						case K_MAX:
						case K_MIN:
						case K_AVG:
						case K_COUNT:
						case K_SUM:
						case IDENTIFIER:
							{
							setState(908);
							switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
							case 1:
								{
								setState(905);
								database_name();
								setState(906);
								match(DOT);
								}
								break;
							}
							setState(910);
							table_name();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					}
					} 
				}
				setState(917);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
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

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(querytestParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(querytestParser.STRING_LITERAL, 0); }
		public TerminalNode BLOB_LITERAL() { return getToken(querytestParser.BLOB_LITERAL, 0); }
		public TerminalNode K_NULL() { return getToken(querytestParser.K_NULL, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(querytestParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(querytestParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(querytestParser.K_CURRENT_TIMESTAMP, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitLiteral_value(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (K_NULL - 66)) | (1L << (NUMERIC_LITERAL - 66)) | (1L << (BLOB_LITERAL - 66)) | (1L << (STRING_LITERAL - 66)))) != 0)) ) {
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

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode K_NOT() { return getToken(querytestParser.K_NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			_la = _input.LA(1);
			if ( !(((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & ((1L << (T__6 - 7)) | (1L << (T__7 - 7)) | (1L << (T__19 - 7)) | (1L << (K_NOT - 7)))) != 0)) ) {
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

	public static class NameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(922);
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

	public static class Type_nameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<Signed_numberContext> signed_number() {
			return getRuleContexts(Signed_numberContext.class);
		}
		public Signed_numberContext signed_number(int i) {
			return getRuleContext(Signed_numberContext.class,i);
		}
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(924);
				name();
				}
				}
				setState(927); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL) | (1L << K_NO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)) | (1L << (IDENTIFIER - 64)))) != 0) );
			setState(939);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				{
				setState(929);
				match(OPEN_PARENTHESE);
				setState(930);
				signed_number();
				setState(931);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				{
				setState(933);
				match(OPEN_PARENTHESE);
				setState(934);
				signed_number();
				setState(935);
				match(C1);
				setState(936);
				signed_number();
				setState(937);
				match(CLOSE_PARENTHESE);
				}
				break;
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
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
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

	public static class Ag_function_nameContext extends ParserRuleContext {
		public Ag_keywordContext ag_keyword() {
			return getRuleContext(Ag_keywordContext.class,0);
		}
		public Ag_function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ag_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterAg_function_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitAg_function_name(this);
		}
	}

	public final Ag_function_nameContext ag_function_name() throws RecognitionException {
		Ag_function_nameContext _localctx = new Ag_function_nameContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_ag_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(943);
			ag_keyword();
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

	public static class Ag_keywordContext extends ParserRuleContext {
		public TerminalNode K_MAX() { return getToken(querytestParser.K_MAX, 0); }
		public TerminalNode K_MIN() { return getToken(querytestParser.K_MIN, 0); }
		public TerminalNode K_SUM() { return getToken(querytestParser.K_SUM, 0); }
		public TerminalNode K_AVG() { return getToken(querytestParser.K_AVG, 0); }
		public TerminalNode K_COUNT() { return getToken(querytestParser.K_COUNT, 0); }
		public Ag_keywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ag_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterAg_keyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitAg_keyword(this);
		}
	}

	public final Ag_keywordContext ag_keyword() throws RecognitionException {
		Ag_keywordContext _localctx = new Ag_keywordContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_ag_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(945);
			_la = _input.LA(1);
			if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (K_MAX - 86)) | (1L << (K_MIN - 86)) | (1L << (K_AVG - 86)) | (1L << (K_COUNT - 86)) | (1L << (K_SUM - 86)))) != 0)) ) {
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

	public static class Collation_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Collation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collation_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterCollation_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitCollation_name(this);
		}
	}

	public final Collation_nameContext collation_name() throws RecognitionException {
		Collation_nameContext _localctx = new Collation_nameContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_collation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
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
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterDatabase_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitDatabase_name(this);
		}
	}

	public final Database_nameContext database_name() throws RecognitionException {
		Database_nameContext _localctx = new Database_nameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949);
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
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitTable_name(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(951);
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
		public TerminalNode IDENTIFIER() { return getToken(querytestParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(querytestParser.STRING_LITERAL, 0); }
		public Column_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterColumn_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitColumn_alias(this);
		}
	}

	public final Column_aliasContext column_alias() throws RecognitionException {
		Column_aliasContext _localctx = new Column_aliasContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(953);
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
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitColumn_name(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(955);
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
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterTable_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitTable_alias(this);
		}
	}

	public final Table_aliasContext table_alias() throws RecognitionException {
		Table_aliasContext _localctx = new Table_aliasContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(957);
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
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterIndex_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitIndex_name(this);
		}
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(959);
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
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(querytestParser.IDENTIFIER, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitAny_name(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_any_name);
		try {
			setState(963);
			switch (_input.LA(1)) {
			case K_ABORT:
			case K_ALL:
			case K_AND:
			case K_AS:
			case K_ASC:
			case K_BETWEEN:
			case K_BY:
			case K_CASE:
			case K_CAST:
			case K_COLLATE:
			case K_CROSS:
			case K_CURRENT_DATE:
			case K_CURRENT_TIME:
			case K_CURRENT_TIMESTAMP:
			case K_DESC:
			case K_DISTINCT:
			case K_ELSE:
			case K_END:
			case K_ESCAPE:
			case K_EXCEPT:
			case K_EXISTS:
			case K_FAIL:
			case K_FULL:
			case K_FROM:
			case K_GLOB:
			case K_GROUP:
			case K_HAVING:
			case K_IF:
			case K_IGNORE:
			case K_IN:
			case K_INDEXED:
			case K_INNER:
			case K_INTERSECT:
			case K_IS:
			case K_ISNULL:
			case K_JOIN:
			case K_LEFT:
			case K_LIKE:
			case K_LIMIT:
			case K_MATCH:
			case K_NATURAL:
			case K_NO:
			case K_NOT:
			case K_NOTNULL:
			case K_NULL:
			case K_OFFSET:
			case K_ON:
			case K_OR:
			case K_ORDER:
			case K_OUTER:
			case K_RAISE:
			case K_RECURSIVE:
			case K_REGEXP:
			case K_RIGHT:
			case K_ROLLBACK:
			case K_SELECT:
			case K_THEN:
			case K_UNION:
			case K_USING:
			case K_VALUES:
			case K_WHEN:
			case K_WHERE:
			case K_WITH:
			case K_GENERATE:
			case K_MAX:
			case K_MIN:
			case K_AVG:
			case K_COUNT:
			case K_SUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(961);
				keyword();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(962);
				match(IDENTIFIER);
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

	public static class SlContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(querytestParser.STRING_LITERAL, 0); }
		public SlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterSl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitSl(this);
		}
	}

	public final SlContext sl() throws RecognitionException {
		SlContext _localctx = new SlContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_sl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(965);
			match(STRING_LITERAL);
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

	public static class Signed_numberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(querytestParser.NUMERIC_LITERAL, 0); }
		public Signed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterSigned_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitSigned_number(this);
		}
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(968);
			_la = _input.LA(1);
			if (_la==T__6 || _la==T__7) {
				{
				setState(967);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(970);
			match(NUMERIC_LITERAL);
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

	public static class Raise_functionContext extends ParserRuleContext {
		public TerminalNode K_RAISE() { return getToken(querytestParser.K_RAISE, 0); }
		public TerminalNode K_IGNORE() { return getToken(querytestParser.K_IGNORE, 0); }
		public Error_messageContext error_message() {
			return getRuleContext(Error_messageContext.class,0);
		}
		public TerminalNode K_ROLLBACK() { return getToken(querytestParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(querytestParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(querytestParser.K_FAIL, 0); }
		public Raise_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterRaise_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitRaise_function(this);
		}
	}

	public final Raise_functionContext raise_function() throws RecognitionException {
		Raise_functionContext _localctx = new Raise_functionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_raise_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(972);
			match(K_RAISE);
			setState(973);
			match(OPEN_PARENTHESE);
			setState(978);
			switch (_input.LA(1)) {
			case K_IGNORE:
				{
				setState(974);
				match(K_IGNORE);
				}
				break;
			case K_ABORT:
			case K_FAIL:
			case K_ROLLBACK:
				{
				setState(975);
				_la = _input.LA(1);
				if ( !(((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (K_ABORT - 21)) | (1L << (K_FAIL - 21)) | (1L << (K_ROLLBACK - 21)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(976);
				match(C1);
				setState(977);
				error_message();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(980);
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

	public static class Error_messageContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(querytestParser.STRING_LITERAL, 0); }
		public Error_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).enterError_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof querytestListener ) ((querytestListener)listener).exitError_message(this);
		}
	}

	public final Error_messageContext error_message() throws RecognitionException {
		Error_messageContext _localctx = new Error_messageContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_error_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(982);
			match(STRING_LITERAL);
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
		case 34:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		case 12:
			return precpred(_ctx, 7);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3r\u03db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\5\2r\n\2\3\3\3\3\5\3v\n"+
		"\3\3\3\5\3y\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0085\n\5"+
		"\3\5\3\5\3\5\5\5\u008a\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0093\n\5\3"+
		"\5\3\5\7\5\u0097\n\5\f\5\16\5\u009a\13\5\3\5\5\5\u009d\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00ae\n\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b8\n\7\3\7\3\7\5\7\u00bc\n\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u00c6\n\7\3\7\3\7\5\7\u00ca\n\7\5\7\u00cc\n"+
		"\7\3\b\3\b\3\t\3\t\3\t\5\t\u00d3\n\t\3\n\3\n\3\n\3\n\5\n\u00d9\n\n\7\n"+
		"\u00db\n\n\f\n\16\n\u00de\13\n\3\13\3\13\5\13\u00e2\n\13\3\13\3\13\3\13"+
		"\5\13\u00e7\n\13\7\13\u00e9\n\13\f\13\16\13\u00ec\13\13\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00f8\n\r\3\16\5\16\u00fb\n\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u0102\n\16\3\16\3\16\3\16\3\16\5\16\u0108\n\16\7"+
		"\16\u010a\n\16\f\16\16\16\u010d\13\16\7\16\u010f\n\16\f\16\16\16\u0112"+
		"\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u011c\n\17\3\17\3"+
		"\17\3\17\3\17\5\17\u0122\n\17\7\17\u0124\n\17\f\17\16\17\u0127\13\17\7"+
		"\17\u0129\n\17\f\17\16\17\u012c\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\5\20\u0135\n\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u0150\n\21\3\22\3\22\5\22\u0154\n\22\3\23\3\23\3\23\3\24\3"+
		"\24\6\24\u015b\n\24\r\24\16\24\u015c\3\24\7\24\u0160\n\24\f\24\16\24\u0163"+
		"\13\24\3\24\7\24\u0166\n\24\f\24\16\24\u0169\13\24\3\25\3\25\5\25\u016d"+
		"\n\25\3\26\3\26\5\26\u0171\n\26\3\26\3\26\3\26\7\26\u0176\n\26\f\26\16"+
		"\26\u0179\13\26\5\26\u017b\n\26\3\26\3\26\3\26\3\26\7\26\u0181\n\26\f"+
		"\26\16\26\u0184\13\26\3\26\3\26\3\26\3\26\3\26\7\26\u018b\n\26\f\26\16"+
		"\26\u018e\13\26\5\26\u0190\n\26\3\26\3\26\3\26\3\26\5\26\u0196\n\26\5"+
		"\26\u0198\n\26\3\27\3\27\5\27\u019c\n\27\3\27\3\27\3\27\7\27\u01a1\n\27"+
		"\f\27\16\27\u01a4\13\27\5\27\u01a6\n\27\3\27\3\27\3\27\3\27\7\27\u01ac"+
		"\n\27\f\27\16\27\u01af\13\27\3\27\5\27\u01b2\n\27\3\27\5\27\u01b5\n\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u01bf\n\30\f\30\16\30\u01c2"+
		"\13\30\3\30\3\30\5\30\u01c6\n\30\5\30\u01c8\n\30\3\30\3\30\3\30\3\30\3"+
		"\30\7\30\u01cf\n\30\f\30\16\30\u01d2\13\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\7\30\u01da\n\30\f\30\16\30\u01dd\13\30\3\30\3\30\7\30\u01e1\n\30\f"+
		"\30\16\30\u01e4\13\30\5\30\u01e6\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\5\31\u01ef\n\31\3\31\5\31\u01f2\n\31\5\31\u01f4\n\31\3\32\3\32\3\32"+
		"\5\32\u01f9\n\32\3\32\3\32\5\32\u01fd\n\32\3\32\5\32\u0200\n\32\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u0207\n\32\3\32\3\32\3\32\3\32\7\32\u020d\n\32"+
		"\f\32\16\32\u0210\13\32\3\32\5\32\u0213\n\32\3\32\3\32\5\32\u0217\n\32"+
		"\3\32\5\32\u021a\n\32\3\32\3\32\3\32\3\32\5\32\u0220\n\32\3\32\5\32\u0223"+
		"\n\32\5\32\u0225\n\32\3\33\3\33\3\34\3\34\5\34\u022b\n\34\3\34\3\34\3"+
		"\34\7\34\u0230\n\34\f\34\16\34\u0233\13\34\5\34\u0235\n\34\3\34\3\34\3"+
		"\34\3\34\7\34\u023b\n\34\f\34\16\34\u023e\13\34\3\34\3\34\3\34\3\34\3"+
		"\34\7\34\u0245\n\34\f\34\16\34\u0248\13\34\5\34\u024a\n\34\3\34\3\34\3"+
		"\34\3\34\5\34\u0250\n\34\5\34\u0252\n\34\3\35\3\35\5\35\u0256\n\35\3\35"+
		"\3\35\3\35\7\35\u025b\n\35\f\35\16\35\u025e\13\35\5\35\u0260\n\35\3\35"+
		"\3\35\3\35\3\35\7\35\u0266\n\35\f\35\16\35\u0269\13\35\3\35\5\35\u026c"+
		"\n\35\3\35\3\35\5\35\u0270\n\35\3\35\3\35\3\35\3\35\3\35\7\35\u0277\n"+
		"\35\f\35\16\35\u027a\13\35\3\35\3\35\5\35\u027e\n\35\5\35\u0280\n\35\3"+
		"\35\3\35\3\35\3\35\3\35\7\35\u0287\n\35\f\35\16\35\u028a\13\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\7\35\u0292\n\35\f\35\16\35\u0295\13\35\3\35\3"+
		"\35\7\35\u0299\n\35\f\35\16\35\u029c\13\35\5\35\u029e\n\35\3\36\3\36\3"+
		"\36\3\36\3\36\5\36\u02a5\n\36\3\37\3\37\3\37\3\37\5\37\u02ab\n\37\3\37"+
		"\3\37\7\37\u02af\n\37\f\37\16\37\u02b2\13\37\3 \3 \5 \u02b6\n \3 \3 \5"+
		" \u02ba\n \3 \3 \5 \u02be\n \3 \3 \5 \u02c2\n \3 \3 \5 \u02c6\n \3 \5"+
		" \u02c9\n \3!\3!\3!\3!\3!\3!\3!\7!\u02d2\n!\f!\16!\u02d5\13!\3!\3!\5!"+
		"\u02d9\n!\3\"\3\"\3\"\3\"\3\"\7\"\u02e0\n\"\f\"\16\"\u02e3\13\"\3\"\3"+
		"\"\5\"\u02e7\n\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\5#\u02f1\n#\3#\5#\u02f4"+
		"\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u02ff\n$\3$\3$\3$\5$\u0304\n$\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0313\n$\3$\5$\u0316\n$\3$\3$\3$"+
		"\3$\3$\3$\5$\u031e\n$\3$\3$\3$\3$\3$\6$\u0325\n$\r$\16$\u0326\3$\3$\5"+
		"$\u032b\n$\3$\3$\3$\5$\u0330\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u034e\n$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\5$\u035a\n$\3$\3$\3$\5$\u035f\n$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\5$\u036b\n$\3$\3$\3$\3$\5$\u0371\n$\3$\3$\3$\3$\3$\5$\u0378"+
		"\n$\3$\3$\5$\u037c\n$\3$\3$\3$\3$\3$\3$\7$\u0384\n$\f$\16$\u0387\13$\5"+
		"$\u0389\n$\3$\3$\3$\3$\5$\u038f\n$\3$\5$\u0392\n$\7$\u0394\n$\f$\16$\u0397"+
		"\13$\3%\3%\3&\3&\3\'\3\'\3(\6(\u03a0\n(\r(\16(\u03a1\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\5(\u03ae\n(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3"+
		"\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\5\63\u03c6\n\63\3\64\3\64\3\65"+
		"\5\65\u03cb\n\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u03d5\n"+
		"\66\3\66\3\66\3\67\3\67\3\67\2\3F8\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjl\2\20\4\2EE^^\4\2"+
		"\31\31\'\'\4\2\27\27\31\\\4\2\34\34&&\4\2\7\b``\3\2\t\n\4\2\5\5\13\r\3"+
		"\2\16\21\6\2\60\60==??LL\6\2#%DDjknn\5\2\t\n\26\26BB\3\2X\\\3\2mn\5\2"+
		"\27\27--NN\u0460\2n\3\2\2\2\4u\3\2\2\2\6z\3\2\2\2\b\u0092\3\2\2\2\n\u00ad"+
		"\3\2\2\2\f\u00cb\3\2\2\2\16\u00cd\3\2\2\2\20\u00cf\3\2\2\2\22\u00d4\3"+
		"\2\2\2\24\u00e1\3\2\2\2\26\u00ed\3\2\2\2\30\u00f7\3\2\2\2\32\u00fa\3\2"+
		"\2\2\34\u0115\3\2\2\2\36\u012f\3\2\2\2 \u014f\3\2\2\2\"\u0153\3\2\2\2"+
		"$\u0155\3\2\2\2&\u0158\3\2\2\2(\u016c\3\2\2\2*\u017a\3\2\2\2,\u01a5\3"+
		"\2\2\2.\u01e5\3\2\2\2\60\u01f3\3\2\2\2\62\u0224\3\2\2\2\64\u0226\3\2\2"+
		"\2\66\u0234\3\2\2\28\u029d\3\2\2\2:\u02a4\3\2\2\2<\u02a6\3\2\2\2>\u02c8"+
		"\3\2\2\2@\u02d8\3\2\2\2B\u02da\3\2\2\2D\u02ed\3\2\2\2F\u032f\3\2\2\2H"+
		"\u0398\3\2\2\2J\u039a\3\2\2\2L\u039c\3\2\2\2N\u039f\3\2\2\2P\u03af\3\2"+
		"\2\2R\u03b1\3\2\2\2T\u03b3\3\2\2\2V\u03b5\3\2\2\2X\u03b7\3\2\2\2Z\u03b9"+
		"\3\2\2\2\\\u03bb\3\2\2\2^\u03bd\3\2\2\2`\u03bf\3\2\2\2b\u03c1\3\2\2\2"+
		"d\u03c5\3\2\2\2f\u03c7\3\2\2\2h\u03ca\3\2\2\2j\u03ce\3\2\2\2l\u03d8\3"+
		"\2\2\2no\5\6\4\2oq\5\4\3\2pr\5\"\22\2qp\3\2\2\2qr\3\2\2\2r\3\3\2\2\2s"+
		"v\5\b\5\2tv\5\16\b\2us\3\2\2\2ut\3\2\2\2vx\3\2\2\2wy\7i\2\2xw\3\2\2\2"+
		"xy\3\2\2\2y\5\3\2\2\2z{\7W\2\2{|\7m\2\2|\7\3\2\2\2}\u0093\5\32\16\2~\u0093"+
		"\5\34\17\2\177\u0080\7f\2\2\u0080\u0081\5\16\b\2\u0081\u0082\7g\2\2\u0082"+
		"\u0093\3\2\2\2\u0083\u0085\5\30\r\2\u0084\u0083\3\2\2\2\u0084\u0085\3"+
		"\2\2\2\u0085\u0089\3\2\2\2\u0086\u0087\5`\61\2\u0087\u0088\7a\2\2\u0088"+
		"\u008a\3\2\2\2\u0089\u0086\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\u0093\5^\60\2\u008c\u0093\5\n\6\2\u008d\u0093\5\f\7\2\u008e"+
		"\u0093\5 \21\2\u008f\u0093\5f\64\2\u0090\u0093\7j\2\2\u0091\u0093\5\36"+
		"\20\2\u0092}\3\2\2\2\u0092~\3\2\2\2\u0092\177\3\2\2\2\u0092\u0084\3\2"+
		"\2\2\u0092\u008c\3\2\2\2\u0092\u008d\3\2\2\2\u0092\u008e\3\2\2\2\u0092"+
		"\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\u0098\3\2"+
		"\2\2\u0094\u0095\7\3\2\2\u0095\u0097\5\b\5\2\u0096\u0094\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009c\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009b\u009d\7i\2\2\u009c\u009b\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\t\3\2\2\2\u009e\u009f\7d\2\2\u009f\u00a0\5\16\b\2"+
		"\u00a0\u00a1\7e\2\2\u00a1\u00a2\7^\2\2\u00a2\u00ae\3\2\2\2\u00a3\u00a4"+
		"\7d\2\2\u00a4\u00a5\5\16\b\2\u00a5\u00a6\7e\2\2\u00a6\u00a7\7_\2\2\u00a7"+
		"\u00ae\3\2\2\2\u00a8\u00a9\7d\2\2\u00a9\u00aa\5\16\b\2\u00aa\u00ab\7e"+
		"\2\2\u00ab\u00ac\7`\2\2\u00ac\u00ae\3\2\2\2\u00ad\u009e\3\2\2\2\u00ad"+
		"\u00a3\3\2\2\2\u00ad\u00a8\3\2\2\2\u00ae\13\3\2\2\2\u00af\u00b0\7d\2\2"+
		"\u00b0\u00b1\5\16\b\2\u00b1\u00b2\7e\2\2\u00b2\u00bb\7^\2\2\u00b3\u00b4"+
		"\7j\2\2\u00b4\u00b7\7_\2\2\u00b5\u00b6\7j\2\2\u00b6\u00b8\7`\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bc\3\2\2\2\u00b9\u00ba\7j"+
		"\2\2\u00ba\u00bc\7`\2\2\u00bb\u00b3\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc"+
		"\u00cc\3\2\2\2\u00bd\u00be\7d\2\2\u00be\u00bf\5\16\b\2\u00bf\u00c0\7e"+
		"\2\2\u00c0\u00c9\7_\2\2\u00c1\u00c2\7j\2\2\u00c2\u00c5\7^\2\2\u00c3\u00c4"+
		"\7j\2\2\u00c4\u00c6\7`\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00ca\3\2\2\2\u00c7\u00c8\7j\2\2\u00c8\u00ca\7`\2\2\u00c9\u00c1\3\2\2"+
		"\2\u00c9\u00c7\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00af\3\2\2\2\u00cb\u00bd"+
		"\3\2\2\2\u00cc\r\3\2\2\2\u00cd\u00ce\5\20\t\2\u00ce\17\3\2\2\2\u00cf\u00d2"+
		"\5\22\n\2\u00d0\u00d1\7`\2\2\u00d1\u00d3\5\b\5\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\21\3\2\2\2\u00d4\u00dc\5\24\13\2\u00d5\u00d8\7_\2"+
		"\2\u00d6\u00d9\5\24\13\2\u00d7\u00d9\5\b\5\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d5\3\2\2\2\u00db\u00de\3\2"+
		"\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\23\3\2\2\2\u00de\u00dc"+
		"\3\2\2\2\u00df\u00e2\5\b\5\2\u00e0\u00e2\5\26\f\2\u00e1\u00df\3\2\2\2"+
		"\u00e1\u00e0\3\2\2\2\u00e2\u00ea\3\2\2\2\u00e3\u00e6\7^\2\2\u00e4\u00e7"+
		"\5\b\5\2\u00e5\u00e7\5\26\f\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2"+
		"\u00e7\u00e9\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\25\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed"+
		"\u00ee\5\b\5\2\u00ee\u00ef\7]\2\2\u00ef\u00f0\5\b\5\2\u00f0\27\3\2\2\2"+
		"\u00f1\u00f2\7b\2\2\u00f2\u00f3\7\34\2\2\u00f3\u00f8\7c\2\2\u00f4\u00f5"+
		"\7b\2\2\u00f5\u00f6\7&\2\2\u00f6\u00f8\7c\2\2\u00f7\u00f1\3\2\2\2\u00f7"+
		"\u00f4\3\2\2\2\u00f8\31\3\2\2\2\u00f9\u00fb\7\4\2\2\u00fa\u00f9\3\2\2"+
		"\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\5P)\2\u00fd\u0110"+
		"\7b\2\2\u00fe\u0102\5\b\5\2\u00ff\u0102\5\16\b\2\u0100\u0102\5F$\2\u0101"+
		"\u00fe\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102\u010b\3\2"+
		"\2\2\u0103\u0107\7^\2\2\u0104\u0108\5\b\5\2\u0105\u0108\5\16\b\2\u0106"+
		"\u0108\5F$\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2"+
		"\2\u0108\u010a\3\2\2\2\u0109\u0103\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109"+
		"\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010e"+
		"\u0101\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111\u0113\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0114\7c\2\2\u0114"+
		"\33\3\2\2\2\u0115\u0116\7\5\2\2\u0116\u0117\5P)\2\u0117\u012a\7b\2\2\u0118"+
		"\u011c\5\b\5\2\u0119\u011c\5\16\b\2\u011a\u011c\5F$\2\u011b\u0118\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2\2\u011c\u0125\3\2\2\2\u011d"+
		"\u0121\7^\2\2\u011e\u0122\5\b\5\2\u011f\u0122\5\16\b\2\u0120\u0122\5F"+
		"$\2\u0121\u011e\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2\u0122"+
		"\u0124\3\2\2\2\u0123\u011d\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0128"+
		"\u011b\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7c\2\2\u012e"+
		"\35\3\2\2\2\u012f\u0130\5R*\2\u0130\u0134\7d\2\2\u0131\u0132\5`\61\2\u0132"+
		"\u0133\7a\2\2\u0133\u0135\3\2\2\2\u0134\u0131\3\2\2\2\u0134\u0135\3\2"+
		"\2\2\u0135\u0136\3\2\2\2\u0136\u0137\5^\60\2\u0137\u0138\3\2\2\2\u0138"+
		"\u0139\7e\2\2\u0139\37\3\2\2\2\u013a\u013b\7\63\2\2\u013b\u013c\7b\2\2"+
		"\u013c\u013d\5F$\2\u013d\u013e\7c\2\2\u013e\u013f\7P\2\2\u013f\u0140\7"+
		"b\2\2\u0140\u0141\5\16\b\2\u0141\u0142\7c\2\2\u0142\u0143\7(\2\2\u0143"+
		"\u0144\7b\2\2\u0144\u0145\5\16\b\2\u0145\u0146\7c\2\2\u0146\u0150\3\2"+
		"\2\2\u0147\u0148\7b\2\2\u0148\u0149\5F$\2\u0149\u014a\7c\2\2\u014a\u014b"+
		"\7]\2\2\u014b\u014c\5\16\b\2\u014c\u014d\7\6\2\2\u014d\u014e\5\16\b\2"+
		"\u014e\u0150\3\2\2\2\u014f\u013a\3\2\2\2\u014f\u0147\3\2\2\2\u0150!\3"+
		"\2\2\2\u0151\u0154\5&\24\2\u0152\u0154\5$\23\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0152\3\2\2\2\u0154#\3\2\2\2\u0155\u0156\7r\2\2\u0156\u0157\b\23\1\2"+
		"\u0157%\3\2\2\2\u0158\u0161\5(\25\2\u0159\u015b\7h\2\2\u015a\u0159\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u0160\5(\25\2\u015f\u015a\3\2\2\2\u0160\u0163\3\2"+
		"\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0167\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0164\u0166\7h\2\2\u0165\u0164\3\2\2\2\u0166\u0169\3\2"+
		"\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\'\3\2\2\2\u0169\u0167"+
		"\3\2\2\2\u016a\u016d\5*\26\2\u016b\u016d\5\66\34\2\u016c\u016a\3\2\2\2"+
		"\u016c\u016b\3\2\2\2\u016d)\3\2\2\2\u016e\u0170\7V\2\2\u016f\u0171\7K"+
		"\2\2\u0170\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0177\5B\"\2\u0173\u0174\7^\2\2\u0174\u0176\5B\"\2\u0175\u0173\3\2\2"+
		"\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017b"+
		"\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u016e\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u0182\5,\27\2\u017d\u017e\5:\36\2\u017e\u017f\5,"+
		"\27\2\u017f\u0181\3\2\2\2\u0180\u017d\3\2\2\2\u0181\u0184\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u018f\3\2\2\2\u0184\u0182\3\2"+
		"\2\2\u0185\u0186\7H\2\2\u0186\u0187\7\36\2\2\u0187\u018c\5D#\2\u0188\u0189"+
		"\7^\2\2\u0189\u018b\5D#\2\u018a\u0188\3\2\2\2\u018b\u018e\3\2\2\2\u018c"+
		"\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2"+
		"\2\2\u018f\u0185\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0197\3\2\2\2\u0191"+
		"\u0192\7>\2\2\u0192\u0195\5F$\2\u0193\u0194\t\2\2\2\u0194\u0196\5F$\2"+
		"\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u0191"+
		"\3\2\2\2\u0197\u0198\3\2\2\2\u0198+\3\2\2\2\u0199\u019b\7O\2\2\u019a\u019c"+
		"\t\3\2\2\u019b\u019a\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019d\3\2\2\2\u019d"+
		"\u01a2\5\60\31\2\u019e\u019f\7^\2\2\u019f\u01a1\5\60\31\2\u01a0\u019e"+
		"\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u0199\3\2\2\2\u01a5\u01a6\3\2"+
		"\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01b1\7/\2\2\u01a8\u01ad\5\62\32\2\u01a9"+
		"\u01aa\7^\2\2\u01aa\u01ac\5\62\32\2\u01ab\u01a9\3\2\2\2\u01ac\u01af\3"+
		"\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b2\3\2\2\2\u01af"+
		"\u01ad\3\2\2\2\u01b0\u01b2\5<\37\2\u01b1\u01a8\3\2\2\2\u01b1\u01b0\3\2"+
		"\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01b5\5.\30\2\u01b4\u01b3\3\2\2\2\u01b4"+
		"\u01b5\3\2\2\2\u01b5-\3\2\2\2\u01b6\u01b7\7U\2\2\u01b7\u01b8\5F$\2\u01b8"+
		"\u01c7\3\2\2\2\u01b9\u01ba\7\61\2\2\u01ba\u01bb\7\36\2\2\u01bb\u01c0\5"+
		"F$\2\u01bc\u01bd\7^\2\2\u01bd\u01bf\5F$\2\u01be\u01bc\3\2\2\2\u01bf\u01c2"+
		"\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c5\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c3\u01c4\7\62\2\2\u01c4\u01c6\5F$\2\u01c5\u01c3\3\2"+
		"\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01b9\3\2\2\2\u01c7"+
		"\u01c8\3\2\2\2\u01c8\u01e6\3\2\2\2\u01c9\u01ca\7S\2\2\u01ca\u01cb\7b\2"+
		"\2\u01cb\u01d0\5F$\2\u01cc\u01cd\7^\2\2\u01cd\u01cf\5F$\2\u01ce\u01cc"+
		"\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"\u01d3\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01e2\7c\2\2\u01d4\u01d5\7^\2"+
		"\2\u01d5\u01d6\7b\2\2\u01d6\u01db\5F$\2\u01d7\u01d8\7^\2\2\u01d8\u01da"+
		"\5F$\2\u01d9\u01d7\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01df\7c"+
		"\2\2\u01df\u01e1\3\2\2\2\u01e0\u01d4\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2"+
		"\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2"+
		"\2\2\u01e5\u01b6\3\2\2\2\u01e5\u01c9\3\2\2\2\u01e6/\3\2\2\2\u01e7\u01f4"+
		"\7\7\2\2\u01e8\u01e9\5Z.\2\u01e9\u01ea\7a\2\2\u01ea\u01eb\7\7\2\2\u01eb"+
		"\u01f4\3\2\2\2\u01ec\u01f1\5F$\2\u01ed\u01ef\7\33\2\2\u01ee\u01ed\3\2"+
		"\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f2\5\\/\2\u01f1"+
		"\u01ee\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01e7\3\2"+
		"\2\2\u01f3\u01e8\3\2\2\2\u01f3\u01ec\3\2\2\2\u01f4\61\3\2\2\2\u01f5\u01f6"+
		"\5X-\2\u01f6\u01f7\7a\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01f5\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01ff\5Z.\2\u01fb\u01fd\7\33"+
		"\2\2\u01fc\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe"+
		"\u0200\5`\61\2\u01ff\u01fc\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0206\3\2"+
		"\2\2\u0201\u0202\7\66\2\2\u0202\u0203\7\36\2\2\u0203\u0207\5b\62\2\u0204"+
		"\u0205\7B\2\2\u0205\u0207\7\66\2\2\u0206\u0201\3\2\2\2\u0206\u0204\3\2"+
		"\2\2\u0206\u0207\3\2\2\2\u0207\u0225\3\2\2\2\u0208\u0212\7b\2\2\u0209"+
		"\u020e\5\62\32\2\u020a\u020b\7^\2\2\u020b\u020d\5\62\32\2\u020c\u020a"+
		"\3\2\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f"+
		"\u0213\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0213\5<\37\2\u0212\u0209\3\2"+
		"\2\2\u0212\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0219\7c\2\2\u0215"+
		"\u0217\7\33\2\2\u0216\u0215\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\3"+
		"\2\2\2\u0218\u021a\5`\61\2\u0219\u0216\3\2\2\2\u0219\u021a\3\2\2\2\u021a"+
		"\u0225\3\2\2\2\u021b\u021c\7b\2\2\u021c\u021d\5\66\34\2\u021d\u0222\7"+
		"c\2\2\u021e\u0220\7\33\2\2\u021f\u021e\3\2\2\2\u021f\u0220\3\2\2\2\u0220"+
		"\u0221\3\2\2\2\u0221\u0223\5`\61\2\u0222\u021f\3\2\2\2\u0222\u0223\3\2"+
		"\2\2\u0223\u0225\3\2\2\2\u0224\u01f8\3\2\2\2\u0224\u0208\3\2\2\2\u0224"+
		"\u021b\3\2\2\2\u0225\63\3\2\2\2\u0226\u0227\t\4\2\2\u0227\65\3\2\2\2\u0228"+
		"\u022a\7V\2\2\u0229\u022b\7K\2\2\u022a\u0229\3\2\2\2\u022a\u022b\3\2\2"+
		"\2\u022b\u022c\3\2\2\2\u022c\u0231\5B\"\2\u022d\u022e\7^\2\2\u022e\u0230"+
		"\5B\"\2\u022f\u022d\3\2\2\2\u0230\u0233\3\2\2\2\u0231\u022f\3\2\2\2\u0231"+
		"\u0232\3\2\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0234\u0228\3\2"+
		"\2\2\u0234\u0235\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u023c\58\35\2\u0237"+
		"\u0238\5:\36\2\u0238\u0239\58\35\2\u0239\u023b\3\2\2\2\u023a\u0237\3\2"+
		"\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3\2\2\2\u023c\u023d\3\2\2\2\u023d"+
		"\u0249\3\2\2\2\u023e\u023c\3\2\2\2\u023f\u0240\7H\2\2\u0240\u0241\7\36"+
		"\2\2\u0241\u0246\5D#\2\u0242\u0243\7^\2\2\u0243\u0245\5D#\2\u0244\u0242"+
		"\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247"+
		"\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0249\u023f\3\2\2\2\u0249\u024a\3\2"+
		"\2\2\u024a\u0251\3\2\2\2\u024b\u024c\7>\2\2\u024c\u024f\5F$\2\u024d\u024e"+
		"\t\2\2\2\u024e\u0250\5F$\2\u024f\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250"+
		"\u0252\3\2\2\2\u0251\u024b\3\2\2\2\u0251\u0252\3\2\2\2\u0252\67\3\2\2"+
		"\2\u0253\u0255\7O\2\2\u0254\u0256\t\3\2\2\u0255\u0254\3\2\2\2\u0255\u0256"+
		"\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u025c\5\60\31\2\u0258\u0259\7^\2\2"+
		"\u0259\u025b\5\60\31\2\u025a\u0258\3\2\2\2\u025b\u025e\3\2\2\2\u025c\u025a"+
		"\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u0260\3\2\2\2\u025e\u025c\3\2\2\2\u025f"+
		"\u0253\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u026b\7/"+
		"\2\2\u0262\u0267\5\62\32\2\u0263\u0264\7^\2\2\u0264\u0266\5\62\32\2\u0265"+
		"\u0263\3\2\2\2\u0266\u0269\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2"+
		"\2\2\u0268\u026c\3\2\2\2\u0269\u0267\3\2\2\2\u026a\u026c\5<\37\2\u026b"+
		"\u0262\3\2\2\2\u026b\u026a\3\2\2\2\u026c\u026f\3\2\2\2\u026d\u026e\7U"+
		"\2\2\u026e\u0270\5F$\2\u026f\u026d\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u027f"+
		"\3\2\2\2\u0271\u0272\7\61\2\2\u0272\u0273\7\36\2\2\u0273\u0278\5F$\2\u0274"+
		"\u0275\7^\2\2\u0275\u0277\5F$\2\u0276\u0274\3\2\2\2\u0277\u027a\3\2\2"+
		"\2\u0278\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027d\3\2\2\2\u027a\u0278"+
		"\3\2\2\2\u027b\u027c\7\62\2\2\u027c\u027e\5F$\2\u027d\u027b\3\2\2\2\u027d"+
		"\u027e\3\2\2\2\u027e\u0280\3\2\2\2\u027f\u0271\3\2\2\2\u027f\u0280\3\2"+
		"\2\2\u0280\u029e\3\2\2\2\u0281\u0282\7S\2\2\u0282\u0283\7b\2\2\u0283\u0288"+
		"\5F$\2\u0284\u0285\7^\2\2\u0285\u0287\5F$\2\u0286\u0284\3\2\2\2\u0287"+
		"\u028a\3\2\2\2\u0288\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028b\3\2"+
		"\2\2\u028a\u0288\3\2\2\2\u028b\u029a\7c\2\2\u028c\u028d\7^\2\2\u028d\u028e"+
		"\7b\2\2\u028e\u0293\5F$\2\u028f\u0290\7^\2\2\u0290\u0292\5F$\2\u0291\u028f"+
		"\3\2\2\2\u0292\u0295\3\2\2\2\u0293\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294"+
		"\u0296\3\2\2\2\u0295\u0293\3\2\2\2\u0296\u0297\7c\2\2\u0297\u0299\3\2"+
		"\2\2\u0298\u028c\3\2\2\2\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029a"+
		"\u029b\3\2\2\2\u029b\u029e\3\2\2\2\u029c\u029a\3\2\2\2\u029d\u025f\3\2"+
		"\2\2\u029d\u0281\3\2\2\2\u029e9\3\2\2\2\u029f\u02a5\7Q\2\2\u02a0\u02a1"+
		"\7Q\2\2\u02a1\u02a5\7\31\2\2\u02a2\u02a5\78\2\2\u02a3\u02a5\7+\2\2\u02a4"+
		"\u029f\3\2\2\2\u02a4\u02a0\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a3\3\2"+
		"\2\2\u02a5;\3\2\2\2\u02a6\u02b0\5\62\32\2\u02a7\u02aa\5> \2\u02a8\u02ab"+
		"\5<\37\2\u02a9\u02ab\5\62\32\2\u02aa\u02a8\3\2\2\2\u02aa\u02a9\3\2\2\2"+
		"\u02ab\u02ac\3\2\2\2\u02ac\u02ad\5@!\2\u02ad\u02af\3\2\2\2\u02ae\u02a7"+
		"\3\2\2\2\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1"+
		"=\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b3\u02c9\7^\2\2\u02b4\u02b6\7@\2\2\u02b5"+
		"\u02b4\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02c5\3\2\2\2\u02b7\u02b9\7<"+
		"\2\2\u02b8\u02ba\7I\2\2\u02b9\u02b8\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba"+
		"\u02c6\3\2\2\2\u02bb\u02bd\7M\2\2\u02bc\u02be\7I\2\2\u02bd\u02bc\3\2\2"+
		"\2\u02bd\u02be\3\2\2\2\u02be\u02c6\3\2\2\2\u02bf\u02c1\7.\2\2\u02c0\u02c2"+
		"\7I\2\2\u02c1\u02c0\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c6\3\2\2\2\u02c3"+
		"\u02c6\7\67\2\2\u02c4\u02c6\7\"\2\2\u02c5\u02b7\3\2\2\2\u02c5\u02bb\3"+
		"\2\2\2\u02c5\u02bf\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c4\3\2\2\2\u02c5"+
		"\u02c6\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c9\7;\2\2\u02c8\u02b3\3\2"+
		"\2\2\u02c8\u02b5\3\2\2\2\u02c9?\3\2\2\2\u02ca\u02cb\7F\2\2\u02cb\u02d9"+
		"\5F$\2\u02cc\u02cd\7R\2\2\u02cd\u02ce\7b\2\2\u02ce\u02d3\5^\60\2\u02cf"+
		"\u02d0\7^\2\2\u02d0\u02d2\5^\60\2\u02d1\u02cf\3\2\2\2\u02d2\u02d5\3\2"+
		"\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02d6\3\2\2\2\u02d5"+
		"\u02d3\3\2\2\2\u02d6\u02d7\7c\2\2\u02d7\u02d9\3\2\2\2\u02d8\u02ca\3\2"+
		"\2\2\u02d8\u02cc\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9A\3\2\2\2\u02da\u02e6"+
		"\5Z.\2\u02db\u02dc\7b\2\2\u02dc\u02e1\5^\60\2\u02dd\u02de\7^\2\2\u02de"+
		"\u02e0\5^\60\2\u02df\u02dd\3\2\2\2\u02e0\u02e3\3\2\2\2\u02e1\u02df\3\2"+
		"\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e4\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e4"+
		"\u02e5\7c\2\2\u02e5\u02e7\3\2\2\2\u02e6\u02db\3\2\2\2\u02e6\u02e7\3\2"+
		"\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02e9\7\33\2\2\u02e9\u02ea\7b\2\2\u02ea"+
		"\u02eb\5\66\34\2\u02eb\u02ec\7c\2\2\u02ecC\3\2\2\2\u02ed\u02f0\5F$\2\u02ee"+
		"\u02ef\7!\2\2\u02ef\u02f1\5V,\2\u02f0\u02ee\3\2\2\2\u02f0\u02f1\3\2\2"+
		"\2\u02f1\u02f3\3\2\2\2\u02f2\u02f4\t\5\2\2\u02f3\u02f2\3\2\2\2\u02f3\u02f4"+
		"\3\2\2\2\u02f4E\3\2\2\2\u02f5\u02f6\b$\1\2\u02f6\u02f7\5J&\2\u02f7\u02f8"+
		"\5F$\26\u02f8\u0330\3\2\2\2\u02f9\u0330\5\b\5\2\u02fa\u0330\7l\2\2\u02fb"+
		"\u02fc\5X-\2\u02fc\u02fd\7a\2\2\u02fd\u02ff\3\2\2\2\u02fe\u02fb\3\2\2"+
		"\2\u02fe\u02ff\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u0301\5`\61\2\u0301\u0302"+
		"\7a\2\2\u0302\u0304\3\2\2\2\u0303\u02fe\3\2\2\2\u0303\u0304\3\2\2\2\u0304"+
		"\u0305\3\2\2\2\u0305\u0330\5^\60\2\u0306\u0307\7b\2\2\u0307\u0308\5F$"+
		"\2\u0308\u0309\7c\2\2\u0309\u0330\3\2\2\2\u030a\u030b\7 \2\2\u030b\u030c"+
		"\7b\2\2\u030c\u030d\5F$\2\u030d\u030e\7\33\2\2\u030e\u030f\5N(\2\u030f"+
		"\u0310\7c\2\2\u0310\u0330\3\2\2\2\u0311\u0313\7B\2\2\u0312\u0311\3\2\2"+
		"\2\u0312\u0313\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0316\7,\2\2\u0315\u0312"+
		"\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0318\7b\2\2\u0318"+
		"\u0319\5\66\34\2\u0319\u031a\7c\2\2\u031a\u0330\3\2\2\2\u031b\u031d\7"+
		"\37\2\2\u031c\u031e\5F$\2\u031d\u031c\3\2\2\2\u031d\u031e\3\2\2\2\u031e"+
		"\u0324\3\2\2\2\u031f\u0320\7T\2\2\u0320\u0321\5F$\2\u0321\u0322\7P\2\2"+
		"\u0322\u0323\5F$\2\u0323\u0325\3\2\2\2\u0324\u031f\3\2\2\2\u0325\u0326"+
		"\3\2\2\2\u0326\u0324\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u032a\3\2\2\2\u0328"+
		"\u0329\7(\2\2\u0329\u032b\5F$\2\u032a\u0328\3\2\2\2\u032a\u032b\3\2\2"+
		"\2\u032b\u032c\3\2\2\2\u032c\u032d\7)\2\2\u032d\u0330\3\2\2\2\u032e\u0330"+
		"\5j\66\2\u032f\u02f5\3\2\2\2\u032f\u02f9\3\2\2\2\u032f\u02fa\3\2\2\2\u032f"+
		"\u0303\3\2\2\2\u032f\u0306\3\2\2\2\u032f\u030a\3\2\2\2\u032f\u0315\3\2"+
		"\2\2\u032f\u031b\3\2\2\2\u032f\u032e\3\2\2\2\u0330\u0395\3\2\2\2\u0331"+
		"\u0332\f\25\2\2\u0332\u0333\7\3\2\2\u0333\u0394\5F$\26\u0334\u0335\f\24"+
		"\2\2\u0335\u0336\t\6\2\2\u0336\u0394\5F$\25\u0337\u0338\f\23\2\2\u0338"+
		"\u0339\t\7\2\2\u0339\u0394\5F$\24\u033a\u033b\f\22\2\2\u033b\u033c\t\b"+
		"\2\2\u033c\u0394\5F$\23\u033d\u033e\f\21\2\2\u033e\u033f\t\t\2\2\u033f"+
		"\u0394\5F$\22\u0340\u034d\f\20\2\2\u0341\u034e\7\22\2\2\u0342\u034e\7"+
		"\23\2\2\u0343\u034e\7\24\2\2\u0344\u034e\7\25\2\2\u0345\u034e\79\2\2\u0346"+
		"\u0347\79\2\2\u0347\u034e\7B\2\2\u0348\u034e\7\65\2\2\u0349\u034e\7=\2"+
		"\2\u034a\u034e\7\60\2\2\u034b\u034e\7?\2\2\u034c\u034e\7L\2\2\u034d\u0341"+
		"\3\2\2\2\u034d\u0342\3\2\2\2\u034d\u0343\3\2\2\2\u034d\u0344\3\2\2\2\u034d"+
		"\u0345\3\2\2\2\u034d\u0346\3\2\2\2\u034d\u0348\3\2\2\2\u034d\u0349\3\2"+
		"\2\2\u034d\u034a\3\2\2\2\u034d\u034b\3\2\2\2\u034d\u034c\3\2\2\2\u034e"+
		"\u034f\3\2\2\2\u034f\u0394\5F$\21\u0350\u0351\f\17\2\2\u0351\u0352\7\32"+
		"\2\2\u0352\u0394\5F$\20\u0353\u0354\f\16\2\2\u0354\u0355\7G\2\2\u0355"+
		"\u0394\5F$\17\u0356\u0357\f\b\2\2\u0357\u0359\79\2\2\u0358\u035a\7B\2"+
		"\2\u0359\u0358\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u0394"+
		"\5F$\t\u035c\u035e\f\7\2\2\u035d\u035f\7B\2\2\u035e\u035d\3\2\2\2\u035e"+
		"\u035f\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0361\7\35\2\2\u0361\u0362\5"+
		"F$\2\u0362\u0363\7\32\2\2\u0363\u0364\5F$\b\u0364\u0394\3\2\2\2\u0365"+
		"\u0366\f\13\2\2\u0366\u0367\7!\2\2\u0367\u0394\5V,\2\u0368\u036a\f\n\2"+
		"\2\u0369\u036b\7B\2\2\u036a\u0369\3\2\2\2\u036a\u036b\3\2\2\2\u036b\u036c"+
		"\3\2\2\2\u036c\u036d\t\n\2\2\u036d\u0370\5F$\2\u036e\u036f\7*\2\2\u036f"+
		"\u0371\5F$\2\u0370\u036e\3\2\2\2\u0370\u0371\3\2\2\2\u0371\u0394\3\2\2"+
		"\2\u0372\u0377\f\t\2\2\u0373\u0378\7:\2\2\u0374\u0378\7C\2\2\u0375\u0376"+
		"\7B\2\2\u0376\u0378\7D\2\2\u0377\u0373\3\2\2\2\u0377\u0374\3\2\2\2\u0377"+
		"\u0375\3\2\2\2\u0378\u0394\3\2\2\2\u0379\u037b\f\6\2\2\u037a\u037c\7B"+
		"\2\2\u037b\u037a\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u037d\3\2\2\2\u037d"+
		"\u0391\7\65\2\2\u037e\u0388\7b\2\2\u037f\u0389\5\66\34\2\u0380\u0385\5"+
		"F$\2\u0381\u0382\7^\2\2\u0382\u0384\5F$\2\u0383\u0381\3\2\2\2\u0384\u0387"+
		"\3\2\2\2\u0385\u0383\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0389\3\2\2\2\u0387"+
		"\u0385\3\2\2\2\u0388\u037f\3\2\2\2\u0388\u0380\3\2\2\2\u0388\u0389\3\2"+
		"\2\2\u0389\u038a\3\2\2\2\u038a\u0392\7c\2\2\u038b\u038c\5X-\2\u038c\u038d"+
		"\7a\2\2\u038d\u038f\3\2\2\2\u038e\u038b\3\2\2\2\u038e\u038f\3\2\2\2\u038f"+
		"\u0390\3\2\2\2\u0390\u0392\5Z.\2\u0391\u037e\3\2\2\2\u0391\u038e\3\2\2"+
		"\2\u0392\u0394\3\2\2\2\u0393\u0331\3\2\2\2\u0393\u0334\3\2\2\2\u0393\u0337"+
		"\3\2\2\2\u0393\u033a\3\2\2\2\u0393\u033d\3\2\2\2\u0393\u0340\3\2\2\2\u0393"+
		"\u0350\3\2\2\2\u0393\u0353\3\2\2\2\u0393\u0356\3\2\2\2\u0393\u035c\3\2"+
		"\2\2\u0393\u0365\3\2\2\2\u0393\u0368\3\2\2\2\u0393\u0372\3\2\2\2\u0393"+
		"\u0379\3\2\2\2\u0394\u0397\3\2\2\2\u0395\u0393\3\2\2\2\u0395\u0396\3\2"+
		"\2\2\u0396G\3\2\2\2\u0397\u0395\3\2\2\2\u0398\u0399\t\13\2\2\u0399I\3"+
		"\2\2\2\u039a\u039b\t\f\2\2\u039bK\3\2\2\2\u039c\u039d\5d\63\2\u039dM\3"+
		"\2\2\2\u039e\u03a0\5L\'\2\u039f\u039e\3\2\2\2\u03a0\u03a1\3\2\2\2\u03a1"+
		"\u039f\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03ad\3\2\2\2\u03a3\u03a4\7b"+
		"\2\2\u03a4\u03a5\5h\65\2\u03a5\u03a6\7c\2\2\u03a6\u03ae\3\2\2\2\u03a7"+
		"\u03a8\7b\2\2\u03a8\u03a9\5h\65\2\u03a9\u03aa\7^\2\2\u03aa\u03ab\5h\65"+
		"\2\u03ab\u03ac\7c\2\2\u03ac\u03ae\3\2\2\2\u03ad\u03a3\3\2\2\2\u03ad\u03a7"+
		"\3\2\2\2\u03ad\u03ae\3\2\2\2\u03aeO\3\2\2\2\u03af\u03b0\5d\63\2\u03b0"+
		"Q\3\2\2\2\u03b1\u03b2\5T+\2\u03b2S\3\2\2\2\u03b3\u03b4\t\r\2\2\u03b4U"+
		"\3\2\2\2\u03b5\u03b6\5d\63\2\u03b6W\3\2\2\2\u03b7\u03b8\5d\63\2\u03b8"+
		"Y\3\2\2\2\u03b9\u03ba\5d\63\2\u03ba[\3\2\2\2\u03bb\u03bc\t\16\2\2\u03bc"+
		"]\3\2\2\2\u03bd\u03be\5d\63\2\u03be_\3\2\2\2\u03bf\u03c0\5d\63\2\u03c0"+
		"a\3\2\2\2\u03c1\u03c2\5d\63\2\u03c2c\3\2\2\2\u03c3\u03c6\5\64\33\2\u03c4"+
		"\u03c6\7m\2\2\u03c5\u03c3\3\2\2\2\u03c5\u03c4\3\2\2\2\u03c6e\3\2\2\2\u03c7"+
		"\u03c8\7n\2\2\u03c8g\3\2\2\2\u03c9\u03cb\t\7\2\2\u03ca\u03c9\3\2\2\2\u03ca"+
		"\u03cb\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc\u03cd\7j\2\2\u03cdi\3\2\2\2\u03ce"+
		"\u03cf\7J\2\2\u03cf\u03d4\7b\2\2\u03d0\u03d5\7\64\2\2\u03d1\u03d2\t\17"+
		"\2\2\u03d2\u03d3\7^\2\2\u03d3\u03d5\5l\67\2\u03d4\u03d0\3\2\2\2\u03d4"+
		"\u03d1\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6\u03d7\7c\2\2\u03d7k\3\2\2\2\u03d8"+
		"\u03d9\7n\2\2\u03d9m\3\2\2\2\u0088qux\u0084\u0089\u0092\u0098\u009c\u00ad"+
		"\u00b7\u00bb\u00c5\u00c9\u00cb\u00d2\u00d8\u00dc\u00e1\u00e6\u00ea\u00f7"+
		"\u00fa\u0101\u0107\u010b\u0110\u011b\u0121\u0125\u012a\u0134\u014f\u0153"+
		"\u015c\u0161\u0167\u016c\u0170\u0177\u017a\u0182\u018c\u018f\u0195\u0197"+
		"\u019b\u01a2\u01a5\u01ad\u01b1\u01b4\u01c0\u01c5\u01c7\u01d0\u01db\u01e2"+
		"\u01e5\u01ee\u01f1\u01f3\u01f8\u01fc\u01ff\u0206\u020e\u0212\u0216\u0219"+
		"\u021f\u0222\u0224\u022a\u0231\u0234\u023c\u0246\u0249\u024f\u0251\u0255"+
		"\u025c\u025f\u0267\u026b\u026f\u0278\u027d\u027f\u0288\u0293\u029a\u029d"+
		"\u02a4\u02aa\u02b0\u02b5\u02b9\u02bd\u02c1\u02c5\u02c8\u02d3\u02d8\u02e1"+
		"\u02e6\u02f0\u02f3\u02fe\u0303\u0312\u0315\u031d\u0326\u032a\u032f\u034d"+
		"\u0359\u035e\u036a\u0370\u0377\u037b\u0385\u0388\u038e\u0391\u0393\u0395"+
		"\u03a1\u03ad\u03c5\u03ca\u03d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}