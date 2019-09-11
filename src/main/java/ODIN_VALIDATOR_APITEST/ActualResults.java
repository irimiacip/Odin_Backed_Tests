package ODIN_VALIDATOR_APITEST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static ODIN_VALIDATOR_APITEST.Consts.*;
public  class ActualResults {

	
	
	public static String obtainResponse(String path, String body_1) throws Exception {
		
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.getBodyFromFilepath(path, body_1)).
				put(LINK + PROCESS + VERSION);		
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
