
#include <string>
#include <memory>
#include "./persistence/UserRepository.h"
#include "./persistence/AccountRepository.h"
#include "./persistence/TransactionLog.h"

class Bank {
public:
    Bank(const std::string& usersPath,
               const std::string& accountsPath,
               const std::string& transactionsPath);

    bool login();
    void mainMenu();

    // operations used by commands
    void deposit();
    void withdraw();
    void transfer();
    void showBalance();
    void showHistory();

    const std::string& getCurrentUserId() const { return currentUserId; }

private:
    UserRepository userRepository;
    AccountRepository accountRepository;
    TransactionLog transactionLog;
    std::string currentUserId;

    std::string generateTransactionId() const;
    std::string generateTimestamp() const;
};