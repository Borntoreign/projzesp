package pl.lodz.p.carpooling.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.lodz.p.carpooling.user.account.Account;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
public class AccountUserDetails implements UserDetails
{
    private final Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = () -> {
            return "USER";
        };
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Account getAccount() {
        return account;
    }
}
