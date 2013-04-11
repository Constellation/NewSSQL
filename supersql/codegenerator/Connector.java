package supersql.codegenerator;

import java.util.ArrayList;

import supersql.common.Log;
import supersql.extendclass.ExtList;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Grouper;
import supersql.codegenerator.XML.XMLAttribute; //ryuryu
import supersql.codegenerator.XML.XMLC0;//ryuryu

public class Connector implements Operator{

    int id; // SchemaID

	int Dimension;

	public int tfeitems;

	public ExtList tfes;

	//hanki start
	boolean order_flag;
	boolean aggregate_flag;
	String order;
    String aggregate;
    //hanki end

    //oka start
    public static boolean update_flag;

    public static boolean insert_flag;

    public static boolean delete_flag;
    //oka end
    public static boolean login_flag;
    public static boolean logout_flag;

	public DecorateList decos = new DecorateList();

	public Connector() {
			//hanki start
		order_flag = false;
		aggregate_flag = false;
	    //hanki end

		Dimension = -1;
		tfeitems = 0;
		tfes = new ExtList();
	}

	public Connector(int d) {
			//hanki start
		order_flag = false;
		aggregate_flag = false;
	    //hanki end

		Dimension = d;
		tfeitems = 0;
		tfes = new ExtList();
	}

	public void setId(int i) {
	    id = i;
	}
	public int getId() {
	    return id;
	}

	public void setTFE(TFE t) {
		tfeitems++;
		tfes.add(t);
	}

	public void setDeco(DecorateList d) {
		decos = d;
	}

	public void addDeco(String key, Object val) {
		decos.put(key, val);
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
			((TFE) tfes.get(i)).debugout(count + 1);
		}
		dbgout.prt(count, "</Connector>");
	}

	public ExtList makesch() {

		ExtList outsch = new ExtList();

		for (int i = 0; i < tfeitems; i++) {
			outsch.addAll(((TFE) tfes.get(i)).makesch());
		}

		//Log.out("Con outsch:"+outsch);

		return outsch;

	}

	public ExtList makele0() {

		ExtList le0 = new ExtList();

		le0.add(this.getSymbol());

		for (int i = 0; i < tfeitems; i++) {
			le0.add(((TFE) tfes.get(i)).makele0());
		}

		Log.out("Con le0:" + le0);

		return le0;

	}

	public String getSymbol() {
		return "C?";
	}

	public void work(ExtList data_info) {
	}

	public int countconnectitem() {
		int items = 0;
		for (int i = 0; i < tfes.size(); i++) {
			items += ((TFE) tfes.get(i)).countconnectitem();
		}
		return items;
	}

	private ExtList data;

	private int sindex, dindex;

	public void setDataList(ExtList d) {
		data = d;
		sindex = 0;
		dindex = 0;
		//Log.out("tfes : " + tfes);
		//Log.out("data : " + d);
	}

	public boolean hasMoreItems() {
		return (sindex < tfes.size());
	}

	public void worknextItem() {
		TFE tfe = (TFE) tfes.get(sindex);
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

		TFE tfe = (TFE) tfes.get(sindex);
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
		return (TFE) tfes.get(i);
	}
	//hanki start
	public void setOrderBy(String order) {
		order_flag = true;

		this.order = new String();
		this.order = order;
	}

	public void setAggregate(String aggregate) {
		aggregate_flag = true;

		this.aggregate = new String();
		this.aggregate = aggregate;
	}
	//hanki end

	//added by ria 20110913 start
	public ExtList makeschImage() {
		ExtList outsch = new ExtList();

		for (int i = 0; i < tfeitems; i++) {
			outsch.addAll(((TFE) tfes.get(i)).makeschImage());
		}
		return outsch;
	}
	//added by ria 20110913 end

	public void addDeco(String key, String val, String condition) {
		decos.put(key, val, condition);
		
	}
}
