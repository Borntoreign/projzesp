package pl.lodz.p.carpooling.transit.route;

import pl.lodz.p.carpooling.address.City;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
public interface RouteService {
    Route getRoute(City startCity, City endCity);
}
