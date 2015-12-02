package pl.lodz.p.carpooling.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.address.CityService;
import pl.lodz.p.carpooling.transit.Transit;
import pl.lodz.p.carpooling.transit.TransitService;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 29.11.15.
 */
@Service
public class DefaultSearchService implements SearchService {

    @Autowired
    private TransitService transitService;

    @Autowired
    private CityService cityService;

    @Override
    public List<Transit> findTransits(SearchTransitBean searchTransitBean) {
        if(searchTransitBean.getDate() == null) {
            return transitService.getTransits(searchTransitBean.getStartCity(),
                    searchTransitBean.getEndCity());
        }
        return transitService.getTransits(searchTransitBean.getStartCity(),
                searchTransitBean.getEndCity(), searchTransitBean.getDate());
    }

    @Override
    public List<Transit> findTransits(String startCity, String endCity, String date, String time) {
        City start = cityService.getCity(startCity);
        City end = cityService.getCity(endCity);
        SearchTransitBean searchTransitBean = new SearchTransitBean(start,end,date,time);
        return findTransits(searchTransitBean);
    }

    @Override
    public List<Transit> findTransits(String startCity, String endCity) {
        City start = cityService.getCity(startCity);
        City end = cityService.getCity(endCity);
        SearchTransitBean searchTransitBean = new SearchTransitBean(start,end);
        return findTransits(searchTransitBean);
    }


}
