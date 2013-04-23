 package supersql.form;

import java.util.Enumeration;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

import supersql.common.Log;

public class Delete extends HttpServlet {
	
  

  @Override
public void doPost(HttpServletRequest req, 
                      HttpServletResponse res) 
                          throws ServletException, IOException {

    // ContentTypeを設定
    res.setContentType("text/html; charset=Shift_JIS");
    req.setCharacterEncoding("Shift-JIS");
    
    // 出力用PrintWriterを取得
    PrintWriter out = res.getWriter();

    String sqlfile = new String();
    sqlfile = req.getHeader("referer");

	Log.info(sqlfile);
	/*
	sqlfile = sqlfile.substring(sqlfile.indexOf("query=")+6);
	sqlfile = sqlfile.substring(0,sqlfile.indexOf("&cond"));

	Log.info(sqlfile);
    */
    //sqlfile = sqlfile.substring(sqlfile.indexOf("&query="),sqlfile.indexOf("&",sqlfile.indexOf("&query=")));
    /*
    try{
    	sqlfile = req.getParameter("sqlfile");
    }catch(NullPointerException e){
    	out.println("no ssql file \n");
    	System.exit(-1);
    }
    */

    int i = 1;
    int flag = 0;
    
    String cond_name = new String(); 
    String cond = new String();
    String value = new String();
    String value_type = new String();
    String where = new String();

    String configfile = new String(); 
    String updatefile = new String(); 
    while(true)
	{   
    	/*
    	try{
    		configfile = req.getParameter("configfile");
    	}catch(NullPointerException e)
    	{
    		out.println("no config file defined /n");
    		System.exit(-1);
    		
    	}
    	*/
    	configfile = "http://localhost:8080/invoke/config.ssql";
    	
    	Enumeration<String> names = req.getParameterNames();
    	String sql = new String();
    	String tabname = new String();
    	String attlist = new String();
    	String vallist = new String();
    	
    	//get TABLE
    	if(req.getParameter("tableinfo") != null){
    		String[] strAry = req.getParameter("tableinfo").split(" ");
        	tabname += strAry[0];
    	}
    	
    	//get ATT and VALUE
        while (names.hasMoreElements()){
        	String name = names.nextElement();
        	if(name.contains(".")){
        		if(!req.getParameter(name).equals(null) && req.getParameter(name).length() != 0){
        			attlist += name.substring(name.indexOf(".")+1,name.length())  + ",";
    	        	vallist += "'"+ req.getParameter(name)+ "' " + ",";
    	    	}
        	}
        }
        if(attlist.length() != 0){
	        attlist = attlist.substring(0,attlist.length()-1);
	        vallist = vallist.substring(0,vallist.length()-1);
	       	sql = "DELETE FROM " + tabname + " WHERE " + attlist + " = " + vallist + " ;";
	    	delete(sql);
        }
        
    	Log.info("sql:"+sql);
    	
    	break;
    	
	}
    //added by chie update
    /*
    if(!updatefile.equals(null)){
		update(updatefile);
	}
	*/
    
//    String[] args = {"-f",sqlfile,"-cond",where,"-debug","-h",host,"-u",user,"-db",dbname};
    
    String[] args = {"-f",sqlfile,"-cond",where,"-c",configfile};

// String[] args = {"-f",sqlfile,"-cond",where,"-debug","-c",configfile};
    
    res.sendRedirect(sqlfile);
    /*
    GlobalEnv.setGlobalEnv(args);
	SSQLparser parser = new SSQLparser("online");

	CodeGenerator codegenerator = parser.getcodegenerator();

	DataConstructor dc = new DataConstructor(parser);
	
	//add chie
	String[] headfoot = codegenerator.generateCode4(parser,dc.getData()).toString().split(" ###split### ");
	out.println(headfoot[0]);
	out.println(codegenerator.generateCode2(parser, dc.getData()));
    out.println(headfoot[1]);
    */
  } 
  public void delete(String sql){
	  
	  //update database
	  try {
	      // データベースへ接続
		  Class.forName("org.postgresql.Driver"); // PostgreSQLの場合
	      Connection con =
	        DriverManager.getConnection("jdbc:postgresql:ssql",
	                                    "chie",
	                                    ""); // PostgreSQLの場合
	      // ステートメントオブジェクトを生成
	      Statement stmt = con.createStatement();
	
	      // クエリーを実行して結果セットを取得
	      stmt.executeQuery(sql);
	      
	      return;
      } catch (Exception e) {
          System.err.println("sqlerr"+ e);
      }
  }
}