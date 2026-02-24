// Matthew Simpson / A0020997
// COMP 3603 - C++ App Development
// Assignment 1 - June 2024

#include "./TwoDimensionalShapes.h"

TwoDimensionalShapes::TwoDimensionalShapes(void) {
	this->setNoOfSides(1);  //since every 2d shape will only have one "side"
}

double TwoDimensionalShapes::Area() const {
	return 0.0;
}