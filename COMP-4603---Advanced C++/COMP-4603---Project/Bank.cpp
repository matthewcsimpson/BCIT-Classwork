#include "./Bank.h"
#include <iostream>
#include <chrono>
#include <iomanip>
#include <sstream>

Bank::Bank(const std::string &usersPath,
           const std::string &accountsPath,
           const std::string &transactionsPath)
    : userRepository(usersPath),
      accountRepository(accountsPath),
      transactionLog(transactionsPath) {}

bool Bank::login()
{
    std::string username;
    std::string password;

    std::cout << "=== Bank System ===\n";
    std::cout << "Username: ";
    std::getline(std::cin, username);
    std::cout << "Password: ";
    std::getline(std::cin, password);

    if (!userRepository.validatePassword(username, password))
    {
        std::cout << "Invalid credentials.\n";
        return false;
    }

    auto userOpt = userRepository.findByUsername(username);
    if (!userOpt.has_value())
    {
        std::cout << "User not found.\n";
        return false;
    }

    currentUserId = userOpt->userId;
    return true;
}

void Bank::mainMenu()
{
    while (true)
    {
        std::cout << "\n=== Bank System ===\n";
        std::cout << "1) Deposit\n";
        std::cout << "2) Withdraw\n";
        std::cout << "3) Transfer\n";
        std::cout << "4) Check Balance\n";
        std::cout << "5) Transaction History\n";
        std::cout << "6) Logout\n";
        std::cout << "> ";

        int option = 0;
        std::string input;
        std::getline(std::cin, input);
        try
        {
            option = std::stoi(input);
        }
        catch (...)
        {
            option = 0;
        }

        switch (option)
        {
        case 1:
            deposit();
            break;
        case 2:
            withdraw();
            break;
        case 3:
            transfer();
            break;
        case 4:
            showBalance();
            break;
        case 5:
            showHistory();
            break;
        case 6:
            return;
        default:
            std::cout << "Invalid option.\n";
        }
    }
}

void Bank::deposit()
{
    std::cout << "Enter account id: ";
    std::string accountId;
    std::getline(std::cin, accountId);

    auto accountOpt = accountRepository.findByAccountId(accountId);
    if (!accountOpt.has_value() || accountOpt.value()->userId != currentUserId)
    {
        std::cout << "Account not found.\n";
        return;
    }

    std::cout << "Amount: ";
    std::string amountString;
    std::getline(std::cin, amountString);
    double amount = std::stod(amountString);

    auto account = accountOpt.value();
    account->deposit(amount);
    accountRepository.updateAccount(account);
    accountRepository.saveAccounts();

    Transaction transaction(generateTransactionId(),
                            account->accountId,
                            TransactionType::Deposit,
                            amount,
                            "",
                            generateTimestamp());
    transactionLog.append(transaction);

    std::cout << "Deposit successful. New balance: " << account->balance << "\n";
}

void Bank::withdraw()
{
    std::cout << "Enter account id: ";
    std::string accountId;
    std::getline(std::cin, accountId);

    auto accountOpt = accountRepository.findByAccountId(accountId);
    if (!accountOpt.has_value() || accountOpt.value()->userId != currentUserId)
    {
        std::cout << "Account not found.\n";
        return;
    }

    std::cout << "Amount: ";
    std::string amountString;
    std::getline(std::cin, amountString);
    double amount = std::stod(amountString);

    auto account = accountOpt.value();
    if (!account->withdraw(amount))
    {
        std::cout << "Insufficient funds.\n";
        return;
    }

    accountRepository.updateAccount(account);
    accountRepository.saveAccounts();

    Transaction transaction(generateTransactionId(),
                            account->accountId,
                            TransactionType::Withdraw,
                            amount,
                            "",
                            generateTimestamp());
    transactionLog.append(transaction);

    std::cout << "Withdraw successful. New balance: " << account->balance << "\n";
}

void Bank::transfer()
{
    std::cout << "Enter source account id: ";
    std::string sourceId;
    std::getline(std::cin, sourceId);

    auto sourceOpt = accountRepository.findByAccountId(sourceId);
    if (!sourceOpt.has_value() || sourceOpt.value()->userId != currentUserId)
    {
        std::cout << "Source account not found.\n";
        return;
    }

    std::cout << "Enter destination account id: ";
    std::string destinationId;
    std::getline(std::cin, destinationId);

    auto destinationOpt = accountRepository.findByAccountId(destinationId);
    if (!destinationOpt.has_value())
    {
        std::cout << "Destination account not found.\n";
        return;
    }

    std::cout << "Amount: ";
    std::string amountString;
    std::getline(std::cin, amountString);
    double amount = std::stod(amountString);

    auto sourceAccount = sourceOpt.value();
    auto destinationAccount = destinationOpt.value();

    if (!sourceAccount->withdraw(amount))
    {
        std::cout << "Insufficient funds.\n";
        return;
    }

    destinationAccount->deposit(amount);

    accountRepository.updateAccount(sourceAccount);
    accountRepository.updateAccount(destinationAccount);
    accountRepository.saveAccounts();

    std::string timestamp = generateTimestamp();

    Transaction outTransaction(generateTransactionId(),
                               sourceAccount->accountId,
                               TransactionType::TransferOut,
                               amount,
                               destinationAccount->accountId,
                               timestamp);
    transactionLog.append(outTransaction);

    Transaction inTransaction(generateTransactionId(),
                              destinationAccount->accountId,
                              TransactionType::TransferIn,
                              amount,
                              sourceAccount->accountId,
                              timestamp);
    transactionLog.append(inTransaction);

    std::cout << "Transfer successful.\n";
}

void Bank::showBalance()
{
    auto accounts = accountRepository.findByUserId(currentUserId);
    if (accounts.empty())
    {
        std::cout << "No accounts.\n";
        return;
    }

    std::cout << "Accounts for current user:\n";
    for (const auto &account : accounts)
    {
        std::string typeString = (account->type == AccountType::Savings) ? "Savings" : "Chequing";
        std::cout << "  " << account->accountId << " (" << typeString << "): "
                  << account->balance << "\n";
    }
}

void Bank::showHistory()
{
    std::cout << "Enter account id: ";
    std::string accountId;
    std::getline(std::cin, accountId);

    auto accountOpt = accountRepository.findByAccountId(accountId);
    if (!accountOpt.has_value() || accountOpt.value()->userId != currentUserId)
    {
        std::cout << "Account not found.\n";
        return;
    }

    auto transactions = transactionLog.findByAccountId(accountId);
    if (transactions.empty())
    {
        std::cout << "No transactions for this account.\n";
        return;
    }

    std::cout << "Transactions:\n";
    for (const Transaction &transaction : transactions)
    {
        std::cout << "  " << transaction.timestamp
                  << "  " << static_cast<int>(transaction.type)
                  << "  " << transaction.amount
                  << "  related: " << transaction.relatedAccountId << "\n";
    }
}

std::string Bank::generateTransactionId() const
{
    static unsigned long long counter = 1;
    return "tx-" + std::to_string(counter++);
}

std::string Bank::generateTimestamp() const
{
    auto now = std::chrono::system_clock::now();
    std::time_t timeNow = std::chrono::system_clock::to_time_t(now);
    std::tm timeStruct{};
#ifdef _WIN32
    localtime_s(&timeStruct, &timeNow);
#else
    localtime_r(&timeNow, &timeStruct);
#endif
    std::ostringstream stream;
    stream << std::put_time(&timeStruct, "%Y-%m-%d %H:%M:%S");
    return stream.str();
}