package com.zjl.java8.study.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**字符串的排列 实现2
 * 
 * https://www.bilibili.com/video/av86243261
 * ClassName : StringPermutation_2
 * @author 张江立
 * @date 2020年2月23日 下午4:07:18
 *
 */
public class StringPermutation_2 {

	ArrayList<String> resultList = new ArrayList<String>();

	public static void main(String[] args) {
		StringPermutation_2 sp = new StringPermutation_2();
		ArrayList<String> list = sp.permutaion("abc");
		list.stream().forEach(System.out::println);
	}

	public ArrayList<String> permutaion(String inputString) {
		if (Objects.isNull(inputString) || inputString.length() < 1) {
			return new ArrayList<String>();
		}

		List<Character> chars = new ArrayList<Character>();
		for (char c : inputString.toCharArray()) {
			chars.add(c);
		}

		compose(chars, new StringBuffer(), chars.size(), 0);

		resultList = new ArrayList<>(new HashSet<String>(resultList));

		Collections.sort(resultList);

		return resultList;
	}

	private void compose(List<Character> chars, StringBuffer sb, int length,
			int index) {
		// 最后一个位置
		if (index == length) {
			String res = sb.toString();
			resultList.add(res);
			return;
		}

		for (int i = 0; i < chars.size(); i++) {
			char c = chars.get(i);
			sb.append(c);
			chars.remove(i);
			compose(chars, sb, length, index + 1);
			chars.add(i, c);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
