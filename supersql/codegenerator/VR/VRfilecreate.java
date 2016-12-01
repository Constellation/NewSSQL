package supersql.codegenerator.VR;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;

import javax.print.attribute.standard.RequestingUserName;

import org.stringtemplate.v4.compiler.STParser.ifstat_return;

import com.ibm.db2.jcc.am.s;

//import jdk.nashorn.internal.ir.annotations.Ignore;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.parser.queryParser.SortingContext;

public class VRfilecreate {
	///////exharray == 2の時は何もできないけど、残しとく

	private static final String fs = GlobalEnv.OS_FS;
	//private static final String outdirPath = GlobalEnv.getOutputDirPath();
	private static String filename;

	public static void process(String outFileName) {
		filename = outFileName;
		String b = "";
		String s = "";/////ジャンル出す

		
		//VRcjoinarray test = new VRcjoinarray("generate VR\r[shape,[name],]! ! [color,[name],], \nfrom basic;");
		VRcjoinarray.getJoin();
		
//		for(int n=0; n<VRAttribute.genrearray22.size() ;n++){
//			System.out.println("hey="+VRAttribute.genrearray22.get(n));
//		}
		
//		System.out.println(VRAttribute.groupcount);
		VRAttribute.groupcount1 = VRAttribute.cjoinarray.size()+1;
		

		for(int n=0; n<VRAttribute.cjoinarray.size();n++){
			System.out.println("hey="+VRAttribute.cjoinarray.get(n));
		}
		//System.out.println(VRAttribute.groupcount);

		if(VRAttribute.groupcount == 0){//////ビルが一個だけだった時
			VRAttribute.groupcount = 1;
			b = getCS1();
			for(int i=1; i<=VRAttribute.groupcount; i++){
				b += "				if(groupflag ==" + i + "){\n";


				for(int k=0; k<VRAttribute.genrearray2.size(); k++){/////ジャンル出すはじめ
					s += VRAttribute.genrearray2.get(k)+",";
				}
				s = s.substring(0,s.length()-1);/////最後のカンマとる
				b += getCS2(VRAttribute.exharray.get(i-1),s);
				s = "";////////ジャンル出す終わり

				if(VRAttribute.floorarray.get(i-1) == 1){
					 b += "					int objx = 0;/////////////museum change";
					 b += "\n";
				}else if(VRAttribute.floorarray.get(i-1) == 2){
				}else if(VRAttribute.floorarray.get(i-1) == 3){
					b += "					int objz = 0;/////////////museum change";
					b += "\n";
				}
				b += getCS3();
				b += getCS4(VRAttribute.exharray.get(i-1), VRAttribute.floorarray.get(i-1));
				b += getCS5();
				b += getCS6(VRAttribute.floorarray.get(i-1));
				b += getCS7(VRAttribute.floorarray.get(i-1));
			}
		}else{
			b = getCS1();
			for(int i=1; i<=VRAttribute.groupcount1; i++){
				if(i == 1){
					b += "				if(groupflag == " + i + "){\n";
				}else{
					b += "				}else if(groupflag == " + i + "){\n";
				}

				if(i != 1){
					int a = VRAttribute.genrearray22.get(i-1) - VRAttribute.genrearray22.get(i-2);
					if(",".equals(VRAttribute.cjoinarray.get(i-2))){
						if(VRAttribute.floorarray.get(i-2) == 1){
							b +="					billmovex += " + -50*a + ";\n";
						}else if(VRAttribute.floorarray.get(i-2) == 2){
							b +="					billmovex += -50;\n";
						}else{
							b +="					billmovex += -50;\n";
							b +="					billmovez += " + -30*(a-1) + ";\n";
						}
					}else if("!".equals(VRAttribute.cjoinarray.get(i-2))){
						if(VRAttribute.floorarray.get(i-2) == 1){
							b +="					billmovex += " + -50*(a-1) + ";\n";
							b +="					billmovey += 20;\n";
						}else if(VRAttribute.floorarray.get(i-2) == 2){
							b +="					billmovey += " + 20*a + ";\n";
						}else{
							b +="					billmovey += 20;\n";
							b +="					billmovez += " + -30*(a-1) + ";\n";
						}
					}else if("%".equals(VRAttribute.cjoinarray.get(i-2))){
						if(VRAttribute.floorarray.get(i-2) == 1){
							b +="					billmovex += " + -50*(a-1) + ";\n";
							b +="					billmovez += -30;\n";
						}else if(VRAttribute.floorarray.get(i-2) == 2){
							b +="					billmovez += -30;\n";
						}else{
							b +="					billmovez += " + -30*a + ";\n";
						}
					}
				}


				for(int k=VRAttribute.genrearray22.get(i-1); k<VRAttribute.genrearray22.get(i); k++){/////ジャンル出すはじめ
					s += VRAttribute.genrearray2.get(k)+",";
				}
				s = s.substring(0,s.length()-1);/////最後のカンマとる
				b += getCS2(VRAttribute.exharray.get(VRAttribute.genrearray22.get(i)-1),s);
				s = "";////////ジャンル出す終わり


				if(VRAttribute.floorarray.get(i-1) == 1){
					 b += "					int objx = 0;/////////////museum change";
					 b += "\n";
				}else if(VRAttribute.floorarray.get(i-1) == 2){
				}else if(VRAttribute.floorarray.get(i-1) == 3){
					b += "					int objz = 0;/////////////museum change";
					b += "\n";
				}
				b += getCS3();
				b += getCS4(VRAttribute.exharray.get(VRAttribute.genrearray22.get(i)-1), VRAttribute.floorarray.get(i-1));
				b += getCS5();
				b += getCS6(VRAttribute.floorarray.get(i-1));
				b += getCS7(VRAttribute.floorarray.get(i-1));

			}
		}
		b += getCS8();
		createfile(outFileName+".cs", b);
	}

