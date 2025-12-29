package BankAccount;

public class MultipleBanks {
    private Bank[] banks = new Bank[2];

    public Bank[] getBanks() {
        return banks;
    }

    public void bankCreation(){
        Bank gourrouss = new Bank("gourrouss");
        Bank ecobank = new Bank("Orabank");
        Bank uba = new Bank("Orabank");

    }
}
