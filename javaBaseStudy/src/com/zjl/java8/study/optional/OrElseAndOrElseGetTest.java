package com.zjl.java8.study.optional;

import java.util.Optional;

/**
 * orElse()和orElseGet()的区别，其中一点区别就是:
 * orElse(T)无论前面Optional容器是null还是non-null，都会执行orElse里的方法，orElseGet(Supplier)并不会，
 * 如果service无异常抛出的情况下，Optional使用orElse或者orElseGet的返回结果都是一样的
 * 结论：Optional的orElse(T)若方法不是纯计算型的，有与数据库交互或者远程调用的，都应该使用orElseGet()
 * 原文链接：https://blog.csdn.net/liubingyu12345/article/details/78183638
 * <p>
 * optional为空时
 * orElse 会执行，返回orElse中的结果
 * orElseGet 会执行，返回orElseGet中的结果
 * <p>
 * optional有值时
 * orElse 会执行，返回optional的结果
 * orElseGet 不会执行，返回optional的结果
 * <p>
 * 结论
 * 无论optional是否有值，orElse都会被执行
 * 只有optional为空时，orElseGet才会被执行
 * https://blog.csdn.net/bin8632/article/details/103621649
 */
public class OrElseAndOrElseGetTest {
    public static void main(String[] args) {
        orElseAndOrElseGetDistinguish();
    }

    public static void orElseAndOrElseGetDistinguish() {

        System.out.println(Optional.ofNullable(null).orElse("Optional is null, orElse return content 'B String'"));
        System.out.println(Optional.of("A").orElse("B String"));


        System.out.println(Optional.of("A").orElse(B()));
        System.out.println(Optional.of("A").orElseGet(() -> B()));
    }

    static String B() {
        System.out.println("如果此方法，被传入orElse()方法内，不管前面的Optional是null或者not null，都会执行此方法B()...");

        return "B";
    }
}
