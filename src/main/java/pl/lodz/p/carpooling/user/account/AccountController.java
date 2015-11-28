package pl.lodz.p.carpooling.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

/**
 * Created by Mateusz Surmanski on 07.11.15.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public ResponseEntity getAccountForUsername(@PathVariable String username) {
        try {
            Account account = accountService.findAccountByLogin(username);
            if(account == null) {
                throw new AccountNotFoundException("Account : " + username + " not found");
            }
            return ResponseEntity.ok(account);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
