package com.zjl.java8.study.methodReference;

public class InstanceMethodInvoke {
	public static void main(String[] args) {
		Printer p = new Printer();
	    p.print();
	}
}

class Printer {
	 
    void print(){
        System.out.println("instanceRefence::methodName");
    }
 
    private void printInfo(){
        //实例方法引用
        new Thread(this::print);
    }
}
