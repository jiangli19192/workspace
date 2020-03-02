package com.zjl.study.parse;

public class ParseDoubleTest {

	public static void main(String[] args) {
		double height = Double.parseDouble("20");
		double weight = Double.parseDouble("25.2");
		
		System.out.println("Height:" + height + "; Weight:" + weight);
		
		try{
			Integer.parseInt("30.3");
		} catch(NumberFormatException e) {
			System.out.println("30.3转换成int时，数字格式错误!");
		}
		
		int intVar2 = Integer.parseInt("10");
		System.out.println("Integer:" + intVar2);
	}
}
