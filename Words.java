//Robert Payne
//ITCS 4180
//Homework 1 Part One
//Stores the number of times the word has appeared as well as the word itself
//Implements comparable to sort by occurances
public class Words implements Comparable<Words>{
	String word = new String();
	int occurances = 0;
	
	public Words(String word, int occurances){
		this.word = word;
		this.occurances = occurances;
	}
	@Override
	public int compareTo(Words word) {
		
		return word.getOccurances()- occurances;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getOccurances() {
		return occurances;
	}
	public void setOccurances(int occurances) {
		this.occurances = occurances;
	}
	public String toString(){
		return word + " " + String.valueOf(occurances);
	}

}
