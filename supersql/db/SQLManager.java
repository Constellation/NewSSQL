package supersql.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.parser.FromParse;




public class SQLManager {

	private Connection conn;
	private ExtList<String> header_name;
	private ExtList<String> header_type;
	private ExtList<ExtList<String>> tuples;

	private ConnectDB cdb;
	private boolean isMulti = false;

    public SQLManager(ConnectDB in_cdb)
    {
    	cdb = in_cdb;
    	isMulti = true;
    }

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
            GlobalEnv.addErr("Error[SQLManager]: Can't Connect DB : jdbc path = "
                    + url + " , user = " + user);
            return ;
        } catch (ClassNotFoundException e) {
            System.err
                    .println("Error[SQLManager]: Can't Load JDBC driver : driver = "
                            + driver);
            GlobalEnv.addErr("Error[SQLManager]: Can't Load JDBC driver : driver = "
                            + driver);
            return ;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
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

    	if(query.contains(" #"))	query = query.substring(0,query.indexOf(" #"));
        Log.out("[SQLManager ExecQuery]");
        if(!query.equals("SELECT DISTINCT  FROM ;") && !query.equals("SELECT  FROM ;")){
	        Log.info("\n********** SQL is **********");
	        Log.info(query);
        }

        header_name = new ExtList<String>();
        header_type = new ExtList<String>();
        tuples = new ExtList<ExtList<String>>();

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

            ExtList<String> tmplist;
            String val;
            while (rs.next()) {
                tmplist = new ExtList<String>();
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
                tmplist = new ExtList<String>();
            	for (int i = 1; i <= columnCount; i++) {
                    tmplist.add("");
                    Log.out("[Warning] null value exist!");
                }
                tuples.add(tmplist);
                GlobalEnv.setTuplesNum(tuples.size());
                throw (new IllegalStateException());
            }

        } catch (SQLException e) {
        	if(!query.equals("SELECT DISTINCT  FROM ;") && !query.equals("SELECT  FROM ;")){
	              System.err
	              .println("Error[SQLManager.ExecSQL]: Can't Exec Query : query = "
			                      + query);
			      System.err.println(e);
			      GlobalEnv.addErr("Error[SQLManager.ExecSQL]: Can't Exec Query : query = "
			              + query);
			      
			      //added by goto 20131016 start
			      String list = "";
			      String errorContents[] = getErrorContents(e);  //return: [0]=Error message, [1]=Error table name or column name, [2]=Error table alias
			      if(errorContents[0].contains("column")){
			    	  //Log.e(error_tableName_or_columnName_alias+" "+error_tableName_or_columnName);
			    	  ArrayList<ArrayList> tableNameAndAlias = getTableNamesFromQuery(query);	//return: (0)=Table name, (1)=Table alias, (2)=From phrase
			    	  if(errorContents[0].contains("ambiguous")){
			    		  list = getgetAmbiguousTableAndColumnNameList(conn, tableNameAndAlias.get(0), errorContents[1]);
			    	  }else{
				    	  list = getTableAndColumnNameList(conn, tableNameAndAlias.get(0), tableNameAndAlias.get(1), errorContents[1], errorContents[2], tableNameAndAlias.get(2));
			    	  }
			    	  Log.err("\n## Column list ##\n" + list);
			    	  
			      }else if(errorContents[0].contains("table")){
			    	  list = getTableNameList(conn, errorContents[1]);
			    	  Log.err("\n## Table list ##\n" + list + "\n");
			      }
			      
			      ////////////////////////////////////
			      //String args[] = new String[10];
			      //args[0] = "dep";
			      //args[1] = "dept";
			      //String filename="/Users/goto/Desktop/big.txt";
//			      try {
////			    	  checkTableName(new String[]{"dep"});
//			    	  checkTableName("dep", allTables0);
//			      } catch (IOException e1) {
//			    	  e1.printStackTrace();
//			      }
			      ////////////////////////////////////
			      
			      //added by goto 20131016 end

			      return ;
        	}
        } catch (IllegalStateException e) {
            System.err
                    .println("Error[SQLManager.ExecSQL]: No Data Found : query = "
                            + query);
        }
    }

    //added by goto 20131016 start
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    /****************  Did you mean?  ****************/
	private final HashMap<String, Integer> nWords = new HashMap<String, Integer>();
	//private String[] allTables0 = {"world_heritage", "wh_prefectures", "prefectures", "dept"};
	
	public void checkTableName(String tName, ArrayList<String> tNames) throws IOException {
		if(tName.length() > 0){
			String ans = (new SQLManager(tNames)).correct(tName);
			if(!ans.equals(tName)){
				//Log.err("\nもしかして.. "+ans+" ?");
				Log.err("\nDid you mean... '"+ans+"' ?");
			}
		}
	}
	
	public SQLManager(ArrayList<String> t) throws IOException {
		//BufferedReader in = new BufferedReader(new FileReader(file));
		Pattern p = Pattern.compile("\\w+");
		String temp = "";
		for(int i=0; i<t.size(); i++){
			temp = t.get(i);
			Matcher m = p.matcher(temp.toLowerCase());
			while(m.find()) nWords.put((temp = m.group()), nWords.containsKey(temp) ? nWords.get(temp) + 1 : 1);
		}
		//in.close();
		
//		BufferedReader in = new BufferedReader(new FileReader(file));
//		Pattern p = Pattern.compile("\\w+");
//		for(String temp = ""; temp != null; temp = in.readLine()){
//			Matcher m = p.matcher(temp.toLowerCase());
//			while(m.find()) nWords.put((temp = m.group()), nWords.containsKey(temp) ? nWords.get(temp) + 1 : 1);
//		}
//		in.close();
	}
	private final ArrayList<String> edits(String word) {
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i < word.length(); ++i) result.add(word.substring(0, i) + word.substring(i+1));
		for(int i=0; i < word.length()-1; ++i) result.add(word.substring(0, i) + word.substring(i+1, i+2) + word.substring(i, i+1) + word.substring(i+2));
		for(int i=0; i < word.length(); ++i) for(char c='a'; c <= 'z'; ++c) result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i+1));
		for(int i=0; i <= word.length(); ++i) for(char c='a'; c <= 'z'; ++c) result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i));
		return result;
	}
	public final String correct(String word) {
		if(nWords.containsKey(word)) return word;
		ArrayList<String> list = edits(word);
		HashMap<Integer, String> candidates = new HashMap<Integer, String>();
		for(String s : list) if(nWords.containsKey(s)) candidates.put(nWords.get(s),s);
		if(candidates.size() > 0) return candidates.get(Collections.max(candidates.keySet()));
		for(String s : list) for(String w : edits(s)) if(nWords.containsKey(w)) candidates.put(nWords.get(w),w);
		return candidates.size() > 0 ? candidates.get(Collections.max(candidates.keySet())) : word;
	}
    ////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
	//TODO: 類似度判定

	
	////////////////////////////////////////////////////////////////////////////////////////////////

    
    //get 'Error message', 'Error table name or column name', 'Error table alias' from exception message
    /* return: [0]=Error message, [1]=Error table name or column name, [2]=Error table alias */
    private String[] getErrorContents(Exception e){
    	String error = e.toString().toLowerCase();
    	String error_tableName_or_columnName = error.substring(error.lastIndexOf(":")+1).trim();
    	String error_tableAlias = "";
    	if(error_tableName_or_columnName.contains(".")){
    		error_tableAlias = error_tableName_or_columnName.substring(0,error_tableName_or_columnName.indexOf("."));
    	  	error_tableName_or_columnName = error_tableName_or_columnName.substring(error_tableName_or_columnName.indexOf(".")+1);
    	}
    	return new String[]{error, error_tableName_or_columnName, error_tableAlias};
    }
    //get table names from query
    /* return: (0)=Table name, (1)=Table alias, (2)=From phrase */
    @SuppressWarnings({ "rawtypes", "serial" })
	private ArrayList<ArrayList> getTableNamesFromQuery(String query){
  	  	String tableNames = "";
//  	  	ArrayList<String[]> tableName = new ArrayList<String[]>();
  	  	final ArrayList<String> tableName = new ArrayList<String>();
  	  	final ArrayList<String> tableAlias = new ArrayList<String>();
  	  	final ArrayList<String> fromPhrase = new ArrayList<String>();
  	  	try{
	    	  String q = query.toLowerCase();
	    	  q = q.substring(q.lastIndexOf("from")+4);
	    	  if(q.contains("where")){
	    		  tableNames = q.substring(0, q.lastIndexOf("where"));
	    	  }else if(q.contains("group by")){
	    		  tableNames = q.substring(0, q.lastIndexOf("group by"));
	    	  }else if(q.contains("order by")){
	    		  tableNames = q.substring(0, q.lastIndexOf("order by"));
	    	  }
	    	  
	    	  //if(!tableNames.equals("")) Log.e("\n## From phrase ##\n"+tableNames.trim());
	    	  fromPhrase.add(0,tableNames);
	    	  
	    	  int i=0;
	    	  tableNames += ",";
	    	  while(tableNames.contains(",")){
	    		  int index = tableNames.indexOf(",");
	    		  tableName.add(i, tableNames.substring(0,index).trim());
	    		  tableAlias.add(i, "");
	    		  String tn = tableName.get(i);
	    		  if(tn.contains(" ")){
	    			  tableName.set(i, tn.substring(0,tn.indexOf(" ")).trim());
	    			  tableAlias.set(i, tn.substring(tn.lastIndexOf(" ")).trim());
	    		  }
	    		  tableNames = tableNames.substring(index+1);
	    		  //Log.e(tableName.get(i)+" "+tableAlias.get(i));
	    		  i++;
	    	  }
  	  	}catch(Exception e){}
//  	  	ArrayList<ArrayList> array = new ArrayList<ArrayList>();
//  	  	array.add(tableName);
//  	  	array.add(tableAlias);
//  	  	return array;
  	  	return new ArrayList<ArrayList>() {{add(tableName); add(tableAlias); add(fromPhrase);}};
//  	  	return new ArrayList<ArrayList>() {{new ArrayList<String>(tableName); add(tableAlias);}};
//	  		return new ArrayList<ArrayList>(2) {{add("hoge"); add("piyo"); add("foo"); add("bar");}};
    }
