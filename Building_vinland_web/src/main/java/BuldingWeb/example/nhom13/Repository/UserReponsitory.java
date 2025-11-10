package BuldingWeb.example.nhom13.Repository;

import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Enums.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserReponsitory extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    Optional <User> findByEmail(String email);
    Optional <User> findByVaiTro(VaiTro vaitro);

    @Query("SELECT u FROM User u WHERE u.vaiTro = :role " +
            "AND (LOWER(u.hoTen) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(u.email) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<User> findByVaiTroAndSearch(VaiTro role, String search);

}
