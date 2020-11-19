package com.zjl.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @SpringBootApplication 来标注一个主程序类
 * 说明这是一个spring boot应用
 * ClassName : StartApp
 * @author 张江立
 * @date 2020年11月19日 下午6:44:47
 *
 */
//@EnableAutoConfiguration // 开启自动配置
//@ComponentScan           // 开启bean扫描
//@RestController          // spring mvc的rest控制器方法
@SpringBootApplication
public class StartApp {
	
	public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args); // boot启动的核心方法，使用SpringApplication对象
    }
}
