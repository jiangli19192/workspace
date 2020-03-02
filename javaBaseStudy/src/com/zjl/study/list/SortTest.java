package com.zjl.study.list;

import java.util.Comparator;
import java.util.List;

import com.zjl.study.list.entity.Human;

public class SortTest {
	public static void main(String[] args) {
		List<Human> list = Human.getAInitHumanList();
		
		list.sort(Comparator.comparing(Human::getName));
		list.stream().sorted(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
		
		list.forEach(System.out::println);
		
		
	}
}
