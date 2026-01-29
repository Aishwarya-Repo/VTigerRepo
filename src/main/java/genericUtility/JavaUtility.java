package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class is utilise all common method for java related
 * 
 * @author HP
 *
 */
public class JavaUtility {
	/**
	 * this is generate random number for every execution
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int randomval = ran.nextInt(500);
		return randomval;
	}

	/**
	 * this is genrate system date
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		String date = d.toString();
		return date;
	}

	/**
	 * this generic method generate system date in format
	 * 
	 * @return
	 */
//public String getSystemDateInFormat()
//{ 
//	 Date d = new Date();
//	 String[] dArr = d.toString().split(" ");
//	 String month = dArr[1];
//	 String date = dArr[2];
//	String time = dArr[3].replace(":"	, "-"); 
//	String year = dArr[5];
//	String dateInFormat=date+ "-" +month+"-" +year+"-"+time;
//	return dateInFormat;
//}

	public String getSystemDateInFormat() {
		Date d = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss");
		return sd.format(d);
	}

}
