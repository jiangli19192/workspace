package com.zjl.study.array;

import java.util.ArrayList;
import java.util.Arrays;


public class StaticArrayTest {
	public static final ArrayList<String> ARRAYLIST = new ArrayList<String>(Arrays.asList("1", "2", "3"));
	public static final ArrayList<String> ARRAYLIST_2 = new ArrayList<String>() {{
		add("11");
		add("22");
		add("33");
	}};
	
	public static void main(String[] args) {
		for (int i = 0; i < ARRAYLIST.size(); i++) {
			System.out.println(ARRAYLIST.get(i));
		}
		
		for (int i = 0; i < ARRAYLIST_2.size(); i++) {
			System.out.println(ARRAYLIST_2.get(i));
		}
	}
}
