package com.zjl.example.callback.test1;

public class B {

    public void methodA(A.ACallBack ac) {
        System.out.println("调用了B中的A方法");
        ac.invoke();
    }
}