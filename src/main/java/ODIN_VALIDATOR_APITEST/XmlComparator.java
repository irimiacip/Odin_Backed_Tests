package ODIN_VALIDATOR_APITEST;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;


public class XmlComparator {
	

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void read_xml_expected(int microservice, String path, String actualXml , String path_expected, String expectedXml) throws SAXException, IOException, Exception {

		FileInputStream fis1 = new FileInputStream(path_expected+ expectedXml);		 
		 BufferedReader expected = new BufferedReader(new InputStreamReader(fis1));

		 String strExpected = org.apache.commons.io.IOUtils.toString(expected);
		
		 XMLUnit.setIgnoreWhitespace(true); 		 
		 
		// List differences_validator = compareXML(ActualResults.obtainResponse(path, actualXml), strExpected); 
		// List differences_request_procesor = compareXML(ActualResults.obtainResponse_request_processor(path, actualXml), strExpected); 
		 
		 switch (microservice) {
		 case 1:
			 List differences_validator = compareXML(ActualResults.obtainResponse(path, actualXml), strExpected); 
             // System.out.println("differences_validator");
              printDifferences(differences_validator);
              break;
		 case 2:
			 List differences_request_procesor = compareXML(ActualResults.obtainResponse_request_processor(path, actualXml), strExpected); 
             //System.out.println("differences_request_procesor");
             printDifferences(differences_request_procesor);
             break;
		 case 3:
             System.out.println("differences_response");
           //  printDifferences(differences_response);


		 }
		 
		 
		
    }
    
    @SuppressWarnings("rawtypes")
	public static List compareXML(String string, String string2) throws SAXException, IOException { 

		 Diff xmlDiff = new Diff(string, string2); 
		 		 
		 DetailedDiff detailXmlDiff = new DetailedDiff(xmlDiff); 
		 
		 return detailXmlDiff.getAllDifferences(); 
		 
		 } 
		 
		 public static void printDifferences(List<String> differences)  { 
			  
	     int totalDifferences = differences.size(); 
	     System.out.println("==============================="); 
		 System.out.println("Total differences : " + totalDifferences);
		 System.out.println("================================"); 
		 
		 		 
		 for(String difference : differences){
			 
			 System.out.println(difference); } 
		 
		 }
	 
}
