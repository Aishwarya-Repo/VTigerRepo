package genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class contain related to webdriver methods
 * @author HP
 *
 */
public class WebdriverUtility 
{ 
	/**
	 * this method will maximise the window
	 * @param driver
	 */
	public void maximisewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will wait for 10seconds to load the page
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method will wait for element to visible
	 * @param driver
	 */
	public void elementTobeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	/**
	 * this method will explicitly wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void elementTobeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/** 
	 * this method will custom/fluentWait wait and click the element
	 * @param driver
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<10)
		{
			try
			{
				element.click();
			}
			catch(Exception e )
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * this method will perform right click on web page
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method will perform right click on particular web element
	 * @param driver
	 * @param element
	 */
	public void rightclickOnElement(WebDriver driver, WebElement element)
	{
		Actions act =  new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * this method will double click on webpage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver )
	{
		Actions act  =new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will dounle click on particular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	/**
	 * thid method will drag and drop on webelement source to destination
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver, WebElement src,WebElement dest)
	{
		Actions act = new  Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	/**
	 * this method will drag and drop for specific src location to target location
	 * @param driver
	 * @param x
	 * @param y
	 * @param src
	 */
	public void dragAndDrop(WebDriver driver,int x,int y,WebElement src)
	{
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, x, y).perform();
	}
	/**
	 * this method will handle drop down for visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
				
	}
	/**
	 * this method will handle drop down for value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element , String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method will handle by drop down for index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element , int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * this method will handle mouse hover on set off value using x and y co-ordinator
	 * @param driver
	 * @param xoff
	 * @param yoff
	 */
	public void handleMouseHover(WebDriver driver,int xoff,int yoff)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xoff, yoff).perform();
	}
	/**
	 * this method will handle mouse hover on web element
	 * @param driver
	 * @param element
	 */
	public void handleMouseHover(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/** 
	 * this method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method will switch to frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this method will switch to frame based on element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this method will switch to current frame to immdiate parent 
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * this method will switch to current frame to default frame
	 * @param driver
	 */
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	
	}
	
	/**
	 * this method will click accept in alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will click on cancel in alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will get text of alert pop up from caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	
	/**
	 * this method will press enter the key
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * this method will switch to parent window to any child window or any child window to parent window based 
	 * on partial window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		//get all window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		//capture all window ids
		Iterator<String> it = windowIds.iterator();
		
		//navigate each window id 
		while(it.hasNext())
		{
			//capture individual id 
			String WinId = it.next();
			
			//switch to that window and capture current title
			String currentTitle = driver.switchTo().window(WinId).getTitle();
			
			//compare current title with partial title
			if(currentTitle.contains(partialWindowTitle))
			{
				break;
			}
			
		}
	}
		/** 
		 * this method will take screenshot
		 * @param driver
		 * @param ScreenShotName
		 * @return
		 * @throws IOException
		 */
	public String takeScreenShot(WebDriver driver,String ScreenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\JotDownScreeShots"+ScreenShotName+".png");
		FileUtils.copyFile(src, dest); //from commons io
		
		return dest.getAbsolutePath();  //use for extends reports
		
	}
	/**
	 * this method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
	}
	
	/**
	 * this method will scroll untill specified found element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments(0).scrollIntoView();", element);
		
		//or
		int y = element.getLocation().getY(); // as per vertical requier scrolling
		js.executeScript("window.scrollBy(0,"+y+")", element);
		
		
	}
}













