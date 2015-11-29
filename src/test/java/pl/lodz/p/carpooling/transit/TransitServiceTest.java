package pl.lodz.p.carpooling.transit;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.carpooling.CarpoolingApplication;
import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.security.WebSecurityInitializer;
import pl.lodz.p.carpooling.transit.route.Route;
import pl.lodz.p.carpooling.user.User;
import pl.lodz.p.carpooling.user.UserService;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;

/**
 * Created by Mateusz Surmanski on 29.11.15.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {CarpoolingApplication.class, WebSecurityInitializer.class})
@WebAppConfiguration
public class TransitServiceTest {

    public static final String EMAIL = "email@gmail.com";
    public static final String FIRST_NAME = "Jan";
    public static final String LAST_NAME = "Kowalski";
    public static final String CITY_NAME = "Lodz";
    public static final String PHONE_NUMBER = "555-555-555";
    public static final String START_CITY = "Łódź";
    public static final String END_CITY = "Warszawa";
    public static final String START_DATE = "20-11-2014 20:12";
    public static final String USERNAME = "driver";

    private TransitService transitService;

    @Autowired
    private TransitRepository transitRepository;

    private UserService userService;

    private User user;

    @Before
    public void setUp() throws Exception {
        userService = mock(UserService.class);
        transitService = new DefaultTransitService(transitRepository, userService);
        user = new User();
        user.setEmail(EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setPhoneNumber(PHONE_NUMBER);
        City city = new City();
        city.setCityName(CITY_NAME);
        user.setCity(city);

    }

    @Rollback
    @Test
    public void shouldCreateTransitFromEachAttributes() throws Exception {

        when(this.userService.findUserByUsername(anyString())).thenReturn(user);

        Transit transit = transitService.create(USERNAME, START_DATE, START_CITY, END_CITY);

        Transit transitResult = transitRepository.getOne(transit.getId());
        assertThat(transitResult).isNotNull();
        assertThat(transitResult.getDriver()).isNotNull();
        assertThat(transitResult.getDriver()).isEqualTo(user);
        assertThat(transitResult.getId()).isNotZero();
        assertThat(transitResult.getStartDate()).isNotNull();
        assertThat(transitResult.getRoute()).isNotNull();
        assertThat(transitResult.getRoute().getStartCity().getCityName()).isEqualTo(START_CITY);
        assertThat(transitResult.getRoute().getEndCity().getCityName()).isEqualTo(END_CITY);

    }

    @Rollback
    @Test
    public void shouldCreateTransit() throws Exception {
        when(this.userService.findUserByUsername(anyString())).thenReturn(user);

        LocalDateTime dateTime = LocalDateTime.now();
        Transit transit = new Transit(new Route(new City(START_CITY), new City(END_CITY), new BigDecimal(1)), dateTime, user);

        Transit transitCopy = transitService.create(transit);

        Transit transitResult = transitRepository.getOne(transitCopy.getId());
        assertThat(transitResult).isNotNull();
        assertThat(transitResult.getDriver()).isNotNull();
        assertThat(transitResult.getDriver()).isEqualTo(user);
        assertThat(transitResult.getId()).isNotZero();
        assertThat(transitResult.getStartDate()).isNotNull();
        assertThat(transitResult.getRoute()).isNotNull();
        assertThat(transitResult.getRoute().getStartCity().getCityName()).isEqualTo(START_CITY);
        assertThat(transitResult.getRoute().getEndCity().getCityName()).isEqualTo(END_CITY);
    }

    //TODO test implementation!
    @Rollback
    @Test
    public void shouldGetTransitsByUsername() throws Exception {

    }
}