//    private ArrayList<String> getTableNamesFromQuery(String query){
//    	String tableNames = "";
//    	ArrayList<String> tableName = new ArrayList<String>();
//    	try{
//    		String q = query.toLowerCase();
//    		q = q.substring(q.lastIndexOf("from")+4);
//    		if(q.contains("where")){
//    			tableNames = q.substring(0, q.lastIndexOf("where"));
//    		}else if(q.contains("group by")){
//    			tableNames = q.substring(0, q.lastIndexOf("group by"));
//    		}else if(q.contains("order by")){
//    			tableNames = q.substring(0, q.lastIndexOf("order by"));
//    		}
//    		
//    		int i=0;
//    		tableNames += ",";
//    		while(tableNames.contains(",")){
//    			int index = tableNames.indexOf(",");
//    			tableName.add(i, tableNames.substring(0,index).trim());
//    			String tn = tableName.get(i);
//    			if(tn.contains(" ")){
////	    			  tableName.remove(i);
////	    			  tableName.add(i, tn.substring(0,tn.indexOf(" ")).trim());
//    				tableName.set(i, tn.substring(0,tn.indexOf(" ")).trim());
//    			}
//    			tableNames = tableNames.substring(index+1);
//    			i++;
//    		}
//    	}catch(Exception e){}
//    	return tableName;
//    }
    //get table and column name list
    //- no such column: エイリアスあり: それのみ表示、 エイリアス無し: From句に書かれているテーブルの一覧を表示
    private String getTableAndColumnNameList(Connection conn, ArrayList<String> tableName, ArrayList<String> tableAlias, String errorColumnName, String errorTableNameAlias, ArrayList<String> fromPhrase){
  	  	String list = "";
  	  	String listBuf = "";
  	  	String tn = "";
  	  	String ta = "";
  	  	ResultSet rs = null;
  	  	boolean columnNameIsWrong = true;
  	  	String errorTn = "";
  	  	boolean aliasIsWrong = true;
  	  	String tableHas = "";
  	  	try{
				DatabaseMetaData dmd = conn.getMetaData();
//				for(int i=0;i<tableAlias.size();i++){
//					if(tableAlias.get(i).equals(errorTableNameAlias)){
//						aliasIsWrong = false;
//						break;
//					}
//				}
				
				for(int i=0;i<tableName.size();i++){
					tn = tableName.get(i);
					ta = tableAlias.get(i);
					if((!errorTableNameAlias.isEmpty() && (ta.equals(errorTableNameAlias) || tn.equals(errorTableNameAlias)))){
						errorTn = tn;
						listBuf = list;
						list = "";
					}
					list += tn+"(";
					rs = dmd.getColumns(null, null, tn, null);
					try {
						while(rs.next()){
							if(!errorTn.equals("") && tn.equals(errorTn) && rs.getString("COLUMN_NAME").equals(errorColumnName)){
								//Log.e("!!!!!!!! "+ errorTn);
								columnNameIsWrong = false;
							}
							list += rs.getString("COLUMN_NAME") + ", ";
						}
					} finally {
						rs.close();
					}
					list = list.substring(0, list.length()-2);
					list += ")\n";
					if((!errorTableNameAlias.isEmpty() && (ta.equals(errorTableNameAlias) || tn.equals(errorTableNameAlias)))){
						//System.err.print("\n## "+list.replace("(", " has ##\n("));
						tableHas = "\n## "+list.replace("(", " has ##\n(");
						list = listBuf+list;
						aliasIsWrong = false;
					}
				}
				if(aliasIsWrong && !errorTableNameAlias.isEmpty()){
					Log.err("\n## Wrong alias: >>>> "+errorTableNameAlias+" <<<< ."+errorColumnName+"  ##");
				}
				else if(columnNameIsWrong && !errorTableNameAlias.isEmpty()){
					Log.err("\n## Wrong column name: "+errorTableNameAlias+". >>>> "+errorColumnName+" <<<< ##");
				}
				if(!tableHas.isEmpty() && columnNameIsWrong){
					System.err.print(tableHas);
				}
				if(!fromPhrase.get(0).isEmpty() && aliasIsWrong && !errorTableNameAlias.isEmpty()){
					Log.err("\n## From phrase is ##\n"+fromPhrase.get(0).trim());
				}
					
  	  	}catch(Exception e){}
  	  	return list;
    }
    //get ambiguous table and column name list
    //- ambiguous column name: そのカラム名を持っているtable&column一覧を表示
    private String getgetAmbiguousTableAndColumnNameList(Connection conn, ArrayList<String> tableName, String ambiguousColumnName){
    	String list = "";
    	String listBuf = "";
    	String tn = "";
    	String cn = "";
    	ResultSet rs = null;
    	try{
    		DatabaseMetaData dmd = conn.getMetaData();
    		for(int i=0;i<tableName.size();i++){
    			tn = tableName.get(i);
    			listBuf = tn+"(";
    			rs = dmd.getColumns(null, null, tn, null);
    			try {
    				while(rs.next()){
    					cn = rs.getString("COLUMN_NAME");
    					if(!cn.equals(ambiguousColumnName))	listBuf += cn + ", ";
    					else								listBuf += ">>>> "+cn + " <<<< , ";
    				}
    			} finally {
    				rs.close();
    			}
    			if(listBuf.contains(" <<<< , ")){
    				list += listBuf;
    				listBuf = "";
	    			list = list.substring(0, list.length()-2);
	    			list += ")\n";
    			}
    		}
    	}catch(Exception e){}
    	return list;
    }
