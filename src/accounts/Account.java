package accounts;

import java.util.Date;
import java.util.Objects;

/* when you implement Comparable, it is possible that a warning
 * is given, which you should ignore for now, until we discuss Generics. 
 */
public abstract class Account implements Comparable<Object> {
    protected int accountNo;
    protected double balance;
    protected String fullName;
    protected Date dateOpened;
    protected double maxTransferable;

    /**
     * This method deposits <code> amount </code> to this account.
     * @param amount is the amount that is deposited to this account. 
     */
    public abstract void deposit(double amount);

    /**
     * This method withdraws <code> amount </code> from this account.
     * @param amount is the amount that should be withdrawn from this account.
     * @return It returns true if the transaction is done successfully. 
     * @throws Exception This method may throw either <code> NotEnoughMoneyException </code> or
     * <code> TransferNotAllowedException </code>.
     */
    public abstract boolean withdraw(double amount) throws Exception;

    /**
     * This method transfers money from this account to the given account.
     * @param to is the destination account, where the money is deposited to.
     * @param amount is the amount of money that is transferred. 
     * @return It returns true if the transaction is successful. 
     * @throws Exception This method may throw either <code> NotEnoughMoneyException </code> or
     * <code> TransferNotAllowedException </code>.
     */
    public boolean transferFrom(Account a, double amount) throws Exception {
        if (this.balance < amount) {
            throw new NotEnoughMoneyException("Not enough money");
        }
        
        if (this.maxTransferable < amount) {
            throw new TransferNotAllowedException("Max transferable limit is exceeded");
        }
        
        this.balance = this.balance - amount;
        a.balance = a.balance + amount;
        
        return true;
    }

    /**
     * This is the accessor method for <code> accountNo </code>
     * @return It returns the accountNo of this account.
     */
    public int getAccountNo() {
        return this.accountNo;
    }

    /**
     * This is the accessor method for <code> balance </code>
     * @return It returns the balance of the account.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * This is the accessor method for <code> fullName </code>
     * @return It returns the name of the holder of the account.
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * This is the accessor method for <code> dateOpened </code>
     * @return It returns the date at which the account was opened.
     */
    public Date getDateOpened() {
        return this.dateOpened;
    }

    /**
     * This is the accessor method for <code> maxTransferable </code>
     * @return It returns the maximum allowed amount that can be withdrawn from this account in one transaction.
     */
    public double getMaxTransferable() {
        return this.maxTransferable;
    }

    /**
     * This method compares two accounts. If the two accounts have the same values
     * for all the instance variables, they are considered equal and this 
     * method returns 0. If two objects were not equal, the account whose accountNo is less, 
     * is the smaller object so this method returns -1. Otherwise it returns 1.
     * @param object is an object of type account. 
     * @return It returns 0, if the two objects are equal. 
     * It returns -1, if this object is less than the object that is passed as a parameter into the method. 
     * It returns 1, if this object is greater than the object that is passed as a parameter into the method.
     */
    @Override
    public abstract int compareTo(Object oth);
}

class Current extends Account {
    
    // Parameterized constructor
    public Current(int accountNo, double balance, String fullName, Date dateOpened, double maxTransferable) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.fullName = fullName;
        this.dateOpened = dateOpened;
        this.maxTransferable = maxTransferable;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance = this.balance + amount;
        }
    }

    // Withdraw method
    public boolean withdraw(double amount) throws Exception {
        if (amount > this.balance) {
            throw new NotEnoughMoneyException("Not Enough Money");
        }
        if (amount > maxTransferable) {
            throw new TransferNotAllowedException("Transfer not allowed");
        }
        this.balance = this.balance - amount;
        return true;
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass() || obj == null) {
            return false;
        }
        
        Current other = (Current) obj;
        return this.getAccountNo() == other.getAccountNo() 
                && this.getBalance() == other.getBalance() 
                && this.getFullName().equals(other.getFullName()) 
                && this.getDateOpened().equals(other.getDateOpened()) 
                && this.getMaxTransferable() == other.getMaxTransferable();
    }

    // compareTo method
    @Override
    public int compareTo(Object o) {
        Account oth = (Account) o;
        if (this.getAccountNo() == oth.getAccountNo() && this.getBalance() == oth.getBalance() 
            && this.getFullName().equals(oth.getFullName()) 
            && this.getDateOpened().equals(oth.getDateOpened()) 
            && this.getMaxTransferable() == oth.getMaxTransferable()) {
            return 0;
        }
        if (oth.getAccountNo() > this.getAccountNo()) {
            return -1;
        } else {
            return 1;
        }
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(accountNo, balance, fullName, dateOpened, maxTransferable);
    }
}

/**
 * This class is a user-defined Exception used 
 * when transferring money is not allowed.
 */
class TransferNotAllowedException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public TransferNotAllowedException() {
        super();
    }

    public TransferNotAllowedException(String message) {
        super(message);
    }
}

/**
 * This is a user-defined exception used
 * when a transaction is unsuccessful due to lack
 * of enough money.
 */
class NotEnoughMoneyException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public NotEnoughMoneyException() {
        super();
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
