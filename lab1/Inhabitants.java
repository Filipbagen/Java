package lab1;
import java.util.ArrayList;
public class Inhabitants {
	
	// Objects
	private ArrayList<Person> thePeople;
	
	
	// Methods
	public Inhabitants() { // Constructor
		thePeople = new ArrayList<Person> ();
	}
	
	
	public Person addPerson(String theFirstName, String theSecondName, int theAge) {
		Person dummy = searchPerson(theFirstName, theSecondName, theAge);
		
		if (dummy != null) {
			return null;
			
		} else {
			dummy = new Person(theFirstName, theSecondName, theAge);
			thePeople.add(dummy);
			return dummy;
		}
	}

	
	
	public Person searchPerson(String theFirstName, String theSecondName, int theAge) {
		for (int i = 0; i < thePeople.size(); i++) {
			
			if (thePeople.get(i).isPerson(theFirstName, theSecondName, theAge)) {
				return thePeople.get(i);
				
			}
		}
		
		return null;
 	}
	
	

	public String getNumberOfPeople() {
		return "Number of people: " + thePeople.size();
	}
	
	
	
	public String toString() {
		String result = "list of Inhabitants\n";
		
		for (int i = 0; i < thePeople.size(); i++) {
			result += thePeople.get(i).toString() + " \n";
		}
		
		return result;
	}
	
}
