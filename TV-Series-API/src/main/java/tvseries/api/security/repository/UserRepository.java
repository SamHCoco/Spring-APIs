package tvseries.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tvseries.api.security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
