package com.zjl.study.map;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class MapContainsTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashedMap<>();
		map.put("software", "Software");
		
		System.out.println(map.containsKey(null));
	}
}
