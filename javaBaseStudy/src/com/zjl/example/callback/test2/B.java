package com.zjl.example.callback.test2;

public class B {

    public void methodA(A a) {
        System.out.println("调用了B中的A方法");
        // A方法中对对象A的B方法进行了调用（这个步骤就是回调）
        a.methodB();
    }
}