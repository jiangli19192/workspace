package com.zjl.java8.study.iteration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * https://blog.csdn.net/HelloMrZheng/article/details/70148300
 * ClassName : RemoveIfTest
 * @author 张江立
 * @date 2018年12月12日 下午6:28:59
 *
 */
public class RemoveIfTest {
	public static void main(String[] args) {
//		example1();
//		example2();
		
		RemoveIfTest removeIfTest = new RemoveIfTest();
		removeIfTest.example3();
	}
	
	public static void example1() {
		List<Integer> list = new ArrayList<>();
	    list.add(1);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    list.removeIf(s -> s%2==0);               // 过滤掉模2等于0的数
	    list.forEach(s -> System.out.println(s)); // 输出 1 3

	    List<String> strings = new ArrayList<>();
	    strings.add("ab");
	    strings.add("ac");
	    strings.add("bc");
	    strings.add("cd");
	    Predicate<String> predicate = (s) -> s.startsWith("a"); // 这里单独定义了过滤器
	    strings.removeIf(predicate);                            // 过滤掉以"a"开头的元素
	    strings.forEach(s -> System.out.println(s));            // 输出 bc cd
	}
	
	public static void example2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王二");
        list.add("李麻子");
        list.add("李三");
        list.removeIf(obj->obj.contains("李"));
        for (String s : list) {
            System.out.println(s);
        }
    }
	
	public void example3() {
		List<Option> options = new ArrayList<Option>();
		options.add(new Option("FC01", "FC01"));
		options.add(new Option("FC02", "FC02"));
		options.add(new Option("FC03", "FC03"));
		options.add(new Option("FC04", "FC04"));
		options.add(new Option("FC05", "FC05"));
		options.add(new Option("FC06", "FC06"));
		options.add(new Option("FC07", "FC07"));
		
		options.removeIf(option -> option.getCode().equals("FC03"));
		
		options.forEach(s -> System.out.println(s.getCode()));  
	}
	
	
	class Option {
		private String code;
		private String name;
		
		Option(String code, String name) {
			this.code = code;
			this.name = name;
		}

		String getCode() {
			return code;
		}

		void setCode(String code) {
			this.code = code;
		}

		String getName() {
			return name;
		}

		void setName(String name) {
			this.name = name;
		}
	}
}
