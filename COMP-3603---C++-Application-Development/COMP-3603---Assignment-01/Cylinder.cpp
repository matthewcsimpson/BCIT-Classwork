// Optional Assignment 1 Solution: Cylinder.cpp
// Member-function definitions for class Cylinder.
// Author: Bob Langelaan
// Date: Sept. 20th, 2014


// Matthew Simpson / A0020997
// COMP 3603 - C++ App Development
// Assignment 1 - June 2024

#include "Cylinder.h"

// constructor
Cylinder::Cylinder(void)
:mHeight(0.0) {
	this->setNoOfSides(3);   // Why not init. this member in MIL ???
}

// used to set mHeight member
void Cylinder::setHeight(const double & setVal) {
	if (setVal > 0.0 ) {
		this->mHeight = setVal;
	}
}

double Cylinder::getHeight (void) const {
	return this->mHeight;
}

void Cylinder::setRadius(const double & setVal) {
	if (setVal > 0.0 ){
		this->mRadius = setVal;
	}
}

double Cylinder::getRadius (void) const{
	return this->mRadius;
}


double Cylinder::Area (void) const {
	double TwoPiR = 2.0 * Shape::pi * this->mRadius;
	return ( TwoPiR * this->mRadius ) + ( TwoPiR * this->mHeight );
}

// used to claculate and return volume
double Cylinder::Volume (void) const {
	return Shape::pi * this->mRadius * this->mRadius * this->mHeight;
}