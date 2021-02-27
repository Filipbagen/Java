package lab4;

public class Worker extends Employee {

	public Worker(String workerFirstName, String workerSirname, int employeeNumber, double salary) {
		super(workerFirstName, workerSirname, employeeNumber, salary);
	}
	
	public double computeTaxes() {
		return 0.25 * salary;
	}
	
	public int compareTo(Employee employee) {
		if (sortCriterion == 0) {
			return secondName.compareTo(employee.getName());
			
		} else if (sortCriterion == 1) {
			if (employee.getSalary() == this.getSalary()) {
				return 0;
				
			} else if (employee.getSalary() > this.getSalary()) {
				return 1;
				
			} else {
				return -1;
			}
			
		} else {
			if (employee.computeTaxes() == this.computeTaxes()) {
				return 0;
				
			} else if (employee.computeTaxes() < this.computeTaxes()) {
				return -1;
				
			} else {
				return 1;
			}
		}
	}
	
}
