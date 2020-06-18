package com.zjl.study.generics;

/**
 * https://www.cnblogs.com/chanshuyi/p/deep_insight_java_generic.html
 * 
 * 通过引入泛型，我们将获得编译时类型的安全和运行时更小地抛出ClassCastExceptions的可能
 * Pair类引入了一个类型变量T，用<>括起来，并放在类名的后面。泛型类可以有多个类型变量。
 * ClassName : Pair
 * @author 张江立
 * @date 2019年3月21日 下午4:11:02
 *
 * @param <T>
 */
public class Pair<T> {
	private T first;
	private T second;

	public Pair() {
		first = null;
		second = null;
	}

	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}

}
