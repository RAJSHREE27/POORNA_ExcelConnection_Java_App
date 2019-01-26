package com.excel.excelExample1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Query4 {
	
	public void result() throws IOException , FileNotFoundException{
		
		FileInputStream file = new FileInputStream("Athlete Events Dataset.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> row_it = sheet.iterator();
        
        HashMap<String,AthleteMedal> athMed = new HashMap<String ,AthleteMedal>();
        
        while(row_it.hasNext()) {
        	Row row = row_it.next();
	       	Cell name = row.getCell(1);
	       	Cell medal = row.getCell(14);
	       	
	       	if(! athMed.containsKey(name.toString())) {
	       		
	       		
	       		AthleteMedal a = new AthleteMedal();
	       		if(medal.toString() == "Gold") {
	       			a.setGold(a.getGold()+1);
	       			
	       		}else if(medal.toString() == "Silver") {
	       			a.setSilver(a.getSilver()+1);
	       		
	       		}else if(medal.toString() == "Bronze") {
	       			a.setBronze(a.getBronze()+1);
	       			
	       		} 
	       		athMed.put(name.toString(), a);
	       		
	       	}else {
	       		AthleteMedal at = new AthleteMedal();
	       		at = athMed.get(name.toString());
	       		
	       		if(medal.toString() == "Gold") {
	       			at.setGold(at.getGold()+1);
	       			
	       		}else if(medal.toString() == "Silver") {
	       			at.setSilver(at.getSilver()+1);
	       		
	       		}else if(medal.toString() == "Bronze") {
	       			at.setBronze(at.getBronze()+1);
	       			
	       		} 
	       		athMed.put(name.toString(), at);
	       		
	       		
	       	}
	       	String name1;
	        AthleteMedal med;
	        
	        for(Entry<String, AthleteMedal> entry : athMed.entrySet()) {
	        	 name1 = entry.getKey();
	        	 med = entry.getValue();
	        	 
	        	 System.out.printf("%-50s--->  ",name1);
	        	 System.out.printf("  Gold : %d ",med.getGold());
	        	 System.out.printf("  Silver : %d ",med.getSilver());
	        	 System.out.printf("  Bronze : %d ",med.getBronze());
	        	 System.out.println();
	        }
        	
	        workbook.close();
		    file.close();
        	
        }
		
		
	}

}