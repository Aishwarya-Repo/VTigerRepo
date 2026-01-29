package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this ObjectRepo for login page
 * @author HP
 *
 */
public class LoginPage 
{
	// Declaration
@FindBy(name="user_name")
private WebElement usernameEDT;

@FindBy(name="user_password")
private WebElement PasswordEDT;

@FindBy(id="submitButton")
private WebElement loginBTN;

// Intialisation
 public  LoginPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 
 // Utilisation
 public WebElement getUsernameEDT() 
 {
		return usernameEDT;
}
 
 public WebElement getPasswordEDT()
 {
	 return PasswordEDT;
 }
 
 public WebElement getLoginBTN()
 {
	 return loginBTN;
 }
 // bussiness library
 /**
  * this library login to app with the username and password
  * @param username
  * @param password
  */
 public void loginToApp(String username,String password)
 {
	 usernameEDT.sendKeys(username);
	 PasswordEDT.sendKeys(password);
	 loginBTN.click();
 }


}
