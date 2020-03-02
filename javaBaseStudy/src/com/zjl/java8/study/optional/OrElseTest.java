package com.zjl.java8.study.optional;

import java.util.Optional;

/**
 * 如果有值则将其返回，否则返回指定的其它值。
 * 
 * 如果Optional实例有值则将其返回，否则返回orElse方法传入的参数。
 * 
 * ClassName : OrElseTest
 * @author 张江立
 * @date 2017年4月2日 下午6:04:07
 *
 */
public class OrElseTest {

	public static void main(String[] args) {
		//如果值不为null，orElse方法返回Optional实例的值。
		//如果为null，返回传入的消息。
		
		
		Optional<String> name = Optional.of("name");
		
		if (name.isPresent()) {
			//输出：name
			System.out.println(name.orElse("There is some value!"));
		}
		
		
		Optional<String> empty = Optional.ofNullable(null);
		//输出：There is no value present!
		System.out.println(empty.orElse("There is no value present!"));
		
	}
}
