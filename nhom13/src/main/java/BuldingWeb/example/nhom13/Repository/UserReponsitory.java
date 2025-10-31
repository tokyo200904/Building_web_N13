package BuldingWeb.example.nhom13.Repository;

import BuldingWeb.example.nhom13.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReponsitory extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    Optional <User> findByEmail(String email);
    Optional <User> findByvaitro(String vaitro);
}
