package supersql.parser;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.*;
import java.net.*;

import supersql.codegenerator.AttributeItem;
import supersql.codegenerator.CodeGenerator;
import supersql.codegenerator.TFE;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.db.SQLManager;
import supersql.extendclass.ExtList;

public class SSQLparser {

    String media;

    TFEparser tfe_info;

    FromInfo from_info;

    static String from_info_st; //chie

    WhereInfo where_info;

    String order_statement;

    String group_statement;

    String having_statement;

    CodeGenerator cgenerator;

    ForeachInfo foreach_info;

    String QueryImage;

    StringBuffer embed_where = new StringBuffer();

    StringBuffer embed_from = new StringBuffer();

    StringBuffer embed_group = new StringBuffer();

    StringBuffer embed_having = new StringBuffer();

    int table_num = 0;


  //ryuryu(start)/////////////////////////////////////////////////////////////////////////
    public static String XpathQuery;
    public static String[] xpath_query = {""};

    int flag = 0;

    public static int xpath_exist = 0;
    public static int xpath_start = 0;

    public static int num_xpath = 0;

    public static String tmp_xpath1 = new String();
    public static String XPATH = new String();
    public static String tmp_xmlquery1 = new String();
    public static String DB2_XQUERY = new String();
    public static String tmp_xmlquery2 = new String();

    public static int xmltext_flag = 0;
    public static String XMLQuery = new String();

    public static String xpath_tag = new String();
    public static int xpath_tag_exist = 0;
    //ryuryu(end)/////////////////////////////////////////////////////////////////////////


    /*
     * MakeSeparatedSQL sqls; MakeSeparatedSQL_order sqls_o;
     */

    /**
     * This is Constructor
     */
    //tk start//////////////////////////////////////
    public SSQLparser(int id) {

        parseSSQL(this.getSSQLQuery(),id);
    }

    public SSQLparser(String a)
    {
    	parseSSQL(this.getSSQLQuery2(),10000);
    }

