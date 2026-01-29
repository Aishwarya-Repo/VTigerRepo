package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;
/**
 * this object repo for home page
 * @author HP
 *
 */
public class HomePage extends WebdriverUtility
{
// Declare the webElement
@FindBy(linkText = "Contacts")
private WebElement ContactLNK;

@FindBy(linkText = "Organizations")
private WebElement OrganizationsLNK;

@FindBy(linkText = "Opportunities")
private WebElement OpportunitiesLNK;

@FindBy(linkText = "Products")
private WebElement ProductsLNK;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement AdministrateIMG;

@FindBy(linkText  = "Sign Out")
private WebElement SignOutLnk;

// Initiatialisation the webElement
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//Utilisation the Element
public WebElement getContactLnk()
{
 return ContactLNK;
}
public WebElement getOrganizationsLNK() 
{
	return OrganizationsLNK;
}
public WebElement getOpportunitiesLNK() 
{
	return OpportunitiesLNK;
}
public WebElement getProductsLNK() 
{
	return ProductsLNK;
}

public WebElement getAdministrateIMG() {
	return AdministrateIMG;
}

public WebElement getSignOutLnk() {
	return SignOutLnk;
}


//Bussines library
/**
 * this method click on ContactLNK
 */
public void clickOnContactLNK()
{
	ContactLNK.click();
}
/**
 * this method click on OrganizationsLNK
 */
public void clickOnOrganizationsLNK()
{
	OrganizationsLNK.click();
}
/**
 * this method click on OpportunitiesLNK
 */
public void clickOnOpportunitiesLNK()
{
	OpportunitiesLNK.click();
}
/**
 * this method click on ProductsLNK
 */
public void clickOnProductsLNK()
{
	ProductsLNK.click();
}

public void signOutApp(WebDriver driver)
{
	handleMouseHover(driver, AdministrateIMG);
	SignOutLnk.click();
}
}







