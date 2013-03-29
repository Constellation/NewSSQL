package supersql.form;

import java.io.*;
import java.util.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.MessageDigest; 


import javax.servlet.*;
import javax.servlet.http.*;

import supersql.common.GlobalEnv;
import supersql.common.Log;

public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 8021503235844232672L;

	static String att_sets[][];

	public void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
	throws ServletException, IOException {

		//os
		String enc = "EUC-JP";
		
		if(System.getProperty("os.name").indexOf("Windows")>=0){
			enc =  "Shift_JIS";
		}
		// ContentType‚ðÝ’è
		res.setContentType("text/html; charset="+enc);
		req.setCharacterEncoding(enc);

		// o—Í—pPrintWriter‚ðŽæ“¾
		PrintWriter out = res.getWriter();
	
		this.errflg = false;

		String sqlfile = new String();
		/* comment out   chie
    try{
    	sqlfile = req.getParameter("sqlfile");
    }catch(NullPointerException e){
    	out.println("no ssql file \n");
    	System.exit(-1);
    }
		 */
		if(req.getParameter("sqlfile") != null)
			sqlfile = req.getParameter("sqlfile");
		if(req.getParameter("linkfile") != null)
			sqlfile = req.getParameter("linkfile");

		int i = 1;
		int flag = 0;

		String cond_name = new String(); 
		String cond = new String();
		String value = new String();
		String value_type = new String();
		String where = new String();

		String configfile = new String(); 
		String updatefile = new String(); 
		String linkcond = new String(); 

		try{
			configfile = req.getParameter("configfile");
		}catch(NullPointerException e)
		{
			out.println("no config file defined /n");
		}

		if(req.getParameter("updatefile") != null){
			updatefile = req.getParameter("updatefile");
			Log.out("updatefile : " + updatefile);
		}


		/*
    	try{
    		host = req.getParameter("host");
    	}catch(NullPointerException e){
    		out.println("no host defined \n");
    		System.exit(-1);
    	}

    	try{
    		user = req.getParameter("user");
    	}catch(NullPointerException e){
    		out.println("no user defined \n");
    		System.exit(-1);
    	}
    	try{
    		dbname = req.getParameter("dbname");
    	}catch(NullPointerException e){
    		out.println("no dbname id defined");
    		System.exit(-1);
    	}
		 */

		while(true)
		{   
			try{
				cond_name = req.getParameter("cond_name"+i);
			}catch(NullPointerException e){
				cond_name = null;
			}
			if(cond_name == null)
				cond_name = "";

			if(cond_name.equals("exit") || i >= 1000)
				break;

			try{
				cond = req.getParameter("cond"+i);
			}catch(NullPointerException e){
				cond = null;
			}
			if(cond == null)
				cond = "";

			try{
				value_type = req.getParameter("value_type"+i);
			}catch(NullPointerException e){
				value_type = null;
			}
			if(value_type == null)
				value_type = "int";

			try{
				value = req.getParameter("value"+i);    		
			} catch(NullPointerException e){
				value = null;
			}	
			if(value == null)
				value = "";

			if(value.equals("") || value.equalsIgnoreCase("any"))
			{}
			else
			{
				if(flag != 0 && (value_type.equalsIgnoreCase("Int") || value_type.equalsIgnoreCase("String")))
					where = where + " AND ";
				else if(flag != 0)
					where = where + " OR ";

				where = where + " " + cond_name + " "+ cond+" ";

				Log.info("cond :" + cond);
				if(cond.equalsIgnoreCase("LIKE"))
				{
					where = where + " '%" + value + "%' ";
					System.out.println(" cond is LIKE");
				}
				else if(value_type.equalsIgnoreCase("String") || value_type.equalsIgnoreCase("ORString") ){
					where = where + " '" + value + "' " ;
				}
				else {
					where = where + value;
				}
				flag = 1;
			}
			++i;
		}


		//added by chie update
		String stmp[] = {"-f",sqlfile,"-o",sqlfile,"-c",configfile,"-debug"};
		GlobalEnv.setGlobalEnv(stmp);
		host = GlobalEnv.gethost();
		db = GlobalEnv.getdbname();
		user = GlobalEnv.getusername();
		dbms = GlobalEnv.getdbms();
		driver = GlobalEnv.getDriver();
		FormEnv.getFormEnv();

		if(updatefile != null && !updatefile.isEmpty()){
			if(updatefile.startsWith("./")){
				updatefile = GlobalEnv.getFileDirectory()+updatefile.substring(2,updatefile.length());
			}if(updatefile.toLowerCase().startsWith("http://")){
			}else{
				updatefile = GlobalEnv.getFileDirectory()+updatefile;
			}
			if(updatefile.endsWith(")"))
				update2(updatefile,req);
			else
				update(updatefile,req);
		}

		if(sqlfile.startsWith("./")){
			sqlfile = GlobalEnv.getFileDirectory()+sqlfile.substring(2,sqlfile.length());
		}

		if(sqlfile != null && !sqlfile.isEmpty()){
			sqlfile = GlobalEnv.getInvokeServletPath() + "?query=" + sqlfile;
			if(req.getParameter("linkcond") != null){
				linkcond = req.getParameter("linkcond");
				for(int j = 1; j < att_sets.length+1; j++){
					Log.info("ss:"+j);
					if(att_sets[j-1][0] != null && linkcond.contains("$"+att_sets[j-1][0])){
						linkcond = linkcond.replace("$"+att_sets[j-1][0], att_sets[j-1][1]);
					}
				}
				where += linkcond;
				Log.info("WHERE:"+where);
			}

			if(where != null && !where.isEmpty()){
				sqlfile += "&where="+ URLEncoder.encode(where,enc) +"";
			}
			
			if(configfile != null && !configfile.isEmpty()){
				sqlfile += "&config="+ configfile +"";
			}
			
			if(errflg == true){
				sqlfile += "&message="+ URLEncoder.encode(errmessage,enc) +"";
			}
			
			
			Log.info(sqlfile);
			res.sendRedirect(sqlfile);
			/*
			String query = errMessage(sqlfile);

			if(query.contains("session(")){
				InvokeServlet2 invoke = new InvokeServlet2();
				query = invoke.getSession(sqlfile,req,query,this);
			}

			if(req.getParameter("linkcond") != null){
				linkcond = req.getParameter("linkcond");
				for(int j = 1; j < att_sets.length+1; j++){
					Log.info("ss:"+j);
					if(att_sets[j-1][0] != null && linkcond.contains("$"+att_sets[j-1][0])){
						linkcond = linkcond.replace("$"+att_sets[j-1][0], att_sets[j-1][1]);
					}
				}
				where += linkcond;
				Log.info("WHERE:"+where);
			}
			if(this.errflg == true){
				if(where == null || where.trim().isEmpty()){
					where = "false";
				}else{
					where += " AND false";
				}
			}

			//String[] args = {"-f",sqlfile,"-cond",where,"-debug","-h",host,"-u",user,"-db",dbname};
			//String[] args = {"-f",sqlfile,"-cond",where,"-c",configfile};
			//String[] args = {"-f",sqlfile,"-cond",where,"-debug","-c",configfile};
			
			String[] args;
			if(where.isEmpty()){
				String[] s = {"-query",query,"-o",sqlfile,"-c",configfile,"-debug"};
				args = s;
			}else{
				String[] s = {"-query",query,"-o",sqlfile,"-cond",where,"-c",configfile,"-debug"};
				args = s;
			}

			GlobalEnv.setGlobalEnv(args);


			SSQLparser parser = new SSQLparser("online");


			CodeGenerator codegenerator = parser.getcodegenerator();

			DataConstructor dc = new DataConstructor(parser);




			//add chie
			if (GlobalEnv.getErrFlag() == 0){
				String[] headfoot = codegenerator.generateCode4(parser,dc.getData()).toString().split(" ###split### ");
				out.println(headfoot[0]);			
				out.println(codegenerator.generateCode2(parser, dc.getData()));
				if (headfoot.length > 1){
					out.println(headfoot[1]);
				}
			}else if(dc.getData().size() == 0){
				out.println("NO DATA FOUND");
			}

			if (GlobalEnv.getErrFlag() == 0){
				Log.info("// completed normally //");
			}else{
				out.println(GlobalEnv.getErr());
			}
			*/
		}else{
			sqlfile = req.getHeader("referer");
			Log.info(sqlfile);
			res.sendRedirect(sqlfile);
		}

	} 
	public void update(String filename,HttpServletRequest req) {
		Enumeration<String> e = req.getParameterNames();
		int max=0;
		while(e.hasMoreElements()){
			e.nextElement();
			max++;
		}
		Log.out(max);
		String[][] att = new String[max][2]; 
		String exchangeName = new String();
		if(req.getParameter("exchangeName") != null){
			exchangeName = req.getParameter("exchangeName");
		}

		for(int i=1;i < max; i++){
			String tmp1 = ":t"+ i +":";
			if(exchangeName.contains(tmp1)){
				//(usrname,value),(usrname2,value),...
				int index = exchangeName.lastIndexOf(tmp1) + (tmp1).length();
				String tmp2 = exchangeName.substring(index,exchangeName.indexOf(":",index));
				att[i-1][0] = tmp2;
				if(req.getParameter(tmp2) != null){
					if(req.getParameter(tmp2 + ":pwd") != null && req.getParameter(tmp2 + ":pwd").equals("md5")){
						String s = req.getParameter(tmp2);
						try{
							MessageDigest md = MessageDigest.getInstance("MD5");  
							md.update(s.getBytes());   
							byte[] hash = md.digest();   	
							StringBuffer hexString = new StringBuffer();   
							for (int j = 0; j < hash.length; j++) {   
								if ((0xff & hash[j]) < 0x10) {   
									hexString.append("0" + Integer.toHexString((0xFF & hash[j])));   
								} else {   
									hexString.append(Integer.toHexString(0xFF & hash[j]));   
								}   
							}  
							att[i-1][1] = hexString.toString();				    
						}catch(Exception mde){
							//error
						}
					}else{
						//att[i-1][1] = req.getParameter(tmp2);
						String[] values = req.getParameterValues(tmp2);
						if(values.length > 1){
							for(int j = 0;i < max && j < values.length;j++){
								if(values[j] != null){
									att[i-1][0] = tmp2+"["+j+"]";
									att[i-1][1] = values[j];
								}else{
									att[i-1][0] = tmp2+"["+j+"]";
									att[i-1][1] = "";
								}
								i++;
							}
						}else{
							att[i-1][1] = req.getParameter(tmp2);
						}
					}
				}
				else
					att[i-1][1] = "";

			}else{
				//(t1,value),(t2,value),...
				att[i-1][0] = "t"+i;
				att[i-1][1] = req.getParameter("t"+i);
			}
			Log.info("att is : " + att[i-1][0]+" " + att[i-1][1]);
			att_sets = new String[att.length][2];
			att_sets = att.clone();
		}
		checkAtt(att,req);
		if(errflg == false){
			updateDatabaseMain(filename,att,req);
		}else{
			Log.out("InputError");
		}
	}
	public void update2(String filename,HttpServletRequest req){
		//String att = new String()
		String[] att_f;
		//separate filename
		if(filename.indexOf("(") > 0){
			String attributes = filename.substring(filename.indexOf("(")+1,filename.indexOf(")"));
			att_f = attributes.split(",");
			filename = filename.substring(0,filename.indexOf("("));
		}else{
			att_f = null;
		}

		String[][] att = new String[att_f.length][2];
		for(int i = 0; i < att_f.length ; i++){
			att[i][0] = "att"+(i+1);
			att[i][1] = att_f[i];
			Log.info("att is : " + att[i][0]+" " + att[i][1]);
		}

		att_sets = new String[att.length][2];
		att_sets = att.clone();

		for(int i = 0; i < att_f.length ; i++){
			att[i][0] = "att"+(i+1);
			att[i][1] = att_f[i];
			Log.info("att is : " + att[i][0]+" " + att[i][1]);
		}

		updateDatabaseMain(filename,att,req);
	}



	static String host;
	static String db;
	static String user;
	static String dbms;
	static String driver;

	private void updateDatabaseMain(String filename,String[][] att,HttpServletRequest req){
		//update database
		try {
			StringBuffer tmp = new StringBuffer();
			String sql = new String();

			Log.info("updatefile is : " + filename);
			if(filename.startsWith("http:")){
				BufferedReader in;
				URL fileurl = new URL(filename);
				URLConnection fileurlConnection = fileurl.openConnection();
				in = new BufferedReader(new InputStreamReader(fileurlConnection.getInputStream()));
				while (true) {
					String line = in.readLine();
					if ( line == null || line.equals("-1"))
						break;
					tmp.append(" " + line);
				}
			}

			sql = tmp.toString();
			

			//replace session
			if(sql.contains("session(")){
				HttpSession se = req.getSession(false);
				if(se != null){
					while(sql.contains("session(")){
						int f = sql.indexOf("session(");
						int f2 = sql.indexOf("session(") + "session(".length();
						int e = sql.indexOf(")",f);
						int e2 = sql.indexOf(")",f) + ")".length();
						String sessionKey = sql.substring(f2,e);
						String sval = (String)se.getAttribute(sessionKey);
						if( sval != null && !sval.isEmpty()){
							sql = sql.substring(0, f) + sval + sql.substring(e2);
						}else{
							errflg = true;
							errmessage += FormEnv.getLogin();
							break;
						}
					}
				}else{
					errflg = true;
					errmessage += FormEnv.getLogin();
				}
			}
			
			//replace att
			if(att != null){
				for(int i = 1; i < att.length+1; i++){
					if(att[i-1][0] != null && sql.contains("$"+att[i-1][0])){
						sql = sql.replace("$"+att[i-1][0], att[i-1][1]);
					}
				}
				if(sql.contains("now()")){
					Date d = new Date();
					sql = sql.replace("now()", d.toString());
				}
				Log.info("sql is : " + sql);
			}

			Log.info("jdbc:"+dbms+"://" + host + "/" + db +user + driver);

			// connect db
			Class.forName(driver);
			Connection con =
				DriverManager.getConnection("jdbc:"+dbms+"://" + host + "/" + db,
						user,driver);
			// create object
			Statement stmt = con.createStatement();

			// execute
			if(!errflg){
				stmt.executeQuery(sql);
				Log.info("UPDATE");
			}
			return;
		} catch (FileNotFoundException e) {
			System.err.println("UpdateFileIsNotFound:"+filename);
		} catch (NullPointerException e) {
			System.err.println(e);
		} catch (SQLException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public boolean errflg;
	public String errmessage = "";

	public void checkAtt(String[][] att,HttpServletRequest req){
		this.errflg = false;
		this.errmessage = "";
		for(int i=0;i < att.length;i++){
			if(att[i][0] != null){
				if( req.getParameter(att[i][0]+":const") != null){
					String[] constraint = req.getParameter(att[i][0]+":const").split(",");
					for(int j=0;j < constraint.length;j++){
						if(constraint[j].equals("notnull")){
							if(att[i][1] == null  || att[i][1].isEmpty()){
								this.errflg = true;
								this.errmessage += att[i][0] + " " + FormEnv.getNull() + " ";
								Log.out(att[i][0] + " is null ");
							}
						}
						if(constraint[j].equals("number")){
							if ( !att[i][1].isEmpty() && !att[i][1].matches("[0-9]+")){
								this.errflg = true;
								this.errmessage += att[i][0] + " " + FormEnv.getNumber() + " ";
								Log.out(att[i][0] + " is not number");
							}
						}
						if(constraint[j].equals("english")){
							if(att[i][1] != null && !att[i][1].matches("[a-zA-Z]+")){
								this.errflg = true;
								this.errmessage += att[i][0] + " " + FormEnv.getEnglish() + " ";
								Log.out(att[i][0] + " is not english.");
							}
						}
						if(constraint[j].equals("numeng")){
							if(att[i][1] != null && !att[i][1].matches("[a-zA-Z0-9]+")){
								this.errflg = true;
								this.errmessage += att[i][0] + " " + FormEnv.getNumEng() + " ";
								Log.out(att[i][0] + " is not english or number.");
							}
						}
						if(constraint[j].equals("unique")){
						}
					}
				}
			}
		}
	}

	public String errMessage(String filename){
		BufferedReader in;
		String tmp= new String();
		try {
			if(filename.startsWith("http:")){
				URL fileurl = new URL(filename);
				URLConnection fileurlConnection = fileurl.openConnection();
				in = new BufferedReader(new InputStreamReader(fileurlConnection.getInputStream(),"EUC-JP"));
				while(true){
					String line = in.readLine();
					if (line == null){
						break;
					}
					//for comment statement
					if(line.startsWith("//"))
						line = in.readLine();
					if(line.contains("/*"))
					{
						int s = line.indexOf("/*");

						Log.out(line);
						String line1 = line.substring(0,s);
						tmp += " "+line1;
						Log.out(line1);
						while(!line.contains("*/"))
							line = in.readLine();
						int t = line.indexOf("*/");
						line = line.substring(t+2);
					}
					tmp += " " + line.trim();
				}
			}else{
				in = new BufferedReader(new FileReader(filename));
			}
		}catch(Exception e){}

		//Log.info(tmp);

		if(tmp.contains("errmessage()")){
			if( errmessage == null ||errmessage.isEmpty()){
				tmp = tmp.replace("errmessage()","null(\"\")");
			}else{
				tmp = tmp.replace("errmessage()", "\"" + errmessage +"\"@{color=red}");
			}
		}
		while(tmp.contains("errmessage(\"")){
			int f = tmp.toLowerCase().indexOf("errmessage(\"");
			int f2 = tmp.toLowerCase().indexOf("errmessage(\"") + "errmessage(\"".length();
			int e = tmp.toLowerCase().indexOf("\")",f2);
			int e2 = tmp.toLowerCase().indexOf("\")",f2) + "\")".length();
			String message = tmp.substring(f2,e);
			if(errflg == true){
				if(errmessage == null || errmessage.isEmpty())
					tmp = tmp.substring(0,f) +"\"" + message + "\"" + tmp.substring(e2);
				else
					tmp = tmp.substring(0,f) +"\"" + message + "\"+\"" + errmessage + "\"" + tmp.substring(e2);
			}else{
				tmp = tmp.substring(0,f) + "null(\"\")" + tmp.substring(e2);
			}
		}
		return tmp;

	}
	public String errMessage2(String tmp){
		if(tmp.contains("errmessage()")){
			if(errmessage.isEmpty() || errmessage == null){
				tmp = tmp.replace("errmessage()","null(\"\")");
			}else{
				tmp = tmp.replace("errmessage()", "\"" + errmessage +"\"@{color=red}");
			}
		}
		while(tmp.contains("errmessage(\"")){
			int f = tmp.toLowerCase().indexOf("errmessage(\"");
			int f2 = tmp.toLowerCase().indexOf("errmessage(\"") + "errmessage(\"".length();
			int e = tmp.toLowerCase().indexOf("\")",f2);
			int e2 = tmp.toLowerCase().indexOf("\")",f2) + "\")".length();
			String message = tmp.substring(f2,e);
			if(errflg == true){
				if(errmessage == null || errmessage.isEmpty())
					tmp = tmp.substring(0,f) +"\"" + message + "\"" + tmp.substring(e2);
				else
					tmp = tmp.substring(0,f) +"\"" + message + "\"+\"" + errmessage + "\"" + tmp.substring(e2);
			}else{
				tmp = tmp.substring(0,f) + "null(\"\")" + tmp.substring(e2);
			}
		}
		return tmp;

	}


}