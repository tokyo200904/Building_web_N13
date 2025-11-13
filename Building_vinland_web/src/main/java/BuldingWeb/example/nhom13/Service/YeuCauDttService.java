package BuldingWeb.example.nhom13.Service;

import BuldingWeb.example.nhom13.Model.Reponse.DetailTtReponse;
import BuldingWeb.example.nhom13.Model.Reponse.dangTinTucReponse;
import BuldingWeb.example.nhom13.Model.YeuCauTinTucDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface YeuCauDttService {
    public String dangTinTuc(dangTinTucReponse dto , MultipartFile anh) throws Exception;
    public List<YeuCauTinTucDTO> getAllDuyetTinTuc();
    public DetailTtReponse getChiTietDuyetTt(Integer yeuCauId);
    public void duyetTinTuc(Integer yeuCauId);
    public void TuChoiTinTuc(Integer yeuCauId, String lyDo);
}
