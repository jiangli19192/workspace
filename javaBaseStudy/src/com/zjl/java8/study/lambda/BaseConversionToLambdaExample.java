package com.zjl.java8.study.lambda;

import com.google.common.collect.Lists;
import com.zjl.java8.study.lambda.entity.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基础实现过渡到Lambda例子
 * @author zjl
 *
 * 需求：有一个List<Person>列表,我们需要获得年龄为70岁的前10个Person的姓名。
 */
public class BaseConversionToLambdaExample {

    public List<Person> fromDB() {
        List<Person> persons = Lists.newArrayList();
        for (int i = 1; i < 20; i++) {
            persons.add(new Person("Person" + i, 70));
        }

        return persons;
    }

    /**
     * 基础实现和Lambda实现比较
     * <p>
     * 两种方案的不同之处：
     * <p>
     * 　　从函数式的角度上看，过程式的代码实现将收集元素、循环迭代、各种逻辑判断耦合在一起，暴露了太多细节。
     * 当未来需求变动和变得更加复杂的情况下，过程式的代码将变得难以理解和维护(需要控制台打印出 年龄为70岁的前10个Person中，姓王的Person的名称）。
     * <p>
     * 　　函数式的解决方案解开了代码细节和业务逻辑的耦合，类似于sql语句，表达的是"要做什么"而不是"如何去做"，
     * 使程序员可以更加专注于业务逻辑，写出易于理解和维护的代码。
     */
    @Test
    public void baseAndLambdaCompareTest() {
        List<String> baseReturnNames = baseImplementation();
        List<String> lambdaReturnNames = lambdaImplementation();

        System.out.println(baseReturnNames.toString());
        System.out.println(lambdaReturnNames.toString());

        Assert.assertEquals(baseReturnNames.size(), lambdaReturnNames.size());
        Assert.assertEquals(baseReturnNames, lambdaReturnNames);
    }

    /**
     * 一个过程式的解决方案(伪代码)
     *
     * @return List<String>
     */
    public List<String> baseImplementation() {
        // 获得List<Person>
        List<Person> personList = fromDB();
        // 限制条件
        int limit = 10;
        // 收集的姓名集合
        List<String> nameList = new ArrayList();
        for (Person personItem : personList) {
            // 满足年龄是70的条件
            if (personItem.getAge() == 70) {
                // 加入姓名集合
                nameList.add(personItem.getName());
                // 判断是否超过限制
                if (nameList.size() >= limit) {
                    break;
                }
            }
        }
        return nameList;
    }

    /**
     * 一种基于stream流的解决方案(伪代码)
     *
     * @return List<String>
     */
    public List<String> lambdaImplementation() {
        // 获得List<Person>
        List<Person> personList = fromDB();
        List<String> nameList = personList.stream()
            // 过滤条件
            .filter(item -> item.getAge() == 70)
            // limit限制条件
            .limit(10)
            // 获得姓名
            .map(item -> item.getName())
            // 转化为list
            .collect(Collectors.toList());

        return nameList;
    }
}
