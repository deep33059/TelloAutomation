package com.trello.gmc.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/** 
 * ExcelUtility is used to read the data from Excel sheet
 * @author CodeRoverAbhay
 */
public class ExcelUtility {
	public double readNumericExcelData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trelloTC.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		// Here I'am not chaining the process of retrieving the cell value as it'll make the debugging process easy
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		double numericCellValue = cell.getNumericCellValue();
		return numericCellValue;
	}

	public String readStringExcelData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trelloTC.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String stringCellValue = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return stringCellValue;
	}
}