package com.zjl.study.operator;

public class Increment {
	public static void main(String[] args) {
//		test_1();
		test_2();
	}
	
	
	/**
	 * 讲题连接地址：https://www.bilibili.com/video/av37602130/?p=1
	 * https://www.cnblogs.com/yaohuiqin/p/10373205.html
	 * 局部变量表     操作数栈
	 * 运行结果：i=4
	 * j=1
	 * k=11
	 */
	private static void test_2() {
		int i = 1;
		i = i++;
		int j = i++;
		int k = i + ++i * i++;
		
		System.out.println("i=" + i);
		System.out.println("j=" + j);
		System.out.println("k=" + k);
	}
	
	private static void test_1() {
		int j = 0;
		for (int i = 0; i < 100; i++) {
			// 放开这段代码，实际结果：打印0
			j = j++;
		    // 放开这段代码，实际结果：打印100
//			j = ++j;
		}
		System.out.println(j);
	}
}