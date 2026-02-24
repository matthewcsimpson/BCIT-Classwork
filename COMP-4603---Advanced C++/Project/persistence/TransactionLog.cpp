#include "TransactionLog.h"
#include "FileUtils.h"
#include <sstream>

TransactionLog::TransactionLog(const std::string& filePath)
    : path(filePath) {}

static std::string transactionTypeToString(TransactionType type) {
    switch (type) {
        case TransactionType::Deposit:     return "Deposit";
        case TransactionType::Withdraw:    return "Withdraw";
        case TransactionType::TransferOut: return "TransferOut";
        case TransactionType::TransferIn:  return "TransferIn";
        default:                           return "Unknown";
    }
}

static TransactionType transactionTypeFromString(const std::string& typeString) {
    if (typeString == "Deposit") return TransactionType::Deposit;
    if (typeString == "Withdraw") return TransactionType::Withdraw;
    if (typeString == "TransferOut") return TransactionType::TransferOut;
    if (typeString == "TransferIn") return TransactionType::TransferIn;
    return TransactionType::Deposit;
}

bool TransactionLog::append(const Transaction& transaction) {
    std::string line = transaction.transactionId + "," +
                       transaction.accountId + "," +
                       transactionTypeToString(transaction.type) + "," +
                       std::to_string(transaction.amount) + "," +
                       transaction.relatedAccountId + "," +
                       transaction.timestamp;
    return FileUtils::appendLine(path, line);
}

std::vector<Transaction> TransactionLog::findByAccountId(const std::string& accountId) const {
    std::vector<Transaction> result;
    std::vector<std::string> lines;
    FileUtils::readAllLines(path, lines);

    for (const std::string& line : lines) {
        if (line.empty()) {
            continue;
        }
        std::stringstream stream(line);
        std::string transactionId;
        std::string storedAccountId;
        std::string typeString;
        std::string amountString;
        std::string relatedAccountId;
        std::string timestamp;

        std::getline(stream, transactionId, ',');
        std::getline(stream, storedAccountId, ',');
        std::getline(stream, typeString, ',');
        std::getline(stream, amountString, ',');
        std::getline(stream, relatedAccountId, ',');
        std::getline(stream, timestamp, ',');

        if (storedAccountId != accountId) {
            continue;
        }

        double amount = std::stod(amountString);
        TransactionType type = transactionTypeFromString(typeString);

        result.emplace_back(transactionId, storedAccountId, type, amount, relatedAccountId, timestamp);
    }

    return result;
}