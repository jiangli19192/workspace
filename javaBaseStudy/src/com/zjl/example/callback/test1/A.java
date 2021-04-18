package com.zjl.example.callback.test1;

/**
 * 原文链接：https://blog.csdn.net/qq_17616169/article/details/75116483
 */
public class A {

    public static ACallBack ac;

    /**
     * 调用B中的方法
     *
     * @param str
     */
    public void methodA() {
        B b = new B();
        System.out.println("调用了A类中的A方法");
        ac = new ACallBack();
        b.methodA(ac);
    }

    public static class ACallBack implements CallBack {
        @Override
        public void invoke() {
            System.out.println("调用了A类中回调类的invoke方法");
        }

    }
}