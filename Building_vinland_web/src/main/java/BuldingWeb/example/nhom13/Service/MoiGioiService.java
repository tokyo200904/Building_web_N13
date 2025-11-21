package BuldingWeb.example.nhom13.Service;

import BuldingWeb.example.nhom13.Model.MoiGioiDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MoiGioiService {
    public List<MoiGioiDTO> getAllMoiGioi();
    public MoiGioiDTO getMoiGioiById(Integer id);
    public void saveMoiGioi(MoiGioiDTO dto, MultipartFile imageFile) throws Exception;
    public void deleteMoiGioi(Integer id);
    public void addNhanVienMoiGioi(Integer moiGioiId, String email);
    public void xoaNhanVienMoiGioi(Integer moiGioiId, Integer idNhanVien) throws Exception;
}
