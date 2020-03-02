package com.zjl.java8.study.iteration;

import java.util.Arrays;
import java.util.List;

/**
 * noneMatch与allMatch恰恰相反，它用于判断流中的所有元素是否都不满足指定条件
 * ClassName : NoneMatchTest
 * @author 张江立
 * @date 2017年8月11日 上午10:50:53
 *
 */
public class NoneMatchTest {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		List<String> initList = Arrays.asList("abc", "bbc", "cbd", "ebd");
		System.out.println(initList.stream().noneMatch(str -> str.indexOf("b") != -1));
		System.out.println(initList.stream().noneMatch(str -> str.indexOf("c") != -1));
		System.out.println(initList.stream().noneMatch(str -> str.indexOf("f") != -1));
	}
	
	
}
