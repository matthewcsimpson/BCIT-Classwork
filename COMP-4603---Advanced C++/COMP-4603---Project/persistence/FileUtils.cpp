#include "./FileUtils.h"
#include <fstream>
#include <cstdio>

namespace FileUtils {

bool readAllLines(const std::string& filePath, std::vector<std::string>& lines) {
    std::ifstream inputStream(filePath);
    if (!inputStream.is_open()) {
        return false;
    }
    std::string currentLine;
    while (std::getline(inputStream, currentLine)) {
        lines.push_back(currentLine);
    }
    return true;
}

bool writeAllLinesAtomic(const std::string& filePath, const std::vector<std::string>& lines) {
    const std::string tempPath = filePath + ".tmp";

    std::ofstream outputStream(tempPath, std::ios::trunc);
    if (!outputStream.is_open()) {
        return false;
    }

    for (const std::string& line : lines) {
        outputStream << line << "\n";
    }
    outputStream.close();

    if (std::remove(filePath.c_str()) != 0) {
        // If remove fails, we still attempt rename; in worst case, manual cleanup needed.
    }
    if (std::rename(tempPath.c_str(), filePath.c_str()) != 0) {
        return false;
    }
    return true;
}

bool appendLine(const std::string& filePath, const std::string& line) {
    std::ofstream outputStream(filePath, std::ios::app);
    if (!outputStream.is_open()) {
        return false;
    }
    outputStream << line << "\n";
    return true;
}

}