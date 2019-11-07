package ODIN_VALIDATOR_APITEST;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.omg.Messaging.SyncScopeHelper;

public class TEST {

	public static void main(String[] args) throws Exception {				
		//fomatDay(getDayPlus1());
		String a = DataCalcul.returnDate("today", 10);
		System.out.println(a);
		String b = DataCalcul.fomatDay(DataCalcul.getDay());
		System.out.println(b);
	}

		public static void fomatDay(String  actualDate){
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MMM-yy", Locale.ENGLISH);
			LocalDate ld = LocalDate.parse(actualDate, dtf);
			String month_name = dtf2.format(ld);
			System.out.println(month_name);
		}
		
		public static String getDayPlus1() {	
			String zzz = null;
			Date date = new Date();
			long ltime=date.getTime()+1*24*60*60*1000;
			Date today1=new Date(ltime);			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			zzz = formatter.format(today1).toString();
			return zzz;			
		}
	    

	
}
