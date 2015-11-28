package pl.lodz.p.carpooling.user.account;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;
import pl.lodz.p.carpooling.user.User;

import javax.persistence.*;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Entity
public class Account {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String login;

    @Length(min = 5)
    private String password;

    @OneToOne
    @Cascade(CascadeType.PERSIST)
    private User user;

    public Account() {
    }

    public Account(String login, String password, String email, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.user = new User(firstName, lastName, email);
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
