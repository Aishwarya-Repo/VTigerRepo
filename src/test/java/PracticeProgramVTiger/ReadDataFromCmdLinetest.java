package PracticeProgramVTiger;

import org.testng.annotations.Test;

public class ReadDataFromCmdLinetest {
@Test
public void readData()
{
	System.out.println("read data from command line");
String BROWSER = System.getProperty("browser");
String URL = System.getProperty("url");
System.out.println(BROWSER);
System.out.println(URL);
}
}
