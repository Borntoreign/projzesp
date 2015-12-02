package pl.lodz.p.carpooling.transit.route;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import pl.lodz.p.carpooling.address.City;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Entity
public class Route {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private long id;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private City startCity;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private City endCity;

    public Route() {
    }

    public Route(City startCity, City endCity) {
        this.startCity = startCity;
        this.endCity = endCity;
    }

    public long getId() {
        return id;
    }

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public void setEndCity(City endCity) {
        this.endCity = endCity;
    }

}
