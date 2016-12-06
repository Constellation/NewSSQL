package supersql.ctab;

import supersql.common.Log;
import supersql.extendclass.ExtList;

public class Ctab2 {

	public ExtList read_tfe(ExtList func_tfe) {
		ExtList tfe1 = new ExtList();
		ExtList tfe2 = new ExtList();
		ExtList tfe3 = new ExtList();
		tfe1 = (ExtList)func_tfe.get(2);
		tfe2 = (ExtList)func_tfe.get(4);
		tfe3 = (ExtList)func_tfe.get(6);
		((ExtList)tfe1.get(1)).add("@{ctab='1'}");
		((ExtList)tfe2.get(1)).add("@{ctab='2'}");
		((ExtList)tfe3.get(1)).add("@{ctab='3'}");
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
		Log.info(tfe1);
		ExtList unnest_tfe1 = tfe1.unnest();
		Log.info(unnest_tfe1);
		int num = unnest_tfe1.contain_itemnum();
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
		Log.info(tfe1_att);		

		ExtList unnest_tfe2 = tfe2.unnest();
		Log.info(unnest_tfe2);
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
		Log.info(tfe2_att);
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
		
		//make third node of tree
		
		ExtList third_node = new ExtList();
		third_node.add("exp");
		ExtList tmp21 = new ExtList();
		ExtList tmp22 = new ExtList();
		ExtList tmp23 = new ExtList();
		ExtList tmp24 = new ExtList();
		ExtList tmp25 = new ExtList();
		ExtList tmp26 = new ExtList();
		ExtList tmp28 = new ExtList();
		ExtList tmp29 = new ExtList();
		ExtList tmp30 = new ExtList();
		ExtList tmp31 = new ExtList();
		ExtList tmp32 = new ExtList();
		ExtList tmp33 = new ExtList();
		
		//関数に格納
		ExtList fc1 = new ExtList();
		ExtList fc2 = new ExtList();
		ExtList fc3 = new ExtList();
		ExtList fc4 = new ExtList();
		ExtList fc5 = new ExtList();
		ExtList fc6 = new ExtList();
		ExtList fc7 = new ExtList();
		ExtList fc8 = new ExtList();
		ExtList fc9 = new ExtList();

		fc1.add("third_tree");
		fc2.add("any_name");
		fc2.add(fc1);
		fc3.add("function_name");
		fc3.add(fc4);
		fc5.add("function");
		fc6.add(fc3);
		fc6.add("(");
		((ExtList)fc3.get(1)).add(fc2);
		for(int m = 0; m < tfe1_att_nest.size(); m++){
			fc6.add(tfe1_att_nest.get(m));
			fc6.add(",");
		}
		
		for(int n = 0; n < tfe2_att_nest.size(); n++){
			fc6.add(tfe2_att_nest.get(n));
			fc6.add(",");
		}
//		Log.info(tmp27);
		fc6.add(tfe3);
		fc6.add(")");
		fc5.add(fc6);
		fc7.add("operand");
		fc7.add(fc8);
		((ExtList)fc7.get(1)).add(fc5);
		tmp23.add("h_exp");
		tmp23.add(fc9);
		((ExtList)tmp23.get(1)).add(fc7);
		tmp24.add("v_exp");
		tmp24.add(tmp25);
		((ExtList)tmp24.get(1)).add(tmp23);
		tmp22.add("d_exp");
		tmp22.add(tmp26);
		((ExtList)tmp22.get(1)).add(tmp24);
		third_node.add(tmp31);
		((ExtList)third_node.get(1)).add(tmp22);
		Log.info("third_node"+third_node); //expから
		Log.info(fc7); //operandから
		((ExtList)fc7.get(1)).add("@{third_node='1'}");

		//make 1st 2nd node
		//marge third node to tree
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
//		//CG部での表示を楽にするためグルーパーの追加
//		ExtList tfe1_g = new ExtList();
//		ExtList tfe2_g = new ExtList();
//		l19.add("h_exp");
//		l19.add(l20);
//		((ExtList)l19.get(1)).add(tfe1);
//		l21.add("v_exp");
//		l21.add(l22);
//		((ExtList)l21.get(1)).add(l19);
//		l23.add("d_exp");
//		l23.add(l24);
//		((ExtList)l23.get(1)).add(l21);
//		l25.add("exp");
//		l25.add(l26);
//		((ExtList)l25.get(1)).add(l23);
//		l27.add("[");
//		l27.add(l25);
//		l27.add("]");
//		l27.add(",");
//		l28.add("grouper");
//		l28.add(l27);
//		tfe1_g.add("operand");
//		tfe1_g.add(l30);
//		((ExtList)tfe1_g.get(1)).add(l28);
////		Log.info(tfe1_g);
//		l31.add("h_exp");
//		l31.add(l32);
//		((ExtList)l31.get(1)).add(tfe2);
//		l33.add("v_exp");
//		l33.add(l34);
//		((ExtList)l33.get(1)).add(l31);
//		l35.add("d_exp");
//		l35.add(l36);
//		((ExtList)l35.get(1)).add(l33);
//		l37.add("exp");
//		l37.add(l38);
//		((ExtList)l37.get(1)).add(l35);
//		l39.add("[");
//		l39.add(l37);
//		l39.add("]");
//		l39.add("!");
//		l40.add("grouper");
//		l40.add(l39);
//		tfe2_g.add("operand");
//		tfe2_g.add(l41);
//		((ExtList)tfe2_g.get(1)).add(l40);
////		Log.info(tfe2_g);
		l12.add(tfe1);
		l14.add("h_exp");
		l14.add(l12);
		l15.add("h_exp");
		l17.add(tfe2);
		l17.add(",");
		l17.add(third_node);
		l15.add(l17);
		l16.add(l14);
		l16.add("!");
		l16.add(l15);
		l1.add("root");
		l45.add("root");
		l45.add(l16);
		Log.info(l45);
		l5.add("v_exp");
		l5.add(l16);
//		((ExtList)l5.get(1)).add(l16);
		l7.add("d_exp");
		l7.add(l8);
		((ExtList)l7.get(1)).add(l5);
		l9.add("exp");
		l9.add(l10);
		((ExtList)l9.get(1)).add(l7);
		l1.add(l11);
		((ExtList)l1.get(1)).add(l9);
		Log.info(l1);
		//属性試作
		l40.add("root");
		l42.add("h_exp");
		l42.add(l51);
		((ExtList)l42.get(1)).add(tfe1);
		l52.add("h_exp");
		l52.add(l53);
		((ExtList)l52.get(1)).add(tfe2);
		l54.add(l42);
		l54.add("!");
		l54.add(l52);
		l44.add("v_exp");
		l44.add(l54);
		l47.add("d_exp");
		l47.add(l48);
		((ExtList)l47.get(1)).add(l44);
		l49.add("exp");
		l49.add(l50);
		((ExtList)l49.get(1)).add(l47);
		l56.add(l49);
		l56.add(",");
		l56.add(third_node);
		l57.add("h_exp");
		l57.add(l56);
		l58.add("v_exp");
		l59.add(l57);
		l58.add(l59);
		l60.add("d_exp");
		l61.add(l58);
		l60.add(l61);
		l62.add("exp");
		l63.add(l60);
		l62.add(l63);
//		l64.add("operand");
//		l65.add(l62);
//		l64.add(l65);
		l64.add(l62);
//		l66.add(l64);
		l40.add(l64);
//		l40.add(l43);
//		((ExtList)l40.get(1)).add(l49);
		l40.add("@{ctab='1'}");
		Log.info(l40);
		return l40;
	}
}
