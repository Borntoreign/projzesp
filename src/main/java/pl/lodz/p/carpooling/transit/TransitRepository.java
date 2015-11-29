package pl.lodz.p.carpooling.transit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.p.carpooling.user.User;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
@Repository
interface TransitRepository extends JpaRepository<Transit, Long>, TransitRepositoryCustom {

    List<Transit> findTransitsByDriver(User driver);
}
