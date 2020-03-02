package com.zjl.study.RegExp;

public class RegularExpression {
	
	public static boolean checkNumber(String numberStr, String regex) {
		
		return numberStr.matches(regex);
	}

	public static void main(String[] args) {
		String regex = "^([0-9]{1,2}|([0-9]{1,2}[,，]?)+[0-9]{1,2})|([0-9]{1,2}(to|-)[0-9]{1,6})|([0-9]{1,2}[,，]?+[0-9]{1,2}(to|-)[0-9]{1,6})$";
		String number1 = "382000-383000";
		System.out.println(checkNumber(number1, regex));
		
		String number2 = "1to383000";
		System.out.println(checkNumber(number2, regex));
		
		String number3 = "1,333to383000";
		System.out.println(checkNumber(number3, regex));
		
	}

}
