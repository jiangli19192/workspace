package com.zjl;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjl.bean.Person;
import com.zjl.config.MainConfig;

public class MainTest {

	public static void main(String[] args) {
//		test_config_file_develop_mode();
		test_config_class_develop_mode();
		
	}
	
	private static void test_config_class_develop_mode() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class); // 现在传入的是配置类的位置
		Person person = applicationContext.getBean(Person.class);
		System.out.println("通过类的类型获取容器内的Person对象：" + person);
		
		// ctrl+2+L这个快捷键可自动补全变更名，注：ctrl和2同时按完以后释放，再快速按L。极大提升编码效率!
		// 通过类的类型获取类的名称
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String beanName : beanNamesForType) {
			System.out.println("通过Bean的类型获取到的类的名称：" + beanName);
		}
	}
	
	/**
	 * 测试配置文件方式开发
	 */
	private static void test_config_file_develop_mode() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml"); // 此处参数传入的是配置文件的位置
		Person person = (Person) applicationContext.getBean("person");
		System.out.println("通过ID获取Spring容器内的Person对象:" + person);
	}
}
