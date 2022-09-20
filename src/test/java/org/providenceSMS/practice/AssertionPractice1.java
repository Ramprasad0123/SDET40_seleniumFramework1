package org.providenceSMS.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice1 {
	@Test
	public void test1() {
		SoftAssert soft=new SoftAssert();
		String actual="HiHello";
		String expected="Hi";
		Reporter.log("test 1",true);
		soft.assertEquals(actual, expected);//test case is fail
		Reporter.log("test 11",true);
		
		soft.assertEquals(1,4);
		Reporter.log("test 12",true);
		soft.assertAll();//(this method will used at end),and this method will make softAssert as HardAssert and it will show previous assertion error
		Reporter.log("test 12",true);
		
	}
	
	@Test
	public void test2() {
		
		Reporter.log("test 2",true);
	}
	
	@Test
	public void test3() {
		
		Reporter.log("test 3",true);
	}

}
