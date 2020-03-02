package com.zjl.study.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
	private final static QName _Person_QName =new QName("http://fair-jm.iteye.com","Person");
	private final static QName _Adress_QName =new QName("http://fair-jm.iteye.com","Address");
	
	public Person createPerson(){
		return new Person();
	}
	
	public Address createAddress(){
		return new Address();
	}
	
	@XmlElementDecl(namespace="http://fair-jm.iteye.com",name="Person")
	public JAXBElement<Person> createPerson(Person value){
		return new JAXBElement<Person>(_Person_QName, Person.class, value);
	}
	
	@XmlElementDecl(namespace="http://fair-jm.iteye.com",name="Address")   
	public JAXBElement<Address> createAddress(Address value){
		return new JAXBElement<Address>(_Adress_QName,Address.class,value);
	}
	
}
