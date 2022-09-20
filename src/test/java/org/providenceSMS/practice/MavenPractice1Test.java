package org.providenceSMS.practice;

import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class MavenPractice1Test {
	@Test(groups="sanity")
	
	public void step1Test() {
		String browser = System.getProperty("b");
		String url=System.getProperty("u");
		System.out.println("Browser name is "+browser);
		System.out.println("url is "+url);
		
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		webDriverUtility.openBrowserAndApplication(browser, 10l, url);
		
		}
}
