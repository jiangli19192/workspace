package com.zjl.study.map;

import java.util.HashMap;
import java.util.Map;

public class GetOrDefaultExample {
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		
		System.out.println(map.getOrDefault("2", 0));
		System.out.println(map.getOrDefault("5", 0));
	}

}
