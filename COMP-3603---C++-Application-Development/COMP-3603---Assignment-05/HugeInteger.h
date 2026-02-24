// Matthew Simpson 
// 2nd July 2024

#ifndef HUGEINTEGER_H
#define HUGEINTEGER_H

#include <iostream>
#include <stdexcept>
#include <cstring>

class HugeInteger {
    friend std::istream & operator >> (std::istream &, HugeInteger &);
    friend std::ostream & operator << (std::ostream &, const HugeInteger &);
public:
    static const unsigned int NUMBER_OF_DIGITS = 17;

    HugeInteger(long long value = 0); // default ctor, and converts a long long into a HugeInteger
    HugeInteger(const char *str); // converts a C-string into a HugeInteger

    // Overloaded operator functions
    HugeInteger operator +(const HugeInteger &) const;
    HugeInteger operator +(const char *str) const;
    HugeInteger operator +(long long value) const;
    HugeInteger & operator +=(const HugeInteger &);
    HugeInteger operator -(const HugeInteger &) const;
    HugeInteger operator -(const char *str) const;
    HugeInteger operator -(long long value) const;
    HugeInteger & operator -=(const HugeInteger &);
    HugeInteger operator -(void) const; // unary minus
    HugeInteger operator ~(void) const; // unary ~, absolute value
    bool operator ==(const HugeInteger &) const;
    bool operator < (const HugeInteger &) const;
    bool operator !() const; // test for zero
    operator double(void) const;

    HugeInteger & operator ++ (); // Pre-increment operator
    HugeInteger operator ++ (int); // Post-increment operator
    HugeInteger & operator -- (); // Pre-decrement operator
    HugeInteger operator -- (int); // Post-decrement operator

    // Exception classes definitions
    class OverflowException : public std::overflow_error {
    public:
        OverflowException(const std::string& message) : std::overflow_error(message) {}
    };

    class StringTooLargeException : public std::length_error {
    public:
        StringTooLargeException(const std::string& message) : std::length_error(message) {}
    };

    class InvalidStringArgumentException : public std::invalid_argument {
    public:
        InvalidStringArgumentException(const std::string& message) : std::invalid_argument(message) {}
    };

private:
    short hugeInt[NUMBER_OF_DIGITS] = {};
    bool negative = false;

    void input(const char *str); // converts a C-string into a HugeInteger
};

#endif
