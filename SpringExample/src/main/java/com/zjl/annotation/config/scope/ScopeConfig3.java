package com.zjl.annotation.config.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.zjl.annotation.bean.Person;

/**
 * 懒加载实例
 * ClassName : ScopeConfig3
 * @author 张江立
 * @date 2021年2月4日 下午11:05:14
 *
 */
@Configuration
public class ScopeConfig3 {
	
	// 默认的都是单实例
	/**
	 * Scope的作用是调整作用域
	 * 
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
	 * 
	 * 懒加载：
	 *      针对单实例Bean，默认在容器启动的时候创建对象。
	 *      懒加载@Lazy：容器启动不创建对象。第一次使用(获取)Bean实现时，创建对象，并初始化对象。
	 */
	@Scope
	@Lazy
	@Bean("person")
	public Person person() {
		System.out.println("给容器中添加Person...");
		return new Person("lisi", 20);
	}
}
