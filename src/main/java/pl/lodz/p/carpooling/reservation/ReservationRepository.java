package pl.lodz.p.carpooling.reservation;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodz.p.carpooling.user.User;

interface ReservationRepository  extends JpaRepository<Reservation, Long>{
	
	List<Reservation> findReservationsByUser(User user);
}
