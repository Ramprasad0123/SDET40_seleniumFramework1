package org.providenceSMS.pom;

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
import org.tyss.ProvidenceSMS_ObjectRepository.ExamDetails;
import org.tyss.ProvidenceSMS_ObjectRepository.LoginPage;

public class CreateExam {
	public static void main(String[] args) throws Throwable {
		
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
	String password = excel.getDataFromExcelFile("Sheet1","Password");
	
	Map<String, String> map = excel.getDataFromExcelInMapGrade("Sheet3");
	
	long timeouts = (long) (javaUtility.convertStringToAnyData(timeout, DataType.LONG));
	
	//launching the browser and doing some browser setting
	WebDriver driver = webDriverUtility.openBrowserAndApplication(browser, timeouts, url);
	
	//initialize all the object repository class
	LoginPage loginpage=new LoginPage(driver);
	CommonPage commonpage = new CommonPage(driver);
	//int random = javaUtility.getRandomNumber(1000);
	ExamDetails examdetails=new ExamDetails(driver);
	
	//Scripts
	loginpage.loginAction(email, password);
	commonpage.getMessage();
	examdetails.clickExamTab();
	examdetails.addExam(map);
	//dropdown
	examdetails.selectIndex();
	
	//convert into commonpage
	examdetails.waitTillElementisClickable(examdetails.getEle());
	//gradedetails.deleteGrade();

	examdetails.waitTillElementisClickable(examdetails.getyes());
    //	gradedetails.yesbut();	

    commonpage.signOutAction();
    excel.closeExcelWorkbook();
	webDriverUtility.closeDriver();


	
	}
}
