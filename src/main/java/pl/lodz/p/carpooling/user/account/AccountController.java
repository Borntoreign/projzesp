package pl.lodz.p.carpooling.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mateusz Surmanski on 07.11.15.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountForUsername(@PathVariable String username) {
        try {
            Account account = accountService.findAccountByLogin(username);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
