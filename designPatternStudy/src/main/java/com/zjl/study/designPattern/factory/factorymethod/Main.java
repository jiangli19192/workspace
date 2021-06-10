package com.zjl.study.designPattern.factory.factorymethod;

import com.zjl.study.designPattern.factory.factorymethod.beans.Car;
import com.zjl.study.designPattern.factory.factorymethod.beans.Moveable;
import com.zjl.study.designPattern.factory.factorymethod.factory.CarFactory;

/**
 * 1.任意定义交通工具
 * 2.任意定义生产过程
 */
public class Main {
    public static void main(String[] args) {
        invoke_1();
        invoke_2();
    }

    private static void invoke_2() {
        Moveable move = new CarFactory().create();
        move.go();
    }

    private static void invoke_1() {
        Moveable move = new Car();
        move.go();
    }
}
