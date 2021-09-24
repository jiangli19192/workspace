package com.zjl.java8.study.funcitonalInterface.example1;

/**
 * 引入了新的注解 @FunctionalInterface
 * 标识一个接口是函数式接口，该接口只能有一个抽象方法，
 * 如果有两个或者两个以上，则编译不通过
 */
@FunctionalInterface
public interface UserInterface {
    boolean filter(int age);
}
