package com.zjl.annotation.config._import.importSelectorImpl;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// 自定义返回需要导入的组件
public class MyImportSelector implements ImportSelector{

	/**
	 * 返回值：就是要导入到容器中的组件全类名
	 * AnnotationMetadata：当前标注@Import注解的类的所有注解信息
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// 方法不要返回null值，可以返回空数组
		return new String[]{"com.zjl.annotation.bean.Blue", "com.zjl.annotation.bean.Yellow"};
	}

}
