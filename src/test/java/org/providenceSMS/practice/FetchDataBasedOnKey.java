package org.providenceSMS.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataBasedOnKey {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/ComTestdata1.xlsx");
		Sheet sheet = WorkbookFactory.create(fis).getSheet("Sheet2");
		
		String value=null;
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			
			if(key.equalsIgnoreCase("pincode")) {
				value=sheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		System.out.println(value);
	}

}
