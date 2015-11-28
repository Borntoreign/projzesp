package pl.lodz.p.carpooling.transit;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.lodz.p.carpooling.transit.route.Route;
import pl.lodz.p.carpooling.user.User;

import java.net.URI;
import java.util.Map;

@RestController
public class TransitController {

    @Autowired
    private TransitService transitService;

    @RequestMapping(value = "/transit", method = RequestMethod.POST)
    public ResponseEntity createTransit(@RequestBody Map<String, String> requestMap) {
        try {
            Transit createdTransit = transitService.create(requestMap.get("driver"), requestMap.get("startDate"), requestMap.get("startCity"), requestMap.get("endCity"));
            return ResponseEntity.created(new URI("/transit/" + createdTransit.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
