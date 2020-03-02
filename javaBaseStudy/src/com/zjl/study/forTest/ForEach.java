package com.zjl.study.forTest;

import java.util.List;

public class ForEach {

	public static void main(String[] args) {
		forEachTest();
	}

	private static void forEachTest() {
		try {
			List<String> list = null;

			for (String str : list) {
				System.out.println(str);
			}
		} catch (NullPointerException e) {
			System.out.println("循环列表对象为NULL");
		}
	}
}
