/*
 * Created on 2004/11/26 by mai
 */
package supersql.codegenerator.SWF;

import java.io.*;
import supersql.codegenerator.*;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class SWFManager extends Manager {

	SWFEnv swf_env;
	SWFWriter writer;
	ITFE tfe_info;

	StringBuffer imgpath = new StringBuffer();
	StringBuffer name = new StringBuffer();
	StringBuffer data = new StringBuffer();
	StringBuffer x = new StringBuffer();
	StringBuffer y = new StringBuffer();
	StringBuffer w = new StringBuffer();
	StringBuffer h = new StringBuffer();
	StringBuffer bgcolor = new StringBuffer();
	StringBuffer bdcolor = new StringBuffer();
	StringBuffer color = new StringBuffer();
	StringBuffer align = new StringBuffer();
	StringBuffer size = new StringBuffer();
	StringBuffer margin = new StringBuffer();
	// edit tomo 2007.12.23
	StringBuffer texttype = new StringBuffer();
	StringBuffer mask = new StringBuffer();
	String dur;
	//morya wrote
	  StringBuffer tname = new StringBuffer();
	  StringBuffer tdata = new StringBuffer();
	  StringBuffer tx = new StringBuffer();
	  StringBuffer ty = new StringBuffer();
	  StringBuffer tw = new StringBuffer();
	  StringBuffer th = new StringBuffer();
	  StringBuffer tcolor = new StringBuffer();
	  StringBuffer tsize = new StringBuffer();
	  StringBuffer timefrom = new StringBuffer();
	  StringBuffer timeto = new StringBuffer();

	  StringBuffer int_name = new StringBuffer();
	  StringBuffer int_namet = new StringBuffer();
	  StringBuffer inter_name = new StringBuffer();
	  StringBuffer tmp = new StringBuffer();//photo
	  StringBuffer int_x = new StringBuffer();//photo
	  StringBuffer int_y = new StringBuffer();
	  StringBuffer int_w = new StringBuffer();
	  StringBuffer int_h = new StringBuffer();
	  StringBuffer int_bgcolor = new StringBuffer();
	  StringBuffer int_bdcolor = new StringBuffer();
	  StringBuffer int_color = new StringBuffer();
	  StringBuffer int_alpha = new StringBuffer();
	  StringBuffer int_size = new StringBuffer();
	  StringBuffer int_align = new StringBuffer();
	  StringBuffer int_margin = new StringBuffer();
	  StringBuffer int_str = new StringBuffer();
	  StringBuffer inter_imgpath = new StringBuffer();//photo
	  StringBuffer inter_x = new StringBuffer();
	  StringBuffer inter_y = new StringBuffer();
	  StringBuffer inter_w = new StringBuffer();
	  StringBuffer inter_h = new StringBuffer();
	  StringBuffer lnum = new StringBuffer();//only scene0
	  StringBuffer limgnum = new StringBuffer();
	  StringBuffer visibleflag = new StringBuffer();//%info
	  StringBuffer lx = new StringBuffer();
	  StringBuffer ly = new StringBuffer();
	  StringBuffer lw = new StringBuffer();
	  StringBuffer lh = new StringBuffer();
	  StringBuffer lstop = new StringBuffer();

	  //morya kokomade

	int dx = 0;
	int dy = 0;
	int left_counter = 0;
	int left_counter_resize = 0;
	int k;
	int atwindow_x=0, atwindow_y=0;

	public SWFManager(SWFEnv swf_env) {
		this.swf_env = swf_env;
		writer = new SWFWriter(swf_env);
	}

	public void generateCode(ITFE tfe_info, ExtList data_info) {
		int dx = 0;
		int dy = 0;

		swf_env.loadPDFfont();
		this.tfe_info = tfe_info;
		tfe_info.work(data_info);
		set_frame();

		writer.writeHeader();
//		Log.out("[SWFManager:generateCode]header = \n"+ swf_env.header);
		writer.writeFunctions();
		writer.writeControlAS();
//		Log.out("[SWFManager:generateCode]function = \n"+ swf_env.function);
		writer.writeFooter();
//		Log.out("[SWFManager:generateCode]footer = \n"+ swf_env.footer);
	}


	public void set_frame(){
		String ftype = swf_env.final_value.type;
		Log.out("ftype:"+ftype);
		//morya wrote
		if (swf_env.telop != "false"){
			initTelopArray();
			SWFValue pos = (SWFValue)swf_env.final_value.inList.get(0);
			makeTelopArray(pos);
			writeTelopArray();
		}
		//morya kokomade
		//G4
		if(ftype.equals("G4")){
			for(int i=0; i<swf_env.final_value.inList.size(); i++){
				k=0; atwindow_x=0; atwindow_y=0;
				initArray();
				SWFValue pos = (SWFValue)swf_env.final_value.inList.get(i);

				resize_cell(pos);
				set_position(pos,dx,dy);

				//resize_cellC3(pos);
				set_positionC3(pos,dx,dy);
				addWindowConfig(pos,pos);
				//addWindowConfigLeaf(pos);

				if(pos.type.equals("Att") || pos.type.equals("Func")){
					makeArray1(pos);
				}else{
					makeIntConfig();
					makeIntArray(pos);
					makeIntImgArray(pos);
					makeArray2(pos);
				}
//				dur = "$duration="+Integer.toString(pos.duration)+"/1000;\n";
				dur = "$duration="+Integer.toString(this.swf_env.duration)+"/1000;\n";
				if(swf_env.visibleflag_count != 0)
					writeInteraction(i);
				writeArray();

				writeDispFunc();

			}
		} // C4
		else if(ftype.equals("C4")){
			for(int i=0; i<swf_env.final_value.inList.size(); i++){
				initArray();
				SWFValue pos = (SWFValue)swf_env.final_value.inList.get(i);

				if(pos.type.equals("G4")){
					for(int j=0; j<pos.inList.size(); j++){
						initArray();
						SWFValue pos_child = (SWFValue)pos.inList.get(j);

						resize_cell(pos_child);

						set_position(pos_child,dx,dy);

						if(pos_child.type.equals("Att") || pos_child.type.equals("Func")){
							makeArray1(pos_child);
						}else{
							makeArray2(pos_child);
						}

						dur = "$duration="+Integer.toString(this.swf_env.duration)+"/1000;\n";
						writeArray();

						writeDispFunc();
					}
				}else if(ftype.equals("G1")||ftype.equals("G2")){
					initArray();

					resize_cell(pos);

					set_position(pos,dx,dy);

					if(pos.type.equals("Att") || pos.type.equals("Func")){
						makeArray1(pos);
					}else{
						makeArray2(pos);
					}
//					dur = "$duration="+Integer.toString(pos.duration)+"/1000;\n";
					dur = "$duration="+Integer.toString(this.swf_env.duration)+"/1000;\n";
					writeArray();

					writeDispFunc();
				}
			}
		}
		else{
			initArray();

			resize_cell(swf_env.final_value);

			set_position(swf_env.final_value,dx,dy);

			makeArray2(swf_env.final_value);
			dur = "$duration="+Integer.toString(this.swf_env.duration)+"/1000;\n";
//			dur = "$duration="+Integer.toString(swf_env.final_value.duration)+"/1000;\n";
			writeArray();

			writeDispFunc();
		}
	}

	private void initTelopArray(){
		//morya wrote
	    tname = new StringBuffer();
	    tdata = new StringBuffer();
	    tx = new StringBuffer();
	    ty = new StringBuffer();
	    tw = new StringBuffer();
	    th = new StringBuffer();
	    tcolor = new StringBuffer();
	    tsize = new StringBuffer();
	    timefrom = new StringBuffer();
	    timeto = new StringBuffer();
	    //morya kokomade
	  //morya wrote
		tname.append("$tname = array(");
	    tdata.append("$tstr = array(");
	    tx.append("$tx = array(");
	    ty.append("$ty = array(");
	    tw.append("$tw = array(");
	    th.append("$th = array(");
	    tcolor.append("$tcolor = array(");
	    tsize.append("$tsize = array(");
	    timefrom.append("$timefrom = array(");
	    timeto.append("$timeto = array(");
		//morya kokomade
	}


	// edit tomo 2007.12.23
	private void initArray() {
		imgpath = new StringBuffer();
		name = new StringBuffer();
		x = new StringBuffer();
		y = new StringBuffer();
		w = new StringBuffer();
		h = new StringBuffer();
		bgcolor = new StringBuffer();
		bdcolor = new StringBuffer();
		color = new StringBuffer();
		size = new StringBuffer();
		align = new StringBuffer();
		margin = new StringBuffer();
		data = new StringBuffer();
		texttype = new StringBuffer();
		mask = new StringBuffer();
		String dur = "$duration = ";
		int_name = new StringBuffer();
		int_namet = new StringBuffer();
		inter_name = new StringBuffer();
		tmp = new StringBuffer();
		int_x = new StringBuffer();
		int_y = new StringBuffer();
		int_w = new StringBuffer();
		int_h = new StringBuffer();
		int_bgcolor = new StringBuffer();
		int_bdcolor = new StringBuffer();
		int_color = new StringBuffer();
		int_alpha = new StringBuffer();
		int_size = new StringBuffer();
		int_align = new StringBuffer();
		int_margin = new StringBuffer();
		int_str = new StringBuffer();
		inter_imgpath = new StringBuffer();//photo
		inter_x = new StringBuffer();
		inter_y = new StringBuffer();
		inter_w = new StringBuffer();
		inter_h = new StringBuffer();
		lnum = new StringBuffer();//only scene0
		limgnum = new StringBuffer();
		visibleflag = new StringBuffer();
		lx = new StringBuffer();
		ly = new StringBuffer();
		lw = new StringBuffer();
		lh = new StringBuffer();
		lstop = new StringBuffer();

		imgpath.append("$imgpath = array(");
		name.append("$name = array(");
		x.append("$x = array(");
		y.append("$y = array(");
		w.append("$w = array(");
		h.append("$h = array(");
		bgcolor.append("$bgcolor = array(");
		bdcolor.append("$bdcolor = array(");
		color.append("$color = array(");
		size.append("$size = array(");
		align.append("$align = array(");
		margin.append("$margin = array(");
		data.append("$str = array(");
		texttype.append("$texttype = array(");
		mask.append("$mw = array(");

		int_name.append("$int_name = array(");
		int_namet.append("$int_namet = array(");
		inter_name.append("$inter_name = array(");
		tmp.append("$tmp = array(");
		int_x.append("$int_x = array(");
		int_y.append("$int_y = array(");
		int_w.append("$int_w = array(");
		int_h.append("$int_h = array(");
		int_bgcolor.append("$int_bgcolor = array(");
		int_bdcolor.append("$int_bdcolor = array(");
		int_color.append("$int_color = array(");
		int_alpha.append("$int_alpha = array(");
		int_size.append("$int_size = array(");
		int_align.append("$int_align = array(");
		int_margin.append("$int_margin = array(");
		int_str.append("$int_str = array(");
		inter_imgpath.append("$inter_imgpath = array(");//photo
		inter_x.append("$inter_x = array(");
		inter_y.append("$inter_y = array(");
		inter_w.append("$inter_w = array(");
		inter_h.append("$inter_h = array(");
		lnum.append("$lnum = array(");//only scene0
		limgnum.append("$limgnum = array(");
		visibleflag.append("$visibleflag = array(");
		lx.append("$lx = array(");
		ly.append("$ly = array(");
		lw.append("$lw = array(");
		lh.append("$lh = array(");
		lstop.append("$lstop = array(");
	}

	public void resize_cell (SWFValue self){
		SWFValue child;
		int j=0;
		int num_of_child = self.inList.size();
		Log.out("num_of_child"+num_of_child+" self.type"+self.type);
		int w_tmp = 0;
		int h_tmp = 0;
		while(j<num_of_child){
			child = (SWFValue)self.inList.get(j);

			Log.out("+++++++++++child.type:"+child.type);
			Log.out("+++++++++++child.data:"+child.data);

			if(self.type.equals("G1")||self.type.equals("C1")){
				Log.out("height="+self.height);
				Log.out("width="+self.width);
				child.height = self.height;

				if(j==num_of_child-1){
					child.width = self.width - w_tmp;
					Log.out("child.width:" +child.width);
				}
				else{
					w_tmp += child.width;
					Log.out("width:"+w_tmp);
				}
				Log.out(child.data+"(w,h)=("+child.width+","+child.height+")");
			} 
			else if(self.type.equals("G2")||self.type.equals("C2")){
				Log.out("width="+self.width);
				Log.out("½height="+self.height);
				child.width = self.width;

				if(j==num_of_child-1){
					child.height = self.height - h_tmp;
					Log.out("child.height:" +child.height);
				}
				else{
					Log.out("height:"+h_tmp);
					h_tmp += child.height;
				}
				Log.out(child.data+"(w,h)=("+child.width+","+child.height+")");
			}

			else if(self.type.equals("G3")||self.type.equals("C3")){
				Log.out("width="+self.width);
				Log.out("height="+self.height);
				child.width = self.width;
				child.height = self.height;
				if(child.cthree==0){
					swf_env.int_config[left_counter_resize][3] = child.width;
					swf_env.int_config[left_counter_resize][4] = child.height;
					Log.out("left_counter_resize="+left_counter_resize);
					left_counter_resize++;
				}

				if(j==num_of_child-1){
					//child.height = self.height - h_tmp;
					Log.out("child.height:" +child.height);
				}
				else{
					Log.out("height:"+h_tmp);
					//h_tmp += child.height;
				}
				Log.out(child.data+"(w,h)=("+child.width+","+child.height+")");
			}

			if(!(child.type.equals("Att")||child.type.equals("Func")))


			resize_cell(child);

			j++;

		}
	}

	public void set_position (SWFValue self, int dx, int dy){
		SWFValue child;
		int j=0;
		Log.out("self.inList.size="+self.inList.size()+" self.type="+self.type);
		while(j<self.inList.size()){
			child = (SWFValue)self.inList.get(j);
			int dx_tmp = 0;
			int dy_tmp = 0;

			Log.out(">>>>>>>>>>>child.type:"+child.type);
			Log.out(">>>>>>>>>>>child.data:"+child.data);

			if(self.type.equals("G1")||self.type.equals("C1")){
				Log.out("x="+self.x);
				Log.out("dx="+dx);
				child.x = self.x + dx;
				child.y = self.y;
				Log.out("x="+child.x);
				Log.out(child.data+"(x,y)=("+child.x+","+child.y+")");

				self.x = child.x;
				self.y = child.y;

				if(child.type.equals("C1")||child.type.equals("G1")){

					dx_tmp = 0;
				}
				dx = child.width;
				dy = 0;
			} 
			else if(self.type.equals("G2")||self.type.equals("C2")){
				Log.out("y="+self.y);
				Log.out("dy="+dy);
				child.y = self.y + dy;
				child.x = self.x;
				Log.out("y="+child.y);
				Log.out(child.data+"(x,y)=("+child.x+","+child.y+")");

				self.x = child.x;
				self.y = child.y;

				if(child.type.equals("C2")||child.type.equals("G2")){

					dy_tmp = 0;
				}
				dy = child.height;
				dx = 0;
				Log.out("child.height.dy="+dy+" child.type="+child.type+" child.data="+child.data);
			}
			else if(self.type.equals("G3")||self.type.equals("C3")){//morya wrote
				Log.out("y="+self.y);
				Log.out("dy="+dy);
				child.y = self.y;
				child.x = self.x;

				Log.out(child.data+"(x,y)=("+child.x+","+child.y+")");
				if(child.cthree==0){
					swf_env.int_config[left_counter][1] = child.x;
					swf_env.int_config[left_counter][2] = child.y;
					Log.out("left_counter="+left_counter);
					left_counter++;
				}

				self.x = child.x;
				self.y = child.y;

				if(child.type.equals("C3")||child.type.equals("G3")){

					//dy_tmp = 0;
				}
				dy = 0;//child.height;
				dx = 0;
			}

			if(!(child.type.equals("Att")||child.type.equals("Func")))


			set_position(child,dx_tmp,dy_tmp);

			j++;
		}

	}

	public void resize_cellC3 (SWFValue self){
		SWFValue child;
		int j=0;
		int num_of_child = self.inListC3Leaf.size();
		Log.out("num_of_childC3Leaf"+num_of_child+" self.type"+self.type);
		int w_tmp = 0;
		int h_tmp = 0;
		while(j<num_of_child){
			child = (SWFValue)self.inListC3Leaf.get(j);

			Log.out("*+++++++++++child.type:"+child.type);
			Log.out("*+++++++++++child.data:"+child.data);

			if(self.type.equals("G1")||self.type.equals("C1")){
				Log.out("intheight="+self.int_h);
				Log.out("intwidth="+self.int_w);
				child.int_h = self.int_h;

				if(j==num_of_child-1){
					//child.int_w = self.int_w - w_tmp;
					Log.out("child.intwidth:" +child.int_w);
				}
				else{
					w_tmp += child.int_w;
					Log.out("width:"+w_tmp);
				}
				Log.out(child.data+"(intw,inth)=("+child.int_w+","+child.int_h+")");
			}
			else if(self.type.equals("G2")||self.type.equals("C2")){
				Log.out("intwidth="+self.int_w);
				Log.out("intheight="+self.int_h);
				child.int_w = self.int_w;

				if(j==num_of_child-1){
					//child.int_h = self.int_h - h_tmp;
					Log.out("child.intheight:" +child.int_h);
				}
				else{
					Log.out("height:"+h_tmp);
					h_tmp += child.int_h;
				}
				Log.out(child.data+"(intw,inth)=("+child.int_w+","+child.int_h+")");
			}


			if(!(child.type.equals("Att")||child.type.equals("Func")))

			resize_cellC3(child);

			j++;

		}
	}
	public void set_positionC3 (SWFValue self, int dx, int dy){
		SWFValue child;
		int j=0;
		Log.out("self.inListC3Leaf.size="+self.inListC3Leaf.size()+" self.type="+self.type);
		while(j<self.inListC3Leaf.size()){
			child = (SWFValue)self.inListC3Leaf.get(j);
			int dx_tmp = 0;
			int dy_tmp = 0;

			Log.out(">>>>>>>>>>>child.type:"+child.type);
			Log.out(">>>>>>>>>>>child.data:"+child.data);

			if(self.type.equals("G1")||self.type.equals("C1")){
				Log.out("intx="+self.int_x);
				Log.out("dx="+dx);
				child.int_x = self.int_x + dx;
				child.int_y = self.int_y;

				Log.out("intx="+child.int_x);
				Log.out(child.data+"(intx,inty)=("+child.int_x+","+child.int_y+")");

				self.int_x = child.int_x;
				self.int_y = child.int_y;

				if(child.type.equals("C1")||child.type.equals("G1")){
					dx_tmp = 0;
				}
				dx = child.int_w;
				dy = 0;
			} 
			else if(self.type.equals("G2")||self.type.equals("C2")){
				Log.out("inty="+self.int_y);
				Log.out("dy="+dy);
				child.int_y = self.int_y + dy;
				child.int_x = self.int_x;
				Log.out("inty="+child.int_y);
				Log.out(child.data+"(intx,inty)=("+child.int_x+","+child.int_y+")");

				self.int_x = child.int_x;
				self.int_y = child.int_y;

				if(child.type.equals("C2")||child.type.equals("G2")){
					dy_tmp = 0;
				}
				dy = child.int_h;
				dx = 0;
				Log.out("child.height.dy="+dy+" child.type="+child.type+" child.data="+child.data);
			}//


			if(!(child.type.equals("Att")||child.type.equals("Func")))

			set_positionC3(child,dx_tmp,dy_tmp);

			j++;
		}

	}
	public void addWindowConfig(SWFValue parent, SWFValue stat_parent) {
		SWFValue child;
		Log.out("** self.type@="+parent.type);
		for(int j=0;j<parent.inList.size();j++){
			child = (SWFValue)parent.inList.get(j);
			Log.out(child.cthree+"@@@@G4@:child.type = " + child.type);
			if(child.type.equals("Att") || child.type.equals("Func")){
				if(child.cthree==0){
					Log.out(stat_parent.type+""+child.data+" window_y "+child.window_y+" k"+k);
					atwindow_x = child.window_x;
					atwindow_y = child.window_y;
					addWindowConfigLeaf(stat_parent);
					k++;
				}
			}
			addWindowConfig(child,stat_parent);
		}
	}

	public void addWindowConfigLeaf(SWFValue parent) {
		SWFValue childLeaf;
		for(int i=0;i<parent.inListC3Leaf.size();i++){
			childLeaf = (SWFValue)parent.inListC3Leaf.get(i);
			if(childLeaf.type.equals("Att") || childLeaf.type.equals("Func")){
				if(Integer.parseInt(childLeaf.lnum)-1==k){
					childLeaf.int_x += atwindow_x;
					childLeaf.int_y += atwindow_y;
					Log.out(childLeaf.lnum+""+childLeaf.data+" x "+childLeaf.int_x+" y "+childLeaf.int_y);
				}
			}
			addWindowConfigLeaf(childLeaf);
		}
	}

	public void writeTelopArray(){//this function is wroted by morya

		/*tname.deleteCharAt(tname.length()-1).append(");\n");
	    tdata.deleteCharAt(tdata.length()-1).append(");\n");
	    tx.deleteCharAt(tx.length()-1).append(");\n");
	    ty.deleteCharAt(ty.length()-1).append(");\n");
	    tw.deleteCharAt(tw.length()-1).append(");\n");
	    th.deleteCharAt(th.length()-1).append(");\n");
	    tcolor.deleteCharAt(tcolor.length()-1).append(");\n");
	    tsize.deleteCharAt(tsize.length()-1).append(");\n");
	    timefrom.deleteCharAt(timefrom.length()-1).append(");\n");
	    timeto.deleteCharAt(timeto.length()-1).append(");\n\n");*/
	    //kakikome
	    swf_env.allFrame.append(SWFEnv.tname);
	    swf_env.allFrame.append(SWFEnv.tdata);
	    swf_env.allFrame.append(SWFEnv.tx);
	    swf_env.allFrame.append(SWFEnv.ty);
	    swf_env.allFrame.append(SWFEnv.tw);
	    swf_env.allFrame.append(SWFEnv.th);
	    swf_env.allFrame.append(SWFEnv.tcolor);
	    swf_env.allFrame.append(SWFEnv.tsize);
	    swf_env.allFrame.append(SWFEnv.timefrom);
	    swf_env.allFrame.append(SWFEnv.timeto);
	}

	// edit tomo 2007.12.23
	public void writeArray(){
		imgpath.deleteCharAt(imgpath.length()-1).append(");\n");
		name.deleteCharAt(name.length()-1).append(");\n");
		data.deleteCharAt(data.length()-1).append(");\n");
		w.deleteCharAt(w.length()-1).append(");\n");
		h.deleteCharAt(h.length()-1).append(");\n");
		x.deleteCharAt(x.length()-1).append(");\n");
		y.deleteCharAt(y.length()-1).append(");\n");
		bgcolor.deleteCharAt(bgcolor.length()-1).append(");\n");
		bdcolor.deleteCharAt(bdcolor.length()-1).append(");\n");
		color.deleteCharAt(color.length()-1).append(");\n");
		size.deleteCharAt(size.length()-1).append(");\n");
		align.deleteCharAt(align.length()-1).append(");\n");
		margin.deleteCharAt(margin.length()-1).append(");\n");
		texttype.deleteCharAt(texttype.length()-1).append(");\n");
		mask.deleteCharAt(mask.length()-1).append(");\n");

		swf_env.allFrame.append(dur);
		swf_env.allFrame.append(imgpath);
		swf_env.allFrame.append(name);
		swf_env.allFrame.append(w);
		swf_env.allFrame.append(h);
		swf_env.allFrame.append(x);
		swf_env.allFrame.append(y);
		swf_env.allFrame.append(bgcolor);
		swf_env.allFrame.append(bdcolor);
		swf_env.allFrame.append(color);
		swf_env.allFrame.append(size);
		swf_env.allFrame.append(align);
		swf_env.allFrame.append(margin);
		swf_env.allFrame.append(texttype);
		swf_env.allFrame.append(mask);
		swf_env.allFrame.append(data);

	}
	public void writeInteraction(int i){
		int_name.deleteCharAt(int_name.length()-1).append(");\n");
		int_namet.deleteCharAt(int_namet.length()-1).append(");\n");
		int_x.deleteCharAt(int_x.length()-1).append(");\n");
		int_y.deleteCharAt(int_y.length()-1).append(");\n");
		int_w.deleteCharAt(int_w.length()-1).append(");\n");
		int_h.deleteCharAt(int_h.length()-1).append(");\n");
		int_bgcolor.deleteCharAt(int_bgcolor.length()-1).append(");\n");
		int_bdcolor.deleteCharAt(int_bdcolor.length()-1).append(");\n");
		int_color.deleteCharAt(int_color.length()-1).append(");\n");
		int_alpha.deleteCharAt(int_alpha.length()-1).append(");\n");
		int_size.deleteCharAt(int_size.length()-1).append(");\n");
		int_align.deleteCharAt(int_align.length()-1).append(");\n");
		int_margin.deleteCharAt(int_margin.length()-1).append(");\n");
		int_str.deleteCharAt(int_str.length()-1).append(");\n");
		lnum.deleteCharAt(lnum.length()-1).append(");\n");
		inter_imgpath.deleteCharAt(inter_imgpath.length()-1).append(");\n");
		inter_x.deleteCharAt(inter_x.length()-1).append(");\n");
		inter_y.deleteCharAt(inter_y.length()-1).append(");\n");
		inter_w.deleteCharAt(inter_w.length()-1).append(");\n");
		inter_h.deleteCharAt(inter_h.length()-1).append(");\n");
		inter_name.deleteCharAt(inter_name.length()-1).append(");\n");
		tmp.deleteCharAt(tmp.length()-1).append(");\n");
		limgnum.deleteCharAt(limgnum.length()-1).append(");\n");
		visibleflag.deleteCharAt(visibleflag.length()-1).append(");\n");
		lx.deleteCharAt(lx.length()-1).append(");\n");
		ly.deleteCharAt(ly.length()-1).append(");\n");
		lw.deleteCharAt(lw.length()-1).append(");\n");
		lh.deleteCharAt(lh.length()-1).append(");\n");
		lstop.deleteCharAt(lstop.length()-1).append(");\n");

		if(i==0){
			swf_env.allFrame.append(visibleflag);
			swf_env.allFrame.append(lx);
			swf_env.allFrame.append(ly);
			swf_env.allFrame.append(lw);
			swf_env.allFrame.append(lh);
			swf_env.allFrame.append(lstop);
			swf_env.allFrame.append("\n");

			swf_env.allFrame.append(int_name);
			swf_env.allFrame.append(int_namet);
			swf_env.allFrame.append(int_x);
			swf_env.allFrame.append(int_y);
			swf_env.allFrame.append(int_w);
			swf_env.allFrame.append(int_h);
			swf_env.allFrame.append(int_bgcolor);
			swf_env.allFrame.append(int_bdcolor);
			swf_env.allFrame.append(int_color);
			swf_env.allFrame.append(int_alpha);
			swf_env.allFrame.append(int_size);
			swf_env.allFrame.append(int_align);
			swf_env.allFrame.append(int_margin);
			swf_env.allFrame.append(int_str);
			swf_env.allFrame.append(lnum);
			swf_env.allFrame.append("\n");
			swf_env.allFrame.append(inter_imgpath);
			swf_env.allFrame.append(inter_x);
			swf_env.allFrame.append(inter_y);
			swf_env.allFrame.append(inter_w);
			swf_env.allFrame.append(inter_h);
			swf_env.allFrame.append(inter_name);
			swf_env.allFrame.append(tmp);
			swf_env.allFrame.append(limgnum);
			swf_env.allFrame.append("\n");

			swf_env.allFrame.append("createInteractionButton($visibleflag,$lx,$ly,$lw,$lh,$lstop,$int_name,$int_namet,$lnum,$inter_name,$tmp,$limgnum);\n");
			swf_env.allFrame.append("$addedImga = addInteractionImage($movie,$inter_imgpath,$inter_x,$inter_y,$inter_w,$inter_h,$inter_name);\n");
			swf_env.allFrame.append("addInteractionText($int_name,$int_namet,$int_x,$int_y,$int_w,$int_h,$int_bgcolor,$int_bdcolor,$int_color,$int_alpha,$int_size,$int_align,$int_margin,$int_str);\n");
			swf_env.allFrame.append("for($i=0;$i<count($visibleflag);$i++){\n");
			swf_env.allFrame.append("$vf .= \"$visibleflag[$i]=0; \";\n");
			swf_env.allFrame.append("}\n");
			swf_env.allFrame.append("for($i=0;$i<count($int_name);$i++){\n");
			swf_env.allFrame.append("$vf .= \"_root['$int_name[$i]']._visible = false;\n");
			swf_env.allFrame.append("_root['$int_namet[$i]']._visible = false; \";\n");
			swf_env.allFrame.append("}\n");
			swf_env.allFrame.append("for($i=0;$i<count($inter_name);$i++){\n");
			swf_env.allFrame.append("$vf .= \"_root.$inter_name[$i]._visible = false;\n");
			swf_env.allFrame.append("$tmp[$i] = _root.$inter_name[$i]._visible; \";\n");
			swf_env.allFrame.append("}\n");
			swf_env.allFrame.append("$movie->add(new SWFAction($vf));\n");
			swf_env.allFrame.append("$vf=\"\";\n");
			swf_env.allFrame.append("\n\n\n");

		}else{
			swf_env.allFrame.append("for($i=0;$i<count($addedImga);$i++)\n");
			swf_env.allFrame.append("$movie->remove($addedImga[$i]);\n\n");

			swf_env.allFrame.append(int_name);
			swf_env.allFrame.append(int_namet);
			swf_env.allFrame.append(int_x);
			swf_env.allFrame.append(int_y);
			swf_env.allFrame.append(int_w);
			swf_env.allFrame.append(int_h);
			swf_env.allFrame.append(int_bgcolor);
			swf_env.allFrame.append(int_bdcolor);
			swf_env.allFrame.append(int_color);
			swf_env.allFrame.append(int_alpha);
			swf_env.allFrame.append(int_size);
			swf_env.allFrame.append(int_align);
			swf_env.allFrame.append(int_margin);
			swf_env.allFrame.append(int_str);
			swf_env.allFrame.append("\n");
			swf_env.allFrame.append(inter_imgpath);
			swf_env.allFrame.append(inter_x);
			swf_env.allFrame.append(inter_y);
			swf_env.allFrame.append(inter_w);
			swf_env.allFrame.append(inter_h);
			swf_env.allFrame.append(inter_name);

			swf_env.allFrame.append("\n");

			swf_env.allFrame.append("$addedImga = addInteractionImage($movie,$inter_imgpath,$inter_x,$inter_y,$inter_w,$inter_h,$inter_name);\n");
			swf_env.allFrame.append("addImageTemp($inter_name,$tmp);\n");
			swf_env.allFrame.append("addInteractionText($int_name,$int_namet,$int_x,$int_y,$int_w,$int_h,$int_bgcolor,$int_bdcolor,$int_color,$int_alpha,$int_size,$int_align,$int_margin,$int_str);\n\n\n");
		}
	}


	//edit tomo 2007.12.23
	private void writeDispFunc(){
		//morya modify
		String func;
		if (swf_env.telop != "false"){
			func =
				"frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype,$mw,$tname,$tx,$ty,$tw,$th,$tcolor,$tsize,$timefrom,$timeto,$tstr);\n\n";
		}else {
			func =
				"frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype,$mw);\n\n";
		}
		//String func = "frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath);\n\n";
		//morya kokomade
//		String func = "frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath);\n\n";
//		String func = "frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype);\n\n";
//		String func = "frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype,$mw);\n\n";
		swf_env.allFrame.append(func);
		Log.out("@@@ write out dispFunc @@@");
	}

	public void makeTelopArray(SWFValue parent){//this function is wroted by morya

		tname.append("\"").append(parent.instanceTName).append("\",");
		Log.out("G4:value.tname = "+parent.instanceTName);
	    tdata.append("\"").append(parent.tdata).append("\",");
	    System.out.println("G4:value.tdata = "+parent.tdata);
	    tx.append(Float.toString(parent.tx)).append(",");
	    System.out.println("G4:value.tx = "+parent.tx);
	    ty.append(Float.toString(parent.ty)).append(",");
		System.out.println("G4:value.ty = "+parent.ty);
	    tw.append(Float.toString(parent.twidth)).append(",");
		Log.out("G4:value.tw = "+parent.twidth);
	    th.append(Float.toString(parent.theight)).append(",");
		Log.out("G4:value.th = "+parent.theight);
	    tcolor.append("\"").append(parent.tfontcolor).append("\",");
		Log.out("G4:value.tcolor = "+parent.tfontcolor);
	    tsize.append(Integer.toString(parent.tfontsize)).append(",");
		Log.out("G4:value.tsize = "+parent.tfontsize);
	    timefrom.append(Float.toString(parent.timefrom)).append(",");
	    System.out.println("G4:value.timefrom = "+parent.timefrom);
	    timeto.append(Float.toString(parent.timeto)).append(",");
	    System.out.println("G4:value.timeto = "+parent.timeto);
	}

	// edit tomo 2007.12.23
	public void makeArray1(SWFValue parent){

//		mask.append("\"").append(parent.mask).append(",");
//		Log.out("G4:value.mask = "+parent.mask);
		mask.append(Float.toString(parent.mask)).append(",");
		System.out.println("G4:value.mask = "+parent.mask);

		texttype.append("\"").append(parent.texttype).append("\",");
		Log.out("G4:value.texttype = "+parent.texttype);

		imgpath.append("\"").append(parent.imgpath).append("\",");
		Log.out("G4:value.imgpath = "+parent.imgpath);

		name.append("\"").append(parent.instanceName).append("\",");
		Log.out("G4:value.name = "+parent.instanceName);

		data.append("\"").append(parent.data).append("\",");
		System.out.println("G4:value.data = "+parent.data);

		x.append(Float.toString(parent.x)).append(",");
		System.out.println("G4:value.x = "+parent.x);

		y.append(Float.toString(parent.y)).append(",");
		System.out.println("G4:value.y = "+parent.y);

		w.append(Float.toString(parent.width)).append(",");
		Log.out("G4:value.w = "+parent.width);

		h.append(Float.toString(parent.height)).append(",");
		Log.out("G4:value.h = "+parent.height);

		bgcolor.append("\"").append(parent.bgcolor).append("\",");
		Log.out("G4:value.bgcolor = "+parent.bgcolor);

		bdcolor.append("\"").append(parent.bdcolor).append("\",");
		Log.out("G4:value.bdcolor = "+parent.bdcolor);

		color.append("\"").append(parent.fontcolor).append("\",");
		Log.out("G4:value.color = "+parent.fontcolor);

		size.append(Integer.toString(parent.fontsize)).append(",");
		Log.out("G4:value.size = "+parent.fontsize);

		align.append("\"").append(parent.align).append("\",");
		Log.out("G4:value.align = "+parent.align);

		margin.append(Float.toString(parent.margin)).append(",");
		Log.out("G4:value.margin = "+parent.margin);

		//int_name.append("\"").append(parent.interactionName).append("\",");
		//Log.out("qqq"+int_name);
		Log.out("-------------------------------------");

	}

	public void makeArray2(SWFValue parent) {
		SWFValue child;
		String type = parent.type;

		Log.out("** type="+type);
		Log.out("** parent.inList.size="+parent.inList.size());

		for(int j=0;j<parent.inList.size();j++){
			child = (SWFValue)parent.inList.get(j);

			Log.out("@@@@G4:child.type = " + child.type);
			if(child.type.equals("Att") || child.type.equals("Func")){

//				mask.append("\"").append(child.mask).append("\",");
//				Log.out("G4:value.mask = "+child.mask);
				mask.append(Float.toString(child.mask)).append(",");
				System.out.println("G4:value.mask = "+child.mask);


				texttype.append("\"").append(child.texttype).append("\",");
				Log.out("G4:value.texttype = "+child.texttype);

				imgpath.append("\"").append(child.imgpath).append("\",");
				Log.out("G4:value.imgpath = "+child.imgpath);

				name.append("\"").append(child.instanceName).append("\",");
				Log.out("G4:value.name = "+child.instanceName);

				data.append("\"").append(child.data).append("\",");
				System.out.println("G4:value.data = "+child.data);

				x.append(Float.toString(child.x)).append(",");
				System.out.println("G4:value.x = "+child.x);

				y.append(Float.toString(child.y)).append(",");
				System.out.println("G4:value.y = "+child.y);

				w.append(Float.toString(child.width)).append(",");
				Log.out("G4:value.w = "+child.width);

				h.append(Float.toString(child.height)).append(",");
				Log.out("G4:value.h = "+child.height);

				bgcolor.append("\"").append(child.bgcolor).append("\",");
				Log.out("G4:value.bgcolor = "+child.bgcolor);

				bdcolor.append("\"").append(child.bdcolor).append("\",");
				Log.out("G4:value.bdcolor = "+child.bdcolor);

				color.append("\"").append(child.fontcolor).append("\",");
				Log.out("G4:value.color = "+child.fontcolor);

				size.append(Integer.toString(child.fontsize)).append(",");
				Log.out("G4:value.size = "+child.fontsize);

				align.append("\"").append(child.align).append("\",");
				Log.out("G4:value.align = "+child.align);

				margin.append(Float.toString(child.margin)).append(",");
				Log.out("G4:value.margin = "+child.margin);

				//int_name.append("\"").append(child.interactionName).append("\",");
				//Log.out("qqq"+int_name);
				Log.out("-------------------------------------");
			}
			makeArray2(child);
		}

	}

	public void makeIntConfig(){
		//SWFIntConfig child;
		//SWFValue pos = (SWFValue)swf_env.final_value.inList.get(i);
		for(int j=0;j<swf_env.visibleflag_count;j++){
			visibleflag.append("\"vlf").append(Integer.toString(swf_env.int_config[j][0]-1)).append("\",");
			lx.append(Integer.toString(swf_env.int_config[j][1])).append(",");
			ly.append(Integer.toString(swf_env.int_config[j][2])).append(",");
			lw.append(Integer.toString(swf_env.int_config[j][3])).append(",");
			lh.append(Integer.toString(swf_env.int_config[j][4])).append(",");
			lstop.append(Integer.toString(swf_env.int_config[j][5])).append(",");
		}
		if(swf_env.visibleflag_count==0){
			visibleflag.append("\"");
			lx.append("\"");
			ly.append("\"");
			lw.append("\"");
			lh.append("\"");
			lstop.append("\"");
		}
	}

	public void makeIntArray(SWFValue parent) {

		SWFValue child;
		String type = parent.type;

		Log.out("** type="+type);
		Log.out("** parent.inList.size="+parent.inListC3.size());

		if(swf_env.cthree_string!=0){
			for(int j=0;j<parent.inListC3.size();j++){
				child = (SWFValue)parent.inListC3.get(j);

				Log.out("@@@@G4:child.type = " + child.type);
				if(child.type.equals("Att") || child.type.equals("Func")){

					int_name.append("\"").append(child.interactionName).append("\",");
					int_namet.append("\"").append(child.interactionNamet).append("\",");
					int_x.append(Integer.toString(child.int_x)).append(",");
					int_y.append(Integer.toString(child.int_y)).append(",");
					int_w.append(Integer.toString(child.int_w)).append(",");
					int_h.append(Integer.toString(child.int_h)).append(",");
					int_bgcolor.append("\"").append(child.int_bgcolor).append("\",");
					int_bdcolor.append("\"").append(child.int_bdcolor).append("\",");
					int_color.append("\"").append(child.int_color).append("\",");
					int_alpha.append(Integer.toString(child.int_alpha)).append(",");
					int_size.append(Integer.toString(child.int_size)).append(",");
					int_align.append("\"").append(child.int_align).append("\",");
					int_margin.append(Integer.toString(child.int_margin)).append(",");
					int_str.append("\"").append(child.int_str).append("\",");
					lnum.append(Integer.toString(Integer.parseInt(child.lnum)-1)).append(",");

					/*visibleflag.append("\"").append(child.visibleflag).append("\",");
					lx.append(Integer.toString(child.lx)).append(",");
					ly.append(Integer.toString(child.ly)).append(",");
					lw.append(Integer.toString(child.lw)).append(",");
					lh.append(Integer.toString(child.lh)).append(",");
					lstop.append(Integer.toString(child.lstop)).append(",");*/

					Log.out("qqq"+int_name);
					Log.out("-------------------------------------");
				}
				makeIntArray(child);
				//makeArray2(child);
			}
		}else{
			int_name.append("\"");
			int_namet.append("\"");
			int_x.append("\"");
			int_y.append("\"");
			int_w.append("\"");
			int_h.append("\"");
			int_bgcolor.append("\"");
			int_bdcolor.append("\"");
			int_color.append("\"");
			int_alpha.append("\"");
			int_size.append("\"");
			int_align.append("\"");
			int_margin.append("\"");
			int_str.append("\"");
			lnum.append("\"");
		}



	}

	public void makeIntImgArray(SWFValue parent) {
		SWFValue child;
		String type = parent.type;

		Log.out("** type="+type);
		Log.out("** parent.inListC3Img.size="+parent.inListC3Img.size());


		if(swf_env.cthree_func!=0){
			for(int j=0;j<parent.inListC3Img.size();j++){
				child = (SWFValue)parent.inListC3Img.get(j);

				Log.out("@@@@G4:child.type = " + child.type);
				if(child.type.equals("Att") || child.type.equals("Func")){

					inter_imgpath.append("\"").append(child.inter_imgpath).append("\",");
					inter_x.append(Integer.toString(child.int_x)).append(",");
					inter_y.append(Integer.toString(child.int_y)).append(",");
					inter_w.append(Integer.toString(child.int_w)).append(",");
					inter_h.append(Integer.toString(child.int_h)).append(",");
					inter_name.append("\"").append(child.inter_name).append("\",");
					tmp.append("\"").append(child.tmp).append("\",");
					limgnum.append(Integer.toString(Integer.parseInt(child.lnum)-1)).append(",");

					Log.out("-------------------------------------");
				}
				makeIntImgArray(child);
				//makeArray2(child);
			}
		}else{
			inter_imgpath.append("\"");
			inter_x.append("\"");
			inter_y.append("\"");
			inter_w.append("\"");
			inter_h.append("\"");
			inter_name.append("\"");
			tmp.append("\"");
			limgnum.append("\"");
		}
	}

	public void savePHP(){
		String phpfilepath = swf_env.outdir + swf_env.filename + ".php";
		Log.out("[SWFManager:savePHP]phpfilepath = "+ phpfilepath);
		System.out.println("[SWFManager:savePHP]phpfilepath = "+ phpfilepath);
		try {
			FileOutputStream fos = new FileOutputStream(phpfilepath);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(swf_env.header);
			pw.println(swf_env.controlAS);
			pw.println(swf_env.function);
			pw.println(swf_env.allFrame);
			pw.println(swf_env.footer);
			pw.close();
		} catch (FileNotFoundException fe) {
			System.out.println("Error: specified outdirectory \""
					+ swf_env.outdir + "\" is not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void executeMing(){
		String command = "php " + swf_env.filename + ".php";
		try {
			Process process = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void finish(){
		savePHP();
		Log.out("::: finished :::");
		/*
		if(!swf_env.dynamicFlag){
			executeMing();
		}
		 */
	}

}
