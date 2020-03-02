package com.zjl.study.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 从字符串中提取数字的方法
 * From URL:https://blog.csdn.net/u012723673/article/details/78841766
 * ClassName : ExtractIntFromString
 * @author 张江立
 * @date 2019年3月4日 下午5:22:02
 *
 */
public class ExtractIntFromString {
	
	public static void main(String[] args) {
		String str = "cannot be more than 04.";
		String regEx = "[^0-9]";
		Pattern pattern = Pattern.compile(regEx);
		
		Matcher matcher = pattern.matcher(str);
		String intStr = matcher.replaceAll("").trim();
		
		System.out.println(intStr);
	}

}
