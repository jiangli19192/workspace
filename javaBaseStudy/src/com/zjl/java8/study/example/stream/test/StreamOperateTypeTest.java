package com.zjl.java8.study.example.stream.test;

import com.zjl.java8.study.example.stream.data.Data;
import com.zjl.java8.study.example.stream.data.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * 流的三种操作类型：
 * 1.生成初始流
 * 2.中间操作
 * 3.终止操作
 */
public class StreamOperateTypeTest {

    /**
     * 创建初始流的方式三种
     */
    @Test
    public void initStreamTest() {
        // 第一种
        Stream stream = Stream.of("1", "2", "3");
        // 第二种
        // Collection.stream();
        Stream<Person> stream1 = Data.getData().stream();
        // 第三种
        Arrays.stream(new String[]{"1", "2", "3"});
    }

    /**
     * 中间操作  惰性操作
     */
    @Test
    public void middleOperateTest() {
        Data.getData().stream()
            .filter(person -> {
                System.out.println("person.age = " + person.getAge());
                return person.getAge() > 0;
            });
    }

    /**
     * 终值操作
     */
    @Test
    public void finalValueOperateTest() {
        Data.getData().stream()
            .filter(person -> {
                System.out.println("person.age = " + person.getAge());
                return person.getAge() > 0;
            })
            .toArray();
    }
}
