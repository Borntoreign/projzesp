package pl.lodz.p.carpooling.transit;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.transit.route.Route;
import pl.lodz.p.carpooling.user.User;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Repository
interface TransitRepository extends JpaRepository<Transit, Long>, TransitRepositoryCustom {

    List<Transit> findTransitsByDriver(User driver);

    List<Transit> findTransitsByRouteAndStartDate(Route route, LocalDateTime startDate);

    List<Transit> findTransitsByRoute(Route route);
}
