package com.zjl.study;

public class Increment {
	public static void main(String[] args) {
		int j = 0;
		for (int i = 0; i < 100; i++)
//			j = j++;
			j = ++j;
		System.out.println(j);
	}
}

//期望结果：打印100
//实际结果：打印0