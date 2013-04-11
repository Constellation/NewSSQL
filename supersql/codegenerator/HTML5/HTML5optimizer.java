package supersql.codegenerator.HTML5;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import supersql.codegenerator.HTML.HTMLoptimizer;

public class HTML5optimizer extends HTMLoptimizer{
	//created by chie
	//2007-2009

	public HTML5optimizer() {
	}
	
	public String startOptimizer(){
		try{
			
			/*optimizer start*/
		    System.out.println("******** OPTIMIZER *********");
			
		    
		    front(root);
			
		    
		    walk(root);
						
			
			countTrAndTd(root);
			
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();			
			TransformerFactory tfactory = TransformerFactory.newInstance(); 
			Transformer transformer = tfactory.newTransformer(); 
			transformer.setOutputProperty(OutputKeys.ENCODING, "Shift_JIS");
			//transformer.setOutputProperty(OutputKeys.ENCODING, "EUC_JP");
			Document html = db.newDocument();
			Element r = (Element)root;
			Element htmlroot = html.createElement("TABLE");
			/*
			if(r.getAttribute("tabletype").equals("none"))
				htmlroot = html.createElement("BODY");
			*/
			Element firstChild = null;
			for(Node tmp = root.getFirstChild();tmp!=null;tmp = tmp.getNextSibling()){
				if(tmp.getNodeName().equals("tfe")){
					firstChild = (Element)tmp;
					break;
				}
			}
			if(firstChild != null && firstChild.getNodeName().equals("tfe") /*&& !r.getAttribute("tabletype").equals("none")*/){
				if(firstChild.hasAttribute("border")){
					htmlroot.setAttribute("border",firstChild.getAttribute("border"));
				}else{
					htmlroot.setAttribute("border","1");
				}
				if(firstChild.hasAttribute("class")){
					htmlroot.setAttribute("class",firstChild.getAttribute("class"));
				}
			}

			html.appendChild(htmlroot);

			//transformer.transform(new DOMSource(root.getOwnerDocument()), new StreamResult(new File("C:/ssqltest/bbb.xml")));
			createTable(root,htmlroot);	
			
		
			StringWriter    outWriter = new StringWriter();
			
			
			
			DOMSource    source = new DOMSource(html);
			StreamResult    result = new StreamResult(outWriter);
			/* output debug xml file */
			//transformer.transform(new DOMSource(root.getOwnerDocument()), new StreamResult(new File("C:/ssqltest/bbb.xml")));
			
			transformer.transform(source, result);
			String xml_str = outWriter.toString();
			
			//create html file
			/*
			if(root.getAttribute("tabletype").equals("none")){
				xml_str = xml_str.replaceFirst("<BODY>","");
				xml_str = xml_str.replaceFirst("</BODY>","");
			}
			*/
			xml_str = xml_str.replaceFirst("<?.*?>","");
			xml_str = xml_str.replace("<TR/>","<TR></TR>");
			xml_str = xml_str.replace("</TR>","</TR>\n");


			//Log.out(xml_str);
			while(xml_str.contains("&amp;"))
				xml_str = xml_str.replace("&amp;","&");
			while(xml_str.contains("&lt;"))
				xml_str = xml_str.replace("&lt;","<");
			while(xml_str.contains("&gt;"))
				xml_str = xml_str.replace("&gt;",">");
			
			
			//add 200909 form
			if(xml_str.contains("<form")){
				for(int i = 1; i < HTML5Env.getFormNumber();i++){
					if(xml_str.contains("<form" + i + "start/>")){
						xml_str = xml_str.replace("<form" + i + "start/>",HTML5Env.getFormDetail(i));
					}
					if(xml_str.contains("<form" + i + "end/>")){
						xml_str = xml_str.replace("<form" + i + "end/>","</form>");
					}
				}
				int st = 0;
				while(true){
					if(xml_str.indexOf("<textarea",st) > 0){
						st = xml_str.indexOf("<textarea",st);
						int en = xml_str.indexOf(">",st);
						if(xml_str.charAt(en-1) == '/'){
							String a = xml_str.substring(0,en-1);
							String b = xml_str.substring(en,en+1);
							String c = xml_str.substring(en+1,xml_str.length());
							xml_str = a + b + "</textarea>" + c;
						}
						st++;
					}else{
						break;
					}
				}
			}
			
			
			return xml_str;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

