package BankException;

public class InsufficientAmount extends BankAppExecption {
    public InsufficientAmount(String message){
        super(message);
    }
}
