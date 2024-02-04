package coding;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	public static void main(String[] args) throws IOException {
		String files="./TestData/data.xlsx";
		FileInputStream fis= new FileInputStream(files);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();

        // Iterate over each cell in the first row
        Row firstRow = sheet.getRow(firstRowNum);
        for (int col = firstRow.getFirstCellNum(); col <= firstRow.getLastCellNum(); col++) {
            Cell cell = firstRow.getCell(col);
            if (cell != null) {
                String cellValue = cell.getStringCellValue();
                System.out.println("Cell[" + firstRowNum + "][" + col + "]: " + cellValue);
            }
        }

        workbook.close();
        fis.close();
	}
}
