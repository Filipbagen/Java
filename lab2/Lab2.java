package lab2;
import java.io.*;

public class Lab2 {
	
	// Objects
	private static BufferedReader consoleReader;
	private static BufferedReader fileReader;
	private static BufferedWriter fileWriter;
	
	public static void main(String[] args) throws Exception {
		Dictionary myDictionary = new Dictionary();
		
		boolean run = true;
		
		while (run) {
		    switch (consoleInput("Select option: ")) {
		      
		      case "end":
		    	System.out.println("Bye");
		    	run = false;
		      break;
		    	
		      case "1":
		        System.out.println("Load from file");
		        
		        try {
		        	String filename = consoleInput("Filename: ");
		        	
		        	// Read in the one line from the file
		        	fileReader = new BufferedReader(new FileReader(filename));
		        	myDictionary.addWords(fileReader.readLine());
		        	
		        	// If file can't be found
		        } catch(FileNotFoundException e) {
		        	System.out.println("File does not exist");
		        
		        	// In case of a IOException
		        } catch(IOException e) {
		        	System.out.println("IO error");
		        } 
		        break;
		      
		      case "2":
		        System.out.println("List content");
		        Word.changeOutputFormat(Integer.parseInt(consoleInput("Output format (0 or 1): ")));
		        System.out.println(myDictionary.toString());
		        break;
		        
		      case "3":
		        System.out.println("Remove doubles and sort by number of occurences");
		        myDictionary.removeDuplicates();
		        myDictionary.sortDictionaryByCounts();
		        break;
		        
		      case "4":
		        System.out.println("Count occurences");
		        myDictionary.countOccurenses();
		        break;
		        
		      case "5":
		        System.out.println("Save to file");
		        try {
		        	fileWriter = new BufferedWriter(new FileWriter(consoleInput("filename: ")));
		        	fileWriter.write(myDictionary.toString());
		        	fileWriter.close();
		        	
		        } catch(IOException e) {
		        	e.printStackTrace();
		        }
		        break;
		        
		        default:
		        	System.out.println("Try again!");
		    }	
		}
	}
	
	public static String consoleInput(String input) {
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		String answerByUser = input;
		
		
		try {
			System.out.println(input);
			answerByUser = consoleReader.readLine();
			
		} catch(IOException e) {
			return "";
		}
		
		return answerByUser;
	}

}
