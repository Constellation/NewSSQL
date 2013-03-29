package supersql.embed;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import supersql.codegenerator.CodeGenerator;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.dataconstructor.DataConstructor;
import supersql.parser.SSQLparser;

/*
import supersql.codegenerator.CodeGenerator;
import supersql.common.GlobalEnv;
import supersql.dataconstructor.DataConstructor;
import supersql.parser.SSQLparser;
*/

public class EmbedServlet extends HttpServlet {
	
  private static final long serialVersionUID = 8021503235844232672L;

  @Override
public void doGet(HttpServletRequest req, 
                      HttpServletResponse res) 
                          throws ServletException, IOException {
	  
	  //work(req,res);
	  
	  	String msg= new String();
	  	String error = new String();
	  	String config = new String();
	  	String query = new String();
	  	String cond = new String();
	  	String target = new String();
	  	
	    // ContentType
	    res.setContentType("text/html; charset=Shift-JIS");
	    //res.setCharacterEncoding("UTF-8");
	    req.setCharacterEncoding("Shift-JIS");
	    //req.setCharacterEncoding("EUC-JP");
	    
	    // PrintWriter
	    PrintWriter out = res.getWriter();

	    //get configfile 
	    config = req.getParameter("config");
    	if(config == null)
    		error = "no config file defined";
    	
    	query = req.getParameter("query");
    	if(query == null)
    		error = "no query file defined";
    
    	cond = req.getParameter("cond");
    	
    	target = req.getParameter("target");
   	if(target == null)
    		error = "no target defined";
    	
    	System.out.println("query"+query);
	    System.out.println("config"+config);
	    System.out.println("cond"+cond);
	    System.out.println("target"+target);
	    System.out.println("error;"+error);
	   
	    if(error.equals(""))
	    {    	
//		    out.println("<font color=\"red\">hello "+msg+"</font>");
		
		    String[] args = {"-f",query,"-c",config, "-o",query,"-cond",cond,
		    		"-ajax","-servlet","-debug"};
		    
		    GlobalEnv.setGlobalEnv(args);
		    GlobalEnv.err_flag = 0;
		    
		    SSQLparser parser = new SSQLparser("online");

			if(GlobalEnv.getErrFlag() == 0)
			{
			    CodeGenerator codegenerator = parser.getcodegenerator();
				
			    if(GlobalEnv.getErrFlag() == 0)
				{
			    	DataConstructor dc = new DataConstructor(parser);
					
			    	if(GlobalEnv.getErrFlag() == 0)
					{
			    		//temporary comment out for ajax
//			    		out.println(codegenerator.generateCode4(parser,dc.getData()));
			    		
			    		if(GlobalEnv.getErrFlag() == 0)
			    		{
			    			String code = codegenerator.generateCode2(parser, dc.getData()).toString();
//			    			out.println("<br><a href=\"close.html\" class=\"top_close_"+target+"\" onClick=\"return closeDiv('"+target+"')\">close</a><br>");
			    			out.println(code);
//			    			out.println("<br><a href=\"close.html\" class=\"bottom_close_"+target+"\" onClick=\"return closeDiv('"+target+"')\">close</a><br>");
//			    			System.out.println("<br><a href=\"close.html\" class=\"close_"+target+"\" onClick=\"return closeDiv('"+target+"')\">close</a><br>");
//			    			System.out.println("code:"+code);
			    		}
					}
				}
			    	
		    } 
		    
			System.out.println("errflag:"+GlobalEnv.getErrFlag());
			
		   	if(GlobalEnv.getErrFlag() == 1)
		   	{
		   		out.println("<font color=RED>");
		   		out.println("ERR " + GlobalEnv.getErr());
		   	}
		   	else
		   	{
				long end = System.currentTimeMillis();
				Log.info("end");
		   	}
	    }  
	    else
	    {
	    	out.print("<font color=\"black\">error"+error+"</font>");
	    }

	    
	    out.flush();
	    out.close();
  }
  
  protected void work(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
    PrintWriter out = response.getWriter();
	  out.println("hogehoge");	  
	  return;
  }
}
