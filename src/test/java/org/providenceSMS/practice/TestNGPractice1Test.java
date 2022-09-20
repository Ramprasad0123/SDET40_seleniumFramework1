package org.providenceSMS.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPractice1Test {
	@BeforeSuite
	public void suiteSetUp() {
	Reporter.log("Before suite",true);
	}
	
	@BeforeClass
	public void classSetUp() {
		Reporter.log("Before Class",true);
	}
	
	@BeforeClass
	public void classSetUp1() {
		Reporter.log("Before Class1",true);
	}
	
	@BeforeTest
	public void testSetUp() {
		Reporter.log("Before test",true);
		
	}
	
	@Test
	public void test1() {
		Reporter.log("Test1",true);
	}

	
	@BeforeMethod
	public void methodSetUp() {
		Reporter.log("Before method",true);
	}
	
	@BeforeMethod
	public void methodSetUp1() {
		Reporter.log("Before method1",true);
	}
	
	@Test
	public void test() {
		Reporter.log("Test",true);
	}

	@AfterSuite
	public void suiteSetDown() {
	Reporter.log("after suite",true);
	}
	
	@AfterClass
	public void classSetDown() {
		Reporter.log("after Class",true);
	}
	
	@AfterClass
	public void classSetDown1() {
		Reporter.log("after Class1",true);
	}
	
	@AfterTest
	public void testSetDown() {
		Reporter.log("after test",true);
		
	}
	
	@AfterMethod
	public void methodSetDown() {
		Reporter.log("after method",true);
	}
	@AfterMethod
	public void methodSetDown1() {
		Reporter.log("after method1",true);
	}
	@AfterMethod
	public void methodSetDown2() {
		Reporter.log("after method2",true);
	}
}
