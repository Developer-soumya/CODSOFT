package com.org;

import java.util.Scanner;

public class Student_Grade_Calculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Student Grade Calculator");
		System.out.println("Enter how many subject you have !");

		int totalSubject=sc.nextInt();
		
		//Calculate total marks in all subjects
		int sumOfAllMarks=0;
		for(int i=1;i<=totalSubject;i++) {
			System.out.print("Enter the name of "+i+" subject  :");
			String subjectName=sc.next();
			System.out.print("Enter your marks in "+subjectName +" (out of 100):");
			int mark=sc.nextInt();
			System.out.println("\n");
			sumOfAllMarks+=mark;
		}
		
		//calculate Average percentage 
		float AvgPercentage=sumOfAllMarks/totalSubject;
		System.out.println("-----------------------------------");
		System.out.println("Your Total marks is :"+ sumOfAllMarks);
		System.out.println("Your Average percentage is :"+AvgPercentage +" %");
		System.out.print("Your Grade is : ");
		
		//Calculate what is your grade on the basis of your AvgPercentage
		if(AvgPercentage >=80) {
			System.out.print("A");
		}else if(AvgPercentage >=60 && AvgPercentage < 80) {
			System.out.println("B");
		}else if(AvgPercentage >=40 && AvgPercentage <60) {
			System.out.println("C");
		}else if(AvgPercentage >=30 && AvgPercentage < 40) {
			System.out.println("D");
		}else {
			System.out.println("Fail");
		}
	}
}
