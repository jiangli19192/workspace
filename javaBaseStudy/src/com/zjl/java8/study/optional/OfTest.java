package com.zjl.java8.study.optional;

import java.util.Optional;

public class OfTest {
	public static void main(String[] args) {
		/**
		 * 为非null的值创建一个Optional。
		 * of方法通过工厂方法创建Optional类。需要注意的是，创建对象时传入的参数不能为null。
		 * 如果传入参数为null，则抛出NullPointerException 。
		 */
		
		//调用工厂方法创建Optional实例
		Optional<String> name = Optional.of("Sanaulla");
		System.out.println(name.get());
		
		//传入参数为null，抛出NullPointerException.
//		Optional<String> someNull = Optional.of(null);
		
	}
}
