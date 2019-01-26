package com.excel.excelExample1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Query3 {
	public void result() throws IOException , FileNotFoundException{
		FileInputStream file = new FileInputStream("Athlete Events Dataset.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> row_it = sheet.iterator();
   	 	HashSet<String> players = new HashSet<String>();
   	 	
        while(row_it.hasNext()) {
        	 Row row = row_it.next();
        	 Cell name = row.getCell(1);
        	 Cell team = row.getCell(6);
        	 if (team.toString().equalsIgnoreCase("Saint Kitts and Nevis")) {
        		 players.add(name.toString());
        	 }
         }
		 for (String s : players) {
			    System.out.printf("%-50s",s);
		}
        workbook.close();
	    file.close();
	}
}
