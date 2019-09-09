package ODIN_VALIDATOR_APITEST;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;


public class XmlComparator {
	

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void read_xml_expected(String actualXml , String expectedXml) throws SAXException, IOException, Exception {

		FileInputStream fis1 = new FileInputStream("src/main/resources/validator/expected/"+ expectedXml);		 
		 BufferedReader expected = new BufferedReader(new InputStreamReader(fis1));

		 String strExpected = org.apache.commons.io.IOUtils.toString(expected);
		 
		 XMLUnit.setIgnoreWhitespace(true); 
		 
		 
		 List differences = compareXML(ActualResults.obtainResponse(actualXml), strExpected); 
		 		 
		 printDifferences(differences);
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
