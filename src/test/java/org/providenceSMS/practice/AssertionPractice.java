package org.providenceSMS.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertionPractice {
	@Test
	public void test1() {
		String actual="Hi";
		String expected="Hi";
		Assert.assertEquals(actual, expected);
		Reporter.log("test 1",true);
		
//		String actual="Hi";
//		String expected="hi";
//		Assert.assertTrue(actual.equalsIgnoreCase(expected));
		
//		String actual="HiHello";
//		String expected="hi";
//		
//		Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()));
//		
//		String actual="HiHello";
//		String expected="hi";
		
//		Assert.assertTrue(10==11);
		
		//Assert.assertTrue(10!=11);//----->pass
		
		//Assert.assertFalse(10!=11);//--->fail
		
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
