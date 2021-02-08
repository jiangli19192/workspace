package com.zjl.annotation.config._import;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zjl.annotation.bean.Blue;

public class ImportConfigTest {

	@Test
	public void testImportComponent() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
		printBeans(applicationContext);
		
		/** eclipse列选择: Alt + Shift + A
		 * 打印结果：
		 * importConfig
		 * com.zjl.annotation.bean.Color
		 * com.zjl.annotation.bean.Red
		 * com.zjl.annotation.bean.Blue
		 * com.zjl.annotation.bean.Yellow
		 * person
		 * bill
		 */
		
		Blue blue = applicationContext.getBean(Blue.class);
		System.out.println(blue);
	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for(String name : definitionNames) {
			System.out.println(name);
		}
	}
}
