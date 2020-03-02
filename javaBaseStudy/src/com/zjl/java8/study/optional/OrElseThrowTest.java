package com.zjl.java8.study.optional;

import java.util.Optional;

public class OrElseThrowTest {

	public static void main(String[] args) {
		Optional<String> empty = Optional.ofNullable(null);

		try {
			// orElseThrow与orElse方法类似。与返回默认值不同，
			// orElseThrow会抛出lambda表达式或方法生成的异常

			empty.orElseThrow(ValueAbsentException::new);
		} catch (Throwable ex) {
			// 输出: No value present in the Optional instance
			System.out.println(ex.getMessage());
		}
	}
}

class ValueAbsentException extends Throwable {
	private static final long serialVersionUID = 8290031886621378800L;

	public ValueAbsentException() {
		super();
	}

	public ValueAbsentException(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		return "No value present in the Optional instance";
	}
}
