package pl.lodz.p.carpooling.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lodz.p.carpooling.transit.Transit;

import java.util.List;

/**
 * Created by Mateusz Surmanski on 29.11.15.
 */
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/searchByRouteAndDate", method = RequestMethod.GET)
    public ResponseEntity findTransits(@RequestParam String startCity, @RequestParam String endCity, @RequestParam String date, @RequestParam String time) {
        try {
            List<Transit> transits = searchService.findTransits(startCity,endCity,date,time);
            return ResponseEntity.ok(transits);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/searchByRoute", method = RequestMethod.GET)
    public ResponseEntity findTransitsByRoute(@RequestParam String startCity, @RequestParam String endCity) {
        try {
            List<Transit> transits = searchService.findTransits(startCity,endCity);
            return ResponseEntity.ok(transits);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
