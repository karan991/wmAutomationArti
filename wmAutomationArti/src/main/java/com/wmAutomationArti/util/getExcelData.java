package com.wmAutomationArti.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getExcelData {

	private static String projectPath = System.getProperty("user.dir");
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static int rowCount;
	private static int columnCount;

	public getExcelData(String sheetName) {

		try {
			workbook = new XSSFWorkbook(projectPath + "\\src\\main\\resources\\TestData\\WMTestData.xlsx");
			// EXCEL PATH ---- "

			sheet = workbook.getSheet(sheetName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getRowCount() {

		rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	public static int getColumnCountInRow() {

		columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return columnCount;
	}

	public static String getCellDataString(int rowNum, int colNum) {

		String cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellValue;
	}

	public static double getCellDataNumeric(int rowNum, int colNum) {

		double cellValue = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return cellValue;
	}
}
