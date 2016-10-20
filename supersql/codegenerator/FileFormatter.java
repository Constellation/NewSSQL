//created by goto 20161019 for HTML Formatter

package supersql.codegenerator;

import java.io.IOException;
import java.io.StringWriter;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XmlSerializer;

import supersql.common.Log;

public class FileFormatter {
	
	public FileFormatter() {
		
	}

    public static String process(String html) {
    	Log.i(html);
    	String r = "";
    	
    	// Create an instance of HtmlCleaner
        HtmlCleaner cleaner = new HtmlCleaner();
        // take default cleaner properties
        CleanerProperties props = cleaner.getProperties();
        
        //TODO CDATAのescape http://htmlcleaner.sourceforge.net/parameters.php
        // customize cleaner's behaviour with property setters
        props.setUseCdataFor("style");	

        try {
            // Exec the Cleaner
        	
        	// Clean HTML taken from simple string, file, URL, input stream, 
        	// input source or reader. Result is root node of created 
        	// tree-like structure. Single cleaner instance may be safely used
        	// multiple times.
            TagNode node = cleaner.clean( html );

            
//        	// serialize a node to a file, output stream, DOM, JDom...
//        	new XXXSerializer(props).writeXmlXXX(aNode, ...);
            StringWriter writer = new StringWriter();
        	new PrettyXmlSerializer(props).writeXml(node, writer, "utf-8");
            
//            // XMLに変換してStringWriterに
//            XmlSerializer serializer = new PrettyXmlSerializer( props );
//            StringWriter writer = new StringWriter();
//            serializer.writeXml(node, writer, "utf-8");

            r = writer.getBuffer().toString();
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
        return (!r.equals(""))? r : html;
    	
    	
    	
//    	// create an instance of HtmlCleaner
//    	HtmlCleaner cleaner = new HtmlCleaner();
//    	 
//    	// take default cleaner properties
//    	CleanerProperties props = cleaner.getProperties();
//    	 
//    	// customize cleaner's behaviour with property setters
////    	props.setXXX(...);
//    	 
//    	// Clean HTML taken from simple string, file, URL, input stream, 
//    	// input source or reader. Result is root node of created 
//    	// tree-like structure. Single cleaner instance may be safely used
//    	// multiple times.
//    	TagNode node = cleaner.clean(...);
//    	 
//    	// optionally find parts of the DOM or modify some nodes
//    	TagNode[] myNodes = node.getElementsByXXX(...);
//    	// and/or
//    	Object[] myNodes = node.evaluateXPath(xPathExpression);
//    	// and/or
//    	aNode.removeFromTree();
//    	// and/or
//    	aNode.addAttribute(attName, attValue);
//    	// and/or
//    	aNode.removeAttribute(attName, attValue);
//    	// and/or
//    	cleaner.setInnerHtml(aNode, htmlContent);
//    	// and/or do some other tree manipulation/traversal
//    	 
//    	// serialize a node to a file, output stream, DOM, JDom...
//    	new XXXSerializer(props).writeXmlXXX(aNode, ...);
//    	myJDom = new JDomSerializer(props, true).createJDom(aNode);
//    	myDom = new DomSerializer(props, true).createDOM(aNode);
    	
    }
}