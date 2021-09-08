package com.zjl.example.customAnnotation;

@InitClass
public class InitMethodDemo {

    @InitMethod
    public void init() {
        System.out.println("init...");
    }

    @InitMethod
    public void test() {
        System.out.println("test...");
    }
}
