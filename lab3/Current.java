package lab3;
import java.util.*;

public class Current extends Account {
	
	// Objects
	private Customer theCustomer;
	private ArrayList<Transaction> theTransactions;
	
	// Methods
	public Current(Customer customer, int theAccountNumber, double theBalance) {
		super(theAccountNumber);
		balance = theBalance;
		theCustomer = customer;
		theTransactions = new ArrayList<Transaction>();
	}
	
	
	public Customer getCustomer() {
		return theCustomer;
	}
	
	
	public void transfer(double ammount) {
		double absAmmount = Math.abs(ammount);
		
		if (ammount > 0.0) {
			
			if (balance < absAmmount) {
				absAmmount = balance;
			}
			
			balance -= absAmmount;
			otherAccount.balance += absAmmount;
			theTransactions.add(new Transaction("to", otherAccount.getNumber(), absAmmount));
			
			
		} else if (ammount <= 0.0){
			
			if (otherAccount.getBalance() < absAmmount) {
				absAmmount = otherAccount.balance;
			}
			
			balance += absAmmount;
			otherAccount.balance -= absAmmount;
			theTransactions.add(new Transaction("from", otherAccount.getNumber(), absAmmount));
		}
		
	}
	
	public void deposit(Current account, double sum) {
		balance += sum;
		theTransactions.add(new Transaction("from", account.accountNumber, sum));
	}
	
	public void transfer(Current account, double sum) {
		account.deposit(account, sum);
		balance -= sum;
		theTransactions.add(new Transaction("to", account.accountNumber, sum));
	}

	
	public String toString() {
		String result;
		result =  String.format("%23s %19s\n %21s %15s\n %21s %15s\n %21s %14s\n %1s\n ", 
		"Customer: ", theCustomer.getName(), 
		"Account number:", accountNumber,
		"Balance:", balance, 
		"Savings:", otherAccount.getBalance() , 
		"List of transactions:\n");
		
		for (int i = 0; i < theTransactions.size(); i++){
			result += theTransactions.get(i).toString() + "\n";	
		} 
			
		return result;
	}
	
	
	
}
