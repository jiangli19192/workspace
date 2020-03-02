package com.zjl.study.string;

import java.util.Arrays;

/**
 * 字符串内字母全排列
 * ClassName : StringCharArrangeTest
 * @author 张江立
 * @date 2020年2月18日 上午9:49:32
 * 
 * 题目描述
	输入一个长度为n的字符串，输出该字符串中字符的全排列
	
	举例说明
	如果输入“abc”，则全排列为abc、acb、bac、bca、cab和cba。
	
	算法思路
	①递归实现，每递归一次取一个字符作为当前输入字符的首字符。例如，输入“abc”，则取第一个字符“a”，把字符“a”与第一个字符“a”交换，当前不用交换。剩下的字符“bc”，下次递归也是这样。如果选取的是字符“b”，则在字符数组中把字符“b”与字符“a”交换，后面选取字符就是在“ac”中选取。如果选取的是字符“c”，与字符“a”交换，下次选取就是在“ba”中选取
	②每次选取后，下次递归则需要把交换的字符顺序，重新返回。
	
	链接：https://www.jianshu.com/p/db7f935a00a8
 *
 */
public class StringCharArrangeTest {
	public static void main(String[] args) {
		String str = new String("abc");
		String[] arr = str.split("");
		
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i];
			if (i + 1 >= arr.length) {
				continue;
			}
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}
//		Arrays.stream(arr).forEach(System.out::println);
		
//		char[] arr_1 = {'a', 'b', 'c'};
//		permutation(arr_1, 0, arr.length);
	}
	
	static void permutation(char[] arr, int index, int size) {  
	    if (index == size) {  
	        for (int i = 0; i < arr.length; i++) {  
	            System.out.print(arr[i] + " ");  
	        }  
	        System.out.println();  
	    } 
	    else {  
	        for (int i = index; i < size; i++) {  
	            if(i != index && arr[i] == arr[index])  
	                continue;  
	            swap(arr, i, index);  
	            permutation(arr, index+1, size);  
	            swap(arr, i, index);  
	        }  
	    }  
	}  
	static void swap(char[] arr, int idx1, int idx2) {  
	    char temp = arr[idx1];  
	    arr[idx1] = arr[idx2];  
	    arr[idx2] = temp;  
	}
}
