// Generated from querytest.g4 by ANTLR 4.5

package supersql.parser;

import java.util.*;
import java.io.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link querytestParser}.
 */
public interface querytestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link querytestParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(querytestParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(querytestParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(querytestParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(querytestParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#media}.
	 * @param ctx the parse tree
	 */
	void enterMedia(querytestParser.MediaContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#media}.
	 * @param ctx the parse tree
	 */
	void exitMedia(querytestParser.MediaContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(querytestParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(querytestParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#grouper}.
	 * @param ctx the parse tree
	 */
	void enterGrouper(querytestParser.GrouperContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#grouper}.
	 * @param ctx the parse tree
	 */
	void exitGrouper(querytestParser.GrouperContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#composite_iterator}.
	 * @param ctx the parse tree
	 */
	void enterComposite_iterator(querytestParser.Composite_iteratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#composite_iterator}.
	 * @param ctx the parse tree
	 */
	void exitComposite_iterator(querytestParser.Composite_iteratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(querytestParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(querytestParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#d_exp}.
	 * @param ctx the parse tree
	 */
	void enterD_exp(querytestParser.D_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#d_exp}.
	 * @param ctx the parse tree
	 */
	void exitD_exp(querytestParser.D_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#v_exp}.
	 * @param ctx the parse tree
	 */
	void enterV_exp(querytestParser.V_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#v_exp}.
	 * @param ctx the parse tree
	 */
	void exitV_exp(querytestParser.V_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#h_exp}.
	 * @param ctx the parse tree
	 */
	void enterH_exp(querytestParser.H_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#h_exp}.
	 * @param ctx the parse tree
	 */
	void exitH_exp(querytestParser.H_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#n_exp}.
	 * @param ctx the parse tree
	 */
	void enterN_exp(querytestParser.N_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#n_exp}.
	 * @param ctx the parse tree
	 */
	void exitN_exp(querytestParser.N_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#sorting}.
	 * @param ctx the parse tree
	 */
	void enterSorting(querytestParser.SortingContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#sorting}.
	 * @param ctx the parse tree
	 */
	void exitSorting(querytestParser.SortingContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(querytestParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(querytestParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#aggregate}.
	 * @param ctx the parse tree
	 */
	void enterAggregate(querytestParser.AggregateContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#aggregate}.
	 * @param ctx the parse tree
	 */
	void exitAggregate(querytestParser.AggregateContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#if_then_else}.
	 * @param ctx the parse tree
	 */
	void enterIf_then_else(querytestParser.If_then_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#if_then_else}.
	 * @param ctx the parse tree
	 */
	void exitIf_then_else(querytestParser.If_then_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#from_where}.
	 * @param ctx the parse tree
	 */
	void enterFrom_where(querytestParser.From_whereContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#from_where}.
	 * @param ctx the parse tree
	 */
	void exitFrom_where(querytestParser.From_whereContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#error}.
	 * @param ctx the parse tree
	 */
	void enterError(querytestParser.ErrorContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#error}.
	 * @param ctx the parse tree
	 */
	void exitError(querytestParser.ErrorContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#sql_stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterSql_stmt_list(querytestParser.Sql_stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#sql_stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitSql_stmt_list(querytestParser.Sql_stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#sql_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSql_stmt(querytestParser.Sql_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#sql_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSql_stmt(querytestParser.Sql_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#factored_select_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFactored_select_stmt(querytestParser.Factored_select_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#factored_select_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFactored_select_stmt(querytestParser.Factored_select_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#select_core}.
	 * @param ctx the parse tree
	 */
	void enterSelect_core(querytestParser.Select_coreContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#select_core}.
	 * @param ctx the parse tree
	 */
	void exitSelect_core(querytestParser.Select_coreContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(querytestParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(querytestParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#result_column}.
	 * @param ctx the parse tree
	 */
	void enterResult_column(querytestParser.Result_columnContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#result_column}.
	 * @param ctx the parse tree
	 */
	void exitResult_column(querytestParser.Result_columnContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#table_or_subquery}.
	 * @param ctx the parse tree
	 */
	void enterTable_or_subquery(querytestParser.Table_or_subqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#table_or_subquery}.
	 * @param ctx the parse tree
	 */
	void exitTable_or_subquery(querytestParser.Table_or_subqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(querytestParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(querytestParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#select_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSelect_stmt(querytestParser.Select_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#select_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSelect_stmt(querytestParser.Select_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#select_or_values}.
	 * @param ctx the parse tree
	 */
	void enterSelect_or_values(querytestParser.Select_or_valuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#select_or_values}.
	 * @param ctx the parse tree
	 */
	void exitSelect_or_values(querytestParser.Select_or_valuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#compound_operator}.
	 * @param ctx the parse tree
	 */
	void enterCompound_operator(querytestParser.Compound_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#compound_operator}.
	 * @param ctx the parse tree
	 */
	void exitCompound_operator(querytestParser.Compound_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#join_clause}.
	 * @param ctx the parse tree
	 */
	void enterJoin_clause(querytestParser.Join_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#join_clause}.
	 * @param ctx the parse tree
	 */
	void exitJoin_clause(querytestParser.Join_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#join_operator}.
	 * @param ctx the parse tree
	 */
	void enterJoin_operator(querytestParser.Join_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#join_operator}.
	 * @param ctx the parse tree
	 */
	void exitJoin_operator(querytestParser.Join_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#join_constraint}.
	 * @param ctx the parse tree
	 */
	void enterJoin_constraint(querytestParser.Join_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#join_constraint}.
	 * @param ctx the parse tree
	 */
	void exitJoin_constraint(querytestParser.Join_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#common_table_expression}.
	 * @param ctx the parse tree
	 */
	void enterCommon_table_expression(querytestParser.Common_table_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#common_table_expression}.
	 * @param ctx the parse tree
	 */
	void exitCommon_table_expression(querytestParser.Common_table_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#ordering_term}.
	 * @param ctx the parse tree
	 */
	void enterOrdering_term(querytestParser.Ordering_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#ordering_term}.
	 * @param ctx the parse tree
	 */
	void exitOrdering_term(querytestParser.Ordering_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(querytestParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(querytestParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_value(querytestParser.Literal_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_value(querytestParser.Literal_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(querytestParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(querytestParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(querytestParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(querytestParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#type_name}.
	 * @param ctx the parse tree
	 */
	void enterType_name(querytestParser.Type_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#type_name}.
	 * @param ctx the parse tree
	 */
	void exitType_name(querytestParser.Type_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(querytestParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(querytestParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#ag_function_name}.
	 * @param ctx the parse tree
	 */
	void enterAg_function_name(querytestParser.Ag_function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#ag_function_name}.
	 * @param ctx the parse tree
	 */
	void exitAg_function_name(querytestParser.Ag_function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#ag_keyword}.
	 * @param ctx the parse tree
	 */
	void enterAg_keyword(querytestParser.Ag_keywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#ag_keyword}.
	 * @param ctx the parse tree
	 */
	void exitAg_keyword(querytestParser.Ag_keywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#collation_name}.
	 * @param ctx the parse tree
	 */
	void enterCollation_name(querytestParser.Collation_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#collation_name}.
	 * @param ctx the parse tree
	 */
	void exitCollation_name(querytestParser.Collation_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#database_name}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_name(querytestParser.Database_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#database_name}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_name(querytestParser.Database_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(querytestParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(querytestParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void enterColumn_alias(querytestParser.Column_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void exitColumn_alias(querytestParser.Column_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name(querytestParser.Column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name(querytestParser.Column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void enterTable_alias(querytestParser.Table_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void exitTable_alias(querytestParser.Table_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#index_name}.
	 * @param ctx the parse tree
	 */
	void enterIndex_name(querytestParser.Index_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#index_name}.
	 * @param ctx the parse tree
	 */
	void exitIndex_name(querytestParser.Index_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#any_name}.
	 * @param ctx the parse tree
	 */
	void enterAny_name(querytestParser.Any_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#any_name}.
	 * @param ctx the parse tree
	 */
	void exitAny_name(querytestParser.Any_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#sl}.
	 * @param ctx the parse tree
	 */
	void enterSl(querytestParser.SlContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#sl}.
	 * @param ctx the parse tree
	 */
	void exitSl(querytestParser.SlContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#signed_number}.
	 * @param ctx the parse tree
	 */
	void enterSigned_number(querytestParser.Signed_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#signed_number}.
	 * @param ctx the parse tree
	 */
	void exitSigned_number(querytestParser.Signed_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#raise_function}.
	 * @param ctx the parse tree
	 */
	void enterRaise_function(querytestParser.Raise_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#raise_function}.
	 * @param ctx the parse tree
	 */
	void exitRaise_function(querytestParser.Raise_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link querytestParser#error_message}.
	 * @param ctx the parse tree
	 */
	void enterError_message(querytestParser.Error_messageContext ctx);
	/**
	 * Exit a parse tree produced by {@link querytestParser#error_message}.
	 * @param ctx the parse tree
	 */
	void exitError_message(querytestParser.Error_messageContext ctx);
}