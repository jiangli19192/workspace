package com.zjl.java8.study.example.stream.data;

import java.util.Objects;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private int score;
	
	public Person() {
		super();
	}
	public Person(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", score=" + score
				+ "]";
	}
	
	public String getName() {
		return name;
	}
	public Person setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Person setAge(int age) {
		this.age = age;
		return this;
	}
	public int getScore() {
		return score;
	}
	public Person setScore(int score) {
		this.score = score;
		return this;
	}
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + age;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + score;
//		return result;
		return Objects.hash(name, age, score);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	@Override
	public int compareTo(Person o) {
		return this.score - o.score;
	}
	
	
}
