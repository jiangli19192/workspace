package com.zjl.java8.study.iteration;

import java.util.Arrays;
import java.util.List;

/**
 * 作用：Returns whether any elements of this stream match the provided. 即判断是否至少有一个元素匹配检查条件。
 * @author zjl
 */
public class AnyMatchTest {
    public static void main(String[] args) {
        correctMatchExample();
    }

    private static void correctMatchExample() {
        List<String> list = Arrays.asList("java","c","Python");
        boolean anyMatch = list.stream().anyMatch(obj->obj.endsWith("a"));
        System.out.println(anyMatch);
    }
}
