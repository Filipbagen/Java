package lab4;

import java.util.*;

public class Director extends Employee {
	
	public ArrayList<Worker> theWorkers;
	

	public Director(String directorFirstName, String directorSirname, int employeeNumber, double salary) {
		super(directorFirstName, directorSirname, employeeNumber, salary);
		theWorkers = new ArrayList<Worker>();
	}
	
	public void addEmployee(Worker worker) {
		theWorkers.add(worker);
	}
	
	public double computeBonus() {
		double bonus = 0.0;
		
		for (Worker w: theWorkers) {
			bonus += w.getSalary();
		}
		
		return 0.1 * bonus;
	}
	
	public double computeTaxes() {
		return 0.25 * (computeBonus() + getSalary());
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
