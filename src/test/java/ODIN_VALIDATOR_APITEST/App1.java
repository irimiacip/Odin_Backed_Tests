package ODIN_VALIDATOR_APITEST;

import static ODIN_VALIDATOR_APITEST.ActualResults.obtainResponse;
import static io.restassured.specification.ProxySpecification.host;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;



public class App1 {
	
	final static Logger logger = Logger.getLogger(App1.class);
	
@BeforeClass
public void xxx() {
	System.out.println("Inceput clasa 1");
}

@AfterClass
public void yyy() {
	System.out.println("Terminat clasa 1");
}
	@BeforeMethod

	public void startTest() {
		System.out.println(" begin ");
		logger.info("autentification......");
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.proxy = host("proxy.metro.ro").withPort(3128);
	}

	@Test (priority=1)
	public void test1() throws Exception {
		logger.info("test for check response status 200");
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.bodyRead("test_1.xml")).
				put(Consts.link + Consts.proces + Consts.version).
				then().
				statusCode(200).contentType("application/xml").extract().response();
	}

	@Test (priority=2)
	public void test2() throws Exception {	
		logger.info("test for  check contain messageType");
		String respond = obtainResponse("test_1.xml");		
		String check = "<messageType>OK</messageType>";		  
		assertTrue(respond.contains(check));
	}


	@Test(priority=3)
	public void test3() throws Exception {
		logger.info("test for check contain status");
		String check = "<statuscode>0</statuscode>";
		String respond = obtainResponse("test_1.xml");		 
		assertEquals((StringUtils.countMatches(respond, check)), 2);  
	}

	
	@Test (priority=4)
	public void test4() throws Exception {	
		logger.info("test for compare xml structure and content");
		XmlComparator.read_xml_expected("test_1.xml" ,"expected_1.xml");				
	}
	
	@Test(priority=5)
	public void test5() throws Exception {
		logger.info("test for validate <elementName>");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String respond = obtainResponse("test_2.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);  
	}
	
	
	@Test(priority=6)
	public void test6() throws Exception {
		logger.info("test for validate the xml structure");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String respond = obtainResponse("test_3.xml");		
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2); 
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2); 
	}
			
	@Test(priority=7)
	public void test7() throws Exception {
		logger.info("test for validate minimum value accepted");
		System.out.println("validate minimum value accepted ");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse("test_4.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);		
	}
	
	@Test(priority=8)
	public void test8() throws Exception {
		logger.info("test for validate maximum value accepted ");
		System.out.println("validate maximum value accepted ");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse("test_5.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);		
	}
	
	@Test(priority=9)
	public void test9() throws Exception {
		logger.info("test for validate maximum value +1 not accepted");
		System.out.println("validate maximum value +1 not accepted ");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>maxValue</brokenRule>";
		String respond = obtainResponse("test_6.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=10)
	public void test10() throws Exception {
		logger.info("test for validate minimum value -1 not accepted ");
		System.out.println("validate minimum value -1 not accepted ");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>minValue</brokenRule>";
		String respond = obtainResponse("test_7.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	@Test(priority=11)
	public void test11() throws Exception {
		logger.info("test for validate variable");
		System.out.println("variable validation ");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String respond = obtainResponse("test_8.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
	}
	
	@Test(priority=12)
	public void test12() throws Exception {
		logger.info("test for digit validation");
		System.out.println("digit validation ");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>digits</brokenRule>";
		String respond = obtainResponse("test_9.xml");	
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	

	@Test(priority=13)
	public void test13() throws Exception {
		logger.info("test for validate min occur ");
		System.out.println("validate min occur ");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>minOccurs</brokenRule>";
		String respond = obtainResponse("test_10.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=14)
	public void test14() throws Exception {
		logger.info("test for validate max occur ");
		System.out.println("validate max occur ");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>maxOccurs</brokenRule>";
		String respond = obtainResponse("test_11.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 2);
	}	
 // validate the atribute
	@Test(priority=15)
	public void test15() throws Exception {
		System.out.println("digit min occur atribute");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse("test_12.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}	
	
	@Test(priority=16)
	public void test16() throws Exception {
		System.out.println("digit max occur atribute");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse("test_13.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=17)
	public void test17() throws Exception {
		System.out.println("digit max occur+1 atribute");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>minOccurs</brokenRule>";
		String respond = obtainResponse("test_14.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=18)
	public void test18() throws Exception {
		System.out.println("validate  minLength atribute");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse("test_15.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=19)
	public void test19() throws Exception {
		System.out.println("validate  maxLength atribute");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse("test_16.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=20)
	public void test20() throws Exception {
		System.out.println("validate  minLength-1 atribute");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>minLength</brokenRule>";
		String respond = obtainResponse("test_17.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=21)
	public void test21() throws Exception {
		System.out.println("validate  maxLength+1 atribute");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>maxLength</brokenRule>";
		String respond = obtainResponse("test_18.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=22)
	public void test22() throws Exception {
		System.out.println("validate  string atribute");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse("test_19.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@AfterMethod
	public void endTest() {
		System.out.println("end");
		logger.info("logout....");
	}

}

//mvn clean test -DtestngFile=testng.xml