    public SSQLparser()
    {
    	parseSSQL(this.getSSQLQuery(),10000);
    }
    public SSQLparser(StringBuffer querybuffer) {

        parseSSQL(querybuffer.toString(),10000);

    }
    // tk end////////////////////////////////////////
    private void parseSSQL(String QueryString,int id) {
        //  replace '*' to attributes   added by chie
        if(QueryString.contains("*")){
        	QueryString = replaceQuery(QueryString);
        }
        //'*' end

        QueryImage = QueryString;

        //StringTokenizer st = new StringTokenizer(QueryString);
        StringTokenizer st0 = new StringTokenizer(QueryString);
        st0.nextToken();

        //ryuryu(start)/////////////////////////////////////////////////////////////
        if(st0.nextToken().toString().toUpperCase().equals("XML")){
	        if(QueryString.contains("]")){
	        	QueryString = QueryString.replace("]","],");
	        }
        }
        //ryuryu(end)///////////////////////////////////////////////////////////////


        //ryuryu CSV
        else if(st0.nextToken().toString().toUpperCase().equals("CSV")){

	        if(QueryString.contains("]")){

	        	QueryString = QueryString.replace("]","],");
	        }

        }
       //ryuryu(end)//////////////////////////////////////////

        //  replace '*' to attributes   added by chie
        if(QueryString.contains("*")){
        	QueryString = replaceQuery(QueryString);
        }
        //'*' end

        StringTokenizer st = new StringTokenizer(QueryString);

        try {
            if (!st.hasMoreTokens()) {
                System.err.println("*** No Query Specified ***");
                throw (new IllegalStateException());
            }

            String nt = st.nextToken().toString();
            int state = 0;
            where_info = new WhereInfo();
            //	this.attribute = new Hashtable();
            Log.out("[Paser:Parser] start parse");

            // FOREACH
            boolean foreach_flag = false;
            String foreach_from = new String();
            String foreach_where = new String();
            if (nt.equalsIgnoreCase("FOREACH")) {
                foreach_flag = true;
                StringBuffer foreach_c = new StringBuffer();
                while (st.hasMoreTokens()) {
                    nt = st.nextToken().toString();
                    if (nt.equalsIgnoreCase("GENERATE"))
                        break;
                    foreach_c.append(nt + " ");
                }
                Log.out("");
                Log.out("*** This query contains FOREACH clause ***");
                Log.out(" foreach_c :" + foreach_c);

                foreach_info = new ForeachInfo(foreach_c.toString().trim());
                Log.out("[Parser:Foreach] foreach = " + foreach_info);
            }
            GlobalEnv.foreach_flag = foreach_flag;
            if (foreach_flag) {
                foreach_from = foreach_info.getForeachFrom();
                foreach_where = foreach_info.getForeachWhere();
            }

            //REQUEST SESSION
            if (nt.equalsIgnoreCase("REQUEST")) {
                while (st.hasMoreTokens()) {
                    nt = st.nextToken().toString();
                    if (nt.equalsIgnoreCase("GENERATE"))
                        break;
                }
            }

            // GENERATE medium
            if (!nt.equalsIgnoreCase("GENERATE")) {
            	System.err.println("*** Not Start in GENERATE ***");
                throw (new IllegalStateException());
            }

            if (!st.hasMoreTokens()) {
                System.err.println("*** No medium/tfe Specified ***");
                throw (new IllegalStateException());
            }

            media = st.nextToken().toString();

            //tk modified//////////////////////////////
            //for embed css TFE_ID
            cgenerator = new CodeGenerator(id);

            cgenerator.setFactory(media.toUpperCase());
            Log.out("");
            Log.out("*********** Specified Media is ************");
            Log.out(media);
            cgenerator.initiate();

            // TFE
            StringBuffer tfe = new StringBuffer();
            // FOREACH
            if (foreach_flag) {
                tfe.append("[foreach(" + foreach_info.getForeachAtt() + ")?");
            }



            while (st.hasMoreTokens()) {
                nt = st.nextToken().toString();
                if (nt.equalsIgnoreCase("FROM"))
                    break;

                Log.out("nt : " + nt );

                //ryuryu(start)////////////////////////////////////////////////////////////////////////
                if(nt.toUpperCase().contains("XMLDATA(")){
                	if(nt.contains(")")){
                		String temp_nt = new String();

                		temp_nt = (nt.toUpperCase().replace("XMLDATA(", "")).toLowerCase();

                		if(temp_nt.contains("))")){
                			nt = temp_nt.replace("))", ")");
                		}
                		else{
                			nt = temp_nt.replace(")", "");
                		}

	                	Log.out("nt : " + nt);
	                	tfe.append(nt + " ");
	                	xpath_exist = 1;
                	}
                }


                else if((nt.toUpperCase().contains("SSQL::XPATH(")) || (nt.toUpperCase().contains("XPATH(")))
                {
                	if(nt.toUpperCase().contains("SSQL::XPATH(")){
                		if(nt.toUpperCase().contains("XPATH(")){
                			XpathQuery = nt.toUpperCase().replace("SSQL::XPATH(", "");
                		}
                		else if(nt.toUpperCase().contains("SSQL::XPATH(")){
                			XpathQuery = nt.toUpperCase().replace("SSQL::XPATH(", "");
                		}
                	}

                	else if(nt.toUpperCase().contains("XPATH(")){
                		if(nt.toUpperCase().contains("XPATH(")){
                			XpathQuery = nt.toUpperCase().replace("XPATH(", "");
                		}
                		else if(nt.contains("XPATH(")){
                			XpathQuery = nt.toString().replace("XPATH(", "");
                		}
                	}

                	String tmp_xpath2 = new String();

                	String orig_xpath = new String();
                	String orig2_xpath = new String();

                	Log.out("xpath after nt (before) : " + nt);

                	if(nt.contains(")")){

                		orig_xpath= nt.substring(0,nt.indexOf(",")+1);

                		if(nt.toString().contains("@{")){
                			tmp_xpath1 = nt.substring(nt.toUpperCase().indexOf("XPATH(") + 6, nt.indexOf("@"));
                			if(nt.toString().contains("@{tag=")){
                				xpath_tag = nt.substring(nt.indexOf("@{tag=") + 6, nt.indexOf("}"));
                			}
                			else{ //@{tag}
                				xpath_tag = tmp_xpath1.substring(tmp_xpath1.indexOf(".") + 1, tmp_xpath1.length());
                			}

                			xpath_tag_exist = 1;
                		}
                		else{
                			tmp_xpath1 = nt.substring(nt.toUpperCase().indexOf("XPATH(") + 6, nt.indexOf(","));
                		}


                		orig2_xpath = nt.substring(nt.indexOf(",")+1, nt.length());

                		tmp_xpath2 = nt.substring(nt.indexOf("path=") + 6, nt.indexOf("\")"));


                		if(tmp_xpath2.contains("text()")){ //XPath
                			xmltext_flag = 1;
                		}

                		else if(tmp_xpath2.contains("node()")){ //XPath
                			xmltext_flag = 1;
                		}

                		if(nt.contains("),")){
                			nt = "xpath(\"" + tmp_xpath2 + "\"," + tmp_xpath1 + "),";
                		}

                		else{
                			nt = "xpath(\"" + tmp_xpath2 + "\"," + tmp_xpath1 + ")";
                		}

                		XPATH = nt;
                		Log.out("xpath after nt (after) : " + nt);
                	}

                	tfe.append(nt + " ");
                	Log.out("XPATH tfe : " + tfe);
	                xpath_exist = 1;
                }


                else if((nt.toUpperCase().contains("SSQL::XMLQUERY(")) || (nt.toUpperCase().contains("XMLQUERY(")))
                {
                	if(nt.toUpperCase().contains("SSQL::XMLQUERY(")){
                		if(nt.toUpperCase().contains("XMLQUERY(")){
                			XpathQuery = nt.toUpperCase().replace("SSQL::XMLQUERY(", "");
                		}
                		else if(nt.toUpperCase().contains("SSQL::XMLQUERY(")){
                			XpathQuery = nt.toUpperCase().replace("SSQL::XMLQUERY(", "");
                		}
                	}

                	else if(nt.toUpperCase().contains("XMLQUERY(")){
                		if(nt.toUpperCase().contains("XMLQUERY(")){
                			XpathQuery = nt.toUpperCase().replace("XMLQUERY(", "");
                		}
                		else if(nt.contains("XMLQUERY(")){
                			XpathQuery = nt.toString().replace("XMLQUERY(", "");
                		}
                	}

                	String orig_xmlquery = new String();
                	String orig2_xmlquery = new String();

                	Log.out("xmlquery after nt (before) : " + nt);

                	if(nt.contains(")")){
                		orig_xmlquery= nt.substring(0,nt.indexOf(",")+1);

                		if(nt.toString().contains("@{")){
                			tmp_xmlquery1 = nt.substring(nt.toUpperCase().indexOf("XMLQUERY(") + 9, nt.indexOf("@"));
                			if(nt.toString().contains("@{tag=")){
                				xpath_tag = nt.substring(nt.indexOf("@{tag=") + 6, nt.indexOf("}"));
                			}
                			else{ //@{tag}
                				xpath_tag = tmp_xmlquery1.substring(tmp_xmlquery1.indexOf(".") + 1, tmp_xmlquery1.length());
                			}

                			xpath_tag_exist = 1;
                		}

                		else{
                			tmp_xmlquery1 = nt.substring(nt.toUpperCase().indexOf("XMLQUERY(") + 9, nt.indexOf(","));
                		}


                		orig2_xmlquery = nt.substring(nt.indexOf(",")+1, nt.length());

                		tmp_xmlquery2 = nt.substring(nt.indexOf("path=") + 6, nt.indexOf("\")"));


                		if(tmp_xmlquery2.contains("text()")){ //XMLQuery
                			xmltext_flag = 1;
                		}

                		else if(tmp_xmlquery2.contains("node()")){ //XMLQuery
                			xmltext_flag = 1;
                		}


                		if(nt.contains("),")){
                			nt = "xmlquery(\"$a" + tmp_xmlquery2 + "\"" + "," + tmp_xmlquery1 + "),";
                		}

                		else if(nt.contains(")")){
                			nt = "xmlquery(\"$a" + tmp_xmlquery2 + "\"" + "," + tmp_xmlquery1 + ")";
                		}

                		DB2_XQUERY  = nt;
                		Log.out("xmlquery after nt (after) : " + nt);
                	}

                	tfe.append(nt + " ");
                	Log.out("XMLQUERY tfe : " + tfe);

	                xpath_exist = 1;
                }

                //ryuryu(end)////////////////////////////////////////////////////////////////////////


                // tk /////////////////////////////////////////////////////////////
                //if(nt.contains("sinvoke("))
                else if(nt.contains("sinvoke("))
                {
                	String tmp = new String();
                	String orig = new String();
                	String orig2 = new String();
                	Log.out("sinvoke nt:"+nt);
                	if(nt.contains(")"))
                	{
                		orig= nt.substring(0,nt.indexOf(")"));
                		Log.out("hogehoge"+orig);
                		orig2 = nt.substring(nt.indexOf(")"),nt.length());
                		Log.out("hoge"+orig2);
                		tmp = nt.substring(nt.indexOf("att=")+4,nt.indexOf(")"));

                		Log.out("sinvoke parser tmp:"+tmp);
                		Log.out("sinvoke parser orig:"+orig);
                		Log.out("sinvoke parser orig2:"+orig2);

                		String cond = new String();
                		cond = "ajaxcond=\""+tmp+"\"";
                		if(GlobalEnv.isAjax())
                			nt = orig+" ," + cond + " " + orig2;
                		else
                			nt = orig+orig2;

                		Log.out("sinvoke after nt:"+nt);
                	}
                	tfe.append(nt+" ");
                	Log.out("sinvoke tfe:"+tfe);
                }
                else if(nt.contains("embed("))
                {
                	StringBuffer tmp = new StringBuffer();
                	String deco = new String();

                	if(nt.contains(")"))
                	{
                		deco = nt.substring(nt.indexOf(")")+1, nt.length());
                		nt = nt.substring(0,nt.indexOf(")")+1);
                	}

                    tmp.append(nt + " ");

                    Log.out("tmp:"+tmp);
                    while(!nt.contains(")"))
                	{
                		nt = st.nextToken().toString();

                		Log.out("embed parser : " + nt);

                		if(nt.contains("@"))
                		{
                			deco = nt.substring(nt.indexOf("@"),nt.length());
                			nt = nt.substring(0,nt.indexOf("@"));
                			Log.out("deco:"+deco);
                		}
                		//Log.out("nt tt : " + nt);
                		tmp.append(nt + " ");
                	}

                	tfe.append("{ " +  embed( tmp.toString() ) );

                	tfe.append("}" + deco);
                	Log.out("append embed tfe : " + tfe);

                }
                // tk ////////////////////////////////////////////////////////////
                else
                {
                	tfe.append(nt + " ");
                }

            }

            // FOREACH
            if (foreach_flag) {
                tfe.append("]%");
            }
            
            //changed by goto 20130122  For "slideshow"
            //System.out.println("[Paeser:tfe] tfe = " + tfe);
            if(!tfe.toString().contains("type=\"slideshow\""))
            	System.out.println("[Paeser:tfe] tfe = " + tfe);




            //hanki start
            Preprocessor preprocessor = new Preprocessor(tfe.toString());
            tfe = preprocessor.pushAggregate();
            tfe = preprocessor.pushOrderBy();
            Log.out("[Parser:tfe] converted_tfe = " + tfe);
        	//hanki end


            tfe_info = new TFEparser(tfe.toString(), cgenerator);
            tfe_info.debugout();


            // FROM
            StringBuffer from_c = new StringBuffer();

            while (st.hasMoreTokens()) {
                nt = st.nextToken().toString();
                if (nt.equalsIgnoreCase("WHERE")) {
                    state = 1;
                    break;
                }
                if (nt.equalsIgnoreCase("ORDER")) {
                    state = 2;
                    break;
                }
                if (nt.equalsIgnoreCase("GROUP")) {
                    state = 3;
                    break;
                }
                if (nt.equalsIgnoreCase("HAVING")) {
                    state = 4;
                    break;
                }
                from_c.append(nt + " ");

            }
            //tk/////////////////////////////////////

            if(embed_from.length() != 0)
            {
            	if(from_c.toString().length() != 0)
            		from_c.append(",");
            	from_c.append(embed_from + " ");
            }

            Log.out("FROM : "+ from_c);



            // FOREACH
            if (!(foreach_from.equals(""))) {
                from_c.append("," + foreach_from);
            }

            from_info = new FromInfo(from_c.toString().trim());
            Log.out("[Paeser:From] from = " + from_info);
            if (!(foreach_from.equals(""))) {
                Log.out(foreach_from
                        + ": Used in FOREACH clause and added to FROM clause ");
            }

            // WHERE
            where_info = new WhereInfo();

            if (state == 1) {
                StringBuffer where_c = new StringBuffer();
                while (st.hasMoreTokens()) {
                    nt = st.nextToken().toString();
                    if (nt.equalsIgnoreCase("ORDER")) {
                        state = 2;
                        break;
                    }
                    if (nt.equalsIgnoreCase("GROUP")) {
                        state = 3;
                        break;
                    }
                    if (nt.equalsIgnoreCase("HAVING")) {
                        state = 4;
                        break;
                    }
                    where_c.append(nt + " ");
                }

                where_info.appendWhere(where_c.toString().trim());

            }

            //tk////////////////////////////
            if(embed_where.length() !=  0)
            	where_info.appendWhere(embed_where+ " ");

            Log.out("WHERE:"+where_info);
            // FOREACH
            if (!(foreach_where.equals(""))) {
                where_info.appendWhere(foreach_where);
                Log.out(foreach_where
                                + ": Used in FOREACH clause and added to WHERE clause ");
            }

            String addCondition = GlobalEnv.getCondition();
            if (addCondition != null) {
                where_info.appendWhere(addCondition);
            }
            Log.out("[Paeser:Where] where = " + where_info);

            // ORDER
            if (state == 2) {
                if (st.hasMoreTokens()
                        && st.nextToken().toString().equalsIgnoreCase("BY")) {
                    StringBuffer order_c = new StringBuffer();
                    while (st.hasMoreTokens()) {
                        nt = st.nextToken().toString();
                        if (nt.equalsIgnoreCase("GROUP")) {
                            state = 3;
                            break;
                        }
                        if (nt.equalsIgnoreCase("HAVING")) {
                            state = 4;
                            break;
                        }
                        order_c.append(nt + " ");
                    }
                    order_statement = order_c.toString();
                    Log.out("[Paeser:Order] order = " + order_statement);
                } else {
                    System.err.println("*** ERROR in ORDER BY clause ***");
                    throw (new IllegalStateException());
                }
            }

            // GROUP
            StringBuffer group_c = new StringBuffer();
            if (state == 3) {
                if (st.hasMoreTokens()
                        && st.nextToken().toString().equalsIgnoreCase("BY")) {

                    while (st.hasMoreTokens()) {
                        nt = st.nextToken().toString();
                        if (nt.equalsIgnoreCase("HAVING")) {
                            state = 4;
                            break;
                        }
                        group_c.append(nt + " ");
                    }

                                     group_statement = group_c.toString();

                    Log.out("[Paeser:Group] group = " + group_statement);
                } else {
                    System.err.println("*** ERROR in GROUP BY clause ***");
                    throw (new IllegalStateException());
                }

            }
            //tk//////////////////////////////////////////////////////////////////
            group_c.append(embed_group + " ");


            // HAVING
            StringBuffer having_c = new StringBuffer();

            if (state == 4) {
                while (st.hasMoreTokens()) {
                    nt = st.nextToken().toString();
                    having_c.append(nt + " ");
                }


                having_statement = having_c.toString();
                Log.out("[Paeser:Having] having = " + having_statement);
            }

            //tk/////////////////////////////////////////////////
            having_c.append(embed_group + " ");

        } catch (IllegalStateException e) {
            System.err
                    .println("Error[SSQLparser]: Syntax Error in SSQL statement : "
                            + QueryImage);
            //tk////////////////////////////////////////////////////
            GlobalEnv.addErr("Error[SSQLparser]: Syntax Error in SSQL statement : "
                            + QueryImage);
            return ;
//        	System.exit(-1);
            //tk////////////////////////////////////////////////////
        	}

        //tk//////////////////////////////////////////////////////////////////
    }

