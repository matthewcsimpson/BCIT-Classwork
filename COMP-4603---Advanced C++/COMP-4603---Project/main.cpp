#include "Bank.h"
#include <iostream>

int main()
{
    Bank system("./data/users.txt", "./data/accounts.txt", "./data/transactions.txt");

    while (true)
    {
        if (!system.login())
        {
            std::cout << "Login failed. Try again? (y/n): ";
            std::string answer;
            std::getline(std::cin, answer);
            if (answer != "y" && answer != "Y")
            {
                break;
            }
            continue;
        }

        system.mainMenu();
        std::cout << "Logged out.\n";
    }

    return 0;
}