package PracticeProgramVTiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactPage;
import objectRepository.ContactValidatePage;
import objectRepository.HomePage;
import objectRepository.OrganisationPage;

public class DDTwithContactPage extends BaseClass {

	@Test
	public void DDTwithContactPageTest() throws IOException {
		String firstName = eu.readDataFromExcelsheet("Contacts", 7, 2) + ju.getRandomNumber();
		String lastName = eu.readDataFromExcelsheet("Contacts", 7, 3) + ju.getRandomNumber();
		String orgname = eu.readDataFromExcelsheet("Organisation", 4, 2) + ju.getRandomNumber();
		String industryNm = eu.readDataFromExcelsheet("Organisation", 4, 3);

		HomePage hp = new HomePage(driver);
		hp.clickOnContactLNK();
		ContactPage cp = new ContactPage(driver);
		cp.ClickOnLookIMGContact();
		cp.CreatingNewContact(firstName, lastName);
		ContactValidatePage cv = new ContactValidatePage(driver);
		String cHeader = cv.ContactHeaderValidation();
		Assert.assertTrue(cHeader.contains(lastName), "contact created");
		hp.clickOnOrganizationsLNK();
		OrganisationPage op = new OrganisationPage(driver);
		op.clickOnOrganisationLOOKUPIcon();
		op.createOrganisationOrgnameAndIndustry(driver, orgname, industryNm);
	}

}