    //added by chie   replace '*'
    private String replaceQuery(String query){
    	Log.out("START QUERY REPLACE");
    	//tokenizer
    	StringTokenizer fst = new StringTokenizer(query);

    	//tfe from where
        String tfe = new String();
    	String from_string = new String();
    	String where_string = new String();
        String queryResult = new String();

        //separate tfe from where
        while(fst.hasMoreTokens()){
        	String fnt = fst.nextToken();
        	queryResult += fnt + " ";
        	//Log.out("token : " + fnt);
        	if(fnt.equalsIgnoreCase("GENERATE")){
        		fnt = fst.nextToken();//media
        		queryResult += fnt +" ";
        		break;
        	}
        }
        while(fst.hasMoreTokens()){
        	String fnt = fst.nextToken();
        	//Log.out("token : " + fnt);
        	if(fnt.equalsIgnoreCase("FROM")){
        			break;
        	}
        	tfe += fnt;
        }
        while(fst.hasMoreTokens()){
        	String fnt = fst.nextToken();
        	//Log.out("token : " + fnt);
        	if(fnt.equalsIgnoreCase("WHERE")){
        		where_string += fnt;
        		break;
        	}
        	else
        		from_string += " " + fnt;
        }
        while(fst.hasMoreTokens()){
        	String fnt = fst.nextToken();
        	//Log.out("token : " + fnt);
        	where_string += " " + fnt;
        }

        // remove from_string decoration
        StringTokenizer st = new StringTokenizer(from_string, ",");
        String subfrom_string = new String();
		while (st.hasMoreTokens()) {
			String ch = st.nextToken().trim();
			//Log.out("ch : " + ch);
			if(ch.contains("@")){
				ch = ch.substring(0,ch.indexOf("@"));
			}
			subfrom_string += ch + ",";
		}
		subfrom_string = subfrom_string.substring(0,subfrom_string.length()-1);

		//setting of DB
    	String hostname = GlobalEnv.gethost();
        String dbname = GlobalEnv.getdbname();
        String user = GlobalEnv.getusername();
        String driver = GlobalEnv.getDriver();
        String dbms = GlobalEnv.getdbms();
        String url = GlobalEnv.geturl();
        String password = GlobalEnv.getpassword();

        SQLManager SqlM = new SQLManager(url,user,driver, password);

        TFEtokenizer tfetoken = new TFEtokenizer(tfe);
        //TFEtokenizer tt = new TFEtokenizer(tfe);
    	String connector = new String();
    	int repeaterFlg = 0;
    	boolean replaceFlg = false;

    	while(tfetoken.hasMoreTokens()){
    		replaceFlg = false;
        	String fnt = tfetoken.nextToken();
        	//Log.out("tfetoken : " + fnt);
        	if(fnt.contains("*")&& !fnt.contains("\"")){
            	int i = 0;
        		while(tfetoken.hasMoreTokens()){
        			i++;
            		String fnt2 = tfetoken.nextToken();
                	//Log.out("tfetoken* : " + fnt2 + i);
            		if(connector.isEmpty() && fnt2.equals("!") && repeaterFlg == 1){
                		connector = ",";
                	}else if(connector.isEmpty() && fnt2.equals(",") && repeaterFlg == 1){
                		connector = "!";
                	}

            		if(!connector.isEmpty()){
            			//Log.out(subfrom_string);
            			String columnList = SqlM.getAttList(subfrom_string,connector,fnt);
                		fnt = "{" +  columnList +"}";
                		repeaterFlg--;
                		replaceFlg = true;
                		connector = "";
                		break;
            		}

            		if(fnt2.equals("[")){
                		repeaterFlg--;
                	}

            		if(fnt2.equals("]")){
                		repeaterFlg++;
                	}

        		}
        		//back
        		for(;i>0;i--){
        			String tmp = tfetoken.prevToken();
                	//Log.out("tfetoken* : " + tmp);
        		}
        		if(replaceFlg == false){
        			connector = ",";
        			String columnList = SqlM.getAttList(subfrom_string,connector,fnt);
            		fnt = "{" +  columnList +"}";
            		connector = "";
        		}
        	}
        	queryResult += fnt;
        }

    	queryResult += " FROM " + from_string + " " + where_string;

    	Log.out("query : " + queryResult);
    	return queryResult;
    }

