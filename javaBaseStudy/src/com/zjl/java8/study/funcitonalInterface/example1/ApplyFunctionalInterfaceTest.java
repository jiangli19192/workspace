package com.zjl.java8.study.funcitonalInterface.example1;

import com.zjl.java8.study.funcitonalInterface.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * (int a) -> {return a > 15;}
 * 关于Lambda表达式规则：(参数) ->(分割参数和表达式) 表达式
 *
 * 关于参数的写法：参数可以有也可以没有(和定义的接口中，抽象方法的参数列表有关系)
 * 1.没有则可以写成：List<User> findAgeGreater15 = test.findAgeGreater15(users, () -> System.out.println("执行完成"));
 * 2.一个参数可以写成  List<User> findAgeGreater15 = test.findAgeGreater15(users, (int a) -> System.out.println("执行完成"));
 * 或者List<User> findAgeGreater15 = test.findAgeGreater15(users, ( a) -> System.out.println("执行完成"));
 * 当只有一个参数的时候 可以不说明类型，该类型是可导类型
 * 3.多个类型的时候  List<User> findAgeGreater15 = test.findAgeGreater15(users, (int a，int b) -> System.out.println("执行完成"))
 *
 *  关于表达式的写法：主要就是 有无返回值（和定义的接口 参数返回值有关系）：
 *  1.有返回值的写法：必须要有大括号和分号
 *  test.findAgeGreater15(users, (int a) -> { return a > 15; });
 *  2.没有返回值的时候:
 *  test.findAgeGreater15(users, (int a) -> System.out.println("没有返回值"));
 */
public class ApplyFunctionalInterfaceTest {
    public static List<User> users = new ArrayList<>();

    static {
        User user = new User("张三", 15);
        users.add(user);

        User user1 = new User("李四", 26);
        users.add(user1);
    }

    /**
     * 需求1：从所有的用户中 找出 年龄大于15岁的用户
     *
     * @param users
     * @param userInterface
     * @return
     */
    public List<User> findAgeGreaterThan15(List<User> users, UserInterface userInterface) {
        List<User> tempUser = new ArrayList<>();

        for (User user : users) {
            if (user == null) {
                continue;
            }

            if (!userInterface.filter(user.getAge())) {
                continue;
            }

            tempUser.add(user);
        }

        return tempUser;
    }

    public static void main(String[] args) {
        ApplyFunctionalInterfaceTest test = new ApplyFunctionalInterfaceTest();
        List<User> findAgeGreaterThan15 = test.findAgeGreaterThan15(users, (int a) -> a > 15);
        for (User user : findAgeGreaterThan15) {
            System.out.println(user);
        }
    }
}
