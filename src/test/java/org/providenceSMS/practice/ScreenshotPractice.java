package org.providenceSMS.practice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS_GenericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotPractice {
	@Test
	
	public void screenshot() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
       driver.get("http://rmgtestingserver/domain/Student_Management_System/view/dashboard.php");
       JavaUtility javaUtility=new JavaUtility();
		String currentTime = javaUtility.currentTime();
		System.out.println(currentTime);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+getClass().getSimpleName()+"_"+currentTime+".png");
		FileUtils.copyFile(src, dst);
		 


		
	}

}
