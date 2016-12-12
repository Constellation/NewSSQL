/*
 * Created on 2004/07/25
 */
package supersql.codegenerator.VR;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.stringtemplate.v4.compiler.STParser.ifstat_return;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Jscss;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.common.Utils;
import supersql.extendclass.ExtList;

public class VRG3 extends Grouper {

	private String backfile = new String();
	private int countinstance = 0;

	private VREnv html_env;

	private VREnv html_env2;
	int count = 0;			// 20140526_masato

	// ���󥹥ȥ饯��
	public VRG3(Manager manager, VREnv henv, VREnv henv2) {
		this.html_env = henv;
		this.html_env2 = henv2;
	}

//	private void setLinkButton() {
//		
//		String nextfile = new String();
//		nextfile = html_env.linkOutFile
//				+ String.valueOf(html_env.countFile + 1) + ".html";
//		html_env.code.append("<DIV class=\"linkbutton "
//				+ VREnv.getClassID(tfe) + "\">\n");
//		if (countinstance > 1) {
//			html_env.code.append("<A href=\"" + backfile + "\">");
//			html_env.code.append("[back]");
//			html_env.code.append("</A>\n");
//		}
//		if (this.hasMoreItems()) {
//			html_env.code.append("<A href=\"" + nextfile + "\">");
//			html_env.code.append("[next]");
//			html_env.code.append("</A>\n");
//		}
//		//html_env.code.append("</div>\n");
//
//		// html_env.addLinkButtonCSS();
//
//	}

	@Override
	public String getSymbol() {
		return "HTMLG3";
	}

