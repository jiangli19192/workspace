package com.zjl.java8.study.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://blog.csdn.net/haoshuai2015/article/details/93746529
 * 
 * 应用函数接口Comparator，实现排序
 * ClassName : ComparatorSort
 * @author 张江立
 * @date 2020年2月21日 下午10:01:19
 *
 */
public class NameComparator implements Comparator<Sort> {
	
	

	public static void main(String[] args) {
		ComparatorSort sort = new ComparatorSort();
//		sort.testSortByListSort();
		
		testSortByListSort();
	}

	
	public static void testSortByListSort() {
		List<Sort> sourceList = new ArrayList<Sort>();
		sourceList.add(new Sort(1, 13, 112, "three"));
		sourceList.add(new Sort(2, 12, 111, "one"));
		sourceList.add(new Sort(5, 12, 111, "one"));
		sourceList.add(new Sort(2, 12, 114, "two"));
		sourceList.add(new Sort(3, 11, 113, "one"));
		sourceList.add(new Sort(4, 14, 114, "three"));
		
		sourceList.sort(new NameComparator());
		
		for (Sort sort : sourceList) {
			System.out.println("name: " + sort.getName());
			
		}
	}

	@Override
	public int compare(Sort beforeSort, Sort afterSort) {
		if (beforeSort.getName().equals("one") && "two".equals(afterSort.getName())) {
			return -1;
		} else if (beforeSort.getName().equals("one") && "three".equals(afterSort.getName())) {
			return -1;
		} else if (beforeSort.getName().equals("two") && "three".equals(afterSort.getName())) {
			return -1;
		} else {
			return 1;
		}
	}
}
