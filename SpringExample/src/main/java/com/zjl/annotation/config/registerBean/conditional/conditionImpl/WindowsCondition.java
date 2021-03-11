package com.zjl.annotation.config.registerBean.conditional.conditionImpl;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是Windows系统
 *
 * ClassName : WindowsCondition
 * 
 * @author 张江立
 * @date 2021年2月7日 下午10:44:12
 *
 */
public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 3.获取当前环境信息
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		if (property.contains("Windows")) {
			return true;
		}
		return false;
	}
}
