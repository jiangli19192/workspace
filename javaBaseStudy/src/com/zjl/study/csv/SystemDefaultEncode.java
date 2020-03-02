package com.zjl.study.csv;

public class SystemDefaultEncode {

	public static void main(String[] args) {
		String myCharset = System.getProperty("file.encoding");
		System.out.println("系统默认编码： "+myCharset );
		
		String encoding = System.getProperty("file.encoding");  
        System.out.println("你的操作系统所用的编码为："+encoding);
	}

}
