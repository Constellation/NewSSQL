package supersql.form;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

import javax.servlet.*;
import javax.servlet.http.*;

import supersql.codegenerator.CodeGenerator;
import supersql.common.GlobalEnv;
import supersql.dataconstructor.DataConstructor;
import supersql.parser.SSQLparser;

public class FormServlet2 extends HttpServlet {
	
  private static final long serialVersionUID = 8021503235844232672L;

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
    try{
    	sqlfile = req.getParameter("sqlfile");
    }catch(NullPointerException e){
    	out.println("no ssql file \n");
    	System.exit(-1);
    }
    
    String configfile = new String(); 
   	try{
		configfile = req.getParameter("configfile");
	}catch(NullPointerException e)
	{
		out.println("no config file defined /n");
		System.exit(-1);
		
	}

	
    BufferedReader dis;
	URL fileurl = new URL(sqlfile);    
    URLConnection fileurlConnection = fileurl.openConnection();
    String line = new String();
    StringBuffer tmp_query = new StringBuffer();
    
    dis = new BufferedReader(new InputStreamReader(fileurlConnection.getInputStream()));
    
    while (true) {
        line = dis.readLine();

    	if (line == null || line.equals("-1"))
            break;

        //tk start/////////////////////////////////////
        if(line.startsWith("//"))
        	line = dis.readLine();
        if(line.startsWith("/*"))
        {
        	while(!line.contains("*/"))
        		line = dis.readLine();
        	int t = line.indexOf("*/");
        	line = line.substring(t+2);
//        	line = in.readLine();
        }
        //tk end///////////////////////////////////////
        tmp_query.append(" " + line);
    }	
    
    
    String Query = new String(tmp_query.toString());
    
    StringTokenizer st = new StringTokenizer(Query);

    StringBuffer query = new StringBuffer();
    String[] read_where;
    read_where = new String[1000000000];
    String part = new String();
  
    int i = 0,j=0;
    
    while(st.hasMoreTokens())
    {
		String tmp = st.nextToken();
    	if(tmp.equalsIgnoreCase("where"))
    		break;
    	else
    		query.append(tmp + " ");
    }

    int String_flag = 0;
    int Where_flag = 0;
    int Between_flag = 0;
    int appended_flag = 0;
    int null_variable_num = 0;
    int in_flag = 0;
    
