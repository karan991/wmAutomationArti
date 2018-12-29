package com.wmAutomationArti.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CORBA.UserException;

public class fetchExcelData {

	public void readDataFromExcel() {
		
		String filename = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\WMTestData.xlsx";

        try {
        	FileInputStream fis = new FileInputStream(filename);
            XSSFWorkbook workbook;
			try {
				workbook = new XSSFWorkbook(fis);
				 XSSFSheet sheet = workbook.getSheetAt(0);
				 Iterator<Row> rows = sheet.rowIterator();
		
            while (rows.hasNext()) {
                XSSFRow row =  (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();

                    CellType type = cell.getCellType();
                    if (type == CellType.STRING) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = STRING; Value = "
                                + cell.getRichStringCellValue().toString());
                    } else if (type == CellType.NUMERIC) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = NUMERIC; Value = "
                                + cell.getNumericCellValue());
                    } else if (type == CellType.BOOLEAN) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = BOOLEAN; Value = "
                                + cell.getBooleanCellValue());
                    } else if (type == CellType.BLANK) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = BLANK CELL");
                    }
                                
                }
            }
            
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
		
	}
	

