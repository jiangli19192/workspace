package com.zjl.java8.study.optional;

import java.util.Optional;

/**
 * isPresent: 如果值存在返回true，否则返回false。
 * ClassName : IsPresentTest
 * @author 张江立
 * @date 2017年4月2日 下午5:51:02
 *
 */
public class IsPresentTest {
	
	public static void main(String[] args) {
		//调用工厂方法创建Optional实例
		Optional<String> name = Optional.of("Sanaulla");
		
		//isPresent方法用来检查Optional实例中是否包含值
		if (name.isPresent()) {
		  //在Optional实例内调用get()返回已存在的值
		  System.out.println(name.get());//输出Sanaulla
		}
	}
}
