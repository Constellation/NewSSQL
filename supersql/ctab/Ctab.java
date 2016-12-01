package supersql.ctab;

import java.util.ArrayList;

import supersql.codegenerator.Manager;
import supersql.codegenerator.TFE;
import supersql.codegenerator.HTML.HTMLFactory;
import supersql.codegenerator.Mobile_HTML5.Mobile_HTML5Factory;
import supersql.codegenerator.PDF.PDFFactory;
import supersql.codegenerator.Web.WebFactory;
import supersql.codegenerator.X3D.X3DFactory;
import supersql.common.GlobalEnv;
import supersql.common.LevenshteinDistance;
import supersql.common.Log;
import supersql.common.ParseXML;
import supersql.extendclass.ExtList;
import supersql.parser.Preprocessor;
import supersql.parser.Start_Parse;

public class Ctab {

	public ExtList read_tfe(ExtList func_tfe){
		System.err.println("Ctab called!!!");
		System.err.println(func_tfe);
		int str = (int)func_tfe.size();
		ExtList tfe1 = (ExtList)func_tfe.get(2);
		ExtList tfe2 = (ExtList)func_tfe.get(4);
		ExtList tfe3 = (ExtList)func_tfe.get(6);
		ExtList tfe4 = new ExtList();
		ExtList tfe5 = new ExtList();
		Log.info(tfe1);
//		ArrayList<String> top_atts = new ArrayList<String>();
//		ArrayList<String> side_atts = new ArrayList<String>();
//		RetAtts ra = new RetAtts();
//		ra.retAtts(tfe1, tfe2, top_atts, side_atts);
//		System.err.println("top:" + top_atts);
//		System.err.println("side" + side_atts);
		if(str == 8){
			System.err.println("333");
		}else if(str == 10){
			System.err.println("444");
			tfe4 = (ExtList)func_tfe.get(8);
			if ( ((ExtList)((ExtList)((ExtList)tfe4.get(1)).get(0)).get(1)).get(0) instanceof String){
				Log.info("Detect string");
				((ExtList)(tfe4.get(1))).add("@{att_com=1}");
			}
		}else{
			System.err.println("555");
			tfe4 = (ExtList)func_tfe.get(8);
			tfe5 = (ExtList)func_tfe.get(10);
			if ( ((ExtList)((ExtList)((ExtList)tfe4.get(1)).get(0)).get(1)).get(0) instanceof String){
				Log.info("Detect string");
				((ExtList)(tfe4.get(1))).add("@{att_com=1}");
			}
			if ( ((ExtList)((ExtList)((ExtList)tfe5.get(1)).get(0)).get(1)).get(0) instanceof String){
				Log.info("Detect string");
				((ExtList)(tfe5.get(1))).add("@{att_com=1}");
			}
		}
		ExtList ctab_tfe = new ExtList();
		ExtList ctab_tfe1 = new ExtList();		
		ExtList ctab_tfe2 = new ExtList();
		ExtList ctab_tfe3 = new ExtList();
		ExtList ctab_tfe4 = new ExtList();
		ExtList ctab_tfe5 = new ExtList();
		ExtList ctab_tfe6 = new ExtList();
		ExtList ctab_tfe7 = new ExtList();
		ExtList ctab_tfe8 = new ExtList();
		ExtList ctab_tfe9 = new ExtList();
		ExtList ctab_tfe10 = new ExtList();
		ExtList ctab_tfe11 = new ExtList();
		ExtList ctab_tfe12 = new ExtList();
		ExtList ctab_tfe13 = new ExtList();
		ExtList ctab_tfe14 = new ExtList();
		ExtList ctab_tfe15 = new ExtList();
		ExtList ctab_tfe16 = new ExtList();
		ExtList ctab_tfe17 = new ExtList();
		ExtList ctab_tfe18 = new ExtList();
		ExtList ctab_tfe19 = new ExtList();
		ExtList ctab_tfe20 = new ExtList();
		ExtList ctab_tfe21 = new ExtList();
		ExtList ctab_tfe22 = new ExtList();
		ExtList ctab_tfe23 = new ExtList();
		ExtList ctab_tfe24 = new ExtList();
		ExtList ctab_tfe25 = new ExtList();
		ExtList ctab_tfe26 = new ExtList();
		ExtList ctab_tfe27 = new ExtList();
		ExtList ctab_tfe28 = new ExtList();
		ExtList ctab_tfe29 = new ExtList();
		ExtList ctab_tfe30 = new ExtList();
		ExtList ctab_tfe31 = new ExtList();
		ExtList ctab_tfe32 = new ExtList();
		ExtList ctab_tfe33 = new ExtList();
		ExtList ctab_tfe34 = new ExtList();
		ExtList ctab_tfe35 = new ExtList();
		ExtList ctab_tfe36 = new ExtList();
		ExtList ctab_tfe37 = new ExtList();
		ExtList ctab_tfe38 = new ExtList();
		ExtList ctab_tfe39 = new ExtList();
		ExtList ctab_tfe40 = new ExtList();
		ExtList ctab_tfe41 = new ExtList();
		ExtList ctab_tfe42 = new ExtList();
		ExtList ctab_tfe43 = new ExtList();
		ExtList ctab_tfe44 = new ExtList();
		ExtList ctab_tfe45 = new ExtList();
		ExtList ctab_tfe46 = new ExtList();
		ExtList ctab_tfe47 = new ExtList();
		ExtList ctab_tfe48 = new ExtList();
		ExtList ctab_tfe49 = new ExtList();
		ExtList ctab_tfe50 = new ExtList();
		ExtList ctab_tfe51 = new ExtList();
		ExtList ctab_tfe52 = new ExtList();
		ExtList ctab_tfe53 = new ExtList();
		ExtList ctab_tfe54 = new ExtList();
		ExtList ctab_tfe55 = new ExtList();
		ExtList ctab_tfe56 = new ExtList();
		ExtList ctab_tfe57 = new ExtList();
		ExtList ctab_tfe58 = new ExtList();
		ExtList ctab_tfe59 = new ExtList();
		ExtList ctab_tfe60 = new ExtList();
		ExtList ctab_tfe61 = new ExtList();
		ExtList ctab_tfe62 = new ExtList();
		ExtList ctab_tfe63 = new ExtList();
		ExtList ctab_tfe64 = new ExtList();
		ExtList ctab_tfe65 = new ExtList();
		ExtList ctab_tfe66 = new ExtList();
		ExtList ctab_tfe67 = new ExtList();
		ExtList ctab_tfe68 = new ExtList();
		ExtList ctab_tfe69 = new ExtList();
		ExtList ctab_tfe70 = new ExtList();
		ExtList ctab_tfe71 = new ExtList();
		ExtList ctab_tfe72 = new ExtList();
		ExtList ctab_tfe73 = new ExtList();
		ExtList ctab_tfe74 = new ExtList();
		ExtList ctab_tfe75 = new ExtList();
		ExtList ctab_tfe76 = new ExtList();
		ExtList ctab_tfe77 = new ExtList();
		ExtList ctab_tfe78 = new ExtList();
		ExtList ctab_tfe79 = new ExtList();
		ExtList ctab_tfe80 = new ExtList();
		ExtList ctab_tfe81 = new ExtList();
		ExtList ctab_tfe82 = new ExtList();
		ExtList ctab_tfe83 = new ExtList();
		ExtList ctab_tfe84 = new ExtList();
		ExtList ctab_tfe85 = new ExtList();
		ExtList ctab_tfe86 = new ExtList();
		ExtList ctab_tfe87 = new ExtList();
		ExtList ctab_tfe88 = new ExtList();
		ExtList ctab_tfe89 = new ExtList();
		ExtList ctab_tfe90 = new ExtList();
		ExtList ctab_tfe91 = new ExtList();
		ExtList ctab_tfe92 = new ExtList();
		ExtList ctab_tfe93 = new ExtList();
		ExtList ctab_tfe94 = new ExtList();
		ExtList ctab_tfe95 = new ExtList();
		ExtList ctab_tfe96 = new ExtList();
		ExtList ctab_tfe97 = new ExtList();
		ExtList ctab_tfe98 = new ExtList();
		ExtList ctab_tfe99 = new ExtList();
		ExtList ctab_tfe100 = new ExtList();
		ExtList ctab_tfe101 = new ExtList();
		ExtList ctab_tfe102 = new ExtList();
		ExtList ctab_tfe103 = new ExtList();
		ExtList ctab_tfe104 = new ExtList();
		ExtList ctab_tfe105 = new ExtList();
		ExtList ctab_tfe106 = new ExtList();
		ExtList ctab_tfe107 = new ExtList();
		ExtList ctab_tfe108 = new ExtList();
		ExtList ctab_tfe109 = new ExtList();
		ExtList ctab_tfe110 = new ExtList();
		ExtList ctab_tfe111 = new ExtList();
		ExtList ctab_tfe112 = new ExtList();
		ExtList ctab_tfe113 = new ExtList();
		ExtList ctab_tfe114 = new ExtList();
		ExtList ctab_tfe115 = new ExtList();
		ExtList ctab_tfe116 = new ExtList();
		ExtList ctab_tfe117 = new ExtList();
		ExtList ctab_tfe118 = new ExtList();
		ExtList ctab_tfe119 = new ExtList();
		
		//各tfeの@ctabをつける
		((ExtList)tfe1.get(1)).add("@{cross_tab}");
		((ExtList)tfe2.get(1)).add("@{cross_tab}");
		((ExtList)tfe3.get(1)).add("@{cross_tab}");
//		System.err.println(tfe3);
//		System.err.println("1");
//		System.err.println("2");
		ctab_tfe1.add("h_exp");
//		System.err.println("3");
		ctab_tfe1.add(ctab_tfe);
		((ExtList)ctab_tfe1.get(1)).add(tfe1);
		ctab_tfe2.add("v_exp");
		ctab_tfe2.add(ctab_tfe3);
		((ExtList)ctab_tfe2.get(1)).add(ctab_tfe1);
		ctab_tfe4.add("d_exp");
		ctab_tfe4.add(ctab_tfe5);
		((ExtList)ctab_tfe4.get(1)).add(ctab_tfe2);
		ctab_tfe6.add("exp");
		ctab_tfe6.add(ctab_tfe7);
		((ExtList)ctab_tfe6.get(1)).add(ctab_tfe4);
		ctab_tfe8.add("[");
		ctab_tfe8.add(ctab_tfe6);
		ctab_tfe8.add("]");
		ctab_tfe8.add(",");
		ctab_tfe9.add("grouper");
		ctab_tfe9.add(ctab_tfe8);
		ctab_tfe10.add("operand");
		ctab_tfe10.add(ctab_tfe11);
		((ExtList)ctab_tfe10.get(1)).add(ctab_tfe9);
		//空白用のオペランド作成
//		ctab_tfe101.add("sl");
//		ctab_tfe101.add(ctab_tfe102);
//		((ExtList)ctab_tfe101.get(1)).add("\" \"");
//		ctab_tfe100.add(ctab_tfe101);
////		if()
//		ctab_tfe100.add("@{width=\"30\"}");
//		ctab_tfe103.add("operand");
//		ctab_tfe103.add(ctab_tfe100);
//		
		ctab_tfe12.add("h_exp");
		ctab_tfe12.add(ctab_tfe13);
//		((ExtList)ctab_tfe12.get(1)).add(ctab_tfe103);
//		((ExtList)ctab_tfe12.get(1)).add(",");
		((ExtList)ctab_tfe12.get(1)).add(ctab_tfe10);
		//ここまでで左半分
		
//		System.err.println(ctab_tfe12);

		//null作成
		ctab_tfe21.add("keyword");
		ctab_tfe21.add(ctab_tfe22);
		((ExtList)ctab_tfe21.get(1)).add("null");
		ctab_tfe23.add("any_name");
		ctab_tfe23.add(ctab_tfe24);
		((ExtList)ctab_tfe23.get(1)).add(ctab_tfe21);
		ctab_tfe25.add("function_name");
		ctab_tfe25.add(ctab_tfe26);
		((ExtList)ctab_tfe25.get(1)).add(ctab_tfe23);
		
		//null関数内に引数を入れる
		ctab_tfe52.add(ctab_tfe25);
		ctab_tfe52.add("(");
		ctab_tfe52.add(tfe1);
		ctab_tfe52.add(")");
		ctab_tfe55.add("function");
		ctab_tfe55.add(ctab_tfe52);
		ctab_tfe53.add("operand");
		ctab_tfe53.add(ctab_tfe54);
		((ExtList)ctab_tfe53.get(1)).add(ctab_tfe55);

		//
		ctab_tfe56.add("h_exp");
		
		//tfe3作成
		ctab_tfe31.add("h_exp");
		ctab_tfe31.add(ctab_tfe32);
		((ExtList)ctab_tfe31.get(1)).add(tfe3);
		ctab_tfe33.add("v_exp");
		ctab_tfe33.add(ctab_tfe34);
		((ExtList)ctab_tfe33.get(1)).add(ctab_tfe31);
		ctab_tfe35.add("d_exp");
		ctab_tfe35.add(ctab_tfe36);
		((ExtList)ctab_tfe35.get(1)).add(ctab_tfe33);
		ctab_tfe37.add("exp");
		ctab_tfe37.add(ctab_tfe38);
		((ExtList)ctab_tfe37.get(1)).add(ctab_tfe35);
		
		//パーツの[]をくっつける
		ctab_tfe39.add("[");
		ctab_tfe39.add(ctab_tfe37);
		ctab_tfe39.add("]");
		ctab_tfe39.add(",");
		
		//grouperとoperandつける
		ctab_tfe40.add("grouper");
		ctab_tfe40.add(ctab_tfe39);
		ctab_tfe42.add("operand");
		ctab_tfe42.add(ctab_tfe43);
		((ExtList)ctab_tfe42.get(1)).add(ctab_tfe40);
		
		
		//null(tfe1)とtfe3と,をh_expに入れる
		ctab_tfe56.add(ctab_tfe57);
		((ExtList)ctab_tfe56.get(1)).add(ctab_tfe53);
		((ExtList)ctab_tfe56.get(1)).add(",");
		((ExtList)ctab_tfe56.get(1)).add(ctab_tfe42);
		
		//expまでくっつける
		ctab_tfe60.add("v_exp");
		ctab_tfe60.add(ctab_tfe61);
		((ExtList)ctab_tfe60.get(1)).add(ctab_tfe56);
		ctab_tfe62.add("d_exp");
		ctab_tfe62.add(ctab_tfe63);
		((ExtList)ctab_tfe62.get(1)).add(ctab_tfe60);
		ctab_tfe64.add("exp");
		ctab_tfe64.add(ctab_tfe65);
		((ExtList)ctab_tfe64.get(1)).add(ctab_tfe62);
		
		//パーツとしての[]つける
		ctab_tfe66.add("[");
		ctab_tfe66.add(ctab_tfe64);
		ctab_tfe66.add("]");
		ctab_tfe66.add(",");
		
		//grouperとoperandつける
		ctab_tfe67.add("grouper");
		ctab_tfe67.add(ctab_tfe66);
		ctab_tfe69.add("operand");
		ctab_tfe69.add(ctab_tfe70);
		((ExtList)ctab_tfe69.get(1)).add(ctab_tfe67);
		
		
		//tfe2等を入れる
		ctab_tfe71.add("h_exp");
		ctab_tfe71.add(ctab_tfe72);
		((ExtList)ctab_tfe71.get(1)).add(tfe2);
		((ExtList)ctab_tfe71.get(1)).add(",");
		((ExtList)ctab_tfe71.get(1)).add(ctab_tfe69);
		ctab_tfe85.add("v_exp");
		ctab_tfe85.add(ctab_tfe73);
		((ExtList)ctab_tfe85.get(1)).add(ctab_tfe71);
		ctab_tfe74.add("d_exp");
		ctab_tfe74.add(ctab_tfe75);
		((ExtList)ctab_tfe74.get(1)).add(ctab_tfe85);
		ctab_tfe76.add("exp");
		ctab_tfe76.add(ctab_tfe77);
		((ExtList)ctab_tfe76.get(1)).add(ctab_tfe74);
		
		//パーツとしての[]と!つける
		ctab_tfe78.add("[");
		ctab_tfe78.add(ctab_tfe76);
		ctab_tfe78.add("]");
		ctab_tfe78.add("!");
		
		//grouper,operand,h_expつける
		ctab_tfe79.add("grouper");
		ctab_tfe79.add(ctab_tfe78);
		ctab_tfe81.add("operand");
		ctab_tfe81.add(ctab_tfe82);
		((ExtList)ctab_tfe81.get(1)).add(ctab_tfe79);
		ctab_tfe83.add("h_exp");
		ctab_tfe83.add(ctab_tfe84);
		((ExtList)ctab_tfe83.get(1)).add(ctab_tfe81);
		
		//左半分と結合
		ctab_tfe86.add("v_exp");
		ctab_tfe86.add(ctab_tfe87);
		((ExtList)ctab_tfe86.get(1)).add(ctab_tfe12);
		((ExtList)ctab_tfe86.get(1)).add("!");
		((ExtList)ctab_tfe86.get(1)).add(ctab_tfe83);
//		System.err.println(ctab_tfe86);
		//最後のd以降をつける
		ctab_tfe88.add("d_exp");
		ctab_tfe88.add(ctab_tfe89);
		((ExtList)ctab_tfe88.get(1)).add(ctab_tfe86);
		ctab_tfe90.add("exp");
		ctab_tfe90.add(ctab_tfe91);
		((ExtList)ctab_tfe90.get(1)).add(ctab_tfe88);
		ctab_tfe92.add("root");
		ctab_tfe92.add(ctab_tfe93);
		((ExtList)ctab_tfe92.get(1)).add(ctab_tfe90);
		System.err.println(ctab_tfe92);
		return ctab_tfe92;
	}
}
