// Test_main.cpp - Assignment 6
// Implement a double ended queue

// Author: Bob Langelaan
// Date: July 3rd, 2024

#include <iostream>
#include <iomanip>
#include <utility>

#include "Deque.h"

using namespace std;

int main() {

    cout << "- TEST push_front() on object \"deque\" and then test both front() and back():" << endl;
    Deque<int> deque; // Create empty Deque of ints with default initial capacity of 8
    deque.push_front(10); //Add 10 to the deque
    cout << "front: " << deque.front() << "  back: " << deque.back() << endl;

    cout << "\n- TEST pop_back() on object \"deque\":" << endl;
    deque.pop_back();
    if (deque.isEmpty())
    {
        cout << "deque is now empty as expected." << endl;
    }

    // Add 20 items to deque
    cout << "\n- TEST push_front(), push_back(), front() and back() on object \"deque\":" << endl;
    for (int i = 1; i <= 10; ++i)
    {
        deque.push_front(i); // push front values 1 to 10
        deque.push_back(i + 20); // push back values 21 to 30
        cout << "front: " << deque.front() << "  back: " << deque.back();
        cout << "  deque size and capacity are: " << deque.size() << " " << deque.capacity() << endl;
    }

    cout << "\ndeque: " << deque; // output contents of deque

    cout << "\n- TEST copy ctor by creating new object \"deque2\" as copy of \"deque\"" << endl;
    Deque<int> deque2(deque); // test copy ctor

    // Remove 10 values from the deque2 (the copy)
    for (int i = 1; i <= 5; ++i)
    {
       deque2.pop_front(); // pop front value from copy
       deque2.pop_back(); // pop back value from copy
       cout << "front: " << deque2.front() << "  back: " << deque2.back() << endl;
    }

    cout << "\ndeque2: " << deque2;  // output current state of the copy
    cout << "\ndeque: " << deque; // output current state of deque
    cout << endl;

    // Empty out the deque
    cout << "\n- TEST Empty out \"deque\"" << endl;
    while(!deque.isEmpty())
    {
        deque.pop_front(); // pop front value from copy
        cout << "deque size and capacity are: " << deque.size() << " " << deque.capacity() << endl;
    }
    cout << endl;
    cout << "deque: " << deque; // output current state of deque

    // Test that the proper exceptions are thrown for underflow situations
    cout << "\n- TEST handling of underflow errors" << endl;
    // Situation 1
    try
    {
        deque.front();
    }
    catch (std::underflow_error& errObj)
    {
        cout << errObj.what() << " exception was thrown!" << endl;
    }

    // Situation 2
    try
    {
        deque.back();
    }
    catch (std::underflow_error& errObj)
    {
        cout << errObj.what() << " exception was thrown!" << endl;
    }

    // Situation 3
    try
    {
        deque.pop_front();
    }
    catch (std::underflow_error& errObj)
    {
        cout << errObj.what() << " exception was thrown!" << endl;
    }

    // Situation 4
    try
    {
        deque.pop_back();
    }
    catch (std::underflow_error& errObj)
    {
        cout << errObj.what() << " exception was thrown!" << endl;
    }

    // Let's make sure deque object was not somehow corrupted by above actions
    deque.push_front(1);
    deque.push_back(2);
    cout << "\ndeque.back() = ";
    cout << deque.back();
    cout << " and deque.front() = ";
    cout << deque.front() << endl;


    cout << "\n- TEST Create a deque object \"deque3\" of doubles with initial capacity of 4" << endl;
    Deque<double> deque3(4);  // Create empty Deque of doubles with initial capacity of 4

    cout << std::fixed << std::setprecision(2);

    cout << "\n- TEST Add 10 values to the front of \"deque3\" and then output values stored in the object" << endl;
    for (int i = 1; i <= 10; ++i)
    {
        deque3.push_front(i*1.0);
        cout << "front: " << deque3.front() << "  back: " << deque3.back();
        cout << "  deque3 size and capacity are: " << deque3.size() << " " << deque3.capacity() << endl;
    }

    cout << "\ndeque3: " << deque3 << endl;

    cout << "\n- TEST move ctor.  This in effect tests the swap() function as well." << endl;
    Deque<double> deque4(std::move(deque3)); // test move ctor

    for (int i = 1; i <= 4; ++i)
    {
        deque4.pop_back();
        cout << "deque4 size and capacity are: " << deque4.size() << " " << deque4.capacity() << endl;
    }

    cout << "\ndeque3: " << deque3;
    cout << "deque3 capacity is: " << deque3.capacity();
    cout << "\n\ndeque4: " << deque4;

    cout << "\n- TEST overloaded copy assignment operator.";
    deque3.push_back(5.5);
    deque3.push_back(6.6);
    deque3 = deque4;
    cout << "\ndeque3: " << deque3;
    cout << "\ndeque4: " << deque4;

    cout << "\n- TEST overloaded move assignment operator. This in effect tests the clear() and swap() functions as well.";
    deque3.pop_back();
    deque3.pop_front();
    deque4 = std::move(deque3);
    cout << "\ndeque3: " << deque3;
    cout << "deque3 capacity is: " << deque3.capacity();
    cout << "\n\ndeque4: " << deque4;

    cout << "\n- Test the overloaded subscript operators";
    {
        Deque<char> deque5;

        try {
            cout << "\ndeque[0] = " << deque5[0] << endl;  //not a valid subscript
        }
        catch (std::out_of_range& errObj)
        {
            cout << '\n' << errObj.what() << " exception was thrown!" << endl;
        }

        char c = 'a';
        for (int i = 1; i <= 6; ++i)
        {
            deque5.push_front(c++);
        }

        cout << "\nCurrent contents of deque5 starting at index 0" << endl;
        for (int i = 0; i < deque5.size(); ++i)
        {
            cout << deque5[i] << "  ";
        }

//        cout << "\n\nCurrent contents of deque5 starting at index 0" << endl;
//        cout << "using range based for loop" << endl;
//        for (auto& value : deque5)
//        {
//           cout << value << "  ";
//        }

        for (int i = 1; i <= 5; ++i)
        {
            deque5.pop_front();
            deque5.push_back(c++);
        }
        cout << endl;

        cout << "\nCurrent contents of deque5 starting at index 0" << endl;
        for (int i = 0; i < deque5.size(); ++i)
        {
            cout << deque5[i] << "  ";
        }
        cout << endl;

//        cout << "\nCurrent contents of deque5 starting at index 0" << endl;
//        cout << "using range based for loop" << endl;
//        for (auto& value : deque5)
//        {
//           cout << value << "  ";
//        }
//        cout << endl;

        try {
            cout << "\ndeque[-1] = " << deque5[-1] << endl;  //not a valid subscript
        }
        catch (std::out_of_range& errObj)
        {
            cout << '\n' << errObj.what() << " exception was thrown!" << endl;
        }
    }

    cout << "\n- TEST clear() function." << endl;
    // clear all of the deque objects so they are empty, in a valid state, and back to the MIN_ARRAY_SIZE
    deque.clear();
    cout << deque;
    cout << "deque capacity is: " << deque.capacity() << endl;
    deque2.clear();
    deque3.clear();
    deque4.clear();

    return 0;
}
