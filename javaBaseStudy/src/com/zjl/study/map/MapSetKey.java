package com.zjl.study.map;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class MapSetKey {

	public static void main(String[] args) {
		LinkedHashMap<Set<String>, String> maps = new LinkedHashMap<Set<String>, String>();
		
		Set<String> setKey = new HashSet<String>();
		setKey.add("1");
		setKey.add("2");
		maps.put(setKey, "12");
		
		Set<String> setKey2 = new HashSet<String>();
		setKey2.add("1");
		setKey2.add("2");
		
		System.out.println(maps.containsKey(setKey2));
		System.out.println(setKey.equals(setKey2));;
	}
}
