import java.util.*;
import java.io.*;
import java.lang.*;

public class WordArray2 {
	
	// Array storing words
	public String[] array;
	
	// String temporarily storing each word
	public String word;
	
	// Number of words in text file
	public int count;
	
	// constructor
	public WordArray2() {
		Scanner scan = null;
		File file = new File("Words.txt");
		try {
			scan = new Scanner(file);  // Scans wordlist file
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		if (file.exists()) {
			putList(scan);
		}
	}
	
	/**
	* puts words into the array
	*/
	public void putList(Scanner scan) {
		count = 0;
		while (scan.hasNext()) {  // counts how many words in the document for array size
			count++;
			scan.next();
		}
		scan.close(); // close scanner
		
		Scanner scan2 = null;  // new scanner
		File file = new File("Words.txt");
		try {
			scan2 = new Scanner(file);  // Scans wordlist file
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		array = new String[count]; // initializes array
		word = scan2.next();
		int index = 0;
		while (scan2.hasNext()){
			array[index] = word; // puts words in array
			index++;
			word = scan2.next();
		}
		array[count - 1] = word;
		
	}
	
	/**
	* Getter method
	* @param index
	* @return word
	*/
	public String getWord(int index) {
		return array[index];
	}
	
	/**
	* Finds words with certain letters in them (order unspecific)
	* @param letters arbitrary letters that you want to be in your word
	* @return words with said letters in them (order unspecific)
	*/
	public ArrayList<String> wordsWithLetters(String letters) {
		String[] words = array; // array of all possible words
		
		int length = letters.length();

		
		String[] lett = new String[length];
		for (int i = 0; i < length; i++) {
			lett[i] = letters.substring(i, i + 1);  // each desired letter as a string in an array
		}
		
		for (int i = 0; i < count; i++) { // For every word
			for (int j = 0; j < length; j++) { // for every desired letter
				if (!words[i].contains(lett[j])) { // if letter is not in the word
					words[i] = "z"; // remove word
				}
			}
		}
		
		ArrayList<String> desiredWords = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			if (!words[i].equals("z")) {
				desiredWords.add(words[i]);
			}
		}
		desiredWords = sort(desiredWords);
		System.out.println("");
		
		return desiredWords;
	}
	
	/**
	* Given a string of possible letters, returns all words that can be made from
	* the possible letters
	* @param poss all possible letters used in the word
	* @return returns ArrayList with all desired words
	*/
	public ArrayList<String> wordsOutOf(String poss) {
		String[] word = array;
		int possLength = poss.length();
		
		ArrayList<String> des = new ArrayList<String>();
		
		
		for (int i = 0; i < count; i++) { // for all words
		
			String[] lett = new String[possLength];
			for (int h = 0; h < possLength; h++) {
				lett[h] = poss.substring(h, h + 1);  // each possible letter as a string in an array
			}
			
			int length = word[i].length();
			int matchedCount = 0;
			for (int j = 0; j < length; j++) { // for all letters in that word
				
				String letter = word[i].substring(j, j+ 1);
				for (int k = 0; k < possLength; k++) { // for all of the possible letters
					
					if (lett[k].equals(letter)) { // if the letter matches one of the possible letters
						matchedCount++;
						lett[k] = "az";
						break;
					}
				}
				
			}
			if (matchedCount == length) {
				des.add(word[i]);
				
			} else {
				array[i] = "z";
			}
		}
		
		return des;
	}
	
	/**
	* Sorts ArrayList words by length
	* @param des ArrayList with words to be sorted
	* @return 
	*/
	public ArrayList<String> sort(ArrayList<String> des) {
		
		Collections.sort(des, new StringComparator());
		return des;
	}
	
}