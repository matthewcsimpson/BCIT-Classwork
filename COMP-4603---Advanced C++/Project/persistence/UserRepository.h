#pragma once
#include <vector>
#include <optional>
#include "../models/User.h"

class UserRepository {
public:
    explicit UserRepository(const std::string& filePath);

    std::optional<User> findByUsername(const std::string& username) const;
    bool validatePassword(const std::string& username, const std::string& password) const;
    bool loadUsers();

private:
    std::string path;
    std::vector<User> users;
};