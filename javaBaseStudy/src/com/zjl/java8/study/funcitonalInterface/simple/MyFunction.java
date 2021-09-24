package com.zjl.java8.study.funcitonalInterface.simple;


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

	/**
	 * 有且仅有一个抽象方法
	 * @param a
	 * @param b
	 * @return c
	 */
	C doSum(A a, B b);

	/**
	 * 第一个默认方法
	 */
	default void doa() {};

	/**
	 * 第二个默认方法
	 * @return
	 */
	default String dao() {
		return "sss";
	};
}