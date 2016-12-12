package supersql.ctab;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.border.EtchedBorder;

import com.ibm.db2.jcc.am.ad;
import com.ibm.db2.jcc.am.in;
import com.ibm.db2.jcc.am.l;
import com.sun.javafx.util.TempState;
import com.sun.media.jfxmedia.events.NewFrameEvent;

import sun.awt.im.InputMethodJFrame;
import sun.util.logging.resources.logging;
import supersql.codegenerator.CodeGenerator;
import supersql.codegenerator.TFE;
import supersql.common.Log;
import supersql.dataconstructor.DataConstructor;
import supersql.extendclass.ExtList;

public class Ctab3 {
	private Hashtable<String, String> sort_info = new Hashtable<>();
	
	public ExtList read_tfe(ExtList func_tfe, String ltwidth) {
		Log.info(func_tfe);
		Log.info(ltwidth);
		ltwidth =ltwidth.replace("lt-width", "width");
		Log.info(ltwidth);
		ExtList tfe1 = new ExtList();
		ExtList tfe2 = new ExtList();
		ExtList tfe3 = new ExtList();
		tfe1 = (ExtList)func_tfe.get(2);
		tfe2 = (ExtList)func_tfe.get(4);
		tfe3 = (ExtList)func_tfe.get(6);
//		ExtList list = new ExtList(); 
//		list = tfe2;
//		boolean flag = false;
//		ArrayList<ExtList> list_tfe2 = new ArrayList<ExtList>();
//		ArrayList<Integer> construct_num = new ArrayList<Integer>();
//		int attnum = 0;
//		while(true){
//			Log.info("list_before:"+list);
//			if(!flag){
//				construct_num.add(0);
//				if(list.get(0).toString().equals("grouper") || list.get(0).toString().equals("[")){
//					flag = false;
//				}else{
//					flag = true;
//				}
//				list = (ExtList)list.get(1);
//				Log.info("1"+list);
//				attnum++;
//			}else{
//				construct_num.add(1);
//				list = (ExtList)list.get(0);
//				Log.info("0"+list);
//				flag = false;
//				attnum++;
//			}
//			if(list.get(0).toString().equals("table_alias")){
//				break;
//			}else{
//				list_tfe2.add(list);
//			}
//			Log.info("--------------------------------");
//		}
//		TFE schema1 = new TFE();
//		CodeGenerator cg1 = new CodeGenerator();
//		schema1 = cg1.initialize((ExtList)tfe2);
//		
//		Log.info("aaaaaaaaa"+schema1.makele0());
//		Log.info("aaaaaaaaa"+schema1.makesch());
//		for(int k = 0; k < attnum; k++){
//			System.out.println(construct_num.get(k)+":"+list_tfe2.get(k));
//		}
		((ExtList)tfe1.get(1)).add("@{ctab_tfe1='1'}");
		((ExtList)tfe2.get(1)).add("@{border='0'}");
//		((ExtList)tfe3.get(1)).add("@{border='0'}");
		int str = (int)func_tfe.size();
		ExtList tfe4 = new ExtList();
		ExtList tfe5 = new ExtList();
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
		
		
		//retrieve tfe1 and tfe2's attributes
//		Log.info(tfe1);
		ExtList unnest_tfe1 = tfe1.unnest();
//		Log.info(unnest_tfe1);
		int num = unnest_tfe1.contain_itemnum();
//		boolean sort_flag = true;
//		for (int i = 0; i < num; i++) {
//			if(unnest_tfe1.get(i).toString().equals("asc")){
//				sort_flag = false;
//			}
//		}
		ExtList tfe1_att = new ExtList();
		for(int i = 0; i < num; i++){
			if(unnest_tfe1.get(i).equals("table_alias")){
				ExtList tmp = new ExtList();
				tmp.add(unnest_tfe1.get(i));
				tmp.add(unnest_tfe1.get(i + 1));
				tmp.add(unnest_tfe1.get(i + 2));
				tmp.add(unnest_tfe1.get(i + 3));
				tmp.add(unnest_tfe1.get(i + 4));
				tmp.add(unnest_tfe1.get(i + 5));
				tmp.add(unnest_tfe1.get(i + 6));
				tfe1_att.add(tmp);
				i = i + 6;
			}else if(unnest_tfe1.get(i).equals("column_name")){
				ExtList tmp2 = new ExtList();
				tmp2.add(unnest_tfe1.get(i));
				tmp2.add(unnest_tfe1.get(i + 1));
				tmp2.add(unnest_tfe1.get(i + 2));
				tfe1_att.add(tmp2);
				i = i + 2;
			}
		}
//		Log.info(tfe1_att);		

		ExtList unnest_tfe2 = tfe2.unnest();
//		Log.info(unnest_tfe2);
		int num2 = unnest_tfe2.contain_itemnum();
		ExtList tfe2_att = new ExtList();
		for(int i = 0; i < num2; i++){
			if(unnest_tfe2.get(i).equals("table_alias")){
				ExtList tmp = new ExtList();
				tmp.add(unnest_tfe2.get(i));
				tmp.add(unnest_tfe2.get(i + 1));
				tmp.add(unnest_tfe2.get(i + 2));
				tmp.add(unnest_tfe2.get(i + 3));
				tmp.add(unnest_tfe2.get(i + 4));
				tmp.add(unnest_tfe2.get(i + 5));
				tmp.add(unnest_tfe2.get(i + 6));
				tfe2_att.add(tmp);
				i = i + 6;
			}else if(unnest_tfe2.get(i).equals("column_name")){
				ExtList tmp2 = new ExtList();
				tmp2.add(unnest_tfe2.get(i));
				tmp2.add(unnest_tfe2.get(i + 1));
				tmp2.add(unnest_tfe2.get(i + 2));
				tfe2_att.add(tmp2);
				i = i + 2;
			}
		}
//		Log.info(tfe2_att);
		//retrieve tfe1 and tfe2's attributes end
		
		//nest tfe1_att and tfe2_att
		ExtList tfe1_att_nest = new ExtList();
//		Log.info("tfe1_att:"+tfe1_att);
		for(int i = 0; i < tfe1_att.size(); i++){
			ExtList att = (ExtList)tfe1_att.get(i);
			if(att.get(0).equals("table_alias")){
				ExtList tmp = new ExtList();
				ExtList tmp1 = new ExtList();
				ExtList tmp2 = new ExtList();
				ExtList tmp3 = new ExtList();
				ExtList tmp4 = new ExtList();
				tmp2.add(att.get(1));
				tmp3.add(att.get(2));
				tmp2.add(tmp3);
				tmp1.add(att.get(0));
				tmp1.add(tmp4);
				((ExtList)tmp1.get(1)).add(tmp2);
				tmp.add("operand");
				ExtList tmp20 = new ExtList();
				//sort_flag=trueなら問答無用でdescにする
//				ExtList sort = new ExtList();
//				ExtList sort1 = new ExtList();
//				sort.add("sorting");
//				sort1.add("(");
//				if(sort_flag){
//					sort1.add("desc");
//				}else{
//					sort1.add("asc");
//				}
//				sort1.add(")");
//				sort.add(sort1);
//				tmp20.add(sort);
				tmp20.add(tmp1);
				ExtList tmp5 = new ExtList();
				ExtList tmp6 = new ExtList();
				ExtList tmp7 = new ExtList();
				ExtList tmp8 = new ExtList();
				tmp6.add(att.get(5));
				tmp7.add(att.get(6));
				tmp6.add(tmp7);
				tmp5.add(att.get(4));
				tmp5.add(tmp8);
				((ExtList)tmp5.get(1)).add(tmp6);
				tmp20.add(att.get(3));
				tmp20.add(tmp5);
				tmp.add(tmp20);
				tfe1_att_nest.add(tmp);
			}
		}
//		Log.info("tfe1_atts"+tfe1_att_nest);
		
		ExtList tfe2_att_nest = new ExtList();
		for(int i = 0; i < tfe2_att.size(); i++){
			ExtList att2 = (ExtList)tfe2_att.get(i);
			if(att2.get(0).equals("table_alias")){
				ExtList tmp17 = new ExtList();
				ExtList tmp9 = new ExtList();
				ExtList tmp10 = new ExtList();
				ExtList tmp11 = new ExtList();
				ExtList tmp12 = new ExtList();
				ExtList tmp13 = new ExtList();
				tmp9.add(att2.get(1));
				tmp10.add(att2.get(2));
				tmp9.add(tmp10);
				tmp11.add(att2.get(0));
				tmp11.add(tmp12);
				((ExtList)tmp11.get(1)).add(tmp9);
				ExtList tmp19 = new ExtList();
				tmp17.add("operand");
//				ExtList sort = new ExtList();
//				ExtList sort1 = new ExtList();
//				sort.add("sorting");
//				sort1.add("(");
//				if(sort_flag){
//					sort1.add("desc");
//				}else{
//					sort1.add("asc");
//				}
//				sort1.add(")");
//				sort.add(sort1);
//				tmp19.add(sort);
				tmp19.add(tmp11);
				ExtList tmp14 = new ExtList();
				ExtList tmp15 = new ExtList();
				ExtList tmp16 = new ExtList();
				ExtList tmp18 = new ExtList();
				tmp14.add(att2.get(5));
				tmp15.add(att2.get(6));
				tmp14.add(tmp15);
				tmp16.add(att2.get(4));
				tmp16.add(tmp18);
				((ExtList)tmp16.get(1)).add(tmp14);
				tmp19.add(att2.get(3));
				tmp19.add(tmp16);
				tmp17.add(tmp19);
				tfe2_att_nest.add(tmp17);
			}
		}
//		Log.info("tfe2_atts"+tfe2_att_nest);
		
		//tfe1とtfe2にソートを打ち込む
//		Log.info("tfe1_before:"+tfe1);
//		Log.info("tfe2_before:"+tfe2);
		ExtList tfe1_sorted = new ExtList();
		ExtList tfe2_sorted = new ExtList();
		boolean sflag = false;
		tfe1_sorted = tfe_sort(tfe1, sflag, "null");
//		Log.info("----------------------tfe1_end------------------------");
		tfe1_sorted = tfe_sort(tfe2, sflag, "null");
//		Log.info("tfe1_after:"+tfe1);
//		Log.info("tfe2_after:"+tfe2);
		
//		Log.info("sort_info:"+sort_info);
		//ExtListの大量生成
		ExtList l1 = new ExtList();
		ExtList l2 = new ExtList();
		ExtList l3 = new ExtList();
		ExtList l4 = new ExtList();
		ExtList l5 = new ExtList();
		ExtList l6 = new ExtList();
		ExtList l7 = new ExtList();
		ExtList l8 = new ExtList();
		ExtList l9 = new ExtList();
		ExtList l10 = new ExtList();
		ExtList l11 = new ExtList();
		ExtList l12 = new ExtList();
		ExtList l13 = new ExtList();
		ExtList l14 = new ExtList();
		ExtList l15 = new ExtList();
		ExtList l16 = new ExtList();
		ExtList l17 = new ExtList();
		ExtList l18 = new ExtList();
		ExtList l19 = new ExtList();
		ExtList l20 = new ExtList();
		ExtList l21 = new ExtList();
		ExtList l22 = new ExtList();
		ExtList l23 = new ExtList();
		ExtList l24 = new ExtList();
		ExtList l25 = new ExtList();
		ExtList l26 = new ExtList();
		ExtList l27 = new ExtList();
		ExtList l28 = new ExtList();
		ExtList l29 = new ExtList();
		ExtList l30 = new ExtList();
		ExtList l31 = new ExtList();
		ExtList l32 = new ExtList();
		ExtList l33 = new ExtList();
		ExtList l34 = new ExtList();
		ExtList l35 = new ExtList();
		ExtList l36 = new ExtList();
		ExtList l37 = new ExtList();
		ExtList l38 = new ExtList();
		ExtList l39 = new ExtList();
		ExtList l40 = new ExtList();
		ExtList l41 = new ExtList();
		ExtList l42 = new ExtList();
		ExtList l43 = new ExtList();
		ExtList l44 = new ExtList();
		ExtList l45 = new ExtList();
		ExtList l46 = new ExtList();
		ExtList l47 = new ExtList();
		ExtList l48 = new ExtList();
		ExtList l49 = new ExtList();
		ExtList l50 = new ExtList();
		ExtList l51 = new ExtList();
		ExtList l52 = new ExtList();
		ExtList l53 = new ExtList();
		ExtList l54 = new ExtList();
		ExtList l55 = new ExtList();
		ExtList l56 = new ExtList();
		ExtList l57 = new ExtList();
		ExtList l58 = new ExtList();
		ExtList l59 = new ExtList();
		ExtList l60 = new ExtList();
		ExtList l61 = new ExtList();
		ExtList l62 = new ExtList();
		ExtList l63 = new ExtList();
		ExtList l64 = new ExtList();
		ExtList l65 = new ExtList();
		ExtList l66 = new ExtList();
		ExtList l67 = new ExtList();
		ExtList l68 = new ExtList();
		ExtList l69 = new ExtList();
		ExtList l70 = new ExtList();
		ExtList l71 = new ExtList();
		ExtList l72 = new ExtList();
		ExtList l73 = new ExtList();
		ExtList l74 = new ExtList();
		ExtList l75 = new ExtList();
		ExtList l76 = new ExtList();
		ExtList l77 = new ExtList();
		ExtList l78 = new ExtList();
		ExtList l79 = new ExtList();
		ExtList l80 = new ExtList();
		ExtList l81 = new ExtList();
		ExtList l82 = new ExtList();
		ExtList l83 = new ExtList();
		ExtList l84 = new ExtList();
		ExtList l85 = new ExtList();
		ExtList l86 = new ExtList();
		ExtList l87 = new ExtList();
		ExtList l88 = new ExtList();
		ExtList l89 = new ExtList();
		ExtList l90 = new ExtList();
		ExtList l91 = new ExtList();
		ExtList l92 = new ExtList();
		ExtList l93 = new ExtList();
		ExtList l94 = new ExtList();
		ExtList l95 = new ExtList();
		ExtList l96 = new ExtList();
		ExtList l97 = new ExtList();
		ExtList l98 = new ExtList();
		ExtList l99 = new ExtList();
		ExtList l100 = new ExtList();
		//null部分の作成
		//tfe3,tfe1,tfe2の順で入れる
		l1.add("h_exp");
		l2.add(tfe3);
		l1.add(l2);
		l4.add("v_exp");
		l5.add(l1);
		l4.add(l5);
		l6.add("d_exp");
		l7.add(l4);
		l6.add(l7);
		l8.add("exp");
		l9.add(l6);
		l8.add(l9);
		l10.add("[");
		l10.add(l8);
		l10.add("]");
		l10.add(",");
		l11.add("grouper");
		l11.add(l10);
		l12.add("operand");
		l13.add(l11);
		l13.add("@{border='0'}");
		l12.add(l13); //tfe3をoperandに入れたもの
		//att_nestにソート情報追加
		//grouperに入ってるoperandを作成
		ExtList op_list = new ExtList();
		for(int i = tfe1_att_nest.size() - 1; i >= 0; i--){
			ExtList tmp11 = ((ExtList)tfe1_att_nest.get(i)).unnest();
//			Log.info(tmp11);
			String att = tmp11.get(3).toString();
			att += tmp11.get(4).toString();
			att += tmp11.get(7).toString();
			String sorting = sort_info.get(att);
			ExtList t2 = new ExtList();
			if(sorting.equals("asc")){
				ExtList t1 = new ExtList();
				ExtList t3 = new ExtList();
				ExtList t4 = new ExtList();
				t3.add("(");
				t3.add("asc");
				t3.add(")");
				t2.add("sorting");
				t2.add(t3);
			}else{
				ExtList t1 = new ExtList();
				ExtList t3 = new ExtList();
				ExtList t4 = new ExtList();
				t3.add("(");
				t3.add("desc");
				t3.add(")");
				t2.add("sorting");
				t2.add(t3);
			}
			((ExtList)((ExtList)tfe1_att_nest.get(i)).get(1)).add(0, t2);
			ExtList tmp1 = new ExtList();
			ExtList tmp2 = new ExtList();
			ExtList tmp3 = new ExtList();
			ExtList tmp4 = new ExtList();
			ExtList tmp5 = new ExtList();
			ExtList tmp6 = new ExtList();
			ExtList tmp7 = new ExtList();
			ExtList tmp8 = new ExtList();
			ExtList tmp9 = new ExtList();
			ExtList tmp10 = new ExtList();
			tmp1.add("null");
			tmp2.add("keyword");
			tmp2.add(tmp1);
			tmp3.add("any_name");
			tmp4.add(tmp2);
			tmp3.add(tmp4);
			tmp5.add("function_name");
			tmp6.add(tmp3);
			tmp5.add(tmp6);
			tmp7.add(tmp5);
			tmp7.add("(");
			tmp7.add(tfe1_att_nest.get(i));
			tmp7.add(")");
			tmp8.add("function");
			tmp8.add(tmp7);
			tmp9.add("operand");
			tmp10.add(tmp8);
			tmp10.add("@{border='0'}");
			tmp9.add(tmp10);
			
			op_list.add(tmp9);
		}
//		for(int i = tfe2_att_nest.size() - 1; i >= 0; i--){
//			ExtList tmp1 = new ExtList();
//			ExtList tmp2 = new ExtList();
//			ExtList tmp3 = new ExtList();
//			ExtList tmp4 = new ExtList();
//			ExtList tmp5 = new ExtList();
//			ExtList tmp6 = new ExtList();
//			ExtList tmp7 = new ExtList();
//			ExtList tmp8 = new ExtList();
//			ExtList tmp9 = new ExtList();
//			ExtList tmp10 = new ExtList();
//			tmp1.add("null");
//			tmp2.add("keyword");
//			tmp2.add(tmp1);
//			tmp3.add("any_name");
//			tmp4.add(tmp2);
//			tmp3.add(tmp4);
//			tmp5.add("function_name");
//			tmp6.add(tmp3);
//			tmp5.add(tmp6);
//			tmp7.add(tmp5);
//			tmp7.add("(");
//			tmp7.add(tfe2_att_nest.get(i));
//			tmp7.add(")");
//			tmp8.add("function");
//			tmp8.add(tmp7);
//			tmp9.add("operand");
//			tmp10.add(tmp8);
//			tmp10.add("@{border='0'}");
//			tmp9.add(tmp10);
//			
//			op_list.add(tmp9);
//		}
//		Log.info("op_list:"+op_list);
		
		//grouperに繰り返しで入れる
		ExtList third_tree = new ExtList();
		for(int i = 0; i < op_list.size(); i++){
			if(i == 0){
				third_tree = func(op_list, l12, i, tfe1_att_nest.size());
			}else{
				third_tree = func(op_list, third_tree, i, tfe1_att_nest.size());
			}
		}
//		Log.info(third_tree);
		//tfe2に埋め込む
		boolean inflag = false;
		ExtList tfe2_inserted = insert_into_tfe2(tfe2, third_tree, inflag);
//		Log.info("tfe2_in:"+tfe2_inserted);
//		Log.info("tfe2"+tfe2);
//		l14.add(tfe2);
//		l14.add(",");
//		l14.add(third_tree);
//		l15.add("h_exp");
//		l15.add(l14);
//		l16.add("v_exp");
//		l17.add(l15);
//		l16.add(l17);
//		l18.add("d_exp");
//		l19.add(l16);
//		l18.add(l19);
//		l20.add("exp");
//		l21.add(l18);
//		l20.add(l21);
//		l22.add("[");
//		l22.add(l20);
//		l22.add("]");
//		l22.add("!");
//		l23.add("grouper");
//		l23.add(l22);
//		l23.add("@{border='0'}");
//		l24.add("operand");
//		l25.add(l23);
//		l24.add(l25);
//		l26.add("h_exp");
//		l27.add(l24);
//		l26.add(l27);
		//左上の空白入れる
		l41.add("\" \"");
		l42.add("sl");
		l42.add(l41);
		l43.add(l42);
		l43.add(ltwidth);
		l44.add("operand");
		l44.add(l43);
		//作成終了
		//tfe1と連結
		l28.add("h_exp");
		l38.add(l44);
		l38.add(",");
		l38.add(tfe1);
		l28.add(l38);
		l29.add(l28);
		l29.add("!");
		l39.add("h_exp");
		l40.add(tfe2_inserted);
		l39.add(l40);
		l29.add(l39);
		l30.add("v_exp");
		l30.add(l29);
		l32.add("d_exp");
		l33.add(l30);
		l32.add(l33);
		l34.add("exp");
		l35.add(l32);
		l34.add(l35);
		l36.add("root");
		l37.add(l34);
		l36.add(l37);
		Log.info("result:"+l36);
		
		return l36;
	}
	
