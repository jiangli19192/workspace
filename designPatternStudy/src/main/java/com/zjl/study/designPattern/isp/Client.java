package com.zjl.study.designPattern.isp;

/**
 * @author zjl
 */
public class Client {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }
}

interface I1 {
    /**
     * method1
     */
    void method1();
}

interface I2 {
    /**
     * method2
     */
    void method2();

    /**
     * method3
     */
    void method3();
}

interface I3 {
    /**
     * method4
     */
    void method4();

    /**
     * method5
     */
    void method5();
}

/**
 * A 依赖接口中的1,2,3三个方法
 */
class A {
    public void depend1(I1 i) {
        i.method1();
    }
    public void depend2(I2 i) {
        i.method2();
    }
    public void depend3(I2 i) {
        i.method3();
    }
}

class B implements I1, I2 {
    public void method1() {
        System.out.println("method1......");
    }

    public void method2() {
        System.out.println("method2......");
    }

    public void method3() {
        System.out.println("method3......");
    }
}

/**
 * C 依赖接口中的1,4,5三个接口
 */
class C {
    public void depend1(I1 i) {
        i.method1();
    }
    public void depend4(I3 i) {
        i.method4();
    }
    public void depend5(I3 i) {
        i.method5();
    }
}

class D implements I1, I3 {
    public void method1() {
        System.out.println("method1......");
    }

    public void method4() {
        System.out.println("method4......");
    }

    public void method5() {
        System.out.println("method5......");
    }
}
