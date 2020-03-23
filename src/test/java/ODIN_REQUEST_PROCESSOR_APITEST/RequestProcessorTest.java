package ODIN_REQUEST_PROCESSOR_APITEST;

import static ODIN_VALIDATOR_APITEST.Cassandra_dbconnect.cassandra_update;
import static ODIN_VALIDATOR_APITEST.ConnectDB.closeDbConn;
import static ODIN_VALIDATOR_APITEST.ConnectDB.executeInsert;
import static ODIN_VALIDATOR_APITEST.ConnectDB.executeQuerryDB;
import static ODIN_VALIDATOR_APITEST.ConnectDB.getDatafromDB;
import static ODIN_VALIDATOR_APITEST.Consts.COUNTRY_TENANT;
import static ODIN_VALIDATOR_APITEST.Consts.COUNTRY_TENANT_PP;
import static ODIN_VALIDATOR_APITEST.Consts.FILEPATH_REQUEST_PROCESSOR;
import static ODIN_VALIDATOR_APITEST.Consts.LINK_PROCESSOR;
import static ODIN_VALIDATOR_APITEST.Consts.PATH_EXPECTED_REQUEST_PROCESSOR;
import static ODIN_VALIDATOR_APITEST.Consts.PROCESS;
import static ODIN_VALIDATOR_APITEST.Consts.VERSION_PROCESSOR_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.CLEAN_DB;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.CLEAN_DB_BRAND_ID;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_0;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_3;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_4;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_6;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_7;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_21;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_22;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_23;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_24;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_25;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_26;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_27;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_3;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_31;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_32;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_33;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_34;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_35;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_0;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_3;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_4;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_6;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_7;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_21;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_22;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_23;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_24;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_25;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_26;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_27;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_3;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_31;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_32;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_33;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_34;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_35;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM__MERGE_1_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM__MERGE_1_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM__MERGE_2_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM__MERGE_2_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM__MERGE_3_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_FROM__MERGE_3_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO_ENG_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO_ENG_5;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO_POL_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO_POL_5;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO__MERGE_1_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO__MERGE_1_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO__MERGE_2_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO__MERGE_2_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO__MERGE_3_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB_BRAND_VALID_TO__MERGE_3_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_3;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_4;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_5;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_6;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_7;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_8;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_9;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_ALLOW_GAP_ENG_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_ALLOW_GAP_ENG_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_ALLOW_GAP_POL_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_ALLOW_GAP_POL_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_MERGE__1_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_MERGE__1_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_MERGE__2_ENG;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_BRAND_ID_MERGE__2_POL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.dbURL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.dbURL_pp;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.pass_cassandra;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.sql_cassandra_allow_gap;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.sql_cassandra_not_allow_gap;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.strPassword;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.strPassword_pp;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.strUserID;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.strUserID_pp;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.user_cassandra;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.CREATE_TABLE;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.DELETE_TABLE;
/*import static ODIN_VALIDATOR_APITEST.DataBaseConsts.CLEAN_DB;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.GET_DATA_DB;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_2;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_3;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_4;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_5;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_6;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_7;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_8;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.INSERT_DB_9;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.dbURL;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.dbURL_pp;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.strPassword;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.strPassword_pp;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.strUserID;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.strUserID_pp;*/
import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import ODIN_VALIDATOR_APITEST.Cassandra_dbconnect;
import ODIN_VALIDATOR_APITEST.ConnectDB;
import ODIN_VALIDATOR_APITEST.Consts;
import ODIN_VALIDATOR_APITEST.ListComparator;
import ODIN_VALIDATOR_APITEST.ReadBody;
import ODIN_VALIDATOR_APITEST.ReadCSVFile;
import ODIN_VALIDATOR_APITEST.XmlComparator;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestProcessorTest {
	final static Logger logger = Logger.getLogger(RequestProcessorTest.class);
	static boolean value = true;
	String environment = System.getProperty("var");
	String user;
	String pass;
	String url;
	String clean;
	String env_cassandra;
    String country_tenant;
    String cassandra_update;
	//@BeforeMethod(groups = {"BG_MCC"})
	@BeforeTest(groups = {"BG_MCC"})
	public void startTest() throws Exception {
		if (environment.contains("dev")) {
			country_tenant = COUNTRY_TENANT;
			user = strUserID;
			pass = strPassword;
			url = dbURL;
			env_cassandra = "od_inbound_dev";
			cassandra_update = System.getProperty("cassandra_update");
		} else {
			country_tenant = COUNTRY_TENANT_PP;
			//user = strUserID_pp;
			//pass = strPassword_pp;
			user = strUserID;
			pass = strPassword;
			//url = dbURL_pp;
			url = dbURL;
			env_cassandra = "od_inbound_pp1";
			cassandra_update = System.getProperty("cassandra_update");
		}		
		ConnectDB.initConn(user, pass, url);
		executeInsert(CREATE_TABLE);
		
		logger.info("=====================");
		logger.info("autentification......");
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.useRelaxedHTTPSValidation();
	}	@AfterMethod(groups = {"BG_MCC"})
	public void endTest() throws SQLException {
		logger.info("logout....");
		logger.info("Finish TEST ");
	}

	@AfterTest (groups = {"BG_MCC"})
	public void closeDB() throws SQLException, InterruptedException {
		executeInsert(DELETE_TABLE);
		closeDbConn();
	}

	//// @Ignore
	@Test(priority = 1)
	public void test1() throws Exception {
		
		logger.info("TEST -- 1 --");
		logger.info("test for ==>compare xml structure , content , data inserted in DB vs expected <==");
		executeInsert(CLEAN_DB);		
		// executeQuerryDB(CLEAN_6DB, strUserID, strPassword, dbURL);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_1.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}				
		XmlComparator.read_xml_expected(2, 1, FILEPATH_REQUEST_PROCESSOR, "test_1.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_1.xml", "null", 0);
		
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("0");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 2)
	public void test2() throws Exception {
		logger.info("TEST -- 2 --");
		logger.info("test for ==> check response http status 200 <==");
		Response result = (Response) RestAssured.given().contentType("text/plain")
				.body(ReadBody.getBodyFromFilepath(FILEPATH_REQUEST_PROCESSOR, "test_1.xml"))
				.put(LINK_PROCESSOR + PROCESS + VERSION_PROCESSOR_1 + COUNTRY_TENANT).then().statusCode(200)
				.contentType("application/xml").extract().response();
	}

	//// @Ignore
	@Test(priority = 3)
	public void test3() throws Exception {
		logger.info("TEST -- 3 --");
		logger.info("test for ==><sourceXMLElement><==");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_12.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}

		
		
		XmlComparator.read_xml_expected(2, 12, FILEPATH_REQUEST_PROCESSOR, "test_1.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_2.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("2");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 4)
	public void test4() throws Exception {
		logger.info("TEST -- 4 --");
		logger.info("test for ==><targetColumn><==");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_13.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			
		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		XmlComparator.read_xml_expected(2, 13, FILEPATH_REQUEST_PROCESSOR, "test_1.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_3.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("3");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 5)
	public void test5() throws Exception {
		logger.info("TEST -- 5 --");
		logger.info("test for test for warrnig message received from validator==>");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_1.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			
		}else {
			logger.info("no cassandra update will be done");
		}
		
		XmlComparator.read_xml_expected(2, 1, FILEPATH_REQUEST_PROCESSOR, "test_2.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_4.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("4");
		logger.info("check data inserted in DB");
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 6)
	public void test6() throws Exception {
		logger.info("TEST -- 6 --");
		logger.info("test for warrnig message received from validator==>");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_1.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			
		}else {
			logger.info("no cassandra update will be done");
		}

		
		
		XmlComparator.read_xml_expected(2, 1, FILEPATH_REQUEST_PROCESSOR, "test_3.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_5.xml", "null", 0);
		 //Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("5");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 7)
	public void test7() throws Exception {
		logger.info("TEST -- 7 --");
		logger.info("test negative for check the behvior of the request processor==>");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_1.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}
				
		
		XmlComparator.read_xml_expected(2, 1, FILEPATH_REQUEST_PROCESSOR, "test_4.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_6.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("6");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 8)
	public void test8() throws Exception {
		logger.info("TEST -- 8 --");
		logger.info("Test situation for tag : SUBSTR : extract first 5 caracters starting with the first ==>");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_2.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 2, FILEPATH_REQUEST_PROCESSOR, "test_5.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_7.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("8");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 9)
	public void test9() throws Exception {
		logger.info("TEST -- 9 --");
		logger.info(
				"Test situation for tag : SUBSTR : extract first 5 caracters starting with the first; string contain less then 5 char ==>");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_6.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 2, FILEPATH_REQUEST_PROCESSOR, "test_6.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_8.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("9");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 10)
	public void test10() throws Exception {
		logger.info("TEST -- 10 --");
		logger.info("If a tag has null value, the concatenated values from two columns will be inserted there==>");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_3.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		XmlComparator.read_xml_expected(2, 3, FILEPATH_REQUEST_PROCESSOR, "test_7.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_9.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("10");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 11)
	public void test11() throws Exception {
		logger.info("TEST -- 11 --DE DISCUTAT");
		logger.info(
				"If a tag has null value, the concatenated values from two columns will be inserted there(one one them is null==>");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_8.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 4, FILEPATH_REQUEST_PROCESSOR, "test_8.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_10.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("11");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 12 )
	public void test12() throws Exception {
		logger.info("TEST -- 12 --DE FACUT REFACTOR LA COD--");
		logger.info("insert date SYSTIMESTAMP when a tag is missing==>");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_9.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 5, FILEPATH_REQUEST_PROCESSOR, "test_9.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_11.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("12");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 13)
	public void test13() throws Exception {
		logger.info("TEST -- 13 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT");
		executeInsert(CLEAN_DB);
		executeInsert(INSERT_DB_1);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_6.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 6, FILEPATH_REQUEST_PROCESSOR, "test_10.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_12.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("13");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 14)
	public void test14() throws Exception {
		logger.info("TEST -- 14 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT null table");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_6.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 6, FILEPATH_REQUEST_PROCESSOR, "test_11.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_13.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("14");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 15)
	public void test15() throws Exception {
		logger.info("TEST -- 15 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT two record in table");
		executeInsert(CLEAN_DB);
		executeInsert(INSERT_DB_1);
		executeInsert(INSERT_DB_2);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_6.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			
			

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		XmlComparator.read_xml_expected(2, 6, FILEPATH_REQUEST_PROCESSOR, "test_12.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_14.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("15");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 16)
	public void test16() throws Exception {
		logger.info("TEST -- 16 --");
		logger.info(
				"test for <mappingRule>{FUNCTION:select......ON INSERT no record in table and skippline is prezent");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_7.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		XmlComparator.read_xml_expected(2, 7, FILEPATH_REQUEST_PROCESSOR, "test_13.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_15.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("16");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 17)
	public void test17() throws Exception {
		logger.info("TEST -- 17 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT integer");
		executeInsert(CLEAN_DB);
		executeInsert(INSERT_DB_3);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_8.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 8, FILEPATH_REQUEST_PROCESSOR, "test_14.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_16.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("17");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 18)
	public void test18() throws Exception {
		logger.info("TEST -- 18 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT integer null table");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_8.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}

		
		XmlComparator.read_xml_expected(2, 8, FILEPATH_REQUEST_PROCESSOR, "test_15.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_17.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("18");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 19)
	public void test19() throws Exception {
		logger.info("TEST -- 19 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT integer two record in table");
		executeInsert(CLEAN_DB);
		executeInsert(INSERT_DB_4);
		executeInsert(INSERT_DB_5);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_8.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}

		
		
		XmlComparator.read_xml_expected(2, 8, FILEPATH_REQUEST_PROCESSOR, "test_16.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_18.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("19");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	//// @Ignore
	@Test(priority = 20)
	public void test20() throws Exception {
		logger.info("TEST -- 20 --");
		logger.info(
				"test for <mappingRule>{FUNCTION:select......ON INSERT integer no record in table and skippline is prezent");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_9.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 9, FILEPATH_REQUEST_PROCESSOR, "test_17.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_19.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("20");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	// @Ignore
	// date tests
	@Test(priority = 21)
	public void test21() throws Exception {
		logger.info("TEST -- 21 --");
		logger.info("test for <mappingRule>{FUNCTION:select......ON INSERT data ");
		executeInsert(CLEAN_DB);
		executeInsert(INSERT_DB_6);
		executeInsert(INSERT_DB_7);
		executeInsert(INSERT_DB_8);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_10.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 10, FILEPATH_REQUEST_PROCESSOR, "test_18.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_20.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("21");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");
	}

	// @Ignore
	@Test(priority = 22)
	public void test22() throws Exception {
		logger.info("TEST -- 22 --");
		logger.info("test for <mappingRule>{FUNCTION:select......ON INSERT data multiple record in table ");
		executeInsert(CLEAN_DB);
		executeInsert(INSERT_DB_6);
		executeInsert(INSERT_DB_7);
		executeInsert(INSERT_DB_8);
		executeInsert(INSERT_DB_9);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_10.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));

		}else {
			logger.info("no cassandra update will be done");
		}

		
		
		XmlComparator.read_xml_expected(2, 10, FILEPATH_REQUEST_PROCESSOR, "test_19.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_21.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("22");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");

	}

	// @Ignore
	@Test(priority = 23)
	public void test23() throws Exception {
		logger.info("TEST -- 23 --");
		logger.info("test for <mappingRule>{FUNCTION:select......ON INSERT data no record in table ");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_10.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}

		
		
		XmlComparator.read_xml_expected(2, 10, FILEPATH_REQUEST_PROCESSOR, "test_20.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_22.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("23");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");

	}

	// @Ignore
	@Test(priority = 24)
	public void test24() throws Exception {
		logger.info("TEST -- 24 --");
		logger.info("test for <mappingRule>{FUNCTION:select......ON INSERT data no record in table and skippline ");
		executeInsert(CLEAN_DB);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_11.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		
		XmlComparator.read_xml_expected(2, 11, FILEPATH_REQUEST_PROCESSOR, "test_21.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_23.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB));
		List<String> listexpected = ReadCSVFile.readExpected("24");
		logger.info("check data inserted in DB");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		logger.info("check succesfully");

	}

	// @Ignore
	@Test(priority = 25) // Merge request ===> 22 23 24 expected 24 25 26
	public void test25() throws Exception {
		logger.info("TEST -- 25 --");
		logger.info("Test MERGE situation 1");
		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__1_ENG);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__2_ENG);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__1_POL);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__2_POL);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_17.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}
		

		
		
		XmlComparator.read_xml_expected(2, 17, FILEPATH_REQUEST_PROCESSOR, "test_22.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_24.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM__MERGE_1_ENG), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("25", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO__MERGE_1_ENG), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("26", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM__MERGE_1_POL), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("25", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO__MERGE_1_POL), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("26", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		// Thread.sleep(5000);

		// prepaer the settings.xml for MERGE
		// conect and delete // insert data in MMS (brand)
		// insert data initial
		// execute request
		// compare expected with actual
		// check data from db
		// check that the interval is changed and some records are deleted
		// delete data inserted in mms
	}

	// @Ignore
	@Test(priority = 26) // Merge request ===> 22 23 24 expected 24 25 26
	public void test26() throws Exception {
		logger.info("TEST -- 26 --");
		logger.info("Test MERGE situation 2");
		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__1_ENG);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__2_ENG);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__1_POL);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__2_POL);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_18.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}
		

		
		
		XmlComparator.read_xml_expected(2, 18, FILEPATH_REQUEST_PROCESSOR, "test_23.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_25.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM__MERGE_2_ENG), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("40", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO__MERGE_2_ENG), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("41", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM__MERGE_2_POL), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("40", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO__MERGE_2_POL), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("41", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);

		// prepaer the settings.xml for MERGE
		// conect and delete // insert data in MMS (brand)
		// insert data initial
		// execute request
		// compare expected with actual
		// check data from db
		// check that the interval is changed and some records are deleted
		// delete data inserted in mms
	}

	// @Ignore
	@Test(priority = 27) // Merge request ===> 22 23 24 expected 24 25 26
	public void test27() throws Exception {
		logger.info("TEST -- 27 --");
		logger.info("Test MERGE negative situation 3");
		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__1_ENG);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__2_ENG);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__1_POL);
		executeInsert(INSERT_DB_BRAND_ID_MERGE__2_POL);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_18.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}
		

		
		
		XmlComparator.read_xml_expected(2, 18, FILEPATH_REQUEST_PROCESSOR, "test_24.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_26.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM__MERGE_3_ENG), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("42", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO__MERGE_3_ENG), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("43", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM__MERGE_3_POL), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("42", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO__MERGE_3_POL), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("43", "MERGE");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);

		// prepaer the settings.xml for MERGE
		// conect and delete // insert data in MMS (brand)
		// insert data initial
		// execute request
		// compare expected with actual
		// check data from db
		// check that the interval is changed and some records are deleted
		// delete data inserted in mms
	}

	// @Ignore
	@Test(priority = 28) // Merge MMS
	public void test28() throws Exception {
		logger.info("TEST --28 --");
		logger.info("test MERGE MMS situation 1");
		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_1);
		executeInsert(INSERT_DB_BRAND_ID_2);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_14.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}
		

		
		
		XmlComparator.read_xml_expected(2, 14, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_27.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("27", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_ENG), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("28", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("27", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_POL), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("28", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
	}

	// @Ignore
	@Test(priority = 29) // Merge MMS
	public void test29() throws Exception {
		logger.info("TEST --29 --");
		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_1);
		executeInsert(INSERT_DB_BRAND_ID_2);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_14.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}

		
		
		XmlComparator.read_xml_expected(2, 14, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_27.xml", "null", 0);
		logger.info("interval is splitted started point");
		logger.info("execute request for split the second interval");
		if(cassandra_update.equals("true")) {
			String sql_1 = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_15.sql");
			System.out.println(sql_1);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}

		
		XmlComparator.read_xml_expected(2, 15, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_28.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_0), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("29", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_1), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("30", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_ENG_2), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("31", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_2), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("32", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_0), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("29", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_1), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("30", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_POL_2), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("31", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_2), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("32", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
	}

	// @Ignore
	@Test(priority = 30) // Merge MMS
	public void test30() throws Exception {
		logger.info("TEST --30 --");
		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_1);
		executeInsert(INSERT_DB_BRAND_ID_2);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_14.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}

	
		
		XmlComparator.read_xml_expected(2, 14, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_27.xml", "null", 0);
		
		if(cassandra_update.equals("true")) {
			String sql_1 = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_14.sql");
			System.out.println(sql_1);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}
		
		
		XmlComparator.read_xml_expected(2, 15, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_28.xml", "null", 0);
		if(cassandra_update.equals("true")) {
			String sql_2 = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_14.sql");
			System.out.println(sql_2);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}		

		
		XmlComparator.read_xml_expected(2, 16, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_29.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_3), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("33", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_4), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("34", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_ENG_5), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("35", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_6), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("36", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_7), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("37", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);

		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_3), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("33", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_4), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("34", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_POL_5), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("35", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_6), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("36", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_7), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("37", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_3), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("33", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_4), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("34", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_ENG_5), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("35", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_6), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("36", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_7), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("37", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
	}

	// @Ignore
	@Test(priority = 31)
	public void test31() throws Exception {
		logger.info("--TEST 31--");
		logger.info("Test negative for the situation when the description for BRAND is missing");
		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_1);
		executeInsert(INSERT_DB_BRAND_ID_2);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_14.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}	
	
		
		
		XmlComparator.read_xml_expected(2, 14, FILEPATH_REQUEST_PROCESSOR, "test_26.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_30.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_3), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("38", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_3), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("39", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
	}

	// @Ignore
	@Test(priority = 32)
	public void test32() throws Exception {
		logger.info("--TEST 32--");
		logger.info("Test negativ with sub_brand_id not valid and brand_id valid");
		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_1);
		executeInsert(INSERT_DB_BRAND_ID_2);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_14.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}	

		XmlComparator.read_xml_expected(2, 14, FILEPATH_REQUEST_PROCESSOR, "test_27.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_31.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_3), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("38", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_3), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("39", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		// bad request sub_brand_id=wrong
	}

	 @Ignore
	@Test(priority = 33)
	public void test33() throws InterruptedException {
		logger.info("---- TEST 33 ----");
		logger.info("Test will change the setting in cassandra for table RT_BRANDS_ML to allow GAP");
		cassandra_update(user_cassandra, pass_cassandra, sql_cassandra_allow_gap);
		Thread.sleep(5000);
	}

	// @Ignore
	@Test(priority = 34, groups = {"BG_MCC"})	

	public void test34() throws Exception {
		logger.info("---TEST 34 ------");
		logger.info("Test first situation for ALLOWED GAP");

		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_ENG_1);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_ENG_2);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_POL_1);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_POL_2);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_19.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
		}else {
			logger.info("no cassandra update will be done");
		}	

				
		XmlComparator.read_xml_expected(2, 19, FILEPATH_REQUEST_PROCESSOR, "test_28.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_32.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_1), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("44", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_2), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("45", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_3), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("46", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_1), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("44", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_2), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("45", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_3), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("46", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);	
	}

	// @Ignore
	@Test(priority = 35, groups = {"BG_MCC"})
	public void test35() throws Exception {
		logger.info("---TEST 35 ------");
		logger.info("Test second situation for ALLOWED GAP");
		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_ENG_1);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_ENG_2);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_POL_1);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_POL_2);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_19.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			//Thread.sleep(5000);
		}else {
			logger.info("no cassandra update will be done");
		}

		
		XmlComparator.read_xml_expected(2, 19, FILEPATH_REQUEST_PROCESSOR, "test_28.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_32.xml", "null", 0);
		if(cassandra_update.equals("true")) {
			String sql_1 = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_20.sql");
			System.out.println(sql_1);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			// Thread.sleep(5000);
		}else {
			logger.info("no cassandra update will be done");
		}		

		
		XmlComparator.read_xml_expected(2, 20, FILEPATH_REQUEST_PROCESSOR, "test_29.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_33.xml", "null", 0);
		
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_21), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("47", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_22), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("48", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_23), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("49", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_24), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("50", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_25), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("51", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_26), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("52", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_27), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("53", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_21), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("47", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_22), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("48", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_23), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("49", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_24), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("50", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_25), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("51", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_26), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("52", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_27), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("53", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
	}

	// @Ignore
	@Test(priority = 36, groups = {"BG_MCC"})
	public void test36() throws Exception {
		logger.info("---TEST 36 ------");
		logger.info("Test third situation for ALLOWED GAP");

		executeInsert(CLEAN_DB_BRAND_ID);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_ENG_1);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_ENG_2);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_POL_1);
		executeInsert(INSERT_DB_BRAND_ID_ALLOW_GAP_POL_2);
		if(cassandra_update.equals("true")) {
			String sql = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_19.sql");
			System.out.println(sql);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			// Thread.sleep(5000);
		}else {
			logger.info("no cassandra update will be done");
		}	

		// Thread.sleep(5000);
		XmlComparator.read_xml_expected(2, 19, FILEPATH_REQUEST_PROCESSOR, "test_28.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_32.xml", "null", 0);
		if(cassandra_update.equals("true")) {
			String sql_1 = Cassandra_dbconnect.cassandra_sql(Consts.FILEPATH_VALIDATOR_CASSANDRA, "processor_21.sql");
			System.out.println(sql_1);
			cassandra_update(user_cassandra, pass_cassandra, Cassandra_dbconnect.env_cassandra(env_cassandra));
			Thread.sleep(5000);
		}else {
			logger.info("no cassandra update will be done");
		}	

		XmlComparator.read_xml_expected(2, 21, FILEPATH_REQUEST_PROCESSOR, "test_30.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_34.xml", "null", 0);
		// Thread.sleep(5000);
		List<String> listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_31), "MERGE_MMS");
		List<String> listexpected = ReadCSVFile.readExpected("54", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_32), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("55", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_33), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("56", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_34), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("57", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_ALLOW_GAP_35), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("58", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_31), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("54", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_32), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("55", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_33), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("56", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_34), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("57", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_ALLOW_GAP_35), "MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("58", "MERGE_MMS");
		//value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(listactual, listexpected);
	}

	 @Ignore
	@Test(priority = 37)
	public void test37() throws InterruptedException {
		logger.info("---TEST 37 ------");
		logger.info("Test will change the setting in cassandra for table RT_BRANDS_ML to NOT allow GAP");
		cassandra_update(user_cassandra, pass_cassandra, sql_cassandra_not_allow_gap);
		Thread.sleep(5000);
	}

	// @Ignore
	@Test(priority = 38)
	public void test38() {
		logger.info("---TEST 38 ------");
		logger.info("Test terminate");

	}

	// mvn clean test -DproxySet=true -DproxyHost=proxy.metro.ro -DproxyPort=3128 -DtestngFile=2_testng.xml -Dvar=dev -Dvarlink=dev -DCredential_user_dev=nwe -DCredential_pass_dev=europa
	// mvn clean test -DtestngFile=2_testng.xml -Dvar=pp -Dvarlink=pp1
	// mvn clean test -DtestngFile=2_testng.xml -Dvar=dev -Dvarlink=dev
	// mvn clean test -DproxySet=true -DproxyHost=proxy.metro.ro -DproxyPort=3128 -DtestngFile=2_testng.xml -Dvar=pp -Dvarlink=pp1 -DCredential_user_pp=nwe -DCredential_pass_pp=PSC6O-3HFWOR
	
	   //PL==>PLDEV  ==> env
}