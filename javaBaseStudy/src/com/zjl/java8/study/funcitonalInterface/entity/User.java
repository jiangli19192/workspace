package com.zjl.java8.study.funcitonalInterface.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
}
