package com.zjl.java8.study.arithmetic;

/**
 * 快速排序Java实现
 * ClassName : QuickSort
 * @author 张江立
 * @date 2020年2月20日 下午10:41:37
 *
 */
public class QuickSort {
	/**
	 * 找中轴
	 * 1.指定一个中轴
	 * 2.
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private int get_index(int[] arr, int left, int right) {
		
		return 0;
	}
	
	/**
	 * 1.找中轴
	 * 2.左边快排
	 * 3.右边快排
	 * @param arr
	 * @param left
	 * @param right
	 */
	public void quick_sort(int[] arr, int left, int right) {
		// 1.找中轴
		int index = get_index(arr, left, right);
		// 2.左边递归
		quick_sort(arr, left, index - 1);
		// 3.右边递归
		quick_sort(arr, index + 1, right);
	}

}
