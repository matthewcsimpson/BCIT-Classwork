 // Assignment 2
// 
// Test_Main.cpp 
// 
// Name: Bob Langelaan
// Date: June 15, 2022

// An exercise to demonstrate knowledge of dynamic memory allocation of an array
//    in the constructor.

#include <iostream>
#include "Date_and_Times.h"
using namespace std;

const size_t NUM_TIMES = 5;

int main()
{
   // Create Date object
   Date date1( 1, 13, 2016 );
   
   // Create array of Time objects
   Time times[NUM_TIMES];

   // Create a Time object
   Time time1(10, 30, 0);

   // Set time objects to be 10 seconds apart
   for (size_t i = 0; i < NUM_TIMES; ++i)
   {
	   times[i] = time1;
	   time1.setSecond(time1.getSecond() + 10);
   }
 
   // Create Date_and_Times object
   Date_and_Times dTsObj(date1, times, NUM_TIMES);

   // Display Date_and_Times object
   cout << "Output the object just created.\n";
   dTsObj.display();

   // Invoke copy ctor; add 5 secs to each time object in the copy; and display copy
   {
	   Date_and_Times dTsObj2(dTsObj); //using copy ctor

	   dTsObj2.addFiveSecs(); // add 5 seconds to each Time object

	   cout << "Output the object dTsObj2 just created using copy ctor.\n";
	   cout << "Note that 5 seconds has been added to each Time object.\n";
	   dTsObj2.display();
   }

   // Display original object again. It should _NOT_ have been modified !!!
   cout << "Output the original object again to show it was not modified/corrupted\n";
   cout << "when the object created by copy ctor was modified.\n";
   dTsObj.display();

   // Create another Date object
   Date date2(12, 31, 1999);

   // Create another array of Time objects
   Time times2[NUM_TIMES+5];

   // Create another Time object
   Time time2(23, 00, 0);

   // Set time objects to be 10 seconds apart
   for (size_t i = 0; i < NUM_TIMES+5; ++i)
   {
	   times2[i] = time2;
	   time2.setSecond(time2.getSecond() + 5);
   }

   // Dynamically allocate a new Date_and_Times object and assign to reference.

   //  Date_and_Times & dTsObjRef = *(new Date_and_Times(dTsObj)); // Also allowed
   Date_and_Times & dTsObjRef = *(new Date_and_Times(date2,times2, NUM_TIMES + 5));

   // Display new object created dynamically
   cout << "Output the object just created dynamically.\n";
   dTsObjRef.display();

   // Invoke copy ctor; exercise assignment operator and add 5 secs to each time object in the
   // left operand object of the assignment operator and display it.
   {
	   Date_and_Times dTsObj2(dTsObjRef); // using copy ctor
	   cout << "Output dTsObj2 after being created again using copy ctor." << endl;
	   dTsObj2.display(); // display after copy ctor

	   dTsObj2 = dTsObj; //using assignment operator
	   cout << "Output dTsObj2 after being overwritten by assignment operator." << endl;
	   dTsObj2.display(); // display after being overwritten by assignment operator

	   dTsObj2.addFiveSecs(); // add 5 seconds to each Time object
	   cout << "Output the object one last time.\n";
	   cout << "Note that 5 seconds has been added to each Time object.\n";
	   dTsObj2.display();
   }

   // Display original object again. It should _NOT_ have been modified
   cout << "Output the original object again to show it was not modified/corrupted\n";
   cout << "when the object overwritten by assignment operator was modified.\n";
   dTsObj.display();

   // Test self assignment
   dTsObj = dTsObj;

   // Display original object one last time.
   cout << "Output the original object one last time proving that self assignment did not corrupt it.\n";
   dTsObj.display();

   delete& dTsObjRef;  // Free memory allocated to dynamically created object.

} // end main

