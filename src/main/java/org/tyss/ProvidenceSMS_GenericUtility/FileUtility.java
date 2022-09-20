package org.tyss.ProvidenceSMS_GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/*
 * this class consist of the actions performed on Property file
 * @Author r
 */

public class FileUtility {
	Properties property=null;
	
	/*
	 * This method is used to initialize the Property File
	 * @param propertyPath
	 * 
	 */
	public void initializePropertyFile(String proprtyPath)
	{
		FileInputStream fisProperty=null;
		try {
			 fisProperty=new FileInputStream(proprtyPath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	    property=new Properties();
		try {
			property.load(fisProperty);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	/*
	 * this method consist of the code to fetch data from property file
	 * @param propertyPath
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String key)
	{
		return property.getProperty(key).trim();
		
		}

}
