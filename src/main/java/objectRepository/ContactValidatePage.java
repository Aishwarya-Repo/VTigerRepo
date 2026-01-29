package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactValidatePage {
	//Declaration
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement contactHeaderTXT;

//intialisation
public ContactValidatePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//utilisation
public WebElement  getcontactHeaderTXT()
{
	return contactHeaderTXT;
}
//bussiness liabrary
/**
 * this bussiness library for validation for contact page
 * @return 
 */
public String ContactHeaderValidation()
{
	 return contactHeaderTXT.getText();
}
}
