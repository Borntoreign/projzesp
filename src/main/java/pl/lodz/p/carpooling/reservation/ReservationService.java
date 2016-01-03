package pl.lodz.p.carpooling.reservation;

import java.util.List;


public interface ReservationService {
	
	Reservation reserveTransit(String transitId, String username);
	
	List<Reservation> getReservationsByUsername(String username);
}
