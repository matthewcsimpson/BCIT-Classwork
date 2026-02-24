#include "HugeInteger.h"
using namespace std;

// Default constructor
HugeInteger::HugeInteger() {
    this->isNegative = false;
    for (unsigned int i = 0; i < NUMBER_OF_DIGITS; ++i) {
        this->hugeInt[i] = 0;
    }
}

// long long constructor
HugeInteger::HugeInteger(long long value) {
    this->isNegative = false;
    if (value < 0LL) {
        this->isNegative = true;
        value = -value;
    }
    for (unsigned int i = 0; i < NUMBER_OF_DIGITS; ++i) {
        this->hugeInt[i] = 0;
    }
    for (int j = NUMBER_OF_DIGITS - 1; j >= 0 && value != 0LL; j--) {
        this->hugeInt[j] = value % 10;
        value /= 10;
    }
    if (value != 0LL) {
        *this = 0LL;
        this->isNegative = true;
    }
}

// string constructor
HugeInteger::HugeInteger(const char *str) {
    this->input(str);
}

// input to HugeInteger
void HugeInteger::input(const char* str) {
    this->isNegative = (str[0] == '-');
    size_t len = strlen(str);
    size_t start = (this->isNegative) ? 1 : 0;
    for (size_t i = 0; i < NUMBER_OF_DIGITS; ++i) {
        this->hugeInt[i] = 0;
    }
    size_t pos = NUMBER_OF_DIGITS - 1;
    for (size_t i = len; i > start; --i) {
        if (isdigit(str[i-1])) {
            this->hugeInt[pos--] = str[i-1] - '0';
        }
    }
}

// +
HugeInteger HugeInteger::operator +(const HugeInteger& rightside) const {
    HugeInteger temp = *this;
    return temp += rightside;
}

// +=
HugeInteger &HugeInteger::operator +=(const HugeInteger &rightside) {
    int carryOver = 0;
    for (int i = NUMBER_OF_DIGITS - 1; i >= 0; --i) {
        int sum = this->hugeInt[i] + rightside.hugeInt[i] + carryOver;
        this->hugeInt[i] = sum % 10;
        carryOver = sum / 10;
    }
    if (carryOver > 0) {
        this->isNegative = true; // Handle overflow
    }
    return *this;
}

// -=
HugeInteger& HugeInteger::operator -=(const HugeInteger& rightside) {
    int borrowOver = 0;
    for (int i = NUMBER_OF_DIGITS - 1; i >= 0; --i) {
        int diff = this->hugeInt[i] - rightside.hugeInt[i] - borrowOver;
        if (diff < 0) {
            diff += 10;
            borrowOver = 1;
        } else {
            borrowOver = 0;
        }
        this->hugeInt[i] = diff;
    }
    return *this;
}

// ==
bool HugeInteger::operator ==(const HugeInteger& rightside) const {
    for (unsigned int i = 0; i < NUMBER_OF_DIGITS; ++i) {
        if (this->hugeInt[i] != rightside.hugeInt[i]) {
            return false;
        }
    }
    return this->isNegative == rightside.isNegative;
}

// <
bool HugeInteger::operator <(const HugeInteger& rightside) const {
    if (this->isNegative != rightside.isNegative) {
        return this->isNegative;
    }
    for (unsigned int i = 0; i < NUMBER_OF_DIGITS; ++i) {
        if (this->hugeInt[i] != rightside.hugeInt[i]) {
            return (this->isNegative) ? (this->hugeInt[i] > rightside.hugeInt[i]) : (this->hugeInt[i] < rightside.hugeInt[i]);
        }
    }
    return false;
}

// ++n
HugeInteger &HugeInteger::operator ++ () {
    *this += 1;
    return *this;
}

// n++
HugeInteger HugeInteger::operator ++ (int) {
    HugeInteger temp = *this;
    ++(*this);
    return temp;
}

// --n
HugeInteger &HugeInteger::operator -- () {
    *this -= 1;
    return *this;
}

// n++
HugeInteger HugeInteger::operator -- (int) {
    HugeInteger temp = *this;
    --(*this);
    return temp;
}

//// overload typecast to double
//HugeInteger::operator double() const {
// 
//}

// >>
//istream &operator>>(istream &src, HugeInteger &value) {
//  
//}

// <<
//ostream &operator<<(ostream &dest, const HugeInteger &value) {
//  
//}
