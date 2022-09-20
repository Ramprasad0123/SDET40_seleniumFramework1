package org.tyss.ProvidenceSMS_GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * This class consist of all the actions performed on web driver 
 * @author r
 */
public class WebDriverUtility {
	WebDriver driver;
	/*
	 * This method is used to launch respective browser
	 * @param browser
	 * @return
	 */
	
	public WebDriver launchBrowser(String browser)
	{
		switch(browser) {
		case "chrome": WebDriverManager.chromedriver().setup();
		               driver = new ChromeDriver();
		               break;
		               
		case "firefox": WebDriverManager.firefoxdriver().setup();
		                driver = new FirefoxDriver();
		                break;
		                
		case "ie": WebDriverManager.iedriver().setup();
		            driver = new InternetExplorerDriver();
		            break;
		         
		default : System.out.println("Enter valid browser name"); 
		           break;
		}
		return driver;
	}
	
	/*
	 * This method is used to maximize the browser 
	 * @param driver 
	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	/*
	 * This method is used to wait till browser page is loaded completely
	 * @param driver 
	 * @param longTimeout
	 */
	public void waitTillPageLoad(Long longTimeout)      //public void waitTillLoad(WebDriver driver,Long longTimeOuts)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	
	/*
	 * This method is used to navigate to the application using given url
	 * @param driver 
	 * @param url
	 */
	public void navigateToApplication(String url)
	{
		driver.get(url);
	}
	
	/*
	 * This method is used to open the browser and application
	 * @param browser
	 * @param longTime
	 * @param url
	 * return
	 */
	public WebDriver openBrowserAndApplication(String browser,long longTimeout,String url)
	{
		launchBrowser(browser);
		maximizeBrowser();
		waitTillPageLoad(longTimeout);
		navigateToApplication(url);
		return driver;
		
	}
	
	/*
	 * This method is used to get the screenshot and store into local folder
	 * @param driver
	 * @param javaUtility
	 * @param classname
	 * @throws IOexception
	 */
	public void Screenshot(WebDriver driver,JavaUtility javaUtility,String classname) throws IOException 
	{
		String currentTime=javaUtility.currentTime();
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+classname+"_"+currentTime+".png");
		FileUtils.copyFile(src, dst);
	}
	
	
	/*
	 * This method is used to get base64 string format
	 * @param driver
	 * @return
	 * @throws IOexception
	 */
	public String getScreenshot(WebDriver driver)
	{
		TakesScreenshot tss=(TakesScreenshot)driver;
		String tempPath=tss.getScreenshotAs(OutputType.BASE64);
		return tempPath;
	}
	
	/*
	 * This method is used to convert dynamic x-path into web element
	 * @param dynamicPath
	 * @param replaceData
	 * @param driver
	 * @return
	 */
	public WebElement convertDynamicXpathIntoWebElement(String dynamicPath, String replaceData) {
		String requiredPath = String.format(dynamicPath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredPath));
		return element;
	}
	
	
	
	
	/*
	 * This method is used to handle drop-down by Index
	 * @param element
	 * @param value
	 */
	public void dropdownByIndex(WebElement element,int value)
	{
		Select di=new Select(element);
		di.selectByIndex(value);
		
	}
	
	
	/*
	 * This method is used to handle drop-down by Index
	 * @param element
	 * @param value
	 */
	public void dropdownByValue(WebElement element,String value)
	{
		Select di=new Select(element);
		di.selectByValue(value);
	}
	
	/*
	 * This method is used to handle drop-down by Index
	 * @param element
	 * @param value
	 */
	public void dropdownByText(WebElement element,String value)
	{
		Select di=new Select(element);
		di.selectByVisibleText(value);
	}
	
	/*
	 * This method is used to wait till the element is available for clicking action
	 * @param element
	 * @param timeouts
	 */
	
	public void explicitWait(WebElement element,long timeouts) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	/*
	 * This method is used to perform mouse hovering to given element
	 * @param element
	 */
	public void moveToElementAction(WebElement element) {
	  Actions a=new Actions(driver);
	  a.moveToElement(element).perform();
	}
	
	
	public void Scroll(WebDriver driver, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",ele);
	}
	
	

	/*
	 * This method is used to wait till the element visible
	 * @param driver
	 * @param element
	 * @param timeouts
	 */
	
	public void waitTillElementVisible(WebDriver driver, long timeOuts, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOuts));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	public void verifyWebpage(WebElement element,WebDriver driver,Long longTimeout,String expectedText) {
		for(;;) {
			try {
				   Assert.assertEquals(element.getText(), expectedText);
				   break;
			} 
			catch(Exception e) {
				waitTillElementVisible(driver,longTimeout,element);
			}
		}
		
	}
	
//	
//	public void verifyResult(String actualLastName, String expectedContactLAastName) {
//		Assert.assertEquals(actualLastName, expectedContactLAastName);
//		
//	}
//	
	
	public void verifyResult(boolean condition) {
		Assert.assertTrue(condition);
	}
	
	

	
	/*
	 * This method is used to close the browser
	 */
	public void closeDriver()
	{
		driver.quit();
	}
	
}