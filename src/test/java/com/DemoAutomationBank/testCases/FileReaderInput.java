package com.DemoAutomationBank.testCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReaderInput {

	public static void main(String[] args) throws IOException {
		String fils="./TestData/data.xlsx";
		FileInputStream fis=new FileInputStream(fils);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		String input=sheet.getRow(0).getCell(3).getStringCellValue();
		System.out.println(input);
		
	}
}
