package pl.lodz.p.carpooling.user.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.carpooling.CarpoolingApplication;
import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.security.WebSecurityInitializer;
import pl.lodz.p.carpooling.user.User;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {CarpoolingApplication.class, WebSecurityInitializer.class})
@WebAppConfiguration
public class AccountServiceTest {

    public static final String USERNAME = "jkowalski";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email@gmail.com";
    public static final String FIRST_NAME = "Jan";
    public static final String LAST_NAME = "Kowalski";
    public static final String CITY_NAME = "Lodz";
    public static final String PHONE_NUMBER = "555-555-555";

    @Autowired
    private DefaultAccountService accountService;

    @Rollback
    @Test
    public void shouldRegisterToDatabaseAndGetItBack() throws Exception {
        Account account = new Account();
        account.setLogin(USERNAME);
        account.setPassword(PASSWORD);
        User user = new User();
        user.setEmail(EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setPhoneNumber(PHONE_NUMBER);
        City city = new City();
        city.setCityName(CITY_NAME);
        user.setCity(city);
        account.setUser(user);

        accountService.register(account);

        Account accountResult = accountService.findAccountByLogin(USERNAME);
        assertThat(accountResult).isNotNull();
        assertThat(accountResult.getLogin()).isEqualTo(USERNAME);
        assertThat(accountResult.getPassword()).isEqualTo(PASSWORD);
        User userResult = accountResult.getUser();
        assertThat(userResult).isNotNull();
        assertThat(userResult.getEmail()).isEqualTo(EMAIL);
        assertThat(userResult.getPhoneNumber()).isEqualTo(PHONE_NUMBER);
        assertThat(userResult.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(userResult.getLastName()).isEqualTo(LAST_NAME);
        City cityResult = userResult.getCity();
        assertThat(cityResult).isNotNull();
        assertThat(cityResult.getCityName()).isEqualTo(CITY_NAME);
    }

}