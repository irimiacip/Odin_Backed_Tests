package ODIN_VALIDATOR_APITEST;

/*import static ODIN_VALIDATOR_APITEST.DataCalcul.fomatDay;
import static ODIN_VALIDATOR_APITEST.DataCalcul.getDayPlus1;*/
import static ODIN_VALIDATOR_APITEST.DataCalcul.data_special;
import static ODIN_VALIDATOR_APITEST.DataCalcul.fomatDay;
import static ODIN_VALIDATOR_APITEST.DataCalcul.getDay;
import static ODIN_VALIDATOR_APITEST.DataCalcul.getDayPlus1;

//import static ODIN_VALIDATOR_APITEST.DataCalcul.data_special;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFile {

	public static void main(String[] args) throws Exception {
		/*
		 * readExpected("7"); updated_list();
		 * System.out.println("=========new list=================="); updated_list();
		 */

		readExpected("28", "MERGE_MMS");
	}

	public static List<String> readExpected(String linefromcsv) throws Exception {
		List<String> listexpected = new ArrayList<String>();
		String csvFile = Consts.PATH_EXPECTED_REQUEST_PROCESSOR + "/expected_values.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			int i = 0;
			while ((line = br.readLine()) != null) {

				if (String.valueOf(i).equals(linefromcsv)) {
					String[] values = line.split(cvsSplitBy);
					listexpected.add(values[1].toString());
					listexpected.add(values[2].toString());
					listexpected.add(values[3].toString());
					listexpected.add(values[4].toString());
				}
				i++;
			}
			updated_list(listexpected);

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

	public static List<String> readExpected(String linefromcsv, String MERGE_TYPE) throws Exception {
		String csvFile = Consts.PATH_EXPECTED_REQUEST_PROCESSOR + "/expected_values.csv";
		List<String> listexpected = new ArrayList<String>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			int i = 0;
			while ((line = br.readLine()) != null) {

				if (String.valueOf(i).equals(linefromcsv)) {
					String[] values = line.split(cvsSplitBy);
					listexpected.add(values[1].toString());
					listexpected.add(values[2].toString());
				}
				i++;
			}
			updated_list_merge(listexpected);

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

	public static void updated_list(List<String> listexpected) throws Exception {
		int i = 0;
		while (i < listexpected.size()) {
			// System.out.println("expected data :" + listexpected.get(i));
			if (listexpected.get(i).equals("DATE+1")) {
				// System.out.println(i);
				listexpected.set(i, fomatDay(getDayPlus1()).toString());
			} else if (listexpected.get(i).equals("DATE-FORMAT")) {
				listexpected.set(i, data_special().toString().trim());
			} else if (listexpected.get(i).equals("DATE")) {
				listexpected.set(i, fomatDay(getDay()).toString());
			}
			i++;
		}
	}

	public static void updated_list_merge(List<String> listexpected) throws Exception {
		int i = 0;
		while (i < listexpected.size()) {
			// System.out.println("expected data :" + listexpected.get(i));
			if (listexpected.get(i).equals("DATE+1")) {
				// System.out.println(i);
				listexpected.set(i, getDayPlus1().toString() + " 00:00:00");
			} else if (listexpected.get(i).equals("DATE-FORMAT")) {
				listexpected.set(i, data_special().toString().trim());
			} else if (listexpected.get(i).equals("DATE")) {
				listexpected.set(i, getDay().toString() + " 00:00:00");
			}
			i++;
		}
	}

	/*
	 * public static void read_new_list() { int i = 0; while (i <
	 * listexpected.size()) { System.out.println("expected data :" +
	 * listexpected.get(i));
	 * 
	 * i++; } }
	 */

}
