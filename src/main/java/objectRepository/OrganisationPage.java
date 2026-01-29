package objectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;

public class OrganisationPage extends WebdriverUtility
{
	//Declaration
@FindBy(xpath = "//img[@title='Create Organization...']")
private WebElement OrgLookUpIMG;

@FindBy(name="accountname")
private WebElement OrgNameTXT;

@FindBy(name="industry")
private WebElement IndustryDropLST;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement SaveBTN;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement AdministratorIMG;

@FindBy(linkText = "Sign Out")
private WebElement SignoutLNK;

//Initialisation
public OrganisationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//Utilisation

public WebElement getOrgLookUpIMG()
{
  return OrgLookUpIMG;
}

public WebElement getOrgNameTXT() {
	return OrgNameTXT;
}

public WebElement getIndustryDropLST() {
	return IndustryDropLST;
}

public WebElement getSaveBTN() {
	return SaveBTN;
}

public WebElement getAdministratorIMG() {
	return AdministratorIMG;
}

public WebElement getSignoutLNK() {
	return SignoutLNK;
}

// bussiness library
/**
 * this method click on organisation look up icon
 */
public void clickOnOrganisationLOOKUPIcon()
{
	OrgLookUpIMG.click();
}
/**
 * this method fo create orgnistion for multiple organisation and industry names
 * @param driver
 * @param Orgname
 * @param Industry
 */
public void createOrganisationOrgnameAndIndustry(WebDriver driver, String Orgname,String Industry)
{
	OrgNameTXT.sendKeys(Orgname);
	IndustryDropLST.click();
	handleDropDown(IndustryDropLST, Industry);
	handleMouseHover(driver, AdministratorIMG);
	SaveBTN.click();
	
}
}





