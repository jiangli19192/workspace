package com.zjl.java8.study.funcitonalInterface.example1;

import com.zjl.java8.study.funcitonalInterface.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserTest {
    public static List<User> users = new ArrayList<>();

    static {
        User user = new User("张三", 15);
        users.add(user);

        User user1 = new User("李四", 26);
        users.add(user1);
    }

    /**
     * 需求1：从所有的用户中 找出 年龄大于15岁的用户
     * @param users
     * @param age
     * @return
     */
    public List<User> findAgeGreaterThan15(List<User> users, int age) {
        List<User> tempUser = new ArrayList<>();

        for (User user : users) {
            if (user == null) {
                continue;
            }

            if (user.getAge() <= age) {
                continue;
            }

            tempUser.add(user);
        }

        return tempUser;
    }

    public static void main(String[] args) {
        UserTest test = new UserTest();
        List<User> findAgeGreaterThan15 = test.findAgeGreaterThan15(users, 15);
        for (User user : findAgeGreaterThan15) {
            System.out.println(user);
        }
    }
}
