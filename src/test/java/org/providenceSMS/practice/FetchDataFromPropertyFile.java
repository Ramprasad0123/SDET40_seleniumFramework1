package org.providenceSMS.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		
		//step1----> convert the physical file into java readable object
		FileInputStream fin=new FileInputStream("./src/test/resources/CommonData.Properties");
		
		//step2----> create object for properties
		Properties prop = new Properties();
		
		//step3---> load all the keys
	    prop.load(fin);
	    
	    //step4-->fetch the data
	     //String brow = prop.getProperty("Browser").trim();
	     String url = prop.getProperty("url1").trim();
	     
	     //System.out.println(brow);
	     System.out.println(url);
		
	
	}
}