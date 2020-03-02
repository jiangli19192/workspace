package com.zjl.java8.study.lambda;

@FunctionalInterface
interface MathOperator<T> {

	T operator(T x, T y);
}