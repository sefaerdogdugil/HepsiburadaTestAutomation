package com.hbtestautomation.utility;

import com.alibaba.excel.EasyExcel;
import java.util.List;
import java.util.Map;

public class ReadExcelFile {

    // Excel verisini tek seferde oku ve bellekte tut
    public static List<Map<Integer, String>> readExcelData(String fileName, String sheetName) {
        return EasyExcel.read(fileName).sheet(sheetName).doReadSync();
    }

    // Satır sayısını alma
    public static int getRowCount(List<Map<Integer, String>> data) {
        return data.size();
    }

    // Kolon sayısını alma
    public static int getColCount(List<Map<Integer, String>> data) {
        return data.isEmpty() ? 0 : data.get(0).size();
    }
}
