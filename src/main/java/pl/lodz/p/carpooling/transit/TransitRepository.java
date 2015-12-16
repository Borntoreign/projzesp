package pl.lodz.p.carpooling.transit;

import org.joda.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.lodz.p.carpooling.transit.route.Route;
import pl.lodz.p.carpooling.user.User;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@RepositoryRestResource
interface TransitRepository extends JpaRepository<Transit, Long>, TransitRepositoryCustom {

    List<Transit> findTransitsByDriver(User driver);

    List<Transit> findTransitsByRouteAndStartDate(Route route, LocalDateTime startDate);

    List<Transit> findTransitsByRouteAndStartDateGreaterThanEqual(Route route, LocalDateTime startDate);

    List<Transit> findTransitsByRoute(Route route);
}
