package supersql.dataconstructor.optimizer;

import supersql.dataconstructor.optimizer.attributes.TfePath;

public class StringLiteral {
	private String string;
	private TfePath path;
	
	public StringLiteral(String s, TfePath p){
		string = s;
		path = p;
	}
	
	public String getString(){
		return string;
	}
	
	public TfePath getPath(){
		return path;
	}
	
	public boolean equals(Object o){
		if(o instanceof StringLiteral)
			return ((StringLiteral) o).string.equals(string) && ((StringLiteral) o).path.equals(path);
		return false;
	}
	
	public int hashCode(){
		return string.hashCode();
	}
}


