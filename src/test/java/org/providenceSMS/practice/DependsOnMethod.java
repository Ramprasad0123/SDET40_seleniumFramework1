package org.providenceSMS.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test
	public void compose() {
		Reporter.log("compose1",true);
		
		
	}
	@Test(dependsOnMethods="compose")
	public void sentItems() {
		Reporter.log("sentttems1",true);
		Assert.fail();
	}
	@Test(dependsOnMethods="sentItems")
	public void trash() {
		Reporter.log("trash1",true);
		
	}

}
