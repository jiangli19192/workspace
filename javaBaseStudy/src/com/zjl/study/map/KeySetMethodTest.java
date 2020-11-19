package com.zjl.study.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySetMethodTest {
	public static void main(String[] args) {
//		keySet_method_test();
		forEach_test();
	}
	
	public static void forEach_test() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		
		map.forEach((key, value) -> {
			if ("1".equals(key)) {
				return;
			}
			
			System.out.println(key + "; " + value);
		});
	}
	
	public static void keySet_method_test() {
		Map<String, String> map = new HashMap<>();
		Set<String> set = map.keySet();
		System.out.println(set);
	}
}
