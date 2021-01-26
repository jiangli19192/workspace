package com.zjl.study.map;

/**
 * Hash函数
 * ClassName : HashFunciton
 * @author 张江立
 * @date 2020年2月23日 下午11:15:31
 *
 */
public class HashFunciton {
	
	public static void main(String[] args) {
		System.out.println(hash(1));
		System.out.println(hash(3));
		System.out.println(hash(8));
		System.out.println(hash(10));
	}

	private static int hash(int inputValue) {
		return (3 * inputValue + 4) % 7;
	}
}
