package com.zjl.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
  
@SpringBootApplication
public class StartApp{
	
	public static void main(String[] args) {
		SpringApplication.run(StartApp.class, args); // boot启动的核心方法，使用SpringApplication对象
    }
}