    private String getSSQLQuery() {

        String query = GlobalEnv.getQuery();
        if (query != null) {
            query = query.trim();
        }

        String filename = GlobalEnv.getfilename();
        if (filename != null) {

            Log.info("[Paser:Parser] filename = " + filename);
            BufferedReader in;
            StringBuffer tmp = new StringBuffer();
            try {
                in = new BufferedReader(new FileReader(filename));
                String line = null;
                while (true) {
                    line = in.readLine();
                    if (line == null)
                        break;

                    //tk start/////////////////////////////////////
                    //for comment statement
            		//commented out by goto 20130412
//                    if(line.startsWith("//")){
//                    	while(line != null && line.startsWith("//")){
//                    		line = in.readLine();//added by chie
//                    	}
//                    }
                    //changed by goto 20130412
                    if(line!=null && line.contains("/*"))// "if !null" added by chie
                    {
                    	int s = line.indexOf("/*");
                    	String line1 = line.substring(0,s);
//                    	tmp.append(" "+line1);
                    	while(!line.contains("*/"))
                    		line = in.readLine();
                    	int t = line.indexOf("*/");
                    	line = line1+line.substring(t+2);
                    }
                    //added by goto 20130412
                    if(line!=null && line.contains("//")){
                    	boolean dqFlg=false;
                    	int i=0;
                    	
                    	for(i=0; i<line.length(); i++){
                    		if(line.charAt(i)=='"' && !dqFlg)		dqFlg=true;
                    		else if(line.charAt(i)=='"' && dqFlg)	dqFlg=false;
                    		
                    		if(!dqFlg && i<line.length()-1 && (line.charAt(i)=='/' && line.charAt(i+1)=='/'))
                    			break;
                    	}
                    	line = line.substring(0,i);
                    }
                    
                    if(line!=null)//"if !null" added by chie
                    	tmp.append(" " + line);
                }
                in.close();
            } catch (FileNotFoundException e) {
            	System.err.println("Error[SQLparser]: File("+filename+") Is Not Found.");
                GlobalEnv.addErr("Error[SQLparser]: File("+filename+") Is Not Found."+e);
                return "";
            }catch (IOException e) {
                GlobalEnv.addErr("Error[SQLparser]:"+ e);
            }
            query = tmp.toString().trim();
        }else{
        	if(GlobalEnv.getQuery()==""){
	        	try{
	        		if(filename == null || filename.isEmpty()){
	        			throw(new NullPointerException());
	        		}
	        	}
	        	catch (NullPointerException e) {
	        		System.err.println("Error[SQLparser]: File Is Not Specified.");
	        		GlobalEnv.addErr("Error[SQLparser]: File Is Not Specified."+e);
	        		return "";
	        	}
        	}
        }

        if (query.endsWith(";")) {
            query = query.substring(0, query.length() - 1).trim();
        }
        
        Log.info("[Paser:Parser] ssql statement = " + query);
        
        //addde by goto 20130122  For "slideshow"
        if(query.contains("slideshow")){
        	//TODO: 1."sslideshow"等のミスタイプ時のエラー表示、2.正しい正規表現かどうかの判定
        	
	        //置換: replaceAll
	        //<正規表現>
	        //0文字以上の任意の文字列：.*
	        //0個以上の空白：\\s*
	        //( )で囲った部分は、S1,　$2等として、置換後の文字列に使用可能（置換前の全文字列は、$0)
        	
	        //"slideshow [" -> "[imagefile("
	        query = query.replaceAll("slideshow\\s*\\[",
	        		                 "\\[imagefile(");
	        //"[imagefile(*,path="*"*]" -> "[imagefile(*,path="*"*, type="slideshow")"
	        query = query.replaceAll("(\\[imagefile\\(.*,\\spath=\".*\".*)\\]", 
	        		                 "$1, type=\"slideshow\")");

	        if(query.matches(".*\\[imagefile\\(.*\\)\\s*\\@\\s*\\{.*\\}.*")){
		        //@あり
		        //"[imagefile(*) @ {*}" -> "[imagefile(*) @ {*} ]! "
		        query = query.replaceAll("\\[imagefile\\(.*\\)\\s*\\@\\s*\\{[a-zA-Z0-9=\\s,]*\\}",
		        		                 "$0]! ");
	        }else{
		        //@無し
		        //"[imagefile(*) " -> "[imagefile(*)]! "
		        query = query.replaceAll("\\[imagefile\\(.*\\)",		//"(\\[imagefile\\(.*\\)[\\s*|\\s*^\\@])",
		        		                 "$0]! ");
	        }
	        //Log.info("[Paser:Parser] ssql statement2 = " + query);
        }
        
        return query;

    }