	private ExtList insert_into_tfe2(ExtList tfe2, ExtList third_tree, boolean inflag) {
		if(tfe2.get(0).toString().equals("h_exp")){
			ExtList tmp1 = new ExtList();
			ExtList tmp2 = new ExtList();
			tmp1.add(tfe2.get(0).toString());
//			Log.info("tfe_hv:"+tfe2);
			int child_num = ((ExtList)tfe2.get(1)).size();
			ExtList node = (ExtList)((ExtList)tfe2.get(1)).get(child_num - 1);
			if(((ExtList)((ExtList)node.get(1)).get(0)).get(0).toString().equals("grouper")){
				for(int i = 0; i < child_num - 1; i = i + 2){
					tmp2.add((ExtList)((ExtList)tfe2.get(1)).get(i));
//					Log.info("tfe2:"+(ExtList)((ExtList)tfe2.get(1)).get(i));
					tmp2.add(",");
				}
				tmp2.add(insert_into_tfe2(node, third_tree, inflag));
//				Log.info("gtmp2:"+tmp2);
			}else if(((ExtList)((ExtList)node.get(1)).get(0)).get(0).toString().equals("sorting") || (((ExtList)((ExtList)node.get(1)).get(0)).get(0).toString().equals("table_alias"))){
				for(int i = 0; i < child_num; i = i + 2){
					tmp2.add((ExtList)((ExtList)tfe2.get(1)).get(i));
					Log.info(tmp2);
					tmp2.add(",");
				}
				tmp2.add(third_tree);
//				Log.info("stmp2:"+tmp2);
			}
//			Log.info("htmp2:"+tmp2);
			tmp1.add(tmp2);
//			Log.info("htmp1:"+tmp1);
			return tmp1;
		}else{
			//継続して探索する
			ExtList tmp = new ExtList();
			ExtList tmp1 = new ExtList();
			ExtList tmp2 = new ExtList();
			ExtList tmp3 = new ExtList();
			if(!inflag){
				if(tfe2.get(0).toString().equals("grouper") || tfe2.get(0).toString().equals("[")){
					inflag = false;
				}else{
					inflag = true;
				}
				tmp = (ExtList)tfe2.get(1);
//				Log.info("1"+tmp);
				tmp1.add(tfe2.get(0).toString());
				ExtList tmp4 = insert_into_tfe2(tmp, third_tree, inflag);
				tmp1.add(tmp4);
//				Log.info("tfe2222:"+tfe2);
				if(tfe2.get(0).toString().equals("[")){
					tmp1.add(tmp1.size(), "]");
					tmp1.add(tfe2.get(tfe2.size() - 1).toString());
				}
//				Log.info("tfe2:"+tmp4);
//				Log.info("1tmp1:"+tmp1);
			}else{
				tmp = (ExtList)tfe2.get(0);
//				Log.info("0"+tmp);
				inflag = false;
				tmp1.add(insert_into_tfe2(tmp, third_tree, inflag));
//				Log.info("tmp3:"+tmp3);
//				Log.info("0tmp1:"+tmp1);
			}
			return tmp1;
		}
	}

