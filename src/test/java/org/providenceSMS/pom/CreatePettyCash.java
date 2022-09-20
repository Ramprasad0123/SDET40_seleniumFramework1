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
import org.tyss.ProvidenceSMS_ObjectRepository.LoginPage;
import org.tyss.ProvidenceSMS_ObjectRepository.PettyCashDetails;

public class CreatePettyCash {
	public static void main(String[] args) throws Throwable {
		
		        //create instance for the Generic Utility
				WebDriverUtility webDriverUtility=new WebDriverUtility();
				FileUtility propertyFile=new FileUtility();
				ExcelUtility excelUtility=new ExcelUtility();
				JavaUtility javaUtility=new JavaUtility();
				JavaScriptUtility javaScriptUtility=new JavaScriptUtility();
				
				//initialize the property File and Excel file
				propertyFile.initializePropertyFile(IConstantUtility.PROPERTY_FILE_PATH);
				excelUtility.initializeExcel(IConstantUtility.EXCEL_PATH);
				
				//fetch the data from property
				String browser = propertyFile.getDataFromPropertyFile("Browser");
				String url = propertyFile.getDataFromPropertyFile("Url");
				String timeout = propertyFile.getDataFromPropertyFile("Timeout");
				
				//fetch the data from excel
				String temail = excelUtility.getDataFromExcelFile("Sheet1","Teacher Email");
			    String tpassword = excelUtility.getDataFromExcelFile("Sheet1","T Password");
			     
			    String email = excelUtility.getDataFromExcelFile("Sheet1","Admin Email");
			    String password = excelUtility.getDataFromExcelFile("Sheet1","Password");
				
				Map<String, String> map = excelUtility.getDataFromExcelInMapGrade("Sheet3");
				long timeouts = (long) (javaUtility.convertStringToAnyData(timeout, DataType.LONG));
				
				//launching the browser and doing some browser setting
				WebDriver driver = webDriverUtility.openBrowserAndApplication(browser, timeouts, url);
				

				//initialize all the object repository class
				LoginPage loginpage=new LoginPage(driver);
				CommonPage commonpage = new CommonPage(driver);
				PettyCashDetails pettyCashDetails=new PettyCashDetails(driver);
				int random = javaUtility.getRandomNumber(1000);
				
				
				//Script
				loginpage.teacherLoginAction(temail, tpassword);
				pettyCashDetails.clickMyPettyCashTab();
				pettyCashDetails.addMyPettyCash(map);
				javaUtility.robotClass();
				commonpage.signOutTeacher();
				
				loginpage.loginAction(email, password);
				//commonpage.clickRequiredTab(webDriverUtility, TabNames.MYPETTYCASHTAB);//driver.findElement(By.xpath("//span[.='Petty Cash']")).click();
				commonpage.clickAdminPettyCash();
				pettyCashDetails.selectIndex();
				
				System.out.println("TestCase pass");
				
			    commonpage.signOutAction();
				//close the excel
			    excelUtility.closeExcelWorkbook();
				
			//close the browser
			webDriverUtility.closeDriver();
				
	}
}
