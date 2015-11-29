package pl.lodz.p.carpooling.transit;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */
interface TransitService {
    Transit create(Transit transit);
    Transit create(String username, String startDate, String startCity, String endCity);

    List<Transit> getTransitsByUsername(String username);
}
