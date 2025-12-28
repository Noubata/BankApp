package BankException;

public class NoAccountException extends BankAppExecption {
    public NoAccountException(String message) {
        super(message);
    }
}
