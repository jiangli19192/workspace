package com.zjl.study.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写java程序:输入一组整数存放在数组中,比较并输出其中最大值和最小值,并将数组元素从小到大输出 ClassName : Arr
 * 
 * @author 张江立
 * @date 2016年10月11日 上午9:49:11
 *
 */

public class Arr {
	private static int[] arr = { 3, 1, 6, 4, 5, 10, 2, 7, 8, 9 };
	

	public int getArrMaxValue(){
		// 对数组进行简单的排序
		java.util.Arrays.sort(arr);
		
		return arr[arr.length - 1];
	}
	
	public void incrementLessThanArrMaxValue() {
		List<Integer> list = new ArrayList<Integer>();
		int max = getArrMaxValue();//Integer.MAX_VALUE;
		int increments = 4;
		for (int index = 0; index < arr.length; index++) {
			
			for (int begin = 1; begin < max; begin = begin + increments) {
				if (begin == arr[index]) {
					list.add(begin);
				}
			}
			
		}
		
		System.out.println(list.toString());
	}
	
	public void sort(){
		// 对数组进行简单的排序
		java.util.Arrays.sort(arr);
		// 输出最大值、最小值
		System.out.println("最大值：" + arr[arr.length - 1] + "\n最小值：" + arr[0]);
		// 从小到大输出
		System.out.println(java.util.Arrays.toString(arr));
	}

	public static void main(String[] args) {
		Arr arr = new Arr();
		arr.incrementLessThanArrMaxValue();
	}
}