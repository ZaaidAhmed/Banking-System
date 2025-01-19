# Banking System

## Overview

This project represents a **Banking System** implemented in Java that allows users to perform various banking operations like **deposit**, **withdraw**, **transfer** between accounts, and more. It utilizes object-oriented principles and includes custom exceptions to handle scenarios like insufficient balance or exceeding transfer limits.

The system supports:
- **Account management**: Each account has a unique account number, balance, account holder's name, and maximum transferable amount.
- **Transactions**: Users can deposit, withdraw, and transfer money between different accounts with various validation checks.
- **Custom Exceptions**: Handles errors like insufficient balance and transfer restrictions with user-defined exceptions.
  
## Features

- **Account Operations**:
  - Deposit money to an account.
  - Withdraw money with checks for sufficient balance and transfer limits.
  - Transfer money between two accounts with proper validations.

- **Custom Exceptions**:
  - `NotEnoughMoneyException`: Thrown when there are insufficient funds in the account for a transaction.
  - `TransferNotAllowedException`: Thrown when a transfer exceeds the allowable limit for the account.

- **Account Comparison**: Accounts can be compared based on their attributes (account number, balance, account holder's name, etc.).

## Classes & Structure

### `Account`
- An abstract class representing a general bank account. It defines basic operations such as depositing, withdrawing, and transferring money, along with accessors for various attributes like account number, balance, and account holder's name.

### `Current`
- A subclass of `Account` that represents a current bank account. This class implements deposit and withdraw functionalities and includes checks for insufficient funds and transfer restrictions.

### `NotEnoughMoneyException`
- A custom exception class thrown when there isn't enough balance to complete a transaction.

### `TransferNotAllowedException`
- A custom exception class thrown when a transfer exceeds the maximum allowable amount for the account.

## How to Use

1. **Clone the repository**:
git clone https://github.com/ZaaidAhmed/Banking-System.git

markdown
Copy

2. **Run the tests**:
- The project includes JUnit tests to validate the banking operations.
- Use your IDE or a command-line tool to run tests.

