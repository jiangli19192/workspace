package com.zjl.study.designPattern.factory.factorymethod.factory;

import com.zjl.study.designPattern.factory.factorymethod.beans.Car;
import com.zjl.study.designPattern.factory.factorymethod.beans.Moveable;

public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }
}
