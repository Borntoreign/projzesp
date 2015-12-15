package pl.lodz.p.carpooling.reservation;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pl.lodz.p.carpooling.transit.Transit;
import pl.lodz.p.carpooling.user.User;

@Entity
public class Reservation {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	@ManyToOne
	@JoinColumn
	private User user;

	@ManyToOne
	@JoinColumn
	private Transit transit;

	private Date date;
	
	public Reservation() {
	}

	public Reservation(long id, User user, Transit transit, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.transit = transit;
		this.date = date;
	}

	public Reservation(User user, Transit transit, Date date) {
		this.user = user;
		this.transit = transit;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Transit getTransit() {
		return transit;
	}

	public void setTransit(Transit transit) {
		this.transit = transit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
