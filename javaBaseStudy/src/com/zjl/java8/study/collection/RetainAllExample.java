package com.zjl.java8.study.collection;

import java.util.ArrayList;
import java.util.List;

public class RetainAllExample {
	
	public static void main(String[] args) {
		List<String> sourceList = new ArrayList<String>();
		sourceList.add("2");
		sourceList.add("3");
		
		List<String> sourceList2 = new ArrayList<String>();
		sourceList2.add("5");
		sourceList2.add("6");
		
		List<String> targetList = new ArrayList<String>();
		targetList.add("1");
		targetList.add("2");
		targetList.add("3");
		targetList.add("4");
		
		sourceList.retainAll(targetList);
		sourceList2.retainAll(targetList);
		
		
		System.out.println("------------------sourceList---------------------");
		sourceList.stream().forEach(str -> System.out.println(str));
		System.out.println("------------------sourceList2---------------------");
		sourceList2.stream().forEach(str -> System.out.println(str));
		System.out.println("------------------targetList---------------------");
		targetList.stream().forEach(str -> System.out.println(str));
	}

}
