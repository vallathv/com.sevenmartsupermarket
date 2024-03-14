package com.sevenmartsupermarket.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sevenmartsupermarket.constants.Constants;

public class Excel {

	 XSSFSheet sheet; //Represents an Excel sheet.
	XSSFWorkbook workbook;// Represents an Excel workbook (.xlsx file).

	XSSFRow row;//Represents a row in the sheet.
	XSSFCell cell;//Represents a cell in a row.
	
	public void setExcelFile(String workBookName, String sheetName) {
		try {
			String path = Constants.EXCEL_FILE_PATH +workBookName+".xlsx" ;
			File src = new File(path);/// Import excel sheet.
			FileInputStream fi = new FileInputStream(src);//// Load the file.
			workbook = new XSSFWorkbook(fi);// // Load the workbook.
			sheet = workbook.getSheet(sheetName);// // Load the sheet in which data is stored.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getCellData(int rowNo, int columnNo){
		row = sheet.getRow(rowNo);
		cell = row.getCell(columnNo);
		switch (cell.getCellType()) {
		case STRING: { 
			String data; //Returns the string value directly.
			data = cell.getStringCellValue();
			return data;
		}
		case NUMERIC: {
			long d = (long) cell.getNumericCellValue(); //Converts the numeric value to a string (assuming the numeric value represents a long integer).
			return String.valueOf(d);
		}

		default:
			return null; //If the cell contains data types other than string or numeric, or if the cell is empty, it returns null.

		}
	}
	public int getRowCount() {
		
		return 0;
	}
}
	
	
	

