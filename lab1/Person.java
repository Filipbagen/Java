package lab1;

public class Person {
	
	// Objects
	private int age;
	private String firstName, secondName;
	private Building address;
	private static boolean theFormat;
	public static final boolean WITHAGE = true;
	public static final boolean NOAGE = false;
	
	
	// Methods
	public Person(String theFirstName, String theSecondName, int theAge) { // Constructor 
		firstName = theFirstName;
		secondName = theSecondName;
		age = theAge;
	}
	
	public void setAdress(Building theAddress) {
		address = theAddress;
	}
	
	public Building getAdress() {
		return address;
	}
	
	public boolean isPerson(String theFirstName, String theSecondName, int theAge) {
		if (firstName == theFirstName && secondName == theSecondName && age == theAge) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public static void changeFormat(boolean Format) {
		theFormat = Format;
	}
	
	public String toString() {
		if (theFormat) {
			return String.format("%-20s%-5s", firstName, secondName, String.valueOf(age));
			
		} else {
			return String.format("%-20s%-5s", firstName, secondName);
		}
	}	

	
}
