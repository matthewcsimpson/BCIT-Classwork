// Assignment 4
// File: Assign4_main.cpp
// Array template class definition with overloaded ops.

// Author: Bob Langelaan
// Feb. 23, 2022

#include "Array.h"
#include <string>
using namespace std;

int main()
{
   int ObjectCount = Array<>::getArrayCount(); //will default to Array<int,5>
   cout << "The current number of Array<int, 5> objects instantiated is: " << ObjectCount << '\n';

   ObjectCount = Array<string, 7>::getArrayCount();
   cout << "\nThe current number of Array<string, 7> objects instantiated is: " << ObjectCount << '\n';

   Array< int, 5 > intArray1; // create a <int,5> Array object
   Array< int, 5 > intArray2; // create a second <int,5> Array object
   Array< int, 5 > intArray3(intArray2); // create a third <int,5> Array object
   Array< int, 6 > intArray4; // create a <int,6> Array object

   // initialize intArray1 with user input values
   cout << "\nEnter " << intArray1.getSize() << " integer values:\n";
   intArray1.inputArray();

   // output intArray1
   cout << "\nThe values in intArray1 are:\n";
   intArray1.outputArray();

   Array< string, 7 > stringArray1; // create <string,7> Array object
   Array< string, 7 > stringArray2; // create 2nd <string,7> Array object

   // initialize stringArray with user input values
   cout << "\nEnter " << stringArray1.getSize()
      << " one-word string values:\n";
   stringArray1.inputArray();

   // output stringArray
   cout << "\nThe values in the stringArray are:\n";
   stringArray1.outputArray();

// Note that if you were to overload the '=' operator (not required for this assignment),
// you would likely assume that both operands have the same number of elements and
// the same type of elements. Do you understand why such an assumption is relatively
// safe?
   
   intArray3 = intArray1;

   stringArray2 = stringArray1;

   if(intArray1 == intArray3)
   {
	   cout << "\nintArray1 == intArray3 \n";
   }

   if(stringArray1 == stringArray2)
   {
	   cout << "\nstringArray1 == stringArray2 \n";
   }

   intArray1[0] = 5;
   stringArray1[6] = "hello!!!";

   // output intArray after changing element 0
   cout << "\nThe values in intArray1 are:\n";
   intArray1.outputArray();

   // output stringArray after changing element 6
   cout << "\nThe values in the stringArray1 are:\n";
   stringArray1.outputArray();

   if(intArray1 != intArray3)
   {
	   cout << "\nintArray1 != intArray3 \n";
   }

   if(stringArray1 != stringArray2)
   {
	   cout << "\nstringArray1 != stringArray2 \n";
   }

   /*

   This code will not compile, which is why I have commented it out.
   Why will it not compile ?

   if(intArray3 != intArray4)
   {
	   cout << "\nintArray3 != intArray4 \n";
   }

   */

   // For fun, let's dynamically create and destroy another intArray object

   auto * ptr = new Array<>;
   delete ptr;

   // How many objects do we have now?
   ObjectCount = Array<int, 5>::getArrayCount();
   cout << "\nThe current number of Array<int, 5> objects instantiated is: " << ObjectCount << '\n';

   ObjectCount = Array<string, 7>::getArrayCount();
   cout << "\nThe current number of Array<string, 7> objects instantiated is: " << ObjectCount << '\n';

} // end main

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************/
