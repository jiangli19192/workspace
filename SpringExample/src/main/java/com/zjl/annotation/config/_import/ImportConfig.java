package com.zjl.annotation.config._import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.zjl.annotation.bean.Color;
import com.zjl.annotation.bean.Person;
import com.zjl.annotation.bean.Red;
import com.zjl.annotation.config._import.importSelectorImpl.MyImportSelector;
import com.zjl.annotation.config.conditional.conditionImpl.WindowsCondition;

// @Import导入组件，id默认是组件的全类名
/** @Import(Color.class)是导入单个组件 */
//@Import(Color.class)
/** @Import({Color.class, Red.class})是导入多个组件 */
@Import({Color.class, Red.class, MyImportSelector.class})
@Conditional({WindowsCondition.class})
@Configuration
public class ImportConfig {

	/**
	 * 给容器中注册组件的方式：
	 * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[指针对自已写的可用]
	 * 2）、@Bean[导入的第三方包里面的组件]
	 * 3）、@Import[快速的给容器中导入一个组件]
	 * 		1)、@Import(要导入到容器中的组件):容器中就会自动注册这个组件，id默认是组件的全类名
	 * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
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
}
