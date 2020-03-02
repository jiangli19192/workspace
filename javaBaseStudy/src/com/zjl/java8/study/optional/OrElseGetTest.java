package com.zjl.java8.study.optional;

import java.util.Optional;

/**
 * orElseGet与orElse方法类似，区别在于得到的默认值。orElse方法将传入的字符串作为默认值，
 * 
 * orElseGet方法可以接受Supplier接口的实现用来生成默认值。
 * 
 * ClassName : OrElseGetTest
 * @author 张江立
 * @date 2017年4月2日 下午6:08:43
 *
 */
public class OrElseGetTest {

	public static void main(String[] args) {
		Optional<String> name = Optional.of("name");
		
		if (name.isPresent()) {
			//输出：name
			System.out.println(name.orElseGet(() -> "Default Value"));
		}
		
		
		Optional<String> empty = Optional.ofNullable(null);
		//输出：Default Value
		System.out.println(empty.orElseGet(() -> "Default Value"));
		
	}
}
