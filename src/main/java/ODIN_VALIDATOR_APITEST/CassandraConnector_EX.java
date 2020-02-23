package ODIN_VALIDATOR_APITEST;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;*/
/*from ww w  .  j  a  v  a 2s .c  om*/

/*public class DataBaseCassandra {

	
	 * public static void main(String[] args) throws Exception {
	 * 
	 * Connection con = null;
	 * Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver"); con =
	 * DriverManager.getConnection("jdbc:cassandra://localhost:9160/Keyspace");
	 * 
	 * String query = "SELECT * FROM column_family where gender=f ";
	 * 
	 * Statement stmt = con.createStatement(); ResultSet result =
	 * stmt.executeQuery(query);
	 * 
	 * while (result.next()) { System.out.println(result.getString("user_name"));
	 * System.out.println(result.getString("gender"));
	 * System.out.println(result.getString("password")); } con.close(); }
	 
	

}*/

import java.util.List;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraConnector_EX {
	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().addContactPoint("cassandra2.cass.odin.test6.mcc.be-gcw1.metroscales.io").withPort(9042).withCredentials("mcc_test6", "kQ9Tg50A8rVQXWfK2GMSTwdf93Bbn4").build();
		Session session = cluster.connect();
		System.out.println("session object---" + session);
		session.execute("use od_inbound_dev");		
		//ResultSet resultSet = session.execute("SELECT target_system, namespace, table_owner, content FROM od_inbound_dev.additional_target_properties WHERE target_system = 'MMS_HO' and namespace = 'NWE' and table_owner ='RT_BRANDS_ML';");
		//INSERT INTO od_inbound_dev.additional_target_properties (target_system, namespace, table_owner, content) VALUES('MMS_HO', 'NWE', 'RT_BRANDS_ML', '{ "writeExportRecords":"false", "exportRecordIdentifier":"RT", "tableAllowsScheduleGaps":"false", "filterKeyColumn":"BRAND_ID"}');
		ResultSet resultSet = session.execute("INSERT INTO od_inbound_dev.additional_target_properties (target_system, namespace, table_owner, content) VALUES('MMS_HO', 'NWE', 'RT_BRANDS_ML', '{ \"writeExportRecords\":\"false\", \"exportRecordIdentifier\":\"RT\", \"tableAllowsScheduleGaps\":\"true\", \"filterKeyColumn\":\"BRAND_ID\"}');");

		List<Row> results = resultSet.all();
		for (Row row : results) {
			//System.out.println(row.getString("target_system")); 
			//System.out.println(row.getString("namespace"));
			//System.out.println(row.getString("table_owner"));
			System.out.println(row.getString("content"));
		}
		session.close();
	}
}

//http://www.java2s.com/Tutorials/Java/JDBC_How_to/Connection/Connect_to_Cassandra.htm