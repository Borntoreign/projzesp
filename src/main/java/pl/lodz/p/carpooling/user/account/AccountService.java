package pl.lodz.p.carpooling.user.account;

/**
 * Created by Mateusz Surmanski on 07.11.15.
 */
public interface AccountService {
    void register(Account account);

    void register(String login, String password, String email, String firstName, String lastName);

    Account findAccountByLogin(String login);
}
