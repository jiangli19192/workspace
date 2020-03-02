package com.zjl.study.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class HelloService {
	
	@RequestMapping("/hello") //提供一个访问接口”/hello”; 访问：http://localhost:8080/hello
    public String hello(){
        return "Hello world!";
    }

	public String getName() {
		return "hello";
	}
}
