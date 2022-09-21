package org.providenceSMS.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		Thread.sleep(2000);
				
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Mumbai");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();

		//element

		driver.findElement(By.xpath("//span[.='To']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Delhi");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[.='New Delhi, India']")).click();
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//div[@id='root']")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		driver.close();
	}
	
}

