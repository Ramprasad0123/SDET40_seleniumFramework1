package org.tyss.ProvidenceSMS_GenericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.tyss.ProvidenceSMS_ObjectRepository.ClassDetails;
import org.tyss.ProvidenceSMS_ObjectRepository.CommonPage;
import org.tyss.ProvidenceSMS_ObjectRepository.ExamDetails;
import org.tyss.ProvidenceSMS_ObjectRepository.GradeDetails;
import org.tyss.ProvidenceSMS_ObjectRepository.LoginPage;
import org.tyss.ProvidenceSMS_ObjectRepository.PettyCashDetails;

public class BaseClass {
	
	protected WebDriver driver;
	protected static WebDriver sdriver;
	protected WebDriverUtility webdriverUtility;
	private FileUtility propertyFile;
	protected ExcelUtility excelUtility;
	protected JavaUtility javaUtility;
	protected LoginPage loginpage;
	protected CommonPage commonpage;
	protected GradeDetails gradedetails;
    protected ClassDetails classdetails;
	protected ExamDetails examdetails;
	protected PettyCashDetails pettyCashDetails;
	private String browser;
	private String url;
    private String time;
    private long timeouts;
    protected int randomNumber;
	protected String email;
	protected String password;
	protected String temail;
	protected String tpassword;
	
	
	@BeforeClass
	public void classSetUp() {
		 webdriverUtility=new WebDriverUtility();
		 propertyFile=new FileUtility();
		 excelUtility=new ExcelUtility();
		 javaUtility=new JavaUtility();
		
		 propertyFile.initializePropertyFile(IConstantUtility.PROPERTY_FILE_PATH);
         excelUtility.initializeExcel(IConstantUtility.EXCEL_PATH);
        
         browser = propertyFile.getDataFromPropertyFile("Browser");
		 url = propertyFile.getDataFromPropertyFile("Url");
		 time = propertyFile.getDataFromPropertyFile("Timeout");
		 
		   timeouts = (long)(javaUtility.convertStringToAnyData(time, DataType.LONG));
		
		 email = excelUtility.getDataFromExcelFile("Sheet1","Admin Email");
		 password = excelUtility.getDataFromExcelFile("Sheet1","Password");
		
		 temail = excelUtility.getDataFromExcelFile("Sheet1","Teacher Email");
		 tpassword = excelUtility.getDataFromExcelFile("Sheet1","T Password");
		    
		 driver=webdriverUtility.openBrowserAndApplication(browser, timeouts, url);
		sdriver=driver;
		 loginpage = new LoginPage(driver);
		 commonpage = new CommonPage(driver);
	     gradedetails = new GradeDetails(driver);
	     classdetails = new ClassDetails(driver);
	     examdetails = new ExamDetails(driver);
	     pettyCashDetails =new PettyCashDetails(driver);
		 randomNumber = javaUtility.getRandomNumber(1000);
		
	}
	
//	@BeforeMethod
//	public void methodSetUp() {
//		loginpage.loginAction(email, password);
//		}
	
	
	@AfterClass
	public void classSetdown() {
		excelUtility.closeExcelWorkbook();
		webdriverUtility.closeDriver();
		
	}
	
}
