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

        System.out.println("""
                
                Welcome to Orabank!!
                
                1. Login
                2. Creeate account
                3. Exit
                
                """);

        int choice = 0;
        try {
            System.out.println("Choose from above: ");
            choice = userInput.nextInt();
            if (choice <= -1 || choice > 3) {
                throw new IllegalArgumentException("Please! Choose only from above!");
            }
            switch (choice){
                case 1 -> {
                    System.out.println("Enter your firstName: ");
                    String username = userInput.nextLine();
                    System.out.print("Enter password: ");
                    String pass = userInput.nextLine();
                }
                case 2 -> {
                    System.out.print("Enter your first name: ");
                    String firstName = userInput.nextLine();
                    System.out.print("Enter your last name: ");
                    String lastName = userInput.nextLine();
                    System.out.print("Enter your password: ");
                    String password = userInput.nextLine();

                }


            }
        }catch(IllegalArgumentException error){
                System.out.println("Error" + error.getMessage());
        } catch (InputMismatchException error) {
            System.out.println("Please! Choose only from above!");
        }
    }
}