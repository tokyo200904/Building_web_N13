package BuldingWeb.example.nhom13.Repository;

import BuldingWeb.example.nhom13.Entity.HinhAnhYeuCau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhAnhYcRepository extends JpaRepository<HinhAnhYeuCau, Integer> {
}