	private ExtList tfe_sort(ExtList tfe, boolean flag, String string) {
		//tfeを解析して行ってsortを追加します。尚指定がなかったらascを入れます。stringは使いません………
		int attnum = 0;
//		if(string.equals("hv")){
//			ExtList tmp1 = new ExtList();
//			ExtList tmp2 = new ExtList();
//			Log.info("tmp_hv:"+tfe);
//			int child_num = ((ExtList)tfe.get(1)).size();
//			tmp1.add(tfe.get(0).toString());
//			Log.info("child:"+tfe.get(1));
//			Log.info("child_num:"+child_num);
//			for (int i = 0; i < child_num; i = i + 2) {
//				Log.info("i:"+i);
//				if(((ExtList)((ExtList)tfe.get(1)).get(0)).get(0).toString().equals("h_exp")){
//					tmp2.add(tfe_sort((ExtList)((ExtList)tfe.get(1)).get(i), flag, "hv"));
//				}else{
//					tmp2.add(tfe_sort((ExtList)((ExtList)tfe.get(1)).get(i), flag, "null"));
//				}
//			}
//			Log.info("tmp1:"+tmp1);
//			tmp1.add(tmp2);
//			return tmp1;
//		}
//		if(tfe.get(0).toString().equals("operand")){	
//			Log.info("tso:"+((ExtList)((ExtList)tmp.get(1)).get(0)).get(0).toString());
//		}
		if(tfe.get(0).toString().equals("operand")){
			if(((ExtList)((ExtList)tfe.get(1)).get(0)).get(0).toString().equals("table_alias")){
				//ソートを入れてもどる
				//ソートの部品作る(asc)
				ExtList tmp1 = new ExtList();
				ExtList tmp2 = new ExtList();
				ExtList tmp3 = new ExtList();
				ExtList tmp4 = new ExtList();
				tmp3.add("(");
				tmp3.add("asc");
				tmp3.add(")");
				tmp2.add("sorting");
				tmp2.add(tmp3);
				//ソートの情報を保存
				ExtList tmp5 = new ExtList();
				tmp5 = (ExtList)tfe.get(1);
				ExtList tmp5_unnest = tmp5.unnest();
				String att = new String();
				att = tmp5_unnest.get(2).toString();
				att = att + tmp5_unnest.get(3).toString();
				att = att + tmp5_unnest.get(6).toString();
				sort_info.put(att, "asc");
//				Log.info("att:"+att);
				//合体して返す
				((ExtList)tfe.get(1)).add(0, tmp2);
//				Log.info("tfe_ta:"+tfe);
				return tfe;
			}else if (((ExtList)((ExtList)tfe.get(1)).get(0)).get(0).toString().equals("sorting")) {
				//ソートを保存して戻る
				ExtList tmp5 = new ExtList();
				tmp5 = (ExtList)tfe.get(1);
				ExtList tmp5_unnest = tmp5.unnest();
				String att = new String();
				att = tmp5_unnest.get(6).toString();
				att = att + tmp5_unnest.get(7).toString();
				att = att + tmp5_unnest.get(10).toString();
				sort_info.put(att, tmp5_unnest.get(2).toString());
//				Log.info("tfe_s:"+tfe);
				return tfe;
			}else{
				ExtList tmp = new ExtList();
				ExtList tmp1 = new ExtList();
				ExtList tmp2 = new ExtList();
				ExtList tmp3 = new ExtList();
				if(!flag){
					if(tfe.get(0).toString().equals("grouper") || tfe.get(0).toString().equals("[")){
						flag = false;
					}else{
						flag = true;
					}
					tmp = (ExtList)tfe.get(1);
//					Log.info("1"+tmp);
					attnum++;
					tmp1.add(tfe_sort(tmp, flag, "null"));
				}else{
					tmp = (ExtList)tfe.get(0);
//					Log.info("0"+tmp);
					flag = false;
					attnum++;
					tmp1.add(tfe.get(0).toString());
					tmp3.add(tfe_sort(tmp, flag, "null"));
					tmp1.add(tmp3);
				}
				return tmp1;
			}
		}else if ((tfe.get(0).toString().equals("h_exp") || tfe.get(0).toString().equals("v_exp")) && !string.equals("hv")) {
			ExtList tmp1 = new ExtList();
			ExtList tmp2 = new ExtList();
//			Log.info("tfe_hv:"+tfe);
			int child_num = ((ExtList)tfe.get(1)).size();
			tmp1.add(tfe.get(0).toString());
//			Log.info("child_num:"+child_num);
			for (int i = 0; i < child_num; i = i + 2) {
//				Log.info("i:"+i);
//				Log.info((ExtList)((ExtList)tfe.get(1)).get(i));
				tmp2.add(tfe_sort((ExtList)((ExtList)tfe.get(1)).get(i), flag, "null"));
			}
			tmp1.add(tmp2);
//			Log.info("htmp1:"+tmp1);
			return tmp1;
		}else{
			//奥に進む。帰ってきた場合はロールバック。
			ExtList tmp = new ExtList();
			ExtList tmp1 = new ExtList();
			ExtList tmp2 = new ExtList();
			ExtList tmp3 = new ExtList();
			if(!flag){
				if(tfe.get(0).toString().equals("grouper") || tfe.get(0).toString().equals("[")){
					flag = false;
				}else{
					flag = true;
				}
				tmp = (ExtList)tfe.get(1);
//				Log.info("01"+tmp);
				attnum++;
				tmp1.add(tfe_sort(tmp, flag, "null"));
			}else{
				tmp = (ExtList)tfe.get(0);
//				Log.info("00"+tmp);
				flag = false;
				attnum++;
				tmp1.add(tfe.get(0).toString());
				tmp3.add(tfe_sort(tmp, flag, "null"));
				tmp1.add(tmp3);
			}
//			Log.info("tmp1:"+tmp1);
			return tmp1;
		}
//		return null;
	}