	private static String getCS1(){
		return
"using System;\n"+
//using System.Collections.Generic;
"using System.ComponentModel;\n"+
//using System.Data;
//using System.Drawing;
"using System.Linq;\n"+
"using System.Text;\n"+
//using System.Windows.Forms;
"using System.Xml;\n"+
"using UnityEngine;\n"+
"using System.Collections;\n"+
"\n"+
"public class NewBehaviourScript : MonoBehaviour {\n"+
"	static int billmovex = 0;\n"+
"	static int billmovey = 0;\n"+
"	static int billmovez = 0;\n"+
"	void Start () {\n"+
"	GameObject[] array = new GameObject[100];\n"+
"	GameObject obj1 = new GameObject();///二つ目からのビルの移動のため\n"+
"	String[] sarray = new String[100];///////////////////テキスト生成\n"+
"	int groupflag = 1;\n"+
"\n"+
"	XmlDocument xmlDocument = new XmlDocument();\n"+
"	xmlDocument.Load(\""+filename+".xml\");\n"+
"	XmlElement elem = xmlDocument.DocumentElement; //elem.Nameはdoc\n"+
	"\n"+
"		if (elem.HasChildNodes == true) {\n"+
"	        XmlNode childNode2 = elem.FirstChild;\n"+

"	        while (childNode2 != null) {\n";

}

