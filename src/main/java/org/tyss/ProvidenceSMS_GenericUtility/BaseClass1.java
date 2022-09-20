package org.tyss.ProvidenceSMS_GenericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.tyss.ProvidenceSMS_ObjectRepository.AddTeacherPage;
import org.tyss.ProvidenceSMS_ObjectRepository.AdminHomePage;
import org.tyss.ProvidenceSMS_ObjectRepository.AllTeacherPage;
import org.tyss.ProvidenceSMS_ObjectRepository.CommonPage;
import org.tyss.ProvidenceSMS_ObjectRepository.GradeDetails;
import org.tyss.ProvidenceSMS_ObjectRepository.LoginPage;
import org.tyss.ProvidenceSMS_ObjectRepository.ParentHomePage;

public class BaseClass1 {
	protected WebDriver driver;
	protected WebDriverUtility webdriver;
	protected FileUtility propertyFile;
	protected ExcelUtility excelUtility;
	protected JavaUtility javaUtility;
	protected LoginPage loginpage;
	protected CommonPage commonpage;
	protected GradeDetails gradedetails;
	private String browser;
	private String url;
    private String time;
    private long timeouts;
    private int randomNumber;
	
	protected String email;
	protected String password;
	
	//protected CommonPage commonPage;
	protected AdminHomePage adminhomePage;
	protected AddTeacherPage addTeacherAction;
	protected ParentHomePage parenthomePage;
	protected AllTeacherPage allTeacherPage;
	
	
	@BeforeClass
	public void classSetUp() {
		 webdriver=new WebDriverUtility();
		 propertyFile=new FileUtility();
		 excelUtility=new ExcelUtility();
		 javaUtility=new JavaUtility();
		
		propertyFile.initializePropertyFile(IConstantUtility.PROPERTY_FILE_PATH);
        excelUtility.initializeExcel(IConstantUtility.EXCEL_PATH);
        
         browser = propertyFile.getDataFromPropertyFile("Browser");
		  url = propertyFile.getDataFromPropertyFile("Url");
		 time = propertyFile.getDataFromPropertyFile("Timeout");
		 timeouts=(long)(javaUtility.convertStringToAnyData(time, DataType.LONG));
		
		
		 email = excelUtility.getDataFromExcelFile("Sheet1","Admin Email");
		 
		 password = excelUtility.getDataFromExcelFile("Sheet1","Password");
		
		driver=webdriver.openBrowserAndApplication(browser, timeouts, url);
		
		 loginpage=new LoginPage(driver);
		 commonpage = new CommonPage(driver);
	     gradedetails = new GradeDetails(driver);
		  randomNumber = javaUtility.getRandomNumber(1000);
		
        
	}
	
//	@BeforeMethod
//	public void methodSetUp() {
//		loginpage.loginAction(email, password);
//		
//	}
	@BeforeMethod
	public void methodSetup() {
		adminhomePage = new AdminHomePage(driver);
		addTeacherAction = new AddTeacherPage(driver);
		parenthomePage = new ParentHomePage(driver);
		allTeacherPage =new AllTeacherPage(driver);
	}
	
	@AfterClass
	public void classSetdown() {
		excelUtility.closeExcelWorkbook();
		webdriver.closeDriver();
		
	}

}
