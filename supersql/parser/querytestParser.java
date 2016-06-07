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
		RULE_aggregate = 13, RULE_if_then_else = 14, RULE_from_where = 15, RULE_error = 16, 
		RULE_sql_stmt_list = 17, RULE_sql_stmt = 18, RULE_factored_select_stmt = 19, 
		RULE_select_core = 20, RULE_where = 21, RULE_result_column = 22, RULE_table_or_subquery = 23, 
		RULE_keyword = 24, RULE_select_stmt = 25, RULE_select_or_values = 26, 
		RULE_compound_operator = 27, RULE_join_clause = 28, RULE_join_operator = 29, 
		RULE_join_constraint = 30, RULE_common_table_expression = 31, RULE_ordering_term = 32, 
		RULE_expr = 33, RULE_literal_value = 34, RULE_unary_operator = 35, RULE_name = 36, 
		RULE_type_name = 37, RULE_function_name = 38, RULE_ag_function_name = 39, 
		RULE_ag_keyword = 40, RULE_collation_name = 41, RULE_database_name = 42, 
		RULE_table_name = 43, RULE_column_alias = 44, RULE_column_name = 45, RULE_table_alias = 46, 
		RULE_index_name = 47, RULE_any_name = 48, RULE_sl = 49, RULE_signed_number = 50, 
		RULE_raise_function = 51, RULE_error_message = 52;
	public static final String[] ruleNames = {
		"query", "root", "media", "operand", "grouper", "composite_iterator", 
		"exp", "d_exp", "v_exp", "h_exp", "n_exp", "sorting", "function", "aggregate", 
		"if_then_else", "from_where", "error", "sql_stmt_list", "sql_stmt", "factored_select_stmt", 
		"select_core", "where", "result_column", "table_or_subquery", "keyword", 
		"select_stmt", "select_or_values", "compound_operator", "join_clause", 
		"join_operator", "join_constraint", "common_table_expression", "ordering_term", 
		"expr", "literal_value", "unary_operator", "name", "type_name", "function_name", 
		"ag_function_name", "ag_keyword", "collation_name", "database_name", "table_name", 
		"column_alias", "column_name", "table_alias", "index_name", "any_name", 
		"sl", "signed_number", "raise_function", "error_message"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'||'", "'$'", "':'", "'*'", "'/'", "'+'", "'-'", "'<<'", "'>>'", 
		"'&'", "'|'", "'<'", "'<='", "'>'", "'>='", "'='", "'=='", "'!='", "'<>'", 
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
			setState(106);
			media();
			setState(107);
			root();
			setState(109);
			_la = _input.LA(1);
			if (_la==K_FROM || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (K_SELECT - 77)) | (1L << (K_VALUES - 77)) | (1L << (K_WITH - 77)) | (1L << (UNEXPECTED_CHAR - 77)))) != 0)) {
				{
				setState(108);
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
			setState(113);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(111);
				operand();
				}
				break;
			case 2:
				{
				setState(112);
				exp();
				}
				break;
			}
			setState(116);
			_la = _input.LA(1);
			if (_la==DECOLATOR) {
				{
				setState(115);
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
			setState(118);
			match(K_GENERATE);
			setState(119);
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
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(121);
				function();
				}
				break;
			case 2:
				{
				setState(122);
				match(OPEN_BRACE);
				setState(123);
				exp();
				setState(124);
				match(CLOSE_BRACE);
				}
				break;
			case 3:
				{
				setState(127);
				_la = _input.LA(1);
				if (_la==OPEN_PARENTHESE) {
					{
					setState(126);
					sorting();
					}
				}

				{
				setState(132);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(129);
					table_alias();
					setState(130);
					match(DOT);
					}
					break;
				}
				setState(134);
				column_name();
				}
				}
				break;
			case 4:
				{
				setState(135);
				grouper();
				}
				break;
			case 5:
				{
				setState(136);
				composite_iterator();
				}
				break;
			case 6:
				{
				setState(137);
				if_then_else();
				}
				break;
			case 7:
				{
				setState(138);
				sl();
				}
				break;
			case 8:
				{
				setState(139);
				match(NUMERIC_LITERAL);
				}
				break;
			case 9:
				{
				setState(140);
				aggregate();
				}
				break;
			}
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(143);
					match(T__0);
					setState(144);
					operand();
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
			setState(151);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(150);
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
			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(OPEN_BRACKET);
				setState(154);
				exp();
				setState(155);
				match(CLOSE_BRACKET);
				setState(156);
				match(C1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(OPEN_BRACKET);
				setState(159);
				exp();
				setState(160);
				match(CLOSE_BRACKET);
				setState(161);
				match(C2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				match(OPEN_BRACKET);
				setState(164);
				exp();
				setState(165);
				match(CLOSE_BRACKET);
				setState(166);
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
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(OPEN_BRACKET);
				setState(171);
				exp();
				setState(172);
				match(CLOSE_BRACKET);
				setState(173);
				match(C1);
				setState(182);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(174);
					match(NUMERIC_LITERAL);
					setState(175);
					match(C2);
					setState(178);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(176);
						match(NUMERIC_LITERAL);
						setState(177);
						match(C3);
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(180);
					match(NUMERIC_LITERAL);
					setState(181);
					match(C3);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(OPEN_BRACKET);
				setState(185);
				exp();
				setState(186);
				match(CLOSE_BRACKET);
				setState(187);
				match(C2);
				setState(196);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(188);
					match(NUMERIC_LITERAL);
					setState(189);
					match(C1);
					setState(192);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						setState(190);
						match(NUMERIC_LITERAL);
						setState(191);
						match(C3);
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(194);
					match(NUMERIC_LITERAL);
					setState(195);
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
			setState(200);
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
			setState(202);
			v_exp();
			setState(205);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(203);
				match(C3);
				setState(204);
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
			setState(207);
			h_exp();
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(208);
					match(C2);
					setState(211);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						setState(209);
						h_exp();
						}
						break;
					case 2:
						{
						setState(210);
						operand();
						}
						break;
					}
					}
					} 
				}
				setState(217);
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
			setState(220);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(218);
				operand();
				}
				break;
			case 2:
				{
				setState(219);
				n_exp();
				}
				break;
			}
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(222);
					match(C1);
					setState(225);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(223);
						operand();
						}
						break;
					case 2:
						{
						setState(224);
						n_exp();
						}
						break;
					}
					}
					} 
				}
				setState(231);
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
			setState(232);
			operand();
			setState(233);
			match(C0);
			setState(234);
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
			setState(242);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(OPEN_PARENTHESE);
				setState(237);
				match(K_ASC);
				setState(238);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				match(OPEN_PARENTHESE);
				setState(240);
				match(K_DESC);
				setState(241);
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
			setState(245);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(244);
				match(T__1);
				}
			}

			setState(247);
			function_name();
			setState(248);
			match(OPEN_PARENTHESE);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__6) | (1L << T__19) | (1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL) | (1L << K_NO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)) | (1L << (OPEN_PARENTHESE - 64)) | (1L << (OPEN_BRACKET - 64)) | (1L << (OPEN_BRACE - 64)) | (1L << (NUMERIC_LITERAL - 64)) | (1L << (BIND_PARAMETER - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (STRING_LITERAL - 64)))) != 0)) {
				{
				{
				setState(252);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(249);
					operand();
					}
					break;
				case 2:
					{
					setState(250);
					exp();
					}
					break;
				case 3:
					{
					setState(251);
					expr(0);
					}
					break;
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(254);
					match(C1);
					setState(258);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						setState(255);
						operand();
						}
						break;
					case 2:
						{
						setState(256);
						exp();
						}
						break;
					case 3:
						{
						setState(257);
						expr(0);
						}
						break;
					}
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
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
		enterRule(_localctx, 26, RULE_aggregate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			ag_function_name();
			setState(273);
			match(OPEN_BRACKET);
			{
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(274);
				table_alias();
				setState(275);
				match(DOT);
				}
				break;
			}
			setState(279);
			column_name();
			}
			setState(281);
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
		enterRule(_localctx, 28, RULE_if_then_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			switch (_input.LA(1)) {
			case K_IF:
				{
				{
				setState(283);
				match(K_IF);
				setState(284);
				match(OPEN_PARENTHESE);
				setState(285);
				expr(0);
				setState(286);
				match(CLOSE_PARENTHESE);
				setState(287);
				match(K_THEN);
				setState(288);
				match(OPEN_PARENTHESE);
				setState(289);
				exp();
				setState(290);
				match(CLOSE_PARENTHESE);
				setState(291);
				match(K_ELSE);
				setState(292);
				match(OPEN_PARENTHESE);
				setState(293);
				exp();
				setState(294);
				match(CLOSE_PARENTHESE);
				}
				}
				break;
			case OPEN_PARENTHESE:
				{
				{
				setState(296);
				match(OPEN_PARENTHESE);
				setState(297);
				expr(0);
				setState(298);
				match(CLOSE_PARENTHESE);
				setState(299);
				match(C0);
				setState(300);
				exp();
				setState(301);
				match(T__2);
				setState(302);
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
		enterRule(_localctx, 30, RULE_from_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			switch (_input.LA(1)) {
			case K_FROM:
			case K_SELECT:
			case K_VALUES:
			case K_WITH:
				{
				setState(306);
				sql_stmt_list();
				}
				break;
			case UNEXPECTED_CHAR:
				{
				setState(307);
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
		enterRule(_localctx, 32, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
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
		enterRule(_localctx, 34, RULE_sql_stmt_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			sql_stmt();
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(315); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(314);
						match(SEMICOLON);
						}
						}
						setState(317); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SEMICOLON );
					setState(319);
					sql_stmt();
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(325);
				match(SEMICOLON);
				}
				}
				setState(330);
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
		enterRule(_localctx, 36, RULE_sql_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(331);
				factored_select_stmt();
				}
				break;
			case 2:
				{
				setState(332);
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
		enterRule(_localctx, 38, RULE_factored_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(335);
				match(K_WITH);
				setState(337);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(336);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(339);
				common_table_expression();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(340);
					match(C1);
					setState(341);
					common_table_expression();
					}
					}
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(349);
			select_core();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & ((1L << (K_EXCEPT - 41)) | (1L << (K_INTERSECT - 41)) | (1L << (K_UNION - 41)))) != 0)) {
				{
				{
				setState(350);
				compound_operator();
				setState(351);
				select_core();
				}
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(368);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(358);
				match(K_ORDER);
				setState(359);
				match(K_BY);
				setState(360);
				ordering_term();
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(361);
					match(C1);
					setState(362);
					ordering_term();
					}
					}
					setState(367);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(376);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(370);
				match(K_LIMIT);
				setState(371);
				expr(0);
				setState(374);
				_la = _input.LA(1);
				if (_la==K_OFFSET || _la==C1) {
					{
					setState(372);
					_la = _input.LA(1);
					if ( !(_la==K_OFFSET || _la==C1) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(373);
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
		enterRule(_localctx, 40, RULE_select_core);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_la = _input.LA(1);
			if (_la==K_SELECT) {
				{
				setState(378);
				match(K_SELECT);
				setState(380);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(379);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				setState(382);
				result_column();
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(383);
					match(C1);
					setState(384);
					result_column();
					}
					}
					setState(389);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			{
			setState(392);
			match(K_FROM);
			setState(402);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(393);
				table_or_subquery();
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(394);
					match(C1);
					setState(395);
					table_or_subquery();
					}
					}
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(401);
				join_clause();
				}
				break;
			}
			}
			setState(405);
			_la = _input.LA(1);
			if (_la==K_VALUES || _la==K_WHERE) {
				{
				setState(404);
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
		enterRule(_localctx, 42, RULE_where);
		int _la;
		try {
			setState(454);
			switch (_input.LA(1)) {
			case K_WHERE:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(407);
				match(K_WHERE);
				setState(408);
				expr(0);
				}
				setState(424);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(410);
					match(K_GROUP);
					setState(411);
					match(K_BY);
					setState(412);
					expr(0);
					setState(417);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(413);
						match(C1);
						setState(414);
						expr(0);
						}
						}
						setState(419);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(422);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(420);
						match(K_HAVING);
						setState(421);
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
				setState(426);
				match(K_VALUES);
				setState(427);
				match(OPEN_PARENTHESE);
				setState(428);
				expr(0);
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(429);
					match(C1);
					setState(430);
					expr(0);
					}
					}
					setState(435);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(436);
				match(CLOSE_PARENTHESE);
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(437);
					match(C1);
					setState(438);
					match(OPEN_PARENTHESE);
					setState(439);
					expr(0);
					setState(444);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(440);
						match(C1);
						setState(441);
						expr(0);
						}
						}
						setState(446);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(447);
					match(CLOSE_PARENTHESE);
					}
					}
					setState(453);
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
		enterRule(_localctx, 44, RULE_result_column);
		int _la;
		try {
			setState(468);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(456);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(457);
				table_name();
				setState(458);
				match(DOT);
				setState(459);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(461);
				expr(0);
				setState(466);
				_la = _input.LA(1);
				if (_la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(463);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(462);
						match(K_AS);
						}
					}

					setState(465);
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
		enterRule(_localctx, 46, RULE_table_or_subquery);
		int _la;
		try {
			setState(517);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(473);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(470);
					database_name();
					setState(471);
					match(DOT);
					}
					break;
				}
				setState(475);
				table_name();
				setState(480);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(477);
					switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
					case 1:
						{
						setState(476);
						match(K_AS);
						}
						break;
					}
					setState(479);
					table_alias();
					}
					break;
				}
				setState(487);
				switch (_input.LA(1)) {
				case K_INDEXED:
					{
					setState(482);
					match(K_INDEXED);
					setState(483);
					match(K_BY);
					setState(484);
					index_name();
					}
					break;
				case K_NOT:
					{
					setState(485);
					match(K_NOT);
					setState(486);
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
				setState(489);
				match(OPEN_PARENTHESE);
				setState(499);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(490);
					table_or_subquery();
					setState(495);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(491);
						match(C1);
						setState(492);
						table_or_subquery();
						}
						}
						setState(497);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(498);
					join_clause();
					}
					break;
				}
				setState(501);
				match(CLOSE_PARENTHESE);
				setState(506);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(503);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						setState(502);
						match(K_AS);
						}
						break;
					}
					setState(505);
					table_alias();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(508);
				match(OPEN_PARENTHESE);
				setState(509);
				select_stmt();
				setState(510);
				match(CLOSE_PARENTHESE);
				setState(515);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(512);
					switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
					case 1:
						{
						setState(511);
						match(K_AS);
						}
						break;
					}
					setState(514);
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
		enterRule(_localctx, 48, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
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
		enterRule(_localctx, 50, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(521);
				match(K_WITH);
				setState(523);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(522);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(525);
				common_table_expression();
				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(526);
					match(C1);
					setState(527);
					common_table_expression();
					}
					}
					setState(532);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(535);
			select_or_values();
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & ((1L << (K_EXCEPT - 41)) | (1L << (K_INTERSECT - 41)) | (1L << (K_UNION - 41)))) != 0)) {
				{
				{
				setState(536);
				compound_operator();
				setState(537);
				select_or_values();
				}
				}
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(554);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(544);
				match(K_ORDER);
				setState(545);
				match(K_BY);
				setState(546);
				ordering_term();
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(547);
					match(C1);
					setState(548);
					ordering_term();
					}
					}
					setState(553);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(562);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(556);
				match(K_LIMIT);
				setState(557);
				expr(0);
				setState(560);
				_la = _input.LA(1);
				if (_la==K_OFFSET || _la==C1) {
					{
					setState(558);
					_la = _input.LA(1);
					if ( !(_la==K_OFFSET || _la==C1) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(559);
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
		enterRule(_localctx, 52, RULE_select_or_values);
		int _la;
		try {
			setState(638);
			switch (_input.LA(1)) {
			case K_FROM:
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(576);
				_la = _input.LA(1);
				if (_la==K_SELECT) {
					{
					setState(564);
					match(K_SELECT);
					setState(566);
					switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
					case 1:
						{
						setState(565);
						_la = _input.LA(1);
						if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					setState(568);
					result_column();
					setState(573);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(569);
						match(C1);
						setState(570);
						result_column();
						}
						}
						setState(575);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				{
				setState(578);
				match(K_FROM);
				setState(588);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(579);
					table_or_subquery();
					setState(584);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(580);
						match(C1);
						setState(581);
						table_or_subquery();
						}
						}
						setState(586);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(587);
					join_clause();
					}
					break;
				}
				}
				setState(592);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(590);
					match(K_WHERE);
					setState(591);
					expr(0);
					}
				}

				setState(608);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(594);
					match(K_GROUP);
					setState(595);
					match(K_BY);
					setState(596);
					expr(0);
					setState(601);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(597);
						match(C1);
						setState(598);
						expr(0);
						}
						}
						setState(603);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(606);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(604);
						match(K_HAVING);
						setState(605);
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
				setState(610);
				match(K_VALUES);
				setState(611);
				match(OPEN_PARENTHESE);
				setState(612);
				expr(0);
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(613);
					match(C1);
					setState(614);
					expr(0);
					}
					}
					setState(619);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(620);
				match(CLOSE_PARENTHESE);
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(621);
					match(C1);
					setState(622);
					match(OPEN_PARENTHESE);
					setState(623);
					expr(0);
					setState(628);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==C1) {
						{
						{
						setState(624);
						match(C1);
						setState(625);
						expr(0);
						}
						}
						setState(630);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(631);
					match(CLOSE_PARENTHESE);
					}
					}
					setState(637);
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
		enterRule(_localctx, 54, RULE_compound_operator);
		try {
			setState(645);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(640);
				match(K_UNION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(641);
				match(K_UNION);
				setState(642);
				match(K_ALL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(643);
				match(K_INTERSECT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(644);
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
		enterRule(_localctx, 56, RULE_join_clause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			table_or_subquery();
			setState(657);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(648);
					join_operator();
					setState(651);
					switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
					case 1:
						{
						setState(649);
						join_clause();
						}
						break;
					case 2:
						{
						setState(650);
						table_or_subquery();
						}
						break;
					}
					setState(653);
					join_constraint();
					}
					} 
				}
				setState(659);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
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
		enterRule(_localctx, 58, RULE_join_operator);
		int _la;
		try {
			setState(681);
			switch (_input.LA(1)) {
			case C1:
				enterOuterAlt(_localctx, 1);
				{
				setState(660);
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
				setState(662);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(661);
					match(K_NATURAL);
					}
				}

				setState(678);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(664);
					match(K_LEFT);
					setState(666);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(665);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_RIGHT:
					{
					setState(668);
					match(K_RIGHT);
					setState(670);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(669);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_FULL:
					{
					setState(672);
					match(K_FULL);
					setState(674);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(673);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(676);
					match(K_INNER);
					}
					break;
				case K_CROSS:
					{
					setState(677);
					match(K_CROSS);
					}
					break;
				case K_JOIN:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(680);
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
		enterRule(_localctx, 60, RULE_join_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(683);
				match(K_ON);
				setState(684);
				expr(0);
				}
				break;
			case 2:
				{
				setState(685);
				match(K_USING);
				setState(686);
				match(OPEN_PARENTHESE);
				setState(687);
				column_name();
				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==C1) {
					{
					{
					setState(688);
					match(C1);
					setState(689);
					column_name();
					}
					}
					setState(694);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(695);
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
		enterRule(_localctx, 62, RULE_common_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			table_name();
			setState(711);
			_la = _input.LA(1);
			if (_la==OPEN_PARENTHESE) {
				{
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
			}

			setState(713);
			match(K_AS);
			setState(714);
			match(OPEN_PARENTHESE);
			setState(715);
			select_stmt();
			setState(716);
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
		enterRule(_localctx, 64, RULE_ordering_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			expr(0);
			setState(721);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(719);
				match(K_COLLATE);
				setState(720);
				collation_name();
				}
			}

			setState(724);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(723);
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
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				{
				setState(727);
				unary_operator();
				setState(728);
				expr(20);
				}
				break;
			case 2:
				{
				setState(730);
				operand();
				}
				break;
			case 3:
				{
				setState(731);
				match(BIND_PARAMETER);
				}
				break;
			case 4:
				{
				setState(740);
				switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
				case 1:
					{
					setState(735);
					switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
					case 1:
						{
						setState(732);
						database_name();
						setState(733);
						match(DOT);
						}
						break;
					}
					setState(737);
					table_alias();
					setState(738);
					match(DOT);
					}
					break;
				}
				setState(742);
				column_name();
				}
				break;
			case 5:
				{
				setState(743);
				match(OPEN_PARENTHESE);
				setState(744);
				expr(0);
				setState(745);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 6:
				{
				setState(747);
				match(K_CAST);
				setState(748);
				match(OPEN_PARENTHESE);
				setState(749);
				expr(0);
				setState(750);
				match(K_AS);
				setState(751);
				type_name();
				setState(752);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 7:
				{
				setState(758);
				_la = _input.LA(1);
				if (_la==K_EXISTS || _la==K_NOT) {
					{
					setState(755);
					_la = _input.LA(1);
					if (_la==K_NOT) {
						{
						setState(754);
						match(K_NOT);
						}
					}

					setState(757);
					match(K_EXISTS);
					}
				}

				setState(760);
				match(OPEN_PARENTHESE);
				setState(761);
				select_stmt();
				setState(762);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 8:
				{
				setState(764);
				match(K_CASE);
				setState(766);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(765);
					expr(0);
					}
					break;
				}
				setState(773); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(768);
					match(K_WHEN);
					setState(769);
					expr(0);
					setState(770);
					match(K_THEN);
					setState(771);
					expr(0);
					}
					}
					setState(775); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_WHEN );
				setState(779);
				_la = _input.LA(1);
				if (_la==K_ELSE) {
					{
					setState(777);
					match(K_ELSE);
					setState(778);
					expr(0);
					}
				}

				setState(781);
				match(K_END);
				}
				break;
			case 9:
				{
				setState(783);
				raise_function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(886);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(884);
					switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(786);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(787);
						match(T__0);
						setState(788);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(789);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(790);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4 || _la==C3) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(791);
						expr(19);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(792);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(793);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(794);
						expr(18);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(795);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(796);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(797);
						expr(17);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(798);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(799);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(800);
						expr(16);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(801);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(814);
						switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
						case 1:
							{
							setState(802);
							match(T__15);
							}
							break;
						case 2:
							{
							setState(803);
							match(T__16);
							}
							break;
						case 3:
							{
							setState(804);
							match(T__17);
							}
							break;
						case 4:
							{
							setState(805);
							match(T__18);
							}
							break;
						case 5:
							{
							setState(806);
							match(K_IS);
							}
							break;
						case 6:
							{
							setState(807);
							match(K_IS);
							setState(808);
							match(K_NOT);
							}
							break;
						case 7:
							{
							setState(809);
							match(K_IN);
							}
							break;
						case 8:
							{
							setState(810);
							match(K_LIKE);
							}
							break;
						case 9:
							{
							setState(811);
							match(K_GLOB);
							}
							break;
						case 10:
							{
							setState(812);
							match(K_MATCH);
							}
							break;
						case 11:
							{
							setState(813);
							match(K_REGEXP);
							}
							break;
						}
						setState(816);
						expr(15);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(817);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(818);
						match(K_AND);
						setState(819);
						expr(14);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(820);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(821);
						match(K_OR);
						setState(822);
						expr(13);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(823);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(824);
						match(K_IS);
						setState(826);
						switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
						case 1:
							{
							setState(825);
							match(K_NOT);
							}
							break;
						}
						setState(828);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(829);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(831);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(830);
							match(K_NOT);
							}
						}

						setState(833);
						match(K_BETWEEN);
						setState(834);
						expr(0);
						setState(835);
						match(K_AND);
						setState(836);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(838);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(839);
						match(K_COLLATE);
						setState(840);
						collation_name();
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(841);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(843);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(842);
							match(K_NOT);
							}
						}

						setState(845);
						_la = _input.LA(1);
						if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (K_GLOB - 46)) | (1L << (K_LIKE - 46)) | (1L << (K_MATCH - 46)) | (1L << (K_REGEXP - 46)))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(846);
						expr(0);
						setState(849);
						switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
						case 1:
							{
							setState(847);
							match(K_ESCAPE);
							setState(848);
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
						setState(851);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(856);
						switch (_input.LA(1)) {
						case K_ISNULL:
							{
							setState(852);
							match(K_ISNULL);
							}
							break;
						case K_NOTNULL:
							{
							setState(853);
							match(K_NOTNULL);
							}
							break;
						case K_NOT:
							{
							setState(854);
							match(K_NOT);
							setState(855);
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
						setState(858);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(860);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(859);
							match(K_NOT);
							}
						}

						setState(862);
						match(K_IN);
						setState(882);
						switch (_input.LA(1)) {
						case OPEN_PARENTHESE:
							{
							setState(863);
							match(OPEN_PARENTHESE);
							setState(873);
							switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
							case 1:
								{
								setState(864);
								select_stmt();
								}
								break;
							case 2:
								{
								setState(865);
								expr(0);
								setState(870);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==C1) {
									{
									{
									setState(866);
									match(C1);
									setState(867);
									expr(0);
									}
									}
									setState(872);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
								break;
							}
							setState(875);
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
							setState(879);
							switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
							case 1:
								{
								setState(876);
								database_name();
								setState(877);
								match(DOT);
								}
								break;
							}
							setState(881);
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
				setState(888);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
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
		enterRule(_localctx, 68, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(889);
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
		enterRule(_localctx, 70, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(891);
			_la = _input.LA(1);
			if ( !(((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (T__5 - 6)) | (1L << (T__6 - 6)) | (1L << (T__19 - 6)) | (1L << (K_NOT - 6)))) != 0)) ) {
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
		enterRule(_localctx, 72, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(893);
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
		enterRule(_localctx, 74, RULE_type_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(895);
				name();
				}
				}
				setState(898); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_ABORT) | (1L << K_ALL) | (1L << K_AND) | (1L << K_AS) | (1L << K_ASC) | (1L << K_BETWEEN) | (1L << K_BY) | (1L << K_CASE) | (1L << K_CAST) | (1L << K_COLLATE) | (1L << K_CROSS) | (1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP) | (1L << K_DESC) | (1L << K_DISTINCT) | (1L << K_ELSE) | (1L << K_END) | (1L << K_ESCAPE) | (1L << K_EXCEPT) | (1L << K_EXISTS) | (1L << K_FAIL) | (1L << K_FULL) | (1L << K_FROM) | (1L << K_GLOB) | (1L << K_GROUP) | (1L << K_HAVING) | (1L << K_IF) | (1L << K_IGNORE) | (1L << K_IN) | (1L << K_INDEXED) | (1L << K_INNER) | (1L << K_INTERSECT) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_JOIN) | (1L << K_LEFT) | (1L << K_LIKE) | (1L << K_LIMIT) | (1L << K_MATCH) | (1L << K_NATURAL) | (1L << K_NO))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_NOT - 64)) | (1L << (K_NOTNULL - 64)) | (1L << (K_NULL - 64)) | (1L << (K_OFFSET - 64)) | (1L << (K_ON - 64)) | (1L << (K_OR - 64)) | (1L << (K_ORDER - 64)) | (1L << (K_OUTER - 64)) | (1L << (K_RAISE - 64)) | (1L << (K_RECURSIVE - 64)) | (1L << (K_REGEXP - 64)) | (1L << (K_RIGHT - 64)) | (1L << (K_ROLLBACK - 64)) | (1L << (K_SELECT - 64)) | (1L << (K_THEN - 64)) | (1L << (K_UNION - 64)) | (1L << (K_USING - 64)) | (1L << (K_VALUES - 64)) | (1L << (K_WHEN - 64)) | (1L << (K_WHERE - 64)) | (1L << (K_WITH - 64)) | (1L << (K_GENERATE - 64)) | (1L << (K_MAX - 64)) | (1L << (K_MIN - 64)) | (1L << (K_AVG - 64)) | (1L << (K_COUNT - 64)) | (1L << (K_SUM - 64)) | (1L << (IDENTIFIER - 64)))) != 0) );
			setState(910);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				{
				setState(900);
				match(OPEN_PARENTHESE);
				setState(901);
				signed_number();
				setState(902);
				match(CLOSE_PARENTHESE);
				}
				break;
			case 2:
				{
				setState(904);
				match(OPEN_PARENTHESE);
				setState(905);
				signed_number();
				setState(906);
				match(C1);
				setState(907);
				signed_number();
				setState(908);
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
		enterRule(_localctx, 76, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(912);
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
		enterRule(_localctx, 78, RULE_ag_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
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
		enterRule(_localctx, 80, RULE_ag_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(916);
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
		enterRule(_localctx, 82, RULE_collation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
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
		enterRule(_localctx, 84, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
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
		enterRule(_localctx, 86, RULE_table_name);
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
		enterRule(_localctx, 88, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(924);
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
		enterRule(_localctx, 90, RULE_column_name);
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
		enterRule(_localctx, 92, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(928);
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
		enterRule(_localctx, 94, RULE_index_name);
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
		enterRule(_localctx, 96, RULE_any_name);
		try {
			setState(934);
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
				setState(932);
				keyword();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(933);
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
		enterRule(_localctx, 98, RULE_sl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
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
		enterRule(_localctx, 100, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__6) {
				{
				setState(938);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__6) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(941);
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
		enterRule(_localctx, 102, RULE_raise_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(943);
			match(K_RAISE);
			setState(944);
			match(OPEN_PARENTHESE);
			setState(949);
			switch (_input.LA(1)) {
			case K_IGNORE:
				{
				setState(945);
				match(K_IGNORE);
				}
				break;
			case K_ABORT:
			case K_FAIL:
			case K_ROLLBACK:
				{
				setState(946);
				_la = _input.LA(1);
				if ( !(((((_la - 21)) & ~0x3f) == 0 && ((1L << (_la - 21)) & ((1L << (K_ABORT - 21)) | (1L << (K_FAIL - 21)) | (1L << (K_ROLLBACK - 21)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(947);
				match(C1);
				setState(948);
				error_message();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(951);
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
		enterRule(_localctx, 104, RULE_error_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(953);
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
		case 33:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3r\u03be\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\5\2p\n\2\3\3\3\3\5\3t\n\3\3\3\5\3"+
		"w\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0082\n\5\3\5\3\5\3\5\5"+
		"\5\u0087\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0090\n\5\3\5\3\5\7\5\u0094"+
		"\n\5\f\5\16\5\u0097\13\5\3\5\5\5\u009a\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00ab\n\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7\u00b5\n\7\3\7\3\7\5\7\u00b9\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u00c3\n\7\3\7\3\7\5\7\u00c7\n\7\5\7\u00c9\n\7\3\b\3\b\3\t\3"+
		"\t\3\t\5\t\u00d0\n\t\3\n\3\n\3\n\3\n\5\n\u00d6\n\n\7\n\u00d8\n\n\f\n\16"+
		"\n\u00db\13\n\3\13\3\13\5\13\u00df\n\13\3\13\3\13\3\13\5\13\u00e4\n\13"+
		"\7\13\u00e6\n\13\f\13\16\13\u00e9\13\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00f5\n\r\3\16\5\16\u00f8\n\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00ff\n\16\3\16\3\16\3\16\3\16\5\16\u0105\n\16\7\16\u0107\n\16\f"+
		"\16\16\16\u010a\13\16\7\16\u010c\n\16\f\16\16\16\u010f\13\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u0118\n\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0133\n\20\3\21\3\21\5\21\u0137\n\21\3"+
		"\22\3\22\3\22\3\23\3\23\6\23\u013e\n\23\r\23\16\23\u013f\3\23\7\23\u0143"+
		"\n\23\f\23\16\23\u0146\13\23\3\23\7\23\u0149\n\23\f\23\16\23\u014c\13"+
		"\23\3\24\3\24\5\24\u0150\n\24\3\25\3\25\5\25\u0154\n\25\3\25\3\25\3\25"+
		"\7\25\u0159\n\25\f\25\16\25\u015c\13\25\5\25\u015e\n\25\3\25\3\25\3\25"+
		"\3\25\7\25\u0164\n\25\f\25\16\25\u0167\13\25\3\25\3\25\3\25\3\25\3\25"+
		"\7\25\u016e\n\25\f\25\16\25\u0171\13\25\5\25\u0173\n\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0179\n\25\5\25\u017b\n\25\3\26\3\26\5\26\u017f\n\26\3\26\3"+
		"\26\3\26\7\26\u0184\n\26\f\26\16\26\u0187\13\26\5\26\u0189\n\26\3\26\3"+
		"\26\3\26\3\26\7\26\u018f\n\26\f\26\16\26\u0192\13\26\3\26\5\26\u0195\n"+
		"\26\3\26\5\26\u0198\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27"+
		"\u01a2\n\27\f\27\16\27\u01a5\13\27\3\27\3\27\5\27\u01a9\n\27\5\27\u01ab"+
		"\n\27\3\27\3\27\3\27\3\27\3\27\7\27\u01b2\n\27\f\27\16\27\u01b5\13\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u01bd\n\27\f\27\16\27\u01c0\13\27"+
		"\3\27\3\27\7\27\u01c4\n\27\f\27\16\27\u01c7\13\27\5\27\u01c9\n\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01d2\n\30\3\30\5\30\u01d5\n\30\5"+
		"\30\u01d7\n\30\3\31\3\31\3\31\5\31\u01dc\n\31\3\31\3\31\5\31\u01e0\n\31"+
		"\3\31\5\31\u01e3\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u01ea\n\31\3\31\3"+
		"\31\3\31\3\31\7\31\u01f0\n\31\f\31\16\31\u01f3\13\31\3\31\5\31\u01f6\n"+
		"\31\3\31\3\31\5\31\u01fa\n\31\3\31\5\31\u01fd\n\31\3\31\3\31\3\31\3\31"+
		"\5\31\u0203\n\31\3\31\5\31\u0206\n\31\5\31\u0208\n\31\3\32\3\32\3\33\3"+
		"\33\5\33\u020e\n\33\3\33\3\33\3\33\7\33\u0213\n\33\f\33\16\33\u0216\13"+
		"\33\5\33\u0218\n\33\3\33\3\33\3\33\3\33\7\33\u021e\n\33\f\33\16\33\u0221"+
		"\13\33\3\33\3\33\3\33\3\33\3\33\7\33\u0228\n\33\f\33\16\33\u022b\13\33"+
		"\5\33\u022d\n\33\3\33\3\33\3\33\3\33\5\33\u0233\n\33\5\33\u0235\n\33\3"+
		"\34\3\34\5\34\u0239\n\34\3\34\3\34\3\34\7\34\u023e\n\34\f\34\16\34\u0241"+
		"\13\34\5\34\u0243\n\34\3\34\3\34\3\34\3\34\7\34\u0249\n\34\f\34\16\34"+
		"\u024c\13\34\3\34\5\34\u024f\n\34\3\34\3\34\5\34\u0253\n\34\3\34\3\34"+
		"\3\34\3\34\3\34\7\34\u025a\n\34\f\34\16\34\u025d\13\34\3\34\3\34\5\34"+
		"\u0261\n\34\5\34\u0263\n\34\3\34\3\34\3\34\3\34\3\34\7\34\u026a\n\34\f"+
		"\34\16\34\u026d\13\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0275\n\34\f"+
		"\34\16\34\u0278\13\34\3\34\3\34\7\34\u027c\n\34\f\34\16\34\u027f\13\34"+
		"\5\34\u0281\n\34\3\35\3\35\3\35\3\35\3\35\5\35\u0288\n\35\3\36\3\36\3"+
		"\36\3\36\5\36\u028e\n\36\3\36\3\36\7\36\u0292\n\36\f\36\16\36\u0295\13"+
		"\36\3\37\3\37\5\37\u0299\n\37\3\37\3\37\5\37\u029d\n\37\3\37\3\37\5\37"+
		"\u02a1\n\37\3\37\3\37\5\37\u02a5\n\37\3\37\3\37\5\37\u02a9\n\37\3\37\5"+
		"\37\u02ac\n\37\3 \3 \3 \3 \3 \3 \3 \7 \u02b5\n \f \16 \u02b8\13 \3 \3"+
		" \5 \u02bc\n \3!\3!\3!\3!\3!\7!\u02c3\n!\f!\16!\u02c6\13!\3!\3!\5!\u02ca"+
		"\n!\3!\3!\3!\3!\3!\3\"\3\"\3\"\5\"\u02d4\n\"\3\"\5\"\u02d7\n\"\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\5#\u02e2\n#\3#\3#\3#\5#\u02e7\n#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\5#\u02f6\n#\3#\5#\u02f9\n#\3#\3#\3#\3#\3#\3#\5"+
		"#\u0301\n#\3#\3#\3#\3#\3#\6#\u0308\n#\r#\16#\u0309\3#\3#\5#\u030e\n#\3"+
		"#\3#\3#\5#\u0313\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0331\n#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\5#\u033d\n#\3#\3#\3#\5#\u0342\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\5#\u034e\n#\3#\3#\3#\3#\5#\u0354\n#\3#\3#\3#\3#\3#\5#\u035b\n#\3#\3"+
		"#\5#\u035f\n#\3#\3#\3#\3#\3#\3#\7#\u0367\n#\f#\16#\u036a\13#\5#\u036c"+
		"\n#\3#\3#\3#\3#\5#\u0372\n#\3#\5#\u0375\n#\7#\u0377\n#\f#\16#\u037a\13"+
		"#\3$\3$\3%\3%\3&\3&\3\'\6\'\u0383\n\'\r\'\16\'\u0384\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\5\'\u0391\n\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-"+
		"\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\5\62\u03a9\n\62\3\63\3\63"+
		"\3\64\5\64\u03ae\n\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u03b8"+
		"\n\65\3\65\3\65\3\66\3\66\3\66\2\3D\67\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhj\2\20\4\2EE^^\4"+
		"\2\31\31\'\'\4\2\27\27\31\\\4\2\34\34&&\4\2\6\7``\3\2\b\t\3\2\n\r\3\2"+
		"\16\21\6\2\60\60==??LL\6\2#%DDjknn\5\2\b\t\26\26BB\3\2X\\\3\2mn\5\2\27"+
		"\27--NN\u043d\2l\3\2\2\2\4s\3\2\2\2\6x\3\2\2\2\b\u008f\3\2\2\2\n\u00aa"+
		"\3\2\2\2\f\u00c8\3\2\2\2\16\u00ca\3\2\2\2\20\u00cc\3\2\2\2\22\u00d1\3"+
		"\2\2\2\24\u00de\3\2\2\2\26\u00ea\3\2\2\2\30\u00f4\3\2\2\2\32\u00f7\3\2"+
		"\2\2\34\u0112\3\2\2\2\36\u0132\3\2\2\2 \u0136\3\2\2\2\"\u0138\3\2\2\2"+
		"$\u013b\3\2\2\2&\u014f\3\2\2\2(\u015d\3\2\2\2*\u0188\3\2\2\2,\u01c8\3"+
		"\2\2\2.\u01d6\3\2\2\2\60\u0207\3\2\2\2\62\u0209\3\2\2\2\64\u0217\3\2\2"+
		"\2\66\u0280\3\2\2\28\u0287\3\2\2\2:\u0289\3\2\2\2<\u02ab\3\2\2\2>\u02bb"+
		"\3\2\2\2@\u02bd\3\2\2\2B\u02d0\3\2\2\2D\u0312\3\2\2\2F\u037b\3\2\2\2H"+
		"\u037d\3\2\2\2J\u037f\3\2\2\2L\u0382\3\2\2\2N\u0392\3\2\2\2P\u0394\3\2"+
		"\2\2R\u0396\3\2\2\2T\u0398\3\2\2\2V\u039a\3\2\2\2X\u039c\3\2\2\2Z\u039e"+
		"\3\2\2\2\\\u03a0\3\2\2\2^\u03a2\3\2\2\2`\u03a4\3\2\2\2b\u03a8\3\2\2\2"+
		"d\u03aa\3\2\2\2f\u03ad\3\2\2\2h\u03b1\3\2\2\2j\u03bb\3\2\2\2lm\5\6\4\2"+
		"mo\5\4\3\2np\5 \21\2on\3\2\2\2op\3\2\2\2p\3\3\2\2\2qt\5\b\5\2rt\5\16\b"+
		"\2sq\3\2\2\2sr\3\2\2\2tv\3\2\2\2uw\7i\2\2vu\3\2\2\2vw\3\2\2\2w\5\3\2\2"+
		"\2xy\7W\2\2yz\7m\2\2z\7\3\2\2\2{\u0090\5\32\16\2|}\7f\2\2}~\5\16\b\2~"+
		"\177\7g\2\2\177\u0090\3\2\2\2\u0080\u0082\5\30\r\2\u0081\u0080\3\2\2\2"+
		"\u0081\u0082\3\2\2\2\u0082\u0086\3\2\2\2\u0083\u0084\5^\60\2\u0084\u0085"+
		"\7a\2\2\u0085\u0087\3\2\2\2\u0086\u0083\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0090\5\\/\2\u0089\u0090\5\n\6\2\u008a\u0090\5\f"+
		"\7\2\u008b\u0090\5\36\20\2\u008c\u0090\5d\63\2\u008d\u0090\7j\2\2\u008e"+
		"\u0090\5\34\17\2\u008f{\3\2\2\2\u008f|\3\2\2\2\u008f\u0081\3\2\2\2\u008f"+
		"\u0089\3\2\2\2\u008f\u008a\3\2\2\2\u008f\u008b\3\2\2\2\u008f\u008c\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u0095\3\2\2\2\u0091"+
		"\u0092\7\3\2\2\u0092\u0094\5\b\5\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u009a\7i\2\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\t\3\2\2\2\u009b\u009c\7d\2\2\u009c\u009d\5\16\b\2\u009d\u009e"+
		"\7e\2\2\u009e\u009f\7^\2\2\u009f\u00ab\3\2\2\2\u00a0\u00a1\7d\2\2\u00a1"+
		"\u00a2\5\16\b\2\u00a2\u00a3\7e\2\2\u00a3\u00a4\7_\2\2\u00a4\u00ab\3\2"+
		"\2\2\u00a5\u00a6\7d\2\2\u00a6\u00a7\5\16\b\2\u00a7\u00a8\7e\2\2\u00a8"+
		"\u00a9\7`\2\2\u00a9\u00ab\3\2\2\2\u00aa\u009b\3\2\2\2\u00aa\u00a0\3\2"+
		"\2\2\u00aa\u00a5\3\2\2\2\u00ab\13\3\2\2\2\u00ac\u00ad\7d\2\2\u00ad\u00ae"+
		"\5\16\b\2\u00ae\u00af\7e\2\2\u00af\u00b8\7^\2\2\u00b0\u00b1\7j\2\2\u00b1"+
		"\u00b4\7_\2\2\u00b2\u00b3\7j\2\2\u00b3\u00b5\7`\2\2\u00b4\u00b2\3\2\2"+
		"\2\u00b4\u00b5\3\2\2\2\u00b5\u00b9\3\2\2\2\u00b6\u00b7\7j\2\2\u00b7\u00b9"+
		"\7`\2\2\u00b8\u00b0\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00c9\3\2\2\2\u00ba"+
		"\u00bb\7d\2\2\u00bb\u00bc\5\16\b\2\u00bc\u00bd\7e\2\2\u00bd\u00c6\7_\2"+
		"\2\u00be\u00bf\7j\2\2\u00bf\u00c2\7^\2\2\u00c0\u00c1\7j\2\2\u00c1\u00c3"+
		"\7`\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c7\3\2\2\2\u00c4"+
		"\u00c5\7j\2\2\u00c5\u00c7\7`\2\2\u00c6\u00be\3\2\2\2\u00c6\u00c4\3\2\2"+
		"\2\u00c7\u00c9\3\2\2\2\u00c8\u00ac\3\2\2\2\u00c8\u00ba\3\2\2\2\u00c9\r"+
		"\3\2\2\2\u00ca\u00cb\5\20\t\2\u00cb\17\3\2\2\2\u00cc\u00cf\5\22\n\2\u00cd"+
		"\u00ce\7`\2\2\u00ce\u00d0\5\b\5\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\21\3\2\2\2\u00d1\u00d9\5\24\13\2\u00d2\u00d5\7_\2\2\u00d3\u00d6"+
		"\5\24\13\2\u00d4\u00d6\5\b\5\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2"+
		"\u00d6\u00d8\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7"+
		"\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\23\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00df\5\b\5\2\u00dd\u00df\5\26\f\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3"+
		"\2\2\2\u00df\u00e7\3\2\2\2\u00e0\u00e3\7^\2\2\u00e1\u00e4\5\b\5\2\u00e2"+
		"\u00e4\5\26\f\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e6\3"+
		"\2\2\2\u00e5\u00e0\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\25\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\5\b\5"+
		"\2\u00eb\u00ec\7]\2\2\u00ec\u00ed\5\b\5\2\u00ed\27\3\2\2\2\u00ee\u00ef"+
		"\7b\2\2\u00ef\u00f0\7\34\2\2\u00f0\u00f5\7c\2\2\u00f1\u00f2\7b\2\2\u00f2"+
		"\u00f3\7&\2\2\u00f3\u00f5\7c\2\2\u00f4\u00ee\3\2\2\2\u00f4\u00f1\3\2\2"+
		"\2\u00f5\31\3\2\2\2\u00f6\u00f8\7\4\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\5N(\2\u00fa\u010d\7b\2\2\u00fb"+
		"\u00ff\5\b\5\2\u00fc\u00ff\5\16\b\2\u00fd\u00ff\5D#\2\u00fe\u00fb\3\2"+
		"\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0108\3\2\2\2\u0100"+
		"\u0104\7^\2\2\u0101\u0105\5\b\5\2\u0102\u0105\5\16\b\2\u0103\u0105\5D"+
		"#\2\u0104\u0101\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105"+
		"\u0107\3\2\2\2\u0106\u0100\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010b"+
		"\u00fe\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2"+
		"\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7c\2\2\u0111"+
		"\33\3\2\2\2\u0112\u0113\5P)\2\u0113\u0117\7d\2\2\u0114\u0115\5^\60\2\u0115"+
		"\u0116\7a\2\2\u0116\u0118\3\2\2\2\u0117\u0114\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011a\5\\/\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011c\7e\2\2\u011c\35\3\2\2\2\u011d\u011e\7\63\2\2\u011e\u011f\7b\2\2"+
		"\u011f\u0120\5D#\2\u0120\u0121\7c\2\2\u0121\u0122\7P\2\2\u0122\u0123\7"+
		"b\2\2\u0123\u0124\5\16\b\2\u0124\u0125\7c\2\2\u0125\u0126\7(\2\2\u0126"+
		"\u0127\7b\2\2\u0127\u0128\5\16\b\2\u0128\u0129\7c\2\2\u0129\u0133\3\2"+
		"\2\2\u012a\u012b\7b\2\2\u012b\u012c\5D#\2\u012c\u012d\7c\2\2\u012d\u012e"+
		"\7]\2\2\u012e\u012f\5\16\b\2\u012f\u0130\7\5\2\2\u0130\u0131\5\16\b\2"+
		"\u0131\u0133\3\2\2\2\u0132\u011d\3\2\2\2\u0132\u012a\3\2\2\2\u0133\37"+
		"\3\2\2\2\u0134\u0137\5$\23\2\u0135\u0137\5\"\22\2\u0136\u0134\3\2\2\2"+
		"\u0136\u0135\3\2\2\2\u0137!\3\2\2\2\u0138\u0139\7r\2\2\u0139\u013a\b\22"+
		"\1\2\u013a#\3\2\2\2\u013b\u0144\5&\24\2\u013c\u013e\7h\2\2\u013d\u013c"+
		"\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u0143\5&\24\2\u0142\u013d\3\2\2\2\u0143\u0146\3\2"+
		"\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u014a\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0147\u0149\7h\2\2\u0148\u0147\3\2\2\2\u0149\u014c\3\2"+
		"\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b%\3\2\2\2\u014c\u014a"+
		"\3\2\2\2\u014d\u0150\5(\25\2\u014e\u0150\5\64\33\2\u014f\u014d\3\2\2\2"+
		"\u014f\u014e\3\2\2\2\u0150\'\3\2\2\2\u0151\u0153\7V\2\2\u0152\u0154\7"+
		"K\2\2\u0153\u0152\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u015a\5@!\2\u0156\u0157\7^\2\2\u0157\u0159\5@!\2\u0158\u0156\3\2\2\2"+
		"\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015e"+
		"\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u0151\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0165\5*\26\2\u0160\u0161\58\35\2\u0161\u0162\5*"+
		"\26\2\u0162\u0164\3\2\2\2\u0163\u0160\3\2\2\2\u0164\u0167\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0172\3\2\2\2\u0167\u0165\3\2"+
		"\2\2\u0168\u0169\7H\2\2\u0169\u016a\7\36\2\2\u016a\u016f\5B\"\2\u016b"+
		"\u016c\7^\2\2\u016c\u016e\5B\"\2\u016d\u016b\3\2\2\2\u016e\u0171\3\2\2"+
		"\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f"+
		"\3\2\2\2\u0172\u0168\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u017a\3\2\2\2\u0174"+
		"\u0175\7>\2\2\u0175\u0178\5D#\2\u0176\u0177\t\2\2\2\u0177\u0179\5D#\2"+
		"\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0174"+
		"\3\2\2\2\u017a\u017b\3\2\2\2\u017b)\3\2\2\2\u017c\u017e\7O\2\2\u017d\u017f"+
		"\t\3\2\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u0185\5.\30\2\u0181\u0182\7^\2\2\u0182\u0184\5.\30\2\u0183\u0181\3\2"+
		"\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186"+
		"\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u017c\3\2\2\2\u0188\u0189\3\2"+
		"\2\2\u0189\u018a\3\2\2\2\u018a\u0194\7/\2\2\u018b\u0190\5\60\31\2\u018c"+
		"\u018d\7^\2\2\u018d\u018f\5\60\31\2\u018e\u018c\3\2\2\2\u018f\u0192\3"+
		"\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0195\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0193\u0195\5:\36\2\u0194\u018b\3\2\2\2\u0194\u0193\3\2"+
		"\2\2\u0195\u0197\3\2\2\2\u0196\u0198\5,\27\2\u0197\u0196\3\2\2\2\u0197"+
		"\u0198\3\2\2\2\u0198+\3\2\2\2\u0199\u019a\7U\2\2\u019a\u019b\5D#\2\u019b"+
		"\u01aa\3\2\2\2\u019c\u019d\7\61\2\2\u019d\u019e\7\36\2\2\u019e\u01a3\5"+
		"D#\2\u019f\u01a0\7^\2\2\u01a0\u01a2\5D#\2\u01a1\u019f\3\2\2\2\u01a2\u01a5"+
		"\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a8\3\2\2\2\u01a5"+
		"\u01a3\3\2\2\2\u01a6\u01a7\7\62\2\2\u01a7\u01a9\5D#\2\u01a8\u01a6\3\2"+
		"\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u019c\3\2\2\2\u01aa"+
		"\u01ab\3\2\2\2\u01ab\u01c9\3\2\2\2\u01ac\u01ad\7S\2\2\u01ad\u01ae\7b\2"+
		"\2\u01ae\u01b3\5D#\2\u01af\u01b0\7^\2\2\u01b0\u01b2\5D#\2\u01b1\u01af"+
		"\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01c5\7c\2\2\u01b7\u01b8\7^\2"+
		"\2\u01b8\u01b9\7b\2\2\u01b9\u01be\5D#\2\u01ba\u01bb\7^\2\2\u01bb\u01bd"+
		"\5D#\2\u01bc\u01ba\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01bf\u01c1\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c2\7c"+
		"\2\2\u01c2\u01c4\3\2\2\2\u01c3\u01b7\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c5\3\2"+
		"\2\2\u01c8\u0199\3\2\2\2\u01c8\u01ac\3\2\2\2\u01c9-\3\2\2\2\u01ca\u01d7"+
		"\7\6\2\2\u01cb\u01cc\5X-\2\u01cc\u01cd\7a\2\2\u01cd\u01ce\7\6\2\2\u01ce"+
		"\u01d7\3\2\2\2\u01cf\u01d4\5D#\2\u01d0\u01d2\7\33\2\2\u01d1\u01d0\3\2"+
		"\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d5\5Z.\2\u01d4\u01d1"+
		"\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01ca\3\2\2\2\u01d6"+
		"\u01cb\3\2\2\2\u01d6\u01cf\3\2\2\2\u01d7/\3\2\2\2\u01d8\u01d9\5V,\2\u01d9"+
		"\u01da\7a\2\2\u01da\u01dc\3\2\2\2\u01db\u01d8\3\2\2\2\u01db\u01dc\3\2"+
		"\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01e2\5X-\2\u01de\u01e0\7\33\2\2\u01df"+
		"\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\5^"+
		"\60\2\u01e2\u01df\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e9\3\2\2\2\u01e4"+
		"\u01e5\7\66\2\2\u01e5\u01e6\7\36\2\2\u01e6\u01ea\5`\61\2\u01e7\u01e8\7"+
		"B\2\2\u01e8\u01ea\7\66\2\2\u01e9\u01e4\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u0208\3\2\2\2\u01eb\u01f5\7b\2\2\u01ec\u01f1\5\60"+
		"\31\2\u01ed\u01ee\7^\2\2\u01ee\u01f0\5\60\31\2\u01ef\u01ed\3\2\2\2\u01f0"+
		"\u01f3\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f6\3\2"+
		"\2\2\u01f3\u01f1\3\2\2\2\u01f4\u01f6\5:\36\2\u01f5\u01ec\3\2\2\2\u01f5"+
		"\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01fc\7c\2\2\u01f8\u01fa\7\33"+
		"\2\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb"+
		"\u01fd\5^\60\2\u01fc\u01f9\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0208\3\2"+
		"\2\2\u01fe\u01ff\7b\2\2\u01ff\u0200\5\64\33\2\u0200\u0205\7c\2\2\u0201"+
		"\u0203\7\33\2\2\u0202\u0201\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3"+
		"\2\2\2\u0204\u0206\5^\60\2\u0205\u0202\3\2\2\2\u0205\u0206\3\2\2\2\u0206"+
		"\u0208\3\2\2\2\u0207\u01db\3\2\2\2\u0207\u01eb\3\2\2\2\u0207\u01fe\3\2"+
		"\2\2\u0208\61\3\2\2\2\u0209\u020a\t\4\2\2\u020a\63\3\2\2\2\u020b\u020d"+
		"\7V\2\2\u020c\u020e\7K\2\2\u020d\u020c\3\2\2\2\u020d\u020e\3\2\2\2\u020e"+
		"\u020f\3\2\2\2\u020f\u0214\5@!\2\u0210\u0211\7^\2\2\u0211\u0213\5@!\2"+
		"\u0212\u0210\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215"+
		"\3\2\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0217\u020b\3\2\2\2\u0217"+
		"\u0218\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021f\5\66\34\2\u021a\u021b\5"+
		"8\35\2\u021b\u021c\5\66\34\2\u021c\u021e\3\2\2\2\u021d\u021a\3\2\2\2\u021e"+
		"\u0221\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u022c\3\2"+
		"\2\2\u0221\u021f\3\2\2\2\u0222\u0223\7H\2\2\u0223\u0224\7\36\2\2\u0224"+
		"\u0229\5B\"\2\u0225\u0226\7^\2\2\u0226\u0228\5B\"\2\u0227\u0225\3\2\2"+
		"\2\u0228\u022b\3\2\2\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022d"+
		"\3\2\2\2\u022b\u0229\3\2\2\2\u022c\u0222\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"\u0234\3\2\2\2\u022e\u022f\7>\2\2\u022f\u0232\5D#\2\u0230\u0231\t\2\2"+
		"\2\u0231\u0233\5D#\2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0235"+
		"\3\2\2\2\u0234\u022e\3\2\2\2\u0234\u0235\3\2\2\2\u0235\65\3\2\2\2\u0236"+
		"\u0238\7O\2\2\u0237\u0239\t\3\2\2\u0238\u0237\3\2\2\2\u0238\u0239\3\2"+
		"\2\2\u0239\u023a\3\2\2\2\u023a\u023f\5.\30\2\u023b\u023c\7^\2\2\u023c"+
		"\u023e\5.\30\2\u023d\u023b\3\2\2\2\u023e\u0241\3\2\2\2\u023f\u023d\3\2"+
		"\2\2\u023f\u0240\3\2\2\2\u0240\u0243\3\2\2\2\u0241\u023f\3\2\2\2\u0242"+
		"\u0236\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u024e\7/"+
		"\2\2\u0245\u024a\5\60\31\2\u0246\u0247\7^\2\2\u0247\u0249\5\60\31\2\u0248"+
		"\u0246\3\2\2\2\u0249\u024c\3\2\2\2\u024a\u0248\3\2\2\2\u024a\u024b\3\2"+
		"\2\2\u024b\u024f\3\2\2\2\u024c\u024a\3\2\2\2\u024d\u024f\5:\36\2\u024e"+
		"\u0245\3\2\2\2\u024e\u024d\3\2\2\2\u024f\u0252\3\2\2\2\u0250\u0251\7U"+
		"\2\2\u0251\u0253\5D#\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0262"+
		"\3\2\2\2\u0254\u0255\7\61\2\2\u0255\u0256\7\36\2\2\u0256\u025b\5D#\2\u0257"+
		"\u0258\7^\2\2\u0258\u025a\5D#\2\u0259\u0257\3\2\2\2\u025a\u025d\3\2\2"+
		"\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u0260\3\2\2\2\u025d\u025b"+
		"\3\2\2\2\u025e\u025f\7\62\2\2\u025f\u0261\5D#\2\u0260\u025e\3\2\2\2\u0260"+
		"\u0261\3\2\2\2\u0261\u0263\3\2\2\2\u0262\u0254\3\2\2\2\u0262\u0263\3\2"+
		"\2\2\u0263\u0281\3\2\2\2\u0264\u0265\7S\2\2\u0265\u0266\7b\2\2\u0266\u026b"+
		"\5D#\2\u0267\u0268\7^\2\2\u0268\u026a\5D#\2\u0269\u0267\3\2\2\2\u026a"+
		"\u026d\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026e\3\2"+
		"\2\2\u026d\u026b\3\2\2\2\u026e\u027d\7c\2\2\u026f\u0270\7^\2\2\u0270\u0271"+
		"\7b\2\2\u0271\u0276\5D#\2\u0272\u0273\7^\2\2\u0273\u0275\5D#\2\u0274\u0272"+
		"\3\2\2\2\u0275\u0278\3\2\2\2\u0276\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277"+
		"\u0279\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u027a\7c\2\2\u027a\u027c\3\2"+
		"\2\2\u027b\u026f\3\2\2\2\u027c\u027f\3\2\2\2\u027d\u027b\3\2\2\2\u027d"+
		"\u027e\3\2\2\2\u027e\u0281\3\2\2\2\u027f\u027d\3\2\2\2\u0280\u0242\3\2"+
		"\2\2\u0280\u0264\3\2\2\2\u0281\67\3\2\2\2\u0282\u0288\7Q\2\2\u0283\u0284"+
		"\7Q\2\2\u0284\u0288\7\31\2\2\u0285\u0288\78\2\2\u0286\u0288\7+\2\2\u0287"+
		"\u0282\3\2\2\2\u0287\u0283\3\2\2\2\u0287\u0285\3\2\2\2\u0287\u0286\3\2"+
		"\2\2\u02889\3\2\2\2\u0289\u0293\5\60\31\2\u028a\u028d\5<\37\2\u028b\u028e"+
		"\5:\36\2\u028c\u028e\5\60\31\2\u028d\u028b\3\2\2\2\u028d\u028c\3\2\2\2"+
		"\u028e\u028f\3\2\2\2\u028f\u0290\5> \2\u0290\u0292\3\2\2\2\u0291\u028a"+
		"\3\2\2\2\u0292\u0295\3\2\2\2\u0293\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294"+
		";\3\2\2\2\u0295\u0293\3\2\2\2\u0296\u02ac\7^\2\2\u0297\u0299\7@\2\2\u0298"+
		"\u0297\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u02a8\3\2\2\2\u029a\u029c\7<"+
		"\2\2\u029b\u029d\7I\2\2\u029c\u029b\3\2\2\2\u029c\u029d\3\2\2\2\u029d"+
		"\u02a9\3\2\2\2\u029e\u02a0\7M\2\2\u029f\u02a1\7I\2\2\u02a0\u029f\3\2\2"+
		"\2\u02a0\u02a1\3\2\2\2\u02a1\u02a9\3\2\2\2\u02a2\u02a4\7.\2\2\u02a3\u02a5"+
		"\7I\2\2\u02a4\u02a3\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a9\3\2\2\2\u02a6"+
		"\u02a9\7\67\2\2\u02a7\u02a9\7\"\2\2\u02a8\u029a\3\2\2\2\u02a8\u029e\3"+
		"\2\2\2\u02a8\u02a2\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a7\3\2\2\2\u02a8"+
		"\u02a9\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ac\7;\2\2\u02ab\u0296\3\2"+
		"\2\2\u02ab\u0298\3\2\2\2\u02ac=\3\2\2\2\u02ad\u02ae\7F\2\2\u02ae\u02bc"+
		"\5D#\2\u02af\u02b0\7R\2\2\u02b0\u02b1\7b\2\2\u02b1\u02b6\5\\/\2\u02b2"+
		"\u02b3\7^\2\2\u02b3\u02b5\5\\/\2\u02b4\u02b2\3\2\2\2\u02b5\u02b8\3\2\2"+
		"\2\u02b6\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b9\3\2\2\2\u02b8\u02b6"+
		"\3\2\2\2\u02b9\u02ba\7c\2\2\u02ba\u02bc\3\2\2\2\u02bb\u02ad\3\2\2\2\u02bb"+
		"\u02af\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc?\3\2\2\2\u02bd\u02c9\5X-\2\u02be"+
		"\u02bf\7b\2\2\u02bf\u02c4\5\\/\2\u02c0\u02c1\7^\2\2\u02c1\u02c3\5\\/\2"+
		"\u02c2\u02c0\3\2\2\2\u02c3\u02c6\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c4\u02c5"+
		"\3\2\2\2\u02c5\u02c7\3\2\2\2\u02c6\u02c4\3\2\2\2\u02c7\u02c8\7c\2\2\u02c8"+
		"\u02ca\3\2\2\2\u02c9\u02be\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\3\2"+
		"\2\2\u02cb\u02cc\7\33\2\2\u02cc\u02cd\7b\2\2\u02cd\u02ce\5\64\33\2\u02ce"+
		"\u02cf\7c\2\2\u02cfA\3\2\2\2\u02d0\u02d3\5D#\2\u02d1\u02d2\7!\2\2\u02d2"+
		"\u02d4\5T+\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02d6\3\2\2"+
		"\2\u02d5\u02d7\t\5\2\2\u02d6\u02d5\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7C"+
		"\3\2\2\2\u02d8\u02d9\b#\1\2\u02d9\u02da\5H%\2\u02da\u02db\5D#\26\u02db"+
		"\u0313\3\2\2\2\u02dc\u0313\5\b\5\2\u02dd\u0313\7l\2\2\u02de\u02df\5V,"+
		"\2\u02df\u02e0\7a\2\2\u02e0\u02e2\3\2\2\2\u02e1\u02de\3\2\2\2\u02e1\u02e2"+
		"\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e4\5^\60\2\u02e4\u02e5\7a\2\2\u02e5"+
		"\u02e7\3\2\2\2\u02e6\u02e1\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e8\3\2"+
		"\2\2\u02e8\u0313\5\\/\2\u02e9\u02ea\7b\2\2\u02ea\u02eb\5D#\2\u02eb\u02ec"+
		"\7c\2\2\u02ec\u0313\3\2\2\2\u02ed\u02ee\7 \2\2\u02ee\u02ef\7b\2\2\u02ef"+
		"\u02f0\5D#\2\u02f0\u02f1\7\33\2\2\u02f1\u02f2\5L\'\2\u02f2\u02f3\7c\2"+
		"\2\u02f3\u0313\3\2\2\2\u02f4\u02f6\7B\2\2\u02f5\u02f4\3\2\2\2\u02f5\u02f6"+
		"\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f9\7,\2\2\u02f8\u02f5\3\2\2\2\u02f8"+
		"\u02f9\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fb\7b\2\2\u02fb\u02fc\5\64"+
		"\33\2\u02fc\u02fd\7c\2\2\u02fd\u0313\3\2\2\2\u02fe\u0300\7\37\2\2\u02ff"+
		"\u0301\5D#\2\u0300\u02ff\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0307\3\2\2"+
		"\2\u0302\u0303\7T\2\2\u0303\u0304\5D#\2\u0304\u0305\7P\2\2\u0305\u0306"+
		"\5D#\2\u0306\u0308\3\2\2\2\u0307\u0302\3\2\2\2\u0308\u0309\3\2\2\2\u0309"+
		"\u0307\3\2\2\2\u0309\u030a\3\2\2\2\u030a\u030d\3\2\2\2\u030b\u030c\7("+
		"\2\2\u030c\u030e\5D#\2\u030d\u030b\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030f"+
		"\3\2\2\2\u030f\u0310\7)\2\2\u0310\u0313\3\2\2\2\u0311\u0313\5h\65\2\u0312"+
		"\u02d8\3\2\2\2\u0312\u02dc\3\2\2\2\u0312\u02dd\3\2\2\2\u0312\u02e6\3\2"+
		"\2\2\u0312\u02e9\3\2\2\2\u0312\u02ed\3\2\2\2\u0312\u02f8\3\2\2\2\u0312"+
		"\u02fe\3\2\2\2\u0312\u0311\3\2\2\2\u0313\u0378\3\2\2\2\u0314\u0315\f\25"+
		"\2\2\u0315\u0316\7\3\2\2\u0316\u0377\5D#\26\u0317\u0318\f\24\2\2\u0318"+
		"\u0319\t\6\2\2\u0319\u0377\5D#\25\u031a\u031b\f\23\2\2\u031b\u031c\t\7"+
		"\2\2\u031c\u0377\5D#\24\u031d\u031e\f\22\2\2\u031e\u031f\t\b\2\2\u031f"+
		"\u0377\5D#\23\u0320\u0321\f\21\2\2\u0321\u0322\t\t\2\2\u0322\u0377\5D"+
		"#\22\u0323\u0330\f\20\2\2\u0324\u0331\7\22\2\2\u0325\u0331\7\23\2\2\u0326"+
		"\u0331\7\24\2\2\u0327\u0331\7\25\2\2\u0328\u0331\79\2\2\u0329\u032a\7"+
		"9\2\2\u032a\u0331\7B\2\2\u032b\u0331\7\65\2\2\u032c\u0331\7=\2\2\u032d"+
		"\u0331\7\60\2\2\u032e\u0331\7?\2\2\u032f\u0331\7L\2\2\u0330\u0324\3\2"+
		"\2\2\u0330\u0325\3\2\2\2\u0330\u0326\3\2\2\2\u0330\u0327\3\2\2\2\u0330"+
		"\u0328\3\2\2\2\u0330\u0329\3\2\2\2\u0330\u032b\3\2\2\2\u0330\u032c\3\2"+
		"\2\2\u0330\u032d\3\2\2\2\u0330\u032e\3\2\2\2\u0330\u032f\3\2\2\2\u0331"+
		"\u0332\3\2\2\2\u0332\u0377\5D#\21\u0333\u0334\f\17\2\2\u0334\u0335\7\32"+
		"\2\2\u0335\u0377\5D#\20\u0336\u0337\f\16\2\2\u0337\u0338\7G\2\2\u0338"+
		"\u0377\5D#\17\u0339\u033a\f\b\2\2\u033a\u033c\79\2\2\u033b\u033d\7B\2"+
		"\2\u033c\u033b\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u0377"+
		"\5D#\t\u033f\u0341\f\7\2\2\u0340\u0342\7B\2\2\u0341\u0340\3\2\2\2\u0341"+
		"\u0342\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0344\7\35\2\2\u0344\u0345\5"+
		"D#\2\u0345\u0346\7\32\2\2\u0346\u0347\5D#\b\u0347\u0377\3\2\2\2\u0348"+
		"\u0349\f\13\2\2\u0349\u034a\7!\2\2\u034a\u0377\5T+\2\u034b\u034d\f\n\2"+
		"\2\u034c\u034e\7B\2\2\u034d\u034c\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u034f"+
		"\3\2\2\2\u034f\u0350\t\n\2\2\u0350\u0353\5D#\2\u0351\u0352\7*\2\2\u0352"+
		"\u0354\5D#\2\u0353\u0351\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0377\3\2\2"+
		"\2\u0355\u035a\f\t\2\2\u0356\u035b\7:\2\2\u0357\u035b\7C\2\2\u0358\u0359"+
		"\7B\2\2\u0359\u035b\7D\2\2\u035a\u0356\3\2\2\2\u035a\u0357\3\2\2\2\u035a"+
		"\u0358\3\2\2\2\u035b\u0377\3\2\2\2\u035c\u035e\f\6\2\2\u035d\u035f\7B"+
		"\2\2\u035e\u035d\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u0360\3\2\2\2\u0360"+
		"\u0374\7\65\2\2\u0361\u036b\7b\2\2\u0362\u036c\5\64\33\2\u0363\u0368\5"+
		"D#\2\u0364\u0365\7^\2\2\u0365\u0367\5D#\2\u0366\u0364\3\2\2\2\u0367\u036a"+
		"\3\2\2\2\u0368\u0366\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036c\3\2\2\2\u036a"+
		"\u0368\3\2\2\2\u036b\u0362\3\2\2\2\u036b\u0363\3\2\2\2\u036b\u036c\3\2"+
		"\2\2\u036c\u036d\3\2\2\2\u036d\u0375\7c\2\2\u036e\u036f\5V,\2\u036f\u0370"+
		"\7a\2\2\u0370\u0372\3\2\2\2\u0371\u036e\3\2\2\2\u0371\u0372\3\2\2\2\u0372"+
		"\u0373\3\2\2\2\u0373\u0375\5X-\2\u0374\u0361\3\2\2\2\u0374\u0371\3\2\2"+
		"\2\u0375\u0377\3\2\2\2\u0376\u0314\3\2\2\2\u0376\u0317\3\2\2\2\u0376\u031a"+
		"\3\2\2\2\u0376\u031d\3\2\2\2\u0376\u0320\3\2\2\2\u0376\u0323\3\2\2\2\u0376"+
		"\u0333\3\2\2\2\u0376\u0336\3\2\2\2\u0376\u0339\3\2\2\2\u0376\u033f\3\2"+
		"\2\2\u0376\u0348\3\2\2\2\u0376\u034b\3\2\2\2\u0376\u0355\3\2\2\2\u0376"+
		"\u035c\3\2\2\2\u0377\u037a\3\2\2\2\u0378\u0376\3\2\2\2\u0378\u0379\3\2"+
		"\2\2\u0379E\3\2\2\2\u037a\u0378\3\2\2\2\u037b\u037c\t\13\2\2\u037cG\3"+
		"\2\2\2\u037d\u037e\t\f\2\2\u037eI\3\2\2\2\u037f\u0380\5b\62\2\u0380K\3"+
		"\2\2\2\u0381\u0383\5J&\2\u0382\u0381\3\2\2\2\u0383\u0384\3\2\2\2\u0384"+
		"\u0382\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0390\3\2\2\2\u0386\u0387\7b"+
		"\2\2\u0387\u0388\5f\64\2\u0388\u0389\7c\2\2\u0389\u0391\3\2\2\2\u038a"+
		"\u038b\7b\2\2\u038b\u038c\5f\64\2\u038c\u038d\7^\2\2\u038d\u038e\5f\64"+
		"\2\u038e\u038f\7c\2\2\u038f\u0391\3\2\2\2\u0390\u0386\3\2\2\2\u0390\u038a"+
		"\3\2\2\2\u0390\u0391\3\2\2\2\u0391M\3\2\2\2\u0392\u0393\5b\62\2\u0393"+
		"O\3\2\2\2\u0394\u0395\5R*\2\u0395Q\3\2\2\2\u0396\u0397\t\r\2\2\u0397S"+
		"\3\2\2\2\u0398\u0399\5b\62\2\u0399U\3\2\2\2\u039a\u039b\5b\62\2\u039b"+
		"W\3\2\2\2\u039c\u039d\5b\62\2\u039dY\3\2\2\2\u039e\u039f\t\16\2\2\u039f"+
		"[\3\2\2\2\u03a0\u03a1\5b\62\2\u03a1]\3\2\2\2\u03a2\u03a3\5b\62\2\u03a3"+
		"_\3\2\2\2\u03a4\u03a5\5b\62\2\u03a5a\3\2\2\2\u03a6\u03a9\5\62\32\2\u03a7"+
		"\u03a9\7m\2\2\u03a8\u03a6\3\2\2\2\u03a8\u03a7\3\2\2\2\u03a9c\3\2\2\2\u03aa"+
		"\u03ab\7n\2\2\u03abe\3\2\2\2\u03ac\u03ae\t\7\2\2\u03ad\u03ac\3\2\2\2\u03ad"+
		"\u03ae\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03b0\7j\2\2\u03b0g\3\2\2\2\u03b1"+
		"\u03b2\7J\2\2\u03b2\u03b7\7b\2\2\u03b3\u03b8\7\64\2\2\u03b4\u03b5\t\17"+
		"\2\2\u03b5\u03b6\7^\2\2\u03b6\u03b8\5j\66\2\u03b7\u03b3\3\2\2\2\u03b7"+
		"\u03b4\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03ba\7c\2\2\u03bai\3\2\2\2\u03bb"+
		"\u03bc\7n\2\2\u03bck\3\2\2\2\u0084osv\u0081\u0086\u008f\u0095\u0099\u00aa"+
		"\u00b4\u00b8\u00c2\u00c6\u00c8\u00cf\u00d5\u00d9\u00de\u00e3\u00e7\u00f4"+
		"\u00f7\u00fe\u0104\u0108\u010d\u0117\u0132\u0136\u013f\u0144\u014a\u014f"+
		"\u0153\u015a\u015d\u0165\u016f\u0172\u0178\u017a\u017e\u0185\u0188\u0190"+
		"\u0194\u0197\u01a3\u01a8\u01aa\u01b3\u01be\u01c5\u01c8\u01d1\u01d4\u01d6"+
		"\u01db\u01df\u01e2\u01e9\u01f1\u01f5\u01f9\u01fc\u0202\u0205\u0207\u020d"+
		"\u0214\u0217\u021f\u0229\u022c\u0232\u0234\u0238\u023f\u0242\u024a\u024e"+
		"\u0252\u025b\u0260\u0262\u026b\u0276\u027d\u0280\u0287\u028d\u0293\u0298"+
		"\u029c\u02a0\u02a4\u02a8\u02ab\u02b6\u02bb\u02c4\u02c9\u02d3\u02d6\u02e1"+
		"\u02e6\u02f5\u02f8\u0300\u0309\u030d\u0312\u0330\u033c\u0341\u034d\u0353"+
		"\u035a\u035e\u0368\u036b\u0371\u0374\u0376\u0378\u0384\u0390\u03a8\u03ad"+
		"\u03b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}