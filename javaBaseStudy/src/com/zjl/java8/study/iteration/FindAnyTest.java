package com.zjl.java8.study.iteration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAnyTest {
	
	/**
	 * 这样出来的话，这个any肯定就是1了，因为此时stream是有顺序的，
	 * 相当于一个list，把list中的数字按顺序去执行findany，所以第一个是1, 既然找到了1，因此直接返回1
	 */
	private static void test1() {
		List<Integer> list = Arrays.asList(1, 3, 5, 7);
		
		Optional<Integer> any = list.stream().findAny();
		
		System.out.println("test1");
		System.out.println(any.isPresent());
		if (any.isPresent()) {
			System.out.println(any.get());
		}
		System.out.println("------------------------------------------");
	}
	
	/**
	 * 这样的话，这个any肯定就是5了，因为此时根据filter过滤了一把，把大于4的数字留下来了，
	 * 因此在执行findany之前，此时stream中只有5和7了，所以按照顺序，取到第一个是5，找了一个，因此直接返回5
	 */
	private static void test2() {
		List<Integer> list = Arrays.asList(1, 3, 5, 7);
		Optional<Integer> any = list.stream().filter(i -> i>4).findAny();
		
		System.out.println("test2");
		System.out.println(any.isPresent());
		if (any.isPresent()) {
			System.out.println(any.get());
		}
		System.out.println("------------------------------------------");
	}
	
	/**
	 * 这样的话，这个any就是Optional.empty，是一个空的了，因此根据filter过滤完了之后，没有大于9的，
	 * 此时stream中没有元素，因此findany没有找到任何一个，所以返回空Optional
	 */
	private static void test3() {
		List<Integer> list = Arrays.asList(1, 3, 5, 7);
		Optional<Integer> any = list.stream().filter(i -> i>9).findAny();
		
		System.out.println("test3");
		System.out.println(any.isPresent());
		if (any.isPresent()) {
			System.out.println(any.get());
		}
		System.out.println("------------------------------------------");
	}
	
	/**
	 * 这个例子和e.g 1比较像，此时stream中加了parallel()方法，所以这个流是一个并行流，是无序的，
	 * 那这个findany就无法确定到底返回谁了，1,3,5,7,哪一个都有可能返回了
	 */
	private static void test4() {
		List<Integer> list = Arrays.asList(1, 3, 5, 7);
		Optional<Integer> any = list.stream().parallel().findAny();
		
		System.out.println("test4");
		System.out.println(any.isPresent());
		if (any.isPresent()) {
			System.out.println(any.get());
		}
		System.out.println("------------------------------------------");
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
}
