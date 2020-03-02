package com.zjl.study.string;

/**
 * \\s+  圆角空格匹配不上
 * (　+)|( +)
 * ClassName : StringSeparatorTest
 * @author 张江立
 * @date 2018年11月21日 上午10:51:33
 *
 */
public class StringSeparatorTest {
	
	public static void splitString(String keyword) {
		keyword = keyword.replaceAll("(　+)|( +)", " ");
		String[] keywordArray = keyword.split(" ");
		System.out.println("array size:" + keywordArray.length);
		for (int i = 0; i < keywordArray.length; i++) {
			System.out.println(i + " value is:" + keywordArray[i] + ";");
		}
		
		System.out.println("--------------------------------");
	}
	
	public static void main(String[] args) {
		StringSeparatorTest.splitString("");
		StringSeparatorTest.splitString("a　b");
		StringSeparatorTest.splitString("a　b　c");
		StringSeparatorTest.splitString("key ");
		StringSeparatorTest.splitString("8871  PREMI");
		StringSeparatorTest.splitString("8871  PREMI");
		StringSeparatorTest.splitString("8871  PREMI   sd　　ad");
	}

}