//    private String getTableAndColumnNameList(Connection conn, ArrayList<String> tableName){
//    	String list = "";
//    	try{
//    		DatabaseMetaData dmd = conn.getMetaData();
//    		for(int i=0;i<tableName.size();i++){
//    			String tn = tableName.get(i);
//    			list += tn+"(";
//    			ResultSet rs = dmd.getColumns(null, null, tn, null);
//    			try {
//    				while(rs.next()){
//    					list += rs.getString("COLUMN_NAME") + ", ";
//    				}
//    			} finally {
//    				rs.close();
//    			}
//    			list = list.substring(0, list.length()-2);
//    			list += ")\n";
//    		}
//    	}catch(Exception e){}
//    	return list;
//    }
    //get table name list
    //- no such table: 近い名前から表示
    private String getTableNameList(Connection conn, String tName){
  	  	String list = "";
  	  	//String[] tNames = new String[100];
  	  	//String[] tNames = {"SHOP", "DEPT", "EMPLOYEE", "ITEM", "PARTS", "SUPPLIER", "SALE", "SUPPLY", "KIND_OF_WH", "WORLD_HERITAGE", "PREFECTURES", "WH_PREFECTURES", "PICTURES", "SQLITE_SEQUENCE", "STOCK", "QUESTION", "COMMENT", "ADMIN", "USERS", "USERS2", "TEAM", "PLAYER", "OB", "ATTENDANCE", "GPS_TEST", "RESTAURANTS", "R_PHOTO"};
  	  	ArrayList<String> tNames = new ArrayList<String>();
  	  	try{
				DatabaseMetaData dmd = conn.getMetaData();
				String types[] = { "TABLE" };
				ResultSet rs = dmd.getTables(null, null,"%", types);
				try {
					int i = 0;
					while(rs.next()){
						list += rs.getString("TABLE_NAME").toLowerCase() + ", ";
						tNames.add(i++,rs.getString("TABLE_NAME"));
//						i++;
					}
				} finally {
					rs.close();
				}
  	  	}catch(Exception e){}
  	  	if(!list.equals(""))  list = list.substring(0, list.length()-2);
  	  	
  	  	/////////////
  	  	try{
  	  		//for(int i=0; i<tNames.length; i++)
  	  		//Log.e(tNames[i]);
//  	  		checkTableName("det", tNames);
  	  		checkTableName(tName, tNames);
//  	  	checkTableName("dep", allTables0);
  	  	}catch(Exception e){}
  	  	/////////////
  	  	
  	  	return list;
    }
    //added by goto 20131016 end
    
    //morya start
    public void ExecListToResult(String listarg, String query) {

        Log.out("[SQLManager ExecListToResult]");
        Log.info("********** Query For Framework **********");
        query = query.replace("SELECT DISTINCT", "");
        query = query.replace(query.substring(query.indexOf("FROM"),query.length()),"").trim();
        Log.info(query);

        header_name = new ExtList<String>();
        header_type = new ExtList<String>();
        tuples = new ExtList<ExtList<String>>();

        //necessary variable for framework
        List <String> listcol = new ArrayList<String>();
        List <List<String>> listdb = new ArrayList<List<String>>();
        List <Integer> num_from_left = new ArrayList<Integer>();
        int listdb_column_num=0;

        int fromchnum = 0, tochnum=0;
        int flag=0;
        listdb_column_num++;
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
        	listcol = new ArrayList<String>();

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

        //query process
        fromchnum = 0; tochnum=0;
        while(query.indexOf(",",fromchnum) != -1){
        	tochnum = query.indexOf(",",fromchnum);
        	header_name.add(query.substring(fromchnum,tochnum).trim());
        	header_type.add("4");
        	for(int i=0;i<listdb_column_num;i++){
        		if(query.substring(fromchnum,tochnum).trim().equals(listdb.get(0).get(i))){
        			num_from_left.add(i);
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
    		}
    	}

        //get record turn
        ExtList<String> tmplist;
        String val;
        for (int i=1;i<listdb.size();i++) {//from 1 roop
            tmplist = new ExtList<String>();
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
    }

    public ExtList<ExtList<String>> GetBody() {
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
	            GlobalEnv.addErr("Error[SQLManager]: Can't Close DB :");
	            return ;
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
    				ResultSetMetaData metaData = rs.getMetaData();
    				int columnCount = metaData.getColumnCount();
    				for(int i = 1 ; i <= columnCount;i++){
    					columnList += fp.getAlias() + "." + metaData.getColumnName(i) + connector;
    				}
    			}
    		}
    		columnList = columnList.substring(0,columnList.length()-1);
    	}catch(Exception e){
    		System.err.println(e);
    	}
    	return columnList;
    }

}