	private static String getCS2(int exhflag,String s){
		if(exhflag == 1){
			return
					"\n"+
"					String[] genrearray = {"+ s + "};///////////タイトル表示\n"+

"					int[] xarray = new int[100];\n"+
"					int[] xxarray = new int[100];/////////////G1 change\n"+
"					int[] zarray = new int[100];\n"+
"					int r;\n"+
"					float objhigh = 3.0f;\n"+
"					float standhigh = 1.25f;\n"+
"					int museumcount = 0;\n"+
"				\n"+

"					for(int n=10,k=0; n >= -10; n = n-5,k++){///////////////ここら辺G1 change\n"+
"						zarray[k] = n;\n"+
"					}\n"+

"					for(int m=20, l=0; m >= -20; m = m-5,l++){	\n"+
"						xxarray[l] = m;\n"+
"					}\n"+
"					for(int p=0, q=0; p<50; p++,q++){    	\n"+
"						if(q == 9){\n"+
"							q=0;\n"+
"						}\n"+
"						xarray[p] = xxarray[q];	\n"+
"					}   \n"+
"\n";
		}else if(exhflag == 3){
			return
					"\n"+
"					String[] genrearray = {"+ s + "};///////////タイトル表示\n"+
"					int[] xarray = new int[100];\n"+
"					int[] zarray = new int[100];\n"+
"					int[] zzarray = new int[100];\n"+
"					int r;\n"+
"					float objhigh = 3.0f;\n"+
"					float standhigh = 1.25f;\n"+
"					int museumcount = 0;\n"+
"					\n"+

"					for(int n=20,k=0; n >= -20; n = n-5,k++){\n"+
"						xarray[k] = n;\n"+
"					}\n"+

"					for(int m=10, l=0; m >= -10; m = m-5,l++){	\n"+
"						zzarray[l] = m;\n"+
"					}\n"+
"					for(int p=0, q=0; p<50; p++,q++){    	\n"+
"						if(q == 5){\n"+
"							q=0;\n"+
"						}\n"+
"						zarray[p] = zzarray[q];	\n"+
"					}\n"+
"\n";
		}else{
			return "";
		}
	}

	private static String getCS3(){
		return
"		        	if(childNode2.HasChildNodes == true){\n"+
"	        			XmlNode childNode = childNode2.FirstChild; ////////category\n"+
"	///////////group追加 end\n"+
"				        while (childNode != null) { //childNode.Nameはcategory\n"+
"				        	museumcount++;\n"+

"				          	if (childNode.HasChildNodes == true) {\n"+
"					            for (int i=0; i < childNode.ChildNodes.Count; i++) {\n"+
"					              	XmlNode dataNode= childNode.ChildNodes[i]; //dataNode.NameはShapeというか二種類目のcategory\n"+
"						            for (int j=0; j < dataNode.ChildNodes.Count; j++) {     /////element\n"+

"					                	XmlNode xmlAttr = dataNode.ChildNodes[j]; //xmlAttrはkindCubekind  \n"+        
"					                	//array[j] = GameObject.Find(xmlAttr.InnerText);//オブジェクト一個一個の場所移動\n"+
"										array[j] = Instantiate(Resources.Load(xmlAttr.InnerText)) as GameObject;///////bill change\n"+

"					                	XmlNode xmlAttr = dataNode.ChildNodes[j]; //xmlAttrはkindCubekind  \n"+
"					                	array[j] = GameObject.Find(xmlAttr.InnerText);//オブジェクト一個一個の場所移動\n"+

"										sarray[j] = xmlAttr.InnerText;//オブジェクトのテキスト生成のため\n";
	}

