package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationValidationPage 
{
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement HeaderTXT;

public OrganisationValidationPage(WebDriver driver	)
{
	PageFactory.initElements(driver, this);
}

public WebElement getHeaderTXT() {
	return HeaderTXT;
}

// bussiness library
/**
 * this method for validation for organisation page
 * @return
 */

public String validationHeaderText()
{
	 return  HeaderTXT.getText();
}
}
