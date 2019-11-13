package ODIN_REQUEST_PROCESSOR_APITEST;

import static io.restassured.specification.ProxySpecification.host;
import static org.testng.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static ODIN_VALIDATOR_APITEST.Consts.*;

import ODIN_VALIDATOR_APITEST.ConnectDB;
import ODIN_VALIDATOR_APITEST.Consts;
import ODIN_VALIDATOR_APITEST.ListComparator;

import static ODIN_VALIDATOR_APITEST.DataBaseConsts.*;
import ODIN_VALIDATOR_APITEST.ReadBody;
import ODIN_VALIDATOR_APITEST.ReadCSVFile;
import ODIN_VALIDATOR_APITEST.XmlComparator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static ODIN_VALIDATOR_APITEST.ConnectDB.*;


public class RequestProcessorTest {
final static Logger logger = Logger.getLogger(RequestProcessorTest.class);
static	List<String> listactual = new ArrayList<String>();
static List<String> listexpected = new ArrayList<String>();
static boolean value = true;

	@BeforeMethod
	public void startTest() {
		logger.info("=====================");
		logger.info("autentification......");
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.useRelaxedHTTPSValidation();
		//RestAssured.proxy = host("proxy.metro.ro").withPort(3128);
	}
	
	@AfterMethod
	public void endTest() throws SQLException {
		//closeDbConn();
		logger.info("logout....");
		logger.info(" ");
	}
	@AfterTest
	public void closeDB() throws SQLException {
		closeDbConn();
	}

	
	@Test (priority=1)
	public void test1() throws Exception {	
		logger.info("TEST -- 1 --");
		logger.info("test for ==>compare xml structure , content , data inserted in DB vs expected <==");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		//executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 1,FILEPATH_REQUEST_PROCESSOR, "test_1.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_1.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("0");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}

	@Test (priority=2)
	public void test2() throws Exception {
		logger.info("TEST -- 2 --");
		logger.info("test for ==> check response http status 200 <==");
		
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.getBodyFromFilepath(FILEPATH_REQUEST_PROCESSOR, "test_1.xml")).
				put(LINK_PROCESSOR + PROCESS + VERSION_PROCESSOR_1 + COUNTRY_TENANT).				
				then().
				statusCode(200).contentType("application/xml").extract().response();
	}
	
	@Test (priority=3)
	public void test3() throws Exception {	
		logger.info("TEST -- 3 --");
		logger.info("test for ==><sourceXMLElement><==");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 10,FILEPATH_REQUEST_PROCESSOR, "test_1.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_2.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("2");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
		
	@Test (priority=4)
	public void test4() throws Exception {	
		logger.info("TEST -- 4 --");
		logger.info("test for ==><targetColumn><==");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 11,FILEPATH_REQUEST_PROCESSOR, "test_1.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_3.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("3");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=5)
	public void test5() throws Exception {	
		logger.info("TEST -- 5 --");
		logger.info("test for test for warrnig message received from validator==>");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 1,FILEPATH_REQUEST_PROCESSOR, "test_2.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_4.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("4");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=6)
	public void test6() throws Exception {	
		logger.info("TEST -- 6 --");
		logger.info("test for warrnig message received from validator==>");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 1,FILEPATH_REQUEST_PROCESSOR, "test_3.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_5.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("5");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=7)
	public void test7() throws Exception {	
		logger.info("TEST -- 7 --");
		logger.info("test negative for check the behvior of the request processor==>");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 1,FILEPATH_REQUEST_PROCESSOR, "test_4.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_6.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("6");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=8)
	public void test8() throws Exception {	
		logger.info("TEST -- 8 --");
		logger.info("Test situation for tag : SUBSTR : extract first 5 caracters starting with the first ==>");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 2,FILEPATH_REQUEST_PROCESSOR, "test_5.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_7.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("8");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=9)
	public void test9() throws Exception {	
		logger.info("TEST -- 9 --");
		logger.info("Test situation for tag : SUBSTR : extract first 5 caracters starting with the first; string contain less then 5 char ==>");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 2,FILEPATH_REQUEST_PROCESSOR, "test_6.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_8.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("9");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=10)
	public void test10() throws Exception {	
		logger.info("TEST -- 10 --");
		logger.info("If a tag has null value, the concatenated values from two columns will be inserted there==>");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 3,FILEPATH_REQUEST_PROCESSOR, "test_7.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_9.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("10");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=11)
	public void test11() throws Exception {	
		logger.info("TEST -- 11 --DE DISCUTAT");
		logger.info("If a tag has null value, the concatenated values from two columns will be inserted there(one one them is null==>");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 4,FILEPATH_REQUEST_PROCESSOR, "test_8.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_10.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("11");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=12)
	public void test12() throws Exception {	
		logger.info("TEST -- 12 --DE FACUT REFACTOR LA COD--");
		logger.info("insert date SYSTIMESTAMP when a tag is missing==>");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
		XmlComparator.read_xml_expected(2, 5,FILEPATH_REQUEST_PROCESSOR, "test_9.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_11.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("12");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=13)
	public void test13() throws Exception {	
		logger.info("TEST -- 13 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);
		executeQuerryDB(INSERT_DB, strUserID, strPassword, dbURL);
		XmlComparator.read_xml_expected(2, 6,FILEPATH_REQUEST_PROCESSOR, "test_10.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_12.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("13");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
	@Test (priority=14)
	public void test14() throws Exception {	
		logger.info("TEST -- 14 --");
		logger.info("test for <mappingRule>{FUNCTION:select..... ON INSERT");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);
		XmlComparator.read_xml_expected(2, 6,FILEPATH_REQUEST_PROCESSOR, "test_11.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_13.xml","null",0);
		listactual = getDatafromDB(executeQuerryDB(GET_DATA_DB,strUserID, strPassword, dbURL));
		listexpected = ReadCSVFile.readExpected("14");
		logger.info("check data inserted in DB");
		value=ListComparator.compareLists(listactual, listexpected);		
		assertEquals(true, value);
		logger.info("check succesfully");					
	}
	
}