	private static String getCS4(int exhflag, int floorflag){
		if(exhflag == 1){
			if(floorflag == 1){
		return
"										r = j/9;//////////////G1 change \n"+
"										if(j == 0){ //xmAttr.Nameはkind, xml.InnerTextはCubeとか \n"+
"											r = 0; \n"+
"										} \n"+
"						\n"+
"										array[j].transform.position  = new Vector3 (xarray[j]+objx, objhigh, zarray[r]);////////////G1 change \n"+
"										array[j].transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"\n"+
"										//stand生成 \n"+
"										GameObject stand = Instantiate(Resources.Load(\"Prefab/Stand\")) as GameObject; \n"+
"										stand.transform.position= new Vector3(xarray[j]+objx, standhigh, zarray[r]); /////////////G1 change \n"+
"										stand.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"										\n"+
"										//オブジェクトのテキスト生成 \n"+
"										GameObject  messageText = Instantiate(Resources.Load(\"Prefab/TextPrefab\")) as GameObject; \n"+
"										messageText.GetComponent<TextMesh>().text = sarray[j].ToString(); \n"+
"										messageText.transform.Rotate(0,180,0); \n"+
"										messageText.transform.position= new Vector3(xarray[j]+1.0f+objx, standhigh+0.9f, zarray[r]);  \n"+
"										messageText.transform.localScale = new Vector3(0.5f, 0.5f, 0.5f);\n "+
"										messageText.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n";
			}else if(floorflag ==2){
				return
"										r = j/9;//////////////G1 change \n"+
"										if(j == 0){ //xmAttr.Nameはkind, xml.InnerTextはCubeとか \n"+
"											r = 0; \n"+
"										} \n"+
"						\n"+
"										array[j].transform.position  = new Vector3 (xarray[j], objhigh, zarray[r]);////////////G1 change \n"+
"										array[j].transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"\n"+
"										//stand生成 \n"+
"										GameObject stand = Instantiate(Resources.Load(\"Prefab/Stand\")) as GameObject; \n"+
"										stand.transform.position= new Vector3(xarray[j], standhigh, zarray[r]); /////////////G1 change \n"+
"										stand.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"										\n"+
"										//オブジェクトのテキスト生成 \n"+
"										GameObject  messageText = Instantiate(Resources.Load(\"Prefab/TextPrefab\")) as GameObject; \n"+
"										messageText.GetComponent<TextMesh>().text = sarray[j].ToString(); \n"+
"										messageText.transform.Rotate(0,180,0); \n"+
"										messageText.transform.position= new Vector3(xarray[j]+1.0f, standhigh+0.9f, zarray[r]);  \n"+
"										messageText.transform.localScale = new Vector3(0.5f, 0.5f, 0.5f);\n "+
"										messageText.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n";

			}else if(floorflag == 3){
				return
"										r = j/9;//////////////G1 change \n"+
"										if(j == 0){ //xmAttr.Nameはkind, xml.InnerTextはCubeとか \n"+
"											r = 0; \n"+
"										} \n"+
"						\n"+
"										array[j].transform.position  = new Vector3 (xarray[j], objhigh, zarray[r]+objz);////////////G1 change \n"+
"										array[j].transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"\n"+
"										//stand生成 \n"+
"										GameObject stand = Instantiate(Resources.Load(\"Prefab/Stand\")) as GameObject; \n"+
"										stand.transform.position= new Vector3(xarray[j], standhigh, zarray[r]+objz); /////////////G1 change \n"+
"										stand.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"										\n"+
"										//オブジェクトのテキスト生成 \n"+
"										GameObject  messageText = Instantiate(Resources.Load(\"Prefab/TextPrefab\")) as GameObject; \n"+
"										messageText.GetComponent<TextMesh>().text = sarray[j].ToString(); \n"+
"										messageText.transform.Rotate(0,180,0); \n"+
"										messageText.transform.position= new Vector3(xarray[j]+1.0f, standhigh+0.9f, zarray[r]+objz);  \n"+
"										messageText.transform.localScale = new Vector3(0.5f, 0.5f, 0.5f);\n "+
"										messageText.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n";
			}else{
				return"";
			}

		}else if(exhflag == 3){
			if(floorflag == 1){
				return
"										r = j/5; \n"+
"										if(j == 0){ //xmAttr.Nameはkind, xml.InnerTextはCubeとか \n"+
"											r = 0; \n"+
"										} \n"+
"					\n"+
"										array[j].transform.position  = new Vector3 (xarray[r]+objx, objhigh, zarray[j]); \n"+
"										array[j].transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"\n"+
"										//stand生成 \n"+
"										GameObject stand = Instantiate(Resources.Load(\"Prefab/Stand\")) as GameObject; \n"+
"										stand.transform.position= new Vector3(xarray[r]+objx, standhigh, zarray[j]);  \n"+
"										stand.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"			\n"+
"										//オブジェクトのテキスト生成 \n"+
"										GameObject  messageText = Instantiate(Resources.Load(\"Prefab/TextPrefab\")) as GameObject; \n"+
"										messageText.GetComponent<TextMesh>().text = sarray[j].ToString(); \n"+
"										messageText.transform.Rotate(0,180,0); \n"+
"										messageText.transform.position= new Vector3(xarray[r]+1.0f+objx, standhigh+0.9f, zarray[j]);  \n"+
"										messageText.transform.localScale = new Vector3(0.5f, 0.5f, 0.5f); \n"+
"										messageText.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n";
			}else if(floorflag == 2){
			return
"										r = j/5; \n"+
"										if(j == 0){ //xmAttr.Nameはkind, xml.InnerTextはCubeとか \n"+
"											r = 0; \n"+
"										} \n"+
"					\n"+
"										array[j].transform.position  = new Vector3 (xarray[r], objhigh, zarray[j]); \n"+
"										array[j].transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"\n"+
"										//stand生成 \n"+
"										GameObject stand = Instantiate(Resources.Load(\"Prefab/Stand\")) as GameObject; \n"+
"										stand.transform.position= new Vector3(xarray[r], standhigh, zarray[j]);  \n"+
"										stand.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+

"			\n"+	
"										//オブジェクトのテキスト生成 \n"+
"										GameObject  messageText = Instantiate(Resources.Load(\"Prefab/TextPrefab\")) as GameObject; \n"+
"										messageText.GetComponent<TextMesh>().text = sarray[j].ToString(); \n"+
"										messageText.transform.Rotate(0,180,0); \n"+
"										messageText.transform.position= new Vector3(xarray[r]+1.0f, standhigh+0.9f, zarray[j]);  \n"+
"										messageText.transform.localScale = new Vector3(0.5f, 0.5f, 0.5f); \n:"+
"										messageText.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n";

			}else if(floorflag == 3){
				return
"										r = j/5; \n"+
"										if(j == 0){ //xmAttr.Nameはkind, xml.InnerTextはCubeとか \n"+
"											r = 0; \n"+
"										} \n"+
"					\n"+
"										array[j].transform.position  = new Vector3 (xarray[r], objhigh, zarray[j]+objz); \n"+
"										array[j].transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"\n"+
"										//stand生成 \n"+
"										GameObject stand = Instantiate(Resources.Load(\"Prefab/Stand\")) as GameObject; \n"+
"										stand.transform.position= new Vector3(xarray[r], standhigh, zarray[j]+objz);  \n"+
"										stand.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
"			\n"+
"										//オブジェクトのテキスト生成 \n"+
"										GameObject  messageText = Instantiate(Resources.Load(\"Prefab/TextPrefab\")) as GameObject; \n"+
"										messageText.GetComponent<TextMesh>().text = sarray[j].ToString(); \n"+
"										messageText.transform.Rotate(0,180,0); \n"+
"										messageText.transform.position= new Vector3(xarray[r]+1.0f, standhigh+0.9f, zarray[j]+objz);  \n"+
"										messageText.transform.localScale = new Vector3(0.5f, 0.5f, 0.5f); \n"+
"										messageText.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n";
			}else{
				return "";
			}
		}else{
			return "";
		}
	}

