package com.zjl.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.zjl.annotation.bean.Person;

/**
 * 配置类==配置文件
 * ClassName : MainConfig
 * @author 张江立
 * @date 2021年1月27日 下午11:40:36
 *
 */
@Configuration // 告诉Spring这是一个配置类
@ComponentScan(value = "com.zjl.annotation", includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false) // 开启包扫描配置，等同于配置文件中的<context:component-scan>标签
// ComponentScan value:指定要扫描的包
// excludeFilters = Filter[]:指定扫描的时候，按照什么样的规则排除哪些组件
// includeFilters = Filter[]:指定扫描的时候，只需要包含哪些组件
public class MainConfig {

	// 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	// 如果不想根据方法名做为id，可以使用@Bean("person")指定beanName
	@Bean("person")
	public Person person01() {
		return new Person("zhangsan", 19);
	}
}
