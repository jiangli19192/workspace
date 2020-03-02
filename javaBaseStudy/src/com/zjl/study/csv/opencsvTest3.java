package com.zjl.study.csv;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class opencsvTest3 {
	public static void main(String[] args) throws Exception {
//		String encoding = "GBK";
		String encoding = "GB2312";
//		String encoding = "UTF-8";

//		File file = new File("src/com/zjl/study/csv/UTF-8-2.csv");
		File file = new File("src/com/zjl/study/csv/ANSI-1.csv");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		InputStreamReader inputStreamReader = new InputStreamReader(
				dataInputStream, encoding);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		List<String[]> list = new ArrayList<String[]>();
		String line = null;
		
		while((line = bufferedReader.readLine()) != null){
			String[] columns = line.split(",");
			list.add(columns);
		}
		
		for (String[] ss : list) {
			for (String s : ss)
				if (null != s && !s.equals(""))
					System.out.print(s + " , ");
			System.out.println();
		}
		
		bufferedReader.close();
	}
}
