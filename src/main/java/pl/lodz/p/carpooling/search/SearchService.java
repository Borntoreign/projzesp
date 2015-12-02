package pl.lodz.p.carpooling.search;

import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.transit.Transit;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 29.11.15.
 */
public interface SearchService {
    List<Transit> findTransits(SearchTransitBean searchTransitBean);

    List<Transit> findTransits(String startCity, String endCity, String date, String time);

    List<Transit> findTransits(String startCity, String endCity);
}
