package com.zjl.study.xStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.zjl.study.xStream.bean.Student;

public class XStreamTest {
	
	public static void main(String[] args) {
		Student student = new Student("张三", 20);
        XStream xStream = new XStream();//需要XPP3库
        //XStream xStream = new XStream(new DomDriver());//不需要XPP3库
        //XStream xStream = new XStream(new StaxDriver());//不需要XPP3库开始使用Java 6
        //XML序列化
        String xml = xStream.toXML(student);
        System.out.println(xml);
        //XML反序列化
        student = (Student) xStream.fromXML(xml);
        System.out.println(student);

        xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.setMode(XStream.NO_REFERENCES);
        //Json序列化
        String json = xStream.toXML(student);
        System.out.println(json);
        //Json反序列
        student = (Student) xStream.fromXML(json);
        System.out.println(student);
	}
}
