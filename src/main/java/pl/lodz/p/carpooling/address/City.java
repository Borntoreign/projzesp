package pl.lodz.p.carpooling.address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Entity
public class City {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String cityName;

    public City() {
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public long getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
