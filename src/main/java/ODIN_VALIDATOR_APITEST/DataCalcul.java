package ODIN_VALIDATOR_APITEST;
import static ODIN_VALIDATOR_APITEST.Consts.FILEPATH_VALIDATOR;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.omg.Messaging.SyncScopeHelper;

public class DataCalcul {

	public static String returnDate(String date_required, Integer i) throws Exception {
		String aaa="";
		Calendar time = Calendar.getInstance();//time.getTime()
		
		if(date_required.contains("today")) {
			Date today = time.getTime();
			time.add(Calendar.DAY_OF_YEAR, 1);
			time.add(Calendar.DATE, 1);  
			String TIMESTAMP_FORMAT = "dd.MM.yyyy HH:mm:ss.SSSSSS";
			String[] DATE_FORMAT = new String[] {"dd.MM.yyyy", "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss'Z'" , 
			            "MM.dd.yyyy", "MM.d.yyyy", "dd.M.yyyy", "M.d.yyyy", "d.M.yyyy", "d.MM.yyyy", "M.dd.yyyy"};
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT[i]);
	        SimpleDateFormat timestampFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
	        aaa= dateFormat.format(today);
		}else if(date_required.contains("tomorrow")) {
			Date today = time.getTime();
			Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
			time.add(Calendar.DATE, 1);  
			String TIMESTAMP_FORMAT = "dd.MM.yyyy HH:mm:ss.SSSSSS";
			String[] DATE_FORMAT = new String[] {"dd.MM.yyyy", "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss'Z'" , 
			            "MM.dd.yyyy", "MM.d.yyyy", "dd.M.yyyy", "M.d.yyyy", "d.M.yyyy", "d.MM.yyyy", "M.dd.yyyy"};
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT[i]);
	        SimpleDateFormat timestampFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
	        aaa= dateFormat.format(tomorrow);
		}else {
			Date today = time.getTime();
			Date yesterday = new Date(today.getTime() - (1000 * 60 * 60 * 24));
			time.add(Calendar.DATE, 1);  
			String TIMESTAMP_FORMAT = "dd.MM.yyyy HH:mm:ss.SSSSSS";
			String[] DATE_FORMAT = new String[] {"dd.MM.yyyy", "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss'Z'" , 
			            "MM.dd.yyyy", "MM.d.yyyy", "dd.M.yyyy", "M.d.yyyy", "d.M.yyyy", "d.MM.yyyy", "M.dd.yyyy"};
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT[i]);
	        SimpleDateFormat timestampFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
	        aaa= dateFormat.format(yesterday);
		}

        return aaa;

	}
	

}
