package projectbanking;

public class Account {

	private String AccountNumber;
	private String AccountHolderName;
	private double balance;
	
	
	public Account(String AccountNumber,String AccountHolderName,double balance){
		this.AccountNumber = AccountNumber;
		this.AccountHolderName = AccountHolderName;
		this.balance = balance;		
	}


	public String getAccountNumber() {
		return AccountNumber;
	}


	public String getAccountHolderName() {
		return AccountHolderName;
	}


	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount>0) {
			balance += amount;
		}
	}
	
	public void withdraw(double amount) {
		if(amount>0&&amount<=balance) {
			balance -= amount;
		}
	}
	
}

