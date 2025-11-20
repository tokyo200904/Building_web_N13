package BuldingWeb.example.nhom13.Repository;

import BuldingWeb.example.nhom13.Entity.MoiGioi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoiGioiRepository extends JpaRepository<MoiGioi, Integer> {
    MoiGioi findByUser_UserId(Integer userId);
    boolean existsByTenCongTy(String tenCongTy);
}
