package org.provienceSMS.EndToEnd.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.tyss.ProvidenceSMS_GenericUtility.DataType;
import org.tyss.ProvidenceSMS_GenericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS_GenericUtility.FileUtility;
import org.tyss.ProvidenceSMS_GenericUtility.IConstantUtility;
import org.tyss.ProvidenceSMS_GenericUtility.JavaUtility;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class CreateExam1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		
		FileUtility propertyFile=new FileUtility();
	    JavaUtility javautility=new JavaUtility();
	    propertyFile.initializePropertyFile(IConstantUtility.PROPERTY_FILE_PATH);
		String url = propertyFile.getDataFromPropertyFile("Url");
		String browser=propertyFile.getDataFromPropertyFile("Browser");
		String timeout = propertyFile.getDataFromPropertyFile("Timeout");
		long timeouts = (long) (javautility.convertStringToAnyData(timeout, DataType.LONG));
		
		WebDriverUtility webdriverutility = new WebDriverUtility();
		driver=webdriverutility.openBrowserAndApplication(browser, timeouts, url);
	    
		ExcelUtility excel=new ExcelUtility();
		excel.initializeExcel(IConstantUtility.EXCEL_PATH);
		String mail = excel.getDataFromExcelFile("Sheet1", 1, 1);
		String pwd = excel.getDataFromExcelFile("Sheet1", 2, 1);
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("btnSubmit")).click();
		
		String msg = driver.findElement(By.xpath("//h5[text()='Abhishek K H,']/descendant::span[text()=' Welcome back! ']")).getText();
		if(msg.equals("Welcome back!"))
		{
			System.out.println("Login is successfull...");
		} else {
			System.out.println("Login is failure");
			
		}
		
     driver.findElement(By.xpath("//span[.='Exam']")).click();
     driver.findElement(By.xpath("//a[.='Create Exam']")).click();
   
     driver.findElement(By.xpath("//a[.='Add ']")).click();
   
     String examname = excel.getDataFromExcelFile("Sheet3", 21, 3);
		
     driver.findElement(By.xpath("//input[@id='name']")).sendKeys(examname);
     driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
     
    
     WebElement d = driver.findElement(By.xpath("//select[@class='form-control input-sm']"));
		Select s=new Select(d);
		s.selectByIndex(3);
		
		int count=0;
		int duration=10;
		while(count<duration)
		{
		try {
		driver.findElement(By.xpath("//tr[@role='row']/parent::thead/following-sibling::tbody//tr[last()]//a[@class='confirm-delete btn btn-danger btn-xs']")).click();
		break;
		}
		catch(Exception E)
		{
			Thread.sleep(1000);
			count++;
		}
		}
		int count1=0;
		int duration1=10;
		while(count1<duration1)
		{
		try {
		driver.findElement(By.xpath("//a[@id='btnYes']")).click();
		break;
		}
		catch(Exception E)
		{
			Thread.sleep(1000);
			count1++;
		}
		}
	//driver.findElement(By.xpath("//a[@id='btnYes']")).click();
	
	
	 driver.findElement(By.xpath("//span[.='Abhishek K H']")).click();
	
//	WebElement a = driver.findElement(By.xpath("//span[.='Abhishek K H']"));
//	a.click();
	//webdriverutility.explicitWait(a, 10);
	
	driver.findElement(By.xpath("//a[.='Sign out']")).click();
	
    excel.closeExcelWorkbook();
    webdriverutility.closeDriver();
	}
}
