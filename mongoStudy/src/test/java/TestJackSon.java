import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJackSon {

	// 声明两个转换器
	private ObjectMapper objectMapper = null; // 一般使用ObjectMapper就已足够
	private JsonGenerator jsonGenerator = null; // 需要关闭

	/**
	 * Java对象转换成JSON_1（objectMapper）
	 */
	public void test1() {
		// 实例化转换器
		objectMapper = new ObjectMapper();

		// 测试
		try {
			User user = new User("ZhangSan", 25, "abc@163.com");

			// 直接输出转化结果到服务台，返回void
			System.out.println("直接输出到服务台：");
			objectMapper.writeValue(System.out, user); // user可替换为List,Map等等其他类型,都可正常输出

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Java对象转换成JSON_2（objectMapper）
	 */
	public void test2() {
		// 实例化转换器
		objectMapper = new ObjectMapper();

		// 测试
		try {
			User user = new User("ZhangSan", 25, "abc@163.com");
			// 返回String
			String json = objectMapper.writeValueAsString(user); // user可替换为List,Map等等其他类型,都可正常输出
			System.out.println("返回String：");
			System.out.println(json);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Json转Java对象（objectMapper）
	 */
	public void test3() {
		// 实例化转换器
		objectMapper = new ObjectMapper();

		// 测试
		try {
			String json = "{\"name\":\"ZhangSan\",\"age\":25,\"emailAddress\":\"abc@163.com\"}";
			User user = objectMapper.readValue(json, User.class);

			System.out.println(user.getName() + " | " + user.getAge() + " | "
					+ user.getEmailAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * jsonGenerator的简单使用
	 */
	public void test4() {
		// 实例化转换器
		objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					System.out, JsonEncoding.UTF8);
			User user = new User("ZhangSan", 25, "abc@163.com");

			// 测试
			System.out.println("jsonGenerator:");
			jsonGenerator.writeObject(user); // 直接输出到控制台

			// jsonGenerator需要关闭
			if (jsonGenerator != null) {
				jsonGenerator.flush();
			}
			if (!jsonGenerator.isClosed()) {
				jsonGenerator.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试main
	 */
	public static void main(String[] args) {
		TestJackSon test = new TestJackSon();
		test.test4();
	}

}

class User {

	public String name;

	public int age;

	public String emailAddress;

	/**
	 * 构造函数
	 */
	public User(String name, int age, String emailAddress) {
		super();
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	String getEmailAddress() {
		return emailAddress;
	}

	void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}