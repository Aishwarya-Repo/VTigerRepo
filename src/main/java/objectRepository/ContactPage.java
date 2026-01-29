package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;

public class ContactPage extends WebdriverUtility
{
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement lookupIMG;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement FirstnameTXT;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastnameTXT;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement SelectOrgLookupIMG;
	
	@FindBy(id = "search_txt"	)
	private WebElement searchTXT;
	
	@FindBy(name = "search"	)
	private WebElement searchBTN;;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement contactOrgnameLNK;
	
	@FindBy(xpath = "//input[@title='Clear']")
	private WebElement clearLookupIMG;
	
	@FindBy(xpath = "//select[@name='leadsource']")
	private WebElement leadSaurceDROPLIST;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministrateIMG;
	
	@FindBy(linkText  = "Sign Out")
	private WebElement SignOutLnk;
	
	//Intialisation
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilisation

	public WebElement getLookupIMG() {
		return lookupIMG;
	}

	public WebElement getFirstnameTXT() {
		return FirstnameTXT;
	}

	public WebElement getLastnameTXT() {
		return LastnameTXT;
	}

	public WebElement getSelectOrgLookupIMG() {
		return SelectOrgLookupIMG;
	}

	public WebElement getSearchTXT() {
		return searchTXT;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}

	public WebElement getClearLookupIMG() {
		return clearLookupIMG;
	}

	public WebElement getLeadSaurceDROPLIST() {
		return leadSaurceDROPLIST;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}

	public WebElement getAdministrateIMG() {
		return AdministrateIMG;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}

	public WebElement getContactOrgnameLNK() {
		return contactOrgnameLNK;
	}

	// Bussiness Library
	/**
	 * this liabrary for clickon contact image
	 * @param firstname
	 * @param lastname
	 */
	public void ClickOnLookIMGContact()
	{
		lookupIMG.click();
	}
	
	/**
	 * this liabrary for create contact for fistname and lastname
	 * @param firstname
	 * @param lastname
	 */
	public void CreatingNewContact(String firstname,String lastname)
	{
		FirstnameTXT.sendKeys(firstname);
		LastnameTXT.sendKeys(lastname);
		saveBTN.click();
	}
	/**
	 * this library for create contact with fistname , lastname,leadsaurce
	 * @param firstname
	 * @param lastname
	 * @param leadSaurcevalue
	 */
	public void CreatingNewContact(String firstname,String lastname,String leadSaurcevalue)
	{
		FirstnameTXT.sendKeys(firstname);
		LastnameTXT.sendKeys(lastname);
		handleDropDown(leadSaurceDROPLIST, leadSaurcevalue);
		saveBTN.click();
	}
	/**
	 * this library for create contact with fistname , lastname, leadsaurce, orgname
	 * @param firstname
	 * @param lastname
	 * @param leadSaurcevalue
	 * @throws InterruptedException 
	 */
	public void  CreatingNewContact(WebDriver driver ,String firstname,String lastname, String leadSaurcevalue,String partialTextWithChild, String partialTextWithParent, String orgNamevalue) throws InterruptedException
	{
		// firstname,lastname,leadsource
		FirstnameTXT.sendKeys(firstname);
		LastnameTXT.sendKeys(lastname);
		handleDropDown(leadSaurceDROPLIST, leadSaurcevalue);
		//click on look image and switch to child windo
		SelectOrgLookupIMG.click();
		switchToWindow(driver, partialTextWithChild);
		// element to visible
		elementTobeVisible(driver, searchTXT);
		// search organisation
		searchTXT.sendKeys(orgNamevalue);
		searchBTN.click();
		contactOrgnameLNK.click();
		// switch to child to parent
		switchToWindow(driver, partialTextWithParent);
		//save 
		saveBTN.click();
	}
	public void CreatingNewContactWithSignout(WebDriver driver)
	{
	handleMouseHover(driver, AdministrateIMG);
	SignOutLnk.click();
	}
	
}








