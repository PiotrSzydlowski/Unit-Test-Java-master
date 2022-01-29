import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by Piotr Szydlowski on 29.01.2022
 */
class AccountServiceStubTest {

    @Test
    void getAllActiveAccounts(){
        AccountRepository accountRepositoryStub = new AccountRepositoryStub();
        AccountService accountService = new AccountService(accountRepositoryStub);

        List<Account> accountList = accountService.getAllActiveAccount();

        assertThat(accountList, hasSize(2));
    }

}