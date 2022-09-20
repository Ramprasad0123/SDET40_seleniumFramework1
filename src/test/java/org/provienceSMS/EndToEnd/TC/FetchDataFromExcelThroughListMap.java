package org.provienceSMS.EndToEnd.TC;

import java.util.List;
import java.util.Map;

import org.tyss.ProvidenceSMS_GenericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS_GenericUtility.IConstantUtility;

public class FetchDataFromExcelThroughListMap {
	
	public static void main(String[] args) {
		
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.initializeExcel(IConstantUtility.EXCEL_PATH);
		List<Map<String, String>> list = excelUtility.getDataFromExcelInList("Sheet2");
		
		System.out.println(list.get(2).get("State"));
	}

}
