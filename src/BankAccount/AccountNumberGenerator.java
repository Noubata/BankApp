package BankAccount;

public class AccountNumberGenerator {
    private final String bankCode;
    private long serial;

    public AccountNumberGenerator(String bankCode, long serial) {
        this.bankCode = bankCode;
        this.serial = serial;
    }
    public synchronized String generateNUBAN() {
        serial++;
        String eachSerial = String.format("%09d", serial);
        int checkDigit = calculateCheckDigit(bankCode, eachSerial);
        return eachSerial + checkDigit;
    }

        // you already know this method
    private int calculateCheckDigit(String bankCode, String serial) {
            // implementation omitted (you know it)
        return 0;
    }

}