    //tk start//////////////////////////////////////////////////////////////////////////////
    //to get SSQL file from Internet
    private String getSSQLQuery2() {

        String query = GlobalEnv.getQuery();
        if (query != null) {
            query = query.trim();
        }

        String filename = GlobalEnv.getfilename();
        if (filename != null) {
            Log.info("[Paser:Parser] filename = " + filename);
            StringBuffer tmp = new StringBuffer();
            String line = new String();
            BufferedReader dis;
                try {

                	if(filename.startsWith("http:"))
                	{
                    URL fileurl = new URL(filename);

                    URLConnection fileurlConnection = fileurl.openConnection();
                    /*DataInputStream dis = new
                    DataInputStream(fileurlConnection.getInputStream());
                    */
                    dis = new BufferedReader(new InputStreamReader(fileurlConnection.getInputStream(),"EUC-JP"));
                	}

                	else
                	{
                        dis = new BufferedReader(new FileReader(filename));
                        line = null;
                	}
                    while (true) {
                        line = dis.readLine();

                    	if (line == null || line.equals("-1"))
                            break;

                        //tk start/////////////////////////////////////
                    	//commented out by goto 20130412
//                        if(line.startsWith("//")){
//                        	while(line!=null && line.startsWith("//")){
//                        		line = dis.readLine();//added by chie
//                        	}
//                        }
//                        if(line!=null && line.startsWith("/*"))
//                        {
//                        	while(!line.contains("*/"))
//                        		line = dis.readLine();
//                        	int t = line.indexOf("*/");
//                        	line = line.substring(t+2);
////                        	line = in.readLine();
//                        }
                        //changed by goto 20130412
                        if(line!=null && line.contains("/*"))
                        {
                        	int s = line.indexOf("/*");
                        	String line1 = line.substring(0,s);
//                        	tmp.append(" "+line1);
                        	while(!line.contains("*/"))
                        		line = dis.readLine();
                        	int t = line.indexOf("*/");
                        	line = line1+line.substring(t+2);
                        }
                        //added by goto 20130412
                        if(line!=null && line.contains("//")){
                        	boolean dqFlg=false;
                        	int i=0;
                        	
                        	for(i=0; i<line.length(); i++){
                        		if(line.charAt(i)=='"' && !dqFlg)		dqFlg=true;
                        		else if(line.charAt(i)=='"' && dqFlg)	dqFlg=false;
                        		
                        		if(!dqFlg && i<line.length()-1 && (line.charAt(i)=='/' && line.charAt(i+1)=='/'))
                        			break;
                        	}
                        	line = line.substring(0,i);
                        }

                        if(line!=null)
                        	tmp.append(" " + line);
                    }
                    /*
                 	while ((line = dis.readLine()) != null) {
                    tmp.append(" " + line);

                 	}
*/        dis.close();

                } catch (MalformedURLException me) {
                    System.out.println("MalformedURLException: " + me);
                } catch (IOException ioe) {
                    System.out.println("IOException: " + ioe);
                    GlobalEnv.addErr("Error[SQLparser]:"+ ioe);
                }


            query = tmp.toString().trim();
        }

        if (query.endsWith(";")) {
            query = query.substring(0, query.length() - 1).trim();
        }

        Log.info("[Paser:Parser] ssql statement = " + query);
        return query;

    }
    //tk end//////////////////////////////////////////////////////////////////////

