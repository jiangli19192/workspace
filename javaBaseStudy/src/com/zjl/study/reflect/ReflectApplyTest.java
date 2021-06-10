package com.zjl.study.reflect;

import com.zjl.study.string.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射获取Class对象的3种方法
 *
 * @author zjl
 */
public class ReflectApplyTest {
    public static void main(String[] args) {
        ReflectApplyTest test = new ReflectApplyTest();

        // 获取Class对象的3种方法
        test.obtainClassObjectThreeMethods();

        // 当我们获得了想要操作的类的Class对象后，
        // 可以通过Class类中的方法获取并查看该类中的方法和属性。
        test.viewMethodAndFieldOfClass();

        //
        test.createObjectTwoMethods();
    }

    public void obtainClassObjectThreeMethods() {
        System.out.println("ReflectApplyTest.obtainClassObjectThreeMethods");
        // 1. 调用某个对象的getClass()方法
        Person p = new Person();
        Class clazz = p.getClass();
        System.out.println("获取类的第一种方法：" + clazz);

        // 2. 调用某个类的class属性来获取该类对应的Class对象
        Class clazz2 = Person.class;
        System.out.println("获取类的第二种方法：" + clazz2);

        // 3.使用Class类中的forName()静态方法（最安全/性能最好）
        // Class clazz3 = Class.forName("类的全路径");
        try {
            Class clazz3 = Class.forName("com.zjl.study.string.entity.Person");
            System.out.println("获取类的第三种方法：" + clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查看该类中的方法和属性
     */
    public void viewMethodAndFieldOfClass() {
        System.out.println("ReflectApplyTest.viewMethodAndFieldOfClass");
        try {
            // 获取Person类的Class对象
            Class clazz = Class.forName("com.zjl.study.string.entity.Person");

            // 获取Person类的所有方法信息
            Method[] declaredMethods = clazz.getDeclaredMethods();
            System.out.println("获取Person类的所有方法信息");
            for (Method method : declaredMethods) {
                System.out.println(method.toString());
            }

            // 获取Person类的所有成员属性信息
            Field[] declaredFields = clazz.getDeclaredFields();
            System.out.println("获取Person类的所有成员属性信息");
            for (Field field : declaredFields) {
                System.out.println(field.toString());
            }

            // 获取Person类的所有构造方法信息
            Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
            System.out.println("获取Person类的所有构造方法信息");
            for (Constructor constructor : declaredConstructors) {
                System.out.println(constructor.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建对象的两种方法
     */
    public void createObjectTwoMethods() {
        Class clazz = null;

        try {
            // 获取Person类的Class对象
            clazz = Class.forName("com.zjl.study.string.entity.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // 使用.newInstance()方法创建对象
            Person p = (Person) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Constructor constructor = null;
        try {
            // 获取构造方法并创建对象
            constructor = clazz.getDeclaredConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 创建对象并设置属性
        try {
            Person p1 = (Person) constructor.newInstance("person姓名");
            System.out.println(p1.getPersonName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
