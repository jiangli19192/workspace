package com.zjl.study.reflect;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanTest {
	public static void main(String args[]) {
		BeanTest bt = new BeanTest();
		Bean bn = new Bean();
		Object obj = bn;

		bt.test(obj);
	}

	public void test(Object obj) {
		PropertyDescriptor[] pd = PropertyUtils.getPropertyDescriptors(obj);
		System.out.print("属性描述符：" + pd.length);

		for (int i = 0; i < pd.length; i++) {

			String name = pd[i].getName();

			System.out.print(name);
		}
	}
}