    public TFEparser gettfe_info() {
        return tfe_info;
    }

    public TFE get_TFEschema() {
        return tfe_info.get_TFEschema();
    }

    public CodeGenerator getcodegenerator() {
    	cgenerator.TFEid = 10000;
        return cgenerator;
    }
    public CodeGenerator getcodegenerator(int id) {
        cgenerator.TFEid = id;
    	return cgenerator;
    }
    public FromInfo get_from_info() {
        return from_info;
    }

    public static void set_from_info_st(String fi) {
        from_info_st = fi;
    }
    public static String get_from_info_st() {
    	if(from_info_st == null){
    		return "";
    	}
        return from_info_st;
    }

    public WhereInfo get_where_info() {
        return where_info;
    }

    public Hashtable get_att_info() {
        return this.tfe_info.get_attp();
    }

    public String getSSQLsig() {
        StringBuffer sig = new StringBuffer();
        //		sig.append(QueryImage.replaceAll("\\s",""));
        sig.append(QueryImage);
        String addCondition = GlobalEnv.getCondition();
        if (addCondition != null) {
            sig.append("@@");
            sig.append(addCondition);
        }
        //Log.out("[SSQL sig] = " +sig);
        return sig.toString();
    }

    /*
     * public String getSQLsig(ExtList sep_sch) {
     *
     * Hashtable atts = this.get_att_info(); FromInfo from =
     * this.get_from_info(); WhereInfo where = this.get_where_info();
     *
     * int i, idx; Integer itemno; ExtList schf; schf = sep_sch.unnest();
     * StringBuffer buf = new StringBuffer(); for (idx = 0; idx < schf.size();
     * idx++) { itemno = (Integer) (schf.get(idx)); AttributeItem att1 =
     * (AttributeItem) (atts.get(itemno)); buf.append(att1.getAttributeSig(from) +
     * "@@"); } // Where buf.append(where.getWhereSig(from));
     *
     * return buf.toString(); }
     */

    public Object[] getSQLsig(ExtList sep_sch) {

        Hashtable atts = this.get_att_info();
        FromInfo from = this.get_from_info();
        WhereInfo where = this.get_where_info();

        int idx;
        Integer itemno;
        ExtList schf = sep_sch.unnest();
        StringBuffer buf = new StringBuffer();

        Hashtable sig2idx = new Hashtable();
        TreeSet sorter = new TreeSet();
        String attsig;
        ExtList ordersig = new ExtList();

        for (idx = 0; idx < schf.size(); idx++) {
            itemno = (Integer) (schf.get(idx));
            attsig = ((AttributeItem) (atts.get(itemno))).getAttributeSig(from);
            sig2idx.put(attsig, new Integer(idx));
            sorter.add(attsig);
        }

        Iterator ite = sorter.iterator();
        while (ite.hasNext()) {
            attsig = (String) ite.next();
            buf.append(attsig + "@@");
            ordersig.add(sig2idx.get(attsig).toString());
        }

        Log.out("sig:" + buf);
        Log.out("ordersig:" + ordersig);

        // Where
        buf.append(where.getWhereSig(from));

        Object[] ret = { buf.toString(), ordersig };

        return ret;

    }

    public String getTFEsig(ExtList sep_sch) {

        Hashtable atts = this.get_att_info();
        FromInfo from = this.get_from_info();
        WhereInfo where = this.get_where_info();

        int i, idx;
        Object o;
        Integer itemno;
        StringBuffer buf = new StringBuffer();
        for (idx = 0; idx < sep_sch.size(); idx++) {
            o = sep_sch.get(idx);
            if (o instanceof Integer) {

                itemno = (Integer) (sep_sch.get(idx));
                AttributeItem att1 = (AttributeItem) (atts.get(itemno));
                buf.append(att1.getAttributeSig(from) + "@@");
            } else if (o instanceof ExtList) {
                buf.append("(");
                buf.append(getTFEsig((ExtList) o));
                buf.append(")");
            }
        }

        // Where
        buf.append(where.getWhereSig(from));

        return buf.toString();

    }


