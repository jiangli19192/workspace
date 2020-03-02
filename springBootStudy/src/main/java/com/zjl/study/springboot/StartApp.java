package com.zjl.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration // 开启自动配置
@ComponentScan           // 开启bean扫描
@RestController          // spring mvc的rest控制器方法
@SpringBootApplication
public class StartApp {
	
	public static void main(String[] args) {
        SpringApplication.run(StartApp.class,args); // boot启动的核心方法，使用SpringApplication对象
    }
}
