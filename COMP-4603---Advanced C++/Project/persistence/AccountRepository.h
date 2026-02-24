#pragma once

#include <vector>
#include <memory>
#include <optional>
#include <string>
#include "../models/Account.h"

class AccountRepository {
public:
    explicit AccountRepository(const std::string& filePath);

    bool loadAccounts();
    bool saveAccounts() const;

    std::vector<std::shared_ptr<Account>> findByUserId(const std::string& userId) const;
    std::optional<std::shared_ptr<Account>> findByAccountId(const std::string& accountId) const;

    void addAccount(const std::shared_ptr<Account>& account);
    void updateAccount(const std::shared_ptr<Account>& account);

private:
    std::string path;
    std::vector<std::shared_ptr<Account>> accounts;
};