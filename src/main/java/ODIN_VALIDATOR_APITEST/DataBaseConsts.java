package ODIN_VALIDATOR_APITEST;

public class DataBaseConsts {

	public static final String GET_DATA_DB = "select * from odin_test order by coloana1 desc";
	public static final String CLEAN_DB = "delete from ODIN_TEST";

	public static final String INSERT_DB_1 = "insert into odin_test (COLOANA1 , COLOANA2 , COLOANA3 , COLOANA4) values ('1' , 'ion', 'mascul','2')";
	public static final String INSERT_DB_2 = "insert into odin_test (COLOANA1 , COLOANA2 , COLOANA3 , COLOANA4) values ('2' , 'ion', 'mascul','3')";
	public static final String INSERT_DB_3 = "INSERT INTO odin_test ( COLOANA1,COLOANA2,COLOANA3,COLOANA4)  VALUES ( 1 , 'femeie' ,'alexandra', 28 )";
	public static final String INSERT_DB_4 = "INSERT INTO odin_test ( COLOANA1,COLOANA2,COLOANA3,COLOANA4)  VALUES ( 1 , 'femeie' ,'alexandra', 28 )";
	public static final String INSERT_DB_5 = "INSERT INTO odin_test ( COLOANA1,COLOANA2,COLOANA3,COLOANA4)  VALUES ( 2 , 'femeie' ,'alex', 28 )";

	public static final String INSERT_DB_6 = "insert into odin_test (COLOANA1,COLOANA2,COLOANA3,COLOANA4) values (1,'salam sibiu','20-12-2019',200)";
	public static final String INSERT_DB_7 = "insert into odin_test (COLOANA1,COLOANA2,COLOANA3,COLOANA4) values (2,'salam victoria','20-12-2019',300)";
	public static final String INSERT_DB_8 = "insert into odin_test (COLOANA1,COLOANA2,COLOANA3,COLOANA4) values (3,'salam agricola','20-12-2019',500)";
	public static final String INSERT_DB_9 = "insert into odin_test (COLOANA1,COLOANA2,COLOANA3,COLOANA4) values (4,'salam agricola','20-12-2019',400)";

	public static final String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=metrom1-scan.de1.ocm.s1587589.oraclecloudatcustomer.com)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=MDP07PLD.de1.ocm.s1587589.oraclecloudatcustomer.com)))";
	public static final String dbURL_pp = "jdbc:oracle:thin:@i125serv.metro-dus.de:15125:MD01PLI";
	public static final String strUserID = "nwe";
	public static final String strUserID_pp = "nwe";
	public static final String strPassword = "europa";
	public static final String strPassword_pp = "PSC6O-3HFWOR";
}
