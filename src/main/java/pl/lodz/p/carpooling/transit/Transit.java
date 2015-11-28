package pl.lodz.p.carpooling.transit;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.joda.time.LocalDateTime;
import pl.lodz.p.carpooling.transit.route.Route;
import pl.lodz.p.carpooling.user.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Entity
public class Transit {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private Route route;

    private LocalDateTime startDate;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    @JoinColumn
    private User driver;

    @ManyToMany
    @Cascade(CascadeType.PERSIST)
    private List<User> passengers;

    public Transit() {
    }

    public Transit(Route route, LocalDateTime startDate, User driver) {
        this.route = route;
        this.startDate = startDate;
        this.driver = driver;
    }

    public long getId() {
        return id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }
}
