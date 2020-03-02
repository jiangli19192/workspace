package com.zjl.study.array;

public class ArrayCopyTest {
	
	public static void main(String[] args) {
		int size = 10000;
		int[] array = new int[size];
		int[] arrayDestination = new int[size];
		
		// 初始化数据
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		
		long startTime = System.currentTimeMillis();
		System.arraycopy(array, 0, arrayDestination, 0, size);// 进行复制
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		String result = "";
		for(int i = 0; i < arrayDestination.length; i += 2) {
			result = result + "," + arrayDestination[i] + "," + arrayDestination[i + 1];
		}
		
		System.out.println(result);
		
	}
}
