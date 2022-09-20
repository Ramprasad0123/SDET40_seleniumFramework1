package org.provienceSMS.EndToEnd.TC;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.tyss.ProvidenceSMS_GenericUtility.DataType;
import org.tyss.ProvidenceSMS_GenericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS_GenericUtility.FileUtility;
import org.tyss.ProvidenceSMS_GenericUtility.IConstantUtility;
import org.tyss.ProvidenceSMS_GenericUtility.JavaScriptUtility;
import org.tyss.ProvidenceSMS_GenericUtility.JavaUtility;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;
import org.tyss.ProvidenceSMS_ObjectRepository.CommonPage;
import org.tyss.ProvidenceSMS_ObjectRepository.LoginPage;
import org.tyss.ProvidenceSMS_ObjectRepository.TeacherDetails;

public class AddNewTeacher {
	public static void main(String[] args) throws InterruptedException {
		//create instance for the Generic Utility
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		FileUtility propertyFile=new FileUtility();
		ExcelUtility excel=new ExcelUtility();
		JavaUtility javaUtility=new JavaUtility();
		JavaScriptUtility javaScriptUtility=new JavaScriptUtility();
		
		//initialize the property File and Excel file
		propertyFile.initializePropertyFile(IConstantUtility.PROPERTY_FILE_PATH);
		excel.initializeExcel(IConstantUtility.EXCEL_PATH);
		
		//fetch the data from property
		String browser = propertyFile.getDataFromPropertyFile("Browser");
		String url = propertyFile.getDataFromPropertyFile("Url");
		String timeout = propertyFile.getDataFromPropertyFile("Timeout");
		
		String email = excel.getDataFromExcelFile("Sheet1","Admin Email");
		//String email = excel.getDataFromExcelFile("Sheet1", 1, 1);//###
		
		//String password = excel.getDataFromExcelFile("Sheet1", 2, 1);
		String password = excel.getDataFromExcelFile("Sheet1","Password");
		
		Map<String, String> map = excel.getDataFromExcelInMapGrade("Sheet3");
		  
				long timeouts = (long) (javaUtility.convertStringToAnyData(timeout, DataType.LONG));
				
				//launching the browser and doing some browser setting
				WebDriver driver = webDriverUtility.openBrowserAndApplication(browser, timeouts, url);
				
				//initialize all the object repository class
				LoginPage loginpage=new LoginPage(driver);
				CommonPage commonpage = new CommonPage(driver);
				TeacherDetails teacherdetails=new TeacherDetails(driver);
				int random = javaUtility.getRandomNumber(1000);
				
				
				//script
				loginpage.loginAction(email, password);
				teacherdetails.clickTeacherTab();
				teacherdetails.clickaddTeacherTab();
				//teacherdetails.addTeacher(map);
				teacherdetails.addTeacher(map);
				 
				
				commonpage.signOutAction();
				
				//close the excel
					excel.closeExcelWorkbook();
					
				//close the browser
				webDriverUtility.closeDriver();
	}
}
