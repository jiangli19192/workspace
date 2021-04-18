package com.zjl.example.callback.test2;

public class A {
    /**
     * 调用B中的方法
     * @param str
     */
    public void methodA(){
        B b = new B();
        System.out.println("调用了A类中的A方法");
        // 调用B的方法A的同时，将对象本身传递给B
        b.methodA(this);
    }
    public void methodB(){
        System.out.println("调用了A类中的B方法");
    }
}