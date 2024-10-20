package projectbanking;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;


public class Main {
  public static void main(String[] args) {
	
	  Bank bank = new Bank();
	  Scanner sc = new Scanner(System.in);
	  while(true) {
	  System.out.println("   Banking System: ");
	  System.out.println("1. Create Account ");
	  System.out.println("2. Deposit Amount ");
	  System.out.println("3. Withdraw Amount ");
	  System.out.println("4. Check Balance ");
	  System.out.println("5. Exit ");
	  System.out.println("  Choose an option ");
	  
	  
	  int choice = sc.nextInt();
	  sc.nextLine();
	  
	  switch (choice) {
	case 1: 
		System.out.println("Enter Account Number: ");
		String AccountNumber = sc.nextLine();
		System.out.println("Enter AccountHolderName: ");
		String AccountHolderName = sc.nextLine();
		System.out.println("Enter initial balance: ");
		double initialbalance = sc.nextDouble();
		bank.addAccount(new Account (AccountNumber,AccountHolderName,initialbalance));
		System.out.println("Account created Succesfully! ");
		break;
		
	case 2:
		 System.out.println("Enter Account Number: ");
		 AccountNumber = sc.nextLine();
		 System.out.println("Enter Deposit Amount ");
		 double DepositAmount = sc.nextDouble();
		 bank.deposit(AccountNumber, DepositAmount);
		 System.out.println("Deposit Succesfull! ");
		 break;
		 
	case 3:
		 System.out.println("Enter Account Number: ");
		 AccountNumber = sc.nextLine();
		 System.out.println("Enter Withdraw Amount ");
		 double WithdrawAmount = sc.nextDouble();
		 bank.withdraw(AccountNumber, WithdrawAmount);
		 System.out.println("Withdraw Succesful! ");
		 break;
		 
	case 4:
		System.out.print("Enter account number: ");
	    AccountNumber = sc.nextLine();
	    double balance = bank.getBalance(AccountNumber);
	    System.out.println("Current balance: " + balance);
	    break;
	    
	case 5:
		System.out.println("Exiting...");
		//sc.close();
        return;
	default:
		System.out.println("Invalid option. Please try again");
	}
			  
			  
	  }
}
}
