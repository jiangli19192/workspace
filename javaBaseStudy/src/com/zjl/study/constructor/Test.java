package com.zjl.study.constructor;

/**
 * 1.构造方法要与类名相同，首字母必须大写
 * 2.
 * ClassName : ConstructorTest
 * @author 张江立
 * @date 2020年2月22日 下午2:04:47
 *
 */
public class Test {
	
	void Test() {
		System.out.println("void Test() {}虽然和类名相同，但是有返回类型，只是一个与类名同名的方法");
	}
	
	/** Illegal modifier for the constuctor in type test; only public, protected & private are permitted.
	 * 类型测试中构造函数的非法修饰符;只允许公共的、受保护的和私有的。
	 */
//	private final Test() {}
//	abstract Test() {}
	/**Return type for the method is missing.
	 * 缺少方法的返回类型。
	 */
//	test() {}
	/**
	 * Multiple markers at this line[此行有多个标记]
	- Syntax error on tokens, delete these tokens[标记语法错误，请删除这些标记]
	- Duplicate method Test() in type Test[类型测试中的重复方法Test()]
	- Syntax error, insert "... VariableDeclaratorId" to complete 
	 */
//	Test(void) {}
	
	/**构造函数Test()从不在本地使用。
	 * The constructor Test() is never used locally.
	 */
	private Test() {}
	
	Test(Test test) {
	}
	
	public static void main(String[] args) {
		Test test = new Test(null);
		test.Test();
	}
}
