
// COMP 3761 - Lab 06-Q2 
// Matthew Simpson 
// July 6th 2025

import java.io.*;
import java.util.*;

public class Lab06Q2 {
	
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
	* Check if the words are distinct
	*/
	public static Boolean areWordsDistinct(String words){
		HashSet<String> distinctWords = new HashSet<>();
		
		String[] wordList = words.split(" ");
		
		for(int i = 0; i<wordList.length; i++){
			String word = wordList[i].toLowerCase();
			if(!word.isEmpty()){
				if(distinctWords.add(word)){ // if the word is added, great. 
					continue;
				} else {
					return false; // if the word isn't added, it's a duplicate, and the words aren't distinct 
				}
			};
		};
		return true;
	};
	
	/**
	* Run the functions
	*/
	public static void main(String[] args) {
		
		// Q2
		String inputWords = buildInput(new File("love.txt"));
		String d = areWordsDistinct(inputWords) ? "DISTINCT" : "NOT DISTINCT";
		System.out.println(d);
		
	}
	
}