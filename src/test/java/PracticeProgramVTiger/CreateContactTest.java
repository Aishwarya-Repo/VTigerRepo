package PracticeProgramVTiger;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.helpers.Reporter;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import objectRepository.ContactPage;
import objectRepository.ContactValidatePage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationPage;
import objectRepository.OrganisationValidationPage;

@Listeners(genericUtility.ListenerImplementationLibrary.class)
public class CreateContactTest extends BaseClass {
	@Test(groups = "SmokeExecution")
	public void CreateContactTest() throws EncryptedDocumentException, IOException {
		ExcelUtility eu = new ExcelUtility();
		String firstName = eu.readDataFromExcelsheet("Contacts", 7, 2) + ju.getRandomNumber();
		String lastName = eu.readDataFromExcelsheet("Contacts", 7, 3) + ju.getRandomNumber();
		String orgname = eu.readDataFromExcelsheet("Organisation", 4, 2) + ju.getRandomNumber();
		String industryNm = eu.readDataFromExcelsheet("Organisation", 4, 3);

		HomePage hp = new HomePage(driver);
		hp.clickOnContactLNK();
		org.testng.Reporter.log("click on contact link");
		ContactPage cp = new ContactPage(driver);
		cp.ClickOnLookIMGContact();
//		Assert.fail("fail the intentially");
		cp.CreatingNewContact(firstName, lastName);
		ContactValidatePage cv = new ContactValidatePage(driver);
		String cHeader = cv.ContactHeaderValidation();
		Assert.assertTrue(cHeader.contains(lastName), "contact created");
		hp.clickOnOrganizationsLNK();
		OrganisationPage op = new OrganisationPage(driver);
		op.clickOnOrganisationLOOKUPIcon();
		op.createOrganisationOrgnameAndIndustry(driver, orgname, industryNm);
		OrganisationValidationPage ov = new OrganisationValidationPage(driver);
		String orgHeader = ov.validationHeaderText();
		Assert.assertTrue(orgHeader.contains(orgname), "organisation created");
	}

//	@Test(groups = "regression")
//	public void practiceTest()
//	{
//		System.out.println("this is practice test............");
//	}
}
