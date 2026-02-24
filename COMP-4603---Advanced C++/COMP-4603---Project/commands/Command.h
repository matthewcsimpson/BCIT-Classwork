#pragma once

class BankSystem; // forward declaration

class Command {
public:
    virtual ~Command() = default;
    virtual void execute(BankSystem& system) = 0;
};