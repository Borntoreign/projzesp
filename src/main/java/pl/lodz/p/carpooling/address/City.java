package pl.lodz.p.carpooling.address;

import pl.lodz.p.carpooling.persistent.PersistentObject;

import javax.persistence.Entity;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Entity
public class City extends PersistentObject {

    private String cityName;
    private String countryName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
