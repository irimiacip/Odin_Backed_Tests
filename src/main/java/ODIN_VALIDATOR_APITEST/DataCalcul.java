package ODIN_VALIDATOR_APITEST;
import static ODIN_VALIDATOR_APITEST.Consts.FILEPATH_VALIDATOR;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
			            "MM.dd.yyyy", "MM.d.yyyy", "dd.M.yyyy", "M.d.yyyy", "d.M.yyyy", "d.MM.yyyy", "M.dd.yyyy" ,"dd-MM-YY"};
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT[i]);
	        SimpleDateFormat timestampFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
	        aaa= dateFormat.format(yesterday);
		}

        return aaa;

	}
	
	public static String fomatDay(String  actualDate){
		String formated_date=null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MMM-yy", Locale.ENGLISH);
		LocalDate ld = LocalDate.parse(actualDate, dtf);
		String date = dtf2.format(ld);
		formated_date = date.toUpperCase();
		return formated_date;
	}
	
	public static String getDayPlus1() {	
		String zzz = null;
		Date date = new Date();
		long ltime=date.getTime()+1*24*60*60*1000;
		Date today1=new Date(ltime);			
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		zzz = formatter.format(today1).toString().toUpperCase();
		return zzz;			
	}

	

}
