package com.zjl.java8.study.collection;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 原文链接：https://blog.csdn.net/zebe1989/article/details/83054037
 * ClassName : CollectorsJoiningTest
 * @author 张江立
 * @date 2019年10月29日 下午3:59:29
 *
 */
public class CollectorsJoiningTest {

	public static void main(String[] args) {
//		test();
		
		// 定义人名数组
		final String[] names = {"US", "PY", "ZH", "CA", "SN"};
		Stream<String> stream1 = Stream.of(names);
		
		// 拼接成 [x, y, z] 形式
		String result1 = stream1.collect(Collectors.joining(", WW - ", "WW - ", ""));
		System.out.println(result1);// WW - US, WW - PY, WW - ZH, WW - CA, WW - SN
	}
	
	public static void test() {
		// 定义人名数组
		final String[] names = {"Zebe", "Hebe", "Mary", "July", "David"};
		Stream<String> stream1 = Stream.of(names);
		Stream<String> stream2 = Stream.of(names);
		Stream<String> stream3 = Stream.of(names);
		// 拼接成 [x, y, z] 形式
		String result1 = stream1.collect(Collectors.joining(", ", "[", "]"));
		// 拼接成 x | y | z 形式
		String result2 = stream2.collect(Collectors.joining(" | ", "", ""));
		// 拼接成 x -> y -> z] 形式
		String result3 = stream3.collect(Collectors.joining(" -> ", "", ""));
		System.out.println(result1);// [Zebe, Hebe, Mary, July, David]
		System.out.println(result2);// Zebe | Hebe | Mary | July | David
		System.out.println(result3);// Zebe -> Hebe -> Mary -> July -> David
	}
}
