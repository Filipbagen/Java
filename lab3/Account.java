package lab3;

public class Account {

	// Objects
	protected int accountNumber;
	protected String accountType;		// Current / Savings
	protected double balance;
	protected Account otherAccount;
	public double FEE, INTEREST;
	
	// Methods
	public Account(int accNum) {
		accountNumber = accNum;
		accountType = "Current";
	}
	
	public Account(int accNum, Current othAcc) {
		otherAccount = othAcc;
		othAcc.otherAccount = this;	// Fattar ej
		accountNumber = accNum;
		accountType = "Savings";
	}
	
	
	public String getAccountType() {
		return accountType;
	}
	
	
	public int getNumber() {
		return accountNumber;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	
	public void annualChange() {
		FEE = 10.0;
		INTEREST = 0.02;
		
		if (accountType.equals("Current")) {
			balance -= FEE;
		}
		
		if (accountType.equals("Savings")) {
			balance += INTEREST;
		}
	}
	
	
}
