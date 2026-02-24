// COMP 3761 - Lab 05 
// Matthew Simpson 
// June 22nd 2025

import java.util.*;

public class Lab05 {
	
	/**
	* Returns the smallest k elements from the input array.
	*/
	public static int[] listLowest(int[] numbers, int k){
		
		if(k == 0 || numbers == null || numbers.length == 0) {
			return new int[0];
		}
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i< numbers.length; i++){
			if(heap.size() < k){
				heap.offer(numbers[i]);
			} else if (numbers[i] < heap.peek()){
				heap.poll();
				heap.offer(numbers[i]);
			}
		}
		
		int[] result = new int[heap.size()];
		int index = 0; 
		for(int number : heap){
			result[index++] = number;
		}
		
		return 	result;
	}
	
	
	public static void main(String[] args) {
		int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
//		int[] input = {};
		int k = 4;
		
		
		int[] result = listLowest(input, k);
		
		
		System.out.println(Arrays.toString(result));
	
	}
	
}


