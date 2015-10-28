package pl.lodz.p.carpooling.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Mateusz Surmański on 25.10.2015.
 */
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
    }
}
