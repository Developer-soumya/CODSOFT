package com.org;

import java.util.Scanner;

public class ATM_Machine {

	private int pinCode;
	
	private Bank_Account account;
	
	public ATM_Machine(int pinCode,Bank_Account account) {
		this.account=account;
		this.pinCode = pinCode;
	}

	//For verify the pin No(aunthetication)
	public boolean verifyPinCode(int code) {
		if(code==pinCode) {
			return true;
		}
		return false;
	}
	//Check balance from Bank_Account
	public void checkBalance() {
		System.out.println("Your current Balance is : $"+account.getBalance()); 
	}
	
	//Deposite money
	public void depositeMoney(double amount) {
		if(amount >0) {
			account.setBalance(account.getBalance()+amount);
			System.out.println("$"+amount+" deposited Successfully !");
		}else {
			System.out.println("Invalid Deposite amount");
		}
	}
	
	//Withdrow money
	public void withdrawMoney(double amount) {
		double balance = account.getBalance();
		if(amount >0 && amount <=balance) {
			account.setBalance(balance-amount);
			System.out.println("$"+amount+" withdraw successfully !");
		}else if(amount>balance){
			System.out.println("Sorry, You hava Insufficient Balance !");
		}else {
			System.out.println("Invalid withdraw amount !");
		}
	}
	
	public static void main(String[] args) {
		
		ATM_Machine atm=new ATM_Machine(1234,new Bank_Account(10000.00));
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\n");
		System.out.println("************Welcome to ATM Machine*****************");
		boolean exit=false;
		while(!exit) {
			System.out.println("\nChoose a option from (1-4)\n ");
			System.out.println(" 1->Check Balance \n "
					+ "2->Deposite Money \n "
					+ "3->Withdrow Money \n "
					+ "4->Exit  ");
			
			
			int choice=sc.nextInt();
			switch (choice) {
			//for check balance
			case 1: {
				System.out.print("Enter your PIN No :");
				int userEnterPin=sc.nextInt();
				if(atm.verifyPinCode(userEnterPin)) {
					atm.checkBalance();
				}else {
					System.out.println("Incorrect Pin ! try again !");
				}
				break;
			}
			//For Deposite money
			case 2:{
				System.out.print("Enter your PIN No :");
				int userEnterPin=sc.nextInt();
				if(atm.verifyPinCode(userEnterPin)) {
					System.out.println("Enter Deposite amount : ");
					double amount=sc.nextDouble();
					atm.depositeMoney(amount);
				}else {
					System.out.println("Incorrect Pin ! try again !");
				}
				break;
			}
			//For withdraw money
			case 3:{
				System.out.print("Enter your PIN No :");
				int userEnterPin=sc.nextInt();
				if(atm.verifyPinCode(userEnterPin)) {
					System.out.println("Enter withdrawal amount : ");
					double withdrawAmount=sc.nextDouble();
					atm.withdrawMoney(withdrawAmount);
				}else {
					System.out.println("Incorrect Pin ! try again !");
				}
				break;
			}
			//for exit
			case 4:{
				exit=true;
				System.out.println("Thank you for using ATM Machine !");
				break;
			}
			default:
				System.out.println("Invalid Option ! Please try Again !");
			}
			System.out.println("\n");
		}
		sc.close();
	}
}
