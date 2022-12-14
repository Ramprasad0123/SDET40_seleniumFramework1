package org.providenceSMS.practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathCalender {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//complete Date format1----->

		String requiredDate = "20";  //DD
		String requiredMonth = "December";  //ex: MMMM--->July, MMM---->Jul, MM--->07
		String requiredYear = "2022";  //YYYY
		
		int requiredMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requiredMonth).get(ChronoField.MONTH_OF_YEAR);
		int requiredYearInNumber = Integer.parseInt(requiredYear);
		
		driver.get("http://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		Thread.sleep(2000);
		String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String[] str=actualMonthYear.split(" ");
		String actualMonth = str[0];
		String actualYear = str[1];
		
		
		int actualMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
		int actualYearInNumber = Integer.parseInt(actualYear);		
		
		Thread.sleep(2000);
		while(requiredMonthInNumber>actualMonthInNumber || requiredYearInNumber>actualYearInNumber)
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str=actualMonthYear.split(" ");
			actualMonth=str[0];
			actualYear=str[1];	
			actualMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
			actualYearInNumber = Integer.parseInt(actualYear);
		}
		
		while(requiredMonthInNumber<actualMonthInNumber || requiredYearInNumber<actualYearInNumber)
		{
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = actualMonthYear.split(" ");
			actualMonth = str[0];
			actualYear = str[1];	
			actualMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
			actualYearInNumber = Integer.parseInt(actualYear);
		}
		
		driver.findElement(By.xpath("//a[text()='"+requiredDate+"']")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
