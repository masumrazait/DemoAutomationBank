package coding;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filess = "./TestData/data.xlsx";
		FileInputStream fis = new FileInputStream(filess);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String cels = sheet.getRow(0).getCell(2).getStringCellValue();
		System.out.println(cels);
	}
}
