package ODIN_VALIDATOR_APITEST;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadBody {
	
	public static String filePath = "src/main/resources/validator/files/";
	
	 public static String readFileAsString(String fileName)throws Exception 
	  { 
	    String body = ""; 
	    body = new String(Files.readAllBytes(Paths.get(fileName))); 
	    return body; 
	  } 
	 
	 public static String bodyRead(String filename) throws Exception {
		 String body = readFileAsString(filePath+filename); 
		 return body; 
	 }
}
