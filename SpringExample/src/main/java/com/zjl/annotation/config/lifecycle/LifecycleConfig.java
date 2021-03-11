package com.zjl.annotation.config.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zjl.annotation.bean.Car;

/**
 * bean的生命周期
 * 		bean创建---初始化---销毁的过程
 * 容器管理bean的生命周期
 * 		我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候，来调用我们自定义的初始化和销毁方法
 * 
 * 构造（对象创建）
 * 		单实例：在容器启动的时候创建对象
 * 		多实例：在每次获取的时候创建对象
 * 初始化：
 * 		对象创建完成，并赋值好，调用初始化方法
 * 销毁：
 * 		单实例：容器关闭的时候，销毁对象。
 * 		多实例：容器不会管理这个bean;容器不会调用销毁方法。（注意：多实例对象，容器给创建，不负责销毁。）
 * 
 * 
 * 有四种方式：
 * 		1)、指定初始化和销毁方法
 * 			通过@Bean注解，指定init-method和destory-method
 * ClassName : LifecycleConfig
 * @author 张江立
 * @date 2021年3月11日 下午9:51:13
 *
 */
@Configuration
public class LifecycleConfig {

	// 用initMethod = "init", destroyMethod = "destroy"指定初始化和销毁方法
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Car car() {
		return new Car();
	}
}
