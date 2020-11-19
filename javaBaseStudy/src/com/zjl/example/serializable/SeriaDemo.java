package com.zjl.example.serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.zjl.example.serializable.entry.Person;

/**
 * 原文链接：https://blog.csdn.net/qq_19782019/java/article/details/80422143
 * ClassName : SeriaDemo
 * @author 张江立
 * @date 2020年6月22日 下午6:21:12
 *
 */
public class SeriaDemo{
	public final static String ROOT = "E:";
	public final static String FILENAME = "serTest.txt";
	
	public static void main(String[] args) throws IOException {
		//实例化一个需要序列化的Person对象
        Person jack = new Person("jack", 12);
        //生成一个文件对象,文件不存在将自动创建文件
        File f = new File(ROOT + File.separator + FILENAME);
        //构造一个对象输出流oos
        ObjectOutputStream oos = null;
        //构造一个文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        //构造对象输出流
        oos = new ObjectOutputStream(fileOutputStream);
        //序列化一个对象到文件变成二进制内容
        oos.writeObject(jack);
        oos.close();
        
        System.out.println("--------------对象序列化完成,并写入至文件中---------------");
	}
}
