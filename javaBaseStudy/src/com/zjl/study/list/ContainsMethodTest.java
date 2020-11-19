package com.zjl.study.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainsMethodTest {

	public static void main(String[] args) {
		List<String> ids = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "3", "5"));
		List<String> condition = new ArrayList<String>(Arrays.asList("3", "4"));
		List<String> list = new ArrayList<String>();
		
//		if (ids.containsAll(condition)) {
//			System.out.println("contains 3 and 4");
//		} else if (ids.contains("2")) {
//			System.out.println("contains 2");
//		} else if (ids.contains("5")) {
//			System.out.println("contains 5");
//		}
		
		System.out.println(ids.containsAll(list));
		System.out.println(list.containsAll(ids));
	}
}
