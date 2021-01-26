package com.zjl.java8.study.iteration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AllMatchTest {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 3, 5, 7);
		boolean boo = list.stream().allMatch(str -> str == 1);
		System.out.println("boo=" + boo);
		
		List<Integer> list2 = Arrays.asList(1, 1, 1, 1);
		boolean boo2 = list2.stream().allMatch(str -> str == 1);
		System.out.println("boo2=" + boo2);
		
		List<String> list3 = Arrays.asList();
		boolean boo3 = list3.stream().filter(Objects::nonNull).allMatch(str -> str == "");
		System.out.println("boo3=" + boo3);
	}
}
