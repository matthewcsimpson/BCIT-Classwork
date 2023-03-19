/**
 * MyArrayList - an imlementation of an array list based on a Java array.
 * 
 * @author Matthew Simpson / A00820997
 * @version Winter 2019
 */

package a00820997.comp1451.Lab09a.Driver;

import a00820997.comp1451.Lab09a.MyArrayList.MyArrayList;

public class Driver {

	public static void main(String[] args) {

		// here is a string object to set the type of objects allowed in the array
		String controlString = new String();

		// here is a new MyArrayList using that control string
		MyArrayList typeControlledMyArrayList = new MyArrayList(controlString);
		
		System.out.println("What kind of object will this MyArrayList take?");
		System.out.println(typeControlledMyArrayList.getObjectType().getClass().getSimpleName());

		// here are some test objects.
		String testerOne = new String("this is the first test string");
		String testerTwo = new String("this is the second test string");
		String testerThree = new String("this is the third test string");
		String testerFour = new String("this is the fourth test string");

		// and here is another MyArrayList object to use as a test when adding items to
		// the type-controlled MyArrayList
		MyArrayList testerArray = new MyArrayList();

		// ok let's do some testing.
		System.out.println("-----------------------------------------------");
		System.out.println("is the MyArrayList empty: " + typeControlledMyArrayList.isEmpty());
		System.out.println("what is the size of the MyArrayList: " + typeControlledMyArrayList.size());
		System.out.println();

		System.out.println("Ok, let's add our test strings");
		typeControlledMyArrayList.add(testerOne);
		typeControlledMyArrayList.add(testerTwo);
		typeControlledMyArrayList.add(testerThree);
		typeControlledMyArrayList.add(testerFour);
		System.out.println("-----------------------------------------------");
		System.out.println("is the MyArrayList empty: " + typeControlledMyArrayList.isEmpty());
		System.out.println("what is the size of the MyArrayList: " + typeControlledMyArrayList.size());
		System.out.println();

		System.out.println("Ok, now let's try to add a different type of object");
		System.out.println("-----------------------------------------------");
		typeControlledMyArrayList.add(testerArray);
		System.out.println("is the MyArrayList empty: " + typeControlledMyArrayList.isEmpty());
		System.out.println("what is the size of the MyArrayList: " + typeControlledMyArrayList.size());
		System.out.println();

		System.out.println("Super.  Now lets display the contents of the list.");
		System.out.println("I wrote a simple method to do this rather than writing the loop more than once. ");
		System.out.println("-----------------------------------------------");
		typeControlledMyArrayList.displayListContents();
		System.out.println();

		System.out.println("Super duper.  Now lets display the contents at the first index (0) in the list.");
		System.out.println("-----------------------------------------------");
		System.out.println(typeControlledMyArrayList.get(0));
		System.out.println();

		System.out.println("Alrighty.  Now lets remove the first item.");
		System.out.println("-----------------------------------------------");
		System.out.println("the content removed is: " + typeControlledMyArrayList.remove(0));
		System.out.println("is the MyArrayList empty: " + typeControlledMyArrayList.isEmpty());
		System.out.println("what is the size of the MyArrayList: " + typeControlledMyArrayList.size());
		System.out.println();

		System.out.println("And lets display the contents of the list again.");
		System.out.println("-----------------------------------------------");
		typeControlledMyArrayList.displayListContents();
		System.out.println();

		System.out.println("Let's do one more quick test run with a different object type (Integer) just for funsies");
		System.out.println("-----------------------------------------------");

		// here is a string object to set the type of objects allowed in the array
		Integer controlInt = Integer.valueOf(0);

		// here is a new MyArrayList using that control Integer
		MyArrayList typeControlledMyArrayListInt = new MyArrayList(controlInt);
		System.out.println("What kind of object will this MyArrayList take?");
		System.out.println(typeControlledMyArrayListInt.getObjectType().getClass().getSimpleName());
		System.out.println("-----------------------------------------------");
		System.out.println();


		// here are some test objects.
		Integer intOne = Integer.valueOf(1);
		Integer intTwo = Integer.valueOf(2);
		Integer intThree = Integer.valueOf(3);
		Integer intFour = Integer.valueOf(4);
		typeControlledMyArrayListInt.add(intOne);
		typeControlledMyArrayListInt.add(intTwo);
		typeControlledMyArrayListInt.add(intThree);
		typeControlledMyArrayListInt.add(intFour);
		System.out.println("is the MyArrayList empty: " + typeControlledMyArrayListInt.isEmpty());
		System.out.println("what is the size of the MyArrayList: " + typeControlledMyArrayListInt.size());
		typeControlledMyArrayListInt.displayListContents();
		System.out.println();
		
		System.out.println("Ok, now let's try to add a a String and that blank MyArrayList to our Integer list");
		System.out.println("-----------------------------------------------");
		typeControlledMyArrayListInt.add(testerOne);
		typeControlledMyArrayListInt.add(testerArray);

		System.out.println("is the MyArrayList empty: " + typeControlledMyArrayListInt.isEmpty());
		System.out.println("what is the size of the MyArrayList: " + typeControlledMyArrayListInt.size());
		System.out.println();
		
		System.out.println("Cool.  Now lets remove the third item.");
		System.out.println("-----------------------------------------------");
		System.out.println("the content removed is: " + typeControlledMyArrayListInt.remove(2));
		System.out.println("is the MyArrayList empty: " + typeControlledMyArrayListInt.isEmpty());
		System.out.println("what is the size of the MyArrayList: " + typeControlledMyArrayListInt.size());
		typeControlledMyArrayListInt.displayListContents();
		System.out.println();
		

		// lab09a driver details. -------------------

//		MyArrayList newList = new MyArrayList();
//
//		System.out.println("how big is the new list?");
//		System.out.println(newList.size());
//		System.out.println("is it empty? " + newList.isEmpty());
//		System.out.println();
//		
//		// create some objects. 
//		Object test1 = new String("testing the first");
//		Object test2 = new String("testing the second");
//		Object test3 = new String("testing the third");
//		Object test4 = new String("testing the fourth");
//		// add them to the arraylist
//		newList.add(test1);
//		newList.add(test2);
//		newList.add(test3);
//		newList.add(test4);
//		System.out.println("How big is it now?");
//		System.out.println(newList.size());
//		System.out.println("is it empty? " + newList.isEmpty());
//		System.out.println();
//		System.out.println("what is in the list?");
//		for(int i = 0; i < newList.size(); i++) {
//			System.out.println(newList.get(i));
//		}
//		System.out.println();
//		//let's remove one. 
//		newList.remove(2);
//		System.out.println("we removed index 2");
//		System.out.println("what is size now?");
//		System.out.println(newList.size());
//		System.out.println("what is in the list?");
//		for(int i = 0; i < newList.size(); i++) {
//			System.out.println(newList.get(i));
//		}

	}

}
