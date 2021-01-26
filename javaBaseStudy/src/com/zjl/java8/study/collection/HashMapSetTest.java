package com.zjl.java8.study.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HashMapSetTest {

	public static void main(String[] args) {
		LinkedHashMap<Set<String>, List<String>> map = new LinkedHashMap<>();
		Set<String> key = new HashSet<String>();
		key.add("1");
		key.add("2");
		
		map.put(key.stream().collect(Collectors.toSet()), new ArrayList<String>());
		
		Set<String> target = new HashSet<String>();
		key.add("2");
		key.add("1");
		
		Set<String> target2 = new HashSet<String>();
		key.add("1");
		key.add("2");
		
		System.out.println(map.containsKey(key.stream().collect(Collectors.toSet())));
		System.out.println(map.containsKey(target.stream().collect(Collectors.toSet())));
		System.out.println(map.containsKey(target2.stream().collect(Collectors.toSet())));
	}
}
