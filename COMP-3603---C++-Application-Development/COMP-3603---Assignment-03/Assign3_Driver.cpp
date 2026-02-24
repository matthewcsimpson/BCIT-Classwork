
// Main driver for Assignment 3: Assign2_Driver.cpp
// Overload operators for HugeInteger class.

// Author: Bob Langelaan
// Date: February 18th, 2022

#include "HugeInteger.h" // include definiton of class HugeInteger
using namespace std;

int main()
{
	HugeInteger a,b,c,d;

	// input values for a & b
	cout << "****** Test << & >> operators ******\n\n";
	cout << "Input values for a and b: ";
	cin >> a >> b;
	cout << "\na = " << a << "\nb = " << b;

	d = b;

	// test += operator
	cout << "\n\n****** Test += operator ******\n\n";
	cout << "a = " << a << "\nb = " << b << "\nc = " << c << "\n\n";
	cout << "c = b += a\n";
	c = b += a;
	cout << "\na = " << a << "\nb = " << b << "\nc = " << c;
	b =d;  // restore b's value

	// test -= operator
	cout << "\n\n****** Test -= operator ******\n\n";
	cout << "a = " << a << "\nb = " << b << "\nc = " << c << "\n\n";
	cout << "c = b -= a\n";
	c = b -= a;
	cout << "\na = " << a << "\nb = " << b << "\nc = " << c;
	b = d;  // restore b's value

	// test unary - operator
	cout << "\n\n****** Test unary - operator ******\n\n";
	cout << "a = " << a << "\nb = " << b << "\nc = " << c << "\n\n";
	cout << "c = b = -a\n";
	c = b= - a;
	cout << "\na = " << a << "\nb = " << b << "\nc = " << c;
	b = d;  // restore b's value

	// test boolean operators
	cout << "\n\n****** Test boolean operators ******\n";
	cout << "\na = " << a << "\nb = " << b << "\n\n";
	if(a == b)
		cout << "a == b\n";
	if(a != b)
		cout << "a != b\n";
	if(a < b)
		cout << "a < b\n";
	if(a > b)
		cout << "a > b\n";
	if(a <= b)
		cout << "a <= b\n";
	if(a >= b)
		cout << "a >= b\n";
	if(b < a)
		cout << "b < a\n";
	if(b > a)
		cout << "b > a\n";
	if(b <= a)
		cout << "b <= a\n";
	if(b >= a)
		cout << "b >= a\n";
	if(!a)
		cout << "a is equal to 0\n";
	if(+a)
		cout << "a is not equal to 0\n";
	if(!b)
		cout << "b is equal to 0\n";
	if(+b)
		cout << "b is not equal to 0\n";

	// test increment and decrement operators
	cout << "\n****** Test increment and decrement operators ******\n";
	cout << "\na = " << a << "\nb = " << b << "\n";
	cout << "\ncout << a++ << a\n";
	cout << a++ << "  " << a;
	cout << "\n\ncout << b-- << b\n";
	cout << b-- << "  " << b;
	cout << "\n\ncout << ++a << a\n";
	cout << ++a << "  " << a;
	cout << "\n\ncout << --b << b\n";
	cout << --b << "  " << b << "\n";

	// test overloaded type cast to double operator
	cout << "\n****** Test overloaded type cast to double operator ******\n";
	cout << "\na = " << a << "\nb = " << b << "\n";
	double dA = (double) a;             // one way to invoke cast operator
	double dB = static_cast<double>(b); // another way to invoke cast operator
	cout << "\na cast to a double is: " << dA;
	cout << "\nb cast to a double is: " << dB << '\n' << endl;

//	system("pause");

	return 0;
} // end main
