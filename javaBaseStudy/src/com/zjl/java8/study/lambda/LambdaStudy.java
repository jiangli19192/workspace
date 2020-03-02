package com.zjl.java8.study.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaStudy {
	
	public static void testThread(){
		//Before Java 8:  
/*		new Thread(new Runnable() {  
			@Override  
			public void run() {  
			    System.out.println("Before Java8, too much code for too little to do");  
			}  
		}).start();*/ 
		
		//Java 8 way:  
		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !") ).start(); 
	}
	
	public static void testList(){
		List<String> names = new ArrayList<>();
		names.add("TaoBao");
		names.add("ZhiFuBao");
		
		List<String> lowercaseNames = names.stream().map((name) -> {return name.toLowerCase();}).collect(Collectors.toList());
		
		System.out.println("-----带有参数类型-------");
		lowercaseNames.stream().forEach((String str) -> System.out.println(str));
		System.out.println("-----省略参数类型-------");
		lowercaseNames.stream().forEach((str) -> System.out.println(str));
		System.out.println("-----当lambda表达式的参数个数只有一个，可以省略小括号-------");
		lowercaseNames.stream().forEach(str -> System.out.println(str));
		
	}
	
	public static void main(String[] args) {
//		testThread();
		testList();
	}

}
