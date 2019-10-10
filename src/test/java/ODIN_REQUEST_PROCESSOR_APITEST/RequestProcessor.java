package ODIN_REQUEST_PROCESSOR_APITEST;

import static io.restassured.specification.ProxySpecification.host;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static ODIN_VALIDATOR_APITEST.Consts.*;
import ODIN_VALIDATOR_APITEST.Consts;
import ODIN_VALIDATOR_APITEST.ReadBody;
import ODIN_VALIDATOR_APITEST.XmlComparator;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestProcessor {
final static Logger logger = Logger.getLogger(RequestProcessor.class);
	

	@BeforeMethod

	public void startTest() {
		logger.info("autentification......");
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.proxy = host("proxy.metro.ro").withPort(3128);
	}
	
	@AfterMethod
	public void endTest() {
		logger.info("logout....");
		logger.info(" ");
	}
	
	@Test (priority=1)
	public void test1() throws Exception {	
		logger.info("test for ==>compare xml structure and content<==");
		XmlComparator.read_xml_expected(2, 1,FILEPATH_REQUEST_PROCESSOR, "test_1.xml" , PATH_EXPECTED_REQUEST_PROCESSOR, "expected_1.xml","null",0);				
	
	  
	}
	
	@Test (priority=2)
	public void test2() throws Exception {
		logger.info("test for check response ==>http status 200<==");
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.getBodyFromFilepath(FILEPATH_REQUEST_PROCESSOR, "test_1.xml")).
				put(LINK_PROCESSOR + PROCESS + VERSION_PROCESSOR + COUNTRY_TENANT).				
				then().
				statusCode(200).contentType("application/xml").extract().response();
	}
    

}
