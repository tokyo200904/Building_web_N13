package BuldingWeb.example.nhom13.Repository;

import BuldingWeb.example.nhom13.Entity.TinTuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinTucRepository extends JpaRepository<TinTuc,Integer> {
}
