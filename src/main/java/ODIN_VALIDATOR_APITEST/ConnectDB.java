package ODIN_VALIDATOR_APITEST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {

	public static void main(String[] args) {
	ConnectDB.checkDatabaseConnection();
	}

	
	public static  void checkDatabaseConnection (){

		
		 String sql = "select * from ODIN_TEST";
		 
		 try (Connection conn = DriverManager.getConnection(
				 "jdbc:oracle:thin:@h227serv.metro-dus.de:15227:MDP07PLD", "nwe", "europa")) {
				
	            if (conn != null) {
	                System.out.println("Connected to the database!");
	                Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql);
	                while (resultSet.next()) {

	                	String col1 = resultSet.getString("COLOANA1");
	                    String col2 = resultSet.getString("COLOANA2");
	                    String col3 = resultSet.getString("COLOANA3");
	                    String col4 = resultSet.getString("COLOANA4");

	                    DBobj obj = new DBobj();
	                    
	                   obj.setCol1(col1);
	                   obj.setCol2(col2);
	                   obj.setCol3(col3);
	                   obj.setCol4(col4);
	                   
	                    String val1 = obj.getCol1(); 
	                    String val2 = obj.getCol2();
	                    String val3 = obj.getCol3();
	                    String val4 = obj.getCol4();
	                    
	                    DBobjexp objexp = new DBobjexp();
	                    objexp.setCol1("2");
	                    objexp.setCol2("Text");
	                    objexp.setCol3("Text2");
	                    objexp.setCol4("1000");
	                    
	                    String val1exp = objexp.getCol1();
	                  String val2exp = objexp.getCol2();
	                  String val3exp = objexp.getCol3();
	                  String val4exp = objexp.getCol4();
	                  
	                  System.out.println(val1);
	                  System.out.println(val1exp);
	                  
	                  
	                  if ( val1.equals(val1exp)||val1.equals(val1exp)||val1.equals(val1exp)||val1.equals(val1exp) ) {
	                	  System.out.println("Identically");
	                  } else
	                  {
	                	  System.out.println("Not identically");
	                  }
	            
	                  
	                }
	            } else {
	                System.out.println("Failed to make connection!");
	            }
	        } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}		
}

//https://www.mkyong.com/jdbc/jdbc-statement-example-select-list-of-the-records/