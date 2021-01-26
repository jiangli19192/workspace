package com.zjl.study.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayListTest test = new ArrayListTest();
		test.test_1();
		test.test_2();
	}
	
	public void test_1() {
		long start = System.currentTimeMillis();
		List<Entry> list = new ArrayList<ArrayListTest.Entry>();
		for (int i = 0; i < 100000; i++) {
			StringBuilder sb = new StringBuilder("name");
			sb.append(i);
			Entry entry = new Entry(sb.toString());
			list.add(entry);
		}
		
//		for (Entry entry2 : list) {
//			System.out.println(entry2.getName());
//		}
		
		System.out.println("test_1 Take time: " + (System.currentTimeMillis() - start));
	}
	
	public void test_2() {
		long start = System.currentTimeMillis();
		List<Entry> list = new ArrayList<ArrayListTest.Entry>();
		Entry entry = null;
		for (int i = 0; i < 100000; i++) {
			StringBuilder sb = new StringBuilder("name");
			sb.append(i);
			entry = new Entry(sb.toString());
			list.add(entry);
		}
		
//		for (Entry entry2 : list) {
//			System.out.println(entry2.getName());
//		}
		
		System.out.println("test_2 Take time: " + (System.currentTimeMillis() - start));
	}
	
	class Entry {
		private String name;
		
		public Entry(String name) {
			this.name = name;
		}

		String getName() {
			return name;
		}

		void setName(String name) {
			this.name = name;
		}
	}
}
