package ODIN_REQUEST_PROCESSOR_APITEST;

import static ODIN_VALIDATOR_APITEST.ConnectDB.closeDbConn;
import static ODIN_VALIDATOR_APITEST.ConnectDB.executeQuerryDB;
import static ODIN_VALIDATOR_APITEST.ConnectDB.getDatafromDB;
import static ODIN_VALIDATOR_APITEST.Consts.COUNTRY_TENANT;
import static ODIN_VALIDATOR_APITEST.Consts.FILEPATH_REQUEST_PROCESSOR;
import static ODIN_VALIDATOR_APITEST.Consts.LINK_PROCESSOR;
import static ODIN_VALIDATOR_APITEST.Consts.PATH_EXPECTED_REQUEST_PROCESSOR;
import static ODIN_VALIDATOR_APITEST.Consts.PROCESS;
import static ODIN_VALIDATOR_APITEST.Consts.VERSION_PROCESSOR_1;
import static ODIN_VALIDATOR_APITEST.DataBaseConsts.*;
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

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import ODIN_VALIDATOR_APITEST.ListComparator;
import ODIN_VALIDATOR_APITEST.ReadBody;
import ODIN_VALIDATOR_APITEST.ReadCSVFile;
import ODIN_VALIDATOR_APITEST.XmlComparator;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestProcessorTest {
	final static Logger logger = Logger.getLogger(RequestProcessorTest.class);
	static List<String> listactual = new ArrayList<String>();
	static List<String> listexpected = new ArrayList<String>();
	static boolean value = true;
	String environment = System.getProperty("var");
	String user;
	String pass;
	String url;
	String clean;

	@BeforeMethod
	public void startTest() throws InterruptedException, SQLException {
		if (environment.contains("dev")) {
			user = strUserID;
			pass = strPassword;
			url = dbURL;
		} else {
			user = strUserID_pp;
			pass = strPassword_pp;
			url = dbURL_pp;
		}
		logger.info("=====================");
		logger.info("autentification......");
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.useRelaxedHTTPSValidation();
		// RestAssured.proxy = host("proxy.metro.ro").withPort(3128);
	}

	@AfterMethod
	public void endTest() throws SQLException {
		// closeDbConn();
		logger.info("logout....");
		logger.info(" ");
	}

	@AfterTest
	public void closeDB() throws SQLException {
		closeDbConn();
	}
	@Ignore
	@Test(priority = 1) 
	public void test1() throws Exception {
		logger.info("TEST -- 1 --");
		logger.info("test for ==>compare xml structure , content , data inserted in DB vs expected <==");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		// executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);
		XmlComparator.read_xml_expected(2, 1, FILEPATH_REQUEST_PROCESSOR, "test_1.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_1.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("0");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 2)
	public void test2() throws Exception {
		logger.info("TEST -- 2 --");
		logger.info("test for ==> check response http status 200 <==");
		Response result = (Response) RestAssured.given().contentType("text/plain")
				.body(ReadBody.getBodyFromFilepath(FILEPATH_REQUEST_PROCESSOR, "test_1.xml"))
				.put(LINK_PROCESSOR + PROCESS + VERSION_PROCESSOR_1 + COUNTRY_TENANT).then().statusCode(200)
				.contentType("application/xml").extract().response();
	}
	@Ignore
	@Test(priority = 3)
	public void test3() throws Exception {
		logger.info("TEST -- 3 --");
		logger.info("test for ==><sourceXMLElement><==");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 12, FILEPATH_REQUEST_PROCESSOR, "test_1.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_2.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("2");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 4)
	public void test4() throws Exception {
		logger.info("TEST -- 4 --");
		logger.info("test for ==><targetColumn><==");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 13, FILEPATH_REQUEST_PROCESSOR, "test_1.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_3.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("3");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 5)
	public void test5() throws Exception {
		logger.info("TEST -- 5 --");
		logger.info("test for test for warrnig message received from validator==>");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 1, FILEPATH_REQUEST_PROCESSOR, "test_2.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_4.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("4");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 6)
	public void test6() throws Exception {
		logger.info("TEST -- 6 --");
		logger.info("test for warrnig message received from validator==>");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 1, FILEPATH_REQUEST_PROCESSOR, "test_3.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_5.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("5");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 7)
	public void test7() throws Exception {
		logger.info("TEST -- 7 --");
		logger.info("test negative for check the behvior of the request processor==>");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 1, FILEPATH_REQUEST_PROCESSOR, "test_4.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_6.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("6");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 8)
	public void test8() throws Exception {
		logger.info("TEST -- 8 --");
		logger.info("Test situation for tag : SUBSTR : extract first 5 caracters starting with the first ==>");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 2, FILEPATH_REQUEST_PROCESSOR, "test_5.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_7.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("8");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 9)
	public void test9() throws Exception {
		logger.info("TEST -- 9 --");
		logger.info(
				"Test situation for tag : SUBSTR : extract first 5 caracters starting with the first; string contain less then 5 char ==>");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 2, FILEPATH_REQUEST_PROCESSOR, "test_6.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_8.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("9");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 10)
	public void test10() throws Exception {
		logger.info("TEST -- 10 --");
		logger.info("If a tag has null value, the concatenated values from two columns will be inserted there==>");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 3, FILEPATH_REQUEST_PROCESSOR, "test_7.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_9.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("10");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 11)
	public void test11() throws Exception {
		logger.info("TEST -- 11 --DE DISCUTAT");
		logger.info(
				"If a tag has null value, the concatenated values from two columns will be inserted there(one one them is null==>");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 4, FILEPATH_REQUEST_PROCESSOR, "test_8.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_10.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("11");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	// @Test (priority=12)
	public void test12() throws Exception {
		logger.info("TEST -- 12 --DE FACUT REFACTOR LA COD--");
		logger.info("insert date SYSTIMESTAMP when a tag is missing==>");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 5, FILEPATH_REQUEST_PROCESSOR, "test_9.xml", PATH_EXPECTED_REQUEST_PROCESSOR,
				"expected_11.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("12");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 13)
	public void test13() throws Exception {
		logger.info("TEST -- 13 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		executeQuerryDB(INSERT_DB_1, strUserID, strPassword, dbURL);
		XmlComparator.read_xml_expected(2, 6, FILEPATH_REQUEST_PROCESSOR, "test_10.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_12.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("13");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	// @Test(priority = 14)
	public void test14() throws Exception {
		logger.info("TEST -- 14 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT null table");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 6, FILEPATH_REQUEST_PROCESSOR, "test_11.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_13.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("14");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 15)
	public void test15() throws Exception {
		logger.info("TEST -- 15 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT two record in table");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		executeQuerryDB(INSERT_DB_1, user, pass, url);
		executeQuerryDB(INSERT_DB_2, user, pass, url);
		XmlComparator.read_xml_expected(2, 6, FILEPATH_REQUEST_PROCESSOR, "test_12.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_14.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("15");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 16)
	public void test16() throws Exception {
		logger.info("TEST -- 16 --");
		logger.info(
				"test for <mappingRule>{FUNCTION:select......ON INSERT no record in table and skippline is prezent");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 7, FILEPATH_REQUEST_PROCESSOR, "test_13.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_15.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("16");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 17)
	public void test17() throws Exception {
		logger.info("TEST -- 17 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT integer");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		executeQuerryDB(INSERT_DB_3, user, pass, url);
		XmlComparator.read_xml_expected(2, 8, FILEPATH_REQUEST_PROCESSOR, "test_14.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_16.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("17");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 18)
	public void test18() throws Exception {
		logger.info("TEST -- 18 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT integer null table");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 8, FILEPATH_REQUEST_PROCESSOR, "test_15.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_17.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("18");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 19)
	public void test19() throws Exception {
		logger.info("TEST -- 19 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT integer two record in table");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		executeQuerryDB(INSERT_DB_4, user, pass, url);
		executeQuerryDB(INSERT_DB_5, user, pass, url);
		XmlComparator.read_xml_expected(2, 8, FILEPATH_REQUEST_PROCESSOR, "test_16.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_18.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("19");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 20)
	public void test20() throws Exception {
		logger.info("TEST -- 20 --");
		logger.info(
				"test for <mappingRule>{FUNCTION:select......ON INSERT integer no record in table and skippline is prezent");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 9, FILEPATH_REQUEST_PROCESSOR, "test_17.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_19.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("20");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	// date tests
	@Test(priority = 21)
	public void test21() throws Exception {
		logger.info("TEST -- 21 --");
		logger.info("test for <mappingRule>{FUNCTION:select......ON INSERT data ");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);
		executeQuerryDB(INSERT_DB_6, user, pass, url);
		executeQuerryDB(INSERT_DB_7, user, pass, url);
		executeQuerryDB(INSERT_DB_8, user, pass, url);
		XmlComparator.read_xml_expected(2, 10, FILEPATH_REQUEST_PROCESSOR, "test_18.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_20.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("21");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 22)
	public void test22() throws Exception {
		logger.info("TEST -- 22 --");
		logger.info("test for <mappingRule>{FUNCTION:select......ON INSERT data multiple record in table ");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		executeQuerryDB(INSERT_DB_6, user, pass, url);
		executeQuerryDB(INSERT_DB_7, user, pass, url);
		executeQuerryDB(INSERT_DB_8, user, pass, url);
		executeQuerryDB(INSERT_DB_9, user, pass, url);
		XmlComparator.read_xml_expected(2, 10, FILEPATH_REQUEST_PROCESSOR, "test_19.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_21.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("22");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 23)
	public void test23() throws Exception {
		logger.info("TEST -- 23 --");
		logger.info("test for <mappingRule>{FUNCTION:select......ON INSERT data no record in table ");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 10, FILEPATH_REQUEST_PROCESSOR, "test_20.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_22.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("23");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority = 24)
	public void test24() throws Exception {
		logger.info("TEST -- 24 --");
		logger.info("test for <mappingRule>{FUNCTION:select......ON INSERT data no record in table and skippline ");
		executeQuerryDB(CLEAN_DB, user, pass, url);
		XmlComparator.read_xml_expected(2, 11, FILEPATH_REQUEST_PROCESSOR, "test_21.xml",
				PATH_EXPECTED_REQUEST_PROCESSOR, "expected_23.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB, user, pass, url));
		listexpected = ReadCSVFile.readExpected("24");
		logger.info("check data inserted in DB");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		logger.info("check succesfully");
	}
	@Ignore
	@Test(priority=25)  // Merge   request ===> 22 23 24   expected  24 25 26 
	       
	public void test25() {
		logger.info("TEST -- 25 --");
		
		// conect and delete some record from MMS 
		// insert data initial
		// execute request 
		// compare expected with actual 
		// check data from db
		// delete data inserted in mms
	}
	
	
	@Test (priority = 28) // Merge MMS
	public void test28() throws Exception {
		logger.info("TEST --28 --");
		logger.info("test situation 1");
		executeQuerryDB(CLEAN_DB_BRAND_ID, user, pass, url);
		executeQuerryDB(INSERT_DB_BRAND_ID_1, user, pass, url);
		executeQuerryDB(INSERT_DB_BRAND_ID_2, user, pass, url);
		XmlComparator.read_xml_expected(2, 14, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",PATH_EXPECTED_REQUEST_PROCESSOR, "expected_27.xml", "null", 0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG, user, pass, url),"MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("27","MERGE_MMS");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_ENG, user, pass, url),"MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("28","MERGE_MMS");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);		
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL, user, pass, url),"MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("27","MERGE_MMS");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_POL, user, pass, url),"MERGE_MMS");
		listexpected = ReadCSVFile.readExpected("28","MERGE_MMS");
		value = ListComparator.compareLists(listactual, listexpected);
		assertEquals(true, value);
	}
	
	@Test (priority = 29) // Merge MMS
	public void test29() throws Exception {
		logger.info("TEST --29 --");
		executeQuerryDB(CLEAN_DB_BRAND_ID, user, pass, url);
		executeQuerryDB(INSERT_DB_BRAND_ID_1, user, pass, url);
		executeQuerryDB(INSERT_DB_BRAND_ID_2, user, pass, url);
		XmlComparator.read_xml_expected(2, 14, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",PATH_EXPECTED_REQUEST_PROCESSOR, "expected_27.xml", "null", 0);
		logger.info("interval is splitted started point");
		logger.info("execute request for split the second interval");		
		XmlComparator.read_xml_expected(2, 15, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",PATH_EXPECTED_REQUEST_PROCESSOR, "expected_28.xml", "null", 0);
		  listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_0, user, pass,url),"MERGE_MMS");		
		  listexpected = ReadCSVFile.readExpected("29","MERGE_MMS");		  
		  value = ListComparator.compareLists(listactual, listexpected);
		  assertEquals(true, value);
		  listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_1, user, pass,url),"MERGE_MMS");		
		  listexpected = ReadCSVFile.readExpected("30","MERGE_MMS");		  
		  value = ListComparator.compareLists(listactual, listexpected);
		  assertEquals(true, value);
		  listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_ENG_2, user, pass,url),"MERGE_MMS");		
		  listexpected = ReadCSVFile.readExpected("31","MERGE_MMS");		  
		  value = ListComparator.compareLists(listactual, listexpected);
		  assertEquals(true, value);		  
		  listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_2, user, pass,url),"MERGE_MMS");
		  listexpected = ReadCSVFile.readExpected("32","MERGE_MMS");
		  value = ListComparator.compareLists(listactual, listexpected);
		  assertEquals(true, value);
		  listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_0, user, pass,url),"MERGE_MMS");		
		  listexpected = ReadCSVFile.readExpected("29","MERGE_MMS");		  
		  value = ListComparator.compareLists(listactual, listexpected);
		  assertEquals(true, value);
		  listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_1, user, pass,url),"MERGE_MMS");		
		  listexpected = ReadCSVFile.readExpected("30","MERGE_MMS");		  
		  value = ListComparator.compareLists(listactual, listexpected);
		  assertEquals(true, value);
		  listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_POL_2, user, pass,url),"MERGE_MMS");		
		  listexpected = ReadCSVFile.readExpected("31","MERGE_MMS");		  
		  value = ListComparator.compareLists(listactual, listexpected);
		  assertEquals(true, value);		  
		  listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_2, user, pass,url),"MERGE_MMS");
		  listexpected = ReadCSVFile.readExpected("32","MERGE_MMS");
		  value = ListComparator.compareLists(listactual, listexpected);
		  assertEquals(true, value);		 
	}
	
	@Test (priority = 30) // Merge MMS
	public void test30() throws Exception {
		logger.info("TEST --30 --");
		executeQuerryDB(CLEAN_DB_BRAND_ID, user, pass, url);
		executeQuerryDB(INSERT_DB_BRAND_ID_1, user, pass, url);
		executeQuerryDB(INSERT_DB_BRAND_ID_2, user, pass, url);
		XmlComparator.read_xml_expected(2, 14, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",PATH_EXPECTED_REQUEST_PROCESSOR, "expected_27.xml", "null", 0);
		XmlComparator.read_xml_expected(2, 15, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",PATH_EXPECTED_REQUEST_PROCESSOR, "expected_28.xml", "null", 0);
		XmlComparator.read_xml_expected(2, 16, FILEPATH_REQUEST_PROCESSOR, "test_25.xml",PATH_EXPECTED_REQUEST_PROCESSOR, "expected_29.xml", "null", 0);
		 
		listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_3, user, pass,url),"MERGE_MMS");		
		 listexpected = ReadCSVFile.readExpected("33","MERGE_MMS");
		 value = ListComparator.compareLists(listactual, listexpected);
		 assertEquals(true, value);
		listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_4, user, pass,url),"MERGE_MMS");		
		 listexpected = ReadCSVFile.readExpected("34","MERGE_MMS");
		 value = ListComparator.compareLists(listactual, listexpected);
		 assertEquals(true, value);
		listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_ENG_5, user, pass,url),"MERGE_MMS");		
		 listexpected = ReadCSVFile.readExpected("35","MERGE_MMS");
		 value = ListComparator.compareLists(listactual, listexpected);
		 assertEquals(true, value);
		listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_6, user, pass,url),"MERGE_MMS");		
		 listexpected = ReadCSVFile.readExpected("36","MERGE_MMS");
		 value = ListComparator.compareLists(listactual, listexpected);
		 assertEquals(true, value);		 
		listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_7, user, pass,url),"MERGE_MMS");		
		 listexpected = ReadCSVFile.readExpected("37","MERGE_MMS");
		 value = ListComparator.compareLists(listactual, listexpected);
		 assertEquals(true, value);
		 		 
			listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_3, user, pass,url),"MERGE_MMS");		
			 listexpected = ReadCSVFile.readExpected("33","MERGE_MMS");
			 value = ListComparator.compareLists(listactual, listexpected);
			 assertEquals(true, value);
			listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_4, user, pass,url),"MERGE_MMS");		
			 listexpected = ReadCSVFile.readExpected("34","MERGE_MMS");
			 value = ListComparator.compareLists(listactual, listexpected);
			 assertEquals(true, value);
			listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_POL_5, user, pass,url),"MERGE_MMS");		
			 listexpected = ReadCSVFile.readExpected("35","MERGE_MMS");
			 value = ListComparator.compareLists(listactual, listexpected);
			 assertEquals(true, value);
			listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_6, user, pass,url),"MERGE_MMS");		
			 listexpected = ReadCSVFile.readExpected("36","MERGE_MMS");
			 value = ListComparator.compareLists(listactual, listexpected);
			 assertEquals(true, value);		 
			listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_POL_7, user, pass,url),"MERGE_MMS");		
			 listexpected = ReadCSVFile.readExpected("37","MERGE_MMS");
			 value = ListComparator.compareLists(listactual, listexpected);
			 assertEquals(true, value);			 			 
				listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_3, user, pass,url),"MERGE_MMS");		
				 listexpected = ReadCSVFile.readExpected("33","MERGE_MMS");
				 value = ListComparator.compareLists(listactual, listexpected);
				 assertEquals(true, value);
				listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_4, user, pass,url),"MERGE_MMS");		
				 listexpected = ReadCSVFile.readExpected("34","MERGE_MMS");
				 value = ListComparator.compareLists(listactual, listexpected);
				 assertEquals(true, value);
				listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_TO_ENG_5, user, pass,url),"MERGE_MMS");		
				 listexpected = ReadCSVFile.readExpected("35","MERGE_MMS");
				 value = ListComparator.compareLists(listactual, listexpected);
				 assertEquals(true, value);
				listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_6, user, pass,url),"MERGE_MMS");		
				 listexpected = ReadCSVFile.readExpected("36","MERGE_MMS");
				 value = ListComparator.compareLists(listactual, listexpected);
				 assertEquals(true, value);		 
				listactual =getDatafromDB(executeQuerryDB(GET_DATA_DB_BRAND_VALID_FROM_ENG_7, user, pass,url),"MERGE_MMS");		
				 listexpected = ReadCSVFile.readExpected("37","MERGE_MMS");
				 value = ListComparator.compareLists(listactual, listexpected);
				 assertEquals(true, value);
				 				 		 		
	}
	
	@Ignore
	@Test(priority = 31)
	public void test31() throws Exception {
		logger.info("--TEST 30--");
		executeQuerryDB(CLEAN_DB_BRAND_ID, user, pass, url);
		
		// test negative
		// bad body request  brand_id = wrong
	}
	
	@Ignore
	@Test(priority = 32)
	public void test32() {
		// test negative
		// bad request sub_brand_id=wrong
	}
	@Ignore
	@Test(priority=33)
	public void test33() {
		// test negative
		//bad request supplier_no = wrong
	}
	
	@Ignore
	@Test(priority = 34)
	
	public void test34() {
		// test negative
		// bad process xml 
	}
	
	@Ignore
	@Test(priority = 35)
	public void test35() {
		// test 
		// insert gap and add interval
	}
		
	//mvn clean test -DproxySet=true -DproxyHost=proxy.metro.ro -DproxyPort=3128 -DtestngFile=2_testng.xml -Dvar=dev -Dvarlink=dev -DCredential_user_dev=nwe -DCredential_pass_dev=europa
	// mvn clean test -DtestngFile=2_testng.xml -Dvar=pp -Dvarlink=pp1
	// mvn clean test -DtestngFile=2_testng.xml -Dvar=dev -Dvarlink=dev
}