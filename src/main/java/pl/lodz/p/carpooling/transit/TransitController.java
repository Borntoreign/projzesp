package pl.lodz.p.carpooling.transit;

/**
 * Created by Mateusz Surmanski on 08.11.15.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "transit")
public class TransitController {

    @Autowired
    private TransitService transitService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createTransit(@RequestBody Map<String, String> requestMap) {
        try {
            Transit createdTransit = transitService.create(requestMap.get("driver"), requestMap.get("startDate"), requestMap.get("startCity"), requestMap.get("endCity"));
            return ResponseEntity.created(new URI("/transit/" + createdTransit.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "my/{user}", method = RequestMethod.GET)
    public ResponseEntity getMyTransit(@PathVariable String user) {
        try {
            List<Transit> transits = transitService.getTransitsByUsername(user);
            return ResponseEntity.ok(transits);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity getTransit(@PathVariable Long id) {
        try {
            Transit transit = transitService.getTransit(id);
            return ResponseEntity.ok(transit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTransit(@PathVariable Long id) {
        try {
            transitService.deleteTransit(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
