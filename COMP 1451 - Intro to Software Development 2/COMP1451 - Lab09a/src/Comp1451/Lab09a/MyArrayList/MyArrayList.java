package Comp1451.Lab09a.MyArrayList;

/**
 * MyArrayList - an imlementation of an array list based on a Java array.
 * 
 * @author Matthew Simpson / A00820997
 * @version Winter 2019
 */
public class MyArrayList implements MyList {
	private Object[] theList; // array of objects

	/**
	 * Constructor - start with an empty array
	 */
	public MyArrayList() {
		theList = new Object[0];
	}

	/**
	 * Adds a new element at the end of the list.
	 * 
	 * @param the object to add
	 * @return true if element successfully added, false if parameter is null
	 */
	public boolean add(Object toAdd) {
		boolean temp = false;
		if (toAdd != null) {
			int checkSize = theList.length;
			checkSize++;
			Object[] newList = new Object[checkSize];
			for (int i = 0; i < theList.length; i++) {
				newList[i] = theList[i];
			}
			int checkSize2 = newList.length;
			checkSize2--;
			newList[checkSize2] = toAdd;
			theList = newList;
			int checkSize3 = theList.length;
			checkSize3--;
			if (theList[checkSize3] == toAdd) {
				temp = true;
			} else {
				temp = false;
			}
		}
		return temp;
	}

	/**
	 * Gets the object at the specified index.
	 * 
	 * @param index value of object to get
	 * @return object at that index
	 */
	public Object get(int index) {
		Object returnedObject = null;
		if (theList != null) {
			returnedObject = theList[index];
		}
		return returnedObject;
	}

	/**
	 * Removes specified object from list.
	 * 
	 * @param index value of object to remove
	 * @return the object removed
	 */
	public Object remove(int index) {
		Object removedObject = null;
		
		if(index >= 0 && index < theList.length) {
			removedObject = theList[index];
			
			theList[index] = null;
			
			int newIndex = theList.length - 1;
			Object[] temp = new Object[newIndex];
			
			for(int i = 0; i < index; i++) {
				temp[i] = theList[i];
			}
			for(int i2 = index; i2 < temp.length; i2++) {
				temp[i2] = theList[i2+1];
			}
			theList = temp;
			
			
		}else {
			System.out.println("There is no index " + index);
		}
		return removedObject;
	}

	/**
	 * Returns size of the list
	 * 
	 * @return number of elements in the list
	 */
	public int size() {

		return theList.length;
	}

	/**
	 * @return true if the list has no elements, false otherwise
	 */
	public boolean isEmpty() {
		boolean checkEmpty = false;
		if (theList.length > 0) {
			checkEmpty = false;
		} else {
			checkEmpty = true;
		}
		return checkEmpty;
	}

}
