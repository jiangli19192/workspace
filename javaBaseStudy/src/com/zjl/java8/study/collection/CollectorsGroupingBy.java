package com.zjl.java8.study.collection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * lambda表达式中的Collectors.groupingBy的使用
 * ClassName : CollectorsGroupingBy
 * @author 张江立
 * @date 2018年6月26日 下午4:48:17
 *
 */
public class CollectorsGroupingBy {
	public static void main(String[] args) {
		// groupingBy使用
		System.out.println("=======groupingBy==========");
		Stream<Person> stream = Stream.of(new Person("1", "aa", "12"),
				new Person("1", "bb", "13"), new Person("3", "cc", "14"));
		Map<String, List<Person>> idPersonListMap = stream.collect(Collectors
				.groupingBy(Person::getId));
		System.out.println(idPersonListMap);
		

		// groupingBy
		Map<String, List<Person>> tempMap = Stream.of(
				new Person("1", "aa", "12"), new Person("1", "bb", "13"),
				new Person("3", "cc", "14")).collect(
				Collectors.groupingBy(x -> x.id));
		for (String s : tempMap.keySet()) {
			tempMap.get(s).stream().forEach(x -> System.out.println(x));
		}

		Map<Boolean, List<Integer>> collectGroup = Stream.of(1, 2, 3, 4)
				.collect(Collectors.groupingBy(it -> it > 3));
		System.out.println("collectGroup : " + collectGroup);
	}
}

class Person {
	String id;
	String name;
	String age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Person() {
	}

	public Person(String id, String name, String age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "id='" + id + '\'' + ", name='" + name + '\''
				+ ", age='" + age + '\'' + '}';
	}
}
