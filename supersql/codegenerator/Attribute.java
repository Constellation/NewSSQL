package supersql.codegenerator;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import supersql.common.Log;
import supersql.extendclass.ExtHashSet;
import supersql.extendclass.ExtList;
import supersql.parser.Preprocessor;

public class Attribute implements Operand {

    int id; // SchemaID

	int AttNo;

	int AttCounts = 0;

	protected String AttName;
	protected String AttName1;
	protected String AttName2;
	private int AttNo1;
	protected ArrayList<String> AttNames = new ArrayList<String>();

	private int AttNo2;
	private String condition;


	int AttType;
	
    //hanki start
	boolean order_flag;
	boolean aggregate_flag;
	String order;
    String aggregate;
    //hanki end
	
	public DecorateList decos = new DecorateList();

	//  String SQLimage;
	//  ExtList UseAtts;
	//  ExtHashSet UseTables;

	String ValKey;

	protected ExtList Items = new ExtList();
	
	boolean conditional;

	public Attribute() {
			//hanki start
		order_flag = false;
		aggregate_flag = false;
		conditional = false;
	    //hanki end
	}
	
	public Attribute(Boolean b) {
		//hanki start
		order_flag = false;
		aggregate_flag = false;
		conditional = b;
		//hanki end
	}

	public void setId(int i) {
	    id = i;
	}
	public int getId() {
	    return id;
	}

	public int setItem(int no, String nm, String attimg, String key,
			Hashtable attp) {

		if(conditional){
			AttNames.add(nm);
		}else
		{
			AttNo = no;
			AttName = nm;
			AttNames.add(nm);
		}
		ValKey = key;

		//tk/////////////////////////////////////////////////////////////////
		StringTokenizer st0 = new StringTokenizer(attimg, "\"+", true);		
		//StringTokenizer st0 = new StringTokenizer(attimg, "\\\"+", true);
		//tk//////////////////////////////////////////////////////////////////
		String ch1, buf;
		AttributeItem item;
		while (st0.hasMoreTokens()) {
			ch1 = st0.nextToken();
			if (ch1.equals("+")) {
				continue;
			}
			if (ch1.equals("\"")) {
				// quoted str
				buf = "";
				while (st0.hasMoreTokens()) {
					ch1 = st0.nextToken();
					if (ch1.equals("\\")) {
						buf += ch1;
						buf += st0.nextToken();
					} else if (ch1.equals("\"")) {
						Items.add(new AttributeItem(buf));
						break;
					}
					buf += ch1;
				}
			} else {
				if (ch1.equals("+") || ch1.equals("\\")) {
					Exception e = new Exception();
				}
				item = new AttributeItem(ch1, no);
				Items.add(item);
				attp.put(new Integer(no), item);
				no++;
			}
		}
		Log.out("[set Attribute] Attribute Items : " + Items);
		Log.out("[set Attribute] Sch: " + this.makesch());

		AttCounts = no - AttNo - AttNo1;
		return no;

	}

	public void setDeco(DecorateList d) {
		decos = d;
	}

	public void addDeco(String key, Object val) {
		if(key.equals("insert")||key.equals("update")||key.equals("delete")||key.equals("login")){
			decos.put(key, AttName);
			return;
		}
		decos.put(key, val);
	}

	public void debugout() {
		debugout(0);
	}

	public void debugout(int count) {

		Debug dbgout = new Debug();
		dbgout.prt(count, "<Attribute No=" + AttNo + " AttName=" + AttName
				+ " AttType=" + AttType + " decoitems=" + decos.size() + " id=" + id + ">");
		if (ValKey != null) {
			dbgout.prt(count + 1, "<ValKey>");
			dbgout.prt(count + 2, ValKey);
			dbgout.prt(count + 1, "</ValKey>");
		}
		dbgout.prt(count + 1, "<AttributeItems>");
		for (int i = 0; i < Items.size(); i++) {
			((AttributeItem) Items.get(i)).debugout(count + 2);
			decos.put("attributeName", Items.get(i).toString());//add by chie
		}
		dbgout.prt(count + 1, "</AttributeItems>");

		decos.debugout(count + 1);

		dbgout.prt(count, "</Attribute>");
	}

	public ExtList makesch() {
		ExtList outsch = new ExtList();

		for (int i = 0; i < Items.size(); i++) {
			outsch.addAll(((AttributeItem) Items.get(i)).makesch());
		}


		//  Log.out("Att outsch:"+outsch);
		//hanki start
		if (order_flag) {
			Preprocessor.putOrderByTable(order, outsch);
			order_flag = false;
		} 
		
		if (aggregate_flag) {
			Preprocessor.putAggregateList(outsch, aggregate);
			aggregate_flag = false;
		}
		//hanki end
		return outsch;
	}

	public ExtList makele0() {

		ExtList attno = new ExtList();
		//  attno.add("Att");

		for (int i = 0; i < Items.size(); i++) {
			attno.addAll(((AttributeItem) Items.get(i)).makele0());
		}

		Log.out("Att le0:" + attno);

		return attno;
	}

	public void work(ExtList data_info) {
		Log.out("Attribute : " + data_info.getStr());
	}

	public String getStr(ExtList data_info) {
		
		String str = "";
		
		if(conditional){
			String toCompare = ((ExtList) data_info.get(Items.size()-1-decos.getConditionsSize())).getStr();
			if(toCompare.equals("t") || toCompare.equals("1")){
				str = ((ExtList) data_info.get(0)).getStr();
			}
			else if(toCompare.equals("f") || toCompare.equals("0")){
				if(Items.size()-decos.getConditionsSize() == 3)
					str = ((ExtList) data_info.get(1)).getStr();
				else
					str = "";
			}
			else throw new IllegalStateException();
			return str;
		}
		else{
			//	Log.out("data_info : " + data_info);
			for (int i = 0; i < Items.size()-decos.getConditionsSize(); i++) {
				//		Log.out("data_info : " +
				// ((AttributeItem)Items.get(i)).getStr(data_info, AttNo));
				str += (((AttributeItem) Items.get(i)).getStr(data_info, AttNo-decos.getConditionsSize()));
			}			//	Log.out("Attribute out : " + str);
			return str;
		}
		
		
	}
	

	public int countconnectitem() {
		int itemcount = 0;
		for (int i = 0; i < Items.size(); i++) {
			itemcount += ((AttributeItem) Items.get(i)).countconnectitem();
		}
		return itemcount;
	}

	public DecorateList get_DecorateList() {
		return decos;
	}

	public ExtHashSet getUseTablesAll() {
		ExtHashSet rs = new ExtHashSet();
		for (int i = 0; i < Items.size(); i++) {
			rs.add(((AttributeItem) Items.get(i)).getUseTables());
		}
		return rs;
	}

	@Override
	public String toString() {
		if(AttNames.size() > 1)
			return AttNames.toString();
		else
			return AttName;
			
	}

	public String getKey() {
		return this.ValKey;
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

		for (int i = 0; i < Items.size(); i++) {
			outsch.addAll(((AttributeItem) Items.get(i)).makeschImage());
		}
		
		return outsch;
	}
	//added by ria 20110913 end

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void addDeco(String key, String val, String condition) {
		if(key.equals("insert")||key.equals("update")||key.equals("delete")||key.equals("login")){
			decos.put(key, AttName, condition);
			return;
		}
		decos.put(key, val, condition);
	}
	
}
