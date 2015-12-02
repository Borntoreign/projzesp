package pl.lodz.p.carpooling.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.p.carpooling.transit.route.Route;

/**
 * Created by Mateusz Surmanski on 02.12.15.
 */
@Repository
interface CityRepository extends JpaRepository<City, Long> {
    City findCityByCityName(String cityName);
}
