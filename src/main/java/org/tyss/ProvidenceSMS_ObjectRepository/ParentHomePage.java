package org.tyss.ProvidenceSMS_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS_GenericUtility.SubTabNames;
import org.tyss.ProvidenceSMS_GenericUtility.TabNames;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class ParentHomePage {
CommonPage commonPage ;
	
	public ParentHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	public void clickTeacherTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.TEACHERTAB);
	}
	
	public void clickAllTeacherSubTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredSubTab(webDriverUtility, SubTabNames.AllTeacherTab);
	}
	
	public void clickExamTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.TEACHERTAB);
	}
	
	public void clickMySonsExamTimetableTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredSubTab(webDriverUtility, SubTabNames.MySonsExamTimetableTab);
	}


}
