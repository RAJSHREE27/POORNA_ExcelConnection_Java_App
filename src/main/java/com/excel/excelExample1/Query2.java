package com.excel.excelExample1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Query2 {
	public void result() throws IOException,FileNotFoundException{
		FileInputStream file = new FileInputStream("Athlete Events Dataset.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> row_it = sheet.iterator();
   	 	HashMap<String,HashSet<String>> hs = new HashMap<String,HashSet<String>>();
        while(row_it.hasNext()) {
        	 Row row = row_it.next();
        	 Cell name = row.getCell(1);
        	 Cell country = row.getCell(7);
        	 if (! hs.containsKey(name.toString())) {
        		 HashSet<String> s = new HashSet<String>();
        		 s.add(country.toString());
        		 hs.put(name.toString(), s);
        	 }else {
        		 HashSet<String> s = new HashSet<String>();
        		 s = hs.get(name.toString());
        		 s.add(country.toString());
        		 hs.put(name.toString(), s);
        	 }
         }
         for(Entry<String, HashSet<String>> entry : hs.entrySet()) {
        	 String name = entry.getKey();
        	 HashSet<String> countries = entry.getValue();
        	 if (countries.size()>=2) {
        		 System.out.printf("%-50s--->  ",name);
        		 for (String s : countries) {
        			    System.out.printf("%-20s",s);
        			}
        		 System.out.println();
        	 }
         }
        workbook.close();
	    file.close();
	}

}
