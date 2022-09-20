package org.providenceSMS.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	public static void main(String[] args) {
		String browser = "Chrome";
		WebDriver driver = null;

		
		 if(browser.equalsIgnoreCase("Firefox")) {
		 WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
		 
		  else if(browser.equalsIgnoreCase("Chrome")) {
		  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		  
		  } else if (browser.equalsIgnoreCase("IE")){
		  WebDriverManager.iedriver().setup(); driver = new InternetExplorerDriver(); }
		 else { System.out.println("please! enter valid browser key..."); }
		 
/*
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;

		case "IE":
			WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("please! enter valid browser key...");
			break;

		}
*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hotstar.com");

	}

}
