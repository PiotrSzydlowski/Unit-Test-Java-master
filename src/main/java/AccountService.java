import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Piotr Szydlowski on 29.01.2022
 */
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    List<Account> getAllActiveAccount(){
        return accountRepository.getAllAccount()
                .stream()
                .filter(Account::isActive)
                .collect(Collectors.toList());
    }
}
