package com.org.dto;

public class Student {

	
	private String name;
	
	private long rollNumber;
	
	private String grade;
	
	private int age;

	private String address;

	public Student(String name, long rollNumber, String grade, int age, String address) {
		super();
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(long rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
