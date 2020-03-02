package com.zjl.study.introspector;

import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * http://blog.csdn.net/zgmzyr/article/details/5753250
 * 相对而言，反射比内省更容易理解一点。用一句比较白的话来概括，
 * 反射就是让你可以通过名称来得到对象 ( 类，属性，方法 ) 的技术，这种技术比内省机制使用范围更广泛。
 * 例如我们可以通过类名来生成一个类的实例；知道了方法名，就可以调用这个方法；知道了属性名就可以访问这个属性的值。 内省是 Java 语言对 Bean 类属性、事件的一种缺省处理方法。例如类 A 中有属性 name, 那我们可以通过 getName,setName 来得到其值或者设置新的值。通过 getName/setName 来访问 name 属性，这就是默认的规则。 Java 中提供了一套 API 用来访问某个属性的 getter/setter 方法，通过这些 API 可以使你不需要了解这个规则（但你最好还是要搞清楚），这些 API 存放于包 java.beans 中。 
一般的做法是通过类 Introspector 来获取某个对象的 BeanInfo 信息，然后通过 BeanInfo 来获取属性的描述器（ PropertyDescriptor ），通过这个属性描述器就可以获取某个属性对应的 getter/setter 方法，然后我们就可以通过反射机制来调用这些方法。下面我们来看一个例子，这个例子把某个对象的所有属性名称和值都打印出来：
 * 
 * 
 * ClassName : myBeanIntrospector
 * @author 张江立
 * @date 2016年11月14日 下午6:15:06
 *
 */

public class myBeanIntrospector {
	public myBeanIntrospector() {
		try {
			// 实例化一个Bean
			bean beanObj = new bean();
			// 依据Bean产生一个相关的BeanInfo类
			BeanInfo bInfoObject = Introspector.getBeanInfo(beanObj.getClass(),
					beanObj.getClass().getSuperclass());
			// 定义一个用于显示的字符串
			String output = "";

			// 开始自省

			/*
			 * BeanInfo.getMethodDescriptors()
			 * 用于获取该Bean中的所有允许公开的成员方法，以MethodDescriptor数组的形式返回
			 * 
			 * MethodDescriptor类 用于记载一个成员方法的所有信息 MethodDescriptor.getName()
			 * 获得该方法的方法名字 MethodDescriptor.getMethod() 获得该方法的方法对象（Method类）
			 * 
			 * Method类 记载一个具体的的方法的所有信息 Method.getParameterTypes()
			 * 获得该方法所用到的所有参数，以Class数组的形式返回
			 * 
			 * Class..getName() 获得该类型的名字
			 */
			output = "内省成员方法：/n";
			MethodDescriptor[] mDescArray = bInfoObject.getMethodDescriptors();
			for (int i = 0; i < mDescArray.length; i++) {
				// 获得一个成员方法描述器所代表的方法的名字
				String methodName = mDescArray[i].getName();

				String methodParams = new String();
				// 获得该方法对象
				Method methodObj = mDescArray[i].getMethod();
				// 通过方法对象获得该方法的所有参数，以Class数组的形式返回
				Class[] parameters = methodObj.getParameterTypes();
				if (parameters.length > 0) {
					// 获得参数的类型的名字
					methodParams = parameters[0].getName();
					for (int j = 1; j < parameters.length; j++) {
						methodParams = methodParams + ","
								+ parameters[j].getName();
					}
				}
				output += methodName + "(" + methodParams + ")/n";
			}
			System.out.println(output);

			/*
			 * BeanInfo.getPropertyDescriptors()
			 * 用于获取该Bean中的所有允许公开的成员属性，以PropertyDescriptor数组的形式返回
			 * 
			 * PropertyDescriptor类 用于描述一个成员属性
			 * 
			 * PropertyDescriptor.getName() 获得该属性的名字
			 * 
			 * PropertyDescriptor.getPropertyType() 获得该属性的数据类型，以Class的形式给出
			 */
			output = "内省成员属性：/n";
			PropertyDescriptor[] mPropertyArray = bInfoObject
					.getPropertyDescriptors();
			for (int i = 0; i < mPropertyArray.length; i++) {
				String propertyName = mPropertyArray[i].getName();
				Class propertyType = mPropertyArray[i].getPropertyType();
				output += propertyName + " ( " + propertyType.getName()
						+ " )/n";
			}
			System.out.println(output);

			/*
			 * BeanInfo.getEventSetDescriptors()
			 * 用于获取该Bean中的所有允许公开的成员事件，以EventSetDescriptor数组的形式返回
			 * 
			 * EventSetDescriptor类 用于描述一个成员事件
			 * 
			 * EventSetDescriptor.getName() 获得该事件的名字
			 * 
			 * EventSetDescriptor.getListenerType() 获得该事件所依赖的事件监听器，以Class的形式给出
			 */
			output = "内省绑定事件：/n";
			EventSetDescriptor[] mEventArray = bInfoObject
					.getEventSetDescriptors();
			for (int i = 0; i < mEventArray.length; i++) {
				String EventName = mEventArray[i].getName();
				Class listenerType = mEventArray[i].getListenerType();
				output += EventName + "(" + listenerType.getName() + ")/n";
			}
			System.out.println(output);
			System.out.println("write by esonghui :");

		} catch (Exception e) {
			System.out.println("异常：" + e);
		}
	}

	public static void main(String[] args) {
		new myBeanIntrospector();
	}
}