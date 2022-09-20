package org.providenceSMS_TestNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS_GenericUtility.BaseClass1;

public class AddTeacherTest extends BaseClass1 {
	@Test
	public void addTeacherTest() {
		
	
	loginpage.loginAction(email, password);
	
	adminhomePage.clickTeacherTab(webdriver, driver);
	
	adminhomePage.clickAddTeacherSubTab(webdriver,driver);
		
	Map<String,String> map = addTeacherAction.addTeacher(webdriver,excelUtility);
    javaUtility.robotClass();
	
	commonpage.signOutAction();
	
	String parentUN =excelUtility.getDataFromExcelFile("Sheet1","Parent Email");//propertyFile.getDataFromExceFile("Parent_UN1");
	String parentPWD =excelUtility.getDataFromExcelFile("Sheet1", "Password");//propertyFile.getDataFromPropertyFile("Parent_PWD1");
	commonpage.loginAction(parentUN, parentPWD);

	
	parenthomePage.clickTeacherTab(webdriver,driver);
	parenthomePage.clickAllTeacherSubTab(webdriver,driver);
	
	allTeacherPage.entryDropdown();

	List<WebElement> teacherNameList = new ArrayList<WebElement>();

	for (WebElement w :  allTeacherPage.getTeacherTableHeaderList()) {
		String headerName = w.getText();
		if (headerName.equals("Name")) {
			teacherNameList = allTeacherPage.getTeacherNameList();
			break;

		}
	}
	int count = 0;
	for (WebElement teacherName : teacherNameList) {
		String name = teacherName.getText();

		if (name.equals(map.get("Full Name"))) {
			excelUtility.writeToExcel("Sheet3", 13, 4, "Pass");
			System.out.println("TC Pass");
			count++;
			break;
		}

	}
	if (count == 0) {
		excelUtility.writeToExcel("Sheet3", 1, 4, "Fail");
		System.out.println("TC Fail");
	}
	
	commonpage.signOutAction();
	
	
	
	}
}
