package com.zjl.study.set;

import java.util.ArrayList;
import java.util.List;

public class RemoveAllTest {
	
	public static void removeAll() {
		List<Integer>  list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		
		list1.removeAll(list2);
		
		for(Integer int1 : list1) {
			System.out.println(int1);
		}
		
	}
	
	public static void main(String[] args) {
		RemoveAllTest.removeAll();
	}

}
