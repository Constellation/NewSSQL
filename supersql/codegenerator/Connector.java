package supersql.codegenerator;

import java.util.ArrayList;

import supersql.common.Log;
import supersql.extendclass.ExtList;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Grouper;
import supersql.codegenerator.XML.XMLAttribute; //ryuryu
import supersql.codegenerator.XML.XMLC0;//ryuryu

public class Connector extends Operator{

	public int tfeitems;
	public ExtList<TFE> tfes;

    //oka start
    public static boolean update_flag;
    public static boolean insert_flag;
    public static boolean delete_flag;
    //oka end
    public static boolean login_flag;
    public static boolean logout_flag;

	public Connector() {
		super();
		Dimension = -1;
		tfeitems = 0;
		tfes = new ExtList<TFE>();
	}

	public Connector(int d) {
		super();
		Dimension = d;
		tfeitems = 0;
		tfes = new ExtList<TFE>();
	}

	public void setTFE(ITFE t) {
		tfeitems++;
		tfes.add((TFE) t);
	}

	public void debugout() {
		debugout(0);
	}

	public void debugout(int count) {
		Debug dbgout = new Debug();
		dbgout.prt(count, "<Connector type=" + getSymbol() + " tfeitems="
				+ tfeitems + " decoitems=" + decos.size() + " id=" + id + ">");

		decos.debugout(count + 1);

		for (int i = 0; i < tfeitems; i++) {
			((ITFE) tfes.get(i)).debugout(count + 1);
		}
		dbgout.prt(count, "</Connector>");
	}

	public ExtList<TFE> makesch() {
		ExtList<TFE> outsch = new ExtList<TFE>();
		for (int i = 0; i < tfeitems; i++) {
			outsch.addAll(((ITFE) tfes.get(i)).makesch());
		}
		return outsch;
	}

	public ExtList makele0() {
		ExtList le0 = new ExtList();
		le0.add(this.getSymbol());
		for (int i = 0; i < tfeitems; i++) {
			le0.add(((ITFE) tfes.get(i)).makele0());
		}

		Log.out("Con le0:" + le0);
		return le0;
	}

	public String getSymbol() {
		return "C?";
	}

	public int countconnectitem() {
		int items = 0;
		for (int i = 0; i < tfes.size(); i++) {
			items += ((ITFE) tfes.get(i)).countconnectitem();
		}
		return items;
	}

	private int sindex, dindex;

	public void setDataList(ExtList d) {
		data = d;
		sindex = 0;
		dindex = 0;
	}

	public boolean hasMoreItems() {
		return (sindex < tfes.size());
	}

	public void worknextItem() {
		ITFE tfe = (ITFE) tfes.get(sindex);
		int ci = tfe.countconnectitem();

		//Log.out("ci : " + ci);

		ExtList subdata = data.ExtsubList(dindex, dindex + ci);

		if (tfe instanceof Connector || tfe instanceof Attribute
				|| tfe instanceof Function || tfe instanceof IfCondition) {
			tfe.work(subdata);
		}
		else {
			tfe.work((ExtList) subdata.get(0));
		}
		sindex++;
		dindex += ci;

	}

	//ryuryu start////////////////////////////////////////////////
	public void worknextItem_GENERATEXML() {

		ITFE tfe = (ITFE) tfes.get(sindex);
		Log.out("tfe : " + tfe);

		int ci = tfe.countconnectitem();

		if(tfe instanceof Connector || tfe instanceof Grouper){

			if(XMLAttribute.tagcount >= 1){
				XMLC0.xml_env.code.append(">");
				XMLC0.xml_env.code.append(XMLAttribute.tag_value);
				XMLC0.xml_env.code.append("</" + XMLAttribute.tag + ">");
				XMLAttribute.tagcount = 0;
			}

			else if(XMLC0.parent_attflag == 1){
				XMLC0.xml_env.code.append(">");
			}
		}

		ExtList subdata = data.ExtsubList(dindex, dindex + ci);
		Log.out("subdata : " + subdata);

		if (tfe instanceof Connector || tfe instanceof Attribute
				|| tfe instanceof Function) {
			tfe.work(subdata);
		} else {
			tfe.work((ExtList) subdata.get(0));
		}
		sindex++;
		dindex += ci;
		Log.out("tfe.countconnectitem() : " + ci);
	}
	//ryuryu end////////////////////////////////////////////////


	public boolean isFirstItem() {
	    return (sindex == 0);
	}

	public TFE gettfe(int i) {
		return tfes.get(i);
	}

	//added by ria 20110913 start
	public ExtList makeschImage() {
		ExtList outsch = new ExtList();
		for (int i = 0; i < tfeitems; i++) {
			outsch.addAll(((ITFE) tfes.get(i)).makeschImage());
		}
		return outsch;
	}
	//added by ria 20110913 end

	public void addDeco(String key, String val, String condition) {
		decos.put(key, val, condition);
		
	}
}
