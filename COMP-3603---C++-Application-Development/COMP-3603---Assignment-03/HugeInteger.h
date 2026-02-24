#ifndef HUGEINTEGER_H
#define HUGEINTEGER_H

#include <iostream>
#include <vector>
#include <string>
#include <cmath>

class HugeInteger {
public:
    // Constructors
    HugeInteger();
    HugeInteger(long long value);
    HugeInteger(const char* str);

    // Operator overloads as member functions
    HugeInteger operator +(const HugeInteger& rightside) const;
    HugeInteger operator -(const HugeInteger& rightside) const;
    HugeInteger operator *(const HugeInteger& rightside) const;
    HugeInteger operator /(const HugeInteger& rightside) const;

    HugeInteger& operator ++();    // Pre-increment
    HugeInteger operator ++(int);  // Post-increment
    HugeInteger& operator --();    // Pre-decrement
    HugeInteger operator --(int);  // Post-decrement

    HugeInteger& operator +=(const HugeInteger& rightside);
    HugeInteger& operator -=(const HugeInteger& rightside);
    HugeInteger& operator *=(const HugeInteger& rightside);
    HugeInteger& operator /=(const HugeInteger& rightside);

    bool operator ==(const HugeInteger& rightside) const;
    bool operator <(const HugeInteger& rightside) const;

    operator double() const;

    // Friend functions for non-member operator overloads
    friend std::istream& operator>>(std::istream& in, HugeInteger& num);
    friend std::ostream& operator<<(std::ostream& out, const HugeInteger& num);

private:
    static const unsigned int NUMBER_OF_DIGITS = 40;
    short hugeInt[NUMBER_OF_DIGITS];
    bool isNegative;
    void input(const char* str);
};

// Inline global (non-member) functions
inline bool operator !=(const HugeInteger& lhs, const HugeInteger& rhs) {
    return !(lhs == rhs);
}

inline bool operator >(const HugeInteger& lhs, const HugeInteger& rhs) {
    return !(lhs <= rhs);
}

inline bool operator >=(const HugeInteger& lhs, const HugeInteger& rhs) {
    return !(lhs < rhs);
}

inline bool operator <=(const HugeInteger& lhs, const HugeInteger& rhs) {
    return (lhs == rhs || lhs < rhs);
}

inline HugeInteger operator +(const HugeInteger& num) {
    return num;
}

#endif // HUGEINTEGER_H
