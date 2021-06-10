package com.zjl.study.reflect;

import com.zjl.study.string.entity.Person;

public class ReflectTest {
    public static void main(String[] args) {
        ReflectTest test = new ReflectTest();

        // 获取Class对象的3种方法
        test.obtainClassObjectThreeMethods();
    }

    public void obtainClassObjectThreeMethods() {
        // 1. 调用某个对象的getClass()方法
        Person p = new Person();
        Class clazz = p.getClass();
        System.out.println(clazz);

        // 2. 调用某个类的class属性来获取该类对应的Class对象
        Class clazz2 = Person.class;
        System.out.println(clazz2);

        // 3.使用Class类中的forName()静态方法（最安全/性能最好）
        // Class clazz3 = Class.forName("类的全路径");
        try {
            Class clazz3 = Class.forName("com.zjl.study.string.entity.Person");
            System.out.println(clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
