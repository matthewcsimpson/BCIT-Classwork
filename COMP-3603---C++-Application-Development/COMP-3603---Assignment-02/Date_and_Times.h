// Date_and_Times.h
// Name:
// Date: 

#ifndef DATE_AND_TIMES_H
#define DATE_AND_TIMES_H

#include <cstddef> // import to resolve size_t type error 
#include "Date.h"
#include "Time.h"

// class Date_and_Times definition
class Date_and_Times
{
public:

   // You supply missing functions here
   // Constructor
   Date_and_Times(const Date& date, const Time times[], size_t size);

   // Copy Constructor
   Date_and_Times(const Date_and_Times& other);
   
   // Asignment Operator
   Date_and_Times& operator=(const Date_and_Times& other);

   // Destructor 
   ~Date_and_Times();
   
   // Display 
   void display() const;
   
   // For simplicity sake, you need not worry about seconds value becoming greater than 59.
   void addFiveSecs();  // adds 5 seconds to each Time object

private:
	size_t _size;  // # of Time objects to be created dynamically
	Date _date;    // Date object
	Time * _timePtr; //ptr to array of Time objects created dynamically

}; // end class Date_and_Times

#endif
