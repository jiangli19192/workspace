package com.zjl.study.spEL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.zjl.study.spEL.mode.Order;
import com.zjl.study.spEL.mode.User;
import com.zjl.study.spEL.util.ParserSPELUtil;

/**
 * 参考地址：http://www.cnblogs.com/best/p/5748105.html SpEL表达式
 */
public class App {
	public static void main(String[] args) {
		// App.test();
		// App.parseStringTest();
		// App.parsePropertyTest();
		// App.parseArrayTest();

	}

	public static void parseArrayTest() {
		EvaluationContext ctx = new StandardEvaluationContext();
		String[] students = new String[] { "tom", "jack", "rose", "mark",
				"lucy" };
		ctx.setVariable("students", students);
		String student = ParserSPELUtil.parseExpressionByContext(
				"#students[3]", ctx, String.class);
		System.out.println("students[3] = " + student);
	}

	/**
	 * User类在前面已定义，这里增加了一个有参构造方法。 
	 * 上面的示例是调用方法，其实可以这样：引用对象属性，只需使用一个句点来表示一个嵌套的属性值
	 * 获取对象属性值有两种方式 第二种方式要注意的是此时#user后不再是一个方法而是.id，直接访问属性，在java中这样做是不行的，便SpEL中允许
	 */
	public static void parsePropertyTest() {
		User user = new User(9527, "周星驰");
		// 解析表达式需要的上下文，解析时有一个默认的上下文
		EvaluationContext context = new StandardEvaluationContext();
		// 在上下文中设置变量，变量名为user，内容为user对象
		context.setVariable("user", user);
		// 从用户对象中获得id并+1900，获得解析后的值在context上下文中
		// Object object =
		// ParserSPELUtil.parseExpressionByContext("#user.getId() + 1900",
		// context);
		Object object = ParserSPELUtil.parseExpressionByContext(
				"#user.id + 1900", context);
		int id = (Integer) object;
		System.out.println("user.id = " + id);
	}

	public static void parseStringTest() {
		// 解析字符串；字符串是由单引号分隔
		ParserSPELUtil.parseString("'Hello '+'World!'");
		// 解析数值
		ParserSPELUtil.parseString("1 + 1");
		// 解析十六进制
		ParserSPELUtil.parseString("0xffffff");
		// 解析实型
		ParserSPELUtil.parseString("1.234345e+3");
		// 解析日期
		ParserSPELUtil.parseString("new java.util.Date()");
		// 调用字符串类型的concat()
		ParserSPELUtil.parseString("'HelloWorld'.concat('!')");
	}

	public static void test() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spel.xml");
		Order order = ctx.getBean("order001", Order.class);
		System.out.println(order);
	}
}
