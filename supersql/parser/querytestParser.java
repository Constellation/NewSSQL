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
		T__17=18, T__18=19, T__19=20, T__20=21, K_ABORT=22, K_ADD=23, K_ALL=24, 
		K_AND=25, K_AS=26, K_ASC=27, K_BETWEEN=28, K_BY=29, K_CASE=30, K_CAST=31, 
		K_COLLATE=32, K_CROSS=33, K_CURRENT_DATE=34, K_CURRENT_TIME=35, K_CURRENT_TIMESTAMP=36, 
		K_DESC=37, K_DISTINCT=38, K_ELSE=39, K_END=40, K_ESCAPE=41, K_EXCEPT=42, 
		K_EXISTS=43, K_FAIL=44, K_FULL=45, K_FROM=46, K_GLOB=47, K_GROUP=48, K_HAVING=49, 
		K_IF=50, K_IGNORE=51, K_IN=52, K_INDEXED=53, K_INNER=54, K_INTERSECT=55, 
		K_IS=56, K_ISNULL=57, K_JOIN=58, K_LEFT=59, K_LIKE=60, K_LIMIT=61, K_MATCH=62, 
		K_NATURAL=63, K_NO=64, K_NOT=65, K_NOTNULL=66, K_NULL=67, K_OFFSET=68, 
		K_ON=69, K_OR=70, K_ORDER=71, K_OUTER=72, K_RAISE=73, K_RECURSIVE=74, 
		K_REGEXP=75, K_RIGHT=76, K_ROLLBACK=77, K_SELECT=78, K_THEN=79, K_UNION=80, 
		K_USING=81, K_VALUES=82, K_WHEN=83, K_WHERE=84, K_WITH=85, K_GENERATE=86, 
		K_MAX=87, K_MIN=88, K_AVG=89, K_COUNT=90, K_SUM=91, C1=92, C2=93, C3=94, 
		DOT=95, OPEN_PARENTHESE=96, CLOSE_PARENTHESE=97, OPEN_BRACKET=98, CLOSE_BRACKET=99, 
		OPEN_BRACE=100, CLOSE_BRACE=101, SEMICOLON=102, DECOLATOR=103, NUMERIC_LITERAL=104, 
		BLOB_LITERAL=105, BIND_PARAMETER=106, IDENTIFIER=107, STRING_LITERAL=108, 
		MULTI_LINE_COMMENT=109, SINGLE_LINE_COMMENT=110, WS=111, UNEXPECTED_CHAR=112;
	public static final int
		RULE_query = 0, RULE_root = 1, RULE_media = 2, RULE_operand = 3, RULE_grouper = 4, 
		RULE_composite_iterator = 5, RULE_exp = 6, RULE_d_exp = 7, RULE_v_exp = 8, 
		RULE_h_exp = 9, RULE_sorting = 10, RULE_function = 11, RULE_if_then_else = 12, 
		RULE_from_where = 13, RULE_error = 14, RULE_sql_stmt_list = 15, RULE_sql_stmt = 16, 
		RULE_factored_select_stmt = 17, RULE_select_core = 18, RULE_where = 19, 
		RULE_result_column = 20, RULE_table_or_subquery = 21, RULE_keyword = 22, 
		RULE_select_stmt = 23, RULE_select_or_values = 24, RULE_compound_operator = 25, 
		RULE_join_clause = 26, RULE_join_operator = 27, RULE_join_constraint = 28, 
		RULE_common_table_expression = 29, RULE_ordering_term = 30, RULE_expr = 31, 
		RULE_literal_value = 32, RULE_unary_operator = 33, RULE_name = 34, RULE_type_name = 35, 
		RULE_function_name = 36, RULE_ag_function_name = 37, RULE_ag_keyword = 38, 
		RULE_collation_name = 39, RULE_database_name = 40, RULE_table_name = 41, 
		RULE_column_alias = 42, RULE_column_name = 43, RULE_table_alias = 44, 
		RULE_index_name = 45, RULE_any_name = 46, RULE_signed_number = 47, RULE_raise_function = 48, 
		RULE_error_message = 49;
	public static final String[] ruleNames = {
		"query", "root", "media", "operand", "grouper", "composite_iterator", 
		"exp", "d_exp", "v_exp", "h_exp", "sorting", "function", "if_then_else", 
		"from_where", "error", "sql_stmt_list", "sql_stmt", "factored_select_stmt", 
		"select_core", "where", "result_column", "table_or_subquery", "keyword", 
		"select_stmt", "select_or_values", "compound_operator", "join_clause", 
		"join_operator", "join_constraint", "common_table_expression", "ordering_term", 
		"expr", "literal_value", "unary_operator", "name", "type_name", "function_name", 
		"ag_function_name", "ag_keyword", "collation_name", "database_name", "table_name", 
		"column_alias", "column_name", "table_alias", "index_name", "any_name", 
		"signed_number", "raise_function", "error_message"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'||'", "'$'", "'?'", "':'", "'*'", "'/'", "'+'", "'-'", "'<<'", 
		"'>>'", "'&'", "'|'", "'<'", "'<='", "'>'", "'>='", "'='", "'=='", "'!='", 
		"'<>'", "'~'", null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"','", "'!'", "'%'", "'.'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "K_ABORT", 
		"K_ADD", "K_ALL", "K_AND", "K_AS", "K_ASC", "K_BETWEEN", "K_BY", "K_CASE", 
		"K_CAST", "K_COLLATE", "K_CROSS", "K_CURRENT_DATE", "K_CURRENT_TIME", 
		"K_CURRENT_TIMESTAMP", "K_DESC", "K_DISTINCT", "K_ELSE", "K_END", "K_ESCAPE", 
		"K_EXCEPT", "K_EXISTS", "K_FAIL", "K_FULL", "K_FROM", "K_GLOB", "K_GROUP", 
		"K_HAVING", "K_IF", "K_IGNORE", "K_IN", "K_INDEXED", "K_INNER", "K_INTERSECT", 
		"K_IS", "K_ISNULL", "K_JOIN", "K_LEFT", "K_LIKE", "K_LIMIT", "K_MATCH", 
		"K_NATURAL", "K_NO", "K_NOT", "K_NOTNULL", "K_NULL", "K_OFFSET", "K_ON", 
		"K_OR", "K_ORDER", "K_OUTER", "K_RAISE", "K_RECURSIVE", "K_REGEXP", "K_RIGHT", 
		"K_ROLLBACK", "K_SELECT", "K_THEN", "K_UNION", "K_USING", "K_VALUES", 
		"K_WHEN", "K_WHERE", "K_WITH", "K_GENERATE", "K_MAX", "K_MIN", "K_AVG", 
		"K_COUNT", "K_SUM", "C1", "C2", "C3", "DOT", "OPEN_PARENTHESE", "CLOSE_PARENTHESE", 
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
			setState(100);
			media();
			setState(101);
			root();
			setState(103);
			_la = _input.LA(1);
			if (_la==K_FROM || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (K_SELECT - 78)) | (1L << (K_VALUES - 78)) | (1L << (K_WITH - 78)) | (1L << (UNEXPECTED_CHAR - 78)))) != 0)) {
				{
				setState(102);
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
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(105);
				operand();
				}
				break;
			case 2:
				{
				setState(106);
				exp();
				}
				break;
			}
			setState(110);
			_la = _input.LA(1);
			if (_la==DECOLATOR) {
				{
				setState(109);
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
			setState(112);
			match(K_GENERATE);
			setState(113);
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
		public TerminalNode STRING_LITERAL() { return getToken(querytestParser.STRING_LITERAL, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(querytestParser.NUMERIC_LITERAL, 0); }
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
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(115);
				function();
				}
				break;
			case 2:
				{
				setState(116);
				match(OPEN_BRACE);
				setState(117);
				exp();
				setState(118);
				match(CLOSE_BRACE);
				}
				break;
			case 3:
				{
				setState(121);
				_la = _input.LA(1);
				if (_la==OPEN_PARENTHESE) {
					{
					setState(120);
					sorting();
					}
				}

				{
				setState(126);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(123);
					table_alias();
					setState(124);
					match(DOT);
					}
					break;
				}
				setState(128);
				column_name();
				}
				}
				break;
			case 4:
				{
				setState(129);
				grouper();
				}
				break;
			case 5:
				{
				setState(130);
				composite_iterator();
				}
				break;
			case 6:
				{
				setState(131);
				if_then_else();
				}
				break;
			case 7:
				{
				setState(132);
				match(STRING_LITERAL);
				}
				break;
			case 8:
				{
				setState(133);
				match(NUMERIC_LITERAL);
				}
				break;
			}
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(136);
					match(T__0);
					setState(137);
					operand();
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(143);
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
			setState(161);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(OPEN_BRACKET);
				setState(147);
				exp();
				setState(148);
				match(CLOSE_BRACKET);
				setState(149);
				match(C1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(OPEN_BRACKET);
				setState(152);
				exp();
				setState(153);
				match(CLOSE_BRACKET);
				setState(154);
				match(C2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				match(OPEN_BRACKET);
				setState(157);
				exp();
				setState(158);
				match(CLOSE_BRACKET);
				setState(159);
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
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(OPEN_BRACKET);
				setState(164);
				exp();
				setState(165);
				match(CLOSE_BRACKET);
				setState(166);
				match(C1);
				setState(175);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(167);
					match(NUMERIC_LITERAL);
					setState(168);
					match(C2);
					setState(171);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(169);
						match(NUMERIC_LITERAL);
						setState(170);
						match(C3);
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(173);
					match(NUMERIC_LITERAL);
					setState(174);
					match(C3);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(OPEN_BRACKET);
				setState(178);
				exp();
				setState(179);
				match(CLOSE_BRACKET);
				setState(180);
				match(C2);
				setState(189);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(181);
					match(NUMERIC_LITERAL);
					setState(182);
					match(C1);
					setState(185);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
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
					{
					setState(187);
					match(NUMERIC_LITERAL);
					setState(188);
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
			setState(193);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			v_exp();
			setState(198);
			_la = _input.LA(1);
			if (_la==C3) {
				{
				setState(196);
				match(C3);
				setState(197);
				operand();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			h_exp();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==C2) {
				{
				{
				setState(201);
				match(C2);
				setState(204);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(202);
					h_exp();
					}
					break;
				case 2:
					{
					setState(203);
					operand();
					}
					break;
				}
				}
				}
				setState(210);
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

	public static class H_expContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
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
			setState(211);
			operand();
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(212);
					match(C1);
					setState(213);
					operand();
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		enterRule(_localctx, 20, RULE_sorting);
		try {
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(OPEN_PARENTHESE);
				setState(220);
				match(K_ASC);
				setState(221);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(OPEN_PARENTHESE);
				setState(223);
				match(K_DESC);
				setState(224);
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
		public Ag_function_nameContext ag_function_name() {
			return getRuleContext(Ag_function_nameContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(querytestParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(querytestParser.CLOSE_BRACKET, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
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
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
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
		enterRule(_localctx, 22, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(228);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(227);
					match(T__1);
					}
				}

				setState(230);
				function_name();
				setState(231);
				match(OPEN_PARENTHESE);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__20) | (1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NO - 64)) | (1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)) | (1L << (OPEN_PARENTHESE - 64)) | (1L << (OPEN_BRACKET - 64)) | (1L << (OPEN_BRACE - 64)) | (1L << (NUMERIC_LITERAL - 64)) | (1L << (BLOB_LITERAL - 64)) | (1L << (BIND_PARAMETER - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (STRING_LITERAL - 64)))) != 0)) {
					{
					{
					setState(235);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(232);
						operand();
						}
						break;
					case 2:
						{
						setState(233);
						exp();
						}
						break;
					case 3:
						{
						setState(234);
						expr(0);
						}
						break;
					}
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(237);
						match(C1);
						setState(241);
						switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
						case 1:
							{
							setState(238);
							operand();
							}
							break;
						case 2:
							{
							setState(239);
							exp();
							}
							break;
						case 3:
							{
							setState(240);
							expr(0);
							}
							break;
						}
						}
						}
						setState(247);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(253);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				{
				setState(255);
				ag_function_name();
				setState(256);
				match(OPEN_BRACKET);
				{
				setState(260);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(257);
					table_alias();
					setState(258);
					match(DOT);
					}
					break;
				}
				setState(262);
				column_name();
				}
				setState(264);
				match(CLOSE_BRACKET);
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
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
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
		enterRule(_localctx, 24, RULE_if_then_else);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			switch (_input.LA(1)) {
			case K_IF:
				{
				{
				setState(268);
				match(K_IF);
				setState(269);
				match(OPEN_PARENTHESE);
				setState(270);
				expr(0);
				setState(271);
				match(CLOSE_PARENTHESE);
				setState(272);
				match(K_THEN);
				setState(273);
				match(OPEN_PARENTHESE);
				setState(274);
				operand();
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(275);
					match(C1);
					setState(276);
					operand();
					}
					}
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(282);
				match(CLOSE_PARENTHESE);
				setState(283);
				match(K_ELSE);
				setState(284);
				match(OPEN_PARENTHESE);
				setState(285);
				operand();
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(286);
					match(C1);
					setState(287);
					operand();
					}
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(293);
				match(CLOSE_PARENTHESE);
				}
				}
				break;
			case OPEN_PARENTHESE:
				{
				{
				setState(295);
				match(OPEN_PARENTHESE);
				setState(296);
				expr(0);
				setState(297);
				match(CLOSE_PARENTHESE);
				setState(298);
				match(T__2);
				{
				setState(299);
				operand();
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(300);
					match(C1);
					setState(301);
					operand();
					}
					}
					setState(306);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(307);
				match(T__3);
				{
				setState(308);
				operand();
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(309);
						match(C1);
						setState(310);
						operand();
						}
						} 
					}
					setState(315);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				}
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
		enterRule(_localctx, 26, RULE_from_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			switch (_input.LA(1)) {
			case K_FROM:
			case K_SELECT:
			case K_VALUES:
			case K_WITH:
				{
				setState(318);
				sql_stmt_list();
				}
				break;
			case UNEXPECTED_CHAR:
				{
				setState(319);
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
		enterRule(_localctx, 28, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
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
		enterRule(_localctx, 30, RULE_sql_stmt_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			sql_stmt();
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(327); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(326);
						match(SEMICOLON);
						}
						}
						setState(329); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEMICOLON );
					setState(331);
					sql_stmt();
					}
					} 
				}
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(337);
				match(SEMICOLON);
				}
				}
				setState(342);
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
		enterRule(_localctx, 32, RULE_sql_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(343);
				factored_select_stmt();
				}
				break;
			case 2:
				{
				setState(344);
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
		enterRule(_localctx, 34, RULE_factored_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(347);
				match(K_WITH);
				setState(349);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(348);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(351);
				common_table_expression();
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(352);
					match(C1);
					setState(353);
					common_table_expression();
					}
					}
					setState(358);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(361);
			select_core();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (K_EXCEPT - 42)) | (1L << (K_INTERSECT - 42)) | (1L << (K_UNION - 42)))) != 0)) {
				{
				{
				setState(362);
				compound_operator();
				setState(363);
				select_core();
				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(380);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(370);
				match(K_ORDER);
				setState(371);
				match(K_BY);
				setState(372);
				ordering_term();
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(373);
					match(C1);
					setState(374);
					ordering_term();
					}
					}
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(388);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(382);
				match(K_LIMIT);
				setState(383);
				expr(0);
				setState(386);
				_la = _input.LA(1);
				if (_la==K_OFFSET || _la==C1) {
					{
					setState(384);
					_la = _input.LA(1);
					if ( !(_la==K_OFFSET || _la==C1) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(385);
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
		enterRule(_localctx, 36, RULE_select_core);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			_la = _input.LA(1);
			if (_la==K_SELECT) {
				{
				setState(390);
				match(K_SELECT);
				setState(392);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(391);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				setState(394);
				result_column();
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(395);
					match(C1);
					setState(396);
					result_column();
					}
					}
					setState(401);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			{
			setState(404);
			match(K_FROM);
			setState(414);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(405);
				table_or_subquery();
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(406);
					match(C1);
					setState(407);
					table_or_subquery();
					}
					}
					setState(412);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(413);
				join_clause();
				}
				break;
			}
			}
			setState(417);
			_la = _input.LA(1);
			if (_la==K_VALUES || _la==K_WHERE) {
				{
				setState(416);
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
		enterRule(_localctx, 38, RULE_where);
		int _la;
		try {
			setState(466);
			switch (_input.LA(1)) {
			case K_WHERE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(419);
				match(K_WHERE);
				setState(420);
				expr(0);
				}
				setState(436);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(422);
					match(K_GROUP);
					setState(423);
					match(K_BY);
					setState(424);
					expr(0);
					setState(429);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(425);
						match(C1);
						setState(426);
						expr(0);
						}
						}
						setState(431);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(434);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(432);
						match(K_HAVING);
						setState(433);
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
				setState(438);
				match(K_VALUES);
				setState(439);
				match(OPEN_PARENTHESE);
				setState(440);
				expr(0);
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(441);
					match(C1);
					setState(442);
					expr(0);
					}
					}
					setState(447);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(448);
				match(CLOSE_PARENTHESE);
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(449);
					match(C1);
					setState(450);
					match(OPEN_PARENTHESE);
					setState(451);
					expr(0);
					setState(456);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(452);
						match(C1);
						setState(453);
						expr(0);
						}
						}
						setState(458);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(459);
					match(CLOSE_PARENTHESE);
					}
					}
					setState(465);
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
		enterRule(_localctx, 40, RULE_result_column);
		int _la;
		try {
			setState(480);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(468);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(469);
				table_name();
				setState(470);
				match(DOT);
				setState(471);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(473);
				expr(0);
				setState(478);
				_la = _input.LA(1);
				if (_la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(475);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(474);
						match(K_AS);
						}
					}

					setState(477);
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
		enterRule(_localctx, 42, RULE_table_or_subquery);
		int _la;
		try {
			setState(529);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(482);
					database_name();
					setState(483);
					match(DOT);
					}
					break;
				}
				setState(487);
				table_name();
				setState(492);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(489);
					switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
					case 1:
						{
						setState(488);
						match(K_AS);
						}
						break;
					}
					setState(491);
					table_alias();
					}
					break;
				}
				setState(499);
				switch (_input.LA(1)) {
				case K_INDEXED:
					{
					setState(494);
					match(K_INDEXED);
					setState(495);
					match(K_BY);
					setState(496);
					index_name();
					}
					break;
				case K_NOT:
					{
					setState(497);
					match(K_NOT);
					setState(498);
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
				setState(501);
				match(OPEN_PARENTHESE);
				setState(511);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(502);
					table_or_subquery();
					setState(507);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(503);
						match(C1);
						setState(504);
						table_or_subquery();
						}
						}
						setState(509);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(510);
					join_clause();
					}
					break;
				}
				setState(513);
				match(CLOSE_PARENTHESE);
				setState(518);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(515);
					switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
					case 1:
						{
						setState(514);
						match(K_AS);
						}
						break;
					}
					setState(517);
					table_alias();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(520);
				match(OPEN_PARENTHESE);
				setState(521);
				select_stmt();
				setState(522);
				match(CLOSE_PARENTHESE);
				setState(527);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(524);
					switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
					case 1:
						{
						setState(523);
						match(K_AS);
						}
						break;
					}
					setState(526);
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
		enterRule(_localctx, 44, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NO - 64)) | (1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)))) != 0)) ) {
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
		enterRule(_localctx, 46, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(533);
				match(K_WITH);
				setState(535);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(534);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(537);
				common_table_expression();
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(538);
					match(C1);
					setState(539);
					common_table_expression();
					}
					}
					setState(544);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(547);
			select_or_values();
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (K_EXCEPT - 42)) | (1L << (K_INTERSECT - 42)) | (1L << (K_UNION - 42)))) != 0)) {
				{
				{
				setState(548);
				compound_operator();
				setState(549);
				select_or_values();
				}
				}
				setState(555);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(566);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(556);
				match(K_ORDER);
				setState(557);
				match(K_BY);
				setState(558);
				ordering_term();
				setState(563);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(559);
					match(C1);
					setState(560);
					ordering_term();
					}
					}
					setState(565);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(574);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(568);
				match(K_LIMIT);
				setState(569);
				expr(0);
				setState(572);
				_la = _input.LA(1);
				if (_la==K_OFFSET || _la==C1) {
					{
					setState(570);
					_la = _input.LA(1);
					if ( !(_la==K_OFFSET || _la==C1) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(571);
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
		enterRule(_localctx, 48, RULE_select_or_values);
		int _la;
		try {
			setState(650);
			switch (_input.LA(1)) {
			case K_FROM:
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(588);
				_la = _input.LA(1);
				if (_la==K_SELECT) {
					{
					setState(576);
					match(K_SELECT);
					setState(578);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						setState(577);
						_la = _input.LA(1);
						if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					setState(580);
					result_column();
					setState(585);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(581);
						match(C1);
						setState(582);
						result_column();
						}
						}
						setState(587);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				{
				setState(590);
				match(K_FROM);
				setState(600);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(591);
					table_or_subquery();
					setState(596);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(592);
						match(C1);
						setState(593);
						table_or_subquery();
						}
						}
						setState(598);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(599);
					join_clause();
					}
					break;
				}
				}
				setState(604);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(602);
					match(K_WHERE);
					setState(603);
					expr(0);
					}
				}

				setState(620);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(606);
					match(K_GROUP);
					setState(607);
					match(K_BY);
					setState(608);
					expr(0);
					setState(613);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(609);
						match(C1);
						setState(610);
						expr(0);
						}
						}
						setState(615);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(618);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(616);
						match(K_HAVING);
						setState(617);
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
				setState(622);
				match(K_VALUES);
				setState(623);
				match(OPEN_PARENTHESE);
				setState(624);
				expr(0);
				setState(629);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(625);
					match(C1);
					setState(626);
					expr(0);
					}
					}
					setState(631);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(632);
				match(CLOSE_PARENTHESE);
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(633);
					match(C1);
					setState(634);
					match(OPEN_PARENTHESE);
					setState(635);
					expr(0);
					setState(640);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(636);
						match(C1);
						setState(637);
						expr(0);
						}
						}
						setState(642);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(643);
					match(CLOSE_PARENTHESE);
					}
					}
					setState(649);
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
		enterRule(_localctx, 50, RULE_compound_operator);
		try {
			setState(657);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(652);
				match(K_UNION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(653);
				match(K_UNION);
				setState(654);
				match(K_ALL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(655);
				match(K_INTERSECT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(656);
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
		enterRule(_localctx, 52, RULE_join_clause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			table_or_subquery();
			setState(669);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(660);
					join_operator();
					setState(663);
					switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
					case 1:
						{
						setState(661);
						join_clause();
						}
						break;
					case 2:
						{
						setState(662);
						table_or_subquery();
						}
						break;
					}
					setState(665);
					join_constraint();
					}
					} 
				}
				setState(671);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
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
		enterRule(_localctx, 54, RULE_join_operator);
		int _la;
		try {
			setState(693);
			switch (_input.LA(1)) {
			case C1:
				enterOuterAlt(_localctx, 1);
				{
				setState(672);
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
				setState(674);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(673);
					match(K_NATURAL);
					}
				}

				setState(690);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(676);
					match(K_LEFT);
					setState(678);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(677);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_RIGHT:
					{
					setState(680);
					match(K_RIGHT);
					setState(682);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(681);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_FULL:
					{
					setState(684);
					match(K_FULL);
					setState(686);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(685);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(688);
					match(K_INNER);
					}
					break;
				case K_CROSS:
					{
					setState(689);
					match(K_CROSS);
					}
					break;
				case K_JOIN:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(692);
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
		enterRule(_localctx, 56, RULE_join_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(709);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(695);
				match(K_ON);
				setState(696);
				expr(0);
				}
				break;
			case 2:
				{
				setState(697);
				match(K_USING);
				setState(698);
				match(OPEN_PARENTHESE);
				setState(699);
				column_name();
				setState(704);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(700);
					match(C1);
					setState(701);
					column_name();
					}
					}
					setState(706);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(707);
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
		enterRule(_localctx, 58, RULE_common_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711);
			table_name();
			setState(723);
			_la = _input.LA(1);
			if (_la==OPEN_PARENTHESE) {
				{
				setState(712);
				match(OPEN_PARENTHESE);
				setState(713);
				column_name();
				setState(718);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(714);
					match(C1);
					setState(715);
					column_name();
					}
					}
					setState(720);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(721);
				match(CLOSE_PARENTHESE);
				}
			}

			setState(725);
			match(K_AS);
			setState(726);
			match(OPEN_PARENTHESE);
			setState(727);
			select_stmt();
			setState(728);
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
		enterRule(_localctx, 60, RULE_ordering_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			expr(0);
			setState(733);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(731);
				match(K_COLLATE);
				setState(732);
				collation_name();
				}
			}

			setState(736);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(735);
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
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode BIND_PARAMETER() { return getToken(querytestParser.BIND_PARAMETER, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
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
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(739);
				unary_operator();
				setState(740);
				expr(20);
				}
				break;
			case 2:
				{
				setState(742);
				literal_value();
				}
				break;
			case 3:
				{
				setState(743);
				match(BIND_PARAMETER);
				}
				break;
			case 4:
				{
				setState(752);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(747);
					switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
					case 1:
						{
						setState(744);
						database_name();
						setState(745);
						match(DOT);
						}
						break;
					}
					setState(749);
					table_name();
					setState(750);
					match(DOT);
					}
					break;
				}
				setState(754);
				column_name();
				}
				break;
			case 5:
				{
				setState(755);
				match(OPEN_PARENTHESE);
				setState(756);
				expr(0);
				setState(757);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 6:
				{
				setState(759);
				match(K_CAST);
				setState(760);
				match(OPEN_PARENTHESE);
				setState(761);
				expr(0);
				setState(762);
				match(K_AS);
				setState(763);
				type_name();
				setState(764);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 7:
				{
				setState(770);
				_la = _input.LA(1);
				if (_la==K_EXISTS || _la==K_NOT) {
					{
					setState(767);
					_la = _input.LA(1);
					if (_la==K_NOT) {
						{
						setState(766);
						match(K_NOT);
						}
					}

					setState(769);
					match(K_EXISTS);
					}
				}

				setState(772);
				match(OPEN_PARENTHESE);
				setState(773);
				select_stmt();
				setState(774);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 8:
				{
				setState(776);
				match(K_CASE);
				setState(778);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(777);
					expr(0);
					}
					break;
				}
				setState(785); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(780);
					match(K_WHEN);
					setState(781);
					expr(0);
					setState(782);
					match(K_THEN);
					setState(783);
					expr(0);
					}
					}
					setState(787); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_WHEN );
				setState(791);
				_la = _input.LA(1);
				if (_la==K_ELSE) {
					{
					setState(789);
					match(K_ELSE);
					setState(790);
					expr(0);
					}
				}

				setState(793);
				match(K_END);
				}
				break;
			case 9:
				{
				setState(795);
				raise_function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(898);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(896);
					switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(798);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(799);
						match(T__0);
						setState(800);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(801);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(802);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5 || _la==C3) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(803);
						expr(19);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(804);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(805);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(806);
						expr(18);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(807);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(808);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(809);
						expr(17);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(810);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(811);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(812);
						expr(16);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(813);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(826);
						switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
						case 1:
							{
							setState(814);
							match(T__16);
							}
							break;
						case 2:
							{
							setState(815);
							match(T__17);
							}
							break;
						case 3:
							{
							setState(816);
							match(T__18);
							}
							break;
						case 4:
							{
							setState(817);
							match(T__19);
							}
							break;
						case 5:
							{
							setState(818);
							match(K_IS);
							}
							break;
						case 6:
							{
							setState(819);
							match(K_IS);
							setState(820);
							match(K_NOT);
							}
							break;
						case 7:
							{
							setState(821);
							match(K_IN);
							}
							break;
						case 8:
							{
							setState(822);
							match(K_LIKE);
							}
							break;
						case 9:
							{
							setState(823);
							match(K_GLOB);
							}
							break;
						case 10:
							{
							setState(824);
							match(K_MATCH);
							}
							break;
						case 11:
							{
							setState(825);
							match(K_REGEXP);
							}
							break;
						}
						setState(828);
						expr(15);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(829);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(830);
						match(K_AND);
						setState(831);
						expr(14);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(832);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(833);
						match(K_OR);
						setState(834);
						expr(13);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(835);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(836);
						match(K_IS);
						setState(838);
						switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
						case 1:
							{
							setState(837);
							match(K_NOT);
							}
							break;
						}
						setState(840);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(841);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(843);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(842);
							match(K_NOT);
							}
						}

						setState(845);
						match(K_BETWEEN);
						setState(846);
						expr(0);
						setState(847);
						match(K_AND);
						setState(848);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(850);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(851);
						match(K_COLLATE);
						setState(852);
						collation_name();
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(853);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(855);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(854);
							match(K_NOT);
							}
						}

						setState(857);
						_la = _input.LA(1);
						if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & ((1L << (K_GLOB - 47)) | (1L << (K_LIKE - 47)) | (1L << (K_MATCH - 47)) | (1L << (K_REGEXP - 47)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(858);
						expr(0);
						setState(861);
						switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
						case 1:
							{
							setState(859);
							match(K_ESCAPE);
							setState(860);
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
						setState(863);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(868);
						switch (_input.LA(1)) {
						case K_ISNULL:
							{
							setState(864);
							match(K_ISNULL);
							}
							break;
						case K_NOTNULL:
							{
							setState(865);
							match(K_NOTNULL);
							}
							break;
						case K_NOT:
							{
							setState(866);
							match(K_NOT);
							setState(867);
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
						setState(870);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(872);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(871);
							match(K_NOT);
							}
						}

						setState(874);
						match(K_IN);
						setState(894);
						switch (_input.LA(1)) {
						case OPEN_PARENTHESE:
							{
							setState(875);
							match(OPEN_PARENTHESE);
							setState(885);
							switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
							case 1:
								{
								setState(876);
								select_stmt();
								}
								break;
							case 2:
								{
								setState(877);
								expr(0);
								setState(882);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==C1) {
									{
									{
									setState(878);
									match(C1);
									setState(879);
									expr(0);
									}
									}
									setState(884);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
								break;
							}
							setState(887);
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
						case STRING_LITERAL:
							{
							setState(891);
							switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
							case 1:
								{
								setState(888);
								database_name();
								setState(889);
								match(DOT);
								}
								break;
							}
							setState(893);
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
				setState(900);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
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
		enterRule(_localctx, 64, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (K_NULL - 67)) | (1L << (NUMERIC_LITERAL - 67)) | (1L << (BLOB_LITERAL - 67)) | (1L << (STRING_LITERAL - 67)))) != 0)) ) {
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
		enterRule(_localctx, 66, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(903);
			_la = _input.LA(1);
			if ( !(((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & ((1L << (T__6 - 7)) | (1L << (T__7 - 7)) | (1L << (T__20 - 7)) | (1L << (K_NOT - 7)))) != 0)) ) {
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
		enterRule(_localctx, 68, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
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
		enterRule(_localctx, 70, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(907);
				name();
				}
				}
				setState(910); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NO - 64)) | (1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (STRING_LITERAL - 64)))) != 0) );
			setState(922);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				{
				setState(912);
				match(OPEN_PARENTHESE);
				setState(913);
				signed_number();
				setState(914);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				{
				setState(916);
				match(OPEN_PARENTHESE);
				setState(917);
				signed_number();
				setState(918);
				match(C1);
				setState(919);
				signed_number();
				setState(920);
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
		enterRule(_localctx, 72, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(924);
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
		enterRule(_localctx, 74, RULE_ag_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(926);
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
		enterRule(_localctx, 76, RULE_ag_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(928);
			_la = _input.LA(1);
			if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (K_MAX - 87)) | (1L << (K_MIN - 87)) | (1L << (K_AVG - 87)) | (1L << (K_COUNT - 87)) | (1L << (K_SUM - 87)))) != 0)) ) {
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
		enterRule(_localctx, 78, RULE_collation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(930);
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
		enterRule(_localctx, 80, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(932);
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
		enterRule(_localctx, 82, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(934);
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
		enterRule(_localctx, 84, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
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
		enterRule(_localctx, 86, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(938);
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
		enterRule(_localctx, 88, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(940);
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
		enterRule(_localctx, 90, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(942);
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
		public TerminalNode STRING_LITERAL() { return getToken(querytestParser.STRING_LITERAL, 0); }
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
		enterRule(_localctx, 92, RULE_any_name);
		try {
			setState(947);
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
				setState(944);
				keyword();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(945);
				match(IDENTIFIER);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(946);
				match(STRING_LITERAL);
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
		enterRule(_localctx, 94, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(950);
			_la = _input.LA(1);
			if (_la==T__6 || _la==T__7) {
				{
				setState(949);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(952);
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
		enterRule(_localctx, 96, RULE_raise_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(954);
			match(K_RAISE);
			setState(955);
			match(OPEN_PARENTHESE);
			setState(960);
			switch (_input.LA(1)) {
			case K_IGNORE:
				{
				setState(956);
				match(K_IGNORE);
				}
				break;
			case K_ABORT:
			case K_FAIL:
			case K_ROLLBACK:
				{
				setState(957);
				_la = _input.LA(1);
				if ( !(((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & ((1L << (K_ABORT - 22)) | (1L << (K_FAIL - 22)) | (1L << (K_ROLLBACK - 22)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(958);
				match(C1);
				setState(959);
				error_message();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(962);
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
		enterRule(_localctx, 98, RULE_error_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(964);
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
		case 31:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3r\u03c9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\3\2\5\2j\n\2\3\3\3\3\5\3n\n\3\3\3\5\3q\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5|\n\5\3\5\3\5\3\5\5\5\u0081\n\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\u0089\n\5\3\5\3\5\7\5\u008d\n\5\f\5\16\5\u0090\13\5\3\5\5\5\u0093"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00a4"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00ae\n\7\3\7\3\7\5\7\u00b2\n"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00bc\n\7\3\7\3\7\5\7\u00c0\n\7"+
		"\5\7\u00c2\n\7\3\b\3\b\3\t\3\t\3\t\5\t\u00c9\n\t\3\n\3\n\3\n\3\n\5\n\u00cf"+
		"\n\n\7\n\u00d1\n\n\f\n\16\n\u00d4\13\n\3\13\3\13\3\13\7\13\u00d9\n\13"+
		"\f\13\16\13\u00dc\13\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e4\n\f\3\r\5\r"+
		"\u00e7\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ee\n\r\3\r\3\r\3\r\3\r\5\r\u00f4"+
		"\n\r\7\r\u00f6\n\r\f\r\16\r\u00f9\13\r\7\r\u00fb\n\r\f\r\16\r\u00fe\13"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0107\n\r\3\r\3\r\3\r\3\r\5\r\u010d"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0118\n\16\f\16"+
		"\16\16\u011b\13\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0123\n\16\f\16"+
		"\16\16\u0126\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0131"+
		"\n\16\f\16\16\16\u0134\13\16\3\16\3\16\3\16\3\16\7\16\u013a\n\16\f\16"+
		"\16\16\u013d\13\16\5\16\u013f\n\16\3\17\3\17\5\17\u0143\n\17\3\20\3\20"+
		"\3\20\3\21\3\21\6\21\u014a\n\21\r\21\16\21\u014b\3\21\7\21\u014f\n\21"+
		"\f\21\16\21\u0152\13\21\3\21\7\21\u0155\n\21\f\21\16\21\u0158\13\21\3"+
		"\22\3\22\5\22\u015c\n\22\3\23\3\23\5\23\u0160\n\23\3\23\3\23\3\23\7\23"+
		"\u0165\n\23\f\23\16\23\u0168\13\23\5\23\u016a\n\23\3\23\3\23\3\23\3\23"+
		"\7\23\u0170\n\23\f\23\16\23\u0173\13\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u017a\n\23\f\23\16\23\u017d\13\23\5\23\u017f\n\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0185\n\23\5\23\u0187\n\23\3\24\3\24\5\24\u018b\n\24\3\24\3\24\3"+
		"\24\7\24\u0190\n\24\f\24\16\24\u0193\13\24\5\24\u0195\n\24\3\24\3\24\3"+
		"\24\3\24\7\24\u019b\n\24\f\24\16\24\u019e\13\24\3\24\5\24\u01a1\n\24\3"+
		"\24\5\24\u01a4\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u01ae"+
		"\n\25\f\25\16\25\u01b1\13\25\3\25\3\25\5\25\u01b5\n\25\5\25\u01b7\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u01be\n\25\f\25\16\25\u01c1\13\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u01c9\n\25\f\25\16\25\u01cc\13\25\3\25"+
		"\3\25\7\25\u01d0\n\25\f\25\16\25\u01d3\13\25\5\25\u01d5\n\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u01de\n\26\3\26\5\26\u01e1\n\26\5\26\u01e3"+
		"\n\26\3\27\3\27\3\27\5\27\u01e8\n\27\3\27\3\27\5\27\u01ec\n\27\3\27\5"+
		"\27\u01ef\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u01f6\n\27\3\27\3\27\3\27"+
		"\3\27\7\27\u01fc\n\27\f\27\16\27\u01ff\13\27\3\27\5\27\u0202\n\27\3\27"+
		"\3\27\5\27\u0206\n\27\3\27\5\27\u0209\n\27\3\27\3\27\3\27\3\27\5\27\u020f"+
		"\n\27\3\27\5\27\u0212\n\27\5\27\u0214\n\27\3\30\3\30\3\31\3\31\5\31\u021a"+
		"\n\31\3\31\3\31\3\31\7\31\u021f\n\31\f\31\16\31\u0222\13\31\5\31\u0224"+
		"\n\31\3\31\3\31\3\31\3\31\7\31\u022a\n\31\f\31\16\31\u022d\13\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u0234\n\31\f\31\16\31\u0237\13\31\5\31\u0239"+
		"\n\31\3\31\3\31\3\31\3\31\5\31\u023f\n\31\5\31\u0241\n\31\3\32\3\32\5"+
		"\32\u0245\n\32\3\32\3\32\3\32\7\32\u024a\n\32\f\32\16\32\u024d\13\32\5"+
		"\32\u024f\n\32\3\32\3\32\3\32\3\32\7\32\u0255\n\32\f\32\16\32\u0258\13"+
		"\32\3\32\5\32\u025b\n\32\3\32\3\32\5\32\u025f\n\32\3\32\3\32\3\32\3\32"+
		"\3\32\7\32\u0266\n\32\f\32\16\32\u0269\13\32\3\32\3\32\5\32\u026d\n\32"+
		"\5\32\u026f\n\32\3\32\3\32\3\32\3\32\3\32\7\32\u0276\n\32\f\32\16\32\u0279"+
		"\13\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0281\n\32\f\32\16\32\u0284"+
		"\13\32\3\32\3\32\7\32\u0288\n\32\f\32\16\32\u028b\13\32\5\32\u028d\n\32"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u0294\n\33\3\34\3\34\3\34\3\34\5\34\u029a"+
		"\n\34\3\34\3\34\7\34\u029e\n\34\f\34\16\34\u02a1\13\34\3\35\3\35\5\35"+
		"\u02a5\n\35\3\35\3\35\5\35\u02a9\n\35\3\35\3\35\5\35\u02ad\n\35\3\35\3"+
		"\35\5\35\u02b1\n\35\3\35\3\35\5\35\u02b5\n\35\3\35\5\35\u02b8\n\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u02c1\n\36\f\36\16\36\u02c4\13\36"+
		"\3\36\3\36\5\36\u02c8\n\36\3\37\3\37\3\37\3\37\3\37\7\37\u02cf\n\37\f"+
		"\37\16\37\u02d2\13\37\3\37\3\37\5\37\u02d6\n\37\3\37\3\37\3\37\3\37\3"+
		"\37\3 \3 \3 \5 \u02e0\n \3 \5 \u02e3\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\5!"+
		"\u02ee\n!\3!\3!\3!\5!\u02f3\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\5!\u0302\n!\3!\5!\u0305\n!\3!\3!\3!\3!\3!\3!\5!\u030d\n!\3!\3!\3!\3!"+
		"\3!\6!\u0314\n!\r!\16!\u0315\3!\3!\5!\u031a\n!\3!\3!\3!\5!\u031f\n!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\5!\u033d\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0349\n!\3"+
		"!\3!\3!\5!\u034e\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u035a\n!\3!\3!\3"+
		"!\3!\5!\u0360\n!\3!\3!\3!\3!\3!\5!\u0367\n!\3!\3!\5!\u036b\n!\3!\3!\3"+
		"!\3!\3!\3!\7!\u0373\n!\f!\16!\u0376\13!\5!\u0378\n!\3!\3!\3!\3!\5!\u037e"+
		"\n!\3!\5!\u0381\n!\7!\u0383\n!\f!\16!\u0386\13!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\6%\u038f\n%\r%\16%\u0390\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u039d\n%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60"+
		"\3\60\5\60\u03b6\n\60\3\61\5\61\u03b9\n\61\3\61\3\61\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\5\62\u03c3\n\62\3\62\3\62\3\63\3\63\3\63\2\3@\64\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX"+
		"Z\\^`bd\2\20\4\2FF^^\4\2\32\32((\4\2\30\30\32]\4\2\35\35\'\'\4\2\7\b`"+
		"`\3\2\t\n\3\2\13\16\3\2\17\22\6\2\61\61>>@@MM\6\2$&EEjknn\5\2\t\n\27\27"+
		"CC\3\2Y]\3\2mn\5\2\30\30..OO\u044e\2f\3\2\2\2\4m\3\2\2\2\6r\3\2\2\2\b"+
		"\u0088\3\2\2\2\n\u00a3\3\2\2\2\f\u00c1\3\2\2\2\16\u00c3\3\2\2\2\20\u00c5"+
		"\3\2\2\2\22\u00ca\3\2\2\2\24\u00d5\3\2\2\2\26\u00e3\3\2\2\2\30\u010c\3"+
		"\2\2\2\32\u013e\3\2\2\2\34\u0142\3\2\2\2\36\u0144\3\2\2\2 \u0147\3\2\2"+
		"\2\"\u015b\3\2\2\2$\u0169\3\2\2\2&\u0194\3\2\2\2(\u01d4\3\2\2\2*\u01e2"+
		"\3\2\2\2,\u0213\3\2\2\2.\u0215\3\2\2\2\60\u0223\3\2\2\2\62\u028c\3\2\2"+
		"\2\64\u0293\3\2\2\2\66\u0295\3\2\2\28\u02b7\3\2\2\2:\u02c7\3\2\2\2<\u02c9"+
		"\3\2\2\2>\u02dc\3\2\2\2@\u031e\3\2\2\2B\u0387\3\2\2\2D\u0389\3\2\2\2F"+
		"\u038b\3\2\2\2H\u038e\3\2\2\2J\u039e\3\2\2\2L\u03a0\3\2\2\2N\u03a2\3\2"+
		"\2\2P\u03a4\3\2\2\2R\u03a6\3\2\2\2T\u03a8\3\2\2\2V\u03aa\3\2\2\2X\u03ac"+
		"\3\2\2\2Z\u03ae\3\2\2\2\\\u03b0\3\2\2\2^\u03b5\3\2\2\2`\u03b8\3\2\2\2"+
		"b\u03bc\3\2\2\2d\u03c6\3\2\2\2fg\5\6\4\2gi\5\4\3\2hj\5\34\17\2ih\3\2\2"+
		"\2ij\3\2\2\2j\3\3\2\2\2kn\5\b\5\2ln\5\16\b\2mk\3\2\2\2ml\3\2\2\2np\3\2"+
		"\2\2oq\7i\2\2po\3\2\2\2pq\3\2\2\2q\5\3\2\2\2rs\7X\2\2st\7m\2\2t\7\3\2"+
		"\2\2u\u0089\5\30\r\2vw\7f\2\2wx\5\16\b\2xy\7g\2\2y\u0089\3\2\2\2z|\5\26"+
		"\f\2{z\3\2\2\2{|\3\2\2\2|\u0080\3\2\2\2}~\5Z.\2~\177\7a\2\2\177\u0081"+
		"\3\2\2\2\u0080}\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0089\5X-\2\u0083\u0089\5\n\6\2\u0084\u0089\5\f\7\2\u0085\u0089\5\32"+
		"\16\2\u0086\u0089\7n\2\2\u0087\u0089\7j\2\2\u0088u\3\2\2\2\u0088v\3\2"+
		"\2\2\u0088{\3\2\2\2\u0088\u0083\3\2\2\2\u0088\u0084\3\2\2\2\u0088\u0085"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008e\3\2\2\2\u008a"+
		"\u008b\7\3\2\2\u008b\u008d\5\b\5\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2"+
		"\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0093\7i\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\t\3\2\2\2\u0094\u0095\7d\2\2\u0095\u0096\5\16\b\2\u0096\u0097"+
		"\7e\2\2\u0097\u0098\7^\2\2\u0098\u00a4\3\2\2\2\u0099\u009a\7d\2\2\u009a"+
		"\u009b\5\16\b\2\u009b\u009c\7e\2\2\u009c\u009d\7_\2\2\u009d\u00a4\3\2"+
		"\2\2\u009e\u009f\7d\2\2\u009f\u00a0\5\16\b\2\u00a0\u00a1\7e\2\2\u00a1"+
		"\u00a2\7`\2\2\u00a2\u00a4\3\2\2\2\u00a3\u0094\3\2\2\2\u00a3\u0099\3\2"+
		"\2\2\u00a3\u009e\3\2\2\2\u00a4\13\3\2\2\2\u00a5\u00a6\7d\2\2\u00a6\u00a7"+
		"\5\16\b\2\u00a7\u00a8\7e\2\2\u00a8\u00b1\7^\2\2\u00a9\u00aa\7j\2\2\u00aa"+
		"\u00ad\7_\2\2\u00ab\u00ac\7j\2\2\u00ac\u00ae\7`\2\2\u00ad\u00ab\3\2\2"+
		"\2\u00ad\u00ae\3\2\2\2\u00ae\u00b2\3\2\2\2\u00af\u00b0\7j\2\2\u00b0\u00b2"+
		"\7`\2\2\u00b1\u00a9\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00c2\3\2\2\2\u00b3"+
		"\u00b4\7d\2\2\u00b4\u00b5\5\16\b\2\u00b5\u00b6\7e\2\2\u00b6\u00bf\7_\2"+
		"\2\u00b7\u00b8\7j\2\2\u00b8\u00bb\7^\2\2\u00b9\u00ba\7j\2\2\u00ba\u00bc"+
		"\7`\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00c0\3\2\2\2\u00bd"+
		"\u00be\7j\2\2\u00be\u00c0\7`\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00bd\3\2\2"+
		"\2\u00c0\u00c2\3\2\2\2\u00c1\u00a5\3\2\2\2\u00c1\u00b3\3\2\2\2\u00c2\r"+
		"\3\2\2\2\u00c3\u00c4\5\20\t\2\u00c4\17\3\2\2\2\u00c5\u00c8\5\22\n\2\u00c6"+
		"\u00c7\7`\2\2\u00c7\u00c9\5\b\5\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\21\3\2\2\2\u00ca\u00d2\5\24\13\2\u00cb\u00ce\7_\2\2\u00cc\u00cf"+
		"\5\24\13\2\u00cd\u00cf\5\b\5\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2"+
		"\u00cf\u00d1\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\23\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00da\5\b\5\2\u00d6\u00d7\7^\2\2\u00d7\u00d9\5\b\5\2\u00d8\u00d6\3\2"+
		"\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\25\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7b\2\2\u00de\u00df\7\35\2"+
		"\2\u00df\u00e4\7c\2\2\u00e0\u00e1\7b\2\2\u00e1\u00e2\7\'\2\2\u00e2\u00e4"+
		"\7c\2\2\u00e3\u00dd\3\2\2\2\u00e3\u00e0\3\2\2\2\u00e4\27\3\2\2\2\u00e5"+
		"\u00e7\7\4\2\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00e9\5J&\2\u00e9\u00fc\7b\2\2\u00ea\u00ee\5\b\5\2\u00eb\u00ee"+
		"\5\16\b\2\u00ec\u00ee\5@!\2\u00ed\u00ea\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ec\3\2\2\2\u00ee\u00f7\3\2\2\2\u00ef\u00f3\7^\2\2\u00f0\u00f4\5\b"+
		"\5\2\u00f1\u00f4\5\16\b\2\u00f2\u00f4\5@!\2\u00f3\u00f0\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00ef\3\2"+
		"\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00ed\3\2\2\2\u00fb\u00fe\3\2"+
		"\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00ff\u0100\7c\2\2\u0100\u010d\3\2\2\2\u0101\u0102\5L\'"+
		"\2\u0102\u0106\7d\2\2\u0103\u0104\5Z.\2\u0104\u0105\7a\2\2\u0105\u0107"+
		"\3\2\2\2\u0106\u0103\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u0109\5X-\2\u0109\u010a\3\2\2\2\u010a\u010b\7e\2\2\u010b\u010d\3\2\2"+
		"\2\u010c\u00e6\3\2\2\2\u010c\u0101\3\2\2\2\u010d\31\3\2\2\2\u010e\u010f"+
		"\7\64\2\2\u010f\u0110\7b\2\2\u0110\u0111\5@!\2\u0111\u0112\7c\2\2\u0112"+
		"\u0113\7Q\2\2\u0113\u0114\7b\2\2\u0114\u0119\5\b\5\2\u0115\u0116\7^\2"+
		"\2\u0116\u0118\5\b\5\2\u0117\u0115\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117"+
		"\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c"+
		"\u011d\7c\2\2\u011d\u011e\7)\2\2\u011e\u011f\7b\2\2\u011f\u0124\5\b\5"+
		"\2\u0120\u0121\7^\2\2\u0121\u0123\5\b\5\2\u0122\u0120\3\2\2\2\u0123\u0126"+
		"\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126"+
		"\u0124\3\2\2\2\u0127\u0128\7c\2\2\u0128\u013f\3\2\2\2\u0129\u012a\7b\2"+
		"\2\u012a\u012b\5@!\2\u012b\u012c\7c\2\2\u012c\u012d\7\5\2\2\u012d\u0132"+
		"\5\b\5\2\u012e\u012f\7^\2\2\u012f\u0131\5\b\5\2\u0130\u012e\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7\6\2\2\u0136\u013b\5\b\5\2\u0137"+
		"\u0138\7^\2\2\u0138\u013a\5\b\5\2\u0139\u0137\3\2\2\2\u013a\u013d\3\2"+
		"\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013f\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013e\u010e\3\2\2\2\u013e\u0129\3\2\2\2\u013f\33\3\2\2"+
		"\2\u0140\u0143\5 \21\2\u0141\u0143\5\36\20\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0141\3\2\2\2\u0143\35\3\2\2\2\u0144\u0145\7r\2\2\u0145\u0146\b\20\1"+
		"\2\u0146\37\3\2\2\2\u0147\u0150\5\"\22\2\u0148\u014a\7h\2\2\u0149\u0148"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014d\3\2\2\2\u014d\u014f\5\"\22\2\u014e\u0149\3\2\2\2\u014f\u0152\3"+
		"\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0156\3\2\2\2\u0152"+
		"\u0150\3\2\2\2\u0153\u0155\7h\2\2\u0154\u0153\3\2\2\2\u0155\u0158\3\2"+
		"\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157!\3\2\2\2\u0158\u0156"+
		"\3\2\2\2\u0159\u015c\5$\23\2\u015a\u015c\5\60\31\2\u015b\u0159\3\2\2\2"+
		"\u015b\u015a\3\2\2\2\u015c#\3\2\2\2\u015d\u015f\7W\2\2\u015e\u0160\7L"+
		"\2\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0166\5<\37\2\u0162\u0163\7^\2\2\u0163\u0165\5<\37\2\u0164\u0162\3\2"+
		"\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167"+
		"\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u015d\3\2\2\2\u0169\u016a\3\2"+
		"\2\2\u016a\u016b\3\2\2\2\u016b\u0171\5&\24\2\u016c\u016d\5\64\33\2\u016d"+
		"\u016e\5&\24\2\u016e\u0170\3\2\2\2\u016f\u016c\3\2\2\2\u0170\u0173\3\2"+
		"\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u017e\3\2\2\2\u0173"+
		"\u0171\3\2\2\2\u0174\u0175\7I\2\2\u0175\u0176\7\37\2\2\u0176\u017b\5>"+
		" \2\u0177\u0178\7^\2\2\u0178\u017a\5> \2\u0179\u0177\3\2\2\2\u017a\u017d"+
		"\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017f\3\2\2\2\u017d"+
		"\u017b\3\2\2\2\u017e\u0174\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0186\3\2"+
		"\2\2\u0180\u0181\7?\2\2\u0181\u0184\5@!\2\u0182\u0183\t\2\2\2\u0183\u0185"+
		"\5@!\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0187\3\2\2\2\u0186"+
		"\u0180\3\2\2\2\u0186\u0187\3\2\2\2\u0187%\3\2\2\2\u0188\u018a\7P\2\2\u0189"+
		"\u018b\t\3\2\2\u018a\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2"+
		"\2\2\u018c\u0191\5*\26\2\u018d\u018e\7^\2\2\u018e\u0190\5*\26\2\u018f"+
		"\u018d\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2"+
		"\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0188\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u01a0\7\60\2\2\u0197\u019c\5"+
		",\27\2\u0198\u0199\7^\2\2\u0199\u019b\5,\27\2\u019a\u0198\3\2\2\2\u019b"+
		"\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a1\3\2"+
		"\2\2\u019e\u019c\3\2\2\2\u019f\u01a1\5\66\34\2\u01a0\u0197\3\2\2\2\u01a0"+
		"\u019f\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u01a4\5(\25\2\u01a3\u01a2\3\2"+
		"\2\2\u01a3\u01a4\3\2\2\2\u01a4\'\3\2\2\2\u01a5\u01a6\7V\2\2\u01a6\u01a7"+
		"\5@!\2\u01a7\u01b6\3\2\2\2\u01a8\u01a9\7\62\2\2\u01a9\u01aa\7\37\2\2\u01aa"+
		"\u01af\5@!\2\u01ab\u01ac\7^\2\2\u01ac\u01ae\5@!\2\u01ad\u01ab\3\2\2\2"+
		"\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b4"+
		"\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u01b3\7\63\2\2\u01b3\u01b5\5@!\2\u01b4"+
		"\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01a8\3\2"+
		"\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01d5\3\2\2\2\u01b8\u01b9\7T\2\2\u01b9"+
		"\u01ba\7b\2\2\u01ba\u01bf\5@!\2\u01bb\u01bc\7^\2\2\u01bc\u01be\5@!\2\u01bd"+
		"\u01bb\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01d1\7c\2\2\u01c3"+
		"\u01c4\7^\2\2\u01c4\u01c5\7b\2\2\u01c5\u01ca\5@!\2\u01c6\u01c7\7^\2\2"+
		"\u01c7\u01c9\5@!\2\u01c8\u01c6\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8"+
		"\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd"+
		"\u01ce\7c\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01c3\3\2\2\2\u01d0\u01d3\3\2"+
		"\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3"+
		"\u01d1\3\2\2\2\u01d4\u01a5\3\2\2\2\u01d4\u01b8\3\2\2\2\u01d5)\3\2\2\2"+
		"\u01d6\u01e3\7\7\2\2\u01d7\u01d8\5T+\2\u01d8\u01d9\7a\2\2\u01d9\u01da"+
		"\7\7\2\2\u01da\u01e3\3\2\2\2\u01db\u01e0\5@!\2\u01dc\u01de\7\34\2\2\u01dd"+
		"\u01dc\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e1\5V"+
		",\2\u01e0\u01dd\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2"+
		"\u01d6\3\2\2\2\u01e2\u01d7\3\2\2\2\u01e2\u01db\3\2\2\2\u01e3+\3\2\2\2"+
		"\u01e4\u01e5\5R*\2\u01e5\u01e6\7a\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01e4"+
		"\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ee\5T+\2\u01ea"+
		"\u01ec\7\34\2\2\u01eb\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\3"+
		"\2\2\2\u01ed\u01ef\5Z.\2\u01ee\u01eb\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"\u01f5\3\2\2\2\u01f0\u01f1\7\67\2\2\u01f1\u01f2\7\37\2\2\u01f2\u01f6\5"+
		"\\/\2\u01f3\u01f4\7C\2\2\u01f4\u01f6\7\67\2\2\u01f5\u01f0\3\2\2\2\u01f5"+
		"\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u0214\3\2\2\2\u01f7\u0201\7b"+
		"\2\2\u01f8\u01fd\5,\27\2\u01f9\u01fa\7^\2\2\u01fa\u01fc\5,\27\2\u01fb"+
		"\u01f9\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2"+
		"\2\2\u01fe\u0202\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0202\5\66\34\2\u0201"+
		"\u01f8\3\2\2\2\u0201\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0208\7c"+
		"\2\2\u0204\u0206\7\34\2\2\u0205\u0204\3\2\2\2\u0205\u0206\3\2\2\2\u0206"+
		"\u0207\3\2\2\2\u0207\u0209\5Z.\2\u0208\u0205\3\2\2\2\u0208\u0209\3\2\2"+
		"\2\u0209\u0214\3\2\2\2\u020a\u020b\7b\2\2\u020b\u020c\5\60\31\2\u020c"+
		"\u0211\7c\2\2\u020d\u020f\7\34\2\2\u020e\u020d\3\2\2\2\u020e\u020f\3\2"+
		"\2\2\u020f\u0210\3\2\2\2\u0210\u0212\5Z.\2\u0211\u020e\3\2\2\2\u0211\u0212"+
		"\3\2\2\2\u0212\u0214\3\2\2\2\u0213\u01e7\3\2\2\2\u0213\u01f7\3\2\2\2\u0213"+
		"\u020a\3\2\2\2\u0214-\3\2\2\2\u0215\u0216\t\4\2\2\u0216/\3\2\2\2\u0217"+
		"\u0219\7W\2\2\u0218\u021a\7L\2\2\u0219\u0218\3\2\2\2\u0219\u021a\3\2\2"+
		"\2\u021a\u021b\3\2\2\2\u021b\u0220\5<\37\2\u021c\u021d\7^\2\2\u021d\u021f"+
		"\5<\37\2\u021e\u021c\3\2\2\2\u021f\u0222\3\2\2\2\u0220\u021e\3\2\2\2\u0220"+
		"\u0221\3\2\2\2\u0221\u0224\3\2\2\2\u0222\u0220\3\2\2\2\u0223\u0217\3\2"+
		"\2\2\u0223\u0224\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u022b\5\62\32\2\u0226"+
		"\u0227\5\64\33\2\u0227\u0228\5\62\32\2\u0228\u022a\3\2\2\2\u0229\u0226"+
		"\3\2\2\2\u022a\u022d\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c"+
		"\u0238\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u022f\7I\2\2\u022f\u0230\7\37"+
		"\2\2\u0230\u0235\5> \2\u0231\u0232\7^\2\2\u0232\u0234\5> \2\u0233\u0231"+
		"\3\2\2\2\u0234\u0237\3\2\2\2\u0235\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236"+
		"\u0239\3\2\2\2\u0237\u0235\3\2\2\2\u0238\u022e\3\2\2\2\u0238\u0239\3\2"+
		"\2\2\u0239\u0240\3\2\2\2\u023a\u023b\7?\2\2\u023b\u023e\5@!\2\u023c\u023d"+
		"\t\2\2\2\u023d\u023f\5@!\2\u023e\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023f"+
		"\u0241\3\2\2\2\u0240\u023a\3\2\2\2\u0240\u0241\3\2\2\2\u0241\61\3\2\2"+
		"\2\u0242\u0244\7P\2\2\u0243\u0245\t\3\2\2\u0244\u0243\3\2\2\2\u0244\u0245"+
		"\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u024b\5*\26\2\u0247\u0248\7^\2\2\u0248"+
		"\u024a\5*\26\2\u0249\u0247\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2"+
		"\2\2\u024b\u024c\3\2\2\2\u024c\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024e"+
		"\u0242\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u025a\7\60"+
		"\2\2\u0251\u0256\5,\27\2\u0252\u0253\7^\2\2\u0253\u0255\5,\27\2\u0254"+
		"\u0252\3\2\2\2\u0255\u0258\3\2\2\2\u0256\u0254\3\2\2\2\u0256\u0257\3\2"+
		"\2\2\u0257\u025b\3\2\2\2\u0258\u0256\3\2\2\2\u0259\u025b\5\66\34\2\u025a"+
		"\u0251\3\2\2\2\u025a\u0259\3\2\2\2\u025b\u025e\3\2\2\2\u025c\u025d\7V"+
		"\2\2\u025d\u025f\5@!\2\u025e\u025c\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u026e"+
		"\3\2\2\2\u0260\u0261\7\62\2\2\u0261\u0262\7\37\2\2\u0262\u0267\5@!\2\u0263"+
		"\u0264\7^\2\2\u0264\u0266\5@!\2\u0265\u0263\3\2\2\2\u0266\u0269\3\2\2"+
		"\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u026c\3\2\2\2\u0269\u0267"+
		"\3\2\2\2\u026a\u026b\7\63\2\2\u026b\u026d\5@!\2\u026c\u026a\3\2\2\2\u026c"+
		"\u026d\3\2\2\2\u026d\u026f\3\2\2\2\u026e\u0260\3\2\2\2\u026e\u026f\3\2"+
		"\2\2\u026f\u028d\3\2\2\2\u0270\u0271\7T\2\2\u0271\u0272\7b\2\2\u0272\u0277"+
		"\5@!\2\u0273\u0274\7^\2\2\u0274\u0276\5@!\2\u0275\u0273\3\2\2\2\u0276"+
		"\u0279\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u027a\3\2"+
		"\2\2\u0279\u0277\3\2\2\2\u027a\u0289\7c\2\2\u027b\u027c\7^\2\2\u027c\u027d"+
		"\7b\2\2\u027d\u0282\5@!\2\u027e\u027f\7^\2\2\u027f\u0281\5@!\2\u0280\u027e"+
		"\3\2\2\2\u0281\u0284\3\2\2\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283"+
		"\u0285\3\2\2\2\u0284\u0282\3\2\2\2\u0285\u0286\7c\2\2\u0286\u0288\3\2"+
		"\2\2\u0287\u027b\3\2\2\2\u0288\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289"+
		"\u028a\3\2\2\2\u028a\u028d\3\2\2\2\u028b\u0289\3\2\2\2\u028c\u024e\3\2"+
		"\2\2\u028c\u0270\3\2\2\2\u028d\63\3\2\2\2\u028e\u0294\7R\2\2\u028f\u0290"+
		"\7R\2\2\u0290\u0294\7\32\2\2\u0291\u0294\79\2\2\u0292\u0294\7,\2\2\u0293"+
		"\u028e\3\2\2\2\u0293\u028f\3\2\2\2\u0293\u0291\3\2\2\2\u0293\u0292\3\2"+
		"\2\2\u0294\65\3\2\2\2\u0295\u029f\5,\27\2\u0296\u0299\58\35\2\u0297\u029a"+
		"\5\66\34\2\u0298\u029a\5,\27\2\u0299\u0297\3\2\2\2\u0299\u0298\3\2\2\2"+
		"\u029a\u029b\3\2\2\2\u029b\u029c\5:\36\2\u029c\u029e\3\2\2\2\u029d\u0296"+
		"\3\2\2\2\u029e\u02a1\3\2\2\2\u029f\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0"+
		"\67\3\2\2\2\u02a1\u029f\3\2\2\2\u02a2\u02b8\7^\2\2\u02a3\u02a5\7A\2\2"+
		"\u02a4\u02a3\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02b4\3\2\2\2\u02a6\u02a8"+
		"\7=\2\2\u02a7\u02a9\7J\2\2\u02a8\u02a7\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9"+
		"\u02b5\3\2\2\2\u02aa\u02ac\7N\2\2\u02ab\u02ad\7J\2\2\u02ac\u02ab\3\2\2"+
		"\2\u02ac\u02ad\3\2\2\2\u02ad\u02b5\3\2\2\2\u02ae\u02b0\7/\2\2\u02af\u02b1"+
		"\7J\2\2\u02b0\u02af\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b5\3\2\2\2\u02b2"+
		"\u02b5\78\2\2\u02b3\u02b5\7#\2\2\u02b4\u02a6\3\2\2\2\u02b4\u02aa\3\2\2"+
		"\2\u02b4\u02ae\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b4\u02b3\3\2\2\2\u02b4\u02b5"+
		"\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b8\7<\2\2\u02b7\u02a2\3\2\2\2\u02b7"+
		"\u02a4\3\2\2\2\u02b89\3\2\2\2\u02b9\u02ba\7G\2\2\u02ba\u02c8\5@!\2\u02bb"+
		"\u02bc\7S\2\2\u02bc\u02bd\7b\2\2\u02bd\u02c2\5X-\2\u02be\u02bf\7^\2\2"+
		"\u02bf\u02c1\5X-\2\u02c0\u02be\3\2\2\2\u02c1\u02c4\3\2\2\2\u02c2\u02c0"+
		"\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c5\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c5"+
		"\u02c6\7c\2\2\u02c6\u02c8\3\2\2\2\u02c7\u02b9\3\2\2\2\u02c7\u02bb\3\2"+
		"\2\2\u02c7\u02c8\3\2\2\2\u02c8;\3\2\2\2\u02c9\u02d5\5T+\2\u02ca\u02cb"+
		"\7b\2\2\u02cb\u02d0\5X-\2\u02cc\u02cd\7^\2\2\u02cd\u02cf\5X-\2\u02ce\u02cc"+
		"\3\2\2\2\u02cf\u02d2\3\2\2\2\u02d0\u02ce\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1"+
		"\u02d3\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d3\u02d4\7c\2\2\u02d4\u02d6\3\2"+
		"\2\2\u02d5\u02ca\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7"+
		"\u02d8\7\34\2\2\u02d8\u02d9\7b\2\2\u02d9\u02da\5\60\31\2\u02da\u02db\7"+
		"c\2\2\u02db=\3\2\2\2\u02dc\u02df\5@!\2\u02dd\u02de\7\"\2\2\u02de\u02e0"+
		"\5P)\2\u02df\u02dd\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e2\3\2\2\2\u02e1"+
		"\u02e3\t\5\2\2\u02e2\u02e1\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3?\3\2\2\2"+
		"\u02e4\u02e5\b!\1\2\u02e5\u02e6\5D#\2\u02e6\u02e7\5@!\26\u02e7\u031f\3"+
		"\2\2\2\u02e8\u031f\5B\"\2\u02e9\u031f\7l\2\2\u02ea\u02eb\5R*\2\u02eb\u02ec"+
		"\7a\2\2\u02ec\u02ee\3\2\2\2\u02ed\u02ea\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee"+
		"\u02ef\3\2\2\2\u02ef\u02f0\5T+\2\u02f0\u02f1\7a\2\2\u02f1\u02f3\3\2\2"+
		"\2\u02f2\u02ed\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u031f"+
		"\5X-\2\u02f5\u02f6\7b\2\2\u02f6\u02f7\5@!\2\u02f7\u02f8\7c\2\2\u02f8\u031f"+
		"\3\2\2\2\u02f9\u02fa\7!\2\2\u02fa\u02fb\7b\2\2\u02fb\u02fc\5@!\2\u02fc"+
		"\u02fd\7\34\2\2\u02fd\u02fe\5H%\2\u02fe\u02ff\7c\2\2\u02ff\u031f\3\2\2"+
		"\2\u0300\u0302\7C\2\2\u0301\u0300\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0303"+
		"\3\2\2\2\u0303\u0305\7-\2\2\u0304\u0301\3\2\2\2\u0304\u0305\3\2\2\2\u0305"+
		"\u0306\3\2\2\2\u0306\u0307\7b\2\2\u0307\u0308\5\60\31\2\u0308\u0309\7"+
		"c\2\2\u0309\u031f\3\2\2\2\u030a\u030c\7 \2\2\u030b\u030d\5@!\2\u030c\u030b"+
		"\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u0313\3\2\2\2\u030e\u030f\7U\2\2\u030f"+
		"\u0310\5@!\2\u0310\u0311\7Q\2\2\u0311\u0312\5@!\2\u0312\u0314\3\2\2\2"+
		"\u0313\u030e\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0313\3\2\2\2\u0315\u0316"+
		"\3\2\2\2\u0316\u0319\3\2\2\2\u0317\u0318\7)\2\2\u0318\u031a\5@!\2\u0319"+
		"\u0317\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u031c\7*"+
		"\2\2\u031c\u031f\3\2\2\2\u031d\u031f\5b\62\2\u031e\u02e4\3\2\2\2\u031e"+
		"\u02e8\3\2\2\2\u031e\u02e9\3\2\2\2\u031e\u02f2\3\2\2\2\u031e\u02f5\3\2"+
		"\2\2\u031e\u02f9\3\2\2\2\u031e\u0304\3\2\2\2\u031e\u030a\3\2\2\2\u031e"+
		"\u031d\3\2\2\2\u031f\u0384\3\2\2\2\u0320\u0321\f\25\2\2\u0321\u0322\7"+
		"\3\2\2\u0322\u0383\5@!\26\u0323\u0324\f\24\2\2\u0324\u0325\t\6\2\2\u0325"+
		"\u0383\5@!\25\u0326\u0327\f\23\2\2\u0327\u0328\t\7\2\2\u0328\u0383\5@"+
		"!\24\u0329\u032a\f\22\2\2\u032a\u032b\t\b\2\2\u032b\u0383\5@!\23\u032c"+
		"\u032d\f\21\2\2\u032d\u032e\t\t\2\2\u032e\u0383\5@!\22\u032f\u033c\f\20"+
		"\2\2\u0330\u033d\7\23\2\2\u0331\u033d\7\24\2\2\u0332\u033d\7\25\2\2\u0333"+
		"\u033d\7\26\2\2\u0334\u033d\7:\2\2\u0335\u0336\7:\2\2\u0336\u033d\7C\2"+
		"\2\u0337\u033d\7\66\2\2\u0338\u033d\7>\2\2\u0339\u033d\7\61\2\2\u033a"+
		"\u033d\7@\2\2\u033b\u033d\7M\2\2\u033c\u0330\3\2\2\2\u033c\u0331\3\2\2"+
		"\2\u033c\u0332\3\2\2\2\u033c\u0333\3\2\2\2\u033c\u0334\3\2\2\2\u033c\u0335"+
		"\3\2\2\2\u033c\u0337\3\2\2\2\u033c\u0338\3\2\2\2\u033c\u0339\3\2\2\2\u033c"+
		"\u033a\3\2\2\2\u033c\u033b\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u0383\5@"+
		"!\21\u033f\u0340\f\17\2\2\u0340\u0341\7\33\2\2\u0341\u0383\5@!\20\u0342"+
		"\u0343\f\16\2\2\u0343\u0344\7H\2\2\u0344\u0383\5@!\17\u0345\u0346\f\b"+
		"\2\2\u0346\u0348\7:\2\2\u0347\u0349\7C\2\2\u0348\u0347\3\2\2\2\u0348\u0349"+
		"\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u0383\5@!\t\u034b\u034d\f\7\2\2\u034c"+
		"\u034e\7C\2\2\u034d\u034c\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u034f\3\2"+
		"\2\2\u034f\u0350\7\36\2\2\u0350\u0351\5@!\2\u0351\u0352\7\33\2\2\u0352"+
		"\u0353\5@!\b\u0353\u0383\3\2\2\2\u0354\u0355\f\13\2\2\u0355\u0356\7\""+
		"\2\2\u0356\u0383\5P)\2\u0357\u0359\f\n\2\2\u0358\u035a\7C\2\2\u0359\u0358"+
		"\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035c\t\n\2\2\u035c"+
		"\u035f\5@!\2\u035d\u035e\7+\2\2\u035e\u0360\5@!\2\u035f\u035d\3\2\2\2"+
		"\u035f\u0360\3\2\2\2\u0360\u0383\3\2\2\2\u0361\u0366\f\t\2\2\u0362\u0367"+
		"\7;\2\2\u0363\u0367\7D\2\2\u0364\u0365\7C\2\2\u0365\u0367\7E\2\2\u0366"+
		"\u0362\3\2\2\2\u0366\u0363\3\2\2\2\u0366\u0364\3\2\2\2\u0367\u0383\3\2"+
		"\2\2\u0368\u036a\f\6\2\2\u0369\u036b\7C\2\2\u036a\u0369\3\2\2\2\u036a"+
		"\u036b\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u0380\7\66\2\2\u036d\u0377\7"+
		"b\2\2\u036e\u0378\5\60\31\2\u036f\u0374\5@!\2\u0370\u0371\7^\2\2\u0371"+
		"\u0373\5@!\2\u0372\u0370\3\2\2\2\u0373\u0376\3\2\2\2\u0374\u0372\3\2\2"+
		"\2\u0374\u0375\3\2\2\2\u0375\u0378\3\2\2\2\u0376\u0374\3\2\2\2\u0377\u036e"+
		"\3\2\2\2\u0377\u036f\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u0379\3\2\2\2\u0379"+
		"\u0381\7c\2\2\u037a\u037b\5R*\2\u037b\u037c\7a\2\2\u037c\u037e\3\2\2\2"+
		"\u037d\u037a\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u037f\3\2\2\2\u037f\u0381"+
		"\5T+\2\u0380\u036d\3\2\2\2\u0380\u037d\3\2\2\2\u0381\u0383\3\2\2\2\u0382"+
		"\u0320\3\2\2\2\u0382\u0323\3\2\2\2\u0382\u0326\3\2\2\2\u0382\u0329\3\2"+
		"\2\2\u0382\u032c\3\2\2\2\u0382\u032f\3\2\2\2\u0382\u033f\3\2\2\2\u0382"+
		"\u0342\3\2\2\2\u0382\u0345\3\2\2\2\u0382\u034b\3\2\2\2\u0382\u0354\3\2"+
		"\2\2\u0382\u0357\3\2\2\2\u0382\u0361\3\2\2\2\u0382\u0368\3\2\2\2\u0383"+
		"\u0386\3\2\2\2\u0384\u0382\3\2\2\2\u0384\u0385\3\2\2\2\u0385A\3\2\2\2"+
		"\u0386\u0384\3\2\2\2\u0387\u0388\t\13\2\2\u0388C\3\2\2\2\u0389\u038a\t"+
		"\f\2\2\u038aE\3\2\2\2\u038b\u038c\5^\60\2\u038cG\3\2\2\2\u038d\u038f\5"+
		"F$\2\u038e\u038d\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u038e\3\2\2\2\u0390"+
		"\u0391\3\2\2\2\u0391\u039c\3\2\2\2\u0392\u0393\7b\2\2\u0393\u0394\5`\61"+
		"\2\u0394\u0395\7c\2\2\u0395\u039d\3\2\2\2\u0396\u0397\7b\2\2\u0397\u0398"+
		"\5`\61\2\u0398\u0399\7^\2\2\u0399\u039a\5`\61\2\u039a\u039b\7c\2\2\u039b"+
		"\u039d\3\2\2\2\u039c\u0392\3\2\2\2\u039c\u0396\3\2\2\2\u039c\u039d\3\2"+
		"\2\2\u039dI\3\2\2\2\u039e\u039f\5^\60\2\u039fK\3\2\2\2\u03a0\u03a1\5N"+
		"(\2\u03a1M\3\2\2\2\u03a2\u03a3\t\r\2\2\u03a3O\3\2\2\2\u03a4\u03a5\5^\60"+
		"\2\u03a5Q\3\2\2\2\u03a6\u03a7\5^\60\2\u03a7S\3\2\2\2\u03a8\u03a9\5^\60"+
		"\2\u03a9U\3\2\2\2\u03aa\u03ab\t\16\2\2\u03abW\3\2\2\2\u03ac\u03ad\5^\60"+
		"\2\u03adY\3\2\2\2\u03ae\u03af\5^\60\2\u03af[\3\2\2\2\u03b0\u03b1\5^\60"+
		"\2\u03b1]\3\2\2\2\u03b2\u03b6\5.\30\2\u03b3\u03b6\7m\2\2\u03b4\u03b6\7"+
		"n\2\2\u03b5\u03b2\3\2\2\2\u03b5\u03b3\3\2\2\2\u03b5\u03b4\3\2\2\2\u03b6"+
		"_\3\2\2\2\u03b7\u03b9\t\7\2\2\u03b8\u03b7\3\2\2\2\u03b8\u03b9\3\2\2\2"+
		"\u03b9\u03ba\3\2\2\2\u03ba\u03bb\7j\2\2\u03bba\3\2\2\2\u03bc\u03bd\7K"+
		"\2\2\u03bd\u03c2\7b\2\2\u03be\u03c3\7\65\2\2\u03bf\u03c0\t\17\2\2\u03c0"+
		"\u03c1\7^\2\2\u03c1\u03c3\5d\63\2\u03c2\u03be\3\2\2\2\u03c2\u03bf\3\2"+
		"\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c5\7c\2\2\u03c5c\3\2\2\2\u03c6\u03c7"+
		"\7n\2\2\u03c7e\3\2\2\2\u0087imp{\u0080\u0088\u008e\u0092\u00a3\u00ad\u00b1"+
		"\u00bb\u00bf\u00c1\u00c8\u00ce\u00d2\u00da\u00e3\u00e6\u00ed\u00f3\u00f7"+
		"\u00fc\u0106\u010c\u0119\u0124\u0132\u013b\u013e\u0142\u014b\u0150\u0156"+
		"\u015b\u015f\u0166\u0169\u0171\u017b\u017e\u0184\u0186\u018a\u0191\u0194"+
		"\u019c\u01a0\u01a3\u01af\u01b4\u01b6\u01bf\u01ca\u01d1\u01d4\u01dd\u01e0"+
		"\u01e2\u01e7\u01eb\u01ee\u01f5\u01fd\u0201\u0205\u0208\u020e\u0211\u0213"+
		"\u0219\u0220\u0223\u022b\u0235\u0238\u023e\u0240\u0244\u024b\u024e\u0256"+
		"\u025a\u025e\u0267\u026c\u026e\u0277\u0282\u0289\u028c\u0293\u0299\u029f"+
		"\u02a4\u02a8\u02ac\u02b0\u02b4\u02b7\u02c2\u02c7\u02d0\u02d5\u02df\u02e2"+
		"\u02ed\u02f2\u0301\u0304\u030c\u0315\u0319\u031e\u033c\u0348\u034d\u0359"+
		"\u035f\u0366\u036a\u0374\u0377\u037d\u0380\u0382\u0384\u0390\u039c\u03b5"+
		"\u03b8\u03c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}