package ODIN_VALIDATOR_APITEST;

public class DataBaseConsts {

	public static final  String GET_DATA_DB = "select * from odin_test order by coloana1 desc" ;
	public static final  String CLEAN_DB = "delete from ODIN_TEST" ;
	
	public static final  String INSERT_DB_1 = "insert into odin_test (COLOANA1 , COLOANA2 , COLOANA3 , COLOANA4) values ('1' , 'ion', 'mascul','2')";
	public static final  String INSERT_DB_2 = "insert into odin_test (COLOANA1 , COLOANA2 , COLOANA3 , COLOANA4) values ('2' , 'ion', 'mascul','3')";
	public static final  String INSERT_DB_3 = "INSERT INTO odin_test ( COLOANA1,COLOANA2,COLOANA3,COLOANA4)  VALUES ( 1 , 'femeie' ,'alexandra', 28 )";
	
	public static final String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=metrom1-scan.de1.ocm.s1587589.oraclecloudatcustomer.com)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=MDP07PLD.de1.ocm.s1587589.oraclecloudatcustomer.com)))";
	 
	public static final String	strUserID = "nwe";
	 
	public static final String strPassword = "europa";
}
