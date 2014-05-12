//Robert Payne
//ITCS 4180
//Homework 1 Part Three
//Stores the attributes of a country as it is formatted in the countries-info.txt file
import java.util.HashSet;


public class Country {
	String name = new String();
	String ISO3 = new String();
	String countryNumber = new String();
	String continent = new String();
	String fullName = new String();

	public Country(String line) {
		parseCountry(line);
	}
	private void parseCountry(String line){
		//should parse the user by splitting the line string (comma separated)

		String[] each = line.split(",");
		continent = each[0];
		name = each[1];
		ISO3 = each[2];
		countryNumber = each[3];
		fullName = each[4];
		
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}

	@Override
	public String toString() {
return name;
	}
	
	public HashSet<String> returnHashSet(String name) {
		HashSet<String> newHashSet = new HashSet<String>();
		newHashSet.add(name);
		return newHashSet;
	}
	
	
	
}
