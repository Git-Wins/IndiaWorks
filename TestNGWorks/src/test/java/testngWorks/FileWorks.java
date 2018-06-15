package testngWorks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class FileWorks {

	@DataProvider
	public static String[][] excelData() throws IOException{
		String[][] data = null;

		FileInputStream fis = new FileInputStream("./data/dataDoc.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(fis);
		XSSFSheet wSheet = wBook.getSheet("Sheet1");

		// get no. of rows
		int rowCount = wSheet.getLastRowNum();

		// get no. of columns
		int columnCount = wSheet.getRow(0).getLastCellNum();
		data = new String[rowCount][columnCount];

		// looping through the rows
		for (int i = 1; i < rowCount + 1; i++) {
			XSSFRow row = wSheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				//String cellVal = "";
				Cell c = row.getCell(j);
				if (c == null) 
				{
					data[i - 1][j] = "";
				}
				else if(c.getCellType() == c.CELL_TYPE_STRING)
				{
					data[i - 1][j] = c.getStringCellValue();
				}else {
					data[i-1][j] = String.valueOf(c.getNumericCellValue());
				}

			}
		}
		fis.close();
		wBook.close();
		return data;
	}

}


