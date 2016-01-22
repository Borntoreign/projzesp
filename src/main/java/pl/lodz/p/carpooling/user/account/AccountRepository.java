package pl.lodz.p.carpooling.user.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
{
    Account findAccountByLogin(String login);
}
