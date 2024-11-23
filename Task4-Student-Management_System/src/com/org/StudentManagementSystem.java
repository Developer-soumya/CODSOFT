package com.org;

import java.util.Scanner;

import com.org.dao.StudentDao;
import com.org.dto.Student;

public class StudentManagementSystem {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentDao dao=new StudentDao();
		
		while(true) {
			System.out.println("\n--- Student Management System ---");
			System.out.println("1 -> Add Student\n"
					+ "2 -> Remove Student\n"
					+ "3 -> Search for a Student\n"
					+ "4 -> Display All Students\n"
					+ "5 -> Exit ");
			System.out.print("Choose a option from (1-5) :");
			int choice=sc.nextInt();
			switch (choice) {
			case 1: {
				//Add student
				System.out.print("Enter Name :");
				String name=sc.next();
				System.out.print("Enter Roll Number :");
				long roll=sc.nextLong();
				System.out.print("Enter Grade :");
				String grade=sc.next();
				System.out.print("Enter age :");
				int age=sc.nextInt();
				System.out.print("Enter Address :");
				String address=sc.next();
				
				Student std=new Student(name, roll, grade, age, address);
				dao.addStudent(std);
				System.out.println("Student added successfully !");
				break;
			}
			case 2:{
				System.out.print("Enter Roll Number to remove :");
				long roll=sc.nextLong();
				
				if(dao.removeStudent(roll)) {
					System.out.println("Remove successfull !");
				}else {
					System.out.println("Student not found !");
				}
				break;
			}
			case 3:{
				System.out.print("Enter Roll Number for Search :");
				long roll=sc.nextLong();
				Student searchStudent = dao.searchStudent(roll);
				if(searchStudent!=null) {
					System.out.println("\nStudent Details are ");
					System.out.println("Name :"+searchStudent.getName());
					System.out.println("Age :"+searchStudent.getAge());
					System.out.println("Roll Number :"+searchStudent.getRollNumber());
					System.out.println("Grade :"+searchStudent.getGrade());
					System.out.println("Address :"+searchStudent.getAddress());
				}else {
					System.out.println("Student not found !");
				}
				break;
			}
			case 4:{
				System.out.println("\nAll Students Details are");
				dao.displayAllStudent();
				break;
			}
			case 5:{
				System.out.println("Thank you !");
				sc.close();
				return;
			}
			default:
				System.out.println("Invalid choice. Please try again.");
			}
			
		}
	}
}
