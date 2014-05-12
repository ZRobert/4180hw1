//Robert Payne
//ITCS 4180
//Homework 1 Part One: Print the 10 most repeated words in the file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class PartOne {
	
	public static HashMap<String,Integer> counts = new HashMap<String,Integer>();
	
	public static void main(String[] args) {
		// Include implementation for Part 1, and create all the required classes.
		
		readFileAtPath("src/words.txt");
		convertHashMapToArrayList(counts);

	}
	public static void readFileAtPath(String filename) {
		
		// Lets make sure the file path is not empty or null
		if (filename == null || filename.isEmpty()) {
		System.out.println("Invalid File Path");
		return;
		}
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
					//if the word does not exist in the hashmap, it adds it's key with a value of 1
					if(counts.get(lineContent) == null)
						counts.put(lineContent, new Integer(1));
					//else increments the the value stored at that key by +1
					else
						counts.put(lineContent, Integer.valueOf(counts.get(lineContent).intValue() + 1));
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
		
	}// end of method
	

	public static void convertHashMapToArrayList(HashMap<String, Integer> hm){
		//list1 contains the key values from the hashmap
		//list2 contains word objects made from the hashmap
		ArrayList<String> list1 = new ArrayList<String>(hm.keySet());
		ArrayList<Words> list2 = new ArrayList<Words>(list1.size());
		
		//creates a new Word object for each key/value pair in the hashmap
		for(int i = 0; i < list1.size(); i++)

			list2.add(new Words((String)list1.get(i), Integer.valueOf(hm.get(list1.get(i)))));
		
		Collections.sort(list2); //sort in descending order
		
		//outputs the the list of the most repeated words from 10 to 1
		for(int i = 9; i >= 0; i--)
			
			System.out.println(String.valueOf(i+1) + ": " + list2.get(i));
				
	}//end of method
	

}