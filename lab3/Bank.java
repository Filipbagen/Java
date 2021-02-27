package lab3;
import java.util.ArrayList;

public class Bank {
	
	// Objects
	private ArrayList<Customer> customerList;
	private ArrayList<Account> accountList;
	private int accountNumber;
	
	// Methods
	public Bank() {
		customerList = new ArrayList<Customer>();
		accountList = new ArrayList<Account>();
		accountNumber = 1000;
	}
	
	public String addCustomer(String name, double sum) {
		
		if (findCustomer(name) != null) {
			return "Customer exists already";
			
		} else {
			Customer c = new Customer(name);
			
			customerList.add(c);
			
			Current myCurrent = new Current(c, accountNumber++, sum);
			Savings mySavings = new Savings(myCurrent, accountNumber++);
			
			c.addAccounts(myCurrent, mySavings);
			accountList.add(myCurrent);
			accountList.add(mySavings);
			
			return "Customer added";
		}
	}
	
	
	public Customer findCustomer(String name) {
		Customer c = null;
		
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getName().equals(name)) {
				c = customerList.get(i);
				break;	
			}
		}
		
		if (c == null) {
			System.out.println("Customer does not exist");
		} 
		
		return c;
		
	}
	
	
	
	
	
	
	public void transfer(String name, double sum) {	
		Customer c = findCustomer(name);
		
		if (c != null) {
			c.getCurrentAccount().transfer(sum);
		}	
	}
	
	
	
	
	public void transfer(String fromName, String toName, double sum) {			
		
		Customer fromCustomer = findCustomer(fromName);
		Customer toCustomer = findCustomer(toName);
		
		fromCustomer.getCurrentAccount().transfer(toCustomer.getCurrentAccount(), sum);
		
	}
	

	public String checkAccount(int accountNumber) {
		
		String result = "Not a current account";
		int Nr = accountNumber - 1000;

		
		if(Nr <= accountList.size()) {

			if (this.accountList.get(Nr).getAccountType().equals("Current")){
				result = accountList.get(Nr).toString();
			}
		}
		return result;
	}
	
	
	
	public void annualChange() {
		
		for (Account a: accountList) {
			a.annualChange();
		}		
	}
	
	
	public String toString() {
		double sum = 0.0;
		
		for (int i = 0; i < accountList.size(); i++) {
			sum += accountList.get(i).balance;
		}
		
		String result = String.format("%12s\n-----------------\n", "\nBank statistics");
		
		result += String.format("%12s %10s\n", "Customers: ", customerList.size());
		result += String.format("%12s %12.2f\n", "Money: ", sum);
		return result;
	}
	
	
	
	
	

}
