package org.provienceSMS.EndToEnd.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.ProvidenceSMS_GenericUtility.DataType;
import org.tyss.ProvidenceSMS_GenericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS_GenericUtility.FileUtility;
import org.tyss.ProvidenceSMS_GenericUtility.IConstantUtility;
import org.tyss.ProvidenceSMS_GenericUtility.JavaUtility;
import org.tyss.ProvidenceSMS_GenericUtility.Screenshot;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class EventCreation_Utility { 
	
	public static void main(String[] args) {
		WebDriver driver=null;
		WebDriverUtility webdriverUtility=new WebDriverUtility();
		FileUtility propertyFile=new FileUtility();
		JavaUtility javaUtility=new JavaUtility();
		ExcelUtility excel=new ExcelUtility();
		Screenshot photo=new Screenshot();
		
		
		propertyFile.initializePropertyFile(IConstantUtility.PROPERTY_FILE_PATH);
		String url = propertyFile.getDataFromPropertyFile("Url");
		String browser=propertyFile.getDataFromPropertyFile("Browser");
		String timeout = propertyFile.getDataFromPropertyFile("Timeout");
		long timeouts = (long) (javaUtility.convertStringToAnyData(timeout, DataType.LONG));
		
		driver=webdriverUtility.openBrowserAndApplication(browser, timeouts, url);
		
		excel.initializeExcel(IConstantUtility.EXCEL_PATH);
		
		String mail = excel.getDataFromExcelFile("Sheet1", 1, 1);
		String pwd = excel.getDataFromExcelFile("Sheet1", 2, 1);
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("btnSubmit")).click();
		//webdriverUtility.Scroll(driver);
	    driver.findElement(By.xpath("//span[text()='Event']")).click();
	    
	    driver.findElement(By.xpath("//a[text()=' My Events']")).click();
	  
	    try {
	   driver.findElement(By.xpath("//a[@class='Btn btn-sm  bg-orange-active pull-right ']")).click();
	   String eventName = excel.getDataFromExcelFile("Sheet3", 11, 3);
	   String categories = excel.getDataFromExcelFile("Sheet3", 12, 3);//specify
	   
	   driver.findElement(By.id("title")).sendKeys(eventName);
	   WebElement category=driver.findElement(By.id("category"));
	   webdriverUtility.dropdownByText(category, categories);
	   
	   driver.findElement(By.id("reservationtime")).click();
	    }
	    catch(ElementNotInteractableException e)
	    {
	    	excel.writeToExcel("Sheet3", 11, 4, "Fail");//create method in excel
	    	photo.getScreenshot(driver);
	    	System.out.println("Test Case is fail");
	    }
	    
	    driver.findElement(By.xpath("//span[.='Paavani S']")).click();
	    driver.findElement(By.xpath("//a[.='Sign out']")).click();
	    
	    excel.closeExcelWorkbook();
	    
	    webdriverUtility.closeDriver();
	}

}
