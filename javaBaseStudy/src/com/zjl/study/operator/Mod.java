package com.zjl.study.operator;

public class Mod {

	public static void main(String[] args) {
		mod();
	}
	
	/**
	 * "余数"符号和左边操作数相同
	 */
	private static void mod() {
		System.out.println(7%3);
		System.out.println(-7%3);
		System.out.println(7%-3);
	}
}
