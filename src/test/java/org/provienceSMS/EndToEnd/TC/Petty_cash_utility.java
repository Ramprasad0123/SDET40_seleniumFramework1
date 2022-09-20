package org.provienceSMS.EndToEnd.TC;

import java.util.List;

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

public class Petty_cash_utility {
	
	public static void main(String[] args) {
		
		WebDriver driver=null;
		WebDriverUtility webdriverutility = new WebDriverUtility();
		FileUtility propertyFile=new FileUtility();
		JavaUtility javautility=new JavaUtility();
		ExcelUtility excel=new ExcelUtility();
		
		propertyFile.initializePropertyFile(IConstantUtility.PROPERTY_FILE_PATH);
		String url = propertyFile.getDataFromPropertyFile("Url");
		String browser=propertyFile.getDataFromPropertyFile("Browser");
		String timeout = propertyFile.getDataFromPropertyFile("Timeout");
		long timeouts = (long) (javautility.convertStringToAnyData(timeout, DataType.LONG));
		
		driver=webdriverutility.openBrowserAndApplication(browser, timeouts, url);
		
		excel.initializeExcel(IConstantUtility.EXCEL_PATH);
		String teacherMail = excel.getDataFromExcelFile("Sheet1", 3, 1);
		String teacherPwd = excel.getDataFromExcelFile("Sheet1", 4, 1);
		driver.findElement(By.id("email")).sendKeys(teacherMail);
		driver.findElement(By.id("password")).sendKeys(teacherPwd);
		driver.findElement(By.id("btnSubmit")).click();
		
		driver.findElement(By.xpath("//span[text()='My Petty Cash']")).click();
		
		driver.findElement(By.xpath("//a[text()='Add ']")).click();
       String pettyCashDescription = excel.getDataFromExcelFile("Sheet3", 8, 3);
       String amount = excel.getDataFromExcelFile("Sheet3", 9, 3);
       
        driver.findElement(By.xpath("//input[@id='textDesc_1']")).sendKeys(pettyCashDescription);
		driver.findElement(By.xpath("//input[@class='amount form-control']")).sendKeys(amount);
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		javautility.robotClass();
		
		driver.findElement(By.xpath("//span[@class='hidden-xs']")).click();		
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		
		String adminMail = excel.getDataFromExcelFile("Sheet1", 1, 1);
		String adminPwd = excel.getDataFromExcelFile("Sheet1", 2, 1);
		driver.findElement(By.id("email")).sendKeys(adminMail);
		driver.findElement(By.id("password")).sendKeys(adminPwd);
		driver.findElement(By.id("btnSubmit")).click();
		
		driver.findElement(By.xpath("//span[.='Petty Cash']")).click();
		
		WebElement d = driver.findElement(By.xpath("//select[@class='form-control input-sm']"));
		Select s=new Select(d);
		s.selectByIndex(3);
		
		String teacherName = excel.getDataFromExcelFile("Sheet3", 8, 5);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(teacherName);
		
		List<WebElement> pettycashlist = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr"));   //tbody[@class='tBody1']/tr
		int size = pettycashlist.size();
		System.out.println(size);
		
		for(int i=0;i<size;i++) {
			String receivedByName = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			String paidStatus = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(i+1)+"]/td[6]")).getText();
		     if(receivedByName.equals(teacherName) && paidStatus.equals("Pending")) {
		    	 driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(i+1)+"]/td[7]/a[.='Approve']")).click();
		    	 
		    	 excel.writeToExcel("Sheet3", 8, 4, "Pass");
		    	 System.out.println("Test case is pass");
		    	 driver.findElement(By.xpath("//a[@id='btnYesApprove']")).click();
		    	 
		    	 break;
		     } else if(i==size-1) {
		    	 excel.writeToExcel("Sheet3", 8, 4, "Fail");
		    	 System.out.println("Test case is Fail");
		     }
			
			}
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		
//		WebElement ele = driver.findElement(By.xpath("//span[text()='Abhishek K H']"));
//		jse.executeScript("arguments[0].scrollIntoView()",ele);
//		
//		ele.click();
		driver.findElement(By.xpath("//span[text()='Abhishek K H']"));
		
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		
        excel.closeExcelWorkbook();
        webdriverutility.closeDriver();
		
	}
	
}
