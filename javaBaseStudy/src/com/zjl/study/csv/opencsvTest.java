package com.zjl.study.csv;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class opencsvTest {
	public static void main(String[] args) throws Exception {
//		String encoding = "GBK";
		String encoding = "UTF-8";
		
		
        File file = new File("src/com/zjl/study/csv/UTF-8-3.csv");  
//        File file = new File("src/com/zjl/study/csv/ANSI-1.csv");  
        
        FileReader fReader = new FileReader(file); 
        System.out.println("encoding=" + fReader.getEncoding());
        CSVReader csvReader = new CSVReader(fReader); 
        
        
        String[] strs = csvReader.readNext();  
        if(strs != null && strs.length > 0){  
            for(String str : strs)  
                if(null != str && !str.equals(""))  
                    System.out.print(str + " , ");  
            System.out.println("\n---------------");  
        }  
        List<String[]> list = csvReader.readAll();  
        for(String[] ss : list){  
            for(String s : ss)  
                if(null != s && !s.equals(""))  
                    System.out.print(s + " , ");  
            System.out.println();  
        }  
        csvReader.close();  
    } 
}
