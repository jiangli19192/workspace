package com.zjl.java8.study.example.stream.test;

import java.util.stream.Stream;

import com.zjl.java8.study.example.stream.data.Data;
import com.zjl.java8.study.example.stream.data.Person;

/**
 * 对象的流式操作 ClassName : Program
 * 
 * URL:https://www.bilibili.com/video/av75370921
 * 
 * @author 张江立
 * @date 2019年12月30日 下午12:57:18
 *
 */
public class Program {
	public static void main(String[] args) {
		// Program.testPerson();
		// 集合的最终操作
		Program.testCollectionStreamTerminalOperation();
	}

	public static void testCollectionStreamTerminalOperation() {
		// 集合的流式操作：JAVA8的一个新特性。
		// 流式操作：不是一个数据结构，不负责任务的数据存储。
		// 更像是一个迭代器。
		// 流式操作的每一个方法，返回值都是返回的流本身。

		// 生成流的三种方式
		Stream<Person> s = Data.getData().stream();
		// Stream.of(Data.getData());
		// Stream.of(1, 2, 3);

		// 最终操作1：collect
		// Collectors
		// List<Person> list = s.collect(Collectors.toList());
		// System.out.println(list);

		// Set<Person> set = s.collect(Collectors.toSet());
		// System.out.println(set);

		// Map<String, Integer> map =
		// s.collect(Collectors.toMap(Person::getName, Person::getScore));
		// System.out.println(map);

		// 最终操作2：reduce
		// Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// Optional<Integer> ret = s1.reduce((n1, n2) -> n1 + n2);
		// System.out.println(ret.get());

		// 求总成绩
		// Optional<Person> ret = s.reduce((n1, n2) -> new
		// Person().setScore(n1.getScore() + n2.getScore()));
		// System.out.println(ret.get().getScore());

		// Person tmp = new Person();
		// Optional<Person> ret = s.reduce((n1, n2) ->
		// tmp.setScore(n1.getScore() + n2.getScore()));
		// System.out.println(ret.get().getScore());

		// 最终操作3：max 和 min
		// Comparator
		// 需求1：找到集合中成绩最高的人的信息
		// Person max = s.max((n1, n2) -> n1.getScore() - n2.getScore()).get();
		// System.out.println(max);

		// 需求2：找到集合中年龄最小的人的信息
		// Person min = s.min((n1, n2) -> n1.getAge() - n2.getAge()).get();
		// System.out.println(min);

		// 最终操作4：anyMatch、allMatch、noneMatch
		// 需求1：判断集合中是否包含成绩不及格的学员
		// boolean ret1 = s.anyMatch(ele -> ele.getScore() < 60);
		// System.out.println(ret1);
		// 需求2：判断集合中是否包含成绩大于80的学员
		// boolean return1 = s.anyMatch(ele -> ele.getScore() > 80);
		// System.out.println(return1);
		// 需求3：判断集合中是否所有的学员都及格
		// boolean return2 = s.anyMatch(ele -> ele.getScore() < 60);
		// System.out.println(return2);
		// 需求4：判断集合中是否所有的学员都不及格
		// boolean return3 = s.allMatch(ele -> ele.getScore() < 60);
		// System.out.println(return3);
		// boolean return4 = s.noneMatch(ele -> ele.getScore() <= 60);
		// System.out.println(return4);

		// 最终操作5：count
		// long count = s.count();
		// System.out.println(count);

		// 最终操作6：forEach
		s.forEach(System.out::println);

		// 注意：流执行完最终操作后，就被关闭掉了，下面的操作就不能继续使用这个流了。
		// 对于下面取最大值和最小值的流操作来说，取最大值后，此流就已经被关闭了；
		// 再用此流取最小值就会出现错误：stream has already been operated upon or closed
		// Person max = s.max((n1, n2) -> n1.getScore() - n2.getScore()).get();
		// Person min = s.min((n1, n2) -> n1.getAge() - n2.getAge()).get();

	}

	public static void testPerson() {
		// Person xiaoming = new Person("xiaoming", 10, 100);

		Person xiaoming = new Person();
		xiaoming.setAge(10);
		xiaoming.setName("xiaoming");
		xiaoming.setScore(100);

		Person zhangsan = new Person();
		zhangsan.setName("zhangsan").setAge(10).setScore(100);
	}
}
