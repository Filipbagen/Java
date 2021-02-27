package lab1;
public class City {

	// Objects
	private AllBuildings infrastructure;
	private Inhabitants people;
			
	
	// Methods
	public City() { // Constructor
		infrastructure = new AllBuildings();
		people = new Inhabitants();
	}
	
	public void addPerson(String theFirstName, String theLastName, int theAge, String theAddress, int theNumber) {
		
		Person dummy = people.addPerson(theFirstName, theLastName, theAge);
		
		if (dummy != null) {
			Building dummy2 = infrastructure.getBuilding(theAddress, theNumber);
			dummy2.addPerson(dummy);
			dummy.setAdress(dummy2);
			System.out.println("Person added");
			
		} else {
			System.out.println("Person already exists");
		}
	}
	
	
	
	
	
	
	
	
	public void movePerson (String theFirstName, String theLastName, int theAge, String newAddress, int newNumber) {
		Person dummy;
		// see if person already exists
		dummy = people.searchPerson(theFirstName, theLastName, theAge);
		
		if (dummy == null) {
			System.out.println("Person des not exists");
		} else {
			dummy.getAdress().removePerson(dummy);
			Building dummy2 = infrastructure.getBuilding(newAddress, newNumber);
			dummy2.addPerson(dummy);
			dummy.setAdress(dummy2);
		}
		
		infrastructure.cleanUp();
	}
	
	
	
	
	

	public String listBuildings() {
		return infrastructure.toString();
	}
	
	public String listPeople() {
		return people.toString();
	}
	
	public String toString() {		
		return "City statistics: \nNumber of buildings: " + infrastructure.getNumberOfBuildings() + " \nNumber of inhabitants:" + people.getNumberOfPeople();
	}
	
}
