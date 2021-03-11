package com.zjl.annotation.config.registerBean.conditional.conditionImpl;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是Linux系统
 * ClassName : LinuxCondition
 * @author 张江立
 * @date 2021年2月7日 下午10:43:51
 *
 */
public class LinuxCondition implements Condition{

	/**
	 * ConditionContext:判断条件能使用的上下文（环境）
	 * AnnotatedTypeMetadata:注释信息
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 1.能获取到ioc容器的beanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		// 2.能获取到类加载器
		ClassLoader classLoader = context.getClassLoader();
		// 3.获取当前环境信息
		Environment environment = context.getEnvironment();
		// 4.获取bean定义类的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		
		String property = environment.getProperty("os.name");
		if (property.contains("Linux")) {
			return true;
		}
		return false;
	}

}
