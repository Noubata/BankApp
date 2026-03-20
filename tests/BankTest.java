import BankAccount.Account;
import BankAccount.AccountNumberGenerator;
import BankAccount.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    void testThat_myBankHasNoaccount(){
        Bank orabank = new Bank("Orabank", new AccountNumberGenerator(234, 908765432));
        assertEquals(0, orabank.getSize());
    }
    @Test
    void testThat_createAnAccount_myBankHasOneAccount(){
        Bank orabank = new Bank("Orabank", new AccountNumberGenerator(234, 908765432));
        assertEquals(0, orabank.getSize());
        orabank.createAccount("Beny", "1234");
        assertEquals(1, orabank.getSize());
    }
    @Test
    void testThat_createAccount_theNumberIsKnown(){
        Bank orabank = new Bank("Orabank", new AccountNumberGenerator(234, 908765432));
        assertEquals(0, orabank.getSize());
        Account account = orabank.createAccount("Beny", "1234");
        assertEquals(1, orabank.getSize());
        assertEquals("1", account.getNuban());
    }
    @Test
    void testThat_deposit500_balance500(){
        Bank orabank = new Bank("Orabank", new AccountNumberGenerator(234, 908765432));
        orabank.createAccount("Beny", "1234");
        assertEquals(1, orabank.getSize());
        assertEquals(500, orabank.deposit("1", 500));
    }
    @Test
    void testThat_deposit500_withdraw200_balance300(){
        Bank orabank = new Bank("Orabank", new AccountNumberGenerator(234, 908765432));
        orabank.createAccount("Beny", "1234");
        assertEquals(500, orabank.deposit("1", 500));
        assertEquals(300, orabank.withdraw("1", 200, "1234"));
    }
    @Test
    void testThat_createAccountBeny_deposit200_transfer100ToChibuzo(){
        Bank orabank = new Bank("Orabank", new AccountNumberGenerator(234, 908765432)       );
        assertEquals(0, orabank.getSize());
        Account account = orabank.createAccount("Beny", "1234");
        Account account1 = orabank.createAccount("Chibuzo", "2234");
        assertEquals(2, orabank.getSize());
        orabank.deposit("1", 200);
        assertEquals(200, account.getBalance("1234"));
        orabank.transfer("1", "2", 100, "1234");
        assertEquals(100, account.getBalance("1234"));
    }
}