    //tk////////////////////////////////////////////////////////
    //embed
    public StringBuffer embed(String tmp)
    {


    	StringBuffer query = new StringBuffer();
       	StringTokenizer st = new StringTokenizer(tmp,",");

    	String[] ArgName = new String[100];
    	String[] ArgValue = new String[100];
    	int num = 0;

    	if(GlobalEnv.getEmbedOption() == 0)
    	{
    		query.append(tmp);
    		return query;
    	}
    	Log.out("**************new embed************************");
    	while(st.hasMoreTokens())
    	{
    		String part = new String();
    		part = st.nextToken();

    		if(part.contains("="))
    		{
	    		Log.out("part : " + part);
	    		String ArgNameTmp = part.substring(0,part.indexOf("="));

	    		String ArgValueTmp = part.substring(part.indexOf("=")+1, part.length());

	    		if(ArgNameTmp.contains("("))
	    		{
	    			ArgNameTmp = ArgNameTmp.substring(ArgNameTmp.indexOf("(")+1, ArgNameTmp.length());
	    		}

	    		if(ArgValueTmp.contains(")"))
	    			ArgValue[num] = ArgValueTmp.replace(")"," ");
	    		else
	    			ArgValue[num] = ArgValueTmp;

	    		ArgName[num] = ArgNameTmp.trim();
	    		ArgValue[num] = ArgValue[num].replace("\""," ");
	    		ArgValue[num] = ArgValue[num].trim();

	    		Log.out("num:"+num);
	    		Log.out("ArgName : " + ArgName[num]);
	    		Log.out("ArgValue : " + ArgValue[num]);

	    		num++;

    		}
    	}

    	int position = 0;

    	String in_where = new String();
    	String in_att = new String();
    	String filename = new String();

    	for(int a = 0; a < num ; ++a)
    	{
    		if(ArgName[a].equals("where"))
    			in_where = ArgValue[a];
    		if(ArgName[a].equals("att"))
    			in_att = ArgValue[a];
    		if(ArgName[a].equals("file"))
    			filename = ArgValue[position];
        }

    	if(!filename.contains(".sql"))
    	{
    		query.append(tmp);
    		return query;
    	}

//    	StringBuffer QueryTmpBuffer = new StringBuffer();
    	String line= new String();

    	BufferedReader in;

        StringBuffer tmp2 = new StringBuffer();
        try {

            in = new BufferedReader(new FileReader(filename));
//            String line2 = null;
            while (true) {
                line = in.readLine();
                if (line == null)
                    break;

                //tk start/////////////////////////////////////
                //for comment statement
                //commented out by goto 20130412
//                if(line.startsWith("//"))
//                	line = in.readLine();
                //changed by goto 20130412
                if(line!=null && line.contains("/*"))
                {
                	int s = line.indexOf("/*");
                	String line1 = line.substring(0,s);
//                	tmp2.append(" "+line1);
                	while(!line.contains("*/"))
                		line = in.readLine();
                	int t = line.indexOf("*/");
                	line = line1+line.substring(t+2);
                }
                //added by goto 20130412
                if(line!=null && line.contains("//")){
                	boolean dqFlg=false;
                	int i=0;
                	
                	for(i=0; i<line.length(); i++){
                		if(line.charAt(i)=='"' && !dqFlg)		dqFlg=true;
                		else if(line.charAt(i)=='"' && dqFlg)	dqFlg=false;
                		
                		if(!dqFlg && i<line.length()-1 && (line.charAt(i)=='/' && line.charAt(i+1)=='/'))
                			break;
                	}
                	line = line.substring(0,i);
                }
                
                if(line!=null)
                	tmp2.append(" " + line);
            }
            in.close();
        } catch (IOException e2) {
        }

        String QueryTmp = tmp2.toString();
        StringBuffer QueryBuffer = new StringBuffer();
        Log.out("embeded Query : " + QueryTmp);

        StringTokenizer st3 = new StringTokenizer(QueryTmp,"\t{}[]!,()@= \"' ;",true);

        String tmp3 = new String();
        String tmp4 = new String();

        String[] embed_table = new String[10000000];

        for(int i = 0 ; i < 1000000 ; i++)
        {
        	embed_table[i] = null;
        }
        int is_replaced = 0;
        String tmp5;

        while(st3.hasMoreTokens())
        {
        	tmp3 = st3.nextToken().toString();

        	tmp3.trim();

        	if(tmp3.equalsIgnoreCase("HTML"))
        		break;
        }

        while(st3.hasMoreTokens())
        {
        	tmp3 = st3.nextToken().toString();

        	tmp3.trim();
//        	Log.out(tmp3);
        	if(tmp3.equalsIgnoreCase("FROM"))
        	{
        		break;
        	}
//        	Log.out("tmp3:"+tmp3);

	        	if(tmp3.contains(".") && (!tmp3.contains("\"") && !tmp3.contains("html") && !tmp3.contains("http") && !tmp3.contains("css")))
	        	{
	        		tmp4 = tmp3.substring(0,tmp3.indexOf("."));
	        		tmp5 = tmp3.substring(tmp3.indexOf("."),tmp3.length());

/*	        		if(tmp4.contains(")"))
	        		{
	        			QueryBuffer.append(tmp4.substring(0,tmp4.indexOf(")")+1) );
	        			tmp4 = tmp4.substring(tmp4.indexOf(")")+1, tmp4.length());
	        		}
	        		else if(tmp4.contains("("))
	        		{
	        			QueryBuffer.append(tmp4.substring(0, tmp4.indexOf("(")+1) );
	        			tmp4 = tmp3.substring(tmp4.indexOf("(")+1, tmp4.length());
	        		}
	        		else if(tmp4.contains("["))
	        		{
	        			QueryBuffer.append(tmp4.substring(0, tmp4.indexOf("[")+1) );
	        			tmp4 = tmp3.substring(tmp4.indexOf("[")+1, tmp4.length());
	        		}
	        		else if(tmp4.contains("{"))
	        		{
	        			QueryBuffer.append(tmp4.substring(0, tmp4.indexOf("{")+1) );
	        			tmp4 = tmp4.substring(tmp4.indexOf("{")+1, tmp4.length());
	        		}
	        		else if(tmp4.contains(","))
	        		{
	        			QueryBuffer.append(tmp4.substring(0, tmp4.indexOf(",")+1) );
	        			tmp4 = tmp4.substring(tmp4.indexOf(",")+1, tmp4.length());
	        		}
	        		else if(tmp4.contains("}"))
	        		{
	        			QueryBuffer.append(tmp4.substring(0, tmp4.indexOf("}")+1) );
	        			tmp4 = tmp4.substring(tmp4.indexOf("}")+1, tmp4.length());
	        		}
	        		else if(tmp4.contains("!"))
	        		{
	        			QueryBuffer.append(tmp4.substring(0, tmp4.indexOf("!")+1) );
	        			tmp4 = tmp4.substring(tmp4.indexOf("!")+1, tmp4.length());
	        		}
	        		else if(tmp4.contains("]"))
	        		{
	        			QueryBuffer.append(tmp4.substring(0, tmp4.indexOf("]")+1) );
	        			tmp4 = tmp4.substring(tmp4.indexOf("]")+1, tmp4.length());
	        		}
	        		else if(tmp4.contains("="))
	        		{
	        			QueryBuffer.append(tmp4.substring(0, tmp4.indexOf("=")+1) );
	        			tmp4 = tmp4.substring(tmp4.indexOf("=")+1, tmp4.length());
	        		}
	*/
	        		for(int b = 0; b < table_num ; ++b)
	        		{
	        			if(tmp4.equals(embed_table[b]))
	        			{
	        				tmp4 = "embed" + b;

	        				is_replaced = 1;
	        				break;
	        			}
	        		}

	        		if(is_replaced == 0)
	        		{
	        			embed_table[table_num] = tmp4;
	        			tmp4 = "embed" + table_num;
	        			table_num++;
	        		}

	        		QueryBuffer.append(tmp4);
	        		QueryBuffer.append(tmp5);
	        		is_replaced = 0;
	        	}
	        	else if(!tmp3.equals(" "))
	        		QueryBuffer.append(tmp3);
	    }

    	for(int b = 0; b < table_num ; ++b)
    	{
    		Log.out( b + " ; " + embed_table[b]);
    	}

        //FROM
    	is_replaced = 0;

    	StringBuffer Embed_From = new StringBuffer();

        while(st3.hasMoreTokens())
        {
        	tmp3 = st3.nextToken().toString();

        	is_replaced = 0;
        	tmp3.trim();
        	Log.out("tmp3:" + tmp3+ " " + tmp3.length());
        	if(tmp3.equalsIgnoreCase("WHERE"))
        		break;

//        	Log.out("FROM tmp3:"+tmp3);
        	for(int b = 0; b < table_num ; ++b)
        	{
        		if(tmp3.equalsIgnoreCase(embed_table[b]))
        		{
        			Embed_From.append(" embed" + b);
        			is_replaced = 1;
        		}
        	}

//        	Log.out("is_replaced:"+is_replaced);

        	if(is_replaced == 0 && !tmp3.equalsIgnoreCase(" ") && !tmp3.equalsIgnoreCase(";"))
        	{
//            	if(Embed_From.length() != 0 && !tmp3.equals(" "))
//        			Embed_From.append(" # ");
        		Embed_From.append(" " + tmp3);
        	}
        }

        Log.out("Embed_From:"+Embed_From);
        if(embed_from.length() != 0)
        	embed_from.append(",");
        embed_from.append(Embed_From);

        //WHERE
        is_replaced = 0;

        StringBuffer Embed_Where = new StringBuffer();

        while(st3.hasMoreTokens())
        {
        	tmp3 = st3.nextToken().toString();
        	tmp3 = tmp3.trim();

 //       	Log.out(tmp3+" "+tmp3.length());
        	if(tmp3.equalsIgnoreCase("GROUP"))
        		break;

        	if(!tmp3.equals(" ") || tmp3.length() != 0)
        	{
        		if(tmp3.contains("."))
        		{
        			tmp4 = tmp3.substring(0,tmp3.indexOf("."));
        			tmp5 = tmp3.substring(tmp3.indexOf("."),tmp3.length());

//        			Log.out(tmp4 + " " + tmp5 );
        			for(int b = 0; b < table_num ; ++b)
        			{
        				if(tmp4.equalsIgnoreCase(embed_table[b]))
        				{
        					tmp4 = "embed" + b;
        					is_replaced = 1;
        				}
        			}

        			Embed_Where.append(tmp4+tmp5);
        		}
        		else
        			Embed_Where.append(tmp3);
        	}
        }

        if(embed_where.length() != 0 && Embed_Where.length() != 0)
        	embed_where .append(" AND ");
        embed_where.append(Embed_Where);



        position = -1;
        for(int a = 0 ; a < num ; ++a)
        	if(ArgName[a].equalsIgnoreCase("where"))
        		position = a;

        if(position != -1)
        {
        	String tmp10 = ArgValue[position];
        	String tmp11 = new String();
        	String tmp12 = new String();
        	is_replaced = 0;

        	if(tmp10.contains("."))
        	{
        		tmp11 = tmp10.substring(0,tmp10.indexOf("."));
        		tmp12 = tmp10.substring(tmp10.indexOf(".")+1 , tmp10.length());
        		for(int a = 0; a < table_num ; ++a)
        		{
        			if(tmp11.equals(embed_table[a]))
        			{
        				tmp11 = "embed"+a;
        				is_replaced = 1;
        			}
        		}
        		if(is_replaced == 0)
        		{
        			tmp11 = "embed" + table_num;
        			table_num++;
        		}
        	}
        	if(position != 0)
        	{
        		if(embed_where.length() != 0)
        			embed_where.append(" AND ");

        		embed_where.append(tmp11+ "." + tmp12);
        	}
        	position = -1;
        	for(int a = 0 ; a < num ; ++a)
       			if(ArgName[a].equalsIgnoreCase("att"))
       				position = a;

        	if(position != -1)
        		embed_where.append(ArgValue[position] + " ");

           	position = -1;
        	for(int a = 0 ; a < num ; ++a)
       			if(ArgName[a].equalsIgnoreCase("attString"))
       				position = a;

        	if(position != -1)
        		embed_where.append("" + ArgValue[position] + " ");

        	Log.out("Embed WHERE : " + embed_where);
        	is_replaced = 0;
        }
        StringBuffer Embed_Group = new StringBuffer();

        while(st3.hasMoreTokens())
        {
        	tmp3 = st3.nextToken();

        	if(tmp3.equalsIgnoreCase("BY"))
        		tmp3 = st3.nextToken();

        	if(tmp3.equalsIgnoreCase("HAVING"))
        		break;

        	for(int b = 0; b < table_num ; ++b)
        	{
        		if(tmp3.equalsIgnoreCase(embed_table[b]))
        		{
        			Embed_Group.append("embed" + b + " ");
        			is_replaced = 1;
        		}
        	}

        	if(is_replaced == 0)
        		Embed_Group.append(tmp3 + " ");
        }

        embed_group.append(Embed_Group);

        is_replaced = 0;

        StringBuffer Embed_Having = new StringBuffer();

        while(st3.hasMoreTokens())
        {
        	tmp3 = st3.nextToken();

        	if(tmp3.equalsIgnoreCase("HAVING"))
        		break;

        	for(int b = 0; b < table_num ; ++b)
        	{
        		if(tmp3.equalsIgnoreCase(embed_table[b]))
        		{
        			Embed_Having.append("embed" + b + " ");
        			is_replaced = 1;
        		}
        	}

        	if(is_replaced == 0)
        		Embed_Having.append(tmp3 + " ");
        }

        embed_having.append(Embed_Having);

        Log.out("Query Buffer : " + QueryBuffer);
        Log.out("Embed FROM : " + Embed_From);


        query = QueryBuffer;

        return  query;
    }

}
