package com.zjl.java8.study.example.stream.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.zjl.java8.study.example.stream.data.Data;
import com.zjl.java8.study.example.stream.data.Person;

/**
 * 练习题
 * ClassName : Exercise
 * @author 张江立
 * @date 2020年1月13日 上午9:56:57
 *
 */
public class Exercise {
	
	/**
	 * 需求： 一个集合中存储了若干个Person对象，要求查询出以下结果：
	 * 
	 * 1. 所有及格的学生信息
	 * 2. 所有及格的学生姓名
	 * 3. 班级的前3名(按照成绩)
	 * 4. 班级的3-10名(按照成绩)
	 * @param args
	 */
	public static void main(String[] args) {
		// 1. 所有及格的学生信息
		List<Person> list = Data.getData().stream().filter(persion -> persion.getScore() >= 60).collect(Collectors.toList());
		System.out.println(list);
		
		// 2. 所有及格的学生姓名
		List<String> names = Data.getData().stream().filter(person -> person.getScore() >= 60).map(person -> person.getName()).collect(Collectors.toList());
		System.out.println(names);
		
		// 3. 班级的前3名(按照成绩)
		List<Person> list2 = Data.getData().stream().sorted((p1, p2) -> p2.getScore() - p1.getScore()).limit(3).collect(Collectors.toList());
		System.out.println(list2);
		
		// 4. 班级的3-10名(按照成绩)
		List<Person> list3 = Data.getData().stream().sorted((p1, p2) -> p2.getScore() - p1.getScore()).skip(2).limit(8).collect(Collectors.toList());
		System.out.println(list3);
		
		List<Person> personList = new ArrayList<Person>();
		Map<String, Person> map = personList.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
		System.out.println(map);
		
	}
}
