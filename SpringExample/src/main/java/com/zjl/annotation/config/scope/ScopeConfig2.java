package com.zjl.annotation.config.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.zjl.annotation.bean.Person;

@Configuration
public class ScopeConfig2 {
	
	// 默认的都是单实例
	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * ConfigurableBeanFactory#SCOPE_SINGLETON
	 * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * prototype:多实例的：ioc容器启动并不会去调用方法创建对象到容器中。
	 * 			每次获取的时候才会调用方法创建对象;
	 * singleton:单实例的（默认值）:ioc容器启动会调用方法创建对象到ioc容器中。
	 * 			以后每次获取就是从容器中拿
	 * request:同一次请求创建一个实例
	 * session:同一个session创建一个实例
	 */
	@Scope
	@Bean("person")
	public Person person() {
		System.out.println("给容器中添加Person...");
		return new Person("lisi", 20);
	}
}
