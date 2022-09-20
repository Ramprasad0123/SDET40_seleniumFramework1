package org.tyss.ProvidenceSMS_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS_GenericUtility.SubTabNames;
import org.tyss.ProvidenceSMS_GenericUtility.TabNames;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class TeacherHomePage {
	CommonPage commonPage ;
	//Initialization of WebElements in Home Page
	public TeacherHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Business Libraries
	public void clickExamTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.EXAMTAB);
	}
	
	public void clickExamTimetableSubTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredSubTab(webDriverUtility, SubTabNames.ExamTimetableTab);
	}

}
