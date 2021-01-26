package com.zjl.java8.study.arithmetic;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * ClassName : BubbleSort
 * @author 张江立
 * @date 2020年2月20日 下午9:51:49
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] number = {9, 7, 5, 3, 1, 10, 8, 6, 4, 2};
		
//		bubble_sort_1(number);
		bubble_sort_2(number, number.length);
	}

	/**
	 * 
	 * @param number
	 */
	private static void bubble_sort_1(int[] number) {
		for (int i = 0; i < number.length - 1; i++) {
			boolean swapped = false; // 假设没有元素交换的状态
			
			for (int j = 0; j < number.length - 1 - i; j++) {
				if (number[j] > number[j + 1]) {
					int temp = number[j];
					number[j] = number[j + 1];
					number[j + 1] = temp;
					swapped = true;
				}
				System.out.println("i = " + i + ";j = " + j);
			}
			
			// 如果没有元素交换，说明已经冒泡排序完成，立即停止运行
			if (!swapped) {
				break;
			}
		}
		
		for (int num : number) {
			System.out.print(num + " ");
		}
	}
	
	
	/**
	 * https://www.bilibili.com/video/av76091575/?spm_id_from=333.788.videocard.15
	 * @param number
	 * @param len
	 */
	private static void bubble_sort_2(int[] number, int len) {
		int temp;
		
		for (int pos = len - 1; pos > 0; pos--) {
			for (int cnt = 0; cnt < pos; cnt++) {
				if (number[cnt] > number[cnt + 1]) {
					temp = number[cnt];
					number[cnt] = number[cnt + 1];
					number[cnt + 1] = temp;
				}
				System.out.println(Arrays.toString(number));
			}
		}
		
		for (int num : number) {
			System.out.print(num + " ");
		}
	}
	
}
