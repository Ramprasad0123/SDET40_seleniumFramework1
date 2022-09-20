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
import org.tyss.ProvidenceSMS_ObjectRepository.GradeDetails;
import org.tyss.ProvidenceSMS_ObjectRepository.LoginPage;

public class CreateGrade {
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
			//String email = excel.getDataFromExcelFile("Sheet1", 1, 1);//###
			
			//String password = excel.getDataFromExcelFile("Sheet1", 2, 1);
			String password = excel.getDataFromExcelFile("Sheet1","Password");
			
			Map<String, String> map = excel.getDataFromExcelInMapGrade("Sheet3");
			
//			String gradeName = excel.getDataFromExcelFile("Sheet3", 1, 3);
//			//List<Map<String, String>> gradeName = excel.getDataFromExcelInList("Sheet3");
//			String admissionFees = excel.getDataFromExcelFile("Sheet3", 2, 3);
//			String hallCharge = excel.getDataFromExcelFile("Sheet3", 3, 3);
//			String range = excel.getDataFromExcelFile("Sheet3", 4, 3);
//			String grade = excel.getDataFromExcelFile("Sheet3", 5, 3);
	          
	          
			long timeouts = (long) (javaUtility.convertStringToAnyData(timeout, DataType.LONG));
			
			//launching the browser and doing some browser setting
			WebDriver driver = webDriverUtility.openBrowserAndApplication(browser, timeouts, url);
			
			//initialize all the object repository class
			LoginPage loginpage=new LoginPage(driver);
			CommonPage commonpage = new CommonPage(driver);
			GradeDetails gradedetails = new GradeDetails(driver);
			int random = javaUtility.getRandomNumber(1000);

		
			//Script
			loginpage.loginAction(email, password);
			commonpage.getMessage();
			gradedetails.clickGradeTab();
			gradedetails.addGrade(map);
			gradedetails.allGrade(map);
			
			
	     /* WebElement scroll = driver.findElement(By.xpath("//div[@id='example1_paginate']"));
//			Point loc = scroll.getLocation();
//			
//			int x = loc.getX();
//			int y = loc.getY();
//			JavascriptExecutor js=(JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy("+ x +","+ y +")");*/
			 
		    commonpage.Scroll(webDriverUtility);        

		    String gradeText = commonpage.getTextAction();
	 	    System.out.println(gradeText);
		
//			// Dimension x = commonpage.getGradeList();
//			// System.out.println(x);0
//		    
//		     
//		if(gradeText.equals(gradeName)) {
//				System.out.println("Test Case is pass");
//			} else {
//				System.out.println("Test Case is fail");
//			}
	
			gradedetails.waitTillElementisClickable(gradedetails.getEle());
			//gradedetails.deleteGrade();

			gradedetails.waitTillElementisClickable(gradedetails.getyes());
		    //	gradedetails.yesbut();	
		
		
			System.out.println("TestCase pass");
			
		    commonpage.signOutAction();
			
		   //close the excel
			excel.closeExcelWorkbook();
			
		  //close the browser
		  webDriverUtility.closeDriver();
			
			
			
		}

}
