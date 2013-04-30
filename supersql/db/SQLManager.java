package supersql.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.parser.FromParse;

public class SQLManager {

    Connection conn;

    ExtList header_name;

    ExtList header_type;

    ExtList tuples;

    //tk//////////////////////////////////////
    ConnectDB cdb;
    boolean isMulti = false;

    //tk////////////////////////////////////////
    public SQLManager(ConnectDB in_cdb)
    {
    	cdb = in_cdb;
    	isMulti = true;
    }
    //tk////////////////////////////////////////


    public SQLManager(String url, String user, String driver, String password) {
        Log.out("[SQLManager Open]");


        try {
        	if (GlobalEnv.getframeworklist() == null) {
	            Class.forName(driver);
	            Log.out("********** Database's URL is **********");
	            Log.out(url);
	            conn = DriverManager.getConnection(url, user, password);
        	}

        } catch (SQLException e) {
            System.err
                    .println("Error[SQLManager]: Can't Connect DB : jdbc path = "
                            + url + " , user = " + user);
            System.err.println(e);
            //tk////////////////////////////////////////////////////
            GlobalEnv.addErr("Error[SQLManager]: Can't Connect DB : jdbc path = "
                    + url + " , user = " + user);
            return ;
//        	System.exit(-1);
            //tk////////////////////////////////////////////////////
        } catch (ClassNotFoundException e) {
            System.err
                    .println("Error[SQLManager]: Can't Load JDBC driver : driver = "
                            + driver);
            //tk////////////////////////////////////////////////////
            GlobalEnv.addErr("Error[SQLManager]: Can't Load JDBC driver : driver = "
                            + driver);
            return ;
//        	System.exit(-1);
            //tk////////////////////////////////////////////////////
        }
    }

    public void ExecSQL(String query) {

    	if(isMulti)
    	{
    		Log.out("thred name:"+cdb.getName());
    		Log.out("isAlive?"+cdb.isAlive());
    		try{
    			cdb.join();
	    	}catch(InterruptedException e)
	    	{}

	    	conn = cdb.getConn();
    	}

        Log.out("[SQLManager ExecQuery]");
        if(!query.equals("SELECT DISTINCT  FROM ;")){
	        Log.info("********** SQL is **********");
	        Log.info(query);
        }

        header_name = new ExtList<String>();
        header_type = new ExtList<String>();
        tuples = new ExtList<String>();

        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                header_name.add(rsmd.getColumnName(i));
                header_type.add(Integer.toString(rsmd
                        .getColumnType(i)));
            }

            ExtList tmplist;
            String val;
            while (rs.next()) {
                tmplist = new ExtList();
                for (int i = 1; i <= columnCount; i++) {
                    val = rs.getString(i);
                    if (val != null) {
                        tmplist.add(val.trim());
                    } else {
                        tmplist.add("");
                        Log.out("[Warning] null value exist!");
                    }
                }
                tuples.add(tmplist);
            }
            Log.out("[SQLManager:execQuerySQL] Result tuples count = "
                    + tuples.size());
            GlobalEnv.setTuplesNum(tuples.size());



