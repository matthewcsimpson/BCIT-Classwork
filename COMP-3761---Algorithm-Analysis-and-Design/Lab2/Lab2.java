
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab2
{
	// O(n^2)
	// check each letter from String a, compare each to string b
	static boolean anagram1(String a, String b)
	{
		if((a.length() != b.length()))
			return false;
		
		// make sure the words compare in the same case
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		// use string builder
		StringBuilder checkString = new StringBuilder(b);
		
		// loop over a and compare each char to the chars in b.  
		for(int i = 0; i < a.length(); i++) {
			char checkChar = a.charAt(i);
			int index = checkString.indexOf(String.valueOf(checkChar));
			
			if(index == -1) return false; // if the char isn't in b, they aren't anagrams
			checkString.deleteCharAt(index);
		};
		
		return checkString.length() == 0; // return whether they are anagrams
	}

	// O(n) or O(n log n), I think the sort is n log n
	// compares 2 string after sorting a words alphabetically
	static boolean anagram2(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		
		Arrays.sort(aArray);
		Arrays.sort(bArray);
		
		for(int i = 0; i < aArray.length; i++){
			if(aArray[i] != bArray[i]){
				return false;
			}
		}
		return true;
	}

	// O(n)
	// checks the difference in present ascii indexes, cases ignored
	static boolean anagram3(String a, String b)
	{
		if(a.length() != b.length())
			return false;

		int []ascii = new int[128];
		
		// fill in solution here
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		for(int i = 0; i < a.length(); i++){
			ascii[a.charAt(i)]++;
			ascii[b.charAt(i)]--;
		}
		
		for(int j = 0; j < ascii.length; j++){
			if(ascii[j] != 0){
				return false;
			}
		}
		return true;
	}



	// stores all words read in the file into an array and finds the word with max
	// anagram and its anagram count value
	static void run(String file, int option) throws FileNotFoundException
	{
		double seconds;
		int count[], max = 0;
		String firstword = "";
		double startTime,endTime;

		ArrayList<String> words = new ArrayList<String>();
		Scanner reader = new Scanner(new FileReader(file));

		while(reader.hasNext())
			words.add(reader.next().toLowerCase()); // store everything in lowercase

		count = new int[words.size()];
		startTime = System.currentTimeMillis();

		for(int i = 0; i < words.size(); i++)
			for(int j = i+1; j < words.size(); j++)
				switch(option)
				{
				case 1:
					if(anagram1(words.get(i), words.get(j)))
						count[i]++;
					break;
				case 2:
					if(anagram2(words.get(i), words.get(j)))
						count[i]++;
					break;
				case 3:
					if(anagram3(words.get(i), words.get(j)))
						count[i]++;
					break;
				default:
					break;
				}

		// looks for maximum number of anagrams a word has from the list
		for(int i = 0; i < count.length; i++)
			if(count[i] > max)
				max = count[i];

		endTime = System.currentTimeMillis();
		seconds = (endTime - startTime)/1000.0;

		// looks for first word with highest anagram count
		for(int i = 0; i < count.length; i++)
			if(count[i] == max)
			{
				firstword = words.get(i);
				break;
			}

		if(max > 0)
			System.out.println("Technique #" + option +" : [" + firstword
					+ "] has " + max + " anagrams. Time = "
					+ seconds + " seconds");
		else
			System.out.println("Technique #" + option + " : No anagrams found.");

		reader.close();
	}

	public static void main(String[] args)
	{
		try
		{
			run("Dictionary.txt", 1);
			run("Dictionary.txt", 2);
			run("Dictionary.txt", 3);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("can't find file");
		}
	}

}
