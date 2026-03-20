package BankAccount;

import BankException.IncorrectPassword;
import BankException.InsufficientAmount;
import BankException.InsufficientFounds;

public class Account {

    private String name;
    private double balance;
    private String password;
    private String nuban;

    public Account(String nuban, String name, String password) {
        this.nuban = nuban;
        this.name = name;
        this.password = password;
        this.balance = 0.0;
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
            throw new IllegalArgumentException("Invalid Password!!");
        }
    }
    public double deposit(double amount) {
        validate(amount);
        balance += amount;
        return balance;
    }
//    private void validateAccountNumber(int accountNumber){
//        if (!this.nuban.equals(accountNumber)){
//            throw new IncorrectPassword("Invalid accountNumber!!");
//        }
//    }
    private void validate(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Insufficient funds!!");
        }
    }
    public double withdraw(double amount, String password) {
        withdrawValidation(amount);
        balance-=amount;
        return balance;
    }
    private void withdrawValidation(double amount) {
        if (amount < 0){
            throw new IllegalArgumentException("Insufficient funds!!");
        }
    }
}
