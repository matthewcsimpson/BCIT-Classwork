// Optional Assignment 1 Solution: Circle.h
// Declaration of class Circle.
// Member functions are defined in Circle.cpp.
// Author: Bob Langelaan 
// Date: Sept. 9th, 2006

// Matthew Simpson / A0020997
// COMP 3603 - C++ App Development
// Assignment 1 - June 2024

#pragma once
#include "TwoDimensionalShapes.h"

class Circle :public TwoDimensionalShapes
{
public:
	Circle(void);
	void setRadius(const double &); 
	double getRadius() const;  
	virtual double Area() const override;  	
protected:
	double mRadius;  
};
