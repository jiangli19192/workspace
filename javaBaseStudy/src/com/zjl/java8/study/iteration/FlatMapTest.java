package com.zjl.java8.study.iteration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * flatMap
 * 
 * 如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。
 * flatMap与map（Funtion）方法类似，区别在于flatMap中的mapper返回值必须是Optional。
 * 调用结束时，flatMap不会对结果用Optional封装。
 * 
 * 
 * ClassName : FlatMapTest
 * @author 张江立
 * @date 2017年4月3日 下午5:11:49
 *
 */
public class FlatMapTest {

	public static void main(String[] args) {
		test1();
		test2();
	}

	private static void test1() {
		/**
		 * flatMap方法与map方法类似，区别在于mapping函数的返回值不同。
		 * map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
		 */
		Optional<String> name = Optional.ofNullable("sanaulla");
		
		//flatMap与map（Function）非常类似，区别在于传入方法的lambda表达式的返回类型。
		//map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。 
		//但flatMap方法中的lambda表达式返回值必须是Optionl实例。 
		Optional<String> upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
		System.out.println(upperName.orElse("No value found"));//输出SANAULLA
	}
	
	private static void test2() {
		List<String> list1 = Arrays.asList("a", "b", "c");
		List<String> list2 = Arrays.asList("a", "d", "e");
		
		List<String> list3 = Stream.of(list1, list2).flatMap(list -> list.stream()).collect(Collectors.toList());
		list3.forEach(str -> System.out.println(str));
		
	}
}
