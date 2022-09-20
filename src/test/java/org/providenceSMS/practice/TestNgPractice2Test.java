package org.providenceSMS.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.tyss.ProvidenceSMS_GenericUtility.RetryToListener.class)
public class TestNgPractice2Test {
	@Test(groups="regression")
	public void step1Test() {
		Assert.fail();
		System.out.println("Script1");
		System.out.println("current thread id---> "+Thread.currentThread());
	}
	
	@Test(groups="sanity")
	public void step2Test() {
		Reporter.log("Script2",true);
		System.out.println("current thread id---> "+Thread.currentThread());
	}
	
	@Test(groups= {"sanity","regression"})
	public void step3Test() {
		Reporter.log("Script3",true);
	}


}
