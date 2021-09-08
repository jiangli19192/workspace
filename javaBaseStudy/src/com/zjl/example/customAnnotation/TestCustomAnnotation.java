package com.zjl.example.customAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author zjl
 */
public class TestCustomAnnotation {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.zjl.example.customAnnotation.InitMethodDemo");
        methodApplyAnnotation(clazz);

        classApplyAnnotation(clazz);
    }

    private static void classApplyAnnotation(Class clazz) {
        Annotation annotation = clazz.getAnnotation(InitClass.class);
        if (Objects.isNull(annotation)) {
            System.out.println("类上面没有注解...");
            return;
        }

        System.out.println("类上面有注解...");
    }

    private static void methodApplyAnnotation(Class clazz) throws Exception {
        Method[] methods = clazz.getMethods();
        if (Objects.isNull(methods)) {
            return;
        }

        for (Method method : methods) {
            boolean isInitMethod = method.isAnnotationPresent(InitMethod.class);
//            System.out.println("Method Name:" + method.getName() + ";  Apply Annotation:" + isInitMethod);
            if (isInitMethod) {
                System.out.println(method.getName() + ", 此方法上面有注解，执行方法。");
                method.invoke(clazz.getConstructor(null).newInstance(null));
            }
        }
    }
}
