package supersql.parser;

import supersql.codegenerator.DecorateList;

//goto 20130915-2  "<$  $>"
public class Embed {
	
	final static String EMBED_LABEL = "_embedLabel_";
	
	public static String checkEmbed(String q) {
		
		while(q.contains("<$")){
			//Log.e("c!! q="+q);
			int index1,index2;
			index1 = q.indexOf("<$");
			String buf1 = q.substring(index1+2);
			index2 = buf1.indexOf("$>")+4;
			String buf2 = buf1.substring(0, index2-4);
			
			buf2 = buf2.replace("\"", "\\\"");	//TODO check
			
			q = q.substring(0,index1) + "! {\""+buf2+"\"}@{"+EMBED_LABEL+", div}!" + q.substring(index1+index2);
			//Log.e(buf2);
		}
		//Log.e("q="+q);
		
//		//goto 20130915-2  "<$  $>"
//		if (line.contains("<$")){
//			String line1 = line.substring(0, line.indexOf("<$"));
//			String buf = "";
//			while (!line.contains("$>")){
//				line = in.readLine();
//				buf += line+"\n";
//			}
//			buf = buf.substring(0,buf.lastIndexOf("$>"));	//substring last '?>'
//			textString.add(textNum, buf);
//			line = line1 + line.substring(line.indexOf("$>") + 2);
//			Log.e(textString.get(textNum));
//			textNum++;
//		}
//		try{
//			if (line.startsWith(IMPORT)){
//				while (line.startsWith(IMPORT)){
//					importString.add(line);
//					line = in.readLine();
//				}
//			}
//		}catch (Exception e) {	}
//		return line;
		return q;
	}
	
	public static boolean embed = false;
	
	public static StringBuffer preProcess(StringBuffer code, DecorateList decos) {
		if(isEmbed(decos)){
			//Log.e(decos);
			code = code.delete(code.lastIndexOf("<"), code.lastIndexOf(">")+1);	//TODO
			embed = true;
			return code;
		}
		return code;
	}
	
	public static StringBuffer postProcess(StringBuffer code) {
		if(embed){
			code = code.delete(code.lastIndexOf("<"), code.lastIndexOf(">")+1);	//TODO
			embed = false;
			return code;
		}
		return code;
	}
	
	public static boolean isEmbed(DecorateList decos) {
		if(decos.containsKey(EMBED_LABEL)){
			return true;
		}
		return false;
	}

}
