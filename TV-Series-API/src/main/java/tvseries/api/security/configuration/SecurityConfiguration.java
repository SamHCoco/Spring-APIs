package tvseries.api.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// This class configures spring security
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * Configures the authentication manager to work with the 'APIUserDetailsService' implementation of
     * the 'UserDetailsService'.
     * @param auth Configures the 'AuthenticationManager' object, which handles user authentication.
     * Configurations for 'AuthenticationManager' can only be set by a 'AuthenticationManagerBuilder' object.
     * @throws Exception If something went wrong with the authentication process.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * Configures USER and ADMIN authorizations for the '/tv-series' resource,
     * by restricting their access.
     * @param http Configures security for specific HTTP requests.
     * @throws Exception If something went wrong with the authorization process.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/tv-series")
                .hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin();
    }

    /**
     * Encodes password in plain text.
     * @return PasswordEncoder object contain plain password.
     */
    @Bean // Password left in plain text for ease of testing and debugging
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
