package BankAccount;

public class MultipleBanks {
    private Bank[] banks = new Bank[2];

    public Bank[] getBanks() {
        return banks;
    }

    public void bankCreation(){
        Bank gourrouss = new Bank();
        Bank ecobank = new Bank();
        Bank uba = new Bank();
        banks[0] = gourrouss;
        banks[1] = ecobank;
        banks[2] = uba;
    }
}
