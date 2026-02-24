#include <iostream>
#include <iomanip>
#include "Date_and_Times.h"

using namespace std;


// Constructor
Date_and_Times::Date_and_Times(const Date& date, const Time times[], size_t size)
: _date(date), _size(size), _timePtr(new Time[size]) {
	for (size_t i = 0; i < size; ++i) {
		_timePtr[i] = times[i];
	}
}

// Copy Constructor
Date_and_Times::Date_and_Times(const Date_and_Times& other)
: _date(other._date), _size(other._size), _timePtr(new Time[other._size]) {
	for (size_t i = 0; i < _size; ++i) {
		_timePtr[i] = other._timePtr[i];
	}
}


// Assignment operator
Date_and_Times& Date_and_Times::operator=(const Date_and_Times& other) {
	if (this != &other) {
		delete[] _timePtr;
		
		_date = other._date;
		_size = other._size;
		_timePtr = new Time[other._size];
		for (size_t i = 0; i < _size; ++i) {
			_timePtr[i] = other._timePtr[i];
		}
	}
	return *this;
}


// Destructor
Date_and_Times::~Date_and_Times() {
	delete[] _timePtr;
}


// Add Five Seconds
void Date_and_Times::addFiveSecs() {
	for (size_t i = 0; i < _size; ++i) {
		int sec = _timePtr[i].getSecond();
		_timePtr[i].setSecond(sec + 5);
	}
}


// Display the date and times
void Date_and_Times::display() const {
	cout << "\nThe Date is:\n";
	_date.print();
	cout << endl;
	cout << "\nThe times are:\n";
	for (size_t i = 0; i < _size; ++i) {
		_timePtr[i].printUniversal();
		cout << endl;
	}
}