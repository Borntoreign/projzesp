package pl.lodz.p.carpooling.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mateusz Surmanski on 02.12.15.
 */
@Service
public class DefaultCityService implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getCity(String cityName) {
        return cityRepository.findCityByCityNameIgnoreCase(cityName);
    }
}
