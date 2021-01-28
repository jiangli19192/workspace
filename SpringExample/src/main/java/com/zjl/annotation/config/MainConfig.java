package com.zjl.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zjl.annotation.bean.Person;

/**
 * 配置类==配置文件
 * ClassName : MainConfig
 * @author 张江立
 * @date 2021年1月27日 下午11:40:36
 *
 */
@Configuration // 告诉Spring这是一个配置类
@ComponentScan(value = "com.zjl.annotation") // 开启包扫描配置，等同于配置文件中的<context:component-scan>标签
public class MainConfig {

	// 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	// 如果不想根据方法名做为id，可以使用@Bean("person")指定beanName
	@Bean("person")
	public Person person01() {
		return new Person("zhangsan", 19);
	}
}
