// Deque.h - Assignment 6
// Implement a double ended queue

// Author: Bob Langelaan
// Date: July 03, 2024

// Modified by: Matthew Simpson
// Date: 16 July 2024

#ifndef DEQUE_H
#define DEQUE_H

#include <stdexcept>
#include <iostream>
#include <utility>

template <typename Type>
class Deque {
	public:
		const static size_t MIN_ARRAY_SIZE = 8; // default minimum array size
		const static int RESIZE_FACTOR = 2; // used to resize deque
		const static int SHRINK_RATE = 4;   // used to determine when deque needs to shrink

		explicit Deque( int = MIN_ARRAY_SIZE); //defualt ctor and conversion ctor
		Deque(Deque const & ); // copy ctor
		Deque(Deque&& ); // move ctor
		~Deque(); // dtor

		Type front() const; // returns value at front of deque object
		Type back() const; // returns value at back of deque object
		int size() const; // returns number of objects on the deque
		bool isEmpty() const; // return true if deque object is empty
		int capacity() const; // returns size of the array which contains objects stored on the deque

		void swap(Deque& ); // swaps deque object that invokes the method with the deque object 
		                    //    passed as a parameter
		Deque&operator=(Deque const& ); // overloaded copy assignment operator
		Deque&operator=(Deque&& ); // overloaded move assignment operator

		// subscript operator for non-const objects returns modifiable lvalue
		Type& operator[](int);

		// subscript operator for const objects returns rvalue
		Type operator[](int) const;

		void push_front( Type const & ); // pushes value on front of deque
		void push_back( Type const & ); // pushes value on back of deque
		void pop_front(); // pops value from front of deque
		void pop_back(); // pops value from back of deque
		void clear(); // resets deque object. NOT the same as dtor! After clear(), the object
		              // should be in the same state as a newly created object with default capacity
						

	private:
		Type* arr;  // pointer to dynamically allocated array that will store objects stored in deque

		int arr_capacity; // current size of the array pointed to by "arr" above
		int num_items; // number of items on the deque

		int front_index; // contains index of where last value was stored in array 
		                 //   when last push_front() was done
		int back_index; // contains index of where last value was stored in array 
		                 //   when last push_back() was done

		// Private member functions
		
		void resize(int); // Resize the array to int argument value. 
		                  // Must support both increasing and decreasing array size.

	    // Friend functions

	    template <typename T> // Overloaded insertion operator
	    friend std::ostream &operator<<( std::ostream &, const Deque<T> & );
};

/////////////////////////////////////////////////////////////////////////
//                   Constructors and Destructors                      //
/////////////////////////////////////////////////////////////////////////

// Constructor
// Complete - do not modify!
template <typename Type>
Deque<Type>::Deque( int n )
	:num_items(0)
{
	if (n < MIN_ARRAY_SIZE)
	{
		n = MIN_ARRAY_SIZE;
	}

	arr_capacity = n;
	arr = new Type[arr_capacity];

	front_index = arr_capacity / 2;
	back_index = front_index - 1;
}

// Copy Constructor
template <typename Type>
Deque<Type>::Deque(const Deque &other)
: arr_capacity(other.arr_capacity), num_items(other.num_items), front_index(other.front_index) {
	arr = new Type[arr_capacity];
	for (int i = 0; i < num_items; ++i) {
		arr[(front_index + i) % arr_capacity] = other.arr[(other.front_index + i) % other.arr_capacity];
	}
}


// Move Constructor
template <typename Type>
Deque<Type>::Deque(Deque &&other)
: arr(other.arr), arr_capacity(other.arr_capacity), num_items(other.num_items), front_index(other.front_index) {
	other.arr = nullptr;
	other.num_items = 0;
	other.front_index = 0;
	other.arr_capacity = 0;
}


// Destructor
template <typename Type>
Deque<Type>::~Deque() {
	delete[] arr;
}

/////////////////////////////////////////////////////////////////////////
//                     Public Member Functions                         //
/////////////////////////////////////////////////////////////////////////

// Returns # of items on the deque
// Complete - do not modify!
template <typename Type>
int Deque<Type>::size() const {
	return num_items;
}

// Returns the current capcity of the array
// Complete - do not modify!
template <typename Type>
int Deque<Type>::capacity() const {
	return arr_capacity;
}

// Returns true if deque is empty and false otherwise
template <typename Type>
bool Deque<Type>::isEmpty() const {

	return num_items == 0;
}

// If deque is not empty it returns item at the front of the deque.
// Otherwise it throws an appropriate exception.
template <typename Type>
Type Deque<Type>::front() const {
	if (isEmpty()) {
		throw std::underflow_error("Underflow in front()");
	}
	return arr[front_index];
}


// If deque is not empty it returns item at the back of the deque.
// Otherwise it throws an appropriate exception.
template <typename Type>
Type Deque<Type>::back() const {
	if (isEmpty()) {
		throw std::underflow_error("Underflow in back()");
	}
	return arr[(front_index + num_items - 1) % arr_capacity];
}

