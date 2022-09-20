package org.provienceSMS.EndToEnd.TC;

import org.tyss.ProvidenceSMS_GenericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS_GenericUtility.IConstantUtility;

public class FetctDataBasedOnKey_utility {
	public static void main(String[] args) {
		
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.initializeExcel(IConstantUtility.EXCEL_PATH);
		String firstname = excelUtility.getDataFromExcelFile("Sheet2", "firstname");
		String lastname = excelUtility.getDataFromExcelFile("Sheet2", "Lastname");
		String address = excelUtility.getDataFromExcelFile("Sheet2", "Address");
		String pincode = excelUtility.getDataFromExcelFile("Sheet2", "pincode");
		
		System.out.println(address);
		System.out.println(pincode);
	}

}
