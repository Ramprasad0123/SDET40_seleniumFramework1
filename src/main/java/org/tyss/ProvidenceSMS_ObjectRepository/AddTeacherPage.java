package org.tyss.ProvidenceSMS_ObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS_GenericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS_GenericUtility.WebDriverUtility;

public class AddTeacherPage {
	//Declaration of all Web Elements in Add Teacher Page
	
		@FindBy(id="index_number") private WebElement indexNumberTextField;
		@FindBy(id="full_name") private WebElement fullNameTextField;
		@FindBy(id="i_name") private WebElement nameWithInitialsTextField;
		@FindBy(id="address") private WebElement addressTextField;
		@FindBy(id="gender") private WebElement genderDropdown;
		@FindBy(id="phone") private WebElement phoneNumberTextField;
		@FindBy(id="email") private WebElement emailTextField;
		//@FindBy(xpath="//input[@id='fileToUpload']") private WebElement chooseFileIcon;
		@FindBy(id="fileToUpload") private WebElement photoUploadPopup;
		@FindBy(id="btnSubmit") private WebElement submitButton;
		
		//Initialization of all the web elements of Add Teacher Page
		
		public AddTeacherPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		//Business Library
		
		public Map<String, String> addTeacher(WebDriverUtility webdriver,ExcelUtility excelUtility) {
			
			//Map<String,String> map = excelUtility.getDataFromExcelFile("Sheet3","Add New Teacher account");
			Map<String, String> map = excelUtility.getDataFromExcelInMapGrade("Sheet3");
			
			indexNumberTextField.sendKeys(map.get("Index Number"));
			fullNameTextField.sendKeys(map.get("Full Name"));
			nameWithInitialsTextField.sendKeys(map.get("Name with Initials"));
			addressTextField.sendKeys(map.get("Address"));
			webdriver.dropdownByText(genderDropdown, map.get("Gender"));
			phoneNumberTextField.sendKeys(map.get("Phone"));
			emailTextField.sendKeys(map.get("Email"));
			photoUploadPopup.sendKeys(map.get("Photo"));
			submitButton.click();
			return map;
		
		}

}
