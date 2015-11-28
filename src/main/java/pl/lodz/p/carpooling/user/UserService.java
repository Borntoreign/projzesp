package pl.lodz.p.carpooling.user;

import javax.security.auth.login.AccountNotFoundException;

/**
 * Created by Mateusz Surmanski on 15.11.15.
 */
public interface UserService {
    User findUserByUsername(String username);
}
