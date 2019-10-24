package ODIN_VALIDATOR_APITEST;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ODIN_VALIDATOR_APITEST.Consts.*;

public class ReadCSVFile {

	public static void main(String[] args) {
		readExpected("0");
	}
	
	
	static List<String> listexpected = new ArrayList<String>();
	
	public static List<String> readExpected(String linefromcsv) {
		String csvFile = Consts.PATH_EXPECTED_REQUEST_PROCESSOR +"/expected_values.csv" ;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;
            while ((line = br.readLine()) != null) {
            		            		
            	if (String.valueOf(i).equals(linefromcsv)) {
                String[] values = line.split(cvsSplitBy);
               // System.out.println("DATA [value_1= " + values[1] + " , value_2=" + values[2] + ", value_3= " + values[3] + " ,value_4= " + values[4] + " ]");
                listexpected.add(values[1]);
                listexpected.add(values[2]);
                listexpected.add(values[3]);
                listexpected.add(values[4]);
            	}
            	i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
           
		return listexpected;

		
    }

	}


