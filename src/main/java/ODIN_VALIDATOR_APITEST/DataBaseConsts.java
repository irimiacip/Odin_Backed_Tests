package ODIN_VALIDATOR_APITEST;

public class DataBaseConsts {

	public static final String GET_DATA_DB = "select * from odin_test order by coloana1 desc";
	public static final String CLEAN_DB = "delete from ODIN_TEST";
	public static final String CLEAN_DB_BRAND_ID = "DELETE FROM RT_BRANDS_ML WHERE BRAND_ID =33710";
	public static final String INSERT_DB_BRAND_ID_1 = "INSERT INTO NWE.RT_BRANDS_ML\r\n" + 
			"(BRAND_ID, LANG_CD, VALID_FROM, VALID_TO, BRAND_IS_VALID, BRAND_NAME, TECHNICAL_BRAND, CREATED_AT, CREATED_BY, CHANGED_AT, CHANGED_BY)\r\n" + 
			"VALUES(33710, 'POL', TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS'), TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 'AMW', 0, TO_DATE('2017-05-23 08:05:45','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804', TO_DATE('2017-05-23 08:05:44','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804')";
	public static final String INSERT_DB_BRAND_ID_2 = "INSERT INTO NWE.RT_BRANDS_ML\r\n" + 
			"(BRAND_ID, LANG_CD, VALID_FROM, VALID_TO, BRAND_IS_VALID, BRAND_NAME, TECHNICAL_BRAND, CREATED_AT, CREATED_BY, CHANGED_AT, CHANGED_BY)\r\n" + 
			"VALUES(33710, 'ENG', TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS'), TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 'AMW', 0, TO_DATE('2017-05-23 08:05:44','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804', TO_DATE('2017-05-23 08:05:44','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_ENG = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_TO_ENG = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";  
	public static final String GET_DATA_DB_BRAND_VALID_FROM_POL = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_TO_POL = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";  
	
	public static final String GET_DATA_DB_BRAND_VALID_FROM_ENG_0 = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_ENG_1 = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2099-12-31 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_TO_ENG_2 = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2099-12-31 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_ENG_2 = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";

	public static final String GET_DATA_DB_BRAND_VALID_FROM_POL_0 = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_POL_1 = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2099-12-31 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_TO_POL_2 = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2099-12-31 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_POL_2 = "SELECT VALID_FROM, VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";

