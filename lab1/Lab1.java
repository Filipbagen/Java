package lab1;

public class Lab1 {

	public static void main(String[] args) {
		
		City theCity = new City();
		// We add people to the city buildings get created whenever we have a new address.
		
		System.out.println("\nPerson 1\n---------");
		theCity.addPerson("Tomas", "Karlsson", 27, "Kungsgatan", 17);
		System.out.println("\nPerson 2\n---------");
		theCity.addPerson("Tomas", "Karlsson", 27, "Kungsgatan", 17);
		System.out.println("\nPerson 3\n---------");
		theCity.addPerson("Fanny", "Johansson", 32, "Kungsgatan", 17);
		System.out.println("\nPerson 4\n---------");
		theCity.addPerson("Torsten", "Svensson", 44, "Kungsgatan", 19);
		System.out.println("\nPerson 5\n---------");
		theCity.addPerson("Anne", "Marklund", 21, "Drottninggatan", 3);
		System.out.println("\nPerson 6\n---------");
		theCity.addPerson("Jakob", "Olsson", 21, "Drottninggatan", 3);
		System.out.println("\nPerson 7\n---------");
		theCity.addPerson("Chantal", "Svensson", 21, "Drottninggatan", 3);
		System.out.println("\nPerson 8\n---------");
		theCity.addPerson("Viveka", "Marklund", 21, "Drottninggatan", 12);
		System.out.println("\nPerson 9\n---------");
		theCity.addPerson("Simon", "Brodin", 70, "Drottninggatan", 12);
		
		System.out.println();
		System.out.println(theCity.listPeople());
		// change here the output format of person to the one with no age.
		Person.changeFormat(Person.NOAGE);
		System.out.println();
		System.out.println(theCity.listPeople());
		
		System.out.println();
		System.out.println(theCity.listBuildings());
		
		System.out.println();
		System.out.println("Moving people\n-------------");
		theCity.movePerson("Torsten", "Svensson", 44, "Drottninggatan", 3);
		theCity.movePerson("Anne", "Marklund", 21, "Drottninggatan", 15);
		
		System.out.println();
		System.out.println(theCity.listPeople());
		
		System.out.println();
		System.out.println(theCity.listBuildings());
		
		System.out.println();
		System.out.println(theCity);
	}

}
