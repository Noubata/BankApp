import BankAccount.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    void testThat_CreateAccount_BalanceIsZero(){
        Account account = new Account("nouba", "1234");
        assertEquals(0, account.getBalance("1234"));
    }
    @Test
    void testThat_deposit100_BalanceIs100(){
        Account account = new Account("nouba", "1234");
        assertEquals(0, account.getBalance("1234"));
        account.deposit(100);
        assertEquals(100, account.getBalance("1234"));
    }
    @Test
    void testThat_deposit500_withdraw200_BalanceIs300(){
        Account account = new Account("nouba", "1234");
        account.deposit(500);
        assertEquals(500, account.getBalance("1234"));
        account.withdraw(200, "1234");
        assertEquals(300, account.getBalance("1234"));
    }
}
