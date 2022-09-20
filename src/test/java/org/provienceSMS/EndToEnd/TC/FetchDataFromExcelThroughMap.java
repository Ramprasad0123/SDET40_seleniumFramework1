package org.provienceSMS.EndToEnd.TC;

import java.util.Map;

import org.tyss.ProvidenceSMS_GenericUtility.ExcelUtility;
import org.tyss.ProvidenceSMS_GenericUtility.IConstantUtility;

public class FetchDataFromExcelThroughMap {
	public static void main(String[] args) {
		ExcelUtility excelUtility=new ExcelUtility();
		excelUtility.initializeExcel(IConstantUtility.EXCEL_PATH);
		Map<String, String> map = excelUtility.getDataFromExcelInMapGrade("sheet3");
		System.out.println(map.get("GradeName"));
	}

}