	private static String getCS5(){
		return
"										//オブジェクトを縮小or拡大、展示用\n"+
"										float nx = array[j].transform.lossyScale.x; \n"+
"										float ny = array[j].transform.lossyScale.y; \n"+
"										float nz = array[j].transform.lossyScale.z; \n"+
		"\n"+
"										float max = nx; \n"+
"										if(max < ny){ \n"+
"											max = ny; \n"+
"										} \n"+
"										if(max < nz){ \n"+
"											max = nz; \n"+
"										} \n"+
"										max = max*1.5f; \n"+
"										array[j].transform.localScale = new Vector3(nx/max, ny/max, nz/max); \n"+
"									} \n"+
"								} \n"+
"							} \n"+
"							childNode = childNode.NextSibling; \n";
	}
	private static String getCS6(int floorflag){

				if(floorflag == 1){
			return
"							objx += -50;/////////////////////////////museumchange\n"+
"						}	\n"+
"					}\n";
		}else if(floorflag ==2){
			return
"							objhigh += 20.0f;\n"+
"	     			       standhigh += 20.0f;\n"+
"	     			   }\n"+
"					}\n";
		}else if(floorflag == 3){
			return
"							objz += -50;/////////////////////////////museumchange\n"+
"						}	\n"+
"					}\n";
		}else{
			return "";
		}
	}


