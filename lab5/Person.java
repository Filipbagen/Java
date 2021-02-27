package lab5;

public class Person {
	
	private String givenName, surname;
	private int phoneNumber;
	
	public Person(String thegivenname, String thesurname, int thephonenumber) {
		givenName = thegivenname;
		surname = thesurname;
		phoneNumber = thephonenumber;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getFullName() {
		return givenName + " " + surname;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}

}
