import java.util.InputMismatchException;
import java.util.Scanner;
import BankAccount.Account;
import BankAccount.Bank;
import BankException.IncorrectPassword;
import BankException.InsufficientFounds;
import BankException.InsufficientAmount;
import BankException.BankAppExecption;

public class Main{
    public static void main(String...args){
        Scanner userInput = new Scanner(System.in);
        Bank bank = new Bank();

        int choice = 0;
        do {
            System.out.println("""
                    
                    Welcome to Orabank!!
                    
                    1. Creeate account
                    2. Check Balance
                    3. Deposit
                    4. Withdraw
                    5. Transfer
                    6. Exit
                    
                    """);


            try {
                System.out.println("Choose from above: ");
                choice = userInput.nextInt();
                if (choice <= -1 || choice > 3) {
                    throw new IllegalArgumentException("Please! Choose only from above!");
                }
                switch (choice) {

                    case 1 -> {
                        System.out.print("Enter your first name: ");
                        String name = userInput.nextLine();
                        System.out.print("Enter your password: ");
                        String password = userInput.nextLine();
                        Account account = bank.createAccount(name, password);
                        System.out.println("Account created successfully!");
                        System.out.println("Your acoount NUMBER is: " + account.getAccountNumber());
                    }
                    case 2 -> {
                        System.out.println("Enter your account number: ");
                        String accountNumber = userInput.nextLine();
                        System.out.println("Enter your password: ");
                        String password = userInput.nextLine();
                        int theBalance = bank.showBalance(accountNumber, password);
                        System.out.println("Your balance is: " + theBalance);
                    }
                    case 3 -> {
                        System.out.println("Enter your account Number: ");
                        String accountNumber = userInput.nextLine();
                        System.out.println("Enter the amount: ");
                        int amount = userInput.nextInt();
                        bank.deposit(accountNumber, amount);
                        System.out.println("amount added successfully!");
                    }
                    case 4 -> {
                        System.out.println("Enter your account Number: ");
                        String accountNumber = userInput.nextLine();
                        System.out.println("Enter the amount: ");
                        int amount = userInput.nextInt();
                        System.out.println("Enter your password: ");
                        String password = userInput.nextLine();
                        bank.withdraw(accountNumber, amount, password);
                        System.out.println("withdrawn successfully!");
                    }
                    case 5 -> {
                        System.out.println("Enter your account Number: ");
                        String accountNumberOfTheSender = userInput.nextLine();
                        System.out.println("Enter the account Number of the receiver: ");
                        String accountNumberOfTheReceiver = userInput.nextLine();
                        System.out.println("Enter the amount: ");
                        int amount = userInput.nextInt();
                        System.out.println("Enter your password: ");
                        String password = userInput.nextLine();
                        bank.transfer(accountNumberOfTheSender, accountNumberOfTheReceiver, amount, password);
                        System.out.println("Transfert successfully executed!");
                    }
                }

            } catch (IllegalArgumentException error) {
                System.out.println("Error" + error.getMessage());
            } catch (InputMismatchException error) {
                System.out.println("Please! Choose only from above!");
            }
        }while (choice !=6);
    }
}