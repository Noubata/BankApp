package BankAccount;

import BankException.IncorrectPassword;
import BankException.InsufficientAmount;
import BankException.InsufficientFounds;

public class Account {

    private String name;
    private double balance;
    private String password;
    private String nuban;
    private String serialNumber;

    public Account(String nuban, String firstName, String password) {
        this.nuban = nuban;
        this.name = firstName;
        this.password = password;
        this.balance = 0.0;
    }

    public String serialNumberGenerator(String serialNumber){
        int number = Integer.parseInt(serialNumber);
        int newNumber = number + 1;
        return String.format("%09d", newNumber);
    }

    public double getBalance(String password) {
        validate(password);
        return balance;
    }
    public String getNuban(){
        return nuban;
    }

    private void validate(String password) {
        if (!this.password.equals(password)) {
            throw new IncorrectPassword("Invalid Password!!");
        }
    }

    public double deposit(double amount) {
        validate(amount);
        balance += amount;
        return balance;
    }
    private void validateAccountNumber(int accountNumber){
        if (!this.nuban.equals(accountNumber)){
            throw new IncorrectPassword("Invalid accountNumber!!");
        }
    }

    private void validate(double amount) {
        if (amount < 0) {
            throw new InsufficientAmount("Insufficient funds!!");
        }
    }

    public double withdraw(double amount, String password) {
        withdrawValidation(amount);
        balance-=amount;
        return balance;
    }

    private void withdrawValidation(double amount) {
        if (amount < 0){
            throw new InsufficientFounds("Insufficient funds!!");
        }
    }
}
