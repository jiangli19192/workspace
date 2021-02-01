package com.zjl.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.zjl.annotation.bean.Person;
import com.zjl.annotation.common.HelloWorld;
import com.zjl.annotation.config.customFilterType.MyFilterType;

/**
 * 配置类==配置文件
 * ClassName : MainConfig
 * @author 张江立
 * @date 2021年1月27日 下午11:40:36
 *
 */
@Configuration // 告诉Spring这是一个配置类
@ComponentScans(value = {
//		@ComponentScan(value = "com.zjl.annotation")
		@ComponentScan(value = "com.zjl.annotation", includeFilters = {
				@Filter(type = FilterType.CUSTOM, classes = {MyFilterType.class})
		}, useDefaultFilters = false)
		,@ComponentScan(value = "com.zjl.annotation", excludeFilters = {
				@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {HelloWorld.class})
		}, useDefaultFilters = false)
})
// 开启包扫描配置，等同于配置文件中的<context:component-scan>标签
// ComponentScan value:指定要扫描的包
// excludeFilters = Filter[]:指定扫描的时候，按照什么样的规则排除哪些组件
// includeFilters = Filter[]:指定扫描的时候，只需要包含哪些组件
// FilterType.ANNOTATION:按照注解，过滤的规则
// FilterType.ASSIGNABLE_TYPE:按照指定类型，过滤的规则
// FilterType.ASPECTJ:使用ASPECTJ表达式，过滤的规则
// FilterType.REGEX:使用正则表达式，过滤的规则
// FilterType.CUSTOM:使用自定义规则
public class MainConfig {

	// 给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	// 如果不想根据方法名做为id，可以使用@Bean("person")指定beanName
	@Bean("person")
	public Person person01() {
		return new Person("zhangsan", 19);
	}
}
