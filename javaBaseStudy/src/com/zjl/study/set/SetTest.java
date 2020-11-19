package com.zjl.study.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断两个Set内是否有相同元素
 * ClassName : SetTest
 * @author 张江立
 * @date 2020年7月15日 下午6:56:45
 *
 */
public class SetTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		boolean boo = contains();
		System.out.println("Result:" + boo + "；take time: " + (System.currentTimeMillis() - start));
	}
	
	public static boolean contains() {
		Set<String> set1 = new HashSet<String>();
		set1.add("1");
		set1.add("2");
		set1.add("3");
		set1.add("4");
		set1.add("5");
		set1.add("6");
		set1.add("7");
		set1.add("8");
		
		Set<String> set2 = new HashSet<String>();
		set2.add("11");
		set2.add("12");
		set2.add("13");
		set2.add("14");
		set2.add("15");
		set2.add("16");
		set2.add("17");
		set2.add("18");
		set2.add("8");
		
		for (String str : set1) {
			for (String str2 : set2) {
				if (str.equals(str2)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
