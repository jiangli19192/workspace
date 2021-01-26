package com.zjl.java8.study.funcitonalInterface;


/**
 * 函数接口：有且只有一个抽象方法的接口，也是一个函数，不是一个对象
 * ClassName : MyFunction
 * @author 张江立
 * @date 2020年2月18日 下午9:48:44
 *
 * @param <A>
 * @param <B>
 * @param <C>
 */
@FunctionalInterface
public interface MyFunction<A, B, C> {
	
	C doSum(A a, B b);
	
	default void doa() {};
}

class MyFunctionTest {
	public static void main(String[] args) {
		MyFunction<Integer, Integer, Integer> fun = (a, b) -> (int)a + (int)b;
		System.out.println(fun.doSum(1, 2));
	}
}
