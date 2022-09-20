package org.providenceSMS.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fxl=new FileInputStream("./src/test/resources/Commondatatest.xlsx");
		
		Workbook book = WorkbookFactory.create(fxl);
		
		Sheet sheet = book.getSheet("Datasheet");
		
		//Row row = sheet.createRow(3);    //create-->means bycott the particular row/cell
		                                   //get--->means it fetch the particular row/cell
		Row row = sheet.getRow(3);
		
		Cell cell = row.createCell(1);
		
		cell.setCellValue("TY");
		
		FileOutputStream fout=new FileOutputStream("./src/test/resources/Commondatatest.xlsx");
		book.write(fout);
		
		System.out.println("Data is updated successfully.....");
		
	}
}
