package pl.lodz.p.carpooling.transit;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.address.CityService;
import pl.lodz.p.carpooling.converters.LocalDateTimeToTimestampConverter;
import pl.lodz.p.carpooling.transit.route.Route;
import pl.lodz.p.carpooling.transit.route.RouteService;
import pl.lodz.p.carpooling.user.User;
import pl.lodz.p.carpooling.user.UserService;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Service
public class DefaultTransitService implements TransitService {

    private TransitRepository transitRepository;

    private UserService userService;

    private RouteService routeService;

    private CityService cityService;

    @Autowired
    public DefaultTransitService(TransitRepository transitRepository, UserService userService, RouteService routeService, CityService cityService) {
        this.transitRepository = transitRepository;
        this.userService = userService;
        this.routeService = routeService;
        this.cityService = cityService;
    }

    @Override
    public Transit create(Transit transit) {
        return transitRepository.save(transit);
    }

    @Override
    public Transit create(String username, String startDate, String startCityName, String endCityName, String cost) {
        Route route = getRoute(startCityName, endCityName);
        User driver = userService.findUserByUsername(username);
        String pattern = "dd-MM-yyyy HH:mm";
        LocalDateTime date = LocalDateTime.parse(startDate, DateTimeFormat.forPattern(pattern));
        Transit transit = new Transit(route, date, driver);
        transit.setCost(new BigDecimal(cost));
        transit.setCostPerPerson(transit.getCost());
        if(transit.getPassengers() != null) {
            transit.setCostPerPerson(transit.getCost().divide(new BigDecimal(transit.getPassengers().size() + 1)));
        }
        transitRepository.save(transit);
        return transit;
    }

    @Override
    public Transit edit(Long id, String username, String startDate, String startCityName, String endCityName, String cost) {
        Transit transit = transitRepository.findOne(id);
        Route route = getRoute(startCityName, endCityName);
        transit.setRoute(route);
        User driver = userService.findUserByUsername(username);
        transit.setDriver(driver);
        String pattern = "dd-MM-yyyy HH:mm";
        LocalDateTime date = LocalDateTime.parse(startDate, DateTimeFormat.forPattern(pattern));
        transit.setStartDate(date);
        transit.setCost(new BigDecimal(cost));
        transitRepository.save(transit);
        return transit;
    }

    private Route getRoute(String startCityName, String endCityName) {
        City city = cityService.getCity(startCityName);
        City startCity = city == null? new City(startCityName) : city;
        city = cityService.getCity(endCityName);
        City endCity = city == null? new City(endCityName) : city;
        Route route = null;
        try {
            route = routeService.getRoute(startCity, endCity);
        }catch(InvalidDataAccessApiUsageException e) {
            route = new Route(startCity,endCity);
        }
        return route;
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

    @Override
    public List<Transit> getTransits(City startCity, City endCity, LocalDateTime startDate) {
        Route route = routeService.getRoute(startCity, endCity);
        return transitRepository.findTransitsByRouteAndStartDateGreaterThanEqual(route, startDate);
    }

    @Override
    public List<Transit> getTransits(City startCity, City endCity) {
        Route route = routeService.getRoute(startCity, endCity);
        return transitRepository.findTransitsByRoute(route);
    }
}
