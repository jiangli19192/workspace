package com.zjl.study.generics;

import java.util.ArrayList;

/**
 * https://www.cnblogs.com/chanshuyi/p/deep_insight_java_generic.html
 * 
 * ClassName : Generics
 * @author 张江立
 * @date 2020年4月13日 下午6:18:22
 *
 */
public class Generics {
	
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		
		Class c1 = a.getClass();
		Class c2 = b.getClass();
		
		System.out.println(c1 == c2);
	}

}
