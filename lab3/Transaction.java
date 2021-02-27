package lab3;

public class Transaction {
	
	// Objects
	private int theAccount;
	private double theAmount;
	private String toFrom;
	
	// Methods
	public Transaction(String toFrom, int account, double amount) {
		this.toFrom = toFrom;
		theAccount = account;
		theAmount = amount;
	}
	
	public String toString() {
		return String.format("Money transfer: %5s account: %4d : %8.2f", toFrom, theAccount, theAmount);
	}
	
	
}
