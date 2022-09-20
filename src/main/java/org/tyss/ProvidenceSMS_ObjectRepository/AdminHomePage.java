package org.tyss.ProvidenceSMS_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS_GenericUtility.SubTabNames;
import org.tyss.ProvidenceSMS_GenericUtility.TabNames;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class AdminHomePage {
	CommonPage commonpage;
	  
	//Initialization of webelements in Home page
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	public void clickTeacherTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonpage=new CommonPage(driver);
		commonpage.clickRequiredTab(webDriverUtility, TabNames.TEACHERTAB);
	}
	
	public void clickAddTeacherSubTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonpage=new CommonPage(driver);
		commonpage.clickRequiredSubTab(webDriverUtility, SubTabNames.AddTeacherTab);
		
	}

}
