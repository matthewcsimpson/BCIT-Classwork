// Optional Assignment 1 Solution: Cylinder.h
// Declaration of class Cylinder.
// Member functions are defined in Cylinder.cpp.
// Author: Bob Langelaan
// Date: Sept. 9th, 2006

// Matthew Simpson / A0020997
// COMP 3603 - C++ App Development
// Assignment 1 - June 2024

#pragma once
#include "ThreeDimensionalShapes.h"

class Cylinder :public ThreeDimensionalShapes
{
public:
	Cylinder(void); 
	void setHeight(const double &); 
	double getHeight() const;
	void setRadius(const double &);
	double getRadius() const;
	virtual double Area() const override;   
	virtual double Volume() const override;  
protected:
	double mHeight;
	double mRadius;
};
