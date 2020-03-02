package com.zjl.study;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入元素个数：");
		int n = Integer.parseInt(sc.nextLine());
		int[] scores = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("请输入整数：");
			scores[i] = Integer.parseInt(sc.nextLine());
			;
		}
		Arrays.sort(scores);// 从小到大排序
		for (int i = 0; i < n; i++) {
			System.out.println(scores[i]);
		}
		System.out.println("最小值：" + scores[0]);
		System.out.println("最大值：" + scores[n - 1]);
	}
}
