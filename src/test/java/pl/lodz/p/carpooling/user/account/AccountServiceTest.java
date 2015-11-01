package pl.lodz.p.carpooling.user.account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.lodz.p.carpooling.CarpoolingApplication;
import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.security.WebSecurityInitializer;
import pl.lodz.p.carpooling.user.User;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {CarpoolingApplication.class, WebSecurityInitializer.class})
@WebAppConfiguration
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void shouldRegisterToDatabase() throws Exception {
        Account account = new Account();
        account.setLogin("jkowalski");
        account.setPassword("password");
        User user = new User();
        user.setEmail("email@gmail.com");
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setPhoneNumber("555-555-555");
        City city = new City();
        city.setCityName("Lodz");
        city.setCountryName("Poland");
        user.setCity(city);
        account.setUser(user);

        accountService.register(account);

        Account jkowalski = accountService.findAccountByLogin("jkowalski");
        assertThat(jkowalski).isNotNull();
    }

}