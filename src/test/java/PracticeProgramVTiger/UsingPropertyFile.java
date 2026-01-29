package PracticeProgramVTiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingPropertyFile {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonFile.properties");
        Properties ps = new Properties();
        ps.load(fis);
        String BROWSER = ps.getProperty("browser");
        System.out.println(BROWSER);
        String URL = ps.getProperty("url");
        System.out.println(URL);
        String USN = ps.getProperty("username");
        System.out.println(USN);
        String PSW = ps.getProperty("password");
        System.out.println(PSW);
	}

}
