package com.zjl.example.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.zjl.example.serializable.entry.Person;

public class DeSerDemo {
	
    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
        //生成一个文件对象
        File f = new File(SeriaDemo.ROOT + File.separator + SeriaDemo.FILENAME);
        //构建对象输入流对象
        ObjectInputStream oos = null;
        //构建文件输入流对象
        FileInputStream fileOutputStream = new FileInputStream(f);
        oos = new ObjectInputStream(fileOutputStream);
        Person persion = (Person) oos.readObject();
        //读取序列化
        System.out.println(persion);
        
        fileOutputStream.close();
        oos.close();
    }
}