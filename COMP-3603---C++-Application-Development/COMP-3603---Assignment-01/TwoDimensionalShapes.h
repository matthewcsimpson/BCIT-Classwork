// Matthew Simpson / A0020997
// COMP 3603 - C++ App Development
// Assignment 1 - June 2024

#pragma once
#include "Shape.h"

class TwoDimensionalShapes : public Shape {
public:
	TwoDimensionalShapes(void);
	virtual double Area() const = 0;
};