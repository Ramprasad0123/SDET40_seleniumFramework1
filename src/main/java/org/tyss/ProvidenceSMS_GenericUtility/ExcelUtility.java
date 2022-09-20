package org.tyss.ProvidenceSMS_GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	Workbook workbook;
	/*
	 * This class consist of all common Action on excel
	 */
	public void initializeExcel(String excelPath)
	{
		FileInputStream fisExcel=null;
		try {
			fisExcel = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			 workbook = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException | IOException e) {
			
			e.printStackTrace();
		
		}
		
		/*------------------------------------
		 * FileInputStream fxl=new FileInputStream(excelPath);
		   Workbook book = WorkbookFactory.create(fxl);
		 */
				
	}
	/*
	 * this method consist of code to fetch data from the excel workbook based on index
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 */
	
	public String getDataFromExcelFile(String sheetName,int rowNumber,int cellNumber)
	{
		Sheet sheet = workbook.getSheet(sheetName);
		String data=new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
		return data;
	}
	
	/*
	 * this method is used to  fetch data from the excel workbook based on key
	 * @param sheetName
	 * @param required key
	 * @return
	 */
	  public String getDataFromExcelFile(String SheetName, String requiredKey) {
		  Sheet sheet = workbook.getSheet(SheetName);
		  String value=null;
		  for(int i=0;i<=sheet.getLastRowNum();i++) {
			  String actualKey = sheet.getRow(i).getCell(0).getStringCellValue();
			  
			  if(actualKey.equalsIgnoreCase(requiredKey)) {
				   value = sheet.getRow(i).getCell(1).getStringCellValue();
				  break;
			  }
		  }
		  return value;
	  }
	
	  
	  /*
		 * this method is used to  fetch data from the excel workbook and stored in map
		 * @param sheetName
		 * @return
		 */
	  public Map<String, String> getDataFromExcelInMap(String sheetName) {

		Sheet sheet = workbook.getSheet(sheetName);
		Map<String, String> map = new HashMap<>();
		DataFormatter df = new DataFormatter();
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));
		}
		return map;
	  }
	  
	 //----Grade TC01,Tc02,Tc03,Tc04
	  public Map<String, String> getDataFromExcelInMapGrade(String sheetName) {

		Sheet sheet = workbook.getSheet(sheetName);
		Map<String, String> map = new HashMap<>();
		DataFormatter df = new DataFormatter();
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			map.put(df.formatCellValue(sheet.getRow(i).getCell(2)), df.formatCellValue(sheet.getRow(i).getCell(3)));
		}
		return map;
	  }
	  
	  
	  /*
		 * this method is used to  fetch data from the excel workbook and stored in List<map>
		 * @param sheetName
		 * @return
		 */
		
		  public List<Map<String, String>> getDataFromExcelInList(String sheetName) {

			  Sheet sheet = workbook.getSheet(sheetName);
				List<Map<String, String>> list = new ArrayList<>();
				DataFormatter df = new DataFormatter();
				
				for(int k=1;k<sheet.getRow(0).getLastCellNum();k++) {
					Map<String, String> map = new HashMap<>();
					
					for(int i=0;i<=sheet.getLastRowNum();i++) {
						map.put(df.formatCellValue(sheet.getRow(i).getCell(0)),df.formatCellValue(sheet.getRow(i).getCell(k)));
					}
					list.add(map);
				}
				return list;
			
		  }
	 
	  
	  
	/*
	 * This method is used to write data to excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 */
	public void writeToExcel(String sheetName, int rowNumber, int cellNumber, String value) {
		FileOutputStream fosExcel=null;
		try {
			fosExcel=new FileOutputStream(IConstantUtility.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		Sheet sheet=workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.createCell(cellNumber);
		cell.setCellValue(value);
		
		try {
			workbook.write(fosExcel);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	/*
	 * This method is used to close the workbook
	 */
	public void closeExcelWorkbook()
	{
		try {
			workbook.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

}
