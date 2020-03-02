package com.zjl.study.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://www.runoob.com/java/java-regular-expressions.html
 * ClassName : MatcheExampleTest
 * @author 张江立
 * @date 2019年3月14日 上午10:58:16
 *
 */
public class MatcheExampleTest {

	public static void main(String[] args) {
		System.out.println("--getMatcherNumber_1-------------------------------------------");
		System.out.println(getMatcherNumber_1("cannot be 3 more than 2."));
		System.out.println("---------------------------------------------");
		System.out.println(getMatcherNumber_1("cannot be more than 4."));
		System.out.println("-------------------getMatcherNumber_2--------------------------");
		System.out.println(getMatcherNumber_2("cannot be more than 6."));
		System.out.println("--getMatcherNumber_3-------------------------------------------");
		getMatcherNumber_3("cannot be 02 more than 08.");
		System.out.println("-------------------getMatcherGroupCount--------------------------");
		getMatcherGroupCount("cannot be 02 more than 08.");

	}

	public static String getMatcherNumber_1(String inputString) {
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher(inputString);
		while (matcher.find()) {
			return matcher.group();
		}

		return "";
	}

	public static String getMatcherNumber_2(String inputString) {
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(inputString);
		return matcher.replaceAll("").trim();
	}
	
	public static void getMatcherNumber_3(String inputString) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(inputString);
        System.out.println("Matcher.groupCount() = " + matcher.groupCount());
        while (matcher.find()) {
        	System.out.println(matcher.group());
        }
    }
	
	public static void getMatcherGroupCount(String inputString) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(inputString);
        System.out.println("Matcher.groupCount() = " +  (matcher.find() ? matcher.groupCount() : "无"));
        System.out.println(matcher.group());
    }

}
