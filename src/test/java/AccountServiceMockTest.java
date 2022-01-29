import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Piotr Szydlowski on 29.01.2022
 */
public class AccountServiceMockTest {

    @Test
    void getAllActiveAccounts(){
        List<Account> accounts = prepareAccountData();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        given(accountRepository.getAllAccount()).willReturn(accounts);

        List<Account> accountList = accountService.getAllActiveAccount();

        assertThat(accountList, hasSize(2));
    }

    @Test
    void getNoActiveAccounts(){
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        given(accountRepository.getAllAccount()).willReturn(Arrays.asList());

        List<Account> accountList = accountService.getAllActiveAccount();

        assertThat(accountList, hasSize(0));
    }

    private List<Account> prepareAccountData(){
        Address address1 = new Address("Polkowa", "32");
        Account account1 = new Account(address1);

        Account account2 = new Account();

        Address address2 = new Address("Piekarska", "54/77");
        Account account3 = new Account(address2);

        return Arrays.asList(account1, account2, account3);
    }
}
