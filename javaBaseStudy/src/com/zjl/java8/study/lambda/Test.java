package com.zjl.java8.study.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class Test {

	public static void main(String[] args) {
		Test t = new Test();
//		t.testOne();
//		t.testTwo();
//		t.testThree();
		t.testFour();
	}
	
	private void testFour() {
		List<String> list = null;
		List<String> resultList = list.stream().filter(Objects::isNull).collect(Collectors.toList());
		System.out.println(resultList);
	}
	
	private void testThree() {
		Set<String> set = new HashSet<String>(){{add("1"); add("2");}};
		Optional<String> str = set.stream().findFirst();
		System.out.println(str.get());
	}

	private void testTwo() {
		MathOperator<Integer> m = (Integer x, Integer y) -> {return (x + y);};
		MathOperator<Integer> m2 = (Integer x, Integer y) -> x + y;
		System.out.println(m.operator(3, 3));
		System.out.println(m2.operator(new Integer(2), new Integer(3)));
	}
	
	private void testOne() {
		Hunman h = str -> System.out.println(str);
		h.say("Hello World");
	}
}