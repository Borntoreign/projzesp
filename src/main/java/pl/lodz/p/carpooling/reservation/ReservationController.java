package pl.lodz.p.carpooling.reservation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping(value = "reservation", method = RequestMethod.POST)
    public ResponseEntity createReservation(@RequestBody Map<String, String> requestMap) {
        try {
            Reservation reservation = reservationService.reserveTransit(requestMap.get("transitId"), requestMap.get("username"));
            return ResponseEntity.ok(reservation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	@RequestMapping(value = "reservation/my/{user}", method = RequestMethod.GET)
    public ResponseEntity getMyReservation(@PathVariable String user) {
        try {
            List<Reservation> reservations = reservationService.getReservationsByUsername(user);
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	@RequestMapping(value = "reservation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteReservation(@PathVariable Long id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
