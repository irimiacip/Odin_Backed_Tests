package ODIN_VALIDATOR_APITEST;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public  class ActualResults {

	
	
	public static String obtainResponse(String body_1) throws Exception {
		
		Response result = (Response)RestAssured.given().
				contentType("text/plain").				
				body(ReadBody.bodyRead(body_1)).
				put(Consts.link + Consts.proces + Consts.version);		
		 String response = result.asString();
		return response;		    		
	}
	
	
}
