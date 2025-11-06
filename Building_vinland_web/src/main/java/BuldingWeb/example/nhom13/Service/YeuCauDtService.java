package BuldingWeb.example.nhom13.Service;

import BuldingWeb.example.nhom13.Entity.YeuCauDangTin;
import BuldingWeb.example.nhom13.Model.Reponse.YeuCauDtReponse;
import BuldingWeb.example.nhom13.Model.Reponse.chitietYcDtReponse;

import java.util.List;

public interface YeuCauDtService {
    List<YeuCauDtReponse> getAllYeuCauDt();
    void DuyetYeuCauDt(Integer idYeuCauDt);
    void TuChoiYeuCauDt(Integer idYeuCauDt, String lyDoTuChoi);
    chitietYcDtReponse getYeuCauDtById(Integer idYeuCauDt);
}
