package com.DemoAutomationBank.testCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReader {

	public static void main(String[] args) throws IOException {
		String file = "./TestData/data.xlsx";
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Assuming the first row contains headers, so starting from the second row
		// (index 1)
		int row = 0;
		Row Frow = sheet.getRow(row);

		// Iterate through each cell in the first row
		for (int i = 0; i < Frow.getLastCellNum(); i++) {
			String cellValue = Frow.getCell(i).getStringCellValue();
			System.out.println("Cell " + (i + 1) + ": " + cellValue);
		}
		workbook.close();
		fis.close();
	}
}