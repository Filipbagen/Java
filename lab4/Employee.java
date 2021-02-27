package lab4;

public abstract class Employee extends Object implements Comparable<Employee> {

	public String firstName;
	public String secondName;
	public int employeeNumber;
	public double salary;
	public static int sortCriterion = 0;
	
	public static final int BYNAME = 0;
	public static final int BYSALARY = 1;
	public static final int BYTAXES = 2;
	
	public Employee(String employeeFirstName, String employeeSirname, int employeeNumber, double employeeSalary) {
		firstName = employeeFirstName;
		secondName = employeeSirname;
		this.employeeNumber = employeeNumber;
		salary = employeeSalary;
		
	}
	
	public int getNumber() {
		return employeeNumber;
	}
	
	public String getName() {
		return secondName;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public static void changeCriterion(int num) {
		sortCriterion = num;
	}
	
	public abstract double computeTaxes();
		
	
	public String toString() {
		String result = "";
		
		if (sortCriterion == 0) {
			result += "\n" + String.format("%-12s %-12s %-8s", firstName, secondName, employeeNumber);
			
		} else  if (sortCriterion == 1) {
			result += "\n" + String.format("%-12s %-12s %-8s %-13s", firstName, secondName, employeeNumber, salary);
			
		} else {
			result += "\n" + String.format("%-12s %-12s %-8s %-13s", firstName, secondName, employeeNumber, computeTaxes());
			
		}
		
		return result;
	}
	
}
	
