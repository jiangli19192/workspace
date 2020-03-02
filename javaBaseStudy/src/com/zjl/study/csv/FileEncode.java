package com.zjl.study.csv;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileEncode {

	public static String getFileEncode(String path) {
		String charset = "asci";
		byte[] first3Bytes = new byte[3];
		BufferedInputStream bis = null;
		try {
			boolean checked = false;
			bis = new BufferedInputStream(new FileInputStream(path));
			bis.mark(0);
			int read = bis.read(first3Bytes, 0, 3);
			if (read == -1)
				return charset;
			if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
				charset = "Unicode";// UTF-16LE
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xFE
					&& first3Bytes[1] == (byte) 0xFF) {
				charset = "Unicode";// UTF-16BE
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xEF
					&& first3Bytes[1] == (byte) 0xBB
					&& first3Bytes[2] == (byte) 0xBF) {
				charset = "UTF8";
				checked = true;
			}
			bis.reset();
			if (!checked) {
				int len = 0;
				int loc = 0;
				while ((read = bis.read()) != -1) {
					loc++;
					if (read >= 0xF0)
						break;
					if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
						break;
					if (0xC0 <= read && read <= 0xDF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF)
							// 双字节 (0xC0 - 0xDF) (0x80 - 0xBF),也可能在GB编码内
							continue;
						else
							break;
					} else if (0xE0 <= read && read <= 0xEF) { // 也有可能出错，但是几率较小
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) {
							read = bis.read();
							if (0x80 <= read && read <= 0xBF) {
								charset = "UTF-8";
								break;
							} else
								break;
						} else
							break;
					}
				}
				// TextLogger.getLogger().info(loc + " " +
				// Integer.toHexString(read));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException ex) {
				}
			}
		}
		return charset;
	}

	public static void main(String[] args) {
		FileEncode fileEncode = new FileEncode();
//		String filePath = "src/com/zjl/study/csv/CategoryReferences_20161207023739.csv";
//		String filePath = "src/com/zjl/study/csv/CategoryReferences_2.csv";
		String filePath = "src/com/zjl/study/csv/aa.csv";
		String fileEncodeName = fileEncode.getFileEncode(filePath);
		
		System.out.println("fileEncodeName=" + fileEncodeName);
		
		String filePath2 = "src/com/zjl/study/csv/CategoryReferences.csv";
		String fileEncodeName2 = fileEncode.getFileEncode(filePath2);
		System.out.println("fileEncodeName2=" + fileEncodeName2);
	}

}
