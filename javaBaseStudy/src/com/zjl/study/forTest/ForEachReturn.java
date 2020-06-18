package com.zjl.study.forTest;

public class ForEachReturn {

	public static void main(String[] args) {
		System.out.println(testForEachReturn(5));
	}
	
	public static boolean testForEachReturn(int num) {
		boolean re = false;
		
		for (int i = 1; i < num; i++) {
			if (i == 3) {
				System.out.println("true:" + i);
				return true;
			} else {
				System.out.println("fasle:" + i);
				testForEachReturn(num - i);
			}
		}
		
		return re;
	}
}
