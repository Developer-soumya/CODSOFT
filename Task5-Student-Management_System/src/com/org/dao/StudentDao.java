package com.org.dao;

import java.util.ArrayList;

import com.org.dto.Student;

public class StudentDao {

	private ArrayList<Student>listOfStudent;
	
	public StudentDao() {
		 listOfStudent=new ArrayList<Student>();
	}
	
	//Add Student
	public void addStudent(Student std) {
		listOfStudent.add(std);
	}
	
	//Search a student from the list of student
	public Student searchStudent(long rollNo) {
		for(Student std:listOfStudent) {
			if(std.getRollNumber()==rollNo) {
				return std;
			}
		}
		return null;
	}
	//for remove a student object from the list
	public boolean removeStudent(long rollNo) {
		return listOfStudent.removeIf(std->std.getRollNumber()==rollNo);
	}
	
	public void displayAllStudent() {
		if(listOfStudent.isEmpty()) {
			System.out.println("No students to display");
		}else {
			for(Student std:listOfStudent) {
				System.out.println("Name :"+std.getName());
				System.out.println("Age :"+std.getAge());
				System.out.println("Roll Number :"+std.getRollNumber());
				System.out.println("Grade :"+std.getGrade());
				System.out.println("Address :"+std.getAddress());
				System.out.println("*************************");
			}
		}
	}
}
