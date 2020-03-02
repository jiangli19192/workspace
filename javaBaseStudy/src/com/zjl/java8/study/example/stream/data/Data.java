package com.zjl.java8.study.example.stream.data;

import java.util.ArrayList;

public class Data {
	
	public static ArrayList<Person> getData() {
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(new Person("xiaoming_100", 10, 100));
		list.add(new Person("xiaoli_90", 12, 90));
		list.add(new Person("xiaowang_80", 9, 80));
		list.add(new Person("xiaozhang_70", 11, 70));
		list.add(new Person("xiaomei_95", 7, 95));
		list.add(new Person("xiaohei_60", 13, 60));
		list.add(new Person("xiaohei_60", 13, 60));
		
		return list;
	}

}
