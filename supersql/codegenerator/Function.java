package supersql.codegenerator;

import java.util.Hashtable;

import supersql.common.Log;
import supersql.extendclass.ExtList;

public class Function extends TFE implements IOperand {

	String Name; 

	int argitems; 

	ExtList Args; 

    //hanki start
	boolean order_flag;
	boolean aggregate_flag;
	String order;
    String aggregate;
    //hanki end
    
	Hashtable ArgHash = new Hashtable();

	public DecorateList decos = new DecorateList();

	public Function() {
		//hanki start
		order_flag = false;
		aggregate_flag = false;
	    //hanki end
	    
		Name = "";
		argitems = 0;
		Args = new ExtList();

	}

	public void setId(int i) {
	    id = i;
	}
	public int getId() {
	    return id;
	}

	public void setFname(String name) {

		Name = name;

	}

	public void setArg(FuncArg fa) {
		argitems++;
		Args.add(fa);
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
		dbgout.prt(count, "<Function Name=" + Name + " argitems=" + argitems
				+ " decoitems=" + decos.size() + " id=" + id + ">");

		for (int i = 0; i < Args.size(); i++) {
			((FuncArg) Args.get(i)).debugout(count + 1);
		}

		decos.debugout(count + 1);

		dbgout.prt(count, "</Function>");
	}

	public ExtList makesch() {

		ExtList outsch = new ExtList();
		ExtList outsch1 = new ExtList();

		for (int i = 0; i < Args.size(); i++) {
			outsch1 = ((FuncArg) Args.get(i)).makesch();
			if (!outsch1.isEmpty()) {
				outsch.addAll(outsch1);
			}
		}

		//  Log.out("Fnc outsch:"+outsch);

		return outsch;

	}

	public ExtList makele0() {

		ExtList le0 = new ExtList();
		ExtList le0_1 = new ExtList();

		for (int i = 0; i < Args.size(); i++) {
			le0_1 = ((FuncArg) Args.get(i)).makele0();
			if (!le0_1.isEmpty()) {
				le0.addAll(le0_1);
			}
		}

		Log.out("Fnc le0:" + le0);

		return le0;

	}

	public void work(ExtList data_info) {
		Log.out("*Function");
	}

	public int countconnectitem() {
		int items = 0;

		for (int i = 0; i < Args.size(); i++) {
			items += ((FuncArg) Args.get(i)).countconnectitem();
		}

		//		Log.out("*Function connect item = " + items);
		return items;
	}

	public ExtList getArgs() {
		return Args;
	}

	public void setDataList(ExtList data) {

		
		int dindex = 0;
		int ci;
		FuncArg fa;
		//Log.out("data = " + data);
		for (int i = 0; i < Args.size(); i++) {
			fa = (FuncArg) Args.get(i);
			ci = fa.countconnectitem();
			//		Log.out("ci = "+ci);
			fa.setData(data.ExtsubList(dindex, dindex + ci));
			//		Log.out("key = "+fa.getKey());
			if (Name.equalsIgnoreCase("foreach")){
				ArgHash.put(Integer.toString(i), fa);
			} else {
				ArgHash.put(fa.getKey(), fa);
			}
			dindex += ci;
		}

	}

	public String getAtt(String Key) {
		return getAtt(Key, "");
	}

	public String getAtt(String Key, String default_str) {
		FuncArg fa = (FuncArg) ArgHash.get(Key);
		if (fa == null) {
			return default_str;
		}
		String ret = fa.getStr();
		if (ret == null) {
			return default_str;
		} else {
			return ret;
		}
	}

	public String getFuncName() {
		return Name;
	}

	public void workAtt(String Key) {
		FuncArg fa = (FuncArg) ArgHash.get(Key);

		if (fa != null) {
			fa.workAtt();
		}
		return;
	}

	public String getClassName() {

		FuncArg fa;
		String result = null;

		//Log.out("data = " + data);
		for (int i = 0; i < Args.size(); i++) {
			fa = (FuncArg) Args.get(i);
			if (fa.getKey().equalsIgnoreCase("class")) {
			    result = fa.getStr();
			}
		}
		
		Log.out("getClassName = "+result);
		return result;

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
		ExtList outsch1 = new ExtList();

		for (int i = 0; i < Args.size(); i++) {
			outsch1 = ((FuncArg) Args.get(i)).makeschImage();
			if (!outsch1.isEmpty()) {
				outsch.addAll(outsch1);
			}
		}

		return outsch;
	}
	//added by ria 20110913 end

	public void addDeco(String name, String value, String condition) {
		decos.put(name, value,condition);

	}
	
}
