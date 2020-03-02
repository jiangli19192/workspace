package com.zjl.study.set;

import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RetainAllTest {
	public static void main(String[] args) {
		RetainAllTest test = new RetainAllTest();
//		test.example_1();
		
		test.example_2();

	}
	
	public void example_1() {
		Set<Object> set1 = new HashSet<Object>();
		set1.add(new Date()); // 向列表中添加数据
		set1.add("apple"); // 向列表中添加数据
		set1.add(new Socket()); // 向列表中添加数据
		set1.add("TV"); // 向列表中添加数据
		System.out.println("Set1的大小为：" + set1.size());
		

		Set<Object> set2 = new HashSet<Object>();
		set2.add("TV"); // 向列表中添加数据
		set2.add("apple"); // 向列表中添加数据
		System.out.println("Set2的大小为：" + set2.size());
		
		set1.retainAll(set2);
		System.out.println("从Set1集合移除Set2集合不包含的内容后：");
		System.out.println("Set1的大小为：" + set1.size());
		/** 
         * for增强循环遍历 
         */  
        for(Object value : set1){  
            System.out.print(value+" ");  
        } 
	}
	
	/**
	 * 两个集合没有相同数据，做交集操作就没有交集数据，取交集后的集合为空，但不是Null
	 */
	void example_2() {
		Set<Integer> integreSet = new HashSet<Integer>();
		integreSet.add(0);
		
		Set<Integer> integreSet_2 = new HashSet<Integer>();
		integreSet_2.add(1);
		integreSet_2.add(2);
		integreSet_2.add(3);
		
		integreSet.retainAll(integreSet_2);
		
		System.out.println(null != integreSet ? "integreSet size is : " + integreSet.size() : "integreSet is null.");
	}
}
