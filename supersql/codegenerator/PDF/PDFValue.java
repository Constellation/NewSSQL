package supersql.codegenerator.PDF;

import java.util.Vector;
import supersql.extendclass.ExtList;

//文字列１つ１つに関する情報に関する値をまとめたクラス
public class PDFValue {
	
	//追加11.29
	float originalWidth, originalHeight;
	//追加10.17
	String type;
	float box_width, box_height;
	ExtList inList;
	String data = "null";
	float data_width, data_height;
	float padding;
	String align = "left";
	String valign = "top";
	String bgcolor = "null";
	String fontcolor = "null";
	String fontstyle = "normal";
	String bordercolor = "null";
	
	//追加10.31 Grouper
	ExtList columns;
	ExtList columnWidths;
	int columnNum;
	//11.09
	ExtList rows;
	ExtList rowHeights;
	int rowNum;
	
	//追加11.25 折り畳む時に指定した幅でボックスサイズをつくるため
	float fold;
	
	//変更11.3 Stringへ 11.10 ２つに変更
	String labelH;
	String labelV;
	
	String labelOH;
	String labelOV;
	
	//追加12.13
	//boolean widthFLAG = false;
	//boolean heightFLAG = false;
	boolean foldFLAG_H = false;
	boolean foldFLAG_V = false;
	int tfeID;
	
	
	
	String filename = "null";
	

	
	String s;

	int yoko = 1;

	int tate = 1;

	int x = 1;

	int y = 1;

	int element;

	//float width;
	//float height;

	int left = 10;

	int under = 700;

	int i;

	int font;

	float fontsize;

	int row = 1;

	float box_x;

	float box_y;

	int image_num = -1;

	float scale = (float) 1.0;

	Vector text_box = new Vector();

	String text_line[];

	boolean set_width = false;

	float s_width;

	boolean bg_rgb = false;
	boolean font_rgb = false;

	int alternate;
	
	//追加10.17
	//コンストラクタ
	public PDFValue(String type){
		this.type = type;
		this.inList = new ExtList();
	}

}