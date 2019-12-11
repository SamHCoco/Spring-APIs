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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        // test whether user found, throw exception if not
        user.orElseThrow(() -> new UsernameNotFoundException("ERROR: USER " + userName + " NOT FOUND"));
        // return 'UserDetails' object with found user
        return user.map(APIUserDetails::new).get();
    }
}
