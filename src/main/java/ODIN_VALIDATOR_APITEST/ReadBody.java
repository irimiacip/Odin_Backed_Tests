package ODIN_VALIDATOR_APITEST;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadBody {
		
	 public static String readFileAsString(String fileName)throws Exception 
	  { 
	    String body = ""; 
	    body = new String(Files.readAllBytes(Paths.get(fileName))); 
	    return body; 
	  } 
	 
	 public static String getBodyFromFilepath(String path, String filename) throws Exception {
		 String body = readFileAsString(path + filename); 
		 return body; 
	 }
	 
	 public static String bodyRead(String filename) throws Exception {
		 String body = readFileAsString(filename); 
		 return body; 
	 }
	 

}
