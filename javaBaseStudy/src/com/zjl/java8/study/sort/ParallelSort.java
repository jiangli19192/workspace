package com.zjl.java8.study.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * 例子，使用串行&并行排序数组
 * 
 * 说明： 除了并行流外，对于普通数组，Java8提供了简单的并行功能。 对于数组排序，一般使用Arrays.sort()方法串行排序，
 * Java8新增方法Arrays.parallelSort()并行排序。
 * 
 * 原文链接：https://blog.csdn.net/weixin_44018338/article/details/93875546 ClassName
 * : ParallelSort
 * 
 * @author 张江立
 * @date 2020年2月21日 下午10:05:29
 *
 */
public class ParallelSort {
	
	/**
	 * 输出结果：
	 * 数组串行排序时间：216 ms
	 * 数组并行排序时间：122 ms
	 * 结论：并行排序比串行排序快
	 */
	public void test() {
		int[] arr = getNumbers();
		long start = System.currentTimeMillis();
		Arrays.sort(arr);
		System.out.println("串行排序时间：" + (System.currentTimeMillis() - start)
				+ " ms");
		arr = getNumbers();
		start = System.currentTimeMillis();
		Arrays.parallelSort(arr);
		System.out.println("并行排序时间：" + (System.currentTimeMillis() - start)
				+ " ms");
	}

	private int[] getNumbers() {
		int[] arr = new int[5000000];
		Random r = new Random();
		for (int i = 0; i < 5000000; ++i) {
			arr[i] = r.nextInt(1000) + 1;
		}
		return arr;
	}

	public static void main(String[] args) {
		ParallelSort parallelSort = new ParallelSort();
		parallelSort.test();
	}
}
