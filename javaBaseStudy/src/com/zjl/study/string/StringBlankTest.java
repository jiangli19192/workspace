package com.zjl.study.string;


public class StringBlankTest {
	public static void main(String[] args) {
		System.out.println(isBlank(""));
		System.out.println(isBlank(" "));
		System.out.println(isBlank(" a"));
		System.out.println(isBlank("     "));
		System.out.println("-----------------------------");
		System.out.println(isEmpty(""));
		System.out.println(isEmpty(" "));
	}
	
	public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
//        	System.out.println("isWhitespace:" + Character.isWhitespace(cs.charAt(i)));
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
	
	public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
}
