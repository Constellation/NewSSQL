package supersql.codegenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Asc_Desc {
	
	public static ArrayList<AscDesc> asc_desc = new ArrayList<>();

	//Asc_Desc
	public Asc_Desc() {
		
	}
	
	//addOrderBy
	public void addOrderBy(String order, String token) {
		//Log.info("order="+order+", token="+token);
		try{
			if(order.toLowerCase().startsWith("asc")){
				int no = Integer.parseInt(order.substring(3));
				asc_desc.add(new AscDesc(no, token+" ASC"));
			}else{
				int no = Integer.parseInt(order.substring(4));
				asc_desc.add(new AscDesc(no, token+" DESC"));
			}
		}catch(Exception e){}
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
