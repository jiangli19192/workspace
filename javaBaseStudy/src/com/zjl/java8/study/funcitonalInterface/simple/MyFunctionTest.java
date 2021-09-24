package com.zjl.java8.study.funcitonalInterface.simple;

public class MyFunctionTest {
	public static void main(String[] args) {
		MyFunction<Integer, Integer, Integer> fun = (a, b) -> a + b;
		System.out.println(fun.doSum(1, 2));
	}
}