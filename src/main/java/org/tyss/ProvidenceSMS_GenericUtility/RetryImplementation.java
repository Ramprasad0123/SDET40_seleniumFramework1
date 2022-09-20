package org.tyss.ProvidenceSMS_GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer{
int count=0;
int maxtries=4;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxtries) {
			count++;
			return true;
		}
		return false;
		//if we write only return true; without logic then it will infinetly retry the method until testcase is pass
	}

}
