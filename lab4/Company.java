package lab4;

/**
 *@author Mark Dieckmann
 *@version 1.0
 */

import java.util.*;

public class Company extends Object {

	public ArrayList<Employee> allWorkers;
	
	/** The constructor takes no argument */
	public Company() {
		allWorkers = new ArrayList<Employee>();
	}
	
	/** info on fuktion 
	 * @param director hej */
	public void addEmployee(Director director) {
		allWorkers.add(director);
	}
	
	public void addEmployee(Worker worker, Director director) {
		allWorkers.add(worker);
		director.addEmployee(worker);
	}
	
	public String toString() {
		String result;
		
		result = "List of Employees" + "\n";
		result += "---------------------" + "\n";
		
		if (Employee.sortCriterion == 0) {
			result += String.format("%-12s %-12s %-8s", "First name", "Surname", "Number") + "\n";
			
		} else if (Employee.sortCriterion == 1)  {
			result += String.format("%-12s %-12s %-8s %-8s", "First name", "Surname", "Number", "Salary") + "\n";
			
		} else {
			result += String.format("%-12s %-12s %-8s %-8s", "First name", "Surname", "Number", "Taxes") + "\n";
		}
		
		Collections.sort(allWorkers);
		
		for (Employee e: allWorkers) {
			result += e.toString();
		}
		
		return result;
	}
	
}
