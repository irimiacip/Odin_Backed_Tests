package ODIN_VALIDATOR_APITEST;

import static ODIN_VALIDATOR_APITEST.ActualResults.obtainResponse_validator_v1;
import static ODIN_VALIDATOR_APITEST.Consts.FILEPATH_VALIDATOR;
import static ODIN_VALIDATOR_APITEST.Consts.LINK;
import static ODIN_VALIDATOR_APITEST.Consts.PROCESS;
import static ODIN_VALIDATOR_APITEST.Consts.*;
import static ODIN_VALIDATOR_APITEST.Consts.PATH_EXPECTED_VALIDATOR;
import static io.restassured.specification.ProxySpecification.host;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class App1 {
	
	final static Logger logger = Logger.getLogger(App1.class);
	

	@BeforeMethod

	public void startTest() {
		logger.info("autentification......");
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.proxy = host("proxy.metro.ro").withPort(3128);
	}

	@Test (priority=1)
	public void test1() throws Exception {
		logger.info("test for check response ==>http status 200<==");
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.getBodyFromFilepath(FILEPATH_VALIDATOR, "test_1.xml")).
				put(LINK + PROCESS + VERSION_1).
				then().
				statusCode(200).contentType("application/xml").extract().response();
	}

	@Test (priority=2)
	public void test2() throws Exception {	
		logger.info("test for  check ==>contain tag messageType<==");
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_1.xml");		
		String check = "<messageType>OK</messageType>";		  
		assertTrue(respond.contains(check));
	}


	@Test(priority=3)
	public void test3() throws Exception {
		logger.info("test for check ==> contain tag status <==");
		String check = "<statuscode>0</statuscode>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_1.xml");		 
		assertEquals((StringUtils.countMatches(respond, check)), 2);  
	}

	
	@Test (priority=4)
	public void test4() throws Exception {	
		logger.info("test for ==>compare xml structure and content<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_1.xml" , PATH_EXPECTED_VALIDATOR, "expected_1.xml","null");				
	}
	
	@Test(priority=5)
	public void test5() throws Exception {
		logger.info("test for ==>validate <elementName> <==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_2.xml" , PATH_EXPECTED_VALIDATOR, "expected_2.xml","null");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_2.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);  
	}
	
	
	@Test(priority=6)
	public void test6() throws Exception {
		logger.info("test for ==>validate the xml structure<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_3.xml" , PATH_EXPECTED_VALIDATOR, "expected_3.xml","null");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_3.xml");		
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2); 
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2); 
	}
			
	@Test(priority=7)
	public void test7() throws Exception {
		logger.info("test for ==>validate minimum value accepted<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_4.xml" , PATH_EXPECTED_VALIDATOR, "expected_4.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_4.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);		
	}
	
	@Test(priority=8)
	public void test8() throws Exception {
		logger.info("test for ==>validate maximum value accepted<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_5.xml" , PATH_EXPECTED_VALIDATOR, "expected_5.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_5.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);		
	}
	
	@Test(priority=9)
	public void test9() throws Exception {
		logger.info("test for ==>validate maximum value +1 not accepted<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_6.xml" , PATH_EXPECTED_VALIDATOR, "expected_6.xml","null");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>maxValue</brokenRule>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_6.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=10)
	public void test10() throws Exception {
		logger.info("test for ==>validate minimum value -1 not accepted<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_7.xml" , PATH_EXPECTED_VALIDATOR, "expected_7.xml","null");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>minValue</brokenRule>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_7.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	@Test(priority=11)
	public void test11() throws Exception {
		logger.info("test for ==>validate variable<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_8.xml" , PATH_EXPECTED_VALIDATOR, "expected_8.xml","null");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_8.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
	}
	
	@Test(priority=12)
	public void test12() throws Exception {
		logger.info("test for ==>digit validation<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_9.xml" , PATH_EXPECTED_VALIDATOR, "expected_9.xml","null");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>digits</brokenRule>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_9.xml");	
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	

	@Test(priority=13)
	public void test13() throws Exception {
		logger.info("test for ==>validate min occur<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_10.xml" , PATH_EXPECTED_VALIDATOR, "expected_10.xml","null");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>minOccurs</brokenRule>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_10.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=14)
	public void test14() throws Exception {
		logger.info("test for ==>validate max occur<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_11.xml" , PATH_EXPECTED_VALIDATOR, "expected_11.xml","null");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>maxOccurs</brokenRule>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_11.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 2);
	}	
	
 // validate the atribute
	
	@Test(priority=15)
	public void test15() throws Exception {
		logger.info("test for ==> digit min occur atribute <==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_12.xml" , PATH_EXPECTED_VALIDATOR, "expected_12.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_12.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}	
	
	@Test(priority=16)
	public void test16() throws Exception {
		logger.info("test for ==> digit max occur atribute <==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_13.xml" , PATH_EXPECTED_VALIDATOR, "expected_13.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_13.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=17)
	public void test17() throws Exception {
		logger.info("test for ==> digit max occur+1 atribute <==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_14.xml" , PATH_EXPECTED_VALIDATOR, "expected_14.xml","null");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>minOccurs</brokenRule>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_14.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=18)
	public void test18() throws Exception {
		logger.info("test for ==> validate  minLength atribute <==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_15.xml" , PATH_EXPECTED_VALIDATOR, "expected_15.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_15.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=19)
	public void test19() throws Exception {
		logger.info("test for ==> validate  maxLength atribute <==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_16.xml" , PATH_EXPECTED_VALIDATOR, "expected_16.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_16.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	//=======DE CLARIFICAT =======
	@Test(priority=20)
	public void test20() throws Exception {
		logger.info("test for ==> validate  minLength-1 atribute <==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_17.xml" , PATH_EXPECTED_VALIDATOR, "expected_17.xml","null");
		String check_statuscode = "<statuscode>-2</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>minLength</brokenRule>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_17.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 2);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=21)
	public void test21() throws Exception {
		logger.info("test for ==> validate  maxLength+1 atribute <==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_18.xml" , PATH_EXPECTED_VALIDATOR, "expected_18.xml","null");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String check_brokenRule= "<brokenRule>maxLength</brokenRule>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_18.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
		assertEquals((StringUtils.countMatches(respond, check_brokenRule)), 1);
	}
	
	@Test(priority=22)
	public void test22() throws Exception {
		logger.info("test for ==>validate  string atribute<==");
		XmlComparator.read_xml_expected(1, 1,FILEPATH_VALIDATOR, "test_19.xml" , PATH_EXPECTED_VALIDATOR, "expected_19.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = obtainResponse_validator_v1(FILEPATH_VALIDATOR, "test_19.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	//=========boolean vaiable ============
	@Test(priority=23)
	public void test23() throws Exception {
		logger.info("test for ==>validate  boolean  variable false <==");
		XmlComparator.read_xml_expected(1, 2,FILEPATH_VALIDATOR, "test_20.xml" , PATH_EXPECTED_VALIDATOR, "expected_20.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = ActualResults.obtainResponse_validator_v2(FILEPATH_VALIDATOR, "test_20.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=24)
	public void test24() throws Exception {
		logger.info("test for ==>validate  boolean varialve true<==");
		XmlComparator.read_xml_expected(1, 2,FILEPATH_VALIDATOR, "test_21.xml" , PATH_EXPECTED_VALIDATOR, "expected_21.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = ActualResults.obtainResponse_validator_v2(FILEPATH_VALIDATOR, "test_21.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=25)
	public void test25() throws Exception {
		logger.info("test for ==>validate  booleam max occurance true<==");
		XmlComparator.read_xml_expected(1, 2,FILEPATH_VALIDATOR, "test_22.xml" , PATH_EXPECTED_VALIDATOR, "expected_22.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = ActualResults.obtainResponse_validator_v2(FILEPATH_VALIDATOR, "test_22.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=26)
	public void test26() throws Exception {
		logger.info("test for ==>validate  booleam max occurance false<==");
		XmlComparator.read_xml_expected(1, 2,FILEPATH_VALIDATOR, "test_23.xml" , PATH_EXPECTED_VALIDATOR, "expected_23.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = ActualResults.obtainResponse_validator_v2(FILEPATH_VALIDATOR, "test_23.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=27) 
	public void test27() throws Exception {
		logger.info("test for ==>validate  booleam max occurance true/false<==");
		XmlComparator.read_xml_expected(1, 2,FILEPATH_VALIDATOR, "test_24.xml" , PATH_EXPECTED_VALIDATOR, "expected_24.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = ActualResults.obtainResponse_validator_v2(FILEPATH_VALIDATOR, "test_24.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=28)
	public void test28() throws Exception {
		logger.info("test for ==>validate  booleam max occurance false/true<==");
		XmlComparator.read_xml_expected(1, 2,FILEPATH_VALIDATOR, "test_25.xml" , PATH_EXPECTED_VALIDATOR, "expected_25.xml","null");
		String check_statuscode = "<statuscode>0</statuscode>";
		String check_messageType = "<messageType>OK</messageType>";
		String respond = ActualResults.obtainResponse_validator_v2(FILEPATH_VALIDATOR, "test_25.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=29)
	public void test29() throws Exception {
		logger.info("test for ==>validate  boolean max occurance + 1<==");
		XmlComparator.read_xml_expected(1, 2,FILEPATH_VALIDATOR, "test_26.xml" , PATH_EXPECTED_VALIDATOR, "expected_26.xml","null");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String respond = ActualResults.obtainResponse_validator_v2(FILEPATH_VALIDATOR, "test_26.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=30) 
	public void test30() throws Exception {
		logger.info("test for ==>validate  boolean min occurance -1<==");
		XmlComparator.read_xml_expected(1, 2,FILEPATH_VALIDATOR, "test_27.xml" , PATH_EXPECTED_VALIDATOR, "expected_27.xml","null");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String respond = ActualResults.obtainResponse_validator_v2(FILEPATH_VALIDATOR, "test_27.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@Test(priority=31)
	public void test31() throws Exception {
		logger.info("test for ==>validate  boolean value<==");
		XmlComparator.read_xml_expected(1, 2,FILEPATH_VALIDATOR, "test_28.xml" , PATH_EXPECTED_VALIDATOR, "expected_28.xml","null");
		String check_statuscode = "<statuscode>-1</statuscode>";
		String check_messageType = "<messageType>ERROR</messageType>";
		String respond = ActualResults.obtainResponse_validator_v2(FILEPATH_VALIDATOR, "test_28.xml");		 
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	//======= finish boolean variable=======
	
	@Test(priority=32)
	public void test32() throws Exception {	
		logger.info("test for  check xxx ==>contain xxxxx<==");
		XmlComparator.read_xml_expected(1, 3,FILEPATH_VALIDATOR, "test.xml" , PATH_EXPECTED_VALIDATOR, "expected_test.xml" , "today");
		String respond = ActualResults.obtainResponse_validator_v3(FILEPATH_VALIDATOR, "test.xml", "today");		
		String check_messageType = "<messageType>WARNING</messageType>";	
		String check_statuscode = "<statuscode>1</statuscode>";        
		assertEquals((StringUtils.countMatches(respond, check_statuscode)), 2);  
		assertEquals((StringUtils.countMatches(respond, check_messageType)), 1);
	}
	
	@AfterMethod
	public void endTest() {
		logger.info("logout....");
		logger.info(" ");
	}

}

//mvn clean test -DtestngFile=testng.xml
