#pragma once

#include <memory>
#include <string>
#include "../models/Account.h"
#include "../strategies/InterestStrategy.h"

class AccountFactory {
public:
    static std::shared_ptr<Account> create(AccountType accountType,
                                           const std::string& userId,
                                           const std::string& accountId,
                                           double initialDeposit) {
        switch (accountType) {
            case AccountType::Savings: {
                auto strategy = std::make_shared<SavingsInterestStrategy>();
                return std::make_shared<Account>(accountId, userId, accountType, initialDeposit, strategy);
            }
            case AccountType::Chequing: {
                auto strategy = std::make_shared<ChequingInterestStrategy>();
                return std::make_shared<Account>(accountId, userId, accountType, initialDeposit, strategy);
            }
            default:
                return nullptr;
        }
    }
};