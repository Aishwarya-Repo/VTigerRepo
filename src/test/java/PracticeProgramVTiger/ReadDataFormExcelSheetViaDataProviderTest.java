package PracticeProgramVTiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationPage;
import objectRepository.OrganisationValidationPage;

public class ReadDataFormExcelSheetViaDataProviderTest extends BaseClass {

	@Test(dataProvider = "multiOrgAndind")
	public void readMultiDataTest(String OrgName, String IndustryType) throws EncryptedDocumentException, IOException {

		String Orgnm = OrgName + ju.getRandomNumber();

		// home page
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLNK();
		// organisation page
		OrganisationPage op = new OrganisationPage(driver);
		op.clickOnOrganisationLOOKUPIcon();

		op.createOrganisationOrgnameAndIndustry(driver, Orgnm, IndustryType);

		// validation
		OrganisationValidationPage vp = new OrganisationValidationPage(driver);
		String orgHeader = vp.validationHeaderText();

		if (orgHeader.contains(Orgnm)) {
			System.out.println(Orgnm);
			System.out.println("pass validation");
		} else {
			System.out.println("fail validation");
		}
 	}

	@DataProvider(name = "multiOrgAndind")
	public Object[][] getMultiData() throws EncryptedDocumentException, IOException {
		Object[][] data = eu.readMultiData("MultipleOrganisation");

		return data;
	}
}
