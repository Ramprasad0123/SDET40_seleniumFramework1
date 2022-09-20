package org.tyss.ProvidenceSMS_ObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS_GenericUtility.JavaScriptUtility;

public class TeacherDetails {
	//declaration
		@FindBy(xpath="//span[text()='Teacher']") private WebElement teacherTab;
		@FindBy(xpath="//a[text()=' Add Teacher']") private WebElement addTeacherTab;
		
		@FindBy(xpath="//input[@id='index_number']") private WebElement indexNumberTextField;
		@FindBy(xpath="//input[@id='full_name']") private WebElement fullNameTextField;
		@FindBy(xpath="//input[@id='i_name']") private WebElement initialNameTextField;
		@FindBy(xpath="//input[@id='address']") private WebElement addressTextField;
		
		//@FindBy(xpath="//select[@id='gender']") private WebElement genderDropdown;
		@FindBy(xpath="//select[@id='gender']/option[2]") private WebElement genderDropdown;
		@FindBy(xpath="//input[@id='phone']") private WebElement phoneNumberTextField;
		@FindBy(xpath="//input[@id='email']") private WebElement emailTextField;
		@FindBy(xpath="//input[@id='fileToUpload']") private WebElement chooseFileIcon;
		//@FindBy(xpath="//input[@name='fileToUpload']") private WebElement fileUploadIcon;
		@FindBy(xpath="//button[@id='btnSubmit']") private WebElement submittButton;
		
		
		//initialization all element variable
		public TeacherDetails(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		JavaScriptUtility javascriptUtility=new JavaScriptUtility();
		
		//Business library
		public void clickTeacherTab() {
			teacherTab.click();
		}
		
		public void clickaddTeacherTab() {
			addTeacherTab.click();
		}
		
		public void addTeacher(Map<String, String> map) throws InterruptedException {
			indexNumberTextField.sendKeys(map.get("Index Number"));
			fullNameTextField.sendKeys(map.get("Full Name"));
			initialNameTextField.sendKeys(map.get("Name with Initials"));
			addressTextField.sendKeys(map.get("Address"));
			//select[@id='gender']/option[2]
			genderDropdown.click();
			phoneNumberTextField.sendKeys(map.get("Phone"));
			emailTextField.sendKeys(map.get("Email"));
			javascriptUtility.scrollTillElementUsingJSE(chooseFileIcon);
			chooseFileIcon.click();
			chooseFileIcon.sendKeys("F:\\SOFT imp\\Screenshot (7).png");
			submittButton.click();
			
		}
}
