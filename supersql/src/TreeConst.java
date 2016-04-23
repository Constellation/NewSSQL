package supersql.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import supersql.parser.prefixParser;
import supersql.parser.querytestParser;

public class TreeConst {
	public static List<SSQLParseTree> tree;
	public static boolean terminal_flag = false; // flag for if terminal node?

	public static List<SSQLParseTree> createSSQLParseTree(ParseTree t, querytestParser recog) {
		String[] ruleNames = recog != null ? recog.getRuleNames() : null;
		List<String> ruleNamesList = ruleNames != null ? Arrays.asList(ruleNames) : null;
		return createSSQLParseTree(t, ruleNamesList);
	}
	
	public static List<SSQLParseTree> createSSQLParseTree(ParseTree t, prefixParser recog) {
		String[] ruleNames = recog != null ? recog.getRuleNames() : null;
		List<String> ruleNamesList = ruleNames != null ? Arrays.asList(ruleNames) : null;
		return createSSQLParseTree(t, ruleNamesList);
	}
	
	/*
	 * generate tree structure & list of attributes in TFE
	 */
	public static List<SSQLParseTree> createSSQLParseTree(final ParseTree t, final List<String> ruleNamesList){
		SSQLParseTree test = new SSQLParseTree();
		String s = getNodeText(t, ruleNamesList);
		test.parent_id = t.toString();
		test.parent_info = s;
		
		for (int i = 0; i<t.getChildCount(); i++) {
			Node n = new Node();
			ParseTree p = t.getChild(i);
			String k = getNodeText(p, ruleNamesList);
			
			n.id = p.toString();
			n.node = k;
			test.children.add(n);
		}
		if(tree == null){
			tree = new ArrayList<SSQLParseTree>();
		}
		tree.add(test);
		for (int i = 0; i<t.getChildCount(); i++) {
			if(t.getChild(i).getChildCount() == 0){
				continue;
			}else{
				createSSQLParseTree(t.getChild(i), ruleNamesList);
			}
		}
		
		return tree;
	}
	
	
	
	
	public static String getNodeText(ParseTree t, List<String> ruleNames) {
		if ( ruleNames!=null ) {
			if ( t instanceof RuleNode) {
				int ruleIndex = ((RuleNode)t).getRuleContext().getRuleIndex();
				String ruleName = ruleNames.get(ruleIndex);
				terminal_flag  = false;
				return ruleName;
			}
			else if ( t instanceof TerminalNode) {
				Token symbol = ((TerminalNode)t).getSymbol();
				if (symbol != null) {
					String s = symbol.getText();
					terminal_flag = true;
					return s;
				}
			}
		}
		// no recog for rule names
		Object payload = t.getPayload();
		if ( payload instanceof Token ) {
			return ((Token)payload).getText();
		}
		return t.getPayload().toString();
	}
	
	
	
	
//	public static void showAtt(List<TFE> attributes2){
//		for(int i = 0; i < attributes2.size(); i++){
//			System.out.println(attributes2.get(i));
//		}
//	}
	
	public static String getMedia(List<SSQLParseTree> tree){
		for(int i = 0; i < tree.size(); i++){
			if(tree.get(i).parent_info.equals("media")){
				return tree.get(i).children.get(1).node;
			}
		}
		return null;
	}
	
	public static List<SSQLParseTree> getfromInfo(List<SSQLParseTree> tree){
		for(int i = 0; i < tree.size(); i++){
			if(tree.get(i).parent_info.equals("from")){
				return tree.subList(i, tree.size()-1);
			}
		}
		return null;
	}
	
//	public static void showTree(SSQLParseTree t){
//		System.out.println(t.parent_info);
//		for(int i = 0; i < t.children.size(); i++){
//			for(int j = 0; j < tree.size();){
//				if(!tree.get(j).parent_id.equals(t.children.get(i).id)){
//					j++;
//					if(j == tree.size()){
//						System.out.println(t.children.get(i).node);
//					}
//				}else{
//					showTree(tree.get(j));
//					break;
//				}
//			}
//		}
//	}

}
