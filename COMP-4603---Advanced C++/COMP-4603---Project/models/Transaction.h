#pragma once
#include <string>

enum class TransactionType {
    Deposit,
    Withdraw,
    TransferOut,
    TransferIn
};

class Transaction {
public:
    std::string transactionId;
    std::string accountId;
    TransactionType type;
    double amount;
    std::string relatedAccountId; // for transfers
    std::string timestamp;        // string for simplicity

    Transaction() = default;

    Transaction(const std::string& newTransactionId,
                const std::string& newAccountId,
                TransactionType newType,
                double newAmount,
                const std::string& newRelatedAccountId,
                const std::string& newTimestamp)
        : transactionId(newTransactionId),
          accountId(newAccountId),
          type(newType),
          amount(newAmount),
          relatedAccountId(newRelatedAccountId),
          timestamp(newTimestamp) {}
};