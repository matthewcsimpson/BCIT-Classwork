#pragma once

#include <string>
#include <memory>
#include "../strategies/InterestStrategy.h"

enum class AccountType {
    Savings,
    Chequing
};

class Account {
protected:
    std::shared_ptr<InterestStrategy> interestStrategy;

public:
    std::string accountId;
    std::string userId;
    AccountType type;
    double balance;

    Account(const std::string& newAccountId,
            const std::string& newUserId,
            AccountType newType,
            double initialBalance,
            std::shared_ptr<InterestStrategy> newStrategy)
        : interestStrategy(std::move(newStrategy)),
          accountId(newAccountId),
          userId(newUserId),
          type(newType),
          balance(initialBalance) {}

    virtual ~Account() = default;

    virtual void deposit(double amount) {
        balance += amount;
    }

    virtual bool withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    double calculateInterest() const {
        if (!interestStrategy) {
            return 0.0;
        }
        return interestStrategy->calculate(balance);
    }
};