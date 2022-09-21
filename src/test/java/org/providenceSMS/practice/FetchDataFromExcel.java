package org.providenceSMS.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//start task...
		//step1----> convert the physical file into java readable object
				FileInputStream fxl=new FileInputStream("./src/test/resources/Commondatatest.xlsx");
		
	   //step2---->open the excel workbook
				Workbook book = WorkbookFactory.create(fxl);
	
	   //step3--->get the control on  sheet
				Sheet sheet = book.getSheet("Datasheet");
				
	   //step4---->get the control on row
				Row row = sheet.getRow(1);
				
	   //step5---->get the control on cell	
				Cell cell = row.getCell(1);
				
	   //step6--->fetch the data
				String un = cell.getStringCellValue();
			
				System.out.println(un);
	   //step7---->close the workbook
				book.close();
     //task over

	  
				
	}
	

}
