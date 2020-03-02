package com.zjl.study.string;


public class StringFormat {
	public static void main(String[] args) {
//		System.out.println(String.format("Action Service (%s) %s", "simpleClassname", "fullMethodName"));
//		
//		System.out.println("English(US)".indexOf("nEnglish"));
//		System.out.println("English(US)".indexOf("English") != -1);
		
		stringEqualsIgnoreCase();
	}
	
	public static void stringEqualsIgnoreCase() {
		String CTO_ONLY = "CTO only";
		System.out.println(CTO_ONLY.equalsIgnoreCase("CTO Only"));
		System.out.println(CTO_ONLY.equalsIgnoreCase("CTO only"));
		System.out.println(CTO_ONLY.equalsIgnoreCase("cto only"));
	}
	
	public static void equalsIgnoreCaseTest() {
		
	}
}
