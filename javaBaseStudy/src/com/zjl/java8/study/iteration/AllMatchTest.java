package com.zjl.java8.study.iteration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 作用：Returns whether all elements of this stream match the provided predicate. 即判断是否所有的元素都匹配检查条件。
 * @author zjl
 *
 */
public class AllMatchTest {

	public static void main(String[] args) {
		incompleteMatchExample();

		allMatchExample();

		allMatchEmptyStreamExample();
	}

	/**
	 * 非全部匹配例子
	 */
	private static void incompleteMatchExample() {
		List<Integer> list = Arrays.asList(1, 3, 5, 7);
		boolean boo = list.stream().allMatch(str -> str == 1);
		System.out.println("boo=" + boo);
	}

	/**
	 * 全部匹配例子
	 */
	private static void allMatchExample() {
		List<Integer> list2 = Arrays.asList(1, 1, 1, 1);
		boolean boo2 = list2.stream().allMatch(str -> str == 1);
		System.out.println("boo2=" + boo2);
	}

	/**
	 * 全部匹配空数据流例子
	 */
	private static void allMatchEmptyStreamExample() {
		List<String> list3 = Arrays.asList();
		boolean boo3 = list3.stream().filter(Objects::nonNull).allMatch(str -> str == "");
		System.out.println("boo3=" + boo3);
	}
}
