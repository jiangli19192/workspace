package com.zjl.study.object;

import com.google.common.base.Objects;


/**
 * guava 复写Object常用方法
 * https://www.cnblogs.com/qdhxhz/p/9404532.html
 * ClassName : ObjectTest
 * @author 张江立
 * @date 2020年11月3日 下午6:28:09
 *
 */
public class ObjectTest {
	public static void main(String[] args) {
		System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a","b"));
        System.out.println(Objects.hashCode("b","a"));
        System.out.println(Objects.hashCode("a","b","c"));
	}
}
