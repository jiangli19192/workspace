package com.zjl.java8.study.optional;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		Optional<String> result = Optional.ofNullable("TOTAL");
		
		System.out.println(result.map(result1 -> result1 == "TOTAL").orElse(false));
	}
}
