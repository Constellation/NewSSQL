package supersql.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import supersql.common.Log;
//import supersql.db.Suggest.LevensteinClass;
//import supersql.db.Suggest.LevensteinComparator;

//added by goto 20131016 start
public class Suggest {
    //added by goto 20131016 start
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    /****************  Did you mean?  ****************/
	private final HashMap<String, Integer> nWords = new HashMap<String, Integer>();
	//private String[] allTables0 = {"world_heritage", "wh_prefectures", "prefectures", "dept"};
	
	public static boolean checkTableNameAndSuggest(String tName, ArrayList<String> tNames) throws IOException {
		if(tName.length() > 0){
			String ans = (new Suggest(tNames)).correct(tName);
			if(!ans.equals(tName)){
				//Log.err("\nもしかして.. "+ans+" ?");
				Log.err("\nDid you mean... '"+ans+"' ?");
				return true;
			}
		}
		return false;
	}
	
	public Suggest(ArrayList<String> t) throws IOException {
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


    
    //get 'Error message', 'Error table name or column name', 'Error table alias' from exception message
    /* return: [0]=Error message, [1]=Error table name or column name, [2]=Error table alias */
    public static String[] getErrorContents(Exception e){
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
	public static ArrayList<ArrayList> getTableNamesFromQuery(String query){
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
    public static String getTableAndColumnNameList(Connection conn, ArrayList<String> tableName, ArrayList<String> tableAlias, String errorColumnName, String errorTableNameAlias, ArrayList<String> fromPhrase){
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
    public static String getgetAmbiguousTableAndColumnNameList(Connection conn, ArrayList<String> tableName, String ambiguousColumnName){
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
    static String getTableNameList(Connection conn, String tName){
  	  	String list = "";
  	  	String tn = "";
  	  	//String[] tNames = {"SHOP", "DEPT", "EMPLOYEE", "ITEM", "PARTS", "SUPPLIER", "SALE", "SUPPLY", "KIND_OF_WH", "WORLD_HERITAGE", "PREFECTURES", "WH_PREFECTURES", "PICTURES", "SQLITE_SEQUENCE", "STOCK", "QUESTION", "COMMENT", "ADMIN", "USERS", "USERS2", "TEAM", "PLAYER", "OB", "ATTENDANCE", "GPS_TEST", "RESTAURANTS", "R_PHOTO"};
  	  	ArrayList<String> tNames = new ArrayList<String>();
  	  	try{
				DatabaseMetaData dmd = conn.getMetaData();
				String types[] = { "TABLE" };
				ResultSet rs = dmd.getTables(null, null,"%", types);
				try {
					int i = 0;
					while(rs.next()){
						tn = rs.getString("TABLE_NAME").toLowerCase();
						//list += tn + ", ";
						tNames.add(i++, tn);
					}
				} finally {
					rs.close();
				}
  	  	}catch(Exception e){}
  	  	//if(!list.equals(""))  list = list.substring(0, list.length()-2);
  	  	
  	  	/////////////
  	  	boolean suggested = false;
  	  	try{
  	  		suggested = checkTableNameAndSuggest(tName, tNames);
  	  	}catch(Exception e){}
  	  	/////////////
  	  	
  	  	/////////////
  	  	if(suggested)	list = checkLevensteinDistance(tName, tNames);	//提案あり: 類似度判定
  	  	else	  		list = ascendingSort(tNames);					//提案なし: 昇順ソート
  	  	/////////////
  	  	
  	  	return list;
    }
    //return Ascending sort Table name
	private static String ascendingSort(ArrayList<String> tNames) {
		//アルファベット順にソート
		String list = "";
		Collections.sort(tNames);
		for(String val : tNames){ 
			list += val + ", ";
		}
		if(!list.equals(""))  list = list.substring(0, list.length()-2);
		return list;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	//類似度判定
	private static String checkLevensteinDistance(String a, ArrayList<String> tNames){
		String tn0 = "";
		String tn = "";
//		List <String>l = new ArrayList<String>();
//		Map<Float, String> hashmap = new HashMap<Float, String>();
        ArrayList<LevensteinClass> al = new ArrayList<LevensteinClass>();
		
		//1に近いほど似ている
        //LevensteinDistance l_algo = new LevensteinDistance();
//        JaroWinklerDistance j_algo = new JaroWinklerDistance();
        for(int i=0; i<tNames.size(); i++){
        	tn0 = a.toLowerCase();
        	tn = tNames.get(i).toLowerCase();
        	//String x = ""+ LevenshteinDistance.computeDistance(tn0, tn);
        	String x = ""+ LevenshteinDistance.getDistance(tn0, tn);
        	//Log.e(tn+" "+x);
//        	String x = ""+j_algo.getDistance(tn0, tn);
//        	l.add(i, x);
//        	hashmap.put(Float.parseFloat(x),tn);
        	al.add(new LevensteinClass(Float.parseFloat(x),tn));
        	
        	//Log.err("実行結果(LevensteinDistance("+tn0+", "+tn+"))：" + x);
        }
//        //1に近いほど似ている
//        LevensteinDistance l_algo = new LevensteinDistance();
////        JaroWinklerDistance j_algo = new JaroWinklerDistance();
//        for(int i=0; i<tNames.size(); i++){
//        	tn0 = a.toLowerCase();
//        	tn = tNames.get(i).toLowerCase();
//        	String x = ""+l_algo.getDistance(tn0, tn);
////        	String x = ""+j_algo.getDistance(tn0, tn);
////        	l.add(i, x);
////        	hashmap.put(Float.parseFloat(x),tn);
//        	al.add(new LevensteinClass(Float.parseFloat(x),tn));
//        	
//        	//Log.err("実行結果(LevensteinDistance("+tn0+", "+tn+"))：" + x);
//        }

        //System.out.println("実行結果(JaroWinklerDistance)：" + j_algo.getDistance(one,two));
//        Collections.sort(l, new StringComparator(StringComparator.DESC));
//        Collections.sort(l);
//        for (String value : l) {  
//            System.out.println(value);  
//        }  
        
        //Log.i("============================================");
    
//xxxxxx        
//        // ソートする
//        //HashMap hashmap = new HashMap();
////        Map<String, String> hashmap = new HashMap<String, String>();
////        hashmap.put( "15", "黄" );
////        hashmap.put( "10", "紫" );
////        hashmap.put( "17", "緑" );
//        ArrayList entries = new ArrayList(hashmap.entrySet());
//        Collections.sort(entries, new Comparator(){
//            public int compare(Object obj1, Object obj2){
//                Map.Entry ent1 =(Map.Entry)obj1;
//                Map.Entry ent2 =(Map.Entry)obj2;
//                String val1 = (String) ent1.getValue();
//                String val2 = (String) ent2.getValue();
//                return val1.compareTo(val2);
//            }
//        });
//        for (Float key : hashmap.keySet()) {
//        	System.out.println(key + " = " + hashmap.get(key));
//        }
        
        
        /*** descending sort ***/
        //descending sort
        Collections.sort(al, new LevensteinComparator());
        Collections.reverse(al);
        /***********************/
        
        String sortedList = "";
        Iterator<LevensteinClass> it = al.iterator();
        while (it.hasNext()) {
        	LevensteinClass data = it.next();
        	sortedList += data.getTableName()+", ";
            //System.out.println(data.getLevensteinDistance() + ": " + data.getTableName());
        }
        if(!sortedList.equals(""))  sortedList = sortedList.substring(0, sortedList.length()-2);

        
        //TODO: 同じ値のものはアルファベット順にソート
        
        
        return sortedList;
	}
	public static class LevensteinClass {
	    private float levensteinDistance;
	    private String tableName;

	    //Constructor
	    public LevensteinClass(float f, String tableName) {
	        this.levensteinDistance = f;
	        this.tableName = tableName;
	    }
	    public float getLevensteinDistance(){
	        return this.levensteinDistance;
	    }
	    public String getTableName(){
	        return this.tableName;
	    }
	}
	public static class LevensteinComparator implements Comparator<LevensteinClass> {
	    //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
	    public int compare(LevensteinClass a, LevensteinClass b) {
	        float f1 = a.getLevensteinDistance();
	        float f2 = b.getLevensteinDistance();

	        //ascending sort
	        if (f1 > f2) {
	            return 1;
	        } else if (f1 == f2) {
	            return 0;
	        } else {
	            return -1;
	        }
	    }
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
    //added by goto 20131016 end

}
//added by goto 20131016 end