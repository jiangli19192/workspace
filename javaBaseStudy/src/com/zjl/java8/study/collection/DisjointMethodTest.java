package com.zjl.java8.study.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DisjointMethodTest {
	public static void main(String[] args) {
		Set<String> source = new HashSet<String>();
		Set<String> source2 = new HashSet<String>();
		
//		Collections.disjoint(null, source2);// NullPointerException
//		Collections.disjoint(source, null); // NullPointerException
		System.out.println(Collections.disjoint(source, source2));
		System.out.println(!Collections.disjoint(source, source2));
	}
}
