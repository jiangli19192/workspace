package com.zjl.study.params;

public class Params {

	/**
	 * 任意参数方法
	 * 
	 * @param params
	 */
	public static void test(String... params) {

		// 遍历参数内容
		for (String temp : params) {

			System.out.print(temp);

		}

		System.out.println();

	}

	public static void main(String[] args) {

		Params.test("a", "a", "a");

		Params.test("b", "b");

		Params.test("c");
		
		String[] str = new String[]{"a", "b", "c"};
		Params.test(str);

	}

}