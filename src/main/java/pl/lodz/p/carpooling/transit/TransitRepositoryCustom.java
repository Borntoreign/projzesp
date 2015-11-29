package pl.lodz.p.carpooling.transit;

import pl.lodz.p.carpooling.user.User;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 29.11.15.
 */
interface TransitRepositoryCustom {
    List<Transit> findTransitByPassenger(User passenger);
}
