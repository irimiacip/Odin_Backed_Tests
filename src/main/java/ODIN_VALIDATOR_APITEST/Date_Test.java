package ODIN_VALIDATOR_APITEST;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Date_Test {

	public static String cacat() {
		String zzz = null;
		Date date = new Date();
		long ltime=date.getTime()+1*24*60*60*1000;
		Date today1=new Date(ltime);			
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		zzz = formatter.format(today1).toString().toUpperCase();
	System.out.println(zzz);
	return zzz;
	}
	
	public static void main(String[] args) {
	
		cacat();
		

	
	}

}
