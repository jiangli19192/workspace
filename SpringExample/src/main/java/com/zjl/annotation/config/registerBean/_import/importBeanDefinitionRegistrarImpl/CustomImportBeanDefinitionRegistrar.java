package com.zjl.annotation.config.registerBean._import.importBeanDefinitionRegistrarImpl;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.zjl.annotation.bean.RainBow;

public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	/**
	 * AnnotationMetadata:当前类的注解信息
	 * BeanDefinitionRegistry:BeanDefinition注册类
	 * 			把所有需要添加到容器中的bean;调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 判断容器中是否包含com.zjl.annotation.bean.Red Bean定义
		boolean definition = registry.containsBeanDefinition("com.zjl.annotation.bean.Red");
		boolean definition2 = registry.containsBeanDefinition("com.zjl.annotation.bean.Blue");
		
		// 当com.zjl.annotation.bean.Red 和 com.zjl.annotation.bean.Blue两个Bean都有定义时，注册rainBow Bean
		if (definition && definition2) {
			// 指定Bean的定义信息(Bean的类型)
			RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			
			// 注册一个Bean, 指定bean名
			registry.registerBeanDefinition("rainBow", beanDefinition);
		}
		
	}

}
