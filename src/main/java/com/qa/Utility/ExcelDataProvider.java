package com.qa.Utility;
import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src= new File("/Users/Saiful021107/Documents/FromYouTubeExperts/TestNG-Framework"
				+ "/TestAutomationFramework/TestData/Data.xls");
		try {
			FileInputStream fis= new FileInputStream(src);
			
			wb= new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			System.out.println("Unable to load the ExcelSheet"+ e.getMessage());
		}
		
	}
	
	public String getStringData(int sheetIndex, int row, int col) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	public double getNumericData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}

}