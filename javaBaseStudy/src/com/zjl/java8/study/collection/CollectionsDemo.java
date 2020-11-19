package com.zjl.java8.study.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 原文链接：https://www.yiibai.com/java/util/collections_disjoint.html ClassName :
 * CollectionsDemo
 * 
 * @author 张江立
 * @date 2020年8月14日 下午2:45:52
 *
 */
public class CollectionsDemo {

	public static void main(String args[]) {
		haveCommonElement();
		noCommonElement();
	}

	private static void haveCommonElement() {
		// create two lists
		List<String> srclst = new ArrayList<String>(5);
		List<String> destlst = new ArrayList<String>(10);

		// populate two lists 填充两个列表
		srclst.add("Java");
		srclst.add("is");
		srclst.add("best");

		destlst.add("C++");
		destlst.add("is not");
		destlst.add("older");

		// check elements in both collections
		boolean iscommon = !Collections.disjoint(srclst, destlst);

		System.out.println("Have commom elements: " + iscommon);
	}

	private static void noCommonElement() {
		// create two lists
		List<String> srclst = new ArrayList<String>(5);
		List<String> destlst = new ArrayList<String>(10);

		// populate two lists 填充两个列表
		srclst.add("Java");
		srclst.add("is");
		srclst.add("best");

		destlst.add("C++");
		destlst.add("is not");
		destlst.add("older");

		// check elements in both collections
		boolean isNoCommon = Collections.disjoint(srclst, destlst);

		System.out.println("No commom elements: " + isNoCommon);
	}
}