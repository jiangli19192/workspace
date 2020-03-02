package com.zjl.java8.study.defaultMethod;

interface Bird {

	default void fly() {
		System.out.println("Bird can fly!");
	}
}