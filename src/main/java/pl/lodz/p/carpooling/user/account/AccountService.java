package pl.lodz.p.carpooling.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void register(Account account) {
        accountRepository.save(account);
    }

    public Account findAccountByLogin(String login) {
        return accountRepository.findAccountByLogin(login);
    }
}
