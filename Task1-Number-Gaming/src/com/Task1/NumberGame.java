package com.Task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rd=new Random();
		int totalRound=1;
		int totalScore=0;
		//for next Round
		while(true) {
			System.out.println("WELCOME TO NUMBER GAME !!");
			System.out.println("This is your "+totalRound);
			System.out.println("You have 10 attempts");
			int generaredNumber=rd.nextInt(101);
			int attempts=0;
			boolean guess=false;
			
			//For next attempts
			while(attempts <= 10 && !guess) {
				System.out.println("Enter your guess from 1 to 100");
				int guessNumber=sc.nextInt();
				attempts++;
				//Check the guess is correct or not
				if(generaredNumber==guessNumber) {
					guess=true;
					System.out.println("Correct Guess ! you have guess the number in "+attempts+" attempts");
				}else if(guessNumber < generaredNumber) {
					System.out.println("Too low! Try again");
				}else {
					System.out.println("Too High! Try again");
				}
				if(attempts==10 && !guess) {
					System.out.println("Sorry ,you have already finish your attempts .The correct answer was "+generaredNumber);
				}
			}
			totalRound++;
			//Calculate the total score
			if(guess) {
				totalScore+=10-attempts;
			}
			
			System.out.println("Would you like to play again? (yes/no)");
			String choise=sc.next();
			if(choise.toLowerCase().equals("no")) {
				break;
			}
		}
		System.out.println("Thanks for playing! You played " + totalRound + " round(s) and scored " + totalScore + " points.");
		sc.close();
	}
}
