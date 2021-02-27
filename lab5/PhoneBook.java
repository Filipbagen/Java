package lab5;

import java.io.*;
import java.util.*;


public class PhoneBook {
	
	private static BufferedReader fileReader;
	private static BufferedWriter fileWriter;

	private ArrayList<Person> listOfNumbers; 
	
	public PhoneBook() {		
		listOfNumbers = new ArrayList<Person>();
	}
	
	public String load(String filename) {
		
		try {
        	
        	// Read in every line from the file
        	fileReader = new BufferedReader(new FileReader(filename));

        	String line;
        	while ((line = fileReader.readLine()) != null) {
        		String[] info = line.split(" +");
        		
        		listOfNumbers.add(new Person(info[0], info[1], Integer.valueOf(info[2])));
        	}

        	        	
        	return "Phone book loaded";
        	
        	// If file can't be found
        } catch(FileNotFoundException e) {
        	return "File does not exist";
        
        	// In case of a IOException
        } catch(IOException e) {
        	return "IO error";
        } 
		
	}
	
	public ArrayList<Person> search(String info) {	
		ArrayList<Person> searchResult = new ArrayList<Person>();
		boolean isNumber;
		
		try {  
		    Double.parseDouble(info);  
		    isNumber = true;
		  } catch(NumberFormatException e){  
		    isNumber = false;  
		  }  
		
		
		if (isNumber) {
			for (Person p: listOfNumbers) {
				if (Integer.parseInt(info) == p.getPhoneNumber()) {
					searchResult.add(p);
				}
			}
			
		} else {
			for (Person p: listOfNumbers) {
				if (p.getSurname().equals(info)) {
					searchResult.add(p);
				}
			}
		}
		
		
		return searchResult;
	}
	
	
	
	public String deletePerson(String fullName, int phoneNumber) {
		boolean deleted = false;
		
		ArrayList<Person> sameNumber = search(String.valueOf(phoneNumber));
		
		for (Person p: sameNumber) {
			if (p.getFullName().equals(fullName)) {
				listOfNumbers.remove(p);
				deleted = true;
				break;
			}
		}
		
		
		if (deleted) {
			return "Person deleted";
			
		} else {
			return "The person/number does not exist";
		}
		
	}
	
	
	
	public boolean addPerson(String fullName, int number) {
		boolean addable = true;
		
		
		if (fullName.split(" +").length != 2) {
			addable = false;
		}
		
		for (Person p: listOfNumbers) {
			if (p.getPhoneNumber() == number) {
				addable = false;
			}
		}
		
		if (addable) {
			String [] name = fullName.split(" +");
			listOfNumbers.add(new Person(name[0], name[1], number));
		}
		
		return addable;
	}
	
	
	public String save(String filename) {
		
        try {
        	fileWriter = new BufferedWriter(new FileWriter(filename));
        	
        	for (Person p: listOfNumbers) {
        		fileWriter.write(String.format("%-20s %-5s", p.getFullName(), p.getPhoneNumber() + "\n"));
        	}
       
        	fileWriter.close();
        	
        	return "Saved " + listOfNumbers.size() + " people to the file"; 
        	
        } catch(IOException e) {
        	e.printStackTrace();
        	return "Could not save the file";
        }
		
	} 
	
	
}
