package com.zjl.annotation.config.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.zjl.annotation.bean.Person;
import com.zjl.annotation.config.conditional.conditionImpl.LinuxCondition;
import com.zjl.annotation.config.conditional.conditionImpl.WindowsCondition;
// 满足当前条件，这个类中配置的所有bean注册才能生效;用于统一设置
@Conditional({WindowsCondition.class})
@Configuration
public class ConditionalConfig2 {

	@Scope
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
	
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02() {
		return new Person("linus", 48);
	}
}
