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
	
	 public static String cassandra_sql(String a , String b) throws Exception {
		 String sql = ReadBody.getBodyFromFilepath(a, b);		 
		return sql;
		 
	 }

     public static String  env_cassandra(String env) throws Exception {
    	 
    	 if (env.contentEquals("od_inbound_pp1")){
    		 String a = cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_1.sql");
    		  a = String.format(a, "od_inbound_pp1");
    	System.out.println(a);
    	return a;
    	 }
    	 else {
    		 String a = cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_1.sql");
   		  a = String.format(a, "od_inbound_dev");
   	System.out.println(a);
   	return a;
    	 }
		
    		 
     }
	 
	    public static void main( String[] args ) throws Exception
	    {	
	    	
	    	env_cassandra("od_inbound_dev");
	    	env_cassandra("od_inbound_pp1");
	  
	  cassandra_update(DataBaseConsts.user_cassandra, DataBaseConsts.pass_cassandra, env_cassandra("od_inbound_pp1"));
	  
	    }	
}
