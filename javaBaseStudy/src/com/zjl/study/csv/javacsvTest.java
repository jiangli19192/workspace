package com.zjl.study.csv;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class javacsvTest {
	public static void main(String[] args) {

		try {

			ArrayList<String[]> csvList = new ArrayList<String[]>(); // 用来保存数据
			String csvFilePath = "src/com/zjl/study/csv/UTF-8-1.csv";
			CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("utf-8")); // 一般用这编码读就可以了

//			reader.readHeaders(); // 跳过表头 如果需要表头的话，不要写这句。

			while (reader.readRecord()) { // 逐行读入除表头的数据
				csvList.add(reader.getValues());
			}
			reader.close();

			for (int row = 0; row < csvList.size(); row++) {
				String[] line = csvList.get(row);// 取第row行
				StringBuffer stringBuffer = new StringBuffer();
				for (String s : line) {
					stringBuffer.append(s).append(",");
				}
				System.out.println(stringBuffer.toString());

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * 写入CSV文件
	 */
	public void writeCsv() {
		try {

			String csvFilePath = "c:/test.csv";
			CsvWriter wr = new CsvWriter(csvFilePath, ',',
					Charset.forName("SJIS"));
			String[] contents = { "aaaaa", "bbbbb", "cccccc", "ddddddddd" };
			wr.writeRecord(contents);
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
