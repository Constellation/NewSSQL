package supersql.ctab;

import sun.util.logging.resources.logging;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class Ctab3 {
	public ExtList read_tfe(ExtList func_tfe) {
		ExtList tfe1 = new ExtList();
		ExtList tfe2 = new ExtList();
		ExtList tfe3 = new ExtList();
		tfe1 = (ExtList)func_tfe.get(2);
		tfe2 = (ExtList)func_tfe.get(4);
		tfe3 = (ExtList)func_tfe.get(6);
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
		Log.info(unnest_tfe1);
		int num = unnest_tfe1.contain_itemnum();
		boolean sort_flag = false;
		for (int i = 0; i < num; i++) {
			if(unnest_tfe1.get(i).toString().equals("asc")){
				sort_flag = true;
			}
		}
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
		Log.info("tfe1_att:"+tfe1_att);
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
				//sort_flag=trueなら問答無用でascにする
				ExtList sort = new ExtList();
				ExtList sort1 = new ExtList();
				sort.add("sorting");
				sort1.add("(");
				if(sort_flag){
					sort1.add("asc");
				}else{
					sort1.add("desc");
				}
				sort1.add(")");
				sort.add(sort1);
				tmp20.add(sort);
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
		Log.info("tfe1_atts"+tfe1_att_nest);
		
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
				ExtList sort = new ExtList();
				ExtList sort1 = new ExtList();
				sort.add("sorting");
				sort1.add("(");
				if(sort_flag){
					sort1.add("asc");
				}else{
					sort1.add("desc");
				}
				sort1.add(")");
				sort.add(sort1);
				tmp19.add(sort);
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
		Log.info("tfe2_atts"+tfe2_att_nest);
		
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
		//grouperに入ってるoperandを作成
		ExtList op_list = new ExtList();
		for(int i = tfe1_att_nest.size() - 1; i >= 0; i--){
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
		for(int i = tfe2_att_nest.size() - 1; i >= 0; i--){
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
			tmp7.add(tfe2_att_nest.get(i));
			tmp7.add(")");
			tmp8.add("function");
			tmp8.add(tmp7);
			tmp9.add("operand");
			tmp10.add(tmp8);
			tmp10.add("@{border='0'}");
			tmp9.add(tmp10);
			
			op_list.add(tmp9);
		}
		Log.info("op_list:"+op_list);
		
		//grouperに繰り返しで入れる
		ExtList third_tree = new ExtList();
		for(int i = 0; i < op_list.size(); i++){
			if(i == 0){
				third_tree = func(op_list, l12, i, tfe1_att_nest.size());
			}else{
				third_tree = func(op_list, third_tree, i, tfe1_att_nest.size());
			}
		}
		Log.info(third_tree);
		//tfe2とh_expで合成
		//tfe2を強制的にascに
		Log.info("tfe2"+tfe2);
		l14.add(tfe2);
		l14.add(",");
		l14.add(third_tree);
		l15.add("h_exp");
		l15.add(l14);
		l16.add("v_exp");
		l17.add(l15);
		l16.add(l17);
		l18.add("d_exp");
		l19.add(l16);
		l18.add(l19);
		l20.add("exp");
		l21.add(l18);
		l20.add(l21);
		l22.add("[");
		l22.add(l20);
		l22.add("]");
		l22.add("!");
		l23.add("grouper");
		l23.add(l22);
		l23.add("@{border='0'}");
		l24.add("operand");
		l25.add(l23);
		l24.add(l25);
		l26.add("h_exp");
		l27.add(l24);
		l26.add(l27);
		//tfe1と連結
		l28.add("h_exp");
		l38.add(tfe1);
		l28.add(l38);
		l29.add(l28);
		l29.add("!");
		l29.add(l26);
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