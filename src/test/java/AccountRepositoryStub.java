import java.util.Arrays;
import java.util.List;

/**
 * Created by Piotr Szydlowski on 29.01.2022
 */
public class AccountRepositoryStub implements AccountRepository{
    @Override
    public List<Account> getAllAccount() {
        Address address1 = new Address("Polkowa", "32");
        Account account1 = new Account(address1);

        Account account2 = new Account();

        Address address2 = new Address("Piekarska", "54/77");
        Account account3 = new Account(address2);

        return Arrays.asList(account1, account2, account3);
    }
}