// Swaps the properties of the object that invokes the member function
// with the object passed as a parameter
template <typename Type>
void Deque<Type>::swap(Deque<Type> &deque) {
	// dynamic arrays
	Type *tempArr = arr;
	arr = deque.arr;
	deque.arr = tempArr;
	
	// capacities
	int tempCapacity = arr_capacity;
	arr_capacity = deque.arr_capacity;
	deque.arr_capacity = tempCapacity;
	
	// number of items
	int tempNumItems = num_items;
	num_items = deque.num_items;
	deque.num_items = tempNumItems;
	
	// front indices
	int tempFrontIndex = front_index;
	front_index = deque.front_index;
	deque.front_index = tempFrontIndex;
}


// Overloaded copy assignment operator
// Complete - do not modify!
template <typename Type>
Deque<Type> & Deque<Type>::operator=(Deque<Type> const &rhs ) {
	// This is done for you...
	Deque<Type> copy( rhs ); // create a copy of rhs that is allowed to be modified
	swap( copy ); // swap the copy with object on left of assignment operator
	              // or in other words, swap copy with object that invoked the method

	return *this;  // The copy object created above, which now contains the same data
	               //   as the original object on the left of assignment operator, will
	               //   go out of scope and be destroyed when this method exits.
} 

// Overloaded move assignment operator
// Complete - do not modify!
template <typename Type>
Deque<Type> & Deque<Type>::operator=(Deque<Type> &&rhs ) {
	// This is done for you
	clear(); // first reset object on left of assignment operator 
	swap( rhs ); // then swap object on left of assignment operator with rhs
	return *this; // And that is all there is to it :)
}

// subscript operator for non-const objects returns modifiable lvalue
// index 0 will be the element at the very front of the deque
// index n-1, where n is the current size of the deque object, will be
//     the element at very back of the deque 
template <typename Type>
Type& Deque<Type>::operator[](int index)
{
	Type temp;
	return temp; // Note that this line will likely cause a warning when
	//    build this solution.
	// When you implement this method this line will need
	//    to be replaced.
}

// subscript operator for const objects returns rvalue
// index 0 will be the element at the very front of the deque
// index n-1, where n is the current size of the deque object, will be
//     the element at very back of the deque 
template <typename Type>
Type Deque<Type>::operator[](int index) const
{
	Type temp;
	return temp;
}

// Pushes a value to the front of the deque.
// If the deque is full, it resizes the array to twice it size
//   to make room for the new value.
template <typename Type>
void Deque<Type>::push_front(const Type &obj) {
	if (num_items == arr_capacity) {
		resize(arr_capacity * 2);
	}
	front_index = (front_index - 1 + arr_capacity) % arr_capacity;
	arr[front_index] = obj;
	++num_items;
}

// Pushes a value to the back of the deque.
// If the deque is full, it resizes the array to twice it size
//   to make room for the new value.
template <typename Type>
void Deque<Type>::push_back(const Type &obj) {
	if (num_items == arr_capacity) {
		resize(arr_capacity * 2);
	}
	arr[(front_index + num_items) % arr_capacity] = obj;
	++num_items;
}
// Pops a value from the front of the deque.
// If after popping the value the deque is less than 1/4 full, it resizes the array appropriately.
// Read assignment description for details.
template <typename Type>
void Deque<Type>::pop_front() {
	if (isEmpty()) {
		throw std::underflow_error("Underflow in pop_front()");
	}
	front_index = (front_index + 1) % arr_capacity;
	--num_items;
	if (num_items > 0 && num_items <= arr_capacity / 4) {
		resize(arr_capacity / 2);
	}
}


// Pops a value from the back of the deque.
// If after popping the value the deque is less than 1/4 full, it resizes the array appropriately.
// Read assignment description for details.
template <typename Type>
void Deque<Type>::pop_back() {
	if (isEmpty()) {
		throw std::underflow_error("Underflow in pop_back()");
	}
	--num_items;
	if (num_items > 0 && num_items <= arr_capacity / 4) {
		resize(arr_capacity / 2);
	}
}


// Resets object to its initial valid state
template <typename Type>
void Deque<Type>::clear() {
	delete[] arr;
	arr_capacity = 8; // Reset to initial capacity of 8
	arr = new Type[arr_capacity];
	num_items = 0;
	front_index = 0;
}


/////////////////////////////////////////////////////////////////////////
//                      Private member functions                       //
/////////////////////////////////////////////////////////////////////////

// Resize the array to new_size
template <typename Type>
void Deque<Type>::resize(int new_size) {
	if (new_size < 8) {
		new_size = 8; // Ensure capacity does not go below initial capacity of 8
	}
	Type* new_arr = new Type[new_size];
	for (int i = 0; i < num_items; ++i) {
		new_arr[i] = arr[(front_index + i) % arr_capacity];
	}
	delete[] arr;
	arr = new_arr;
	arr_capacity = new_size;
	front_index = 0;
}

/////////////////////////////////////////////////////////////////////////
//                               Friend functions                            //
/////////////////////////////////////////////////////////////////////////

// Overloaded insertion operator
// Complete - do not modify!
template <typename T>
std::ostream &operator<<( std::ostream &out, const Deque<T> &list ) {
	if (list.isEmpty())
	{
		out << "list is empty.";
	}
	else
	{
		int new_index = list.front_index;
		for (int i = 1; i <= list.num_items; ++i)
		{
			out << list.arr[new_index] << " ";
			new_index = (new_index + 1) % list.arr_capacity;
		}
	}
	
	out << std::endl;
	return out;
} 

#endif
