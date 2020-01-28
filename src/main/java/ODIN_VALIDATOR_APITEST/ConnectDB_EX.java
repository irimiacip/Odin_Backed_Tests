package ODIN_VALIDATOR_APITEST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB_EX {

	public static void main(String[] args) {
		// ConnectDB_EX.checkDatabaseConnection(DataBaseConsts.GET_DATA_DB
		// ,DataBaseConsts.strUserID, DataBaseConsts.strPassword, DataBaseConsts.dbURL);

		ConnectDB_EX.checkDatabaseConnection("select * from odin_test order by coloana1 desc", "nwe", "PSC6O-3HFWOR",
				"jdbc:oracle:thin:@i125serv.metro-dus.de:15125:MD01PLI");

	}

	public static void checkDatabaseConnection(String querry, String user, String pass, String dbURL) {

		// String sql = "select * from ODIN_TEST";
		String sql = querry;
		String dburl = dbURL;
		String strUserID = user;
		String strPassword = pass;

		try (Connection conn = DriverManager.getConnection(dbURL, strUserID, strPassword)) {
			// "jdbc:oracle:thin:@h227serv.metro-dus.de:1521:MDP07PLD", "nwe", "europa")) {

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

					if (val1.equals(val1exp) || val2.equals(val2exp) || val3.equals(val3exp) || val4.equals(val4exp)) {
						System.out.println("Identically");
					} else {
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