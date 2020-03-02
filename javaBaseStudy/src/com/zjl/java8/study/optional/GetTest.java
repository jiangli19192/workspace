package com.zjl.java8.study.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * get(): 如果Optional有值则将其返回，否则抛出NoSuchElementException。
 * ClassName : GetTest
 * @author 张江立
 * @date 2017年4月2日 下午5:53:28
 *
 */
public class GetTest {

	public static void main(String[] args) {
		Optional<String> name = Optional.of("name");
		
		if (name.isPresent()) {
			System.out.println("有值:" + name.get());
		}
		
		
		Optional<String> empty = Optional.ofNullable(null);
		//执行下面的代码会输出：No value present 
		try {
		  //在空的Optional实例上调用get()，抛出NoSuchElementException
		  System.out.println(empty.get());
		} catch (NoSuchElementException ex) {
		  System.out.println(ex.getMessage());
		}
		
	}
}
