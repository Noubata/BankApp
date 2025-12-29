import java.util.InputMismatchException;
import java.util.Scanner;
import BankAccount.Account;
import BankAccount.AccountNumberGenerator;
import BankAccount.Bank;
import BankException.IncorrectPassword;
import BankException.InsufficientFounds;
import BankException.InsufficientAmount;
import BankException.BankAppExecption;

public class Main{
    public static void main(String...args){
        Scanner userInput = new Scanner(System.in);
        Bank orabank = new Bank("Orabank", new AccountNumberGenerator("123", 334322234));
        Bank semiBank = new Bank("semicolon", new AccountNumberGenerator("234", 908765432));

        int choice = 0;
        do {
            System.out.println("""
                    
                    Welcome to your favorite Chadian bank in naija!!
                   
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
                if (choice <= -1 || choice > 6) {
                    throw new IllegalArgumentException("Please! Choose only from above!");
                }
                switch (choice) {

                    case 1 -> {
                        System.out.println("""
                                
                                Which bank do you prefer:
                        1. Orabank
                        2. SemiBank
                               --------------------------
                        """);
                        System.out.print("Choose from above: ");
                        int chosenBank = userInput.nextInt();
                        if (chosenBank == 1){
                            System.out.print("Enter your first name: ");
                            String name = userInput.next();
                            System.out.print("Enter your password: ");
                            String password = userInput.next();
                            Account account = orabank.createAccount(name, password);
                            String accountNumber = account.getNuban();
                            System.out.println("Account created successfully!");
                            System.out.println("Your acoount NUMBER is: " + accountNumber);
                        }else {
                            System.out.print("Enter your first name: ");
                            String name = userInput.next();
                            System.out.print("Enter your password: ");
                            String password = userInput.next();
                            Account account = semiBank.createAccount(name, password);
                            String number = account.getNuban();
                            System.out.println("Account created successfully!");
                            System.out.println("Your acoount NUMBER is: " + number);
                        }
                    }
                    case 2 -> {
                        System.out.println("""
                                
                                Which bank do you want to check the balance:
                        1. Orabank
                        2. SemiBank
                               --------------------------
                        """);
                        System.out.print("Choose from above: ");
                        int checkBalance = userInput.nextInt();
                        if (checkBalance == 1) {
                            System.out.println("Enter your account number: ");
                            String accountNumber = userInput.next();
                            System.out.println("Enter your password: ");
                            String password = userInput.next();
                            double theBalance = orabank.showBalance(accountNumber, password);
                            System.out.println("Your balance is: " + theBalance);
                        }else {
                            System.out.println("Enter your account number: ");
                            String accountNumber = userInput.next();
                            System.out.println("Enter your password: ");
                            String password = userInput.next();
                            double theBalance = semiBank.showBalance(accountNumber, password);
                            System.out.println("Your balance is: " + theBalance);
                        }
                    }
                    case 3 -> {
                        System.out.println("""
                                
                                Which bank do you want to deposit to:
                        1. Orabank
                        2. SemiBank
                               --------------------------
                        """);
                        System.out.print("Choose from above: ");
                        int depositMoney = userInput.nextInt();
                        if (depositMoney == 1) {
                            System.out.println("Enter your account Number: ");
                            String accountNumber = userInput.next();
                            System.out.println("Enter the amount: ");
                            int amount = userInput.nextInt();
                            orabank.deposit(accountNumber, amount);
                            System.out.println("amount added successfully!");
                        }else {
                            System.out.println("Enter your account Number: ");
                            String accountNumber = userInput.next();
                            System.out.println("Enter the amount: ");
                            int amount = userInput.nextInt();
                            semiBank.deposit(accountNumber, amount);
                            System.out.println("amount added successfully!");
                        }
                    }
                    case 4 -> {
                        System.out.println("""
                                
                                Which bank do you want to withdraw from:
                        1. Orabank
                        2. SemiBank
                               --------------------------
                        """);
                        System.out.print("Choose from above: ");
                        int withdrawMoney = userInput.nextInt();
                        if (withdrawMoney == 1) {
                            System.out.println("Enter your account Number: ");
                            String accountNumber = userInput.next();
                            System.out.println("Enter the amount: ");
                            int amount = userInput.nextInt();
                            System.out.println("Enter your password: ");
                            String password = userInput.next();
                            orabank.withdraw(accountNumber, amount, password);
                            System.out.println("withdrawn successfully!");
                        }else {
                            System.out.println("Enter your account Number: ");
                            String accountNumber = userInput.next();
                            System.out.println("Enter the amount: ");
                            int amount = userInput.nextInt();
                            System.out.println("Enter your password: ");
                            String password = userInput.next();
                            semiBank.withdraw(accountNumber, amount, password);
                            System.out.println("withdrawn successfully!");
                        }
                    }
                    case 5 -> {
                        System.out.println("""
                                
                                Which bank do you want to withdraw from:
                        1. Orabank
                        2. SemiBank
                               --------------------------
                        """);
                        System.out.print("Choose from above: ");
                        int transferMoney = userInput.nextInt();
                        if (transferMoney == 1) {
                            System.out.println("Enter your account Number: ");
                            String accountNumberOfTheSender = userInput.next();
                            System.out.println("Enter the account Number of the receiver: ");
                            String accountNumberOfTheReceiver = userInput.next();
                            System.out.println("Enter the amount: ");
                            int amount = userInput.nextInt();
                            System.out.println("Enter your password: ");
                            String password = userInput.next();
                            orabank.transfer(accountNumberOfTheSender, accountNumberOfTheReceiver, amount, password);
                            System.out.println("Transfert successfully executed!");
                        }else{
                            System.out.println("Enter your account Number: ");
                            String accountNumberOfTheSender = userInput.next();
                            System.out.println("Enter the account Number of the receiver: ");
                            String accountNumberOfTheReceiver = userInput.next();
                            System.out.println("Enter the amount: ");
                            int amount = userInput.nextInt();
                            System.out.println("Enter your password: ");
                            String password = userInput.next();
                            semiBank.transfer(accountNumberOfTheSender, accountNumberOfTheReceiver, amount, password);
                            System.out.println("Transfert successfully executed!");
                        }
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