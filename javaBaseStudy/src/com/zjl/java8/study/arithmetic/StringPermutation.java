package com.zjl.java8.study.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**字符串的排列 实现2
 * 
 * ClassName : StringPermutation
 * @author 张江立
 * @date 2020年2月23日 下午4:08:47
 *
 */
public class StringPermutation {
	
	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		ArrayList<String> list = sp.permutaion("abc");
		list.stream().forEach(System.out::println);
	}

	public ArrayList<String> permutaion(String inputString) {
		char[] a = inputString.toCharArray();
		ArrayList<String> resultList = new ArrayList<String>();
		solve(resultList, a, 0, a.length);
		
		resultList = new ArrayList<>(new HashSet<String>(resultList));
		
		Collections.sort(resultList);
		
		return resultList;
	}

	/**
	 * index  length 
	 * 0      3      a  b  c
	 * 1      3      a   
	 * @param resultList
	 * @param a
	 * @param index
	 * @param length
	 */
	private void solve(ArrayList<String> resultList, char[] a, int index, int length) {
		
		// 最后一个位置
		if (index == (length - 1)) {
			String res = change(a);
			resultList.add(res);
		}
		for (int i = index; i < length; i++) {
			char temp = a[i];
			a[i] = a[index];
			a[index] = temp;
			solve(resultList, a, index + 1, length);
			temp = a[i];
			a[i] = a[index];
			a[index] = temp;
		}
	}

	private String change(char[] a) {
		StringBuilder sb = new StringBuilder();
		for (char value : a) {
			sb.append(value);
		}
		return sb.toString();
	}
}
