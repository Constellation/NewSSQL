package supersql.ctab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import supersql.FrontEnd;
import supersql.codegenerator.Ehtml;
import supersql.codegenerator.Incremental;
import supersql.common.DB;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.common.Suggest;
import supersql.db.ConnectDB;
import supersql.extendclass.ExtList;
import supersql.parser.FromParse;
import supersql.codegenerator.Mobile_HTML5.Mobile_HTML5;

public class RetAtts {
	//この中では属性を取り出してきます
	//データベースに接続して結果を受け取り
	//リストに入れてみよう
	//それを元に枠組みを作る
	//データベースには入っているのに検索には引っかからない値を取りこぼさないようにするため
	/*           id | name    | age  |  pref
	 * 			　1 | tabata  |  12  |   1
	 * 			　2 | bataba  |  12  |   2
	 * 			　3 | atsuto  |  11  |   1
	 * 			　4 | tsutom  |  12  |   3
	 * 			　5 | tomoto  |  11  |   2
	 * 			　6 | tomato  |  11  |   3
	 */
	
	public void retAtts(ExtList tfe1, ExtList tfe2, ArrayList<String> top_atts, ArrayList<String> side_atts){
		try{
			// JDBCドライバの登録
			String driver = "org.postgresql.Driver";
			// データベースの指定
			String server   = "localhost";   // PostgreSQL サーバ ( IP または ホスト名 )
			String dbname   = "ctab";         // データベース名
			String url = "jdbc:postgresql://" + server + "/" + dbname;
			String user     = "tabata";         //データベース作成ユーザ名
			String password = "";     //データベース作成ユーザパスワード
			Class.forName (driver);
			// データベースとの接続
			Connection con = DriverManager.getConnection(url, user, password);
			Connection con2 = DriverManager.getConnection(url, user, password);
			// テーブル照会実行
			Statement stmt = con.createStatement ();
			Statement stmt2 = con2.createStatement ();
			System.err.println("1111111"+tfe1.unnest());
			//上の属性で値に影響を及ぼす属性を抽出
			StringBuffer buf = new StringBuffer();
			boolean p_flag = false;
			for(int k = 0; k < tfe1.unnest().size(); k++){
				if(tfe1.unnest().get(k).equals("]")){
					if(tfe1.unnest().get(k + 1).equals(",")){
						int count = 1;
						int l = 0;
						for(l = k - 1; l > 0; l--){
//							System.err.println(count+" " + tfe1.unnest().get(l));
							
							if(tfe1.unnest().get(l).equals("]")){
								count++;
							}
							if(tfe1.unnest().get(l).equals("[")){
								count--;
							}
							if(count == 0){
								break;
							}
						}
						for(int j = l; j < tfe1.unnest().size(); j++){
							
							if(tfe1.unnest().get(j).equals("table_alias")){
								buf.append(tfe1.unnest().get(j + 2).toString());
								buf.append(".");
								buf.append(tfe1.unnest().get(j + 6));
								break;
							}else if (tfe1.unnest().get(j).equals("column_name")){
								buf.append(tfe1.unnest().get(j + 2).toString());
								break;
							}
						}
//						System.err.println(buf);
						p_flag = true;
						break;
					}
				}
			}
			int m  = 0;
			if(!p_flag){
				while(m < tfe1.unnest().size()){
					if(tfe1.unnest().get(m).equals("table_alias")){
					buf.append(tfe1.unnest().get(m + 2).toString());
					buf.append(".");
					buf.append(tfe1.unnest().get(m + 6));
					break;
					}else if (tfe1.unnest().get(m).equals("column_name")){
					buf.append(tfe1.unnest().get(m + 2).toString());
					break;
					}
					m++;
				}
			}
			String top_att = buf.toString();
//			System.err.println("flag:"+p_flag);
			//sideの属性の抽出
			StringBuffer buf2 = new StringBuffer();
			boolean p_flag2 = false;
			for(int k = 0; k < tfe2.unnest().size(); k++){
				if(tfe2.unnest().get(k).equals("]")){
					if(tfe2.unnest().get(k + 1).equals("!")){
						int count = 1;
						int l = 0;
						for(l = k - 1; l > 0; l--){
//							System.err.println(count+" " + tfe1.unnest().get(l));
							
							if(tfe2.unnest().get(l).equals("]")){
								count++;
							}
							if(tfe2.unnest().get(l).equals("[")){
								count--;
							}
							if(count == 0){
								break;
							}
						}
						for(int j = l; j < tfe2.unnest().size(); j++){
							
							if(tfe2.unnest().get(j).equals("table_alias")){
								buf2.append(tfe2.unnest().get(j + 2).toString());
								buf2.append(".");
								buf2.append(tfe2.unnest().get(j + 6));
								break;
							}else if (tfe2.unnest().get(j).equals("column_name")){
								buf2.append(tfe2.unnest().get(j + 2).toString());
								break;
							}
						}
//						System.err.println(buf);
						p_flag2 = true;
						break;
					}
				}
			}
			int n  = 0;			
//			System.err.println("22222 "+tfe2.unnest());
			if(!p_flag2){
				while(n < tfe2.unnest().size()){
					if(tfe2.unnest().get(n).equals("table_alias")){
					buf2.append(tfe2.unnest().get(n + 2).toString());
					buf2.append(".");
					buf2.append(tfe2.unnest().get(n + 6));
					break;
					}else if (tfe2.unnest().get(n).equals("column_name")){
					buf2.append(tfe2.unnest().get(n + 2).toString());
					break;
					}
					n++;
				}
			}
			String side_att = buf2.toString();
			System.err.println("top "+top_att);
			System.err.println("side "+side_att);
			String sql1 = "SELECT " + top_att + " FROM student s";
			String sql2 = "SELECT " + side_att + " FROM prefecture p";
			ResultSet rs1 = stmt.executeQuery (sql1);
			ResultSet rs2 = stmt2.executeQuery (sql2);
			// テーブル照会結果を出力
			while(rs1.next()){
				String[] tatt = top_att.toString().split("\\.", 0);
				if(top_atts.indexOf(rs1.getString(tatt[1])) == -1){
					top_atts.add(rs1.getString(tatt[1]));
				}	
			}	
			while(rs2.next()){
				String[] satt = side_att.toString().split("\\.", 0);
				if(side_atts.indexOf(rs2.getString(satt[1])) == -1){
					side_atts.add(rs2.getString(satt[1]));
				}	
			}
			 //データベースのクローズ
			rs1.close();
			rs2.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.err.println("SQL failed.");
			e.printStackTrace ();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace ();
		}	
	}
}
