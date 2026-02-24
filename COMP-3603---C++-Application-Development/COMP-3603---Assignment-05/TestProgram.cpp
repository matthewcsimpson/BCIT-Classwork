// Matthew Simpson 
// 2nd July 2024

#include <iostream>
#include "HugeInteger.h"

int main() {
    try {
        HugeInteger input1("876543210987654321");
    } catch (const HugeInteger::OverflowException& e) {
        std::cout << "Exception occurred: " << e.what() << std::endl;
    } catch (const HugeInteger::StringTooLargeException& e) {
        std::cout << "Exception occurred: " << e.what() << std::endl;
    } catch (const HugeInteger::InvalidStringArgumentException& e) {
        std::cout << "Exception occurred: " << e.what() << std::endl;
    }

    while (true) {
        try {
            std::cout << "Enter the first number: ";
            std::string firstNumber;
            std::cin >> firstNumber;
            HugeInteger input1(firstNumber.c_str());
            std::cout << "The first value entered is: " << input1 << std::endl;

            std::cout << "Enter the second number: ";
            std::string secondNumber;
            std::cin >> secondNumber;
            HugeInteger input2(secondNumber.c_str());
            std::cout << "The second value entered is: " << input2 << std::endl;

            try {
                HugeInteger sum = input1 + input2;
                std::cout << "The sum of the 2 numbers is: " << sum << std::endl;
            } catch (const HugeInteger::OverflowException& e) {
                std::cout << "Exception occurred: " << e.what() << std::endl;
            } catch (const HugeInteger::StringTooLargeException& e) {
                std::cout << "Exception occurred: " << e.what() << std::endl;
            } catch (const HugeInteger::InvalidStringArgumentException& e) {
                std::cout << "Exception occurred: " << e.what() << std::endl;
            }

        } catch (const HugeInteger::OverflowException& e) {
            std::cout << "Exception occurred: " << e.what() << std::endl;
        } catch (const HugeInteger::StringTooLargeException& e) {
            std::cout << "Exception occurred: " << e.what() << std::endl;
        } catch (const HugeInteger::InvalidStringArgumentException& e) {
            std::cout << "Exception occurred: " << e.what() << std::endl;
        }

        std::cout << "Do you wish to continue (0 to stop, 1 to continue)? ";
        int choice;
        std::cin >> choice;
        if (choice == 0) break;
    }

    return 0;
}
