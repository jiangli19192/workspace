package com.zjl.java8.study.iteration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterTest {

    class Student {
        String stuName;
        int age;
        String country;

        public String getStuName() {
            return stuName;
        }

        public void setStuName(String stuName) {
            this.stuName = stuName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }


    public static void main(String[] args) {
    	FilterTest t = new FilterTest();
        t.test();
        t.test2();
    }

    private void test() {
        //补全代码
    	List<Student> studentList = init();
    	studentList = studentList.stream().filter(student -> student.age > 22).collect(Collectors.toList());
    	
    	studentList.stream().forEach(student -> System.out.println(student.getStuName()));
    }

    private List<Student> init() {
        List<Student> students = new ArrayList<>();
        Student stu = new Student();
        stu.setStuName("stu1");
        stu.setAge(22);
        stu.setCountry("China");
        students.add(stu);
        stu = new Student();
        stu.setStuName("stu2");
        stu.setAge(25);
        stu.setCountry("USA");
        students.add(stu);
        stu = new Student();
        stu.setStuName("stu3");
        stu.setAge(23);
        stu.setCountry("China");
        students.add(stu);
        return students;
    }
    
    private void test2() {
    	
    	Optional<String> name = Optional.of("Sanaulla");
    	
    	//filter方法检查给定的Option值是否满足某些条件。
    	//如果满足则返回同一个Option实例，否则返回空Optional。
    	Optional<String> longName = name.filter((value) -> value.length() > 6);
    	System.out.println(longName.orElse("The name is less than 6 characters"));//输出Sanaulla
    	 
    	//另一个例子是Optional值不满足filter指定的条件。
    	Optional<String> anotherName = Optional.of("Sana");
    	Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
    	//输出：name长度不足6字符
    	System.out.println(shortName.orElse("The name is less than 6 characters"));
    }

}
