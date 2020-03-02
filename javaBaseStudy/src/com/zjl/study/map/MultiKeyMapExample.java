package com.zjl.study.map;

import java.util.Map;

import org.apache.commons.collections4.map.MultiKeyMap;


/**
 *  需求
	在应用中需要实现一个多键值的MAP表, 希望达到下面的使用目的:
	
	//键值是三个int类型,根据情况,数量和类型都应该可以变化,保存的值是string
	
	map<int,int,int,string> MultiKeyMap;
	
	<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-collections4 -->
	<dependency>
	    <groupId>org.apache.commons</groupId>
	    <artifactId>commons-collections4</artifactId>
	    <version>4.1</version>
	</dependency>
 * ClassName : MultiKeyMapExample
 * @author 张江立
 * @date 2018年1月24日 下午6:39:32
 *
 */
public class MultiKeyMapExample {

	public static void main(String[] args) {
		MultiKeyMap<Integer, String> myMap = new MultiKeyMap<Integer, String>();
		//插入多个值
		myMap.put(1,1,2,"112");
//		myMap.put(1,1,3,"113");
//		myMap.put(1,2,1,"121");
//		myMap.put(1,2,2,"122");
//		myMap.put(1,3,1,"131");

		//查找一个值:
//		System.out.println(myMap);
		System.out.println(myMap.get(1, 1, 2));

		//可以根据部分键值查找出多个匹配值
		String value = myMap.get(1,1);
		System.out.println(value);
	}

}
