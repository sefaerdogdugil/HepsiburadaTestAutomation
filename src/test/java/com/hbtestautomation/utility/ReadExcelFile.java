package com.hbtestautomation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadExcelFile {

    private static final Logger logger = LogManager.getLogger(ReadExcelFile.class); // Log nesnesi

    public static String getCellValue(String filePath, String sheetName, int rowNo, int cellNo) {
        try (FileInputStream inputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) return "";

            Row row = sheet.getRow(rowNo);
            if (row == null) return "";

            Cell cell = row.getCell(cellNo);
            if (cell == null) return "";

            return switch (cell.getCellType()) {
                case STRING -> cell.getStringCellValue();
                case NUMERIC -> String.valueOf(cell.getNumericCellValue());
                case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
                default -> "";
            };

        } catch (IOException e) {
            logger.error("Error reading Excel file: {}", filePath, e); // 🔥 Loglama eklendi
            return "";
        }
    }

    public static int getRowCount(String filePath, String sheetName) {
        try (FileInputStream inputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);
            return (sheet != null) ? sheet.getLastRowNum() + 1 : 0;

        } catch (IOException e) {
            logger.error("Error getting row count from Excel file: {}", filePath, e);
            return 0;
        }
    }

    public static int getColCount(String filePath, String sheetName) {
        try (FileInputStream inputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null || sheet.getRow(0) == null) return 0;

            return sheet.getRow(0).getLastCellNum();

        } catch (IOException e) {
            logger.error("Error getting column count from Excel file: {}", filePath, e);
            return 0;
        }
    }
}
