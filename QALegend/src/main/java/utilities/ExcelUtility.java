package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;
import constants.Messages;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;

	public static String getStringData(int a, int b, String sheet) {
		try {
			String path = Constants.HOME_DIRECTORY + Constants.TESTDATA_EXCELPATH;
			f = new FileInputStream(path);
			w = new XSSFWorkbook(f);
			sh = w.getSheet(sheet);
			Row r = sh.getRow(a);
			Cell c = r.getCell(b);
			return c.getStringCellValue();
		} catch (Exception e) {
			throw new RuntimeException(Messages.EXCELSHEET_NOT_FOUND);
		}
	}

	public static String getIntegerData(int a, int b, String sheet) {
		try {

			String path = Constants.HOME_DIRECTORY + Constants.TESTDATA_EXCELPATH;
			f = new FileInputStream(path);
			w = new XSSFWorkbook(f);
			sh = w.getSheet(sheet);
			Row r = sh.getRow(a);
			Cell c = r.getCell(b);
			int x = (int) c.getNumericCellValue();
			return String.valueOf(x);

		} catch (Exception e) {
			throw new RuntimeException(Messages.EXCELSHEET_NOT_FOUND);
		}
	}

}
