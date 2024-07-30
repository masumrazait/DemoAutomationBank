package coding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelSheet {
	public static void main(String[] args) {
		String TestData = "./TestData/data.xlsx";
		FileInputStream fis;
		try {
			fis = new FileInputStream(TestData);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			String cell = sheet.getRow(0).getCell(3).getStringCellValue();
			System.out.println(cell);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
