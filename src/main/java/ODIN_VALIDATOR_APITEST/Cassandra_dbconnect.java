package ODIN_VALIDATOR_APITEST;

import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class Cassandra_dbconnect {

	
	public static boolean cassandra_update (String user , String pass , String sql) {
		boolean value = true;
		
		Cluster cluster = Cluster.builder().addContactPoint("cassandra2.cass.odin.test6.mcc.be-gcw1.metroscales.io").withPort(9042).withCredentials(user, pass).build();
		Session session = cluster.connect();
		System.out.println("session object---" + session);
		session.execute("use od_inbound_dev");		
		//ResultSet resultSet = session.execute("SELECT target_system, namespace, table_owner, content FROM od_inbound_dev.additional_target_properties WHERE target_system = 'MMS_HO' and namespace = 'NWE' and table_owner ='RT_BRANDS_ML';");
		//INSERT INTO od_inbound_dev.additional_target_properties (target_system, namespace, table_owner, content) VALUES('MMS_HO', 'NWE', 'RT_BRANDS_ML', '{ "writeExportRecords":"false", "exportRecordIdentifier":"RT", "tableAllowsScheduleGaps":"false", "filterKeyColumn":"BRAND_ID"}');
		
		ResultSet resultSet = session.execute(sql);

		List<Row> results = resultSet.all();
		for (Row row : results) {
			//System.out.println(row.getString("target_system")); 
			//System.out.println(row.getString("namespace"));
			//System.out.println(row.getString("table_owner"));
			System.out.println(row.getString("content"));
		}
		session.close();
		
		return value;
	}
	

	
	
}
