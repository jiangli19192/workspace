package com.zjl.java8.study.methodReference;

import java.util.Arrays;
import java.util.List;

public class StaticMethodInvoke {
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("aa","bb","cc");
	    strs.forEach(System.out::println);
	}
	
}
