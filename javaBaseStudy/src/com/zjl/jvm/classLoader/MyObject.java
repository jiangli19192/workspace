package com.zjl.jvm.classLoader;

/**
 * 获取类加载器方法例子
 * 第一个考点：JVM有几种类加载器
 * 第二个考点：当前类的父级类加载器是哪种类加载
 * 
 * ClassName : MyObject
 * @author 张江立
 * @date 2020年3月1日 下午7:05:40
 *
 */
public class MyObject {
	public static void main(String[] args) {
		System.out.println("Java自带类：获取加载器例子");
		Object object = new Object();
		/* 由于Object是Java自带的类(属于rt.jar包内)，所以获取的类加载器是启动类加载器（Bootstrap）
		 * 启动类加载器（Bootstrap）由于是由C++语言开发，Java程序是无法调用，所以返结果为：null
		 */
		System.out.println(object.getClass().getClassLoader());
		
		System.out.println();
		System.out.println();
		System.out.println("自定义类：获取加载器例子");
		
		MyObject myObject = new MyObject();
		/**3.
		 * 扩展类加载器的上一级类加载器是启动类加载器（Bootstrap）
		 * 所以输出结果为：null
		 */
		System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
		
		/**2.
		 * 应用程序类加载器的上一级类加载器是扩展类加载器（Extension）
		 * 所以输出结果是：sun.misc.Launcher$ExtClassLoader@15db9742
		 */
		System.out.println(myObject.getClass().getClassLoader().getParent());
		/**1.
		 * MyObject类是我们自己编写的类，是由应用程序类加载器(AppClassLoader)加载
		 * 所以输出结果为：sun.misc.Launcher$AppClassLoader@73d16e93
		 * sun.misc.Launcher：是JVM调用的入口类
		 */
		System.out.println(myObject.getClass().getClassLoader());
	}
}
