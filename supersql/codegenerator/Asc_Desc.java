package supersql.codegenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import supersql.codegenerator.Asc_Desc.AscDesc;
import supersql.codegenerator.Asc_Desc.AscDescComparator;
import supersql.common.Log;

public class Asc_Desc {

	public static ArrayList<ArrayList<AscDesc>> asc_desc_Array = new ArrayList<>();
	public static ArrayList<AscDesc> asc_desc = new ArrayList<>();

	//Asc_Desc
	public Asc_Desc() {
		
	}
	public static int dynamicCount = 0;
	private static int ascCount = 0;
	private static int descCount = 0;

	//addOrderBy
	public void addOrderBy(String order, String token) {
		//Log.info("order="+order+", token="+token);
		int no = 0;
		if(order.toLowerCase().startsWith("asc")){
			try{
				no = Integer.parseInt(order.substring(3));
			}catch(Exception e){
				no = ++ascCount;
			}
			add_asc_desc(no, token+" ASC");
		}else{
			try{
				no = Integer.parseInt(order.substring(4));
			}catch(Exception e){
				no = ++descCount;
			}
			add_asc_desc(no, token+" DESC");
		}
//		try{
//			if(order.toLowerCase().startsWith("asc")){
//				int no = Integer.parseInt(order.substring(3));
//				asc_desc.add(new AscDesc(no, token+" ASC"));
//			}else{
//				int no = Integer.parseInt(order.substring(4));
//				asc_desc.add(new AscDesc(no, token+" DESC"));
//			}
//		}catch(Exception e){ }
	}
	
	//add
	public void add_asc_desc_Array() {
		asc_desc_Array.add(dynamicCount, asc_desc);
		asc_desc = new ArrayList<AscDesc>();
	}
	//add
	private void add_asc_desc(int no, String AscDesc) {
		//System.out.println(no+" "+AscDesc);
		asc_desc.add(new AscDesc(no, AscDesc));
	}

	//sorting
	public void sorting() {
		Collections.sort(asc_desc, new AscDescComparator());
	}
	
	
	//AscDesc
	public class AscDesc {
		private int no;
		private String ascDesc;
		
		public AscDesc(int no, String ascDesc) {
			this.no = no;
			this.ascDesc = ascDesc;
		}
		public int getNo(){
			return this.no;
		}
		public String getAscDesc(){
			return this.ascDesc;
		}
	}
	//AscDescComparator
	public class AscDescComparator implements Comparator<AscDesc> {
		public int compare(AscDesc a, AscDesc b) {
			int no1 = a.getNo();
			int no2 = b.getNo();
			//asc sort
			if (no1 > no2) {
				return 1;
			} else if (no1 == no2) {
				return 0;
			} else {
				return -1;
			}
		}
	}

}
