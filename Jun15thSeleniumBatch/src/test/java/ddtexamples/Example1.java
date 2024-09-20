package ddtexamples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Example1 {

	@Test
	public void testSheet() throws IOException {
		// file location & FileInputStream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\AppData.xlsx");
		// Create an instance of required XSSFWorkbook class and upcast it to WorkBook
		// interface
		Workbook wb = new XSSFWorkbook(fis);
		// you can perform any operation on Sheets
		System.out.println("Number of sheets: " + wb.getNumberOfSheets());
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			System.out.println(wb.getSheetName(i));
		}
		// get required sheet
		Sheet sheet = wb.getSheet("Sheet1");
	}

	@Test
	public void testRow() throws IOException {
		// file location & FileInputStream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\AppData.xlsx");
		// Create an instance of required XSSFWorkbook class and upcast it to WorkBook
		// interface
		Workbook wb = new XSSFWorkbook(fis);
		// get required sheet
		Sheet sheet = wb.getSheet("Sheet1");
		// now perform any required operation on Sheet1 row
		System.out.println("Sheet1 row count is: " + sheet.getLastRowNum());
		// get required row from Sheet1
		Row row = sheet.getRow(0);
		System.out.println("Cell count in row0: " + row.getLastCellNum());
	}

	@Test
	public void testCell() throws IOException {
		// file location & FileInputStream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\AppData.xlsx");
		// Create an instance of required XSSFWorkbook class and upcast it to WorkBook
		// interface
		Workbook wb = new XSSFWorkbook(fis);
		// get required sheet
		Sheet sheet = wb.getSheet("Sheet1");
		// get required row from Sheet1
		Row row = sheet.getRow(0);
		// now you get required cell from row
//		Cell cell=row.getCell(0);
//		System.out.println("row0-cell0 value is: "+cell.getStringCellValue());

		for (int i = 0; i < row.getLastCellNum(); i++) {
			System.out.println(row.getCell(i).getStringCellValue());
		}
	}

	@Test
	public void testCellWithDiffValues() throws IOException {
		// file location & FileInputStream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\AppData.xlsx");
		// Create an instance of required XSSFWorkbook class and upcast it to WorkBook
		// interface
		Workbook wb = new XSSFWorkbook(fis);
		// get required sheet
		Sheet sheet = wb.getSheet("Sheet1");
		// get required row from Sheet1
		Row row = sheet.getRow(2);
		// now you get required cell from row
//		for(int i=0;i<row.getLastCellNum();i++) {
//			System.out.println(row.getCell(i).getStringCellValue());
//		}

		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell cell=row.getCell(i);
			switch(cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getStringCellValue());
					break;
			case Cell.CELL_TYPE_NUMERIC:
				System.out.println(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				System.out.println(cell.getBooleanCellValue());
				break;
			default:
				System.out.println("Invalid cell");
				break;
			}
		}
	}
	
	@Test
	public void testUpdateCellValue() throws IOException {
		// file location & FileInputStream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData\\AppData.xlsx");
		// Create an instance of required XSSFWorkbook class and upcast it to WorkBook
		// interface
		Workbook wb = new XSSFWorkbook(fis);
		// get required sheet
		Sheet sheet = wb.getSheet("Sheet1");
		// get required row from Sheet1
		Row row = sheet.getRow(1);
		// now you get required cell from row
		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell cell=row.getCell(i);
			switch(cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getStringCellValue());
					break;
			case Cell.CELL_TYPE_NUMERIC:
				System.out.println(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				System.out.println(cell.getBooleanCellValue());
				break;
			default:
				System.out.println("Invalid cell");
				break;
			}
		}
		//below line will create(if cell not present)/update cell value
		row.createCell(4).setCellValue("Failed");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testData\\AppData.xlsx");
		wb.write(fos);
		fos.flush();
		fos.close();
		System.out.println("Updated......");
	}
}
