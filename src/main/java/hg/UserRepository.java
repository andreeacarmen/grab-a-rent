package hg;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long userId);
    User findByEmail(String email);
    List<User> findAllByOrderByIdAsc();
}
