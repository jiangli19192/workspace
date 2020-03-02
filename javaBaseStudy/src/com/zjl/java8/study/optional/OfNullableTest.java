package com.zjl.java8.study.optional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

/**
 * 为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。
 * ofNullable与of方法相似，唯一的区别是可以接受参数为null的情况。示例如下：
 * ClassName : OfNullableTest
 * @author 张江立
 * @date 2017年4月2日 下午5:49:20
 *
 */
public class OfNullableTest {

	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}
	
	private static void test3() {
		Optional<String> empty = Optional.empty();
		
		if (!empty.isPresent()) {
			// 此种情况一定要判断是否为空，不然会报“java.util.NoSuchElementException: No value present”
			empty.get();
		}
	}
	
	private static void test2(){
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(0);
		
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(1);
		set2.add(2);
		set2.add(3);
		set2.add(6);
		set2.add(7);
		set2.add(8);
		
		Set<Integer> set3 = new HashSet<Integer>();
		
		//取出交集：两个集合都有数据
//		Optional.ofNullable(set).ifPresent(set2::retainAll);
//		
//		set2.stream().forEach(val -> {
//			System.out.println(val);
//		});
		
		
		Map<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
		map.putIfAbsent("1", set3);
		
		Set<Entry<String, Set<Integer>>> set4 = map.entrySet();
		set4.stream().forEach(entry->{
			System.out.println(entry.getKey() + entry.getValue());
		});
	}
	
	private static void test1() {
		//下面创建了一个不包含任何值的Optional实例
		//例如，值为'null'
		Optional<String> empty = Optional.ofNullable(null);
		if (empty.isPresent()) {
			System.out.println(empty.get());
		} else {
			System.out.println("Optional is null");
		}
		
		Optional<String> name = Optional.ofNullable("name");
		if (name.isPresent()) {
			System.out.println(name.get());
		} else {
			System.out.println("Optional is null");
		}
	}
}
