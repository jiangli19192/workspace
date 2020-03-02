package com.zjl.study.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySetTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		Set<String> set = map.keySet();
		System.out.println(set);
	}
}
