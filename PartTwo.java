//Robert Payne
//ITCS 4180
//Homework 1 Part Two: Print the intersection of the two files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class PartTwo {
	//Hash sets are used to make sure that there are no duplicates in the individual
	//files that can cause erroneous additions to the intersection list
	public static HashSet<String> fileOneContents = new HashSet<String>(); 
	public static HashSet<String> fileTwoContents = new HashSet<String>();
	public static HashSet<String> combinedFileContents = new HashSet<String>();
	public static ArrayList<User> intersectionOfFiles = new ArrayList<User>();
	
	public static void main(String[] args) {
		// Include implementation for Part 2, and create all the required classes.
		readFileAtPath("/src/userList1.txt", fileOneContents);
		//System.out.println(fileOneContents);
		readFileAtPath("/src/userList2.txt", fileTwoContents);
		//System.out.println(fileTwoContents);
		fileIntersection(fileTwoContents, fileOneContents);
		
	}
	public static void readFileAtPath(String filename, HashSet<String> fileContents) {
		
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
					//System.out.println("Found the line: " + lineContent);
					if(!fileContents.add(lineContent))
						;//System.out.println("Found repeat: " + lineContent + " in: " + filename);
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
	}
	
	public static ArrayList<User> fileIntersection(HashSet<String> fileOne, HashSet<String> fileTwo){
		//Converting the first file to an arraylist
		ArrayList<String> firstFile = new ArrayList<String>(fileOne);
		ArrayList<User> intersectArray = new ArrayList<User>();
		
		//iterate over the contents of the first file to see if each of them are contained in the
		//second file's hash. if so, then add into the intersectionArray
		for(int i = 0; i < firstFile.size(); i++) {
			if(fileTwo.contains(firstFile.get(i)))
				intersectArray.add(new User(firstFile.get(i)));
		}
		
		Collections.sort(intersectArray);	//sort the intersect array by age	
		System.out.println("Number users in both files: " + String.valueOf(intersectArray.size()));
		
		for(int i = 0; i < intersectArray.size(); i++)
			System.out.println(intersectArray.get(i));

		return intersectArray;
	}
}