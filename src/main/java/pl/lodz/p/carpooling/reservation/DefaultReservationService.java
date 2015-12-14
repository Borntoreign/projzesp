package pl.lodz.p.carpooling.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lodz.p.carpooling.transit.Transit;
import pl.lodz.p.carpooling.transit.TransitService;
import pl.lodz.p.carpooling.user.User;
import pl.lodz.p.carpooling.user.UserService;

@Service
public class DefaultReservationService implements ReservationService {
	
	private ReservationRepository reservationRepository;
	
	private UserService userService;
	
	private TransitService transitService;
	
	@Autowired
	public DefaultReservationService(
			ReservationRepository reservationRepository,
			UserService userService, TransitService transitService) {
		this.reservationRepository = reservationRepository;
		this.userService = userService;
		this.transitService = transitService;
	}

	@Override
	public Reservation reserveTransit(String transitId, String username) {
		User user = getUser(username);
		Transit transit = getTransit(transitId);
		Reservation reservation = new Reservation(user, transit);
		reservationRepository.save(reservation);
		return reservation;
	}
	
	@Override
	public List<Reservation> getReservationsByUsername(String username) {
		User user = getUser(username);
		List<Reservation> reservations = reservationRepository.findReservationsByUser(user);
		return reservations;
	}
	
	private User getUser(String username){
		return userService.findUserByUsername(username);
	}
	
	private Transit getTransit(String transitId){
		return transitService.getTransit(Long.parseLong(transitId));
	}

}
