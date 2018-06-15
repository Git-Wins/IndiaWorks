package testngWorks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class FileWorksMODIF {

	@DataProvider
	public static String[][] excelData() throws IOException{
		String[][] data = null;

		FileInputStream fis = new FileInputStream("./data/dataDoc.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(fis);
		XSSFSheet wSheet = wBook.getSheet("Sheet1");

		Iterator rows = wSheet.rowIterator();
		
		while(rows.hasNext()) {
			XSSFRow row = (XSSFRow) rows.next();
			
			for(int i=0;i<row.getLastCellNum();i++) {
				
				XSSFCell cell = row.getCell(i, Row.RETURN_BLANK_AS_NULL);
			}
		}
		
		
		fis.close();
		wBook.close();
		return data;
	}

}


