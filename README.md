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

Example with Maven:
mvn test

vbnet
Copy

3. **Create and manage accounts**:
- Create `Current` accounts using the constructor that requires account number, balance, full name, date of opening, and the maximum transferable amount.

4. **Perform transactions**:
- Use methods like `deposit(double amount)`, `withdraw(double amount)`, and `transferFrom(Account to, double amount)` to perform various transactions.

## Example Usage

```java
Date date = new Date();
Account johnAccount = new Current(101, 5000.0, "John Doe", date, 3000);
Account janeAccount = new Current(102, 3000.0, "Jane Doe", date, 2000);

// Deposit
johnAccount.deposit(1000); // John deposits 1000

// Withdraw
try {
 johnAccount.withdraw(500); // John withdraws 500
} catch (Exception e) {
 System.out.println(e.getMessage());
}

// Transfer
try {
 johnAccount.transferFrom(janeAccount, 1000); // Transfer 1000 from Jane to John
} catch (Exception e) {
 System.out.println(e.getMessage());
}
Testing
The project includes several unit tests that validate the operations of the Account and Current classes. These tests ensure that all bank transactions are correctly handled, including edge cases like insufficient funds or exceeded transfer limits.

Test cases include:

Deposit tests.
Withdraw tests.
Transfer tests (valid and invalid).
Account comparison.
Custom exception handling.
To run the tests, you can use a testing framework such as JUnit.
