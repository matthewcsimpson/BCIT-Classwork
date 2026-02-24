#pragma once
#include <string>
#include <vector>

namespace FileUtils {
    bool readAllLines(const std::string& filePath, std::vector<std::string>& lines);
    bool writeAllLinesAtomic(const std::string& filePath, const std::vector<std::string>& lines);
    bool appendLine(const std::string& filePath, const std::string& line);
}