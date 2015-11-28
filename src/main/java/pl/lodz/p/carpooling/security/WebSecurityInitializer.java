package pl.lodz.p.carpooling.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Created by Mateusz Surmański on 25.10.2015.
 */
@Configuration
@EnableWebMvcSecurity
public class WebSecurityInitializer extends WebSecurityConfigurerAdapter {

    @Autowired
    private DefaultUserDetailsService userDetailsService;

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }


    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .formLogin()
                .failureHandler(new FailureAuthenticationHandler())
                .successHandler(new SuccessAuthenticationHandler())
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .and()
                .authorizeRequests()
                .antMatchers("*//**//**//**//**//**//**//**//**")
                .permitAll();

    }
}
