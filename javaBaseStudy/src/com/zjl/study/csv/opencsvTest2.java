package com.zjl.study.csv;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class opencsvTest2 {
	public static void main(String[] args) throws Exception {
		// String encoding = "GB18030";
		String encoding = "GBK";
		// String encoding = "UTF-8";

		 File file = new File("src/com/zjl/study/csv/UTF-8-1.csv");
//		File file = new File("src/com/zjl/study/csv/ANSI-1.csv");
		FileInputStream fileInputStream = new FileInputStream(file);
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		InputStreamReader inputStreamReader = new InputStreamReader(
				dataInputStream);
		encoding = getFileEncodName(encoding, inputStreamReader);
		System.out.println("encoding=" + encoding);
		InputStreamReader inputStreamReader2 = new InputStreamReader(
				dataInputStream, encoding);
		
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(null);

		CSVReader csvReader = new CSVReader(inputStreamReader2);

		String[] strs = csvReader.readNext();
		if (strs != null && strs.length > 0) {
			for (String str : strs)
				if (null != str && !str.equals(""))
					System.out.print(str + " , ");
			System.out.println("\n---------------");
		}
		List<String[]> list = csvReader.readAll();
		for (String[] ss : list) {
			for (String s : ss)
				if (null != s && !s.equals(""))
					System.out.print(s + " , ");
			System.out.println();
		}
		csvReader.close();
	}

	private static String getFileEncodName(String encoding,
			InputStreamReader inputStreamReader) throws IOException {
		char[] bom = new char[4];
		int readChar = inputStreamReader.read(bom, 0, 4);
		System.out.println("readChar=" + readChar);
		if (readChar >= 2) {
			if (readChar >= 4) {
				// UTF32，Big-Endian
				if (CheckBytes(bom, 4, 0x00, 0x00, 0xFE, 0xFF)) {
					encoding = "Unicode";
				}

				// UTF32，Little-Endian
				if (CheckBytes(bom, 4, 0xFF, 0xFE, 0x00, 0x00)) {
					encoding = "Unicode";
				}

				if (readChar >= 3 && CheckBytes(bom, 3, 0xEF, 0xBB, 0xBF)) {
					encoding = "UTF-8";
				}
			}
		} else {
			encoding = "GBK";
		}

		return encoding;
	}

	public static boolean CheckBytes(char[] chars, int count, int... values) {
		for (int i = 0; i < count; i++) {
			if (chars[i] != values[i]) {
				return false;
			}
		}
		return true;
	}
	
	
}
