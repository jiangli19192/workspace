package com.zjl.java8.study.lambda;

@FunctionalInterface
public interface Hunman {

	public abstract void say(String str);
	
	/**
	 * 接口默认方法
	 * @param str
	 * @return
	 */
	default String hi(String str) {
		return str;
	};
}