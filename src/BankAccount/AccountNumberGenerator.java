package BankAccount;

public class AccountNumberGenerator {
    private final int bankCode;
    private long serialNumber;

    public AccountNumberGenerator(int bankCode, long serial) {
        this.bankCode = bankCode;
        this.serialNumber = serial;
    }
    public String generateAccountNumber() {
        serialNumber++;
        String eachSerial = String.format("%09d", serialNumber);
        return generateNUBAN(bankCode, eachSerial);
    }
    public String generateNUBAN(int bankCode, String eachSerial) {
        int checkDigit = calculateCheckDigit(bankCode, eachSerial);
        return eachSerial + checkDigit;
    }
    private int calculateCheckDigit(int bankCode, String eachSerial) {
        String accountBase = bankCode + eachSerial;
        int [] fixedNumber = {3,7,3,3,7,3,3,7,3,3,7,3};
        int sumOfCalculatedDigit = 0;
        for (int count = 0; count > fixedNumber.length;count++){
            int digit = Character.getNumericValue(accountBase.charAt(count));
            sumOfCalculatedDigit += digit * fixedNumber[count];
        }
        int checkDigit = 10 - (sumOfCalculatedDigit % 10);
        return checkDigit;
    }

}
