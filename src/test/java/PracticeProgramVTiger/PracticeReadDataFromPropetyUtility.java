package PracticeProgramVTiger;

import java.io.IOException;

import genericUtility.PropertyUtility;

public class PracticeReadDataFromPropetyUtility {

	public static void main(String[] args) throws IOException 
	{
PropertyUtility pu = new PropertyUtility();
String Browser = pu.readDataFromPropertyFile("browser");
System.out.println(Browser);
String URL = pu.readDataFromPropertyFile("url");
System.out.println(URL);
String USD = pu.readDataFromPropertyFile("	username");
System.out.println(USD);
String PWD = pu.readDataFromPropertyFile("password");
System.out.println(PWD);
	}

}
