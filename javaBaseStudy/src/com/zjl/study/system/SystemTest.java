package com.zjl.study.system;

public class SystemTest {

	public static void main(String[] args) {
		get_cpu_processor_num();
	}
	
	public static void get_cpu_processor_num() {
		int processor = Runtime.getRuntime().availableProcessors();
		
		System.out.println("最大可用的CPU核数:" + processor);
	}
}
