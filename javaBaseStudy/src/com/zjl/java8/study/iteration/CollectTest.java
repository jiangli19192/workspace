package com.zjl.java8.study.iteration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest {
	public static void main(String[] args) {
		CollectTest t = new CollectTest();
//        t.test();
//        test2();
		test3();
    }

	/**
	 * 使用Stram.of()生成一列表，使用外部迭代和内部迭代输出结果，并比较。
	 */
    private void test() {
        List<String> strs = Stream.of("a","b","c").collect(Collectors.toList());
        System.out.println("用外部迭代for循环输出");
      	print(strs);
      	System.out.println("使用内部迭代输出结果");
      	strs.stream().forEach(str -> System.out.println(str));
    }
  
    private void print(List<String> strs) {
      for (String str : strs) {
          System.out.println(str);
      }
  	}
    
    private static void test2() {
    	List<String> shouldQty = new ArrayList<String>();
    	shouldQty.add("1");
    	shouldQty.add("2");
    	shouldQty.add("3");
    	shouldQty.add("4");
    	shouldQty.add("5");
    	
    	String str = shouldQty.stream().collect(Collectors.toList()).toString();
    	System.out.println(str);
    }
    
    private static void test3() {
    	List<String> shouldQty = new ArrayList<String>();
    	shouldQty.add("1");
    	shouldQty.add("2");
    	shouldQty.add("3");
    	shouldQty.add("4");
    	shouldQty.add("5");
    	
    	List<String> str = shouldQty.stream().filter(var -> var.equals("6")).collect(Collectors.toList());
    	System.out.println(str.size());
    	System.out.println(str.isEmpty());
    	
    	List<String> studentList = new ArrayList<String>();
    	List<String> newStudentList = studentList.stream().filter(var -> var.equals("var")).collect(Collectors.toList());
    	System.out.println(newStudentList.size());
    	System.out.println(newStudentList.isEmpty());
    }
}