	static ExtList func(ExtList op_list, ExtList add_list, int i, int j){
		ExtList tmp1 = new ExtList();
		ExtList tmp2 = new ExtList();
		ExtList tmp3 = new ExtList();
		ExtList tmp4 = new ExtList();
		ExtList tmp5 = new ExtList();
		ExtList tmp6 = new ExtList();
		ExtList tmp7 = new ExtList();
		ExtList tmp8 = new ExtList();
		ExtList tmp9 = new ExtList();
		ExtList tmp10 = new ExtList();
		ExtList tmp11 = new ExtList();
		ExtList tmp12 = new ExtList();
		ExtList tmp13 = new ExtList();
		ExtList tmp14 = new ExtList();
		ExtList tmp15 = new ExtList();
		ExtList tmp16 = new ExtList();
		ExtList tmp17 = new ExtList();
		ExtList tmp18 = new ExtList();
		ExtList tmp19 = new ExtList();
		ExtList tmp20 = new ExtList();
		ExtList third_tree = new ExtList();
		tmp1.add(op_list.get(i));
		tmp1.add(",");
		tmp1.add(add_list);
		tmp2.add("h_exp");
		tmp2.add(tmp1);
		tmp4.add("v_exp");
		tmp5.add(tmp2);
		tmp4.add(tmp5);
		tmp6.add("d_exp");
		tmp7.add(tmp4);
		tmp6.add(tmp7);
		tmp8.add("exp");
		tmp9.add(tmp6);
		tmp8.add(tmp9);
		tmp10.add("[");
		tmp10.add(tmp8);
		tmp10.add("]");
		if(i < j){
			tmp10.add(",");
		}else{
			tmp10.add("!");
		}
		tmp11.add("grouper");
		tmp11.add(tmp10);
		third_tree.add("operand");
		tmp13.add(tmp11);
		tmp13.add("@{border='0'}");
		third_tree.add(tmp13);
		return third_tree;
	}
}