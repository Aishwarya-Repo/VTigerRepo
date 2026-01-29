package PracticeProgramVTiger;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class POMusingLoginPage 
{
public static void main(String[] args) throws IOException, InterruptedException {
	
	// read data from generic utility
	WebdriverUtility wu = new WebdriverUtility();
	ExcelUtility eu = new ExcelUtility();
	JavaUtility ju = new JavaUtility();
	PropertyUtility pu = new PropertyUtility();
	
	String bro = pu.readDataFromPropertyFile("browser");
	String ul = pu.readDataFromPropertyFile("url");
	String un = pu.readDataFromPropertyFile("username");
	String pwd = pu.readDataFromPropertyFile("password");
	
	WebDriver driver = null;
   	if(bro.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("launch "+bro+" browser");
	}
    else if (bro.equalsIgnoreCase("edge"))
	{
	 WebDriverManager.edgedriver().setup();
	 driver =  new EdgeDriver();
	 System.out.println("launch edge browser");
	 }
    else
    {
	   System.out.println("invalid browser");
    }

    wu.maximisewindow(driver);
    wu.waitForPageLoad(driver);
    driver.get(ul);
    
    LoginPage lp = new LoginPage(driver);
    lp.loginToApp(un, pwd);
   
}
}









