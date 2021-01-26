package com.zjl.study.string;

import com.zjl.study.string.entity.Person;


/**
 * 总结 ：== 对于基本类型来说是值比较，对于引用类型来说是比较的是引用；
 * 而 equals 默认情况下是引用比较，只是很多类重写了 equals 方法，比如 String、Integer 等把它变成了值比较，
 * 所以一般情况下 equals 比较的是值是否相等。
 * 
 * 
 * ClassName : StringTest
 * @author 张江立
 * @date 2021年1月23日 下午5:59:48
 *
 */
public class StringTest {
	
	public static void main(String[] args) {
//		simple_example();
		equals_example();
	}
	
	/**
	 * == 解读
	 * 
	 * 对于基本类型和引用类型 == 的作用效果是不同的，如下所示：
	 * 基本类型：比较的是值是否相同；
	 * 引用类型：比较的是引用是否相同；
	 */
	private static void simple_example() {
		String x = "string";
		String y = "string";
		String z = new String("string");
		
		System.out.println(x == y); // true: 因为 x 和 y 指向的是同一个引用，所以 == 也是 true
		System.out.println(x == z); // false: 而 new String()方法则重写开辟了内存空间，所以 == 结果为 false
		
		// 而 equals 比较的一直是值，所以结果都为 true。
		// 原来是 String 重写了 Object 的 equals 方法，把引用比较改成了值比较。
		System.out.println(x.equals(y)); // true
		System.out.println(x.equals(z)); // true
	}
	
	/**
	 * equals 解读
	 * 
	 * equals 本质上就是 ==，只不过 String 和 Integer 等重写了 equals 方法，把它变成了值比较。
	 */
	private static void equals_example() {
		Person person = new Person("name");
		Person person_2 = new Person("name");
		
		System.out.println(person.equals(person_2));// false: 原来Object对象内的 equals 本质上就是 ==。
	}
}