	public static final String GET_DATA_DB_BRAND_VALID_FROM_ENG_3 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_ENG_4 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2018-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_TO_ENG_5 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2099-12-31 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_ENG_6 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2100-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_ENG_7 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2500-01-02 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	
	public static final String GET_DATA_DB_BRAND_VALID_FROM_POL_3 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_POL_4 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_FROM = TO_DATE('2018-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_TO_POL_5 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_TO = TO_DATE('2099-12-31 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_POL_6 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_FROM = TO_DATE('2100-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	public static final String GET_DATA_DB_BRAND_VALID_FROM_POL_7 = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_FROM = TO_DATE('2500-01-02 00:00:00','YYYY-MM-DD HH24:MI:SS')";

	
	public static final String INSERT_DB_BRAND_ID_MERGE__1_ENG ="INSERT INTO NWE.RT_BRANDS_ML\r\n" + 
			"(BRAND_ID, LANG_CD, VALID_FROM, VALID_TO, BRAND_IS_VALID, BRAND_NAME, TECHNICAL_BRAND, CREATED_AT, CREATED_BY, CHANGED_AT, CHANGED_BY)\r\n" + 
			"VALUES(33710, 'POL', TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-01 00:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 'AMW', 0, TO_DATE('2017-05-23 08:05:45','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804', TO_DATE('2017-05-23 08:05:44','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804')";
	public static final String INSERT_DB_BRAND_ID_MERGE__2_ENG ="INSERT INTO NWE.RT_BRANDS_ML\r\n" + 
			"(BRAND_ID, LANG_CD, VALID_FROM, VALID_TO, BRAND_IS_VALID, BRAND_NAME, TECHNICAL_BRAND, CREATED_AT, CREATED_BY, CHANGED_AT, CHANGED_BY)\r\n" + 
			"VALUES(33710, 'POL', TO_DATE('2020-03-02 00:00:00','YYYY-MM-DD HH24:MI:SS'), TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 'AMW', 0, TO_DATE('2017-05-23 08:05:45','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804', TO_DATE('2017-05-23 08:05:44','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804')";
			
	
	
	public static final String INSERT_DB_BRAND_ID_MERGE__1_POL ="INSERT INTO NWE.RT_BRANDS_ML\r\n" + 
			"(BRAND_ID, LANG_CD, VALID_FROM, VALID_TO, BRAND_IS_VALID, BRAND_NAME, TECHNICAL_BRAND, CREATED_AT, CREATED_BY, CHANGED_AT, CHANGED_BY)\r\n" + 
			"VALUES(33710, 'ENG', TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-01 00:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 'AMW', 0, TO_DATE('2017-05-23 08:05:44','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804', TO_DATE('2017-05-23 08:05:44','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804')";
	public static final String INSERT_DB_BRAND_ID_MERGE__2_POL ="INSERT INTO NWE.RT_BRANDS_ML\r\n" + 
			"(BRAND_ID, LANG_CD, VALID_FROM, VALID_TO, BRAND_IS_VALID, BRAND_NAME, TECHNICAL_BRAND, CREATED_AT, CREATED_BY, CHANGED_AT, CHANGED_BY)\r\n" + 
			"VALUES(33710, 'ENG', TO_DATE('2020-03-02 00:00:00','YYYY-MM-DD HH24:MI:SS'), TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 'AMW', 0, TO_DATE('2017-05-23 08:05:44','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804', TO_DATE('2017-05-23 08:05:44','YYYY-MM-DD HH24:MI:SS'), 'BDM_2017-05-23T06:03:09.804')";

	public static final String GET_DATA_DB_BRAND_VALID_FROM__MERGE_1_ENG = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	public static final String GET_DATA_DB_BRAND_VALID_TO__MERGE_1_ENG = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	public static final String GET_DATA_DB_BRAND_VALID_FROM__MERGE_1_POL = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	public static final String GET_DATA_DB_BRAND_VALID_TO__MERGE_1_POL = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_TO = TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	
    public static final String GET_DATA_DB_BRAND_VALID_FROM__MERGE_2_ENG = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	public static final String GET_DATA_DB_BRAND_VALID_TO__MERGE_2_ENG = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2030-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	public static final String GET_DATA_DB_BRAND_VALID_FROM__MERGE_2_POL = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	public static final String GET_DATA_DB_BRAND_VALID_TO__MERGE_2_POL = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_TO = TO_DATE('2030-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	
	
    public static final String GET_DATA_DB_BRAND_VALID_FROM__MERGE_3_ENG = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	public static final String GET_DATA_DB_BRAND_VALID_TO__MERGE_3_ENG = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='ENG' AND  VALID_TO = TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	public static final String GET_DATA_DB_BRAND_VALID_FROM__MERGE_3_POL = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_FROM = TO_DATE('2017-05-24 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	public static final String GET_DATA_DB_BRAND_VALID_TO__MERGE_3_POL = "SELECT VALID_FROM , VALID_TO FROM RT_BRANDS_ML WHERE BRAND_ID =33710 AND BRAND_ID = 33710 AND LANG_CD ='POL' AND  VALID_TO = TO_DATE('2949-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')";
	
	
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
	// public static final String strUserID = "nwe";
	public static String strUserID = System.getProperty("Credential_user_dev");
	public static final String strUserID_pp = "nwe";
	// public static final String strPassword = "europa";
	public static String strPassword = System.getProperty("Credential_pass_dev");
	public static final String strPassword_pp = "PSC6O-3HFWOR";
}
