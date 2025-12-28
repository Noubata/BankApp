package BankAccount;

import BankException.IncorrectPassword;
import BankException.InsufficientAmount;
import BankException.InsufficientFounds;

public class Account {

    private String name;
    private int balance;
    private String password;
    private String accountNumber;

    public Account(String firstName, String password) {
        this.name = firstName;
        this.password = password;
    }

    public int getBalance(String password) {
        validate(password);
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    private void validate(String password) {
        if (!this.password.equals(password)) {
            throw new IncorrectPassword("Invalid Password!!");
        }
    }

    public int deposit(int amount) {
        validate(amount);
        balance += amount;
        return balance;
    }
    private void validateAccountNumber(int accountNumber){
        if (!this.accountNumber.equals(accountNumber)){
            throw new IncorrectPassword("Invalid accountNumber!!");
        }
    }

    private void validate(int amount) {
        if (amount < 0) {
            throw new InsufficientAmount("Insufficient funds!!");
        }
    }

    public int withdraw(int amount, String password) {
        withdrawValidation(amount);
        balance-=amount;
        return balance;
    }

    private void withdrawValidation(int amount) {
        if (amount < 0){
            throw new InsufficientFounds("Insufficient funds!!");
        }
    }
}
