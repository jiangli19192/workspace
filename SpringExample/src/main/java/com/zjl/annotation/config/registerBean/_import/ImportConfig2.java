package com.zjl.annotation.config.registerBean._import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.zjl.annotation.bean.ColorFactoryBean;
import com.zjl.annotation.bean.Person;

@Configuration
public class ImportConfig2 {

	/**
	 * 给容器中注册组件的方式：
	 * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[指针对自已写的可用]
	 * 2）、@Bean[导入的第三方包里面的组件]
	 * 3）、@Import[快速的给容器中导入一个组件]
	 * 		1)、@Import(要导入到容器中的组件):容器中就会自动注册这个组件，id默认是组件的全类名
	 * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
	 * 		3)、ImportBeanDefinitionRegistrar：手动注册Bean到容器中
	 * 4)、使用Spring提供的FactoryBean(工厂Bean)接口
	 * 		1)、默认获取到的工厂bean是调用getObject创建的对象
	 * 		2)、要获取工厂bean本身，我们需要给id前面加一个&符号
	 * 			&colorFactoryBean
	 */
	
	@Lazy
	@Bean("person")
	public Person person() {
		System.out.println("给容器中添加Person...");
		return new Person("lisi", 20);
	}
	
	/**
	 * @Conditional
	 * 
	 * 如果是Windows系统，给容器注册@Bean("bill")
	 * 如果是Linux系统，给容器注册@Bean("linus")
	 */
	@Bean("bill")
	public Person person01() {
		return new Person("Bill Gates", 62);
	}
	
	
	/**
	 * 通过实现Spring提供的FactoryBean接口，注册一个对象
	 * @return
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
