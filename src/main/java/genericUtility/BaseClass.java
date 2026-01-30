package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	public ExcelUtility eu = new ExcelUtility();
	public PropertyUtility pu = new PropertyUtility();
	public JavaUtility ju = new JavaUtility();
	public WebdriverUtility wu = new WebdriverUtility();
	public	WebDriver driver = null;
	public static WebDriver Sdriver  = null;
	@BeforeSuite(groups =  {"SmokeExecution","regression"})
	public void bsConfig() {
		System.out.println("database connect sucessfully");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups =  {"SmokeExecution","regression"})
	public void bcConfig(/*String browser*/) throws IOException {
		String browser = pu.readDataFromPropertyFile("browser");
		String url = pu.readDataFromPropertyFile("url");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("browser lauched  succesfully------>" + browser);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			System.out.println("browser lauched  succesfully------>" + browser);
		}
		Sdriver = driver;
		wu.maximisewindow(driver);
		wu.waitForPageLoad(driver);
		driver.get(url);
	}

	@BeforeMethod(groups =  {"SmokeExecution","regression"})
	public void bmConfig() throws IOException {
		String username = pu.readDataFromPropertyFile("username");
		String password = pu.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		System.out.println("login to application successfully----------");
	}

	@AfterMethod(groups =  {"SmokeExecution","regression"})
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.signOutApp(driver);
		System.out.println("logout the application successfully----------");
	}
	@AfterClass(groups =  {"SmokeExecution","regression"})
	public void acConfig() {
		driver.quit();
		System.out.println("close browser successfully------------");
	}

	@AfterSuite(groups =  {"SmokeExecution","regression"})
	public void asConfig() {
		System.out.println("database close sucessfully");
	}
}
