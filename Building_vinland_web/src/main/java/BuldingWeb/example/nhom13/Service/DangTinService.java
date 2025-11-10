package BuldingWeb.example.nhom13.Service;

import BuldingWeb.example.nhom13.Model.YeuCauDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DangTinService {
    public String dangTin(YeuCauDTO dto, MultipartFile anhChinh, List<MultipartFile> anhPhuList) throws Exception;
}
