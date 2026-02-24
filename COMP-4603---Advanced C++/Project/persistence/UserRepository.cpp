#include "UserRepository.h"
#include "FileUtils.h"
#include <sstream>

UserRepository::UserRepository(const std::string& filePath)
    : path(filePath) {
    loadUsers();
}

bool UserRepository::loadUsers() {
    users.clear();
    std::vector<std::string> lines;
    if (!FileUtils::readAllLines(path, lines)) {
        return false;
    }

    for (const std::string& line : lines) {
        if (line.empty()) {
            continue;
        }
        std::stringstream stream(line);
        std::string userId;
        std::string username;
        std::string passwordHash;

        std::getline(stream, userId, ',');
        std::getline(stream, username, ',');
        std::getline(stream, passwordHash, ',');

        users.emplace_back(userId, username, passwordHash);
    }
    return true;
}

std::optional<User> UserRepository::findByUsername(const std::string& username) const {
    for (const User& user : users) {
        if (user.username == username) {
            return user;
        }
    }
    return std::nullopt;
}

bool UserRepository::validatePassword(const std::string& username, const std::string& password) const {
    auto userOpt = findByUsername(username);
    if (!userOpt.has_value()) {
        return false;
    }
    const User& foundUser = userOpt.value();
    // For now plain text compare.
    return foundUser.passwordHash == password;
}