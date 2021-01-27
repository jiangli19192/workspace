package com.zjl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zjl.bean.Person;

/**
 * 配置类==配置文件
 * ClassName : MainConfig
 * @author 张江立
 * @date 2021年1月27日 下午11:40:36
 *
 */
@Configuration // 告诉Spring这是一个配置类
public class MainConfig {

	// 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	// 如果不想根据方法名做为id，可以使用@Bean("person")指定beanName
	@Bean("person")
	public Person person01() {
		return new Person("zhangsan", 19);
	}
}
