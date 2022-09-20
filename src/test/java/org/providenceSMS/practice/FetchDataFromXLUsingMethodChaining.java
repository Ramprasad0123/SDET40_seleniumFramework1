package org.providenceSMS.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromXLUsingMethodChaining {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fixl=new FileInputStream("./src/test/resources/Commondatatest.xlsx");
		
		Workbook book = WorkbookFactory.create(fixl);
		
		// go for Data Formatter
		DataFormatter df = new DataFormatter();//select empty data formatter constructor
		
		try {
			/*--------first options-------
		Sheet sheet = book.getSheet("Datasheet");
		String data = sheet.getRow(2).getCell(1).getStringCellValue();
		
		//String data = sheet.getRow(2).getCell(1).toString();
		
		//double data = sheet.getRow(2).getCell(1).getNumericCellValue();
		      */
			
		Sheet sheet = book.getSheet("Datasheet");
		  Cell cell = sheet.getRow(2).getCell(1);
		  String data = df.formatCellValue(cell);
			
		System.out.println(data);
		
		}
		
		finally {
			
		System.out.println("Excel getting close....");
		
		book.close();
		}
	}

}
/*if we want to change any contents to the excel sheet then we should (go (src/test/resources)) right-click on xlsx file-->openwith-->Systemeditor
   --->change content--->saveit*/