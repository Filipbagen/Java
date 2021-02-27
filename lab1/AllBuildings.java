package lab1;
import java.util.ArrayList;
public class AllBuildings {
	
	// Objects
	private ArrayList<Building> theBuildings;
	
	
		
	
	// Methods
	public AllBuildings() {
		theBuildings = new ArrayList<Building> ();
	}
	
	public Building getBuilding(String address, int number) {
		Building dummy;
		for (int i = 0; i < theBuildings.size(); i++) {
			
			if (address.equals(theBuildings.get(i).getStreet()) && number == theBuildings.get(i).getNumber()) {
				return theBuildings.get(i);
				
			}
		}
		
		dummy = new Building(address, number);
		theBuildings.add(dummy);
		return dummy;
		
	}
	
	public String getNumberOfBuildings() {
		return "Number of buildings: " + theBuildings.size();
	}
	
	public void cleanUp() {
		for (int i = 0; i < theBuildings.size(); i++) {
			if (theBuildings.get(i).residents() == 0) {
				theBuildings.remove(i);
			}
		}
	} 
	
	public String toString() {
		String result = "List of buildings\n";
		
		for (int i = 0; i < theBuildings.size(); i++) {
			result += theBuildings.get(i).toString() + " \n";
		}
		
		return result;
	}

}
