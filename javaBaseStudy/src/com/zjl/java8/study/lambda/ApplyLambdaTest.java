package com.zjl.java8.study.lambda;

import java.util.Arrays;
import java.util.List;

public class ApplyLambdaTest {
    public static void main(String[] args) {
        commonAndLambdaStyleCompare();

        collectionReverse();
    }

    private static void commonAndLambdaStyleCompare() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("一般写法");
            }
        }).start();

        new Thread(() -> System.out.println("Lambda写法")).start();
    }

    /**
     * 对一个集合从大到小进行排序：
     */
    private static void collectionReverse() {
        List<Integer> list = Arrays.asList(15, -1, 2, 9, 12);
        list.sort((Integer a, Integer b) -> b.compareTo(a));
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
