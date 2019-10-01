package ODIN_VALIDATOR_APITEST;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

import org.omg.Messaging.SyncScopeHelper;

import static ODIN_VALIDATOR_APITEST.Consts.*;


public class Test {

	public static void xxx() {
		
		Calendar time = Calendar.getInstance();//time.getTime()
		Date today = time.getTime();
		time.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = time.getTime();

		String TIMESTAMP_FORMAT = "dd.MM.yyyy HH:mm:ss.SSSSSS";


		String[] DATE_FORMAT = new String[] {"dd.MM.yyyy", "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss'Z'" , 
		            "MM.dd.yyyy", "MM.d.yyyy", "dd.M.yyyy", "M.d.yyyy", "d.M.yyyy", "d.MM.yyyy", "M.dd.yyyy"};

		 

		String value = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + 
				"<IhdsTree xmlns=\"http://cpim.metrosystems.net/ihds-tree/1.0/\" scope=\"test\" version=\"1\">\n" + 
				"<Transaction id=\"1489137860226\" time=\"2017-03-10 11:24:20.226\">\n" + 
				"<Incident id=\"1\">\n" + 
				"<Domain>\n" + 
				"                <column1 attribute1='ceva'>2</column1>\n" + 
				"                <column2>Text</column2>\n" + 
				"</Domain>\n" + 
				" \n" + 
				"<content>\n" + 
				"                <request>\n" + 
				"                                <column3>xxxx</column3>\n" + 
				"                                <column4>10000</column4>\n" + 
				"                </request>\n" + 
				"</content>\n" + 
				" \n" + 
				"</Incident>\n" + 
				"</Transaction>\n" + 
				"</IhdsTree>";
		
		        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT[2]);
		        SimpleDateFormat timestampFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
		        value = value.replaceAll("xxxx", dateFormat.format(today));
		      //  value = value.replaceAll("\\{DATE:TOMORROW\\}", dateFormat.format(tomorrow));
		      //  value = value.replaceAll("\\{DATE:SYSTIMESTAMP\\}", timestampFormat.format(today));
		      //  value = value.replaceAll("\\{DATE:ENDLESS\\}", "01.01.2949");
		System.out.println(value);
		
	}

	public static void a() throws Exception {
		
		Calendar time = Calendar.getInstance();//time.getTime()
		Date today = time.getTime();
		System.out.println("SA VEDEM DE TEST :   "+today.getTime());
		time.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		Date yesterday = new Date(today.getTime() - (1000 * 60 * 60 * 24));
		time.add(Calendar.DATE, 1);  

		String TIMESTAMP_FORMAT = "dd.MM.yyyy HH:mm:ss.SSSSSS";


		String[] DATE_FORMAT = new String[] {"dd.MM.yyyy", "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss'Z'" , 
		            "MM.dd.yyyy", "MM.d.yyyy", "dd.M.yyyy", "M.d.yyyy", "d.M.yyyy", "d.MM.yyyy", "M.dd.yyyy"};
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT[0]);
        SimpleDateFormat timestampFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
        
        
		String aaa = ReadBody.getBodyFromFilepath(FILEPATH_VALIDATOR, "test.xml");
		System.out.println("before " + aaa);
		aaa = aaa.replace("DATE", dateFormat.format(today));
		System.out.println("after " + aaa);
	}
	
	 public static SimpleDateFormat  data() {
		 
			Calendar time = Calendar.getInstance();//time.getTime()
			Date today = time.getTime();
			time.add(Calendar.DAY_OF_YEAR, 1);

			String TIMESTAMP_FORMAT = "dd.MM.yyyy HH:mm:ss.SSSSSS";
			String[] DATE_FORMAT = new String[] {"dd.MM.yyyy", "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss'Z'" , 
			            "MM.dd.yyyy", "MM.d.yyyy", "dd.M.yyyy", "M.d.yyyy", "d.M.yyyy", "d.MM.yyyy", "M.dd.yyyy"};
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT[2]);
		 
		return dateFormat;
		 
	 }
	
	public static void main(String[] args) throws Exception {
		//xxx();
		a();
		
	//	System.out.println(DataCalcul.returnDate("yesterday"));
		//SimpleDateFormat dateFormat;
		//dateFormat.format(today);
	
		//System.out.println(test1().getNume());
	//System.out.println(test1().getPrenume());
	//System.out.println(test2().getTimestampFormat());
	//System.out.println(test2());
	}
	
		
	
}
