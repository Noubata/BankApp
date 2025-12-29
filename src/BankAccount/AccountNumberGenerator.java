package BankAccount;

public class AccountNumberGenerator {
    private final String bankCode;
    private long serial;

    public AccountNumberGenerator(String bankCode, long serial) {
        this.bankCode = bankCode;
        this.serial = serial;
    }
    public String generateAccountNumber() {
        serial++;
        String eachSerial = String.format("%09d", serial);
        return generateNUBAN(bankCode, eachSerial);
    }
    public String generateNUBAN(String bankCode, String eachSerial) {
        int checkDigit = calculateCheckDigit(bankCode, eachSerial);
        return bankCode.substring(0, 3) + eachSerial + checkDigit;
    }
    private int calculateCheckDigit(String bankCode, String serial) {
        String accountBase = bankCode.substring(0, 3) + serial;
        int [] fixedNumber = {3,7,3,3,7,3,3,7,3,3,7,3};
        int sumOfCalculatedDigit = 0;
        for (int count = 0; count > fixedNumber.length;count++){
            int digit = Character.getNumericValue(accountBase.charAt(count));
            sumOfCalculatedDigit += digit * fixedNumber[count];
        }
        int checkDigit = (10 - (sumOfCalculatedDigit % 10)) % 10;

        return checkDigit;
    }

}
