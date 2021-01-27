package com.zjl.java8.study.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class StringSort {
	
	public static void main(String[] args) {
//		sortTest();
		sortTest_2();
	}
	
	private static void sortTest_2() {
		List<Sort> list = new ArrayList<Sort>();
		list.add(new Sort("7159HD6"));
		list.add(new Sort("7159HD5"));
		list.add(new Sort("7Y81CTO1WW"));
		
		list.stream().sorted(Comparator.comparing(Sort::getName))
			.forEach(sort -> System.out.println(sort.getName()));
	}
	

	private static void sortTest() {
		List<Sort> list = new ArrayList<Sort>();
		list.add(new Sort("7Y81CTO1WW"));
		list.add(new Sort("7159HD5"));
		
//		list.stream().sorted().forEach(str -> System.out.println(str));
//		Collections.sort(list, Comparator.comparing(Sort::getName));
//		Collections.sort(list, Comparator.comparing(Sort::getName, (name1, name2) -> name1.compareTo(name2)));
		Collections.sort(list, Comparator.comparing(Sort::getName, (name1, name2) -> {
			if (name1.contains("7Y81CTO1WW") && name2.contains("7159HD5")) {
				return 1;
			} else if (name1.contains("7159HD5") && name2.contains("7Y81CTO1WW")) {
				return -1;
			} else {
				return 0;
			}
		}));
		
		list.forEach(str -> System.out.println(str.getName()));
	}

}
