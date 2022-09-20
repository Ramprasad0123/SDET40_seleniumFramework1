package org.providenceSMS.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataBasedOnKeyInExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Commondatatest.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Datasheet");
		
		DataFormatter df=new DataFormatter();
		String value=null;
		
		//<-----using for loop--------->
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			//Cell a = sheet.getRow(i).getCell(1);
			//System.out.println(a.getStringCellValue());
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(key.equalsIgnoreCase("password"))
			{
		        value = df.formatCellValue(sheet.getRow(i).getCell(1));
				break;
			}
			
		}
		System.out.println(value);
		
		//<---------using while loop------>
		/*int i=0;
		while(i<=sheet.getLastRowNum())
		{
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(key.equalsIgnoreCase("city"))
			{
				value=df.formatCellValue(sheet.getRow(i).getCell(1));
				break;
			}
			i++;
		}
		
		System.out.println(value);*/
	}
	

}
