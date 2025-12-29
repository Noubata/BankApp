package BankAccount;

import BankException.NoAccountException;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;
    private String firstName;
    private final AccountNumberGenerator generator;

    public Bank(String name, AccountNumberGenerator generator){
        this.accounts = new ArrayList<>();
        this.generator = generator;
        this.firstName = name;
    }
    public int getSize() {
        return accounts.size();
    }

    public Account createAccount(String firstName, String password) {
        String nuban = generator.generateAccountNumber();
        Account account = new Account(nuban,firstName, password);
        accounts.add(account);
        return account;
    }
    public Account getMeAccountNumberFromAccount(String accountNumber){
        return accounts.get(Integer.parseInt(accountNumber)-1);
    }
    public double deposit(String accountNumber, int amount) {
        return getMeAccountNumberFromAccount(accountNumber).deposit(amount);
    }
    public double withdraw(String accountNumber, int amount, String password) {
        return getMeAccountNumberFromAccount(accountNumber).withdraw(amount, password);
    }

    public void transfer(String accountNumberSender, String accountNumberReceiver, int amount, String password) {
        getMeAccountNumberFromAccount(accountNumberSender).withdraw(amount, password);
        getMeAccountNumberFromAccount(accountNumberReceiver).deposit(amount);

    }
    public double showBalance(String accountNumber, String password){
        double theBalance = getMeAccountNumberFromAccount(accountNumber).getBalance(password);
        return theBalance;
    }
}
