package com.zjl.java8.study.example.stream.test;

import com.zjl.java8.study.example.stream.data.Data;
import com.zjl.java8.study.example.stream.data.Person;

/**
 * 中间操作 ClassName : Process
 * 
 * URL:https://www.bilibili.com/video/av75370921
 * 
 * @author 张江立
 * @date 2020年1月3日 下午12:59:59
 *
 */
public class Process {
	public static void main(String[] args) {
		// 中间操作1:filter
		// filter: 是一个过滤器，可以自定义一个过滤条件，将流中满足条件的元素保留
		// 需求：保留这个集合中成绩>=80的学员信息
		// Data.getData().stream().filter(ele -> ele.getScore() >= 80)
		// .forEach(System.out::println);

		// 中间操作2：distinct
		// distinct: 去重，去除集合中重复的元素
		// 去重规则：
		// 1.先判断两个对象的hashCode()
		// 2.如果hashCode相同，再判断equals()
		// Data.getData().stream().distinct().forEach(System.out::println);

		// 中间操作3：sorted
		// sorted: 排序，对流中的元素进行排序(需要有大小比较依据)
		// sorted(): 要求流中的元素对应的类需要实现 Comparable 接口
		// Data.getData().stream().sorted().forEach(System.out::println);
		// sorted(Comparator<T> c):使用自定义的规则来进行排序
		// Data.getData().stream().sorted((ele1, ele2) -> ele1.getAge() - ele2.getAge()).forEach(System.out::println);
		
		// 中间操作4：limit
		// limit:限制，只取流中前指定位的元素
		// Data.getData().stream().limit(3).forEach(System.out::println);
		
		// 中间操作5：skip
		// skip:跳过
		// Data.getData().stream().skip(3).forEach(System.out::println);
		
		// 需求：已知集合中有7个元素，想获取从第2个到第5个元素
		// Data.getData().stream().skip(1).limit(4).forEach(System.out::println);
		
		// 中间操作6：map
		// map: 元素映射，用指定的元素来替换掉流中的元素
		// 需求：将流中的Person对象替换成他们的姓名
		// Data.getData().stream().map(person -> person.getName()).forEach(System.out::println);
		// Data.getData().stream().map(person -> person.getScore() >= 80 ? person : person.getName()).forEach(System.out::println);
	}
}
