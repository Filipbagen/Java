package lab2;

public class Word {
	
	// Objects
	private String theWord;
	private int counts;
	private static int outputFormat;
	
	// Methods
	public Word(String word) {
		theWord = word;
		counts = 1;
	}
	
	public String getWord() {
		return theWord;
	}
	
	public int getCounts() {
		return counts;
	}
	
	public void increaseCounts() {
		counts++;
	}
	
	public static void changeOutputFormat(int num) {
		if (num == 0) {
			outputFormat = 0;
			
		} else {
			outputFormat = 1;
		}
		
	}
	
	public String toString() {
		if (outputFormat == 0) {
			return "The word " +  "'" + theWord + "'" + " has occured " + counts + " times.";
			
		} else if (outputFormat == 1) {
			return "The word is: " + theWord;
		}
		
		return null;
	}

	
}
