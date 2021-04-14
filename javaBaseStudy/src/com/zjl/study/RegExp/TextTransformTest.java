package com.zjl.study.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * java 字符大小写判断及转换
 * 
 * ClassName : TextTransformTest
 * @author 张江立
 * @date 2021年4月14日 上午11:47:29
 *
 */
public class TextTransformTest {

	public static void main(String[] args) {
		String str = "SERVICE";

		Pattern p = Pattern.compile("[A-Z]+");

		Pattern p1 = Pattern.compile("[a-z]+");

		Matcher m = p.matcher(str);

		Matcher m1 = p1.matcher(str);

		if (m.matches()) {

			System.out.println("大写");

			// 大写转小写

			str = str.toLowerCase();

			System.out.println(str);

		}

		if (m1.matches()) {

			System.out.println("小写");

			// 小写转大写

			str = str.toUpperCase();

			System.out.println(str);

		}
	}
}
