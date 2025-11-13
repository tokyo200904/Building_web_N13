package BuldingWeb.example.nhom13.Repository;

import BuldingWeb.example.nhom13.Entity.YeuCauDangTinTuc;
import BuldingWeb.example.nhom13.Enums.TrangThaiYeuCauTinTuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YeuCauDangTinTucRepository extends JpaRepository<YeuCauDangTinTuc, Integer> {

    List<YeuCauDangTinTuc> findByTrangThaiYeuCauTt(TrangThaiYeuCauTinTuc status);
}
