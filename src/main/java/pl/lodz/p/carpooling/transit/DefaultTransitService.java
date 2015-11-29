package pl.lodz.p.carpooling.transit;

import com.google.common.collect.Lists;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.transit.route.Route;
import pl.lodz.p.carpooling.user.User;
import pl.lodz.p.carpooling.user.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Service
public class DefaultTransitService implements TransitService {

    private TransitRepository transitRepository;

    private UserService userService;

    @Autowired
    public DefaultTransitService(TransitRepository transitRepository, UserService userService) {
        this.transitRepository = transitRepository;
        this.userService = userService;
    }

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

    //TODO finish it!
    @Override
    public List<Transit> getTransitsByUsername(String username) {
        User user = userService.findUserByUsername(username);
        List<Transit> transitsByDriver = transitRepository.findTransitsByDriver(user);
        // List<Transit> transitsByPassenger = transitRepository.findTransitByPassenger(user);
        // transitsByDriver.addAll(transitsByPassenger);
        List<Transit> transits = Lists.reverse(transitsByDriver.stream().sorted(new TransitDateComparator()).collect(Collectors.toList()));
        return transits;
    }

    @Override
    public Transit getTransit(Long id) {
        return transitRepository.findOne(id);
    }

    @Override
    public void deleteTransit(Long id) {
        transitRepository.delete(id);
    }
}
