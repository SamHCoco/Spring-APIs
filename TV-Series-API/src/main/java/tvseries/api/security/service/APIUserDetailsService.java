package tvseries.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tvseries.api.security.repository.UserRepository;
import tvseries.api.security.model.APIUserDetails;
import tvseries.api.security.model.User;

import java.util.Optional;

@Service
public class APIUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * Checks whether the user passed as an argument exists in the database and returns
     * the UserDetails object containing the user's details (username, password etc).
     * @param userName The user name of the API user.
     * @return The user's details: username, password, roles and authorities.
     * @throws UsernameNotFoundException Throws exception if the user could not be found in database.
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("ERROR: USER " + userName + " NOT FOUND"));
        return user.map(APIUserDetails::new).get();
    }
}
