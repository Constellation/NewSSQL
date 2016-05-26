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
		RULE_index_name = 45, RULE_any_name = 46, RULE_sl = 47, RULE_signed_number = 48, 
		RULE_raise_function = 49, RULE_error_message = 50;
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
		"sl", "signed_number", "raise_function", "error_message"
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
			setState(102);
			media();
			setState(103);
			root();
			setState(105);
			_la = _input.LA(1);
			if (_la==K_FROM || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (K_SELECT - 78)) | (1L << (K_VALUES - 78)) | (1L << (K_WITH - 78)) | (1L << (UNEXPECTED_CHAR - 78)))) != 0)) {
				{
				setState(104);
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
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(107);
				operand();
				}
				break;
			case 2:
				{
				setState(108);
				exp();
				}
				break;
			}
			setState(112);
			_la = _input.LA(1);
			if (_la==DECOLATOR) {
				{
				setState(111);
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
			setState(114);
			match(K_GENERATE);
			setState(115);
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
		public SlContext sl() {
			return getRuleContext(SlContext.class,0);
		}
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
			setState(136);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(117);
				function();
				}
				break;
			case 2:
				{
				setState(118);
				match(OPEN_BRACE);
				setState(119);
				exp();
				setState(120);
				match(CLOSE_BRACE);
				}
				break;
			case 3:
				{
				setState(123);
				_la = _input.LA(1);
				if (_la==OPEN_PARENTHESE) {
					{
					setState(122);
					sorting();
					}
				}

				{
				setState(128);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(125);
					table_alias();
					setState(126);
					match(DOT);
					}
					break;
				}
				setState(130);
				column_name();
				}
				}
				break;
			case 4:
				{
				setState(131);
				grouper();
				}
				break;
			case 5:
				{
				setState(132);
				composite_iterator();
				}
				break;
			case 6:
				{
				setState(133);
				if_then_else();
				}
				break;
			case 7:
				{
				setState(134);
				sl();
				}
				break;
			case 8:
				{
				setState(135);
				match(NUMERIC_LITERAL);
				}
				break;
			}
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(138);
					match(T__0);
					setState(139);
					operand();
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
			setState(146);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(145);
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
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(OPEN_BRACKET);
				setState(149);
				exp();
				setState(150);
				match(CLOSE_BRACKET);
				setState(151);
				match(C1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				match(OPEN_BRACKET);
				setState(154);
				exp();
				setState(155);
				match(CLOSE_BRACKET);
				setState(156);
				match(C2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				match(OPEN_BRACKET);
				setState(159);
				exp();
				setState(160);
				match(CLOSE_BRACKET);
				setState(161);
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
			setState(193);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(OPEN_BRACKET);
				setState(166);
				exp();
				setState(167);
				match(CLOSE_BRACKET);
				setState(168);
				match(C1);
				setState(177);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(169);
					match(NUMERIC_LITERAL);
					setState(170);
					match(C2);
					setState(173);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(171);
						match(NUMERIC_LITERAL);
						setState(172);
						match(C3);
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(175);
					match(NUMERIC_LITERAL);
					setState(176);
					match(C3);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(OPEN_BRACKET);
				setState(180);
				exp();
				setState(181);
				match(CLOSE_BRACKET);
				setState(182);
				match(C2);
				setState(191);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(183);
					match(NUMERIC_LITERAL);
					setState(184);
					match(C1);
					setState(187);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						setState(185);
						match(NUMERIC_LITERAL);
						setState(186);
						match(C3);
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(189);
					match(NUMERIC_LITERAL);
					setState(190);
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
			setState(195);
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
			setState(197);
			v_exp();
			setState(200);
			_la = _input.LA(1);
			if (_la==C3) {
				{
				setState(198);
				match(C3);
				setState(199);
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
			setState(202);
			h_exp();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==C2) {
				{
				{
				setState(203);
				match(C2);
				setState(206);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(204);
					h_exp();
					}
					break;
				case 2:
					{
					setState(205);
					operand();
					}
					break;
				}
				}
				}
				setState(212);
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
			setState(213);
			operand();
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					match(C1);
					setState(215);
					operand();
					}
					} 
				}
				setState(220);
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
			setState(227);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(OPEN_PARENTHESE);
				setState(222);
				match(K_ASC);
				setState(223);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				match(OPEN_PARENTHESE);
				setState(225);
				match(K_DESC);
				setState(226);
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
			setState(268);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(230);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(229);
					match(T__1);
					}
				}

				setState(232);
				function_name();
				setState(233);
				match(OPEN_PARENTHESE);
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__7) | (1L << T__20) | (1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NO - 64)) | (1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)) | (1L << (OPEN_PARENTHESE - 64)) | (1L << (OPEN_BRACKET - 64)) | (1L << (OPEN_BRACE - 64)) | (1L << (NUMERIC_LITERAL - 64)) | (1L << (BLOB_LITERAL - 64)) | (1L << (BIND_PARAMETER - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (STRING_LITERAL - 64)))) != 0)) {
					{
					{
					setState(237);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(234);
						operand();
						}
						break;
					case 2:
						{
						setState(235);
						exp();
						}
						break;
					case 3:
						{
						setState(236);
						expr(0);
						}
						break;
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(239);
						match(C1);
						setState(243);
						switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
						case 1:
							{
							setState(240);
							operand();
							}
							break;
						case 2:
							{
							setState(241);
							exp();
							}
							break;
						case 3:
							{
							setState(242);
							expr(0);
							}
							break;
						}
						}
						}
						setState(249);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(254);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(255);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				{
				setState(257);
				ag_function_name();
				setState(258);
				match(OPEN_BRACKET);
				{
				setState(262);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(259);
					table_alias();
					setState(260);
					match(DOT);
					}
					break;
				}
				setState(264);
				column_name();
				}
				setState(266);
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
			setState(318);
			switch (_input.LA(1)) {
			case K_IF:
				{
				{
				setState(270);
				match(K_IF);
				setState(271);
				match(OPEN_PARENTHESE);
				setState(272);
				expr(0);
				setState(273);
				match(CLOSE_PARENTHESE);
				setState(274);
				match(K_THEN);
				setState(275);
				match(OPEN_PARENTHESE);
				setState(276);
				operand();
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(277);
					match(C1);
					setState(278);
					operand();
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(284);
				match(CLOSE_PARENTHESE);
				setState(285);
				match(K_ELSE);
				setState(286);
				match(OPEN_PARENTHESE);
				setState(287);
				operand();
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(288);
					match(C1);
					setState(289);
					operand();
					}
					}
					setState(294);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(295);
				match(CLOSE_PARENTHESE);
				}
				}
				break;
			case OPEN_PARENTHESE:
				{
				{
				setState(297);
				match(OPEN_PARENTHESE);
				setState(298);
				expr(0);
				setState(299);
				match(CLOSE_PARENTHESE);
				setState(300);
				match(T__2);
				{
				setState(301);
				operand();
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(302);
					match(C1);
					setState(303);
					operand();
					}
					}
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(309);
				match(T__3);
				{
				setState(310);
				operand();
				setState(315);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(311);
						match(C1);
						setState(312);
						operand();
						}
						} 
					}
					setState(317);
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
			setState(322);
			switch (_input.LA(1)) {
			case K_FROM:
			case K_SELECT:
			case K_VALUES:
			case K_WITH:
				{
				setState(320);
				sql_stmt_list();
				}
				break;
			case UNEXPECTED_CHAR:
				{
				setState(321);
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
			setState(324);
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
			setState(327);
			sql_stmt();
			setState(336);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(329); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(328);
						match(SEMICOLON);
						}
						}
						setState(331); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEMICOLON );
					setState(333);
					sql_stmt();
					}
					} 
				}
				setState(338);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(339);
				match(SEMICOLON);
				}
				}
				setState(344);
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
			setState(347);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(345);
				factored_select_stmt();
				}
				break;
			case 2:
				{
				setState(346);
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
			setState(361);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(349);
				match(K_WITH);
				setState(351);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(350);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(353);
				common_table_expression();
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(354);
					match(C1);
					setState(355);
					common_table_expression();
					}
					}
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(363);
			select_core();
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (K_EXCEPT - 42)) | (1L << (K_INTERSECT - 42)) | (1L << (K_UNION - 42)))) != 0)) {
				{
				{
				setState(364);
				compound_operator();
				setState(365);
				select_core();
				}
				}
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(382);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(372);
				match(K_ORDER);
				setState(373);
				match(K_BY);
				setState(374);
				ordering_term();
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(375);
					match(C1);
					setState(376);
					ordering_term();
					}
					}
					setState(381);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(390);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(384);
				match(K_LIMIT);
				setState(385);
				expr(0);
				setState(388);
				_la = _input.LA(1);
				if (_la==K_OFFSET || _la==C1) {
					{
					setState(386);
					_la = _input.LA(1);
					if ( !(_la==K_OFFSET || _la==C1) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(387);
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
			setState(404);
			_la = _input.LA(1);
			if (_la==K_SELECT) {
				{
				setState(392);
				match(K_SELECT);
				setState(394);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(393);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				setState(396);
				result_column();
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(397);
					match(C1);
					setState(398);
					result_column();
					}
					}
					setState(403);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			{
			setState(406);
			match(K_FROM);
			setState(416);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(407);
				table_or_subquery();
				setState(412);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(408);
					match(C1);
					setState(409);
					table_or_subquery();
					}
					}
					setState(414);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(415);
				join_clause();
				}
				break;
			}
			}
			setState(419);
			_la = _input.LA(1);
			if (_la==K_VALUES || _la==K_WHERE) {
				{
				setState(418);
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
			setState(468);
			switch (_input.LA(1)) {
			case K_WHERE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(421);
				match(K_WHERE);
				setState(422);
				expr(0);
				}
				setState(438);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(424);
					match(K_GROUP);
					setState(425);
					match(K_BY);
					setState(426);
					expr(0);
					setState(431);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(427);
						match(C1);
						setState(428);
						expr(0);
						}
						}
						setState(433);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(436);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(434);
						match(K_HAVING);
						setState(435);
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
				setState(440);
				match(K_VALUES);
				setState(441);
				match(OPEN_PARENTHESE);
				setState(442);
				expr(0);
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(443);
					match(C1);
					setState(444);
					expr(0);
					}
					}
					setState(449);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(450);
				match(CLOSE_PARENTHESE);
				setState(465);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(451);
					match(C1);
					setState(452);
					match(OPEN_PARENTHESE);
					setState(453);
					expr(0);
					setState(458);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(454);
						match(C1);
						setState(455);
						expr(0);
						}
						}
						setState(460);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(461);
					match(CLOSE_PARENTHESE);
					}
					}
					setState(467);
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
			setState(482);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(471);
				table_name();
				setState(472);
				match(DOT);
				setState(473);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(475);
				expr(0);
				setState(480);
				_la = _input.LA(1);
				if (_la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(477);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(476);
						match(K_AS);
						}
					}

					setState(479);
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
			setState(531);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(484);
					database_name();
					setState(485);
					match(DOT);
					}
					break;
				}
				setState(489);
				table_name();
				setState(494);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(491);
					switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
					case 1:
						{
						setState(490);
						match(K_AS);
						}
						break;
					}
					setState(493);
					table_alias();
					}
					break;
				}
				setState(501);
				switch (_input.LA(1)) {
				case K_INDEXED:
					{
					setState(496);
					match(K_INDEXED);
					setState(497);
					match(K_BY);
					setState(498);
					index_name();
					}
					break;
				case K_NOT:
					{
					setState(499);
					match(K_NOT);
					setState(500);
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
				setState(503);
				match(OPEN_PARENTHESE);
				setState(513);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(504);
					table_or_subquery();
					setState(509);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(505);
						match(C1);
						setState(506);
						table_or_subquery();
						}
						}
						setState(511);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(512);
					join_clause();
					}
					break;
				}
				setState(515);
				match(CLOSE_PARENTHESE);
				setState(520);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(517);
					switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
					case 1:
						{
						setState(516);
						match(K_AS);
						}
						break;
					}
					setState(519);
					table_alias();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(522);
				match(OPEN_PARENTHESE);
				setState(523);
				select_stmt();
				setState(524);
				match(CLOSE_PARENTHESE);
				setState(529);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(526);
					switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
					case 1:
						{
						setState(525);
						match(K_AS);
						}
						break;
					}
					setState(528);
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
			setState(533);
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
			setState(547);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(535);
				match(K_WITH);
				setState(537);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(536);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(539);
				common_table_expression();
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(540);
					match(C1);
					setState(541);
					common_table_expression();
					}
					}
					setState(546);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(549);
			select_or_values();
			setState(555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (K_EXCEPT - 42)) | (1L << (K_INTERSECT - 42)) | (1L << (K_UNION - 42)))) != 0)) {
				{
				{
				setState(550);
				compound_operator();
				setState(551);
				select_or_values();
				}
				}
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(568);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(558);
				match(K_ORDER);
				setState(559);
				match(K_BY);
				setState(560);
				ordering_term();
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(561);
					match(C1);
					setState(562);
					ordering_term();
					}
					}
					setState(567);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(576);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(570);
				match(K_LIMIT);
				setState(571);
				expr(0);
				setState(574);
				_la = _input.LA(1);
				if (_la==K_OFFSET || _la==C1) {
					{
					setState(572);
					_la = _input.LA(1);
					if ( !(_la==K_OFFSET || _la==C1) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(573);
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
			setState(652);
			switch (_input.LA(1)) {
			case K_FROM:
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(590);
				_la = _input.LA(1);
				if (_la==K_SELECT) {
					{
					setState(578);
					match(K_SELECT);
					setState(580);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						setState(579);
						_la = _input.LA(1);
						if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					setState(582);
					result_column();
					setState(587);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(583);
						match(C1);
						setState(584);
						result_column();
						}
						}
						setState(589);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				{
				setState(592);
				match(K_FROM);
				setState(602);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(593);
					table_or_subquery();
					setState(598);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(594);
						match(C1);
						setState(595);
						table_or_subquery();
						}
						}
						setState(600);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(601);
					join_clause();
					}
					break;
				}
				}
				setState(606);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(604);
					match(K_WHERE);
					setState(605);
					expr(0);
					}
				}

				setState(622);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(608);
					match(K_GROUP);
					setState(609);
					match(K_BY);
					setState(610);
					expr(0);
					setState(615);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(611);
						match(C1);
						setState(612);
						expr(0);
						}
						}
						setState(617);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(620);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(618);
						match(K_HAVING);
						setState(619);
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
				setState(624);
				match(K_VALUES);
				setState(625);
				match(OPEN_PARENTHESE);
				setState(626);
				expr(0);
				setState(631);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(627);
					match(C1);
					setState(628);
					expr(0);
					}
					}
					setState(633);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(634);
				match(CLOSE_PARENTHESE);
				setState(649);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(635);
					match(C1);
					setState(636);
					match(OPEN_PARENTHESE);
					setState(637);
					expr(0);
					setState(642);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(638);
						match(C1);
						setState(639);
						expr(0);
						}
						}
						setState(644);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(645);
					match(CLOSE_PARENTHESE);
					}
					}
					setState(651);
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
			setState(659);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(654);
				match(K_UNION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(655);
				match(K_UNION);
				setState(656);
				match(K_ALL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(657);
				match(K_INTERSECT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(658);
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
			setState(661);
			table_or_subquery();
			setState(671);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(662);
					join_operator();
					setState(665);
					switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
					case 1:
						{
						setState(663);
						join_clause();
						}
						break;
					case 2:
						{
						setState(664);
						table_or_subquery();
						}
						break;
					}
					setState(667);
					join_constraint();
					}
					} 
				}
				setState(673);
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
			setState(695);
			switch (_input.LA(1)) {
			case C1:
				enterOuterAlt(_localctx, 1);
				{
				setState(674);
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
				setState(676);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(675);
					match(K_NATURAL);
					}
				}

				setState(692);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(678);
					match(K_LEFT);
					setState(680);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(679);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_RIGHT:
					{
					setState(682);
					match(K_RIGHT);
					setState(684);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(683);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_FULL:
					{
					setState(686);
					match(K_FULL);
					setState(688);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(687);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(690);
					match(K_INNER);
					}
					break;
				case K_CROSS:
					{
					setState(691);
					match(K_CROSS);
					}
					break;
				case K_JOIN:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(694);
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
			setState(711);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(697);
				match(K_ON);
				setState(698);
				expr(0);
				}
				break;
			case 2:
				{
				setState(699);
				match(K_USING);
				setState(700);
				match(OPEN_PARENTHESE);
				setState(701);
				column_name();
				setState(706);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(702);
					match(C1);
					setState(703);
					column_name();
					}
					}
					setState(708);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(709);
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
			setState(713);
			table_name();
			setState(725);
			_la = _input.LA(1);
			if (_la==OPEN_PARENTHESE) {
				{
				setState(714);
				match(OPEN_PARENTHESE);
				setState(715);
				column_name();
				setState(720);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(716);
					match(C1);
					setState(717);
					column_name();
					}
					}
					setState(722);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(723);
				match(CLOSE_PARENTHESE);
				}
			}

			setState(727);
			match(K_AS);
			setState(728);
			match(OPEN_PARENTHESE);
			setState(729);
			select_stmt();
			setState(730);
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
			setState(732);
			expr(0);
			setState(735);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(733);
				match(K_COLLATE);
				setState(734);
				collation_name();
				}
			}

			setState(738);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(737);
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
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(741);
				unary_operator();
				setState(742);
				expr(20);
				}
				break;
			case 2:
				{
				setState(744);
				literal_value();
				}
				break;
			case 3:
				{
				setState(745);
				match(BIND_PARAMETER);
				}
				break;
			case 4:
				{
				setState(754);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(749);
					switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
					case 1:
						{
						setState(746);
						database_name();
						setState(747);
						match(DOT);
						}
						break;
					}
					setState(751);
					table_alias();
					setState(752);
					match(DOT);
					}
					break;
				}
				setState(756);
				column_name();
				}
				break;
			case 5:
				{
				setState(757);
				match(OPEN_PARENTHESE);
				setState(758);
				expr(0);
				setState(759);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 6:
				{
				setState(761);
				match(K_CAST);
				setState(762);
				match(OPEN_PARENTHESE);
				setState(763);
				expr(0);
				setState(764);
				match(K_AS);
				setState(765);
				type_name();
				setState(766);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 7:
				{
				setState(772);
				_la = _input.LA(1);
				if (_la==K_EXISTS || _la==K_NOT) {
					{
					setState(769);
					_la = _input.LA(1);
					if (_la==K_NOT) {
						{
						setState(768);
						match(K_NOT);
						}
					}

					setState(771);
					match(K_EXISTS);
					}
				}

				setState(774);
				match(OPEN_PARENTHESE);
				setState(775);
				select_stmt();
				setState(776);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 8:
				{
				setState(778);
				match(K_CASE);
				setState(780);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(779);
					expr(0);
					}
					break;
				}
				setState(787); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(782);
					match(K_WHEN);
					setState(783);
					expr(0);
					setState(784);
					match(K_THEN);
					setState(785);
					expr(0);
					}
					}
					setState(789); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_WHEN );
				setState(793);
				_la = _input.LA(1);
				if (_la==K_ELSE) {
					{
					setState(791);
					match(K_ELSE);
					setState(792);
					expr(0);
					}
				}

				setState(795);
				match(K_END);
				}
				break;
			case 9:
				{
				setState(797);
				raise_function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(900);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(898);
					switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(800);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(801);
						match(T__0);
						setState(802);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(803);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(804);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5 || _la==C3) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(805);
						expr(19);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(806);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(807);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(808);
						expr(18);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(809);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(810);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(811);
						expr(17);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(812);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(813);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(814);
						expr(16);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(815);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(828);
						switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
						case 1:
							{
							setState(816);
							match(T__16);
							}
							break;
						case 2:
							{
							setState(817);
							match(T__17);
							}
							break;
						case 3:
							{
							setState(818);
							match(T__18);
							}
							break;
						case 4:
							{
							setState(819);
							match(T__19);
							}
							break;
						case 5:
							{
							setState(820);
							match(K_IS);
							}
							break;
						case 6:
							{
							setState(821);
							match(K_IS);
							setState(822);
							match(K_NOT);
							}
							break;
						case 7:
							{
							setState(823);
							match(K_IN);
							}
							break;
						case 8:
							{
							setState(824);
							match(K_LIKE);
							}
							break;
						case 9:
							{
							setState(825);
							match(K_GLOB);
							}
							break;
						case 10:
							{
							setState(826);
							match(K_MATCH);
							}
							break;
						case 11:
							{
							setState(827);
							match(K_REGEXP);
							}
							break;
						}
						setState(830);
						expr(15);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(831);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(832);
						match(K_AND);
						setState(833);
						expr(14);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(834);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(835);
						match(K_OR);
						setState(836);
						expr(13);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(837);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(838);
						match(K_IS);
						setState(840);
						switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
						case 1:
							{
							setState(839);
							match(K_NOT);
							}
							break;
						}
						setState(842);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(843);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(845);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(844);
							match(K_NOT);
							}
						}

						setState(847);
						match(K_BETWEEN);
						setState(848);
						expr(0);
						setState(849);
						match(K_AND);
						setState(850);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(852);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(853);
						match(K_COLLATE);
						setState(854);
						collation_name();
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(855);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(857);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(856);
							match(K_NOT);
							}
						}

						setState(859);
						_la = _input.LA(1);
						if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & ((1L << (K_GLOB - 47)) | (1L << (K_LIKE - 47)) | (1L << (K_MATCH - 47)) | (1L << (K_REGEXP - 47)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(860);
						expr(0);
						setState(863);
						switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
						case 1:
							{
							setState(861);
							match(K_ESCAPE);
							setState(862);
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
						setState(865);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(870);
						switch (_input.LA(1)) {
						case K_ISNULL:
							{
							setState(866);
							match(K_ISNULL);
							}
							break;
						case K_NOTNULL:
							{
							setState(867);
							match(K_NOTNULL);
							}
							break;
						case K_NOT:
							{
							setState(868);
							match(K_NOT);
							setState(869);
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
						setState(872);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(874);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(873);
							match(K_NOT);
							}
						}

						setState(876);
						match(K_IN);
						setState(896);
						switch (_input.LA(1)) {
						case OPEN_PARENTHESE:
							{
							setState(877);
							match(OPEN_PARENTHESE);
							setState(887);
							switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
							case 1:
								{
								setState(878);
								select_stmt();
								}
								break;
							case 2:
								{
								setState(879);
								expr(0);
								setState(884);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==C1) {
									{
									{
									setState(880);
									match(C1);
									setState(881);
									expr(0);
									}
									}
									setState(886);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
								break;
							}
							setState(889);
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
							setState(893);
							switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
							case 1:
								{
								setState(890);
								database_name();
								setState(891);
								match(DOT);
								}
								break;
							}
							setState(895);
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
				setState(902);
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
			setState(903);
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
			setState(905);
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
			setState(907);
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
			setState(910); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(909);
				name();
				}
				}
				setState(912); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NO - 64)) | (1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)) | (1L << (IDENTIFIER - 64)))) != 0) );
			setState(924);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				{
				setState(914);
				match(OPEN_PARENTHESE);
				setState(915);
				signed_number();
				setState(916);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				{
				setState(918);
				match(OPEN_PARENTHESE);
				setState(919);
				signed_number();
				setState(920);
				match(C1);
				setState(921);
				signed_number();
				setState(922);
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
			setState(926);
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
			setState(928);
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
			setState(930);
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
			setState(936);
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
			setState(938);
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
			setState(944);
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
		enterRule(_localctx, 92, RULE_any_name);
		try {
			setState(948);
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
				setState(946);
				keyword();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(947);
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
		enterRule(_localctx, 94, RULE_sl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(950);
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
		enterRule(_localctx, 96, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(953);
			_la = _input.LA(1);
			if (_la==T__6 || _la==T__7) {
				{
				setState(952);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(955);
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
		enterRule(_localctx, 98, RULE_raise_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(957);
			match(K_RAISE);
			setState(958);
			match(OPEN_PARENTHESE);
			setState(963);
			switch (_input.LA(1)) {
			case K_IGNORE:
				{
				setState(959);
				match(K_IGNORE);
				}
				break;
			case K_ABORT:
			case K_FAIL:
			case K_ROLLBACK:
				{
				setState(960);
				_la = _input.LA(1);
				if ( !(((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & ((1L << (K_ABORT - 22)) | (1L << (K_FAIL - 22)) | (1L << (K_ROLLBACK - 22)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(961);
				match(C1);
				setState(962);
				error_message();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(965);
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
		enterRule(_localctx, 100, RULE_error_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(967);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3r\u03cc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\3\2\3\2\5\2l\n\2\3\3\3\3\5\3p\n\3\3\3\5\3s\n\3\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5~\n\5\3\5\3\5\3\5\5\5\u0083\n\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5\u008b\n\5\3\5\3\5\7\5\u008f\n\5\f\5\16\5\u0092\13\5\3\5"+
		"\5\5\u0095\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6\u00a6\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b0\n\7\3\7\3"+
		"\7\5\7\u00b4\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00be\n\7\3\7\3\7"+
		"\5\7\u00c2\n\7\5\7\u00c4\n\7\3\b\3\b\3\t\3\t\3\t\5\t\u00cb\n\t\3\n\3\n"+
		"\3\n\3\n\5\n\u00d1\n\n\7\n\u00d3\n\n\f\n\16\n\u00d6\13\n\3\13\3\13\3\13"+
		"\7\13\u00db\n\13\f\13\16\13\u00de\13\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e6"+
		"\n\f\3\r\5\r\u00e9\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00f0\n\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00f6\n\r\7\r\u00f8\n\r\f\r\16\r\u00fb\13\r\7\r\u00fd\n\r\f\r\16"+
		"\r\u0100\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0109\n\r\3\r\3\r\3\r\3"+
		"\r\5\r\u010f\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u011a"+
		"\n\16\f\16\16\16\u011d\13\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0125"+
		"\n\16\f\16\16\16\u0128\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\7\16\u0133\n\16\f\16\16\16\u0136\13\16\3\16\3\16\3\16\3\16\7\16\u013c"+
		"\n\16\f\16\16\16\u013f\13\16\5\16\u0141\n\16\3\17\3\17\5\17\u0145\n\17"+
		"\3\20\3\20\3\20\3\21\3\21\6\21\u014c\n\21\r\21\16\21\u014d\3\21\7\21\u0151"+
		"\n\21\f\21\16\21\u0154\13\21\3\21\7\21\u0157\n\21\f\21\16\21\u015a\13"+
		"\21\3\22\3\22\5\22\u015e\n\22\3\23\3\23\5\23\u0162\n\23\3\23\3\23\3\23"+
		"\7\23\u0167\n\23\f\23\16\23\u016a\13\23\5\23\u016c\n\23\3\23\3\23\3\23"+
		"\3\23\7\23\u0172\n\23\f\23\16\23\u0175\13\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u017c\n\23\f\23\16\23\u017f\13\23\5\23\u0181\n\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0187\n\23\5\23\u0189\n\23\3\24\3\24\5\24\u018d\n\24\3\24\3"+
		"\24\3\24\7\24\u0192\n\24\f\24\16\24\u0195\13\24\5\24\u0197\n\24\3\24\3"+
		"\24\3\24\3\24\7\24\u019d\n\24\f\24\16\24\u01a0\13\24\3\24\5\24\u01a3\n"+
		"\24\3\24\5\24\u01a6\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25"+
		"\u01b0\n\25\f\25\16\25\u01b3\13\25\3\25\3\25\5\25\u01b7\n\25\5\25\u01b9"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\7\25\u01c0\n\25\f\25\16\25\u01c3\13\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u01cb\n\25\f\25\16\25\u01ce\13\25"+
		"\3\25\3\25\7\25\u01d2\n\25\f\25\16\25\u01d5\13\25\5\25\u01d7\n\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01e0\n\26\3\26\5\26\u01e3\n\26\5"+
		"\26\u01e5\n\26\3\27\3\27\3\27\5\27\u01ea\n\27\3\27\3\27\5\27\u01ee\n\27"+
		"\3\27\5\27\u01f1\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u01f8\n\27\3\27\3"+
		"\27\3\27\3\27\7\27\u01fe\n\27\f\27\16\27\u0201\13\27\3\27\5\27\u0204\n"+
		"\27\3\27\3\27\5\27\u0208\n\27\3\27\5\27\u020b\n\27\3\27\3\27\3\27\3\27"+
		"\5\27\u0211\n\27\3\27\5\27\u0214\n\27\5\27\u0216\n\27\3\30\3\30\3\31\3"+
		"\31\5\31\u021c\n\31\3\31\3\31\3\31\7\31\u0221\n\31\f\31\16\31\u0224\13"+
		"\31\5\31\u0226\n\31\3\31\3\31\3\31\3\31\7\31\u022c\n\31\f\31\16\31\u022f"+
		"\13\31\3\31\3\31\3\31\3\31\3\31\7\31\u0236\n\31\f\31\16\31\u0239\13\31"+
		"\5\31\u023b\n\31\3\31\3\31\3\31\3\31\5\31\u0241\n\31\5\31\u0243\n\31\3"+
		"\32\3\32\5\32\u0247\n\32\3\32\3\32\3\32\7\32\u024c\n\32\f\32\16\32\u024f"+
		"\13\32\5\32\u0251\n\32\3\32\3\32\3\32\3\32\7\32\u0257\n\32\f\32\16\32"+
		"\u025a\13\32\3\32\5\32\u025d\n\32\3\32\3\32\5\32\u0261\n\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u0268\n\32\f\32\16\32\u026b\13\32\3\32\3\32\5\32"+
		"\u026f\n\32\5\32\u0271\n\32\3\32\3\32\3\32\3\32\3\32\7\32\u0278\n\32\f"+
		"\32\16\32\u027b\13\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0283\n\32\f"+
		"\32\16\32\u0286\13\32\3\32\3\32\7\32\u028a\n\32\f\32\16\32\u028d\13\32"+
		"\5\32\u028f\n\32\3\33\3\33\3\33\3\33\3\33\5\33\u0296\n\33\3\34\3\34\3"+
		"\34\3\34\5\34\u029c\n\34\3\34\3\34\7\34\u02a0\n\34\f\34\16\34\u02a3\13"+
		"\34\3\35\3\35\5\35\u02a7\n\35\3\35\3\35\5\35\u02ab\n\35\3\35\3\35\5\35"+
		"\u02af\n\35\3\35\3\35\5\35\u02b3\n\35\3\35\3\35\5\35\u02b7\n\35\3\35\5"+
		"\35\u02ba\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u02c3\n\36\f\36"+
		"\16\36\u02c6\13\36\3\36\3\36\5\36\u02ca\n\36\3\37\3\37\3\37\3\37\3\37"+
		"\7\37\u02d1\n\37\f\37\16\37\u02d4\13\37\3\37\3\37\5\37\u02d8\n\37\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \5 \u02e2\n \3 \5 \u02e5\n \3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\5!\u02f0\n!\3!\3!\3!\5!\u02f5\n!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\5!\u0304\n!\3!\5!\u0307\n!\3!\3!\3!\3!\3!\3!\5!\u030f"+
		"\n!\3!\3!\3!\3!\3!\6!\u0316\n!\r!\16!\u0317\3!\3!\5!\u031c\n!\3!\3!\3"+
		"!\5!\u0321\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u033f\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\5!\u034b\n!\3!\3!\3!\5!\u0350\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u035c"+
		"\n!\3!\3!\3!\3!\5!\u0362\n!\3!\3!\3!\3!\3!\5!\u0369\n!\3!\3!\5!\u036d"+
		"\n!\3!\3!\3!\3!\3!\3!\7!\u0375\n!\f!\16!\u0378\13!\5!\u037a\n!\3!\3!\3"+
		"!\3!\5!\u0380\n!\3!\5!\u0383\n!\7!\u0385\n!\f!\16!\u0388\13!\3\"\3\"\3"+
		"#\3#\3$\3$\3%\6%\u0391\n%\r%\16%\u0392\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5"+
		"%\u039f\n%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/"+
		"\3/\3\60\3\60\5\60\u03b7\n\60\3\61\3\61\3\62\5\62\u03bc\n\62\3\62\3\62"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u03c6\n\63\3\63\3\63\3\64\3\64\3\64"+
		"\2\3@\65\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\\^`bdf\2\20\4\2FF^^\4\2\32\32((\4\2\30\30\32]\4\2\35"+
		"\35\'\'\4\2\7\b``\3\2\t\n\3\2\13\16\3\2\17\22\6\2\61\61>>@@MM\6\2$&EE"+
		"jknn\5\2\t\n\27\27CC\3\2Y]\3\2mn\5\2\30\30..OO\u044f\2h\3\2\2\2\4o\3\2"+
		"\2\2\6t\3\2\2\2\b\u008a\3\2\2\2\n\u00a5\3\2\2\2\f\u00c3\3\2\2\2\16\u00c5"+
		"\3\2\2\2\20\u00c7\3\2\2\2\22\u00cc\3\2\2\2\24\u00d7\3\2\2\2\26\u00e5\3"+
		"\2\2\2\30\u010e\3\2\2\2\32\u0140\3\2\2\2\34\u0144\3\2\2\2\36\u0146\3\2"+
		"\2\2 \u0149\3\2\2\2\"\u015d\3\2\2\2$\u016b\3\2\2\2&\u0196\3\2\2\2(\u01d6"+
		"\3\2\2\2*\u01e4\3\2\2\2,\u0215\3\2\2\2.\u0217\3\2\2\2\60\u0225\3\2\2\2"+
		"\62\u028e\3\2\2\2\64\u0295\3\2\2\2\66\u0297\3\2\2\28\u02b9\3\2\2\2:\u02c9"+
		"\3\2\2\2<\u02cb\3\2\2\2>\u02de\3\2\2\2@\u0320\3\2\2\2B\u0389\3\2\2\2D"+
		"\u038b\3\2\2\2F\u038d\3\2\2\2H\u0390\3\2\2\2J\u03a0\3\2\2\2L\u03a2\3\2"+
		"\2\2N\u03a4\3\2\2\2P\u03a6\3\2\2\2R\u03a8\3\2\2\2T\u03aa\3\2\2\2V\u03ac"+
		"\3\2\2\2X\u03ae\3\2\2\2Z\u03b0\3\2\2\2\\\u03b2\3\2\2\2^\u03b6\3\2\2\2"+
		"`\u03b8\3\2\2\2b\u03bb\3\2\2\2d\u03bf\3\2\2\2f\u03c9\3\2\2\2hi\5\6\4\2"+
		"ik\5\4\3\2jl\5\34\17\2kj\3\2\2\2kl\3\2\2\2l\3\3\2\2\2mp\5\b\5\2np\5\16"+
		"\b\2om\3\2\2\2on\3\2\2\2pr\3\2\2\2qs\7i\2\2rq\3\2\2\2rs\3\2\2\2s\5\3\2"+
		"\2\2tu\7X\2\2uv\7m\2\2v\7\3\2\2\2w\u008b\5\30\r\2xy\7f\2\2yz\5\16\b\2"+
		"z{\7g\2\2{\u008b\3\2\2\2|~\5\26\f\2}|\3\2\2\2}~\3\2\2\2~\u0082\3\2\2\2"+
		"\177\u0080\5Z.\2\u0080\u0081\7a\2\2\u0081\u0083\3\2\2\2\u0082\177\3\2"+
		"\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u008b\5X-\2\u0085\u008b"+
		"\5\n\6\2\u0086\u008b\5\f\7\2\u0087\u008b\5\32\16\2\u0088\u008b\5`\61\2"+
		"\u0089\u008b\7j\2\2\u008aw\3\2\2\2\u008ax\3\2\2\2\u008a}\3\2\2\2\u008a"+
		"\u0085\3\2\2\2\u008a\u0086\3\2\2\2\u008a\u0087\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008a\u0089\3\2\2\2\u008b\u0090\3\2\2\2\u008c\u008d\7\3\2\2\u008d"+
		"\u008f\5\b\5\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0095\7i\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\t\3\2\2\2"+
		"\u0096\u0097\7d\2\2\u0097\u0098\5\16\b\2\u0098\u0099\7e\2\2\u0099\u009a"+
		"\7^\2\2\u009a\u00a6\3\2\2\2\u009b\u009c\7d\2\2\u009c\u009d\5\16\b\2\u009d"+
		"\u009e\7e\2\2\u009e\u009f\7_\2\2\u009f\u00a6\3\2\2\2\u00a0\u00a1\7d\2"+
		"\2\u00a1\u00a2\5\16\b\2\u00a2\u00a3\7e\2\2\u00a3\u00a4\7`\2\2\u00a4\u00a6"+
		"\3\2\2\2\u00a5\u0096\3\2\2\2\u00a5\u009b\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a6"+
		"\13\3\2\2\2\u00a7\u00a8\7d\2\2\u00a8\u00a9\5\16\b\2\u00a9\u00aa\7e\2\2"+
		"\u00aa\u00b3\7^\2\2\u00ab\u00ac\7j\2\2\u00ac\u00af\7_\2\2\u00ad\u00ae"+
		"\7j\2\2\u00ae\u00b0\7`\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b4\3\2\2\2\u00b1\u00b2\7j\2\2\u00b2\u00b4\7`\2\2\u00b3\u00ab\3\2\2"+
		"\2\u00b3\u00b1\3\2\2\2\u00b4\u00c4\3\2\2\2\u00b5\u00b6\7d\2\2\u00b6\u00b7"+
		"\5\16\b\2\u00b7\u00b8\7e\2\2\u00b8\u00c1\7_\2\2\u00b9\u00ba\7j\2\2\u00ba"+
		"\u00bd\7^\2\2\u00bb\u00bc\7j\2\2\u00bc\u00be\7`\2\2\u00bd\u00bb\3\2\2"+
		"\2\u00bd\u00be\3\2\2\2\u00be\u00c2\3\2\2\2\u00bf\u00c0\7j\2\2\u00c0\u00c2"+
		"\7`\2\2\u00c1\u00b9\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u00a7\3\2\2\2\u00c3\u00b5\3\2\2\2\u00c4\r\3\2\2\2\u00c5\u00c6\5\20\t"+
		"\2\u00c6\17\3\2\2\2\u00c7\u00ca\5\22\n\2\u00c8\u00c9\7`\2\2\u00c9\u00cb"+
		"\5\b\5\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\21\3\2\2\2\u00cc"+
		"\u00d4\5\24\13\2\u00cd\u00d0\7_\2\2\u00ce\u00d1\5\24\13\2\u00cf\u00d1"+
		"\5\b\5\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00cd\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\23\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00dc\5\b\5\2\u00d8\u00d9"+
		"\7^\2\2\u00d9\u00db\5\b\5\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\25\3\2\2\2\u00de\u00dc\3\2\2"+
		"\2\u00df\u00e0\7b\2\2\u00e0\u00e1\7\35\2\2\u00e1\u00e6\7c\2\2\u00e2\u00e3"+
		"\7b\2\2\u00e3\u00e4\7\'\2\2\u00e4\u00e6\7c\2\2\u00e5\u00df\3\2\2\2\u00e5"+
		"\u00e2\3\2\2\2\u00e6\27\3\2\2\2\u00e7\u00e9\7\4\2\2\u00e8\u00e7\3\2\2"+
		"\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\5J&\2\u00eb\u00fe"+
		"\7b\2\2\u00ec\u00f0\5\b\5\2\u00ed\u00f0\5\16\b\2\u00ee\u00f0\5@!\2\u00ef"+
		"\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f9\3\2"+
		"\2\2\u00f1\u00f5\7^\2\2\u00f2\u00f6\5\b\5\2\u00f3\u00f6\5\16\b\2\u00f4"+
		"\u00f6\5@!\2\u00f5\u00f2\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2\2"+
		"\2\u00f6\u00f8\3\2\2\2\u00f7\u00f1\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u00ef\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2"+
		"\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\7c\2\2\u0102"+
		"\u010f\3\2\2\2\u0103\u0104\5L\'\2\u0104\u0108\7d\2\2\u0105\u0106\5Z.\2"+
		"\u0106\u0107\7a\2\2\u0107\u0109\3\2\2\2\u0108\u0105\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\5X-\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010d\7e\2\2\u010d\u010f\3\2\2\2\u010e\u00e8\3\2\2\2\u010e\u0103\3\2"+
		"\2\2\u010f\31\3\2\2\2\u0110\u0111\7\64\2\2\u0111\u0112\7b\2\2\u0112\u0113"+
		"\5@!\2\u0113\u0114\7c\2\2\u0114\u0115\7Q\2\2\u0115\u0116\7b\2\2\u0116"+
		"\u011b\5\b\5\2\u0117\u0118\7^\2\2\u0118\u011a\5\b\5\2\u0119\u0117\3\2"+
		"\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\7c\2\2\u011f\u0120\7)\2"+
		"\2\u0120\u0121\7b\2\2\u0121\u0126\5\b\5\2\u0122\u0123\7^\2\2\u0123\u0125"+
		"\5\b\5\2\u0124\u0122\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012a\7c"+
		"\2\2\u012a\u0141\3\2\2\2\u012b\u012c\7b\2\2\u012c\u012d\5@!\2\u012d\u012e"+
		"\7c\2\2\u012e\u012f\7\5\2\2\u012f\u0134\5\b\5\2\u0130\u0131\7^\2\2\u0131"+
		"\u0133\5\b\5\2\u0132\u0130\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2"+
		"\2\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0134\3\2\2\2\u0137"+
		"\u0138\7\6\2\2\u0138\u013d\5\b\5\2\u0139\u013a\7^\2\2\u013a\u013c\5\b"+
		"\5\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0110\3\2"+
		"\2\2\u0140\u012b\3\2\2\2\u0141\33\3\2\2\2\u0142\u0145\5 \21\2\u0143\u0145"+
		"\5\36\20\2\u0144\u0142\3\2\2\2\u0144\u0143\3\2\2\2\u0145\35\3\2\2\2\u0146"+
		"\u0147\7r\2\2\u0147\u0148\b\20\1\2\u0148\37\3\2\2\2\u0149\u0152\5\"\22"+
		"\2\u014a\u014c\7h\2\2\u014b\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014b"+
		"\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\5\"\22\2"+
		"\u0150\u014b\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u0158\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0157\7h\2\2\u0156"+
		"\u0155\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159!\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015e\5$\23\2\u015c\u015e"+
		"\5\60\31\2\u015d\u015b\3\2\2\2\u015d\u015c\3\2\2\2\u015e#\3\2\2\2\u015f"+
		"\u0161\7W\2\2\u0160\u0162\7L\2\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2"+
		"\2\u0162\u0163\3\2\2\2\u0163\u0168\5<\37\2\u0164\u0165\7^\2\2\u0165\u0167"+
		"\5<\37\2\u0166\u0164\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u015f\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0173\5&\24\2\u016e"+
		"\u016f\5\64\33\2\u016f\u0170\5&\24\2\u0170\u0172\3\2\2\2\u0171\u016e\3"+
		"\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u0180\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0177\7I\2\2\u0177\u0178\7\37"+
		"\2\2\u0178\u017d\5> \2\u0179\u017a\7^\2\2\u017a\u017c\5> \2\u017b\u0179"+
		"\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0176\3\2\2\2\u0180\u0181\3\2"+
		"\2\2\u0181\u0188\3\2\2\2\u0182\u0183\7?\2\2\u0183\u0186\5@!\2\u0184\u0185"+
		"\t\2\2\2\u0185\u0187\5@!\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0189\3\2\2\2\u0188\u0182\3\2\2\2\u0188\u0189\3\2\2\2\u0189%\3\2\2\2"+
		"\u018a\u018c\7P\2\2\u018b\u018d\t\3\2\2\u018c\u018b\3\2\2\2\u018c\u018d"+
		"\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u0193\5*\26\2\u018f\u0190\7^\2\2\u0190"+
		"\u0192\5*\26\2\u0191\u018f\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2"+
		"\2\2\u0193\u0194\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0196"+
		"\u018a\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u01a2\7\60"+
		"\2\2\u0199\u019e\5,\27\2\u019a\u019b\7^\2\2\u019b\u019d\5,\27\2\u019c"+
		"\u019a\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2"+
		"\2\2\u019f\u01a3\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a3\5\66\34\2\u01a2"+
		"\u0199\3\2\2\2\u01a2\u01a1\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a6\5("+
		"\25\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\'\3\2\2\2\u01a7\u01a8"+
		"\7V\2\2\u01a8\u01a9\5@!\2\u01a9\u01b8\3\2\2\2\u01aa\u01ab\7\62\2\2\u01ab"+
		"\u01ac\7\37\2\2\u01ac\u01b1\5@!\2\u01ad\u01ae\7^\2\2\u01ae\u01b0\5@!\2"+
		"\u01af\u01ad\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2"+
		"\3\2\2\2\u01b2\u01b6\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\7\63\2\2"+
		"\u01b5\u01b7\5@!\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9"+
		"\3\2\2\2\u01b8\u01aa\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01d7\3\2\2\2\u01ba"+
		"\u01bb\7T\2\2\u01bb\u01bc\7b\2\2\u01bc\u01c1\5@!\2\u01bd\u01be\7^\2\2"+
		"\u01be\u01c0\5@!\2\u01bf\u01bd\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01bf"+
		"\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c4\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4"+
		"\u01d3\7c\2\2\u01c5\u01c6\7^\2\2\u01c6\u01c7\7b\2\2\u01c7\u01cc\5@!\2"+
		"\u01c8\u01c9\7^\2\2\u01c9\u01cb\5@!\2\u01ca\u01c8\3\2\2\2\u01cb\u01ce"+
		"\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce"+
		"\u01cc\3\2\2\2\u01cf\u01d0\7c\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01c5\3\2"+
		"\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4"+
		"\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6\u01a7\3\2\2\2\u01d6\u01ba\3\2"+
		"\2\2\u01d7)\3\2\2\2\u01d8\u01e5\7\7\2\2\u01d9\u01da\5T+\2\u01da\u01db"+
		"\7a\2\2\u01db\u01dc\7\7\2\2\u01dc\u01e5\3\2\2\2\u01dd\u01e2\5@!\2\u01de"+
		"\u01e0\7\34\2\2\u01df\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\3"+
		"\2\2\2\u01e1\u01e3\5V,\2\u01e2\u01df\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3"+
		"\u01e5\3\2\2\2\u01e4\u01d8\3\2\2\2\u01e4\u01d9\3\2\2\2\u01e4\u01dd\3\2"+
		"\2\2\u01e5+\3\2\2\2\u01e6\u01e7\5R*\2\u01e7\u01e8\7a\2\2\u01e8\u01ea\3"+
		"\2\2\2\u01e9\u01e6\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb"+
		"\u01f0\5T+\2\u01ec\u01ee\7\34\2\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2"+
		"\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f1\5Z.\2\u01f0\u01ed\3\2\2\2\u01f0\u01f1"+
		"\3\2\2\2\u01f1\u01f7\3\2\2\2\u01f2\u01f3\7\67\2\2\u01f3\u01f4\7\37\2\2"+
		"\u01f4\u01f8\5\\/\2\u01f5\u01f6\7C\2\2\u01f6\u01f8\7\67\2\2\u01f7\u01f2"+
		"\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u0216\3\2\2\2\u01f9"+
		"\u0203\7b\2\2\u01fa\u01ff\5,\27\2\u01fb\u01fc\7^\2\2\u01fc\u01fe\5,\27"+
		"\2\u01fd\u01fb\3\2\2\2\u01fe\u0201\3\2\2\2\u01ff\u01fd\3\2\2\2\u01ff\u0200"+
		"\3\2\2\2\u0200\u0204\3\2\2\2\u0201\u01ff\3\2\2\2\u0202\u0204\5\66\34\2"+
		"\u0203\u01fa\3\2\2\2\u0203\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u020a"+
		"\7c\2\2\u0206\u0208\7\34\2\2\u0207\u0206\3\2\2\2\u0207\u0208\3\2\2\2\u0208"+
		"\u0209\3\2\2\2\u0209\u020b\5Z.\2\u020a\u0207\3\2\2\2\u020a\u020b\3\2\2"+
		"\2\u020b\u0216\3\2\2\2\u020c\u020d\7b\2\2\u020d\u020e\5\60\31\2\u020e"+
		"\u0213\7c\2\2\u020f\u0211\7\34\2\2\u0210\u020f\3\2\2\2\u0210\u0211\3\2"+
		"\2\2\u0211\u0212\3\2\2\2\u0212\u0214\5Z.\2\u0213\u0210\3\2\2\2\u0213\u0214"+
		"\3\2\2\2\u0214\u0216\3\2\2\2\u0215\u01e9\3\2\2\2\u0215\u01f9\3\2\2\2\u0215"+
		"\u020c\3\2\2\2\u0216-\3\2\2\2\u0217\u0218\t\4\2\2\u0218/\3\2\2\2\u0219"+
		"\u021b\7W\2\2\u021a\u021c\7L\2\2\u021b\u021a\3\2\2\2\u021b\u021c\3\2\2"+
		"\2\u021c\u021d\3\2\2\2\u021d\u0222\5<\37\2\u021e\u021f\7^\2\2\u021f\u0221"+
		"\5<\37\2\u0220\u021e\3\2\2\2\u0221\u0224\3\2\2\2\u0222\u0220\3\2\2\2\u0222"+
		"\u0223\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0225\u0219\3\2"+
		"\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u022d\5\62\32\2\u0228"+
		"\u0229\5\64\33\2\u0229\u022a\5\62\32\2\u022a\u022c\3\2\2\2\u022b\u0228"+
		"\3\2\2\2\u022c\u022f\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e"+
		"\u023a\3\2\2\2\u022f\u022d\3\2\2\2\u0230\u0231\7I\2\2\u0231\u0232\7\37"+
		"\2\2\u0232\u0237\5> \2\u0233\u0234\7^\2\2\u0234\u0236\5> \2\u0235\u0233"+
		"\3\2\2\2\u0236\u0239\3\2\2\2\u0237\u0235\3\2\2\2\u0237\u0238\3\2\2\2\u0238"+
		"\u023b\3\2\2\2\u0239\u0237\3\2\2\2\u023a\u0230\3\2\2\2\u023a\u023b\3\2"+
		"\2\2\u023b\u0242\3\2\2\2\u023c\u023d\7?\2\2\u023d\u0240\5@!\2\u023e\u023f"+
		"\t\2\2\2\u023f\u0241\5@!\2\u0240\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241"+
		"\u0243\3\2\2\2\u0242\u023c\3\2\2\2\u0242\u0243\3\2\2\2\u0243\61\3\2\2"+
		"\2\u0244\u0246\7P\2\2\u0245\u0247\t\3\2\2\u0246\u0245\3\2\2\2\u0246\u0247"+
		"\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u024d\5*\26\2\u0249\u024a\7^\2\2\u024a"+
		"\u024c\5*\26\2\u024b\u0249\3\2\2\2\u024c\u024f\3\2\2\2\u024d\u024b\3\2"+
		"\2\2\u024d\u024e\3\2\2\2\u024e\u0251\3\2\2\2\u024f\u024d\3\2\2\2\u0250"+
		"\u0244\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u025c\7\60"+
		"\2\2\u0253\u0258\5,\27\2\u0254\u0255\7^\2\2\u0255\u0257\5,\27\2\u0256"+
		"\u0254\3\2\2\2\u0257\u025a\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2"+
		"\2\2\u0259\u025d\3\2\2\2\u025a\u0258\3\2\2\2\u025b\u025d\5\66\34\2\u025c"+
		"\u0253\3\2\2\2\u025c\u025b\3\2\2\2\u025d\u0260\3\2\2\2\u025e\u025f\7V"+
		"\2\2\u025f\u0261\5@!\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0270"+
		"\3\2\2\2\u0262\u0263\7\62\2\2\u0263\u0264\7\37\2\2\u0264\u0269\5@!\2\u0265"+
		"\u0266\7^\2\2\u0266\u0268\5@!\2\u0267\u0265\3\2\2\2\u0268\u026b\3\2\2"+
		"\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026e\3\2\2\2\u026b\u0269"+
		"\3\2\2\2\u026c\u026d\7\63\2\2\u026d\u026f\5@!\2\u026e\u026c\3\2\2\2\u026e"+
		"\u026f\3\2\2\2\u026f\u0271\3\2\2\2\u0270\u0262\3\2\2\2\u0270\u0271\3\2"+
		"\2\2\u0271\u028f\3\2\2\2\u0272\u0273\7T\2\2\u0273\u0274\7b\2\2\u0274\u0279"+
		"\5@!\2\u0275\u0276\7^\2\2\u0276\u0278\5@!\2\u0277\u0275\3\2\2\2\u0278"+
		"\u027b\3\2\2\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027c\3\2"+
		"\2\2\u027b\u0279\3\2\2\2\u027c\u028b\7c\2\2\u027d\u027e\7^\2\2\u027e\u027f"+
		"\7b\2\2\u027f\u0284\5@!\2\u0280\u0281\7^\2\2\u0281\u0283\5@!\2\u0282\u0280"+
		"\3\2\2\2\u0283\u0286\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0285\3\2\2\2\u0285"+
		"\u0287\3\2\2\2\u0286\u0284\3\2\2\2\u0287\u0288\7c\2\2\u0288\u028a\3\2"+
		"\2\2\u0289\u027d\3\2\2\2\u028a\u028d\3\2\2\2\u028b\u0289\3\2\2\2\u028b"+
		"\u028c\3\2\2\2\u028c\u028f\3\2\2\2\u028d\u028b\3\2\2\2\u028e\u0250\3\2"+
		"\2\2\u028e\u0272\3\2\2\2\u028f\63\3\2\2\2\u0290\u0296\7R\2\2\u0291\u0292"+
		"\7R\2\2\u0292\u0296\7\32\2\2\u0293\u0296\79\2\2\u0294\u0296\7,\2\2\u0295"+
		"\u0290\3\2\2\2\u0295\u0291\3\2\2\2\u0295\u0293\3\2\2\2\u0295\u0294\3\2"+
		"\2\2\u0296\65\3\2\2\2\u0297\u02a1\5,\27\2\u0298\u029b\58\35\2\u0299\u029c"+
		"\5\66\34\2\u029a\u029c\5,\27\2\u029b\u0299\3\2\2\2\u029b\u029a\3\2\2\2"+
		"\u029c\u029d\3\2\2\2\u029d\u029e\5:\36\2\u029e\u02a0\3\2\2\2\u029f\u0298"+
		"\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2"+
		"\67\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02ba\7^\2\2\u02a5\u02a7\7A\2\2"+
		"\u02a6\u02a5\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02b6\3\2\2\2\u02a8\u02aa"+
		"\7=\2\2\u02a9\u02ab\7J\2\2\u02aa\u02a9\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab"+
		"\u02b7\3\2\2\2\u02ac\u02ae\7N\2\2\u02ad\u02af\7J\2\2\u02ae\u02ad\3\2\2"+
		"\2\u02ae\u02af\3\2\2\2\u02af\u02b7\3\2\2\2\u02b0\u02b2\7/\2\2\u02b1\u02b3"+
		"\7J\2\2\u02b2\u02b1\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b7\3\2\2\2\u02b4"+
		"\u02b7\78\2\2\u02b5\u02b7\7#\2\2\u02b6\u02a8\3\2\2\2\u02b6\u02ac\3\2\2"+
		"\2\u02b6\u02b0\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b6\u02b5\3\2\2\2\u02b6\u02b7"+
		"\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02ba\7<\2\2\u02b9\u02a4\3\2\2\2\u02b9"+
		"\u02a6\3\2\2\2\u02ba9\3\2\2\2\u02bb\u02bc\7G\2\2\u02bc\u02ca\5@!\2\u02bd"+
		"\u02be\7S\2\2\u02be\u02bf\7b\2\2\u02bf\u02c4\5X-\2\u02c0\u02c1\7^\2\2"+
		"\u02c1\u02c3\5X-\2\u02c2\u02c0\3\2\2\2\u02c3\u02c6\3\2\2\2\u02c4\u02c2"+
		"\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c7\3\2\2\2\u02c6\u02c4\3\2\2\2\u02c7"+
		"\u02c8\7c\2\2\u02c8\u02ca\3\2\2\2\u02c9\u02bb\3\2\2\2\u02c9\u02bd\3\2"+
		"\2\2\u02c9\u02ca\3\2\2\2\u02ca;\3\2\2\2\u02cb\u02d7\5T+\2\u02cc\u02cd"+
		"\7b\2\2\u02cd\u02d2\5X-\2\u02ce\u02cf\7^\2\2\u02cf\u02d1\5X-\2\u02d0\u02ce"+
		"\3\2\2\2\u02d1\u02d4\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3"+
		"\u02d5\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d5\u02d6\7c\2\2\u02d6\u02d8\3\2"+
		"\2\2\u02d7\u02cc\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9"+
		"\u02da\7\34\2\2\u02da\u02db\7b\2\2\u02db\u02dc\5\60\31\2\u02dc\u02dd\7"+
		"c\2\2\u02dd=\3\2\2\2\u02de\u02e1\5@!\2\u02df\u02e0\7\"\2\2\u02e0\u02e2"+
		"\5P)\2\u02e1\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e4\3\2\2\2\u02e3"+
		"\u02e5\t\5\2\2\u02e4\u02e3\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5?\3\2\2\2"+
		"\u02e6\u02e7\b!\1\2\u02e7\u02e8\5D#\2\u02e8\u02e9\5@!\26\u02e9\u0321\3"+
		"\2\2\2\u02ea\u0321\5B\"\2\u02eb\u0321\7l\2\2\u02ec\u02ed\5R*\2\u02ed\u02ee"+
		"\7a\2\2\u02ee\u02f0\3\2\2\2\u02ef\u02ec\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0"+
		"\u02f1\3\2\2\2\u02f1\u02f2\5Z.\2\u02f2\u02f3\7a\2\2\u02f3\u02f5\3\2\2"+
		"\2\u02f4\u02ef\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u0321"+
		"\5X-\2\u02f7\u02f8\7b\2\2\u02f8\u02f9\5@!\2\u02f9\u02fa\7c\2\2\u02fa\u0321"+
		"\3\2\2\2\u02fb\u02fc\7!\2\2\u02fc\u02fd\7b\2\2\u02fd\u02fe\5@!\2\u02fe"+
		"\u02ff\7\34\2\2\u02ff\u0300\5H%\2\u0300\u0301\7c\2\2\u0301\u0321\3\2\2"+
		"\2\u0302\u0304\7C\2\2\u0303\u0302\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0305"+
		"\3\2\2\2\u0305\u0307\7-\2\2\u0306\u0303\3\2\2\2\u0306\u0307\3\2\2\2\u0307"+
		"\u0308\3\2\2\2\u0308\u0309\7b\2\2\u0309\u030a\5\60\31\2\u030a\u030b\7"+
		"c\2\2\u030b\u0321\3\2\2\2\u030c\u030e\7 \2\2\u030d\u030f\5@!\2\u030e\u030d"+
		"\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0315\3\2\2\2\u0310\u0311\7U\2\2\u0311"+
		"\u0312\5@!\2\u0312\u0313\7Q\2\2\u0313\u0314\5@!\2\u0314\u0316\3\2\2\2"+
		"\u0315\u0310\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0315\3\2\2\2\u0317\u0318"+
		"\3\2\2\2\u0318\u031b\3\2\2\2\u0319\u031a\7)\2\2\u031a\u031c\5@!\2\u031b"+
		"\u0319\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u031e\7*"+
		"\2\2\u031e\u0321\3\2\2\2\u031f\u0321\5d\63\2\u0320\u02e6\3\2\2\2\u0320"+
		"\u02ea\3\2\2\2\u0320\u02eb\3\2\2\2\u0320\u02f4\3\2\2\2\u0320\u02f7\3\2"+
		"\2\2\u0320\u02fb\3\2\2\2\u0320\u0306\3\2\2\2\u0320\u030c\3\2\2\2\u0320"+
		"\u031f\3\2\2\2\u0321\u0386\3\2\2\2\u0322\u0323\f\25\2\2\u0323\u0324\7"+
		"\3\2\2\u0324\u0385\5@!\26\u0325\u0326\f\24\2\2\u0326\u0327\t\6\2\2\u0327"+
		"\u0385\5@!\25\u0328\u0329\f\23\2\2\u0329\u032a\t\7\2\2\u032a\u0385\5@"+
		"!\24\u032b\u032c\f\22\2\2\u032c\u032d\t\b\2\2\u032d\u0385\5@!\23\u032e"+
		"\u032f\f\21\2\2\u032f\u0330\t\t\2\2\u0330\u0385\5@!\22\u0331\u033e\f\20"+
		"\2\2\u0332\u033f\7\23\2\2\u0333\u033f\7\24\2\2\u0334\u033f\7\25\2\2\u0335"+
		"\u033f\7\26\2\2\u0336\u033f\7:\2\2\u0337\u0338\7:\2\2\u0338\u033f\7C\2"+
		"\2\u0339\u033f\7\66\2\2\u033a\u033f\7>\2\2\u033b\u033f\7\61\2\2\u033c"+
		"\u033f\7@\2\2\u033d\u033f\7M\2\2\u033e\u0332\3\2\2\2\u033e\u0333\3\2\2"+
		"\2\u033e\u0334\3\2\2\2\u033e\u0335\3\2\2\2\u033e\u0336\3\2\2\2\u033e\u0337"+
		"\3\2\2\2\u033e\u0339\3\2\2\2\u033e\u033a\3\2\2\2\u033e\u033b\3\2\2\2\u033e"+
		"\u033c\3\2\2\2\u033e\u033d\3\2\2\2\u033f\u0340\3\2\2\2\u0340\u0385\5@"+
		"!\21\u0341\u0342\f\17\2\2\u0342\u0343\7\33\2\2\u0343\u0385\5@!\20\u0344"+
		"\u0345\f\16\2\2\u0345\u0346\7H\2\2\u0346\u0385\5@!\17\u0347\u0348\f\b"+
		"\2\2\u0348\u034a\7:\2\2\u0349\u034b\7C\2\2\u034a\u0349\3\2\2\2\u034a\u034b"+
		"\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u0385\5@!\t\u034d\u034f\f\7\2\2\u034e"+
		"\u0350\7C\2\2\u034f\u034e\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u0351\3\2"+
		"\2\2\u0351\u0352\7\36\2\2\u0352\u0353\5@!\2\u0353\u0354\7\33\2\2\u0354"+
		"\u0355\5@!\b\u0355\u0385\3\2\2\2\u0356\u0357\f\13\2\2\u0357\u0358\7\""+
		"\2\2\u0358\u0385\5P)\2\u0359\u035b\f\n\2\2\u035a\u035c\7C\2\2\u035b\u035a"+
		"\3\2\2\2\u035b\u035c\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u035e\t\n\2\2\u035e"+
		"\u0361\5@!\2\u035f\u0360\7+\2\2\u0360\u0362\5@!\2\u0361\u035f\3\2\2\2"+
		"\u0361\u0362\3\2\2\2\u0362\u0385\3\2\2\2\u0363\u0368\f\t\2\2\u0364\u0369"+
		"\7;\2\2\u0365\u0369\7D\2\2\u0366\u0367\7C\2\2\u0367\u0369\7E\2\2\u0368"+
		"\u0364\3\2\2\2\u0368\u0365\3\2\2\2\u0368\u0366\3\2\2\2\u0369\u0385\3\2"+
		"\2\2\u036a\u036c\f\6\2\2\u036b\u036d\7C\2\2\u036c\u036b\3\2\2\2\u036c"+
		"\u036d\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u0382\7\66\2\2\u036f\u0379\7"+
		"b\2\2\u0370\u037a\5\60\31\2\u0371\u0376\5@!\2\u0372\u0373\7^\2\2\u0373"+
		"\u0375\5@!\2\u0374\u0372\3\2\2\2\u0375\u0378\3\2\2\2\u0376\u0374\3\2\2"+
		"\2\u0376\u0377\3\2\2\2\u0377\u037a\3\2\2\2\u0378\u0376\3\2\2\2\u0379\u0370"+
		"\3\2\2\2\u0379\u0371\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u037b\3\2\2\2\u037b"+
		"\u0383\7c\2\2\u037c\u037d\5R*\2\u037d\u037e\7a\2\2\u037e\u0380\3\2\2\2"+
		"\u037f\u037c\3\2\2\2\u037f\u0380\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0383"+
		"\5T+\2\u0382\u036f\3\2\2\2\u0382\u037f\3\2\2\2\u0383\u0385\3\2\2\2\u0384"+
		"\u0322\3\2\2\2\u0384\u0325\3\2\2\2\u0384\u0328\3\2\2\2\u0384\u032b\3\2"+
		"\2\2\u0384\u032e\3\2\2\2\u0384\u0331\3\2\2\2\u0384\u0341\3\2\2\2\u0384"+
		"\u0344\3\2\2\2\u0384\u0347\3\2\2\2\u0384\u034d\3\2\2\2\u0384\u0356\3\2"+
		"\2\2\u0384\u0359\3\2\2\2\u0384\u0363\3\2\2\2\u0384\u036a\3\2\2\2\u0385"+
		"\u0388\3\2\2\2\u0386\u0384\3\2\2\2\u0386\u0387\3\2\2\2\u0387A\3\2\2\2"+
		"\u0388\u0386\3\2\2\2\u0389\u038a\t\13\2\2\u038aC\3\2\2\2\u038b\u038c\t"+
		"\f\2\2\u038cE\3\2\2\2\u038d\u038e\5^\60\2\u038eG\3\2\2\2\u038f\u0391\5"+
		"F$\2\u0390\u038f\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u0390\3\2\2\2\u0392"+
		"\u0393\3\2\2\2\u0393\u039e\3\2\2\2\u0394\u0395\7b\2\2\u0395\u0396\5b\62"+
		"\2\u0396\u0397\7c\2\2\u0397\u039f\3\2\2\2\u0398\u0399\7b\2\2\u0399\u039a"+
		"\5b\62\2\u039a\u039b\7^\2\2\u039b\u039c\5b\62\2\u039c\u039d\7c\2\2\u039d"+
		"\u039f\3\2\2\2\u039e\u0394\3\2\2\2\u039e\u0398\3\2\2\2\u039e\u039f\3\2"+
		"\2\2\u039fI\3\2\2\2\u03a0\u03a1\5^\60\2\u03a1K\3\2\2\2\u03a2\u03a3\5N"+
		"(\2\u03a3M\3\2\2\2\u03a4\u03a5\t\r\2\2\u03a5O\3\2\2\2\u03a6\u03a7\5^\60"+
		"\2\u03a7Q\3\2\2\2\u03a8\u03a9\5^\60\2\u03a9S\3\2\2\2\u03aa\u03ab\5^\60"+
		"\2\u03abU\3\2\2\2\u03ac\u03ad\t\16\2\2\u03adW\3\2\2\2\u03ae\u03af\5^\60"+
		"\2\u03afY\3\2\2\2\u03b0\u03b1\5^\60\2\u03b1[\3\2\2\2\u03b2\u03b3\5^\60"+
		"\2\u03b3]\3\2\2\2\u03b4\u03b7\5.\30\2\u03b5\u03b7\7m\2\2\u03b6\u03b4\3"+
		"\2\2\2\u03b6\u03b5\3\2\2\2\u03b7_\3\2\2\2\u03b8\u03b9\7n\2\2\u03b9a\3"+
		"\2\2\2\u03ba\u03bc\t\7\2\2\u03bb\u03ba\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc"+
		"\u03bd\3\2\2\2\u03bd\u03be\7j\2\2\u03bec\3\2\2\2\u03bf\u03c0\7K\2\2\u03c0"+
		"\u03c5\7b\2\2\u03c1\u03c6\7\65\2\2\u03c2\u03c3\t\17\2\2\u03c3\u03c4\7"+
		"^\2\2\u03c4\u03c6\5f\64\2\u03c5\u03c1\3\2\2\2\u03c5\u03c2\3\2\2\2\u03c6"+
		"\u03c7\3\2\2\2\u03c7\u03c8\7c\2\2\u03c8e\3\2\2\2\u03c9\u03ca\7n\2\2\u03ca"+
		"g\3\2\2\2\u0087kor}\u0082\u008a\u0090\u0094\u00a5\u00af\u00b3\u00bd\u00c1"+
		"\u00c3\u00ca\u00d0\u00d4\u00dc\u00e5\u00e8\u00ef\u00f5\u00f9\u00fe\u0108"+
		"\u010e\u011b\u0126\u0134\u013d\u0140\u0144\u014d\u0152\u0158\u015d\u0161"+
		"\u0168\u016b\u0173\u017d\u0180\u0186\u0188\u018c\u0193\u0196\u019e\u01a2"+
		"\u01a5\u01b1\u01b6\u01b8\u01c1\u01cc\u01d3\u01d6\u01df\u01e2\u01e4\u01e9"+
		"\u01ed\u01f0\u01f7\u01ff\u0203\u0207\u020a\u0210\u0213\u0215\u021b\u0222"+
		"\u0225\u022d\u0237\u023a\u0240\u0242\u0246\u024d\u0250\u0258\u025c\u0260"+
		"\u0269\u026e\u0270\u0279\u0284\u028b\u028e\u0295\u029b\u02a1\u02a6\u02aa"+
		"\u02ae\u02b2\u02b6\u02b9\u02c4\u02c9\u02d2\u02d7\u02e1\u02e4\u02ef\u02f4"+
		"\u0303\u0306\u030e\u0317\u031b\u0320\u033e\u034a\u034f\u035b\u0361\u0368"+
		"\u036c\u0376\u0379\u037f\u0382\u0384\u0386\u0392\u039e\u03b6\u03bb\u03c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}