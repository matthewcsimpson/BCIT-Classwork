// Optional Assignment 1 Solution: Circle.cpp
// Member-function definitions for class Circle.
// Author: Bob Langelaan
// Date: Sept. 20th, 2014

// Matthew Simpson / A0020997
// COMP 3603 - C++ App Development
// Assignment 1 - June 2024

#include "Circle.h"

// constructor 
Circle::Circle(void)
:mRadius(0.0) {
	this->setNoOfSides(1); 
}

// Set the value for mRadius member
void Circle::setRadius(const double & setVal) {
	if (setVal > 0.0) {
		this->mRadius = setVal;
	}
}

// Return current value of mRadius member
double Circle::getRadius (void) const {
	return this->mRadius ;
}

// Calculate and return area.
double Circle::Area (void) const {
	return Shape::pi * this->mRadius * this->mRadius ;
}
