package ODIN_VALIDATOR_APITEST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

public class ListComparator {

	static boolean value = true;
	static List<String> listactual = new ArrayList<String>();
	static List<String> listexpected = new ArrayList<String>();
	final static Logger logger = Logger.getLogger(ListComparator.class);

	public static boolean compareLists(List<String> listactual, List<String> listexpected) {

		try {
			
			System.out.println("listactual=" + listactual);
			System.out.println("listexpected= " + listexpected);

			Integer[] diff = new Integer[4];
			System.out.println("valoare inainte :" + value);
			if (value = listactual.equals(listexpected)) {
				// System.out.println("valoare dupa check :" + value);
				// System.out.println("SUNT EGALE");
			} else {
				// System.out.println("SE PARE CA NU SUNT EGALE");
				int k = 0;
				while (k < listactual.size()) {

					if (listactual.get(k) != listexpected.get(k)) {
						diff[k] = k;
					}

					k++;
				}
				// System.out.println("show differences " + Arrays.toString(diff));
				logger.info("show differences " + Arrays.toString(diff));
				value = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}
	
	public static boolean compareLists1(List<String> listactual, List<String> listexpected) {

		try {
			int j = 0;
			while (j < listactual.size()) {
				System.out.println("actual data :" + listactual.get(j));
				j++;
			}
			int i = 0;
			while (i < listexpected.size()) {
				System.out.println("expected data :" + listexpected.get(i));
				i++;
			}

			Integer[] diff = new Integer[4];
			System.out.println("valoare inainte :" + value);
			if (value = listactual.equals(listexpected)) {
				// System.out.println("valoare dupa check :" + value);
				// System.out.println("SUNT EGALE");
			} else {
				// System.out.println("SE PARE CA NU SUNT EGALE");
				int k = 0;
				while (k < listactual.size()) {

					if (listactual.get(k) != listexpected.get(k)) {
						diff[k] = k;
					}

					k++;
				}
				// System.out.println("show differences " + Arrays.toString(diff));
				logger.info("show differences " + Arrays.toString(diff));
				value = false;
			}
		} catch (Exception e) {
			System.out.println("listactual=");
			System.out.println(listactual);
			System.out.println("listexpected=");
			System.out.println(listexpected);
			e.printStackTrace();
		}

		return value;
	}

}