    int k = 0;
    while(st.hasMoreTokens())
    {
    	
    	read_where[i] = st.nextToken().toString(); 
    	
    	if(read_where[i].equalsIgnoreCase("AND") 
    			|| read_where[i].equalsIgnoreCase("OR")
    			|| !st.hasMoreTokens() 
    			|| read_where[i].equalsIgnoreCase("order")) 
    	{
    		
    		int count = 0;
    		int[] position = new int[20];
    		int join_flag = 0;
    		null_variable_num = 0;
    		
    		for(int a = 0; a <= i ; ++a)
    		{
    			if(read_where[a].contains("$"))
    			{
    				count++;
    				position[count] = a;
    			}
    		}
    		out.println("$ count " + count + "<BR>");
    		
    		for(int b = 1; b <= count ; ++b)
    		{
    			k = position[b];
    			String_flag = 0;
    			
    			//変数置き換え
	    		if(read_where[k].contains("$"))
	    		{
	    			
	    			out.println("read_where2 : " + read_where[k] + "<BR>");  				
	    			
	    			//シングルクオテーション除去
	    			if(read_where[k].contains("'"))
	    			{    				
	    				read_where[k] = read_where[k].replace('\'',' ');
	        		   	String_flag = 1;
	    			}
	    			
	    		    out.println("read_where3 : " + read_where[k] + "<BR>");  				
	    			read_where[k] = read_where[k].toString().trim();	    			
	    			
	    			read_where[k] = req.getParameter(read_where[k]);
	    			part = read_where[k];
	    			out.println("part : " + part + " " + "<BR>");
	    			
	    			//取得値分岐
	    			if(part == null || part.length() == 0)
	    				null_variable_num++;
	    			else if(String_flag == 1)
	    			{
	    				read_where[k] = read_where[k] + "'";
	    				read_where[k] = "'" + read_where[k];
	    				String_flag = 0;
	    			}
	    			
	    			out.println("Parameter : " + read_where[k] + "<BR>");
	    		}
    		}
    			//特定条件チェックフラグ
    			for(int a = 0 ; a < i - 1 ;++a)
    			{
    				if(read_where[a].equalsIgnoreCase("BETWEEN"))
    				{
    					if(Between_flag == 1)
    						Between_flag = 0;
    					else
    						Between_flag = 1;
	   				}
	   				if(read_where[a].contains("IN"))
	   				{
  						in_flag = 1;
	   				}
	   			}
	    
    			out.print("in_flag : " + in_flag + " count : "+ count + " null_variable_Num : " + null_variable_num + 
    					"<BR>");
    			out.print("Between flag : " + Between_flag + "<BR>");
    			//本クエリへの結合
    			if(Between_flag == 0)
	    		{
	    	    	if(null_variable_num == 0 || ( in_flag == 1 && count > null_variable_num ) )
	    	    	{
//	    	    		if(part.length() != 0)
//		    	    	{
		    	    		if(Where_flag == 0)
		    	   			{
		    	   				query.append(" WHERE ");
		    	   				Where_flag = 1;
		    	   			}
		       	    		out.print(" append " + part.length() + "<BR>");
		       	    		out.print(" i " + i + "<BR>");
		       	    		for(j = 0; j <= i; ++j)
			    	    	{
		       	    //			out.print(" appended_flag " + appended_flag + " j : " + j + "<BR>");
		        	    		if( (read_where[j].equalsIgnoreCase("AND") || read_where[j].equalsIgnoreCase("OR")) 
		        	    				&& j == i)
		        	   			{		
		        	   			}
		        	   			else if( (read_where[j].equalsIgnoreCase("AND") || read_where[j	].equalsIgnoreCase("OR"))
		        	    					&& j == 0
		        	    					&& appended_flag == 0
		        	    					)
		        	    		{			
		        	    		}
		        	    		else
		        	    		{
		        	    			if(j != i)
		        	    				if(read_where[j+1].length() == 0)
		        	    				{
		        	    					
		        	    				}
		        	    				else
		        	    				{
		        	    					appended_flag = 1;
		        	    					out.print("append : "+ read_where[j] + " j : " + j + "<BR>");
		        	    					if(read_where[j].contains("'%") || read_where[j+1].contains("%'"))
		        	    						query.append(read_where[j]);
		        	    					else
		        	    						query.append(read_where[j]+" ");
		        	    				}
		        	    			else
		        	    			{
	        	    					appended_flag = 1;
	        	    					out.print("append : "+ read_where[j] + " j : " + j + "<BR>");
	        	    					query.append(read_where[j]+" ");
	        	    				}   			
		        	    		}
			    	    	}
			    	   	//}
		    	   	}
		    	   	if(read_where[i].equals("AND") || read_where[i].equals("OR"))
		    	   	{
		    	   		read_where[0] = read_where[i];					    	    		
		        	}	    	    	
		   	    	i = 0;
	    		}		 		
    		}   	
    	i++;
    }
       out.println("where : " + query + "<BR>"); 
        
        
        String whereString = query.toString();
        String filename = "tes.html";
        String[] args = {"-query", whereString, "-c",configfile, "-o",filename};
        
        GlobalEnv.setGlobalEnv(args);
        GlobalEnv.setOnlineFlag();

        SSQLparser parser = new SSQLparser("online");
	
		if(GlobalEnv.getErrFlag() == 0)
		{
		    CodeGenerator codegenerator = parser.getcodegenerator();
			
		    if(GlobalEnv.getErrFlag() == 0)
			{
		    	DataConstructor dc = new DataConstructor(parser);
				
		    	if(GlobalEnv.getErrFlag() == 0)
				{
		    		//add chie
		    		String[] headfoot = codegenerator.generateCode4(parser,dc.getData()).toString().split(" ###split### ");
		    		out.println(headfoot[0]);
		    		if(GlobalEnv.getErrFlag() == 0)
		    		{
		    			out.println(codegenerator.generateCode2(parser, dc.getData()));
		    		}
		    		out.println(headfoot[1]);
				}
			}
		    	
        } 
        
	   	if(GlobalEnv.getErrFlag() == 1)
	   	{
	   		out.println("<font color=RED>");
	   		out.println("ERR " + GlobalEnv.getErr());
	   	}
    }
    
  
  }  