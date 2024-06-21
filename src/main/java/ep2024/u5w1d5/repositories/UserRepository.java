package ep2024.u5w1d5.repositories;

import ep2024.u5w1d5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<User> findByUsernameStartingWithIgnoreCase(String search);
}
