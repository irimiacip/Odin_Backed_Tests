package ODIN_VALIDATOR_APITEST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*from ww w  .  j  a  v  a 2s .c  om*/
public class DataBaseCassandra {

  public static void main(String[] args) throws Exception {

    Connection con = null;
    Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
    con = DriverManager
        .getConnection("jdbc:cassandra://localhost:9160/Keyspace");

    String query = "SELECT * FROM column_family where gender=f ";

    Statement stmt = con.createStatement();
    ResultSet result = stmt.executeQuery(query);

    while (result.next()) {
      System.out.println(result.getString("user_name"));
      System.out.println(result.getString("gender"));
      System.out.println(result.getString("password"));
    }
    con.close();
  }
}

//http://www.java2s.com/Tutorials/Java/JDBC_How_to/Connection/Connect_to_Cassandra.htm