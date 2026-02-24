#pragma once
#include <string>

class User {
public:
    std::string userId;
    std::string username;
    std::string passwordHash; // for simplicity, store plain or very basic hash

    User() = default;

    User(const std::string& newUserId,
         const std::string& newUsername,
         const std::string& newPasswordHash)
        : userId(newUserId),
          username(newUsername),
          passwordHash(newPasswordHash) {}
};