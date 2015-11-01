package pl.lodz.p.carpooling.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.lodz.p.carpooling.user.account.Account;
import pl.lodz.p.carpooling.user.account.AccountService;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findAccountByLogin(username);
        if(account == null) {
            throw new UsernameNotFoundException("No user found with " + username);
        }
        return new AccountUserDetails(account);
    }
}
