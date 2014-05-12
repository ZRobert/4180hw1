//Robert Payne
//ITCS 4180
//Homework 1 Part Three: Print country names by continent
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;


public class PartThree {
	//Stores all of the countries in a Hashset by continent
	public static HashMap<String,HashSet> countries = new HashMap<String,HashSet>();
	
	public static void main(String[] args) {
		// Include implementation for Part 3, and create all the required classes.
		//Inserts all of the continents and countries into the hashmap
		readFileAtPath("src/countries-info.txt");
		//Formats and prints the countries by continents
		printToConsole();
	}
	
	
	 public static void readFileAtPath(String filename) {
         // Lets make sure the file path is not empty or null
         if (filename == null || filename.isEmpty()) {
                System.out.println("Invalid File Path");
                return; }
         String filePath = System.getProperty("user.dir") + "/" + filename;
         BufferedReader inputStream = null;
         // We need a try catch block so we can handle any potential IO errors
         try {
                try {
                       inputStream = new BufferedReader(new FileReader(filePath));
                       String lineContent = null;
                       // Loop will iterate over each line within the file.
                       // It will stop when no new lines are found.
                       while ((lineContent = inputStream.readLine()) != null) {
                           //creates a new instance of Country object to parse the information  
                    	   Country country = new Country(lineContent);
                             
                             if(countries.containsKey(country.getContinent()))
                            	 //if the continent is already in the hashmap, then we just want to put the country into it's hashset
                            	 countries.get(country.getContinent()).add(country.getName());
                            
                             else 
                            	 //if the continent is not in the hashmap, then we need to add the continent and a new hashset
                            	 countries.put(country.getContinent(), country.returnHashSet((country.getName())));
                             
                       }
}
                // Make sure we close the buffered reader.
                finally {
                       if (inputStream != null)
                             inputStream.close();
                }
         } catch (IOException e) {
                e.printStackTrace();
         }
	 }//end of method
         
	 public static void printToConsole(){
		 	//drop the continent names into an arraylist 
		 	ArrayList<String> continentNames = new ArrayList<String>(countries.keySet());
        	
		 	//iterate over the continent names to format the output and access the hashsets
		 	for(int i = 0; i < continentNames.size(); i++) {
        		//output the current continent
		 		System.out.println("\n"+continentNames.get(i) + ":");
        		System.out.print("\t");
        		
        		//drop the country names for the current continent into an arraylist 
        		ArrayList<String>countryNames = new ArrayList<String>(countries.get(continentNames.get(i)));
        		Collections.sort(countryNames); //sort the country names
        		
        		//formatted output for the countries
        		for(int j = 0; j < countryNames.size()-1; j++) {
        			System.out.print(countryNames.get(j) + ", ");
        		}
        		//print the last country name without a comma following it
        		System.out.print(countryNames.get(countryNames.size()-1));
        	}

         }// end of method
}