	private static String getCS7(int floorflag){
			if(floorflag == 1){
				return
	"					//museum生成\n"+
	"			 		for(int i=0; i<1; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/Wallx\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(25, 10, 0);  /////////////////////////////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					for(int i=0; i<museumcount; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/DoorMuseum\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(-50*i, 0, 0);  /////////////////////////////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					for(int i=0; i<museumcount; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/Wallz\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(-50*i,10, 15);  /////////////////////////////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					for(int i=0; i<museumcount; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/Wallz\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(-50*i,10, -15);  /////////////////////////////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					for(int i=0; i<1; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/Wallx\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(25-(museumcount)*50,10, 0);  /////////////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					//タイトル生成\n"+
	"					for(int i=0; i<museumcount; i++){\n"+
	"						GameObject  messageText1 = Instantiate(Resources.Load(\"Prefab/TextPrefab\")) as GameObject; \n"+
	"						messageText1.GetComponent<TextMesh>().text = genrearray[i].ToString(); \n"+
	"						messageText1.transform.Rotate(0,180,0); \n"+
	"						messageText1.transform.position= new Vector3(-15-50*i, 15, -13);\n"+
	"						messageText1.transform.localScale = new Vector3(3.5f, 3.5f, 3.5f); \n"+
	"						messageText1.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}	\n"+
	"					childNode2 = childNode2.NextSibling;\n";
			}else if(floorflag == 2){
				return
	"					//museum生成\n"+
	"					for(int i=0; i<museumcount; i++){	\n"+
	"						GameObject museum1= Instantiate(Resources.Load(\"Prefab/Wallz\")) as GameObject;///本当はいる　中見えないから消してる\n"+
	"						museum1.transform.position = new Vector3(0, 10+20*i, 15); /////////museum change\n"+
	"						museum1.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"\n"+
	"						GameObject museum2= Instantiate(Resources.Load(\"Prefab/Wallz\")) as GameObject;\n"+
	"						museum2.transform.position = new Vector3(0, 10+20*i, -15); /////////museum change\n"+
	"						museum2.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"\n"+
	"						GameObject museum3= Instantiate(Resources.Load(\"Prefab/DoorMuseum\")) as GameObject;\n"+
	"						museum3.transform.position = new Vector3(0, 20*i, 0); /////////museum change\n"+
	"						museum3.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"\n"+
	"						GameObject museum4= Instantiate(Resources.Load(\"Prefab/Wallx\")) as GameObject;\n"+
	"						museum4.transform.position = new Vector3(25, 10+20*i, 0); /////////museum change\n"+
	"						museum4.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"\n"+
	"						GameObject museum5= Instantiate(Resources.Load(\"Prefab/Wallx\")) as GameObject;\n"+
	"						museum5.transform.position = new Vector3(-25, 10+20*i, 0); /////////museum change\n"+
	"						museum5.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"\n"+
	"					//タイトル生成\n"+
	"						GameObject  messageText1 = Instantiate(Resources.Load(\"Prefab/TextPrefab\")) as GameObject; \n"+
	"						messageText1.GetComponent<TextMesh>().text = genrearray[i].ToString(); \n"+
	"						messageText1.transform.Rotate(0,180,0); \n"+
	"						messageText1.transform.position= new Vector3(-15, 15+20*i, -13);\n"+
	"						messageText1.transform.localScale = new Vector3(3.5f, 3.5f, 3.5f); 		\n"+
	"						messageText1.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					childNode2 = childNode2.NextSibling;\n";

			}else if(floorflag == 3){
				return
	"					//museum生成  \n"+
	"					for(int i=0; i<1; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/Wallz\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(0, 10, 15); /////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					for(int i=0; i<museumcount; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/DoorMuseum\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(0, 0, -30*i); /////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					for(int i=0; i<museumcount; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/Wallx\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(25, 10, -30*i); /////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					for(int i=0; i<museumcount; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/Wallx\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(-25, 10, -30*i); /////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}		\n"+
	"					for(int i=0; i<1; i++){	\n"+
	"						GameObject museum= Instantiate(Resources.Load(\"Prefab/Wallz\")) as GameObject;\n"+
	"						museum.transform.position= new Vector3(0, 10, 15-30*museumcount); //本当は15-30*(museumcount-1)/////////museum change\n"+
	"						museum.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}\n"+
	"					//タイトル生成\n"+
	"					for(int i=0; i<museumcount; i++){\n"+
	"						GameObject  messageText1 = Instantiate(Resources.Load(\"Prefab/TextPrefab\")) as GameObject; \n"+
	"						messageText1.GetComponent<TextMesh>().text = genrearray[i].ToString(); \n"+
	"						messageText1.transform.Rotate(0,180,0); \n"+
	"						messageText1.transform.position= new Vector3(-15, 15, -13-30*i);\n"+
	"						messageText1.transform.localScale = new Vector3(3.5f, 3.5f, 3.5f); \n"+
	"						messageText1.transform.position  += new Vector3 (billmovex, billmovey, billmovez); \n"+
	"					}					 \n"+
	"					childNode2 = childNode2.NextSibling;\n";

			}else{
				return "";
			}
	}
	private static String getCS8(){
		return
"				}\n"+
"				groupflag++;\n"+
"			}/////////group追加end\n"+
"		}\n"+
"	}\n"+
"}\n";
	}




