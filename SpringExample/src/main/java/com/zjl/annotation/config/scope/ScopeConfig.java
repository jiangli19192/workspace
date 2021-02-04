package com.zjl.annotation.config.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.zjl.annotation.bean.Person;

@Configuration
public class ScopeConfig {
	
	// 默认的都是单实例
	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * ConfigurableBeanFactory#SCOPE_SINGLETON
	 * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * prototype:多实例的
	 * singleton:单实例的（默认值）
	 * request:同一次请求创建一个实例
	 * session:同一个session创建一个实例
	 */
	@Scope
	@Bean("person")
	public Person person() {
		return new Person("lisi", 20);
	}
}
