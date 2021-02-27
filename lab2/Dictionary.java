package lab2;

import java.util.ArrayList;

public class Dictionary {
	
	// Objects
	private ArrayList<Word> theDictionary;
	
	// Methods
	public Dictionary() {
		theDictionary = new ArrayList<Word> ();
	}
	
	public void addWords(String words) {
		String input = words;
		String[] result = input.split(" +");
		
		for (int i = 0; i < result.length; ++i) {
			theDictionary.add(new Word(result[i]));
		}
 	}
	
	public int numberOfWords() {
		return theDictionary.size();
	}
	
	public void removeDuplicates() {
		
		for (int i = 0; i < numberOfWords(); ++i) {
			for (int j = i + 1; j < numberOfWords(); ++j) {
				
				if (theDictionary.get(i).getWord().equals(theDictionary.get(j).getWord())) {
					theDictionary.get(i).increaseCounts();
					theDictionary.remove(j);
					j--;
				}
			}
		}
		
	}
	
	public void sortDictionaryByCounts() {
		int slots;
		int counts;
		
		for (int i = 0; i < numberOfWords() - 1; i++) {
			
			slots = i;
			counts = theDictionary.get(i).getCounts();
			
			for (int j = i + 1; j < numberOfWords(); j++) {
				
				if (theDictionary.get(j).getCounts() > counts) {
                    //swap elements  
					slots = j;
					counts = theDictionary.get(j).getCounts(); 
				}
			}
			
			if (slots != i) {
				theDictionary.add(i, theDictionary.get(slots));
				theDictionary.remove(slots + 1);
			}
		}		
	}
	
	
	public void countOccurenses() {
		removeDuplicates();
		sortDictionaryByCounts();
		
		int occurense = 0;
		
		for (int i = 1; i < numberOfWords(); ++i) {
			for (int j = 0; j < numberOfWords(); ++j) {
				
				if (i == theDictionary.get(j).getCounts()) {
					occurense++;
				}

			}

				if (occurense > 0) {
					System.out.println(occurense + " words occured " + i + " times.");
				}		
				
				occurense = 0;
		}		
	}
	
	public String toString() {
		String result = new String();
		for (int i = 0; i < numberOfWords(); i++) {
			result = result + theDictionary.get(i).toString() + "\n";
		}
		return result;
	}
	
}
