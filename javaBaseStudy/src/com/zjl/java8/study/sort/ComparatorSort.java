package com.zjl.java8.study.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 应用函数接口Comparator，实现排序
 * ClassName : ComparatorSort
 * @author 张江立
 * @date 2020年2月21日 下午10:01:19
 *
 */
public class ComparatorSort {

	public static void main(String[] args) {
//		testComparatorSort();
//		testSort();
//		testMultiSort();
		ComparatorSort sort = new ComparatorSort();
		sort.testEqualsSort();
	}
	
	public void testEqualsSort() {
		List<Sort> sourceList = new ArrayList<Sort>();
		sourceList.add(new Sort(1, 11, 112));
		sourceList.add(new Sort(2, 12, 111));
		sourceList.add(new Sort(2, 13, 114));
		sourceList.add(new Sort(3, 14, 113));
		
//		sourceList.sort(Comparator.comparingInt(obj -> obj.getOne()));
		sourceList.sort(new MyComparator());
		sourceList.forEach(obj -> System.out.println(obj.getOne() + "," + obj.getTwo()));
	}

	
	public static void testMultiSort() {
		List<Sort> sourceList = new ArrayList<Sort>();
		sourceList.add(new Sort(1, 13, 112));
		sourceList.add(new Sort(2, 12, 111));
		sourceList.add(new Sort(2, 12, 114));
		sourceList.add(new Sort(3, 11, 113));
		
		sourceList.stream().sorted(Comparator.comparingInt(Sort::getOne)
				.thenComparingInt(Sort::getTwo)
				.thenComparingInt(Sort::getThree)
				)
				.forEach(sort -> System.out.println(sort.getOne() + ";" + sort.getTwo() + ";" + sort.getThree()));
	}

	private static void testComparatorSort() {
		List<String> rackBoxList = new ArrayList<String>();
		rackBoxList.add("9307RC4");
		rackBoxList.add("9307RC2");
		rackBoxList.add("9307All");
		rackBoxList.add("93072PX");
		Comparator<String> compareAscending = Comparator.comparing(item -> item);
        Collections.sort(rackBoxList, compareAscending.reversed());
        
        for(String str : rackBoxList) {
        	System.out.println(str);
        }
	}
	
	public static void testSort() {
		List<Integer> list = Arrays.asList(new Integer[]{1,9,4,6,2,7,5,3});  //构造list，填充值

        list  = list.stream().sorted((n1,n2)->n1.compareTo(n2)).collect(Collectors.toList());

        System.out.println(list);
	}
	
	public static void testSortByListSort() {
		List<Sort> sourceList = new ArrayList<Sort>();
		sourceList.add(new Sort(1, 13, 112, "three"));
		sourceList.add(new Sort(2, 12, 111, "one"));
		sourceList.add(new Sort(2, 12, 114, "two"));
		sourceList.add(new Sort(3, 11, 113, "one"));
		sourceList.add(new Sort(4, 14, 114, "three"));
		
		sourceList.sort(Sort::compare);
		
		for (Sort sort : sourceList) {
			System.out.println("name: " + sort.getName());
			
		}
	}
}
