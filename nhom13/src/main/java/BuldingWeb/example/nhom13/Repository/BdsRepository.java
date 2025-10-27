package BuldingWeb.example.nhom13.Repository;

import BuldingWeb.example.nhom13.Entity.BatDongSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BdsRepository extends JpaRepository<BatDongSan,Integer> {

}
