package pl.lodz.p.carpooling.transit.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Repository
interface RouteRepository extends JpaRepository<Route, Long> {
}
