package PracticeProgramVTiger;

import org.testng.annotations.Test;

public class ReadDataFromCmdLinetest {
@Test
public void readData()
{
	System.out.println("read data from command line");
String BROWSER = System.getProperty("browser");
String URL = System.getProperty("url");
String UN=System.getProperty("username");
String PWD=System.getProperty("password");
System.out.println(BROWSER);
System.out.println(URL);
System.out.println(UN);
System.out.println(PWD);

}
}
