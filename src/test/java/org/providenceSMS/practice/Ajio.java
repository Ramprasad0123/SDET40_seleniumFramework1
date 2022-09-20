package org.providenceSMS.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
	driver.get("https://www.ajio.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.xpath("//a[.='KIDS']")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
	
	String item = driver.findElement(By.xpath("//div[.='Super-Man Print T-shirt with Shorts Set']")).getText();
	System.out.println(item);
	
    String price = driver.findElement(By.xpath("//div[.='Super-Man Print T-shirt with Shorts Set']/../div[3]/span")).getText();
    System.out.println(price);
     
   // driver.findElement(By.xpath("//span[.='1-2Y']")).click();
      
	}
	
}
