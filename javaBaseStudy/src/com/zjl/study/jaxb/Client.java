package com.zjl.study.jaxb;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Client {
  public static void main(String[] args) throws JAXBException {
	ObjectFactory factory=new ObjectFactory();
	Person person=factory.createPerson();
	Address address=new Address();
	address.setCountry("中国");
	address.setStreet("西湖区");
	address.setHouse("xxx街道xx号");
	person.setAge(22);
	person.setBirthDate(new Date());
	person.setName("cc");
	person.setSex(true);
	person.setTempId(1);
	person.setAddress(address);
	
	List<String> favors=new ArrayList<String>();
	favors.add("吃饭");
	favors.add("睡觉");
	person.setFavors(favors);
	JAXBContext jaxbContext=JAXBContext.newInstance("org.cc.jaxb");
	Marshaller marshaller=jaxbContext.createMarshaller();
	
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	marshaller.setProperty(Marshaller.JAXB_ENCODING, "gbk");

	marshaller.marshal(person, baos);
	    
	StringBuffer sb = new StringBuffer(new String(baos.toByteArray()));
	
	System.out.println(sb.toString());
	
	
	Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
	StringReader reader = new StringReader(sb.toString());
	Person per = (Person)unmarshaller.unmarshal(reader);
	System.out.println(per.getFavors());
}
}
