package pl.lodz.p.carpooling.transit;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.transit.route.Route;
import pl.lodz.p.carpooling.user.User;
import pl.lodz.p.carpooling.user.UserService;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Service
public class DefaultTransitService implements TransitService {

    @Autowired
    private TransitRepository transitRepository;

    @Autowired
    private UserService userService;

    @Override
    public Transit create(Transit transit) {
        return transitRepository.save(transit);
    }

    @Override
    public Transit create(String username, String startDate, String startCity, String endCity) {
        Route route = new Route(new City(startCity), new City(endCity), new BigDecimal(new Random().nextDouble()));
        User driver = userService.findUserByUsername(username);
        String pattern = "dd-MM-yyyy HH:mm";
        LocalDateTime date = LocalDateTime.parse(startDate, DateTimeFormat.forPattern(pattern));
        Transit transit = new Transit(route, date, driver);
        transitRepository.save(transit);
        return transit;
    }
}
