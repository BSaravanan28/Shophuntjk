package org.shophunt.addtocart;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step1 - read file using file input stream
		FileInputStream fis= new FileInputStream(".\\Data\\CoolBlue- ShopHunt RTM.xlsx");
		
		//step2 - create workbook
		Workbook book = WorkbookFactory.create(fis);
		
		//step3 - load sheet
		Sheet sh= book.getSheet("sheet1");
		
		//step4 - navigate to row
		Row row = sh.getRow(1);
		
		//step5 - navigate to cell
		Cell cell = row.getCell(3);
		
		//step6 - read the value in the cell
		System.out.println(cell.getStringCellValue());
		
		
		

	}

}
