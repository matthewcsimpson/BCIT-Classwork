#pragma once
#include <string>
#include <vector>
#include "../models/Transaction.h"

class TransactionLog {
public:
    explicit TransactionLog(const std::string& filePath);

    bool append(const Transaction& transaction);
    std::vector<Transaction> findByAccountId(const std::string& accountId) const;

private:
    std::string path;
};