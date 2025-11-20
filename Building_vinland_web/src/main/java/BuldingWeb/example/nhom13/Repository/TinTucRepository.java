package BuldingWeb.example.nhom13.Repository;

import BuldingWeb.example.nhom13.Entity.TinTuc;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TinTucRepository extends JpaRepository<TinTuc,Integer> {
    List<TinTuc> findAll(Sort sort);
}
