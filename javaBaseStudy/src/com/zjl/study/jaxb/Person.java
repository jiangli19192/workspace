package com.zjl.study.jaxb;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Person") // 根名叫做Person
@XmlAccessorType(XmlAccessType.FIELD) //非static类型和标明transient的会被处理
public class Person {
    @XmlAttribute //作为属性
	public String name;
    @XmlAttribute //作为属性
    private int age;
    @XmlAttribute //作为属性
	private boolean sex;
    @XmlElement  //作为一个元素
	private Date birthDate;
	@XmlTransient // 标明不处理这个
	private long tempId;
	
	private Address address; //另一个类型的对象
	
	@XmlElementWrapper(name="list") //favors外包一层list
	private List<String> favors;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public long getTempId() {
		return tempId;
	}
	public void setTempId(long tempId) {
		this.tempId = tempId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getFavors() {
		return favors;
	}
	public void setFavors(List<String> favors) {
		this.favors = favors;
	}
}
