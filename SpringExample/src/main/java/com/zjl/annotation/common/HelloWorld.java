package com.zjl.annotation.common;

import org.springframework.stereotype.Repository;

/**
 * Hello world!
 *
 */
@Repository
public class HelloWorld 
{
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void printHello() {
		System.out.println("Hello ! " + name);
	}
}
