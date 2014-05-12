
//Robert Payne
//ITCS 4180
//Homework 1 Part Two
//Stores the user's attributes and implements comparable to sort by age.
public class User implements Comparable<User>{
	private String firstName, middleInitial, lastName;
	private int age;
	private String city, state;

	public User(String line){
		parseUser(line);
	}
		public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}


	private void parseUser(String line){
		//should parse the user by splitting the line string (comma separated)

		String[] each = line.split(",");
		firstName = each[0];
		middleInitial = each[1];
		lastName = each[2];
		age = Integer.valueOf(each[3]);
		city = each[4];
		state = each[5];
		
		
	}

	
	public String toString(){
		return firstName + " " + middleInitial + " " + lastName + " " + Integer.toString(age) + " " + city + " " + state; 
	}


/*	@Override
	public int compare(User arg0, User arg1) {
		// TODO Auto-generated method stub
		System.out.println("Compare called");
		return arg0.getOccurances() - arg1.getOccurances();
	}*/

	@Override
	public int compareTo(User arg0) {
		// TODO Auto-generated method stub
		return  age - arg0.getAge();
	}
	
}
