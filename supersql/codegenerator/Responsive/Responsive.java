package supersql.codegenerator.Responsive;

import java.util.LinkedHashMap;

import supersql.codegenerator.CodeGenerator;
import supersql.codegenerator.DecorateList;
import supersql.extendclass.ExtList;
import supersql.parser.Start_Parse;

//added by goto 20161217
public class Responsive {
	
	private final static String MODIFIER = "responsive";
	private static boolean responsive = false;
	private static boolean reExec = false;		//CG再実行時: true
	
	public static LinkedHashMap<String, LinkedHashMap<String, String>> fixMap = new LinkedHashMap<>();
	
	
	public Responsive() {

	}
	
	
	// check()
	public static boolean check(DecorateList decos) {
		if(decos.containsKey(MODIFIER)){
			responsive = true;
			return true;
		}
		return false;
	}
	
	// isResponsive()
	public static boolean isResponsive() {
		return responsive;
	}
	
	
	// process() : process1, process2 の実行
	public static boolean process(CodeGenerator codegenerator, Start_Parse parser, ExtList extList) {
		if(!isResponsive())	return false;
		
		LinkedHashMap<String, LinkedHashMap<String, String>> fixMap = process1();
		process2(fixMap, codegenerator, parser, extList);
		return true;
	}
	
	// process1() : TFE全体に@{responsive}がついていた場合に、HTMLなどが生成された後Responsiveの処理に投げる
	private static LinkedHashMap<String, LinkedHashMap<String, String>> process1() {
		//TODO HTMLなどをチェックするメソッドの呼び出し
		//LinkedHashMap<String, LinkedHashMap<String, String>> fixMap = xxx();
		
		/* テスト用の定義 */
		//{TFE10020={lg=1/8, md=1/7, sm=1/5, xs=1/3}}
		LinkedHashMap<String, LinkedHashMap<String, String>> fixMap = new LinkedHashMap<>();
		//lg=1/8, md=1/7, sm=1/5, xs=1/3
		LinkedHashMap<String, String> x = new LinkedHashMap<>();
		x.put("lg", "1/8");
		x.put("md", "1/7");
		x.put("sm", "1/5");
		x.put("xs", "1/3");
		//{TFE10020={x}}
		fixMap.put("TFE10020", x);

		return fixMap;
	}
	
	// process2() : 修正案がResponsive側から返ってきたときに、Code Generatorを再実行する
	private static boolean process2(LinkedHashMap<String, LinkedHashMap<String, String>> fixMap, CodeGenerator codegenerator, Start_Parse parser, ExtList extList) {
		Responsive.fixMap = fixMap;
		Responsive.reExec = true;
		codegenerator.generateCode(parser, extList);	//再実行
		Responsive.reExec = false;
		return true;
	}
	// isReExec()
	public static boolean isReExec() {
		return reExec;
	}

}
