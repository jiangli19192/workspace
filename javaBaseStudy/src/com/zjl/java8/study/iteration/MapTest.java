package com.zjl.java8.study.iteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest {
	public static void main(String[] args) {
		MapTest t = new MapTest();
//        t.test();
//        t.test2();
//        t.convertUpperCase();
		t.test3();
    }
	
	private void test3() {
		List<String> arr4 = new ArrayList<String>(Arrays.asList("4", "6", "8", "7", "5"));
//		List<String> arr5 = arr4.stream().sorted().collect(Collectors.toList());
//		arr5.forEach(str -> System.out.println(str));
		
		List<Integer> arr6 = arr4.stream().map(str -> Integer.valueOf(str)).sorted().collect(Collectors.toList());
		int[] arrInt = arr6.stream().mapToInt(x -> x).toArray();
		for(int i : arrInt){
			System.out.println(i);
		}
	}

	/**
	 * 使用map操作，将一数字集合所有数字都变成原来的两倍。
	 */
    private void test() {
        List<Integer> numbers = Stream.of(5,10,15).collect(Collectors.toList());
        //补全代码
        numbers = numbers.stream().map(num -> num * 2).collect(Collectors.toList());
        
        numbers.stream().forEach(num -> System.out.println(num));
        System.out.println("*********************test1**************************");
    }
    
    private void test2() {
    	/**
    	 * map方法文档说明如下：
    	 * 
    	 * 如果有值，则对其执行调用mapping函数得到返回值。
    	 * 如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
    	 */
    	
    	
    	Optional<String> name = Optional.of("name"); 
    	//map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
    	//为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
    	Optional<String> upperName = name.map((value) -> value.toUpperCase());
    	System.out.println(upperName.orElse("No value found"));
    	System.out.println("*********************test2**************************");
    }
    
    private void convertUpperCase(){
    	List<String> strs = Arrays.asList("a","b","c", "");
        for (String str : strs) {
            System.out.println(str.toUpperCase());
        }
        
        
        strs = Stream.of("d","e","f").map(str -> str.toUpperCase()).collect(Collectors.toList());
        strs.stream().forEach(str -> System.out.println(str));
    }
}
