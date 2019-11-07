package ODIN_VALIDATOR_APITEST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {
//
//	public static void main(String[] args) throws InterruptedException, SQLException {
//	ConnectDB.executeQuerryDB(DataBaseConsts.CLEAN_DB ,DataBaseConsts.strUserID, DataBaseConsts.strPassword, DataBaseConsts.dbURL);
//	
//	ConnectDB.executeQuerryDB(DataBaseConsts.GET_DATA_DB ,DataBaseConsts.strUserID, DataBaseConsts.strPassword, DataBaseConsts.dbURL);
//	}
	static List<String> listactual = new ArrayList<String>();
	static Connection connection = null;
	public static ResultSet  executeQuerryDB (String querry , String user , String pass , String dbURL) throws InterruptedException, SQLException{
		
	 ResultSet resultSet = null ;
		
		 String sql = querry;
		 String dburl = dbURL;
		 String	strUserID = user; 
		 String strPassword = pass;
		 
		
		 
        int count = 10;
        int test_conn = 0 ;
		 while (connection == null && test_conn<count) {
		     try {
		         connection = DriverManager.getConnection(dbURL,strUserID,strPassword);
		     } catch (SQLException e) {
		    	 test_conn= test_conn + 1;
		    	 System.out.println("Afisare counter :" + test_conn);
		    	  System.out.println("Connecting failed, retrying...");
		    	  Thread.sleep(10000);
		     }
		     
		 }

	            if (connection != null) {
	                System.out.println("Connected to the database!");
	                Statement statement = connection.createStatement();	                
	                 resultSet = statement.executeQuery(sql);
	                 System.out.println("SQL statement executed");
	                
	            } else {
	                System.out.println("Failed to make connection!");
	            }

		return resultSet;		
	}
	
	public static List<String> getDatafromDB(ResultSet resultSet) throws SQLException {
		
		if (resultSet.next() == false) { 
			System.out.println("ResultSet in empty in Java"); 
            listactual.add("null");
            listactual.add("null");
            listactual.add("null");
            listactual.add("null");
			}
		else {
			
		 // while (resultSet.next()) {

          	  String col1 = resultSet.getString("COLOANA1");
              String col2 = resultSet.getString("COLOANA2");
              String col3 = resultSet.getString("COLOANA3");
              String col4 = resultSet.getString("COLOANA4");

            if(col3.contains("PM")||col3.contains("AM")) {
            	col3=col3.substring(0,12);
            	System.out.println("data from db :  " + col3 );
            }
                          
              listactual.add(col1);
              listactual.add(col2);
              listactual.add(col3);
              listactual.add(col4);
	//	  }
		}
		return listactual;
	}
	public static void closeDbConn() throws SQLException {
		
		if (connection != null) {	
		connection.close();
		System.out.println("Db connection was closed");
		}
	}
}




//https://www.mkyong.com/jdbc/jdbc-statement-example-select-list-of-the-records/