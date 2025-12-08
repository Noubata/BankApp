package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();
    private int accountNumber = 1;
    private String firstName;

    public int getSize() {
        return accounts.size();
    }

    public Account createAccount(String firstName, String password) {
        Account account = new Account(firstName, password);
        account.setAccountNumber("" + accountNumber++);
        accounts.add(account);
        return account;
    }

    public Account getMeAccountNumberFromAccount(String accountNumber){
        return accounts.get(Integer.parseInt(accountNumber)-1);
    }
    public int deposit(String accountNumber, int amount) {
        return getMeAccountNumberFromAccount(accountNumber).deposit(amount);
    }
    public int withdraw(String accountNumber, int amount, String password) {
        return getMeAccountNumberFromAccount(accountNumber).withdraw(amount, password);
    }

    public void transfer(String accountNumberSender, String accountNumberReceiver, int amount, String password) {
        getMeAccountNumberFromAccount(accountNumberSender).withdraw(amount, password);
        getMeAccountNumberFromAccount(accountNumberReceiver).deposit(amount);

    }
}
