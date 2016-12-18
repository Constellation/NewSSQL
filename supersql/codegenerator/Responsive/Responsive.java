package supersql.codegenerator.Responsive;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import supersql.codegenerator.CodeGenerator;
import supersql.codegenerator.DecorateList;
import supersql.codegenerator.Sass;
import supersql.extendclass.ExtList;
import supersql.parser.Start_Parse;

//added by goto 20161217
public class Responsive {
	
	private final static String MODIFIER = "responsive";
	private static boolean responsive = false;
	private static boolean reExec = false;		//CG再実行時: true
	
	public static LinkedHashMap<String, LinkedHashMap> fixMap = new LinkedHashMap<>();
	
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
		
		LinkedHashMap<String, LinkedHashMap> fixMap = process1(Sass.HTMLCheckMap);
		process2(fixMap, codegenerator, parser, extList);
		return true;
	}
	
	// process1() : TFE全体に@{responsive}がついていた場合に、HTMLなどが生成された後Responsiveの処理に投げる
	private static LinkedHashMap<String, LinkedHashMap> process1(LinkedHashMap SassHTMLCheckMap) {
		//TODO HTMLなどをチェックするメソッドの呼び出し
		LinkedHashMap<Integer, LinkedHashMap>HTMLCheckMap = SassHTMLCheckMap;
		
		Driver.setupDriver();
		
		for(Entry<Integer, LinkedHashMap> e : HTMLCheckMap.entrySet()) {
			LinkedHashMap<String, LinkedHashMap> C1G1Map_B = e.getValue();
			if(C1G1Map_B.containsKey("C1")){
				C1G1Map_B.get("C1");
				Fix_C1.C1Fix(C1G1Map_B.get("C1"));
			}else if(C1G1Map_B.containsKey("G1")){
				C1G1Map_B.get("G1");
				Fix_G1.G1Fix(C1G1Map_B.get("G1"));
			}
		}
		
		Driver.quitDriver();
		
		LinkedHashMap<String, LinkedHashMap> fixMap = new LinkedHashMap<>();
		fixMap = Driver.fixMap;
		
		return fixMap;
	}
	
	// process2() : 修正案がResponsive側から返ってきたときに、Code Generatorを再実行する
	private static boolean process2(LinkedHashMap<String, LinkedHashMap> fixMap, CodeGenerator codegenerator, Start_Parse parser, ExtList extList) {
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
	
	// checkBootstrapModifiers()
	public static DecorateList checkBootstrapModifiers(String classid, DecorateList decos) {
		if(isReExec()){
			try {
				LinkedHashMap<String, String> fMap = fixMap.get(classid);
				for (String key : fMap.keySet()) {
					String value = fMap.get(key);
					decos.put(key, value);
				}
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		return decos;
	}

}
