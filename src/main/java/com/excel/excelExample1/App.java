package com.excel.excelExample1;

import java.io.FileNotFoundException;
import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException 
    {
    	System.out.println("Result of Query 1 : ");
    	Query1 query1 = new Query1();
    	query1.result();
    	
    	System.out.println("\n\nResult of Query 2 : ");
    	Query2 query2 = new Query2();
    	query2.result();
    	
    	System.out.println("\n\nResult of Query 3 : ");
    	Query3 query3 = new Query3();
    	query3.result();
    	
    	System.out.println("\n\nResult of Query 4 : ");
    	Query4 query4 = new Query4();
    	query4.result();
    	
    	
    }
}
