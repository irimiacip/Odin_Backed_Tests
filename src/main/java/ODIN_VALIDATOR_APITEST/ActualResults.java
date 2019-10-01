package ODIN_VALIDATOR_APITEST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static ODIN_VALIDATOR_APITEST.Consts.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public  class ActualResults {

	
	
	public static String obtainResponse_validator_v1(String path, String body_1) throws Exception {
		
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.getBodyFromFilepath(path, body_1)).
				put(LINK + PROCESS + VERSION_1);		
		 String response = result.asString();
		return response;		    		
	}
	
	
	public static String obtainResponse_validator_v2(String path, String body_1) throws Exception {
		
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.getBodyFromFilepath(path, body_1)).
				put(LINK + PROCESS + VERSION_2);		
		 String response = result.asString();
		return response;		    		
	}
	
	public static String obtainResponse_validator_v3(String path, String body_1, String day) throws Exception {
		
		
        String data_system = DataCalcul.returnDate(day);
		String replace = ReadBody.getBodyFromFilepath(path, body_1);
		replace = replace.replace("DATE", data_system);
						
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(replace).
				put(LINK + PROCESS + VERSION_3);		
		 String response = result.asString();
		return response;		    		
	}
	
	
	public static String obtainResponse_request_processor(String path, String body_1) throws Exception {
		
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.getBodyFromFilepath(path, body_1)).
				put(LINK_PROCESSOR + PROCESS + VERSION_PROCESSOR + COUNTRY_TENANT);		
		 String response = result.asString();
		return response;		    		
	}
}
