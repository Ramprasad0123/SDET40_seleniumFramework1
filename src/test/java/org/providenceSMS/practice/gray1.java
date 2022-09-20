package org.providenceSMS.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gray1 {
		
		public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fxl=new FileInputStream("./src/test/resources/ComTestdata1.xlsx");
		Workbook book = WorkbookFactory.create(fxl);
		
		String url = book.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		String mail = book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String pwd = book.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("password")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubmit")).click();
		
		
		String msg = driver.findElement(By.xpath("//h5[text()='Abhishek K H,']/descendant::span[text()=' Welcome back! ']")).getText();
		if(msg.equals("Welcome back!"))
		{
			System.out.println("Login is successfull...");
		} else {
			System.out.println("Login is failure");
		}
		
		driver.findElement(By.xpath("//span[text()='Grade']")).click();
		
		String name = book.getSheet("Sheet1").getRow(4).getCell(1).getStringCellValue();
		String admfees = book.getSheet("Sheet1").getRow(5).getCell(1).getStringCellValue();
		String hc = book.getSheet("Sheet1").getRow(6).getCell(1).getStringCellValue();
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("admission_fee")).sendKeys(admfees);
		driver.findElement(By.id("hall_charge")).sendKeys(hc);
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(4000);
		
		String range = book.getSheet("Sheet1").getRow(8).getCell(1).getStringCellValue();
		String grade = book.getSheet("Sheet1").getRow(9).getCell(1).getStringCellValue();
		
		driver.findElement(By.id("mark_range_text_1")).sendKeys(range);
		driver.findElement(By.id("mark_grade_text_1")).sendKeys(grade);
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit1")).click();
		Thread.sleep(4000);
		
		WebElement scroll = driver.findElement(By.xpath("//div[@class='box']"));
		Point loc = scroll.getLocation();
		int x = loc.getX();
		int y=loc.getY();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+ x +","+ y +")");
		
		/*WebElement x = driver.findElement(By.xpath("//td[text()='Grade 12']"));
		Thread.sleep(2000);
		String y = x.getText();
		Thread.sleep(2000);
		
		if(y.equals("Grade 12")) {
			System.out.println("Test Case is Pass");
		} else {
			System.out.println("Test Case is fail");
		}*/
		
		List<WebElement> gradeList = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr"));
		int size = gradeList.size();
		
		String gr = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(size) + "]/td[2]")).getText();
		System.out.println(gr);
		
		String af = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+ (size) + "]/td[3]")).getText();
		System.out.println(af);
		
		String hall = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+ (size) + "]/td[4]")).getText();
		System.out.println(hall);

		if(gr.equalsIgnoreCase(name) && af.equalsIgnoreCase(admfees) && hall.equalsIgnoreCase(hc) )
		{
			System.out.println(" Test Case is pass");
		}else {
				System.out.println("Test case is Fail");
			
		} 
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.id("btnYes")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Abhishek K H']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();

		driver.close();

	}
		

}
