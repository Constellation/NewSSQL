package supersql.dataconstructor.optimizer.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.dataconstructor.optimizer.attributes.Attribute;

public class DatabaseManager {
	private String url, driver, user, password;
	private Connection connection;
	private DatabaseMetaData metadata;
	
	/**
	 * Constructs an connection instance to a database, and perform the connection
	 * @param ur the url of the database
	 * @param d the driver url of the DBMS
	 * @param us the login identifier for this session (possibly null)
	 * @param pass the password for this session (possibly null)
	 */
	public DatabaseManager(String ur, String d, String us, String pass){
		url = ur;
		driver = d;
		user = us;
		password = pass;
	}
	
	public void openConnection() throws Exception{
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			Log.err("Error[DatabaseManager]: " + e.getMessage());
			throw e;
		}
	}
	
	/**
	 * Execute a query. The returned result is an list of tuples.
	 * @param query the query to execute
	 * @return the list of tuples corresponding to this query
	 */
	public List<Tuple> executeQuery(String query, Map<String, Attribute> mapNameAttribute) throws Exception{
		ResultSet resultSet = null;
		ArrayList<Tuple>  result = new ArrayList<Tuple>();
		try{
			Statement stmt = connection.createStatement();
			resultSet = stmt.executeQuery(query);
			ResultSetMetaData metaData = resultSet.getMetaData();
			int nbColumns = metaData.getColumnCount();
			ArrayList<String> columnNames = new ArrayList<String>();
			
			for(int i=1; i<=nbColumns; i++){
				columnNames.add(metaData.getColumnName(i));
			}
			
			while(resultSet.next()){
				Tuple tuple = new Tuple();
				for(int i=1; i<=nbColumns; i++){
					String value = resultSet.getString(i);
					Attribute att = mapNameAttribute.get(columnNames.get(i-1));
					if(value != null)
						tuple.addValue(att, value);
					else tuple.addValue(att, "");
				}
				result.add(tuple);
			}
		}catch(SQLException e){
			Log.err("Error[DatabaseManager]: " + e.getMessage());
			Log.err("Involved query: " + query);
			throw e;
		}
		
		return result;
	}
	
	
	/**
	 * Performs the update specified by the query.
	 * @param query the query to be executed
	 */
	public void executeUpdate(String query) throws Exception{
		try{
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}catch(SQLException e){
			Log.err("Error[DatabaseManager]: " + e.getMessage());
			Log.err("Involved query: " + query);
			throw e;
		}
	}
	
    public boolean hasTable(String name) throws Exception{
    	boolean result = false;
    	try{
	    	ResultSet rs;
	    	String dbms = GlobalEnv.getdbms();
	    	
	    	getMetadata();
	    	
	    	if(dbms.equals("postgresql"))
				rs = metadata.getTables(null, "public", name, new String[] {"TABLE"});
			else rs = metadata.getTables(null, null, name, new String[] {"TABLE"});
			
			result =  rs.first();
    	}catch(Exception e){
    		Log.err("Error[DatabaseManager]: " + e.getMessage());
    		throw e;
    	}
    	
    	return result;
    }
    
    public Collection<String> getPrimaryKeys(String tableName) throws Exception{
    	getMetadata();
    	
    	Collection<String> result = new ArrayList<String>();
    	try{
    		ResultSet rs = metadata.getPrimaryKeys(null, null, tableName);
    		while(rs.next())
    			result.add(rs.getString("COLUMN_NAME"));
    	}catch(Exception e){
    		String msg = "Error[DatabaseManager]: can't get primary keys of table " + tableName;
    		Log.err(msg);
    		GlobalEnv.addErr(msg);
    		throw e;	
    	}
    	
    	return result;
    }
	
	
	/**
	 * Closes the connection with the database
	 */
	public void closeConnection() throws Exception{
		try{
			connection.close();
		}catch(Exception e){
			Log.err("Error[DatabaseManager]: " + e.getMessage());
			throw e;
		}
	}
	
	private void getMetadata() throws Exception{
		try{
			if(metadata == null)
				metadata = connection.getMetaData();
		}catch(Exception e){
			Log.err("Error[DatabaseManager]: " + e.getMessage());
			throw e;
		}
	}
}
