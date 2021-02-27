package lab1;
import java.util.ArrayList;

public class Building {
	
	// Objects
	private ArrayList<Person> residents;
	private int number;
	private String streetName;
	
	// Methods
	public Building(String theStreetName, int theNumber) { // Constructor
		 residents = new ArrayList<Person>();
		 streetName = theStreetName;
		 number = theNumber;
	}
	
	
	public boolean addPerson(Person theResidents) {
		boolean exists = false;
		
		for (int i = 0; i < residents.size(); i++) {
			
			if (theResidents == residents.get(i)) {
				exists = true;
			}
		}
		
		if (!exists) {
			residents.add(theResidents);
		}
		
		return !exists;
	}
	


	public void removePerson(Person theResidents) {
		for (int i = 0; i < residents.size(); i++) {
			
			if (theResidents == residents.get(i)) {
				residents.remove(theResidents);
			}
		}	
	}
	
	
	
	public int getNumber() {
		return number;
	}
	
	public String getStreet() {
		return streetName;
	}
	
	public int residents() {
		return residents.size();
		
	}
	
	public String toString() {
		return streetName + " " + number + ", number of residents: " + residents();
	}
	
}
