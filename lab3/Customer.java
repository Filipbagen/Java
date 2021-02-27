package lab3;

public class Customer {

	// Objects
	private String name;
	private Current currentAccount;
	private Savings savingsAccount;
	
	// Methods
	public Customer(String CustomerName) { // Constructor
		name = CustomerName;
	}
	
	public String getName() {
		return name;
	}
	
	public Current getCurrentAccount() {
		return currentAccount;
	}
	
	public void addAccounts(Current curAcc, Savings savAcc) {
		currentAccount = curAcc;
		savingsAccount = savAcc;
	}
	
	public String toString() {
		String result;
		
		result = String.format("Name of customer %-16s", name) + "\n";
		
		if (currentAccount != null && savingsAccount != null) {
			result += String.format("Current account %-15s", currentAccount.getNumber()) + "\n";
			result += String.format("Savings account %-15s", savingsAccount.getNumber()) + "\n";
		}
		
		return result;
	}
	
}
