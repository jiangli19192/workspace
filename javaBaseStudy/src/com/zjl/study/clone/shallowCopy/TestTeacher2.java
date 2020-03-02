package com.zjl.study.clone.shallowCopy;

public class TestTeacher2 {
	public static void main(String[] args) {
		Student student = new Student("学生1" ,11);
        Teacher2 origin = new Teacher2("老师", 11, student);
        
        
        Teacher2 clone = (Teacher2) origin.clone();
        System.out.println("比较克隆后的引用对象");
        System.out.println(origin.getStudent().getClass() == clone.getStudent().getClass());
        System.out.println(clone.getStudent().getName());
        
        
        Student student2 = new Student("学生2", 12);
        clone.setStudent(student2);
        System.out.println("克隆后，比较克隆对象改变引用");
        System.out.println(origin.getStudent().getClass() == clone.getStudent().getClass());
        System.out.println(origin.getStudent().getName());
        System.out.println(clone.getStudent().getName());
        // 引用类型只会存在一份内存地址，执行object的clone方法拷贝的也是引用的复制（这部分的内存空间不一样，）
        // 但是引用指向的内存空间是一样的，原对象修改引用变量或者浅拷贝对象修改引用变量都会引起双方的变化
        // 重点：综上两个方面可以知道，Object的clone方法是属于浅拷贝，基本变量类型会复制相同值，而引用变量类型也是会复制相同的引用。
	}
}
