#include "AccountRepository.h"
#include "FileUtils.h"
#include "../factory/AccountFactory.h"
#include <sstream>

AccountRepository::AccountRepository(const std::string& filePath)
    : path(filePath) {
    loadAccounts();
}

bool AccountRepository::loadAccounts() {
    accounts.clear();
    std::vector<std::string> lines;
    if (!FileUtils::readAllLines(path, lines)) {
        return false;
    }

    for (const std::string& line : lines) {
        if (line.empty()) {
            continue;
        }
        std::stringstream stream(line);
        std::string accountId;
        std::string userId;
        std::string typeString;
        std::string balanceString;

        std::getline(stream, accountId, ',');
        std::getline(stream, userId, ',');
        std::getline(stream, typeString, ',');
        std::getline(stream, balanceString, ',');

        AccountType type = AccountType::Savings;
        if (typeString == "Savings") {
            type = AccountType::Savings;
        } else if (typeString == "Chequing") {
            type = AccountType::Chequing;
        }

        double balance = std::stod(balanceString);

        auto account = AccountFactory::create(type, userId, accountId, balance);
        if (account) {
            accounts.push_back(account);
        }
    }
    return true;
}

bool AccountRepository::saveAccounts() const {
    std::vector<std::string> lines;
    for (const auto& account : accounts) {
        std::string typeString = (account->type == AccountType::Savings) ? "Savings" : "Chequing";
        std::string line = account->accountId + "," +
                           account->userId + "," +
                           typeString + "," +
                           std::to_string(account->balance);
        lines.push_back(line);
    }

    return FileUtils::writeAllLinesAtomic(path, lines);
}

std::vector<std::shared_ptr<Account>> AccountRepository::findByUserId(const std::string& userId) const {
    std::vector<std::shared_ptr<Account>> result;
    for (const auto& account : accounts) {
        if (account->userId == userId) {
            result.push_back(account);
        }
    }
    return result;
}

std::optional<std::shared_ptr<Account>> AccountRepository::findByAccountId(const std::string& accountId) const {
    for (const auto& account : accounts) {
        if (account->accountId == accountId) {
            return account;
        }
    }
    return std::nullopt;
}

void AccountRepository::addAccount(const std::shared_ptr<Account>& account) {
    accounts.push_back(account);
}

void AccountRepository::updateAccount(const std::shared_ptr<Account>& account) {
    for (std::size_t index = 0; index < accounts.size(); ++index) {
        if (accounts[index]->accountId == account->accountId) {
            accounts[index] = account;
            return;
        }
    }
}