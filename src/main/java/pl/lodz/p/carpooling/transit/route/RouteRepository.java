package pl.lodz.p.carpooling.transit.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.p.carpooling.address.City;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Repository
interface RouteRepository extends JpaRepository<Route, Long> {
    Route findRouteByStartCityAndEndCity(City startCity, City endCity);
}
