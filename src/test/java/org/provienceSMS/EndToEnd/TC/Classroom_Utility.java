package org.provienceSMS.EndToEnd.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tyss.ProvidenceSMS_GenericUtility.DataType;
import org.tyss.ProvidenceSMS_GenericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS_GenericUtility.FileUtility;
import org.tyss.ProvidenceSMS_GenericUtility.IConstantUtility;
import org.tyss.ProvidenceSMS_GenericUtility.JavaUtility;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class Classroom_Utility {
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
		
		driver.findElement(By.xpath("//span[.='Classroom']")).click();
		
		String classname = excel.getDataFromExcelFile("Sheet3", 6, 3);
		String stdcount = excel.getDataFromExcelFile("Sheet3", 7, 3);
		
		
		driver.findElement(By.id("name")).sendKeys(classname);
		driver.findElement(By.id("student_count")).sendKeys(stdcount);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		Thread.sleep(4000);
		
	//	List<WebElement> classList = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[last()]/td[last()]/a[2]"));//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr
	//	int size = classList.size();
		
		String clsname = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[last()]/td[2]")).getText();//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr["+(size) + "]/td[2]
		System.out.println(clsname);
		
		String stc = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr[last()]/td[3]")).getText();//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr["+(size) + "]/td[3]
		System.out.println(stc);
		
		if(classname.equalsIgnoreCase(clsname) && stdcount.equalsIgnoreCase(stc))
		{
			System.out.println(" Test Case is pass");
		}else {
				System.out.println("Test case is Fail");
			
		} 
		
		driver.findElement(By.xpath("//a[.='Delete']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@id='btnYes']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Abhishek K H']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();

		webdriverutility.closeDriver();
		
				
	}

}
