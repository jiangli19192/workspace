package com.zjl.study.object;

/**
 * 自动装箱与拆箱
 * 1、什么是装箱？什么是拆箱？
 * 装箱：基本类型转变为包装器类型的过程。
 * 拆箱：包装器类型转变为基本类型的过程。
 * <p>
 * 2、装箱和拆箱的执行过程？
 * <p>
 * 装箱是通过调用包装器类的 valueOf 方法实现的
 * 拆箱是通过调用包装器类的 xxxValue 方法实现的，xxx代表对应的基本数据类型。
 * 如int装箱的时候自动调用Integer的valueOf(int)方法；Integer拆箱的时候自动调用Integer的intValue方法。
 */
public class AutoBoxingAndUnboxingTest {

    public static void main(String[] args) {
        defined();
        commonProblem();
    }

    /**
     * 自动装箱与拆箱 定义
     */
    private static void defined() {
        //JDK1.5之前是不支持自动装箱和自动拆箱的，定义Integer对象，必须
        Integer i = new Integer(8);

        //JDK1.5开始，提供了自动装箱的功能，定义Integer对象可以这样
        Integer j = 8;

        //自动拆箱
        int n = j;

        System.out.println("i=" + i + "; j=" + j + "; n=" + n);
    }

    /**
     * 常见问题
     */
    private static void commonProblem() {
        // 整型的包装类 valueOf 方法返回对象时，在常用的取值范围内，会返回缓存对象。
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        // Result: true
        System.out.println(i1 == i2);
        // Result: false
        System.out.println(i3 == i4);

        // 浮点型的包装类 valueOf 方法返回新的对象。
        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;
        System.out.println(d1 == d2);//false
        System.out.println(d3 == d4);//false

        // 布尔型的包装类 valueOf 方法 Boolean类的静态常量 TRUE | FALSE。
        Boolean b1 = false;
        Boolean b2 = false;
        Boolean b3 = true;
        Boolean b4 = true;
        System.out.println(b1 == b2);//true
        System.out.println(b3 == b4);//true


        // 包含算术运算会触发自动拆箱。
        // 存在大量自动装箱的过程，如果装箱返回的包装对象不是从缓存中获取，会创建很多新的对象，比较消耗内存。
        Integer s1 = 0;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 10000; i++) {
            s1 += i;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("使用Integer，递增相加耗时：" + (t2 - t1));//使用Integer，递增相加耗时：68


        int s2 = 0;
        long t3 = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 10000; i++) {
            s2 += i;
        }
        long t4 = System.currentTimeMillis();
        System.out.println("使用int，递增相加耗时：" + (t4 - t3));//使用int，递增相加耗时：6
    }
}
