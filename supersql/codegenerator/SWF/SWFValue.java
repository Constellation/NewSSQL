/*
 * Created on 2004/11/26 by mai
 */
package supersql.codegenerator.SWF;

import supersql.extendclass.ExtList;

public class SWFValue {
	String type;
	ExtList inList;
	ExtList inListC3;
	ExtList inListC3Img;
	ExtList inListC3Leaf;

	int width, height;
//	2007.12.16 tomo
//	int x=10, y=10;
	int x=10, y=30;
	int margin=3;
	int data_width, data_height;

	String instanceName = "null";
	String data = "null";
	String imgpath = "noimage";

	int level;
	int img;

//	2007.12.16 tomo
	int duration=3000;
//	int duration=1000;
	String align = "left";
	String valign = "middle";
	String bgcolor = "0xffffff";
	String bdcolor = "0x000000";
//	edit tomo 2007.12.23
	String texttype = "normal";
	int mask = -1;
	int fontsize = 14;
	String fontcolor = "0x000000";
	String fontstyle = "normal";
	String bordercolor = "0x000000";
	//morya wrote
	String instanceTName = "null";
    String tdata = "null";
    int tx=10, ty=10;
    int twidth=100, theight=50;
    String tfontcolor = "0x000000";
    int tfontsize = 14;
    int timefrom = 0;
    int timeto = -1;

    String interactionName = "null";
    String interactionNamet = "null";
    String inter_name = "null";
    String tmp = "null";

    int int_x=10, int_y=30, int_w=100, int_h=20;
    String int_bgcolor = "0xffffff";
    String int_bdcolor = "0x000000";
    String int_color = "0x000000";
    int int_alpha=100, int_size=14;
    String int_align = "left";
    int int_margin = 3;
    String int_str = "null";
    String lnum = "null";
    String inter_imgpath = "noimage";
    //int inter_x=0, inter_y=0, inter_w=100, inter_h=50;
    //String limgnum = "null";

    String visibleflag = "null";
    int lx=10, ly=10, lw=100, lh=50, lstop=0;
    int window_x=0, window_y=0;
    int cthree = -1;
	//morya kokomade

	public SWFValue(String type){
		this.type = type;
		this.inList = new ExtList();
		this.inListC3 = new ExtList();
		this.inListC3Img = new ExtList();
		this.inListC3Leaf = new ExtList();
	}

}
