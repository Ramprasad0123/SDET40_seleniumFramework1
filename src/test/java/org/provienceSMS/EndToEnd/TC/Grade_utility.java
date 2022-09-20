package org.provienceSMS.EndToEnd.TC;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tyss.ProvidenceSMS_GenericUtility.DataType;
import org.tyss.ProvidenceSMS_GenericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS_GenericUtility.FileUtility;
import org.tyss.ProvidenceSMS_GenericUtility.IConstantUtility;
import org.tyss.ProvidenceSMS_GenericUtility.JavaUtility;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class Grade_utility {
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriver driver=null;
		
		WebDriverUtility webdriverutility=new WebDriverUtility();
		FileUtility propertyFile=new FileUtility();
	    JavaUtility javautility=new JavaUtility();
		
		propertyFile.initializePropertyFile(IConstantUtility.PROPERTY_FILE_PATH);
		String url = propertyFile.getDataFromPropertyFile("Url");
		String browser=propertyFile.getDataFromPropertyFile("Browser");
		String timeout = propertyFile.getDataFromPropertyFile("Timeout");
		long timeouts = (long) (javautility.convertStringToAnyData(timeout, DataType.LONG));
		
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
		
		driver.findElement(By.xpath("//span[text()='Grade']")).click();
		
		String name = excel.getDataFromExcelFile("Sheet3", 1, 3);
		String admfees = excel.getDataFromExcelFile("Sheet3", 2, 3);
		String hc = excel.getDataFromExcelFile("Sheet3", 3, 3);
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("admission_fee")).sendKeys(admfees);
		driver.findElement(By.id("hall_charge")).sendKeys(hc);
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(4000);
		
		String range = excel.getDataFromExcelFile("Sheet3", 4, 3);
		String grade = excel.getDataFromExcelFile("Sheet3", 5, 3);
		
		driver.findElement(By.id("mark_range_text_1")).sendKeys(range);
		driver.findElement(By.id("mark_grade_text_1")).sendKeys(grade);
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit1")).click();
		Thread.sleep(4000);
		
		//List<WebElement> gradeList = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr"));
		//int size = gradeList.size();
		
		
		String gr = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr[last()]/td[2]")).getText();//table[@id='example1']/tbody/tr["+(size) + "]/td[2]
		System.out.println(gr);
		
		String af = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr[last()]/td[3]")).getText();//table[@id='example1']/tbody/tr["+ (size) + "]/td[3]
		System.out.println(af);
		
		String hall = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr[last()]/td[4]")).getText();//table[@id='example1']/tbody/tr["+ (size) + "]/td[4]
		System.out.println(hall);
		
		if(gr.equalsIgnoreCase(name) && af.equalsIgnoreCase(admfees) && hall.equalsIgnoreCase(hc) )
		{
			System.out.println(" Test Case is pass");
		}else {
				System.out.println("Test case is Fail");
			
		} 
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("btnYes")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Abhishek K H']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();

		webdriverutility.closeDriver();
	}
}
