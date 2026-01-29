package PracticeProgramVTiger;

import genericUtility.JavaUtility;

public class PracticeJavaLibrary {

	public static void main(String[] args) 
	{
	JavaUtility j = new JavaUtility();
	String date = j.getSystemDate();
	System.out.println(date);

	String dateInFormat = j.getSystemDateInFormat();
	System.out.println(dateInFormat);
	}

}
