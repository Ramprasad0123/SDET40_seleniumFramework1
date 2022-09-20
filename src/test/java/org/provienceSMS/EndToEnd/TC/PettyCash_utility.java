package org.provienceSMS.EndToEnd.TC;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PettyCash_utility {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		driver.manage().window().maximize();
		FileInputStream fxl=new FileInputStream("./src/test/resources/ComTestdata1.xlsx");
		Workbook book = WorkbookFactory.create(fxl);
		
		String recievedName = book.getSheet("Sheet1").getRow(14).getCell(1).getStringCellValue();
		String paidStatus = book.getSheet("Sheet1").getRow(15).getCell(1).getStringCellValue();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("t3@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='My Petty Cash']")).click();
		
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-sm pull-right']")).click();
		
		driver.findElement(By.xpath("//input[@id='textDesc_1']")).sendKeys("Text");
		driver.findElement(By.xpath("//input[@class='amount form-control']")).sendKeys("250");
		
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='hidden-xs']")).click();		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Sign out']")).click();	
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abhi@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		driver.findElement(By.xpath("//span[.='Petty Cash']")).click();
		
		
		WebElement d = driver.findElement(By.xpath("//select[@class='form-control input-sm']"));
		Select s=new Select(d);
		s.selectByIndex(3);
		
		
		List<WebElement> pettycashlist = driver.findElements(By.xpath("//tbody[@class='tBody1']/tr"));
		int size = pettycashlist.size();
		System.out.println(size);
		
		 String recvname = driver.findElement(By.xpath("//tbody[@class='tBody1']/tr["+(size)+"]/td[2]")).getText();
		 System.out.println(recvname);
		 
		 String payment= driver.findElement(By.xpath("//tbody[@class='tBody1']/tr["+(size)+"]/td[6]")).getText();
		 System.out.println(payment);
		 
		 if(recievedName.equalsIgnoreCase(recvname) && paidStatus.equalsIgnoreCase(payment) )
			{
				System.out.println(" Test Case is pass");
			}else {
					System.out.println("Test case is Fail");
				
			} 
		 
		 driver.findElement(By.xpath("//tbody[@class='tBody1']/tr["+(size)+"]/td[7]/a[2]")).click();
		 
		 driver.findElement(By.xpath("//div[@class='modal-footer']/following::button[@id='frm_cancel']")).click();
		 
		 
		 Thread.sleep(4000);
			driver.findElement(By.xpath("//span[text()='Abhishek K H']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Sign out']")).click();

			
			driver.close();
		
	}
}
//div[@class='modal-footer']/following::button[@id='frm_cancel']---->no

//table[@id='example1']/tbody/tr[31]/td[7]/a[2]----->approve
//table[@id='example1']/tbody/tr[31]/td[6]---->price