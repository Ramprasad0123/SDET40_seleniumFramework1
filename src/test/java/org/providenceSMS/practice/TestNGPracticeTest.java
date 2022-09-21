package org.providenceSMS.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPracticeTest {
	
	@Test(enabled = false)
	public void step1Test() {
		System.out.println("Script1");
	}
	
	@Test(priority=2,invocationCount=3)
	public void step2Test() {
		Reporter.log("Script2",true);
	}
	
	@Test(invocationCount=-1)
	public void step3Test() {
		Reporter.log("Script3",true);
	}

}
