package pl.lodz.p.carpooling.user;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Email;
import pl.lodz.p.carpooling.address.City;
import pl.lodz.p.carpooling.persistent.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Entity
public class User extends PersistentObject {

    private String firstName;
    private String lastName;
    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private City city;
    @Email
    private String email;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
