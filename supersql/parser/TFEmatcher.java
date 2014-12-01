package supersql.parser;

import java.util.LinkedHashMap;

import supersql.common.GlobalEnv;
import supersql.common.Log;

//halken TFEmatcher
public class TFEmatcher {
	
	private static boolean tfeMatchrFlg = false;
	private static boolean tokenCountFlg = false;
	private static int tokenPlace = 0;
	private static int prevIndex = 0;
	private static LinkedHashMap<Integer, Integer> TFEList = new LinkedHashMap<Integer, Integer>();
	
	public TFEmatcher() {
		
	}
	
    //startTokenCount
    public static void startTokenCount() {
    	if(tfeMatchrFlg = GlobalEnv.isTFEmatcher()){
	    	tokenCountFlg = true;
	    	tokenPlace = 0;
	    	prevIndex = 0;	
	    	TFEList.clear();
//    		printStr(str);			//このメソッドは不要
    	}
    }
    
//	//このメソッドは確認用のため、不要
//    private static void printStr(String str) {
//    	if(tfeMatchrFlg){
//	    	Log.i("\n"+str);
//			for(int i=0;i<str.length();i++)
//				Log.i(i+1+" 文字目 : "+str.charAt(i));
//			Log.i("");
//    	}
//    }
    
    //文字数をカウント
    //tokenCounter
    public static void tokenCounter(String s, int ind) {
    	if(tfeMatchrFlg && tokenCountFlg && ind>prevIndex){
			tokenPlace += s.length();
    		prevIndex = ind;
    	}
    }
    
    //各TFEが何文字目で終わるかを記録
    //addTFEid_and_TokenPlace
    public static void addTFEid_and_TokenPlace(int id) {
    	if(tfeMatchrFlg){
	    	//Log.i("!! TFE"+id+ " = "+tokenPlace+" 文字目");
	    	TFEList.put(id, tokenPlace);
    	}
    }
    
	//endTokenCount
	public static void endTokenCount() {
		tokenCountFlg = false;
	}
	
	//output
	public static void output() {
		if(tfeMatchrFlg){
			Log.info("");
			int i = 0;
			for(int key : TFEList.keySet())
				Log.info(/*"#"+key+" = "+*/"TFEidx_end["+(i++)+"] : "+TFEList.get(key));
		}
	}
}
