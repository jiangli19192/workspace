package com.zjl.study.array;

import java.util.ArrayList;
import java.util.List;


/**
 * 字符串组合的例子
 * ClassName : Combination
 * @author 张江立
 * @date 2020年2月18日 上午9:40:35
 *
 */
public class Combination {
	public static void main(String args[]) {
		String str = "ab";
		
		String[] strArray = str.split("");
		
		System.out.println(arrayToString(strArray));
		
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < strArray.length; i++) {
			String[] newStrArray = new String[strArray.length + 1];
			arrayMiddlIinsertBlank(strArray, newStrArray, i);
			list.add(arrayToString(newStrArray));
		}
		
		for (String result : list) {
			System.out.println(result);
		}

	}
	
	public static void arrayMiddlIinsertBlank(String[] sourceArray, String[] resultArray, int beginPosition){
		for (int i = 0; i < sourceArray.length; i++) {
			if (i > beginPosition) {
				resultArray[i + 1] = sourceArray[i];
			} else {
				resultArray[i] = sourceArray[i];
				resultArray[i + 1] = " ";
			}
		}
	}

	public static String arrayToString(String[] params) {
		StringBuffer sb = new StringBuffer();
		for (String str : params) {
			sb.append(str);
		}

		return sb.toString();
	}
}