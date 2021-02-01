package com.zjl.annotation.config.customFilterType;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * 自定义包扫描过滤规则实现类
 * 
 * 1.必须实现接口org.springframework.core.type.filter.TypeFilter
 * 2.重写接口内的match方法
 * 
 * ClassName : MyFilterType
 * @author 张江立
 * @date 2021年2月1日 下午9:52:48
 *
 */
public class MyFilterType implements TypeFilter{

	/**
	 * MetadataReader: 读取到的当前正在扫描的类的信息
	 * MetadataReaderFactory：获取到其它任何类的信息
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// 获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		// 获取当前正在扫描的类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		// 获取当前类资源（类的路径）
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		return false;
	}

}
