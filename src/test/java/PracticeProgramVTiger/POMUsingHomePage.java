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
import objectRepository.ContactPage;
import objectRepository.ContactValidatePage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class POMUsingHomePage {
	public static void main(String[] args) throws IOException, InterruptedException {

		// create generic utility
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		PropertyUtility pu = new PropertyUtility();
		WebdriverUtility wu = new WebdriverUtility();

		String BRO = pu.readDataFromPropertyFile("browser");
		String url = pu.readDataFromPropertyFile("url");
		String UN = pu.readDataFromPropertyFile("username");
		String PWD = pu.readDataFromPropertyFile("password");
		
		String First_Name = eu.readDataFromExcelsheet("Contacts", 10, 2);
		String Last_Name = eu.readDataFromExcelsheet("Contacts", 10, 3);
		String Org_Name = eu.readDataFromExcelsheet("Contacts", 10, 4);
		String Lead_Saurce = eu.readDataFromExcelsheet("Contacts", 10, 5);
		WebDriver driver = null;
		// launch browser
		if (BRO.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launch " + BRO + " browser");
		} else if (BRO.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("launch " + BRO + " browser");
		} else {
			System.out.println("invalid browser");
		}

		wu.maximisewindow(driver);
		wu.waitForPageLoad(driver);
		driver.get(url);
	
		//login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(UN, PWD);
		//click on contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLNK();
		//contact page
		ContactPage cp = new ContactPage(driver);
		cp.ClickOnLookIMGContact();
		cp.CreatingNewContact(driver, First_Name, Last_Name, Lead_Saurce,"Accounts"	,"Contacts",Org_Name);
		
		//validation
		ContactValidatePage cvp = new ContactValidatePage(driver);
	     String header = cvp.ContactHeaderValidation();
	     System.out.println(header);
	     if (header.contains(Last_Name)) 
        {
			System.out.println("pass the validation with "+Last_Name);
		}
	     else
	     {
	    	 System.out.println("fail validation");
	     }
		//sign out
		hp.signOutApp(driver);
	}
}



