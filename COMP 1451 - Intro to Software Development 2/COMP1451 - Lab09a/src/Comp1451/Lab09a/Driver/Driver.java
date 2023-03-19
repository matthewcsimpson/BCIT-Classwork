package Comp1451.Lab09a.Driver;

import Comp1451.Lab09a.MyArrayList.MyArrayList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyArrayList newList = new MyArrayList();

		System.out.println("how big is the new list?");
		System.out.println(newList.size());
		System.out.println("is it empty? " + newList.isEmpty());
		System.out.println();
		
		// create some objects. 
		Object test1 = new String("testing the first");
		Object test2 = new String("testing the second");
		Object test3 = new String("testing the third");
		Object test4 = new String("testing the fourth");
		// add them to the arraylist
		newList.add(test1);
		newList.add(test2);
		newList.add(test3);
		newList.add(test4);
		System.out.println("How big is it now?");
		System.out.println(newList.size());
		System.out.println("is it empty? " + newList.isEmpty());
		System.out.println();
		System.out.println("what is in the list?");
		for(int i = 0; i < newList.size(); i++) {
			System.out.println(newList.get(i));
		}
		System.out.println();
		//let's remove one. 
		newList.remove(2);
		System.out.println("we removed index 2");
		System.out.println("what is size now?");
		System.out.println(newList.size());
		System.out.println("what is in the list?");
		for(int i = 0; i < newList.size(); i++) {
			System.out.println(newList.get(i));
		}


		
	}

}
