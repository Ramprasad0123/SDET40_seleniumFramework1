package org.tyss.ProvidenceSMS_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/*
 * This class consist of the methods to get screenshot of failed TestCase
 * @author R
 */

public class Screenshot {
	/*
	 * This method is used to get the screenshot 
	 */
	public void getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(IConstantUtility.PHOTO_PATH);
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
