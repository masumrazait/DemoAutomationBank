package coding;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static void main(String[] args) throws IOException {
		String filepath = "./TestData/data.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int FR = sheet.getFirstRowNum();
		int LR = sheet.getLastRowNum();
		Row firstRow = sheet.getRow(LR);
		for (int col = firstRow.getRowNum(); col <= firstRow.getLastCellNum(); col++) {
			Cell cell = firstRow.getCell(col);
			if (cell != null) {
				String cellValue = cell.getStringCellValue();
				System.out.println("Cell[" + FR + "][" + col + "]: " + cellValue);
			}
		}

		workbook.close();
		fis.close();
	}
}
