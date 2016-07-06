package supersql.dataconstructor.optimizer.database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

import supersql.dataconstructor.optimizer.attributes.Attribute;

public class Tuple {
	private HashSet<Attribute> attributes; //The list of attributes used to define this tuple
	private Hashtable<Attribute, String> tabAttributeValue; // The mapping attribute/value
	
	/**
	 * Constructs an empty tuple.
	 */
	public Tuple(){
		attributes = new HashSet<Attribute>();
		tabAttributeValue = new Hashtable<Attribute, String>();
	}
	
	
	/**
	 * Adds a value to the tuple for the specified attribute.
	 * @param attribute the attribute corresponding to the value to add
	 * @param value the value to add
	 */
	public void addValue(Attribute attribute, String value){
		attributes.add(attribute);
		tabAttributeValue.put(attribute, value);
	}
	
	
	/**
	 * Gets the value for the specified attributes.
	 * @param attribute the attribute we want the value for this tuple
	 * @return the value corresponding to the specified attribute
	 */
	public String getValue(Attribute attribute){
		return tabAttributeValue.get(attribute);
	}
	
	
	/**
	 * Returns the list of attributes defining this tuple.
	 * @return the list of attributes defining this tuple
	 */
	public HashSet<Attribute> getAttributesList(){
		return attributes;
	}
	
	public Tuple getSubTuple(ArrayList<Attribute> atts){
		Tuple result = new Tuple();
		for(Attribute att : attributes){
			if(atts.contains(att))
				result.addValue(att, tabAttributeValue.get(att));
		}
		return result;
	}
	
	public boolean equals(Object tuple){
		if(tuple instanceof Tuple)
			return this.tabAttributeValue.equals(((Tuple) tuple).tabAttributeValue);
		else return false;
	}
	
	public int hashCode(){
		return tabAttributeValue.hashCode();
	}
	
	public String toString(){
		String result = " ";
		for(Attribute att : attributes){
			result += tabAttributeValue.get(att) + " ";
		}
		return result;
	}
}
