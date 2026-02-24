/**
* COMP 3671 - Algorithms
* Lab 3
* Matthew Simpson / A00820997
* June 8 2025
*/

import java.io.*;
import java.util.*;

public class SpellChecker {

    /**
     * Sequential search algorithm to find each word in the test list within the dictionary.
     * @param dictionary List of words in the dictionary.
     * @param testWords List of words to search for.
     * @return The number of test words not found in the dictionary.
     */
    public static int sequentialSearch(List<String> dictionary, List<String> testWords) {
        int notFoundCount = 0;

        for (int i = 0; i < testWords.size(); i++) {
            String word = testWords.get(i);
            boolean found = false;

            for (int j = 0; j < dictionary.size(); j++) {
                if (word.equals(dictionary.get(j))) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                notFoundCount++;
            }
        }

        return notFoundCount;
    }

    /**
     * Binary search wrapper that uses recursive binary search.
     * @param sortedDictionary A sorted list of dictionary words.
     * @param testWords List of words to search for.
     * @return The number of test words not found in the dictionary.
     */
    public static int binarySearch(List<String> sortedDictionary, List<String> testWords) {
        int notFoundCount = 0;

        for (int i = 0; i < testWords.size(); i++) {
            String word = testWords.get(i);
            if (binarySearch(sortedDictionary, word, 0, sortedDictionary.size() - 1) < 0) {
                notFoundCount++;
            }
        }

        return notFoundCount;
    }

    /**
     * Recursive binary search implementation.
     * @param list Sorted list to search in.
     * @param target The word to search for.
     * @param left Left index of the search range.
     * @param right Right index of the search range.
     * @return Index if found, otherwise -1.
     */
    private static int binarySearch(List<String> list, String target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        String midValue = list.get(mid);

        int comparison = target.compareTo(midValue);
        if (comparison == 0) {
            return mid;
        } else if (comparison < 0) {
            return binarySearch(list, target, left, mid - 1);
        } else {
            return binarySearch(list, target, mid + 1, right);
        }
    }

    /**
     * Reads all words from a file into a list.
     * @param fileName The name of the file to read.
     * @return List of words from the file, or null if error occurs.
     */
    private static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            return null;
        }
        return words;
    }

    public static void main(String[] args) {
        List<String> dictionary = readWordsFromFile("lab3_wordlist.txt");
        List<String> testWords = readWordsFromFile("lab3_testdata.txt");

        if (dictionary == null || testWords == null) {
            System.out.println("Error reading input files.");
            return;
        }

        dictionary.replaceAll(String::toLowerCase);
        testWords.replaceAll(String::toLowerCase);

        long sequentialStart = System.nanoTime();
        int sequentialNotFound = sequentialSearch(dictionary, testWords);
        long sequentialEnd = System.nanoTime();
        double sequentialTimeMicroseconds = (sequentialEnd - sequentialStart) / 1000.0;
        System.out.printf("Sequential search: %d words %.3f Microsecond\n", sequentialNotFound, sequentialTimeMicroseconds);

        Collections.sort(dictionary);
        long binaryStart = System.nanoTime();
        int binaryNotFound = binarySearch(dictionary, testWords);
        long binaryEnd = System.nanoTime();
        double binaryTimeMicroseconds = (binaryEnd - binaryStart) / 1000.0;
        System.out.printf("Binary search: %d words %.3f Microsecond\n", binaryNotFound, binaryTimeMicroseconds);
    }
}