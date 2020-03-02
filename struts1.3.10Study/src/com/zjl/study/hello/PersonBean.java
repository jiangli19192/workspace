package com.zjl.study.hello;

public class PersonBean {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	void savePermanence(){
		if(name!=null){
			System.out.println(name);
		}
		else{
			System.out.println("save filled!The personbean doesn't contain name!");
		}
	}
}
