package com.mysrc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysrc.service.StudentService;

public class MyTester {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		StudentService studentService = (StudentService) context
				.getBean("studentService");
		studentService.doComplexLogic();
	}

}
