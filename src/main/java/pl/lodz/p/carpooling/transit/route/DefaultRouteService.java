package pl.lodz.p.carpooling.transit.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.carpooling.address.City;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Service
public class DefaultRouteService implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route getRoute(City startCity, City endCity) {
        return routeRepository.findRouteByStartCityAndEndCity(startCity, endCity);
    }
}
