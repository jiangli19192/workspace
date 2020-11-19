package com.zjl.study.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorldController {
	
	@RequestMapping("/")
	String startSuccess() {
		return "Spring Boot start success!";
	}
	
	@RequestMapping("/hello") //提供一个访问接口”/hello”; 访问：http://localhost:8080/hello
    public String hello(){
        return "Hello world!";
    }

	@RequestMapping("/hello/{myName}") // 地址内携带方法参数值
	public String getName(@PathVariable String myName) {
		return "Hello " + myName + "!!!";
	}
}
