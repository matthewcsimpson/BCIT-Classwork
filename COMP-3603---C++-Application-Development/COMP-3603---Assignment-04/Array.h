#ifndef ARRAY_H
#define ARRAY_H

#include <iostream>

template <typename T = int, int numberOfElements = 5>
class Array {
public:
    Array();
    Array(const Array &other);

    void inputArray();
    void outputArray() const;

    static int getArrayCount();
    int getSize() const;

    T& operator[](int index);
    const T& operator[](int index) const;

    bool operator==(const Array &other) const;
    bool operator!=(const Array &other) const;

private:
    T data[numberOfElements];
    static int arrayCount;
};

// Initialize the static member
template <typename T, int numberOfElements>
int Array<T, numberOfElements>::arrayCount = 0;

// Default constructor
template <typename T, int numberOfElements>
Array<T, numberOfElements>::Array() {
    arrayCount++;
}

// Copy constructor
template <typename T, int numberOfElements>
Array<T, numberOfElements>::Array(const Array &other) {
    for (int i = 0; i < numberOfElements; ++i) {
        data[i] = other.data[i];
    }
    arrayCount++;
}

// Input array elements
template <typename T, int numberOfElements>
void Array<T, numberOfElements>::inputArray() {
    for (int i = 0; i < numberOfElements; ++i) {
        std::cin >> data[i];
    }
}

// Output array elements
template <typename T, int numberOfElements>
void Array<T, numberOfElements>::outputArray() const {
    for (int i = 0; i < numberOfElements; ++i) {
        std::cout << data[i] << ' ';
    }
    std::cout << std::endl;
}

// Get the number of Array objects instantiated
template <typename T, int numberOfElements>
int Array<T, numberOfElements>::getArrayCount() {
    return arrayCount;
}

// Get the size of the array
template <typename T, int numberOfElements>
int Array<T, numberOfElements>::getSize() const {
    return numberOfElements;
}

// Subscript operator (non-const)
template <typename T, int numberOfElements>
T& Array<T, numberOfElements>::operator[](int index) {
    if (index < 0 || index >= numberOfElements) {
        throw std::out_of_range("Index out of range");
    }
    return data[index];
}

// Subscript operator (const)
template <typename T, int numberOfElements>
const T& Array<T, numberOfElements>::operator[](int index) const {
    if (index < 0 || index >= numberOfElements) {
        throw std::out_of_range("Index out of range");
    }
    return data[index];
}

// Overloaded equality operator
template <typename T, int numberOfElements>
bool Array<T, numberOfElements>::operator==(const Array &other) const {
    for (int i = 0; i < numberOfElements; ++i) {
        if (data[i] != other.data[i]) {
            return false;
        }
    }
    return true;
}

// Overloaded inequality operator
template <typename T, int numberOfElements>
bool Array<T, numberOfElements>::operator!=(const Array &other) const {
    return !(*this == other);
}

#endif
