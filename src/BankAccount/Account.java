package BankAccount;

import BankException.IncorrectPassword;
import BankException.InsufficientAmount;
import BankException.InsufficientFounds;

public class Account {

    private String name;
    private int balance;
    private String password;

    public Account(String firstName, String password) {
        this.name = firstName;
        this.password = password;
    }

    public int getBalance(String password) {
        validate(password);
        return balance;
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
