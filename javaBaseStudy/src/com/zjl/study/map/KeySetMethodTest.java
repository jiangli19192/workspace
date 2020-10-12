package com.zjl.study.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySetMethodTest {
	public static void main(String[] args) {
//		keySet_method_test();
		
	}
	
	public static void keySet_method_test() {
		Map<String, String> map = new HashMap<>();
		Set<String> set = map.keySet();
		System.out.println(set);
	}
}
