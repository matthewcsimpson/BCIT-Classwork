// COMP 3761 - Lab 06-Q1 
// Matthew Simpson 
// July 6th 2025

import java.io.*;
import java.util.*;

public class Lab06Q1 {
	
	/**
	* Read the input file and return as a string
	*/
	public static String buildInput(File inputFile){
		StringBuilder input = new StringBuilder();
		
		try(Scanner s = new Scanner(inputFile)) {
			while(s.hasNextLine()){
				input.append(s.nextLine()).append(" ");
			}			
		} catch (FileNotFoundException e){
			throw new Error("File not found", e);
		};
		
		return input.toString();
	};
	
	/**
	* count the words (Q1)
	* Assumption: punctuation has already been removed from the input file
	*/
	public static Map<String, Integer> countWords(String input) {
		Map<String, Integer> count = new HashMap<>();
		String[] wordList = input.split(" ");
		
		for(int i = 0; i<wordList.length; i++){
			String word = wordList[i].toLowerCase();
			if(!wordList[i].isEmpty()){
				count.put(word, count.getOrDefault(word, 0) +1);
			}
		};
		
		return count;
	};
	
	/**
	* sort & output the words alphabetically (Q1)
	*/ 
	public static void outputWords(Map<String, Integer> words){
		ArrayList<String> sorted = new ArrayList<>(words.keySet());
		Collections.sort(sorted);
		
		for(String word:sorted){
			System.out.println(word + " - " + words.get(word));
		}
		
	}
	
	
	
	
	/**
	* Run the functions
	*/
	public static void main(String[] args) {
		
		// Q1
		String loveWords = buildInput(new File("love.txt"));
		Map<String, Integer> countedLoveWords = countWords(loveWords);
		outputWords(countedLoveWords);
			
	}
	
}


