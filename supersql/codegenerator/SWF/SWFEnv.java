/*
 * Created on 2004/11/26 by mai
 */
package supersql.codegenerator.SWF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pdflib.PDFlibException;
import com.pdflib.pdflib;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;

public class SWFEnv extends LocalEnv {
	pdflib p;
	String outdir = GlobalEnv.getoutdirectory();
//	String filename = GlobalEnv.getoutfilename();
//	String outdir = "test_";
	String filename = "test";
	int movieWidth = 200;
	int movieHeight = 200;
	int rate = 20;
	int duration = 3000;
	int offset = 20;
	int fontSize = 14;
	String movieBgcolor = "0xff,0xff,0xff";
	//morya wrote
	static StringBuffer tname = new StringBuffer();
	static StringBuffer tdata = new StringBuffer();
	static StringBuffer tx = new StringBuffer();
	static StringBuffer ty = new StringBuffer();
	static StringBuffer tw = new StringBuffer();
	static StringBuffer th = new StringBuffer();
	static StringBuffer tcolor = new StringBuffer();
	static StringBuffer tsize = new StringBuffer();
	static StringBuffer timefrom = new StringBuffer();
	static StringBuffer timeto = new StringBuffer();
	ArrayList durationArray = new ArrayList();
	//morya kokomade

//	2007.12.16 tomo
	String controller = null;
	String texttype = null;
	int font;
// 2007.12.16 tomo
//	String fontname = "HeiseiKakuGo-W5";
//	String fontname = "KozMinPro-Regular-Acro";
	String fontname = "Helvetica-Bold";
//	String encoding = "UniJIS-UCS2-H";
//	String encoding = "UniJIS-UTF16-H";
	String encoding = "unicode";

	int def_x = 10;
	int def_y = 10;
//	int def_y = 20;
	int margin = 6;
	int border = 1;
	int instanceID = 10000;
	int interactionNUM = 0;
	int interactionImgNUM = 0;
	int visibleflag_counter = 0;
	int visibleflag_count = 0;
	int [][] int_config = new int[500][6];
	int cthree_flag = -1;
	int cthree_string = 0;
	int cthree_func = 0;

	StringBuffer function = new StringBuffer();
	StringBuffer controlAS = new StringBuffer();
	StringBuffer header = new StringBuffer();
	StringBuffer footer = new StringBuffer();
	StringBuffer allFrame = new StringBuffer();


	boolean dynamicFlag = false;
	boolean loopFlag = true;
	boolean containImg = false;
	//morya wrote
	String transition = "false";
	String mode = "static";
	String telop = "false";
	String telopx = "false";
	String telopy = "false";
	String telopw = "false";
	String teloph = "false";
	String telopcolor = "false";
	String telopsize = "false";
	String teloptimefrom = "false";
	String teloptimeto = "false";
	String music = "false";
	String dduration = "false";
	//morya kokomade

	int tmp_width;
	int tmp_height;

	int level=0;

	SWFValue final_value;
	//System.out.println("waai "+GlobalEnv.table_name);

	public SWFEnv() {
		/*try {
			p = new pdflib();
		} catch (PDFlibException e) {
			System.err.print("PDFlib exception occurred in hello sample:\n");
			System.err.print("[" + e.get_errnum() + "] " + e.get_apiname()
					+ ": " + e.getMessage() + "\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}*/
	}


