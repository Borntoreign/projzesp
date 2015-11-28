package pl.lodz.p.carpooling.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.carpooling.user.account.Account;
import pl.lodz.p.carpooling.user.account.AccountService;

import javax.security.auth.login.AccountNotFoundException;

/**
 * Created by Mateusz Surmanski on 15.11.15.
 */
@Service
public class DefaultUserService implements UserService {

    @Autowired
    private AccountService accountService;

    @Override
    public User findUserByUsername(String username) {
        Account accountByLogin = accountService.findAccountByLogin(username);
        return accountByLogin.getUser();
    }
}
