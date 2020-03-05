package ODIN_VALIDATOR_APITEST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectDBMarius {
//
//	public static void main(String[] args) throws InterruptedException, SQLException {
//	ConnectDB.executeQuerryDB(DataBaseConsts.CLEAN_DB ,DataBaseConsts.strUserID, DataBaseConsts.strPassword, DataBaseConsts.dbURL);
//	
//	ConnectDB.executeQuerryDB(DataBaseConsts.GET_DATA_DB ,DataBaseConsts.strUserID, DataBaseConsts.strPassword, DataBaseConsts.dbURL);
//	}
	static Connection connection = null;

	public static void initConn(String user, String pass, String dbURL) {
		int count = 10;
		int test_conn = 0;
		while (connection == null && test_conn < count) {
			try {
				connection = DriverManager.getConnection(dbURL, user, pass);
			} catch (SQLException e) {
				System.out.println("afisare eroarea " + e.getMessage());
				test_conn = test_conn + 1;
				System.out.println("Afisare counter :" + test_conn);
				System.out.println("Connecting failed, retrying...");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

		if (connection == null) {
			System.out.println("Failed to make connection!");
		}
	}

	public static void executeInsert(String querry) throws InterruptedException, SQLException {

		if (connection != null) {
			System.out.println("Connected to the database!");
			Statement statement = connection.createStatement();
			statement.executeQuery(querry);
			System.out.println("SQL statement executed");
		}

	}

	public static ResultSet executeQuerryDB(String querry) throws InterruptedException, SQLException {

		ResultSet resultSet = null;

		if (connection != null) {
			System.out.println("Connected to the database!");
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(querry);
			System.out.println("SQL statement executed");

		}
		return resultSet;
	}

	public static List<String> getDatafromDB(ResultSet resultSet) throws SQLException {

		List<String> listactual = new ArrayList<String>();

		if (resultSet.next() == false) {
			System.out.println("ResultSet in empty in Java");
			listactual.add("null");
			listactual.add("null");
			listactual.add("null");
			listactual.add("null");
		} else {

			// while (resultSet.next()) {

			String col1 = resultSet.getString("COLOANA1");
			String col2 = resultSet.getString("COLOANA2");
			String col3 = resultSet.getString("COLOANA3");
			String col4 = resultSet.getString("COLOANA4");

			if (col3.contains("PM") || col3.contains("AM")) {
				col3 = col3.substring(0, 9);
				System.out.println("data from db :  " + col3);
			}

			listactual.add(col1);
			listactual.add(col2);
			listactual.add(col3);
			listactual.add(col4);
			// }
		}
		resultSet.close();
		return listactual;
	}

	public static List<String> getDatafromDB(ResultSet resultSet, String MERGE_TYPE) throws SQLException {

		List<String> listactual = new ArrayList<String>();

		if (resultSet.next() == false) {
			System.out.println("ResultSet in empty in Java");
			listactual.add("null");
			listactual.add("null");
			listactual.add("null");
			listactual.add("null");
		} else {

			// while (resultSet.next()) {

			String col1 = resultSet.getString("VALID_FROM");
			String col2 = resultSet.getString("VALID_TO");

			listactual.add(col1);
			listactual.add(col2);

			// }
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