	public void loadPDFfont() {
		try {

			if (p.begin_document("tmp", "") == -1) {
				System.err.println("Couldn't open dummy PDF file");
				System.exit(1);
			}
//			2007.12.16 tomo
			font = p.load_font(fontname, encoding, "");
//			font = p.load_font("Helvetica-Bold", "unicode", "");

		} catch (PDFlibException e) {
			System.err.print("PDFlib exception occurred in SWFEnv.loadPDFfont():\n");
			System.err.print("[" + e.get_errnum() + "] " + e.get_apiname()
					+ ": " + e.getMessage() + "\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public int stringWidth(String data, int fontsize) {
		int data_width = 0;

		try {
			System.out.println("This is PDFlib:font = " + font);
			data_width = (int) Math.ceil(p.stringwidth(data, font, fontsize)*1.02); 

		} catch (PDFlibException e) {
			System.err.print("PDFlib exception occurred in SWFEnv.stringWidth():\n");
			System.err.print("[" + e.get_errnum() + "] " + e.get_apiname()
					+ ": " + e.getMessage() + "\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return data_width;
	}

	public int get_value(String key, int num){
		int value = 0;
		try {

			if(num!=-1)
				value = (int)Math.ceil(p.get_value(key, num));

		} catch (PDFlibException e) {
			System.err.print("PDFlib exception occurred in SWFEnv.getValue():\n");
			System.err.print("[" + e.get_errnum() + "] " + e.get_apiname()
					+ ": " + e.getMessage() + "\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return value;
	}

	public int open_image_file(String type,String filename){
		int img = 0;

		try {
			img = p.load_image(type, filename, "");
		} catch (PDFlibException e) {
			System.err.print("PDFlib exception occurred in SWFEnv.open_image_file():\n");
			System.err.print("[" + e.get_errnum() + "] " + e.get_apiname()
					+ ": " + e.getMessage() + "\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return img;
	}

	public void alternateColors(SWFValue self, String color1, String color2){
		SWFValue child;
		int i=0;

		while(i < self.inList.size()){
			child = (SWFValue) self.inList.get(i);
			if(i%2 == 0 && (self.type.equals("G2")||self.type.equals("G1")||self.type.equals("Att")||self.type.equals("Func")))
				child.bgcolor = color1;
			else if(i%2 != 0 && (self.type.equals("G2")||self.type.equals("G1")||self.type.equals("Att")||self.type.equals("Func")))
				child.bgcolor = color2;

			if(self.type.equals("C1")||self.type.equals("C2"))
				child.bgcolor = self.bgcolor;

			alternateColors(child,color1,color2);

			i++;
		}
	}



	public void getDecos(DecorateList decos){
		Log.out("[SWFEnv:getDecos]decos = " + decos);

		String loopStr;

		if (decos.containsKey("background-color"))
			movieBgcolor = decos.getStr("background-color");
		if (decos.containsKey("bgcolor"))
			movieBgcolor = decos.getStr("bgcolor");

		if (decos.containsKey("width"))
			movieWidth = Integer.parseInt(decos.getStr("width"));

		if (decos.containsKey("height"))
			movieHeight = Integer.parseInt(decos.getStr("height"));

		if (decos.containsKey("rate"))
			rate = Integer.parseInt(decos.getStr("rate"));
		if (decos.containsKey("framerate"))
			rate = Integer.parseInt(decos.getStr("framerate"));

		if (decos.containsKey("duration"))
			duration = Integer.parseInt(decos.getStr("duration"));
		if (decos.containsKey("delay"))
			duration = Integer.parseInt(decos.getStr("delay"));

		// offset
		if (decos.containsKey("offset"))
			offset = Integer.parseInt(decos.getStr("offset"));

		// loop
		if (decos.containsKey("loop")){
			loopStr = decos.getStr("loop");
			if(loopStr.equals("true") || loopStr.equals("yes")) loopFlag = true;
			if(loopStr.equals("false") || loopStr.equals("no")) loopFlag = false;
		}

		// dynamic
		if (decos.containsKey("mode")){
			mode = decos.getStr("mode");
			if(mode.equalsIgnoreCase("dynamic")) dynamicFlag = true;
			if(mode.equalsIgnoreCase("static")) dynamicFlag = false;
			System.out.println("generate mode = " + mode);
		}

		// transition
		if (decos.containsKey("transition"))
			transition = decos.getStr("transition");

		// controller
		if (decos.containsKey("controller")) {
			controller = decos.getStr("controller");
		}
		// texttype
		if (decos.containsKey("texttype")) {
			texttype = decos.getStr("texttype");
		}

		//dynamic-duration  morya wrote
		if (decos.containsKey("dynamic-duration")){
			dduration = decos.getStr("dynamic-duration");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql = "SELECT " + dduration + " FROM " + "cd_duration d;";
	    		Log.out(sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		while(rs.next()){
	    			String dname = rs.getString(dduration);
	    			int name = Integer.parseInt(dname);
	    			if(dname==null){
	    				durationArray.add(3000);
	    			}else {
	    				durationArray.add(name);
	    			}
	    		}
	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    		Log.out(durationArray + "******sekaide*****" + durationArray.size());

	    	//durationArray.add("a");
	    	//arrayList.add(3.str)
	    	//arrayList.get(2)
	    	//arrayList.size()

		}


		// telop   morya wrote
	    if (decos.containsKey("telop")){
	    	telop = decos.getStr("telop");
	    	Log.out("aaaaaa" + telop);
	    	tdata.append("$tstr = array(");
	    	tname.append("$tname = array(");
	    	tx.append("$tx = array(");
		    ty.append("$ty = array(");
		    tw.append("$tw = array(");
		    th.append("$th = array(");
		    tcolor.append("$tcolor = array(");
		    tsize.append("$tsize = array(");
		    timefrom.append("$timefrom = array(");
		    timeto.append("$timeto = array(");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql;
	    		if(GlobalEnv.where_line==null)
		    		sql = "SELECT DISTINCT " + telop + " FROM " + GlobalEnv.table_name + ";";
	    		else
	    			sql = "SELECT DISTINCT " + telop + " FROM " + GlobalEnv.table_name + " WHERE " + GlobalEnv.where_line + ";";
	    		Log.out("sql++++"+sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		int i=10000;
	    		while(rs.next()){
	    			String name = rs.getString(telop);
	    			tdata.append("\"");
	    			tdata.append(name);
	    			tdata.append("\",");
	    			i++;
	    			tname.append("\"tlp");
	    			tname.append(i);
	    			tname.append("\",");
	    		}
	    		i -= 10000;
	    		for(int j=1;j<=i;j++){
	    			tx.append("\"");
	    			tx.append("10");
	    			tx.append("\",");

	    			ty.append("\"");
	    			ty.append("10");
	    			ty.append("\",");

	    			tw.append("\"");
	    			tw.append("350");
	    			tw.append("\",");

	    			th.append("\"");
	    			th.append("50");
	    			th.append("\",");

	    			tcolor.append("\"");
	    			tcolor.append("0x000000");
	    			tcolor.append("\",");

	    			tsize.append("14,");

	    			timefrom.append("0,");

	    			timeto.append("-1,");
	    		}
	    		tdata.deleteCharAt(tdata.length()-1).append(");\n");
	    		tname.deleteCharAt(tname.length()-1).append(");\n");
	    		tx.deleteCharAt(tx.length()-1).append(");\n");
	    		ty.deleteCharAt(ty.length()-1).append(");\n");
	    		tw.deleteCharAt(tw.length()-1).append(");\n");
	    		th.deleteCharAt(th.length()-1).append(");\n");
	    		tcolor.deleteCharAt(tcolor.length()-1).append(");\n");
	    		tsize.deleteCharAt(tsize.length()-1).append(");\n");
	    		timefrom.deleteCharAt(timefrom.length()-1).append(");\n");
	    		timeto.deleteCharAt(timeto.length()-1).append(");\n\n");
	    		//timeto = new StringBuffer();

	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    if (decos.containsKey("telop-x")){
	    	telopx = decos.getStr("telop-x");
	    	tx = new StringBuffer();
	    	tx.append("$tx = array(");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql;
	    		if(GlobalEnv.where_line==null)
		    		sql = "SELECT DISTINCT " + telopx + "," + telop + " FROM " + GlobalEnv.table_name + ";";
	    		else
	    			sql = "SELECT DISTINCT " + telopx + "," + telop + " FROM " + GlobalEnv.table_name + " WHERE " + GlobalEnv.where_line + ";";
	    		Log.out(sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		while(rs.next()){
	    			String name = rs.getString(telopx);
	    			tx.append("\"");
	    			if(name==null){
	    				tx.append("10");
	    			}else {
	    				tx.append(name);
	    			}
	    			tx.append("\",");
	    		}
	    		tx.deleteCharAt(tx.length()-1).append(");\n");
	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    if (decos.containsKey("telop-y")){
	    	telopy = decos.getStr("telop-y");
	    	ty = new StringBuffer();
	    	ty.append("$ty = array(");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql;
	    		if(GlobalEnv.where_line==null)
		    		sql = "SELECT DISTINCT " + telopy + "," + telop + " FROM " + GlobalEnv.table_name + ";";
	    		else
	    			sql = "SELECT DISTINCT " + telopy + "," + telop + " FROM " + GlobalEnv.table_name + " WHERE " + GlobalEnv.where_line + ";";
	    		Log.out(sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		while(rs.next()){
	    			String name = rs.getString(telopy);
	    			ty.append("\"");
	    			if(name==null){
	    				ty.append("10");
	    			}else {
	    				ty.append(name);
	    			}
	    			ty.append("\",");
	    		}
	    		ty.deleteCharAt(ty.length()-1).append(");\n");
	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    if (decos.containsKey("telop-w")){
	    	telopw = decos.getStr("telop-w");
	    	tw = new StringBuffer();
	    	tw.append("$tw = array(");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql;
	    		if(GlobalEnv.where_line==null)
		    		sql = "SELECT DISTINCT " + telopw + "," + telop + " FROM " + GlobalEnv.table_name + ";";
	    		else
	    			sql = "SELECT DISTINCT " + telopw + "," + telop + " FROM " + GlobalEnv.table_name + " WHERE " + GlobalEnv.where_line + ";";
	    		Log.out(sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		while(rs.next()){
	    			String name = rs.getString(telopw);
	    			tw.append("\"");
	    			if(name==null){
	    				tw.append("350");
	    			}else {
	    				tw.append(name);
	    			}
	    			tw.append("\",");
	    		}
	    		tw.deleteCharAt(tw.length()-1).append(");\n");
	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    if (decos.containsKey("telop-h")){
	    	teloph = decos.getStr("telop-h");
	    	th = new StringBuffer();
	    	th.append("$th = array(");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql;
	    		if(GlobalEnv.where_line==null)
		    		sql = "SELECT DISTINCT " + teloph + "," + telop + " FROM " + GlobalEnv.table_name + ";";
	    		else
	    			sql = "SELECT DISTINCT " + teloph + "," + telop + " FROM " + GlobalEnv.table_name + " WHERE " + GlobalEnv.where_line + ";";
	    		Log.out(sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		while(rs.next()){
	    			String name = rs.getString(teloph);
	    			th.append("\"");
	    			if(name==null){
	    				th.append("50");
	    			}else {
	    				th.append(name);
	    			}
	    			th.append("\",");
	    		}
	    		th.deleteCharAt(th.length()-1).append(");\n");
	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    if (decos.containsKey("telop-color")){
	    	telopcolor = decos.getStr("telop-color");
	    	tcolor = new StringBuffer();
	    	tcolor.append("$tcolor = array(");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql;
	    		if(GlobalEnv.where_line==null)
		    		sql = "SELECT DISTINCT " + telopcolor + "," + telop + " FROM " + GlobalEnv.table_name + ";";
	    		else
	    			sql = "SELECT DISTINCT " + telopcolor + "," + telop + " FROM " + GlobalEnv.table_name + " WHERE " + GlobalEnv.where_line + ";";
	    		Log.out(sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		while(rs.next()){
	    			String name = rs.getString(telopcolor);
	    			tcolor.append("\"");
	    			if(name==null){
	    				tcolor.append("0x000000");
	    			}else {
	    				tcolor.append(name);
	    			}
	    			tcolor.append("\",");
	    		}
	    		tcolor.deleteCharAt(tcolor.length()-1).append(");\n");
	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    if (decos.containsKey("telop-size")){
	    	telopsize = decos.getStr("telop-size");
	    	tsize = new StringBuffer();
	    	tsize.append("$tsize = array(");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql;
	    		if(GlobalEnv.where_line==null)
		    		sql = "SELECT DISTINCT " + telopsize + "," + telop + " FROM " + GlobalEnv.table_name + ";";
	    		else
	    			sql = "SELECT DISTINCT " + telopsize + "," + telop + " FROM " + GlobalEnv.table_name + " WHERE " + GlobalEnv.where_line + ";";
	    		Log.out(sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		while(rs.next()){
	    			String name = rs.getString(telopsize);
	    			if(name==null){
	    				tsize.append("14");
	    			}else {
	    				tsize.append(name);
	    			}
	    			tsize.append(",");
	    		}
	    		tsize.deleteCharAt(tsize.length()-1).append(");\n");
	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    if (decos.containsKey("timefrom")){
	    	teloptimefrom = decos.getStr("timefrom");
	    	timefrom = new StringBuffer();
	    	timefrom.append("$timefrom = array(");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql;
	    		if(GlobalEnv.where_line==null)
		    		sql = "SELECT DISTINCT " + teloptimefrom + "," + telop + " FROM " + GlobalEnv.table_name + ";";
	    		else
	    			sql = "SELECT DISTINCT " + teloptimefrom + "," + telop + " FROM " + GlobalEnv.table_name + " WHERE " + GlobalEnv.where_line + ";";
	    		Log.out(sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		while(rs.next()){
	    			String name = rs.getString(teloptimefrom);
	    			if(name==null){
	    				timefrom.append("0");
	    			}else {
	    				timefrom.append(name);
	    			}
	    			timefrom.append(",");
	    		}
	    		timefrom.deleteCharAt(timefrom.length()-1).append(");\n");
	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    if (decos.containsKey("timeto")){
	    	teloptimeto = decos.getStr("timeto");
	    	timeto = new StringBuffer();
	    	timeto.append("$timeto = array(");
	    	try{
	    		Class.forName("org.gjt.mm.mysql.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase","root","");
	    		Statement stmt = con.createStatement();
	    		String sql;
	    		if(GlobalEnv.where_line==null)
		    		sql = "SELECT DISTINCT " + teloptimeto + "," + telop + " FROM " + GlobalEnv.table_name + ";";
	    		else
	    			sql = "SELECT DISTINCT " + teloptimeto + "," + telop + " FROM " + GlobalEnv.table_name + " WHERE " + GlobalEnv.where_line + ";";
	    		Log.out(sql);
	    		ResultSet rs = stmt.executeQuery(sql);

	    		while(rs.next()){
	    			String name = rs.getString(teloptimeto);
	    			if(name==null){
	    				timeto.append("-1");
	    			}else {
	    				timeto.append(name);
	    			}
	    			timeto.append(",");
	    		}
	    		timeto.deleteCharAt(timeto.length()-1).append(");\n\n");
	    		stmt.close();
	    		con.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    if (decos.containsKey("music")){
	    	music = decos.getStr("music");
	    }
	    //morya kokomade

	}


	public static String getClassID(ITFE tfe) {
		return "TFE" + tfe.getId();
	}

}
