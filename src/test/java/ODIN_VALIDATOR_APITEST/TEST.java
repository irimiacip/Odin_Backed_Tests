package ODIN_VALIDATOR_APITEST;

import static ODIN_VALIDATOR_APITEST.Consts.FILEPATH_VALIDATOR;
import static ODIN_VALIDATOR_APITEST.Consts.LINK;
import static ODIN_VALIDATOR_APITEST.Consts.PROCESS;
import static ODIN_VALIDATOR_APITEST.Consts.VERSION_1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TEST {
	@Test (priority=1)
	public void test1() throws Exception {
	
		System.out.println(System.getProperty("var"));
		
		
	}
}
