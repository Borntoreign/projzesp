package pl.lodz.p.carpooling.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Service
public class DefaultAccountService implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void register(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void register(String login, String password, String email, String firstName, String lastName) {
        Account account = new Account(login,password,email,firstName,lastName);
    }

    @Override
    public Account findAccountByLogin(String login) {
        return accountRepository.findAccountByLogin(login);
    }
}
