package com.zjl.study.velocity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

public class VelocityForm extends ActionForm{
	private static final long serialVersionUID = -7382296145868976891L;
	
	private String name;
	private int age;
	private String email;
	private List<String> phones;
	private List<String> telphones;
	private String nullPoint;
	private List<String> addresses;
	private HashMap<String, String> map;
	private HashMap<String, String> map2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNullPoint() {
		return nullPoint;
	}

	public void setNullPoint(String nullPoint) {
		this.nullPoint = nullPoint;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	Map<String, String> getMap() {
		return map;
	}

	void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	Map<String, String> getMap2() {
		return map2;
	}

	void setMap2(HashMap<String, String> map2) {
		this.map2 = map2;
	}

	List<String> getTelphones() {
		return telphones;
	}

	void setTelphones(List<String> telphones) {
		this.telphones = telphones;
	}

}