	/////////////////こっから先はディレクトリ生成について　今はまだ使ってない
	private static void createfile(String fn, String content){
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(
							fn), "UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		pw.println(content);
		pw.close();
	}


	//directoryCopy
	private static Boolean directoryCopy(File fromDir, File toDir) {
		File[] fromFile = fromDir.listFiles();
		toDir = new File(toDir.getPath() + fs + fromDir.getName());

		toDir.mkdir();

		if (fromFile != null) {
			for (File f : fromFile) {
				if (f.isFile()) {
					if (!fileCopy(f, toDir)) {
						return false;
					}
				} else {
					if (!directoryCopy(f, toDir)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	//fileCopy
	private static Boolean fileCopy(File file, File dir) {
		File copyFile = new File(dir.getPath() + fs + file.getName());

		if (!copyFile.isHidden()) {	//if it's not a hidden file
			FileChannel channelFrom = null;
			FileChannel channelTo = null;

			try {
				copyFile.createNewFile();
				channelFrom = new FileInputStream(file).getChannel();
				channelTo = new FileOutputStream(copyFile).getChannel();
				channelFrom.transferTo(0, channelFrom.size(), channelTo);
				return true;
			} catch (IOException e) {
				return false;
			} finally {
				try {
					if (channelFrom != null) {
						channelFrom.close();
					}
					if (channelTo != null) {
						channelTo.close();
					}
					copyFile.setLastModified(file.lastModified());	//copy the update date
				} catch (IOException e) {
					return false;
				}
			}
		}
		return true;
	}


	private static boolean createFile(String fileName, String content) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter
					(new FileOutputStream(fileName), "UTF-8")));
			pw.println(content);
			pw.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