            if (tuples.size() == 0) {
            	//200912chie     notexit
                tmplist = new ExtList();
            	for (int i = 1; i <= columnCount; i++) {
                    tmplist.add("");
                    Log.out("[Warning] null value exist!");
                }
                tuples.add(tmplist);
                GlobalEnv.setTuplesNum(tuples.size());
                //chie end
                throw (new IllegalStateException());
            }

        } catch (SQLException e) {
        	//changed by goto 20130306 start  "FROMなしクエリ対策 2/3"
        	if(!query.equals("SELECT DISTINCT  FROM ;")){
	              System.err
	              .println("Error[SQLManager.ExecSQL]: Can't Exec Query : query = "
			                      + query);
			      System.err.println(e);
			
			      //tk////////////////////////////////////////////////////
			      GlobalEnv.addErr("Error[SQLManager.ExecSQL]: Can't Exec Query : query = "
			              + query);
			      return ;
        	}
        	//else{
        	//	Log.info("FROMなし2");
        	//}
//            System.err
//                    .println("Error[SQLManager.ExecSQL]: Can't Exec Query : query = "
//                            + query);
//            System.err.println(e);
//
//            //tk////////////////////////////////////////////////////
//            GlobalEnv.addErr("Error[SQLManager.ExecSQL]: Can't Exec Query : query = "
//                    + query);
//            return ;
        	//changed by goto 20130306 end
//        	System.exit(-1);
            //tk////////////////////////////////////////////////////

        } catch (IllegalStateException e) {
            System.err
                    .println("Error[SQLManager.ExecSQL]: No Data Found : query = "
                            + query);
            if(false){//200912chie     notexit
            	GlobalEnv.addErr("Error[SQLManager.ExecSQL]: No Data Found : query = "
                    + query);
            }
            //tk
            //System.exit(-1);
        }
    }

    //morya start
    public void ExecListToResult(String listarg, String query) {

        Log.out("[SQLManager ExecListToResult]");
        Log.info("********** Query For Framework **********");
        query = query.replace("SELECT DISTINCT", "");
        query = query.replace(query.substring(query.indexOf("FROM"),query.length()),"").trim();
        Log.info(query);

        header_name = new ExtList();
        header_type = new ExtList();
        tuples = new ExtList();

        //necessary variable for framework
        List <String> listcol = new ArrayList<String>();
        List <List> listdb = new ArrayList<List>();
        List <Integer> num_from_left = new ArrayList<Integer>();
        int listdb_column_num=0;

        /*listcol.add("aaa");
        listcol.add("iii");
        listdb.add(listcol);
        listcol = new ArrayList();
        listcol.add("uuu");
        listcol.add("eee");
        listdb.add(listcol);
        Log.out(listdb.get(0).get(0)+ "listdb" + listdb.get(1).get(1));*/

        /*header_name.add(new ExtList("Car.rank"));
        header_name.add(new ExtList("Car.name"));
        header_name.add(new ExtList("Car.photo"));
        header_type.add(new ExtList("4"));
        header_type.add(new ExtList("4"));
        header_type.add(new ExtList("4"));
        ExtList tmplist = new ExtList();

        tuples.add(tmplist);
        tmplist = new ExtList();

        tuples.add(tmplist);*/


        int fromchnum = 0, tochnum=0;
        int flag=0;
        listdb_column_num++;//+1
        // \t divide turn  **1turn=attribute get
        while(listarg.indexOf("\t",fromchnum) != -1){
        	tochnum = listarg.indexOf("\t",fromchnum);
        	String tmpstr = listarg.substring(fromchnum,tochnum);
        	int fromchnum2 = 0, tochnum2 = 0;
        	while(tmpstr.indexOf(",",fromchnum2) != -1){
        		tochnum2 = tmpstr.indexOf(",",fromchnum2);
        		listcol.add(tmpstr.substring(fromchnum2,tochnum2));
        		fromchnum2 = tochnum2 + 1;
        		if(flag==0) listdb_column_num++;
        	}
        	tochnum2 = tmpstr.length();
            listcol.add(tmpstr.substring(fromchnum2,tochnum2));
            flag++;

        	listdb.add(listcol);
        	listcol = new ArrayList();

        	fromchnum = tochnum + 1; //need +1
        }
        tochnum = listarg.length();
        String tmpstr = listarg.substring(fromchnum,tochnum);
    	int fromchnum2 = 0, tochnum2 = 0;
    	while(tmpstr.indexOf(",",fromchnum2) != -1){
    		tochnum2 = tmpstr.indexOf(",",fromchnum2);
    		listcol.add(tmpstr.substring(fromchnum2,tochnum2));
    		fromchnum2 = tochnum2 + 1;
    	}
    	tochnum2 = tmpstr.length();
        listcol.add(tmpstr.substring(fromchnum2,tochnum2));
    	listdb.add(listcol);

        //display test
        /*for (int i=0;i<listdb.size();i++){
        	Log.out(listdb.get(i)+"listdb_get");
        }*/
    	//Log.out("listdb_column_num:"+listdb_column_num);

        //query process
        fromchnum = 0; tochnum=0;
        while(query.indexOf(",",fromchnum) != -1){
        	tochnum = query.indexOf(",",fromchnum);
        	header_name.add(query.substring(fromchnum,tochnum).trim());
        	header_type.add("4");
        	for(int i=0;i<listdb_column_num;i++){
        		if(query.substring(fromchnum,tochnum).trim().equals(listdb.get(0).get(i))){
        			num_from_left.add(i);
        			//Log.out("virtual query  "+query.substring(fromchnum,tochnum).trim()+" "+listdb.get(0).get(i)+" "+i);
        		}
        	}
        	fromchnum = tochnum + 1;
        }
        tochnum = query.length();
        header_name.add(query.substring(fromchnum,tochnum).trim());
        header_type.add("4");
        for(int i=0;i<listdb_column_num;i++){
    		if(query.substring(fromchnum,tochnum).trim().equals(listdb.get(0).get(i))){
    			num_from_left.add(i);
    			//Log.out("virtual query  "+query.substring(fromchnum,tochnum).trim()+" "+listdb.get(0).get(i)+" "+i);
    		}
    	}

        //display test
        /*Log.out("header_name:"+header_name);
        for (int i=0;i<num_from_left.size();i++){
        	Log.out(num_from_left.get(i)+"num_from_left"+i);
        }*/

        //get record turn
        ExtList<String> tmplist;
        String val;
        for (int i=1;i<listdb.size();i++) {//from 1 roop
            tmplist = new ExtList();
            for (int j=0;j<num_from_left.size();j++) {
            	val = (String)listdb.get(i).get(num_from_left.get(j));
                if (val != null) {
                    tmplist.add(val);
                } else {
                    tmplist.add("");
                    Log.out("[Warning] null value exist!");
                }
            }
            tuples.add(tmplist);

        }
        Log.out("[SQLManager:ExecListToResult] Result tuples count = "
                + tuples.size());

        Log.out("   "+tuples+"  ");

/*
        try {
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                header_name.add(new ExtList(rsmd.getColumnName(i)));
                header_type.add(new ExtList(Integer.toString(rsmd
                        .getColumnType(i))));
            }

            ExtList tmplist;
            String val;

            while (rs.next()) {
                tmplist = new ExtList();
                for (int i = 1; i <= columnCount; i++) {
                    val = rs.getString(i);
                    if (val != null) {
                        tmplist.add(new ExtList(rs.getString(i).toString()
                                .trim()));
                    } else {
                        tmplist.add(new ExtList(""));
                        Log.out("[Warning] null value exist!");
                    }
                }
                tuples.add(tmplist);

            }
            Log.out("[SQLManager:execQuerySQL] Result tuples count = "
                    + tuples.size());



            if (tuples.size() == 0) {
                throw (new IllegalStateException());
            }

        } catch (SQLException e) {
            System.err
                    .println("Error[SQLManager.ExecSQL]: Can't Exec Query : query = "
                            + query);
            System.err.println(e);

            //tk////////////////////////////////////////////////////
            GlobalEnv.addErr("Error[SQLManager.ExecSQL]: Can't Exec Query : query = "
                    + query);
            return ;
//        	System.exit(-1);
            //tk////////////////////////////////////////////////////

        } catch (IllegalStateException e) {
            System.err
                    .println("Error[SQLManager.ExecSQL]: No Data Found : query = "
                            + query);
            //tk
            //System.exit(-1);
        }
        */
    }
    /////////////

    public ExtList GetBody() {
        return tuples;
    }

    public void close() {
    	if (GlobalEnv.getframeworklist() == null) {
	        try {
	            if (!conn.isClosed()) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Error[SQLManager]: Can't Close DB :");
	            //tk////////////////////////////////////////////////////
	            GlobalEnv.addErr("Error[SQLManager]: Can't Close DB :");
	            return ;
	//        	System.exit(-1);
	            //tk////////////////////////////////////////////////////
	        }
    	}

    }

    public String getAttList(String from_string, String connector, String att){
    	String columnList = new String();
    	try{
    		Statement stmt = conn.createStatement();
    		String[] spritFrom = from_string.split(",");
    		if(connector == null || connector.isEmpty()){
    			connector = ",";
    		}
    		for(int fromnum = 0; fromnum < spritFrom.length ;fromnum++){
    			FromParse fp = new FromParse(spritFrom[fromnum].trim());
    			if(att.equals( fp.getAlias() + "." + "*") || att.equals("*")){
    				String sql = "SELECT " + att + " FROM " + fp.getRealName() + " " + fp.getAlias() +" WHERE false;";
    				ResultSet rs = stmt.executeQuery(sql);
    				//Log.out(sql);
    				ResultSetMetaData metaData = rs.getMetaData();
    				int columnCount = metaData.getColumnCount();
    				for(int i = 1 ; i <= columnCount;i++){
    					columnList += fp.getAlias() + "." + metaData.getColumnName(i) + connector;
    				}
    				//Log.out("columnList :"+columnList);
    			}
    		}
    		columnList = columnList.substring(0,columnList.length()-1);
    	}catch(Exception e){
    		System.err.println(e);
    	}
    	return columnList;
    }

}