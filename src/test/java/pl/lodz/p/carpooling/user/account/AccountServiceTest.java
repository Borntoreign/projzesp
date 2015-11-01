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

    public static final String JKOWALSKI = "jkowalski";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email@gmail.com";
    public static final String FIRST_NAME = "Jan";
    public static final String LAST_NAME = "Kowalski";
    public static final String CITY_NAME = "Lodz";
    public static final String COUNTRY_NAME = "Poland";
    public static final String PHONE_NUMBER = "555-555-555";
    @Autowired
    private AccountService accountService;

    @Test
    public void shouldRegisterToDatabaseAndGetItBack() throws Exception {
        Account account = new Account();
        account.setLogin(JKOWALSKI);
        account.setPassword(PASSWORD);
        User user = new User();
        user.setEmail(EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setPhoneNumber(PHONE_NUMBER);
        City city = new City();
        city.setCityName(CITY_NAME);
        city.setCountryName(COUNTRY_NAME);
        user.setCity(city);
        account.setUser(user);

        accountService.register(account);

        Account jkowalski = accountService.findAccountByLogin(JKOWALSKI);
        assertThat(jkowalski).isNotNull();
        assertThat(jkowalski.getLogin()).isEqualTo(JKOWALSKI);
        assertThat(jkowalski.getPassword()).isEqualTo(PASSWORD);
        User user1 = jkowalski.getUser();
        assertThat(user1).isNotNull();
        assertThat(user1.getEmail()).isEqualTo(EMAIL);
        assertThat(user1.getPhoneNumber()).isEqualTo(PHONE_NUMBER);
        assertThat(user1.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(user1.getLastName()).isEqualTo(LAST_NAME);
        City city1 = user1.getCity();
        assertThat(city1).isNotNull();
        assertThat(city1.getCityName()).isEqualTo(CITY_NAME);
        assertThat(city1.getCountryName()).isEqualTo(COUNTRY_NAME);
    }

}