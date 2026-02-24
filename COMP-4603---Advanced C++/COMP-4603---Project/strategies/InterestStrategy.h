#pragma once
#include <memory>

class InterestStrategy {
public:
    virtual ~InterestStrategy() = default;
    virtual double calculate(double balance) const = 0;
};

class SavingsInterestStrategy : public InterestStrategy {
public:
    double calculate(double balance) const override {
        const double annualRate = 0.02;
        return balance * annualRate;
    }
};

class ChequingInterestStrategy : public InterestStrategy {
public:
    double calculate(double balance) const override {
        return 0.0;
    }
};