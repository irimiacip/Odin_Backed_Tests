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


public class RequestProcessor {
final static Logger logger = Logger.getLogger(RequestProcessor.class);
static	List<String> listactual = new ArrayList<String>();
static List<String> listexpected = new ArrayList<String>();
static boolean value = true;

	@BeforeMethod
	public void startTest() {
		logger.info("=====================");
		logger.info("autentification......");
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.proxy = host("proxy.metro.ro").withPort(3128);
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
		logger.info("test for ==>compare xml structure , content , data inserted in DB vs expected <==");
		executeQuerryDB(CLEAN_DB, strUserID, strPassword, dbURL);	
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
	
    
}
