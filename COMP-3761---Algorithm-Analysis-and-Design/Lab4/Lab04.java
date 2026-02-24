// COMP 3761 - Lab 04 
// Matthew Simpson 
// June 15th 2025

// Only for the Arrays.toString function 
import java.util.Arrays;

public class Lab04 {

    /**
    * Merge Sort
    */ 
    public static int[] mergeSort(int[] array) {
        
        // If there's one or fewer elements, just return
        if (array.length <= 1) {
            return array;
        }
        
        // Calculate the mid point
        // Integer division is floored already 
        int middle = array.length / 2;

        // Copy left half. Not using built in methods.
        int[] leftHalf = new int[middle];
        for (int i = 0; i < middle; i++) {
            leftHalf[i] = array[i];
        }

        // Copy right half.  Not using built in methods. 
        int[] rightHalf = new int[array.length - middle];
        for (int i = middle; i < array.length; i++) {
            rightHalf[i - middle] = array[i];
        }

        // Call recursively
        int[] sortedLeft = mergeSort(leftHalf);
        int[] sortedRight = mergeSort(rightHalf);

        // Merge the arrays 
        int[] merged = new int[array.length];
        int i = 0, j = 0, k = 0;

        // Compare the elements and copy the smaller
        while (i < sortedLeft.length && j < sortedRight.length) {
            if (sortedLeft[i] <= sortedRight[j]) {
                merged[k++] = sortedLeft[i++];
            } else {
                merged[k++] = sortedRight[j++];
            }
        }

        // Copy anything remaining from the left 
        while (i < sortedLeft.length) {
            merged[k++] = sortedLeft[i++];
        }

        // Copy anything remaining from the right 
        while (j < sortedRight.length) {
            merged[k++] = sortedRight[j++];
        }

        return merged;
    }


    /**
    * Main
    */
    public static void main(String[] args) {
            int[] originalArray = {12, 4, 7, 3, 9, 2, 10};
            int[] sortedArray = mergeSort(originalArray);
        
            System.out.println("Original array: " + Arrays.toString(originalArray));
            System.out.println("Sorted array:   " + Arrays.toString(sortedArray));
        }
    }