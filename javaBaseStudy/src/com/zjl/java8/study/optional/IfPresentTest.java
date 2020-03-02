package com.zjl.java8.study.optional;

import java.util.Optional;

/**
 * 如果Optional实例有值则为其调用consumer，否则不做处理
 * 
 * 要理解ifPresent方法，首先需要了解Consumer类。简答地说，Consumer类包含一个抽象方法。
 * 该抽象方法对传入的值进行处理，但没有返回值。Java8支持不用接口直接通过lambda表达式传入参数。
 * 
 * ClassName : IfPresentTest
 * @author 张江立
 * @date 2017年4月2日 下午5:59:22
 *
 */
public class IfPresentTest {
	public static void main(String[] args) {
		Optional<String> name = Optional.of("name");
		
		if (name.isPresent()) {
			//ifPresent方法接受lambda表达式作为参数。
			//lambda表达式对Optional的值调用consumer进行处理。
			name.ifPresent(value -> {
				System.out.println("The length of the value is: " + value.length());
			});
			System.out.println("有值:" + name.get());
		}
		
	}
}
