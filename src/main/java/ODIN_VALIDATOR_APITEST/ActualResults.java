package ODIN_VALIDATOR_APITEST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static ODIN_VALIDATOR_APITEST.Consts.*;
public  class ActualResults {

	
	
	public static String obtainResponse(String body_1) throws Exception {
		
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.bodyRead(body_1)).
				put(LINK + PROCESS + VERSION);		
		 String response = result.asString();
		return response;		    		
	}
	
	
}