	// G3��work�᥽�å�
	@Override
	public String work(ExtList data_info) {

		
//		String parentfile = html_env.fileName;
//		String parentnextbackfile = html_env.nextBackFile;
//		StringBuffer parentcode = html_env.code;
//		StringBuffer parentcss = html_env.css;
//		StringBuffer parentheader = html_env.header;
//		StringBuffer parentfooter = html_env.footer;
//		String parentfile2 = html_env2.fileName;
//		String parentnextbackfile2 = html_env2.nextBackFile;
//		StringBuffer parentcode2 = html_env2.code;
//		StringBuffer parentcss2 = html_env2.css;
//		StringBuffer parentheader2 = html_env2.header;
//		StringBuffer parentfooter2 = html_env2.footer;
		Log.out("------- G3 -------");

//		html_env.css = new StringBuffer();
//		html_env.header = new StringBuffer();
//		html_env.footer = new StringBuffer();
//		html_env2.css = new StringBuffer();
//		html_env2.header = new StringBuffer();
//		html_env2.footer = new StringBuffer();
		//html_env.gLevel = 0;
		this.setDataList(data_info);

		if(html_env.gLevel == 0){
			//VRAttribute.floorflag = 3;
			VRAttribute.floorarray.add(3);
		}
		if(html_env.gLevel == 1){
			//VRAttribute.exhflag = true;
			VRAttribute.exharray.add(3);
			//System.out.println("yeahhhhhhh3");
		}
		
		//System.out.println("<G3front>");
		VRAttribute.gjudge++;
		
		while (this.hasMoreItems()==true) {/////////////////////////////////////////////////////////////////////////while here
			//////////////////////////G22//////////////////////////
			VRAttribute.genre = "";

			count++;
			VRAttribute.seq = 0;//n2 kotani
			
			html_env.gLevel++;
			Log.out("selectFlg" + VREnv.getSelectFlg());
			Log.out("selectRepeatFlg" + VREnv.getSelectRepeat());
			Log.out("formItemFlg" + VREnv.getFormItemFlg());
			
			String classid = VREnv.getClassID(tfe);

			if (GlobalEnv.isOpt() && !VREnv.getSelectRepeat()) {
				html_env2.code.append("<tfe type=\"repeat\" dimension=\"2\"");
				html_env2.code.append(" border=\"" + html_env.tableBorder
						+ "\"");

				if (decos.containsKey("tablealign"))
					html_env2.code.append(" align=\""
							+ decos.getStr("tablealign") + "\"");
				if (decos.containsKey("tablevalign"))
					html_env2.code.append(" valign=\""
							+ decos.getStr("tablevalign") + "\"");

				if (decos.containsKey("class")) {
					// class=menu�Ȃǂ̎w�肪��������t��
					html_env2.code.append(" class=\"");
					html_env2.code.append(decos.getStr("class") + " ");
				}
				if (html_env.writtenClassId.contains(VREnv.getClassID(this))) {
					// TFE10000�Ȃǂ̎w�肪��������t��
					if (decos.containsKey("class")) {
						html_env2.code.append(VREnv.getClassID(this) + "\"");
					} else {
						html_env2.code.append(" class=\""
								+ VREnv.getClassID(this) + "\"");
					}
				} else if (decos.containsKey("class")) {
					html_env2.code.append("\"");
				}

				if (decos.containsKey("tabletype")) {
					html_env2.code.append(" tabletype=\""
							+ decos.getStr("tabletype") + "\"");
					if (decos.containsKey("cellspacing")) {
						html_env2.code.append(" cellspacing=\""
								+ decos.getStr("cellspacing") + "\"");
					}
					if (decos.containsKey("cellpadding")) {
						html_env2.code.append(" cellpadding=\""
								+ decos.getStr("cellpadding") + "\"");
					}
				}
				html_env2.code.append(">");
			}

			this.worknextItem();

			if (html_env.notWrittenClassId.contains(classid)
					&& html_env.code.indexOf(classid) >= 0) {
				html_env.code.delete(html_env.code.indexOf(classid),
						html_env.code.indexOf(classid) + classid.length() + 1);
			}

			if (VREnv.getSelectRepeat()) {

			} else {
				// chie
				html_env2.code.append("</tfe>");
			}
			
			html_env.gLevel--;
			

		
		}
		
		for(int l=0; l<VRAttribute.elearray.size();l++){///n2 kotani
			//System.out.println("keio= "+" " +l+" " + VRAttribute.elearray.get(l));
			html_env.code.append("<n2 seq=\""+l+"\">\n" );
			//System.out.println("yoo="+VRAttribute.elearray.get(l));
			html_env.code.append(VRAttribute.elearray.get(l));
			html_env.code.append("</n2>\n" );			
		}
		VRAttribute.elearray.clear();//初期化
		VRAttribute.seq = 0;//初期化
		
		//System.out.println("</G3back>");
		if(VRAttribute.gjudge==1){
			VRAttribute.billnum++;
		}
		VRAttribute.gjudge--;
	

			
			/////////////////////////G22end//////////////////////
			
//			System.out.println("yaaaaa");
//			//////////////////////G2//////////////////////////////
//
//			//html_env.code.append("b="+html_env.gLevel);
//			VRAttribute.genre = "";
//			//if(html_env.gLevel == 1){
//			VRAttribute.g3flag = true;
//			//}
//			// 20140528_masato
//			count++;
//			
//			html_env.gLevel++;
//			Log.out("selectFlg" + VREnv.getSelectFlg());
//			Log.out("selectRepeatFlg" + VREnv.getSelectRepeat());
//			Log.out("formItemFlg" + VREnv.getFormItemFlg());
//			//html_env.code.append("c="+html_env.gLevel);
//			//html_env.code.append(html_env.gLevel);
//			
//			if (VREnv.getSelectRepeat()) {// if form_select
//				// null
//				// in case "select" repeat : not write "<TR><TD>" between
//				// "<option>"s
//			} else {
//				// 20140613_masato
////				if(i != 0 && counter % i != 0 && j != 1){
////					
////				} else {
////					html_env.code.append("<TR><TD class=\""
////							+ VREnv.getClassID(tfe) + " nest\">\n");
////					Log.out("<TR><TD class=\"" + VREnv.getClassID(tfe)
////							+ " nest\">");
////				}
//				
////				counter++;
//			}
//			String classid = VREnv.getClassID(tfe);
//
//			if (GlobalEnv.isOpt() && !VREnv.getSelectRepeat()) {
//				html_env2.code.append("<tfe type=\"repeat\" dimension=\"2\"");
//				html_env2.code.append(" border=\"" + html_env.tableBorder
//						+ "\"");
//
//				if (decos.containsKey("tablealign"))
//					html_env2.code.append(" align=\""
//							+ decos.getStr("tablealign") + "\"");
//				if (decos.containsKey("tablevalign"))
//					html_env2.code.append(" valign=\""
//							+ decos.getStr("tablevalign") + "\"");
//
//				if (decos.containsKey("class")) {
//					// class=menu�Ȃǂ̎w�肪��������t��
//					html_env2.code.append(" class=\"");
//					html_env2.code.append(decos.getStr("class") + " ");
//				}
//				if (html_env.writtenClassId.contains(VREnv.getClassID(this))) {
//					// TFE10000�Ȃǂ̎w�肪��������t��
//					if (decos.containsKey("class")) {
//						html_env2.code.append(VREnv.getClassID(this) + "\"");
//					} else {
//						html_env2.code.append(" class=\""
//								+ VREnv.getClassID(this) + "\"");
//					}
//				} else if (decos.containsKey("class")) {
//					html_env2.code.append("\"");
//				}
//
//				if (decos.containsKey("tabletype")) {
//					html_env2.code.append(" tabletype=\""
//							+ decos.getStr("tabletype") + "\"");
//					if (decos.containsKey("cellspacing")) {
//						html_env2.code.append(" cellspacing=\""
//								+ decos.getStr("cellspacing") + "\"");
//					}
//					if (decos.containsKey("cellpadding")) {
//						html_env2.code.append(" cellpadding=\""
//								+ decos.getStr("cellpadding") + "\"");
//					}
//				}
//				html_env2.code.append(">");
//			}
//
//			this.worknextItem();
//
//			if (html_env.notWrittenClassId.contains(classid)
//					&& html_env.code.indexOf(classid) >= 0) {
//				html_env.code.delete(html_env.code.indexOf(classid),
//						html_env.code.indexOf(classid) + classid.length() + 1);
//			}
//
//			if (VREnv.getSelectRepeat()) {
//
//			} else {
//				// chie
//				html_env2.code.append("</tfe>");
////				if(i != 0 && counter % i != 0 && j != 1){
////					
////				} else {
////					html_env.code.append("</TD>\n");////</TR>消した
////					Log.out("</TD>");////</TR>消した
////				}
//			}
//			
//			// 20140528_masato
////			if(retFlag){
////				if(i != 0){
////					if(count % i == 0){
////						html_env.code.append("</TABLE></TD>");
////						if(!this.hasMoreItems()){
////							flag = true;
////							html_env.code.append("</TR>");
////						} else {
////							html_env.code.append("<TD>\n");
////							html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
////							html_env.code.append(html_env.tableBorder + "\" ");
////							html_env.code.append("class=\"");
////							html_env.code.append("nest\"");
////							html_env.code.append(html_env.getOutlineMode());
////							html_env.code.append(">");		
////						}
////					}
////				}
////			}
//			
////			if(pageFlag){
////				if(count % i == 0){
////					count2++;
// //					if(counter % i != 0 && j != 1){
////						
////					} else {
////						html_env.code.append("</TABLE></TD>");
////					}
////					if(!this.hasMoreItems()){
////						flag = true;
////						html_env.code.append("</TR>");
////					}
////					if(count2 % j == 0 && this.hasMoreItems()){
////						
////						html_env.code.append("</TR></TABLE>");
////						html_env.code.append("</div>\n");
////						html_env.code.append("<div class=\"result\">\n");
////						html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
////						html_env.code.append(html_env.tableBorder + "\" ");
////						html_env.code.append("class=\"");
////						html_env.code.append("nest\"");
////						html_env.code.append(">");
////						html_env.code.append("<TR><TD class=\""	+ VREnv.getClassID(tfe) + " nest\">\n");
////						// 20140613_masato
////						if(counter % i != 0 && j != 1){
////							
////						} else {
////							html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
////							html_env.code.append(html_env.tableBorder + "\" ");
////							html_env.code.append("class=\"");
////							html_env.code.append("nest\"");
////							html_env.code.append(html_env.getOutlineMode());
////							html_env.code.append(">");
////						}
////					} else {
////						html_env.code.append("<TD>\n");
////						html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
////						html_env.code.append(html_env.tableBorder + "\" ");
////						html_env.code.append("class=\"");
////						html_env.code.append("nest\"");
////						html_env.code.append(html_env.getOutlineMode());	
////						html_env.code.append(">");
////					}
////				}
////			}
//			
//			html_env.gLevel--;
//
//		
//			
//			//////////////////////G2///////////////////////////////
//			//html_env.gLevel++;

//			html_env.code = new StringBuffer();
//			html_env2.code = new StringBuffer();

			/*
			 * ����Foreach func�Ǥʤ��?鐃緒申鐃緒申鐃縮わ申G3
			 */
//			if (!html_env.foreachFlag) {
//				backfile = html_env.nextBackFile;
//				html_env.countFile++;
//				countinstance++;
//				html_env.fileName = html_env.outFile
//						+ String.valueOf(html_env.countFile) + ".html";
//				html_env.nextBackFile = html_env.linkOutFile
//						+ String.valueOf(html_env.countFile) + ".html";
//			}

//			html_env.setOutlineMode();
//			this.worknextItem();
			
//
//			if (!html_env.foreachFlag) {
//				setLinkButton();
//			}
			//html_env.gLevel--;
			//html_env.getHeader();
//			html_env.getFooter();
//			//html_env2.header.append("<?xml version=\"1.0\" encoding=\""+ Utils.getEncode() + "\"?><SSQL>");
//			html_env2.header.append("<?xml version=\"1.0\"?>");//上の行をこれに変更
////			html_env2.footer.append("</SSQL>");
/*
			try {
				// changed by goto 20120715_2 start
				// This is for 'link/foreach'.
				// PrintWriter pw2 = new PrintWriter(new BufferedWriter(new
				// FileWriter(
				// html_env.fileName)));
				PrintWriter pw;
				if (html_env.charset != null) {
					pw = new PrintWriter(new BufferedWriter(
							new OutputStreamWriter(new FileOutputStream(
									html_env.fileName), html_env.charset)));
					// Log.info("File encoding: "+html_env.charset);
				} else
					pw = new PrintWriter(new BufferedWriter(new FileWriter(
							html_env.fileName)));
				// Log.info("File encoding: "+((html_env.charset!=null)?
				// html_env.charset : "UTF-8"));
				// changed by goto 20120715_2 end
				pw.println(html_env.header);
				pw.println(html_env.code);
				pw.println(html_env.footer);
				pw.close();
//				if (GlobalEnv.isOpt()) {
//					html_env2.fileName = html_env.fileName.substring(0,
//							html_env.fileName.lastIndexOf(".html")) + ".xml";
//					// changed by goto 20120715_2 start
//					// PrintWriter pw2 = new PrintWriter(new BufferedWriter(new
//					// FileWriter(
//					// html_env2.filename)));
//					PrintWriter pw2;
//					if (html_env.charset != null) {
//						pw2 = new PrintWriter(new BufferedWriter(
//								new OutputStreamWriter(new FileOutputStream(
//										html_env2.fileName), html_env.charset)));
//						// Log.info("File encoding: "+html_env.charset);
//					} else
//						pw2 = new PrintWriter(new BufferedWriter(
//								new FileWriter(html_env2.fileName)));
//					// Log.info("File encoding: "+((html_env.charset!=null)?
//					// html_env.charset : "UTF-8"));
//					// changed by goto 20120715_2 end
//
//					pw2.println(html_env2.header);
//					pw2.println(html_env2.code);
//					pw2.println(html_env2.footer);
//					pw2.close();
//					VRoptimizer xml = new VRoptimizer();
//					String xml_str = xml.generateHtml(html_env2.fileName);
//					pw = new PrintWriter(new BufferedWriter(new FileWriter(
//							html_env.fileName)));
//					pw.println(html_env.header);
//					pw.println(xml_str);
////					StringBuffer footer = new StringBuffer(
////							"</div></body></html>");
////					pw.println(footer);
//					pw.close();
//				}
				html_env.header = new StringBuffer();
				//Jscss.process();	//masato 20141231
				html_env.footer = new StringBuffer();
				html_env2.header = new StringBuffer();
				html_env2.footer = new StringBuffer();
			} catch (FileNotFoundException fe) {
//				System.err.println("Error: specified outdirectory \""
//						+ html_env.outDir + "\" is not found");
				Log.err("Error: specified outdirectory \""
						+ html_env.outDir + "\" is not found");
//				GlobalEnv.errorText += "Error: specified outdirectory \""
//						+ html_env.outDir + "\" is not found";
				GlobalEnv.addErr("Error: specified outdirectory \""
						+ html_env.outDir + "\" is not found");
				// comment out by chie
				// System.exit(-1);
			} catch (IOException e) {
				Log.err("Error[HTMLG3]: File IO Error in HTMLG3");
//				GlobalEnv.errorText += "Error[HTMLG3]: File IO Error in HTMLG3";
				e.printStackTrace();
				GlobalEnv.addErr("Error[HTMLG3]: File IO Error in HTMLG3");
				// comment out by chie
				// System.exit(-1);
			}*/
			
			
	
	


//		html_env.fileName = parentfile;
//		html_env.code = parentcode;
//		html_env.css = parentcss;
//		html_env.header = parentheader;
//		html_env.footer = parentfooter;
//		html_env.nextBackFile = parentnextbackfile;
//		html_env2.fileName = parentfile2;
//		html_env2.code = parentcode2;
//		html_env2.css = parentcss2;
//		html_env2.header = parentheader2;
//		html_env2.footer = parentfooter2;
//		html_env2.nextBackFile = parentnextbackfile2;

		//Log.out("TFEId = " + VREnv.getClassID(this));
		//html_env.append_css_def_td(VREnv.getClassID(this), this.decos);
		if(html_env.gLevel == 0){
			
			//VRAttribute.gjoinflag = 3;
			html_env.code.append("</group>\n");
			VRAttribute.grouptag++;
//			if(VRAttribute.grouptag < VRAttribute.cjoinarray.size()+1){
				html_env.code.append("<group>\n");
//			}
			VRAttribute.genrearray22.add(VRAttribute.genrecount);
//			new VRManager(html_env, html_env2).xmlcreate();
//			VRManager.i++;
			
		}

		
		return null;

	}
	
	
}
