// COMP 3761 - Lab 06-Q3 
// Matthew Simpson 
// July 6th 2025

import java.io.*;
import java.util.*;

public class Lab06Q3 {
	
	/**
	* Read the input file and return keywords and excuses
	*/
	public static List<List<String>> buildInput(File inputFile) {
		ArrayList<String> lines = new ArrayList<>();
		
		try (Scanner s = new Scanner(inputFile)) {
			while (s.hasNextLine()) {
				lines.add(s.nextLine());
			}
		} catch (FileNotFoundException e) {
			throw new Error("File not found", e);
		}
		
		String[] nums = lines.get(0).split(" ");
		int k = Integer.parseInt(nums[0]); // number of keywords
		int e = Integer.parseInt(nums[1]); // number of excuses
		
		ArrayList<String> keywords = new ArrayList<>();
		ArrayList<String> excuses = new ArrayList<>();
		
		for (int i = 1; i <= k; i++) { // lines 1 through k (inclusive) are keywords
			keywords.add(lines.get(i));
		}
		
		for (int j = k + 1; j < k + 1 + e; j++) { // next e lines are excuses
			excuses.add(lines.get(j));
		}
		
		List<List<String>> results = new ArrayList<>();
		results.add(keywords);
		results.add(excuses);
		return results;
	}
	
	/**
	* Count the number of keywords in a given excuse
	*/
	public static int countExcuses(String excuse, List<String> keywords) {
		int count = 0;
		String[] words = excuse.trim().toLowerCase().split(" ");
		
		for (int i = 0; i < words.length; i++) {
			if (keywords.contains(words[i])) {
				count++;
			}
		}
		
		return count;
	}
	
	
	/**
	* get the the highest count from the excuses
	*/
	public static int getMaxCount(Map<String, Integer> counts, List<String> excuses){
		int max = 0;
		for(int i = 0; i<counts.size(); i++){
			String excuse = excuses.get(i);
			int current = counts.get(excuse);
			
			if(current > max){
				max = current;
			}
		}
		
		return max;
	}
	
	/**
	* Print the worst excuse(s)
	*/ 
	public static void printWorst(List<String> excuses, Map<String, Integer> counts, int max){
		for(int j = 0; j < counts.size(); j++){
			String excuse = excuses.get(j);
			int current = counts.get(excuse);
			
			if(current == max){
				System.out.println(excuse);
			}
		}
	}
	
		
	/**
	* Run the functions
	*/
	public static void main(String[] args) {
		
		// Q3
		List<List<String>> input = buildInput(new File("q3test.txt"));
		
		List<String> keywords = input.get(0);
		List<String> excuses = input.get(1);
		
		Map<String, Integer> counts = new HashMap<>();

		for(int i = 0; i < excuses.size(); i++){
			counts.put(excuses.get(i), countExcuses(excuses.get(i), keywords));
		}
		
		int max = getMaxCount(counts, excuses);
		
		printWorst(excuses, counts, max);
		
	}
	
}