package pl.lodz.p.carpooling.transit;

import java.math.BigDecimal;
import org.joda.time.LocalDateTime;
import pl.lodz.p.carpooling.address.City;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
public interface TransitService {
    Transit create(Transit transit);

    Transit create(String username, String startDate, String startCity, String endCity, String cost);

    Transit edit(Long id, String username, String startDate, String startCityName, String endCityName, String cost);

    List<Transit> getTransitsByUsername(String username);

    Transit getTransit(Long id);

    void deleteTransit(Long id);

    List<Transit> getTransits(City startCity, City endCity, LocalDateTime startDate);

    List<Transit> getTransits(City startCity, City endCity);
}
