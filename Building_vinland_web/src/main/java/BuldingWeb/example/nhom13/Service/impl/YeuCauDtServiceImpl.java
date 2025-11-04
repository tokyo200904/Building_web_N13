package BuldingWeb.example.nhom13.Service.impl;

import BuldingWeb.example.nhom13.Entity.YeuCauDangTin;
import BuldingWeb.example.nhom13.Enums.TrangThaiYeuCau;
import BuldingWeb.example.nhom13.Mapper.YeuCauMapper;
import BuldingWeb.example.nhom13.Model.Reponse.YeuCauDtReponse;
import BuldingWeb.example.nhom13.Model.Reponse.chitietYcDtReponse;
import BuldingWeb.example.nhom13.Repository.BdsRepository;
import BuldingWeb.example.nhom13.Repository.YeuCauDtRepository;
import BuldingWeb.example.nhom13.Service.YeuCauDtService;
import BuldingWeb.example.nhom13.Utils.TtNdUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class YeuCauDtServiceImpl implements YeuCauDtService {
    @Autowired
    private YeuCauDtRepository yeuCauDtRepository;
    @Autowired
    private BdsRepository bdsRepository;
    @Autowired
    private TtNdUtil ttNdUtil;
    @Autowired
    private YeuCauMapper yeuCauMapper;
    @Override
    public List<YeuCauDtReponse> getAllYeuCauDt() {
        List<YeuCauDangTin> dto = yeuCauDtRepository.findByTrangThaiYeuCau(TrangThaiYeuCau.CHO_DUYET);

        return dto.stream()
                .map(yeuCauMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void DuyetYeuCauDt(Integer idYeuCauDt) {

    }

    @Override
    public void TuChoiYeuCauDt(Integer idYeuCauDt) {

    }

    @Override
    public chitietYcDtReponse getYeuCauDtById(Integer idYeuCauDt) {
        YeuCauDangTin yeuCau = yeuCauDtRepository.findById(idYeuCauDt)
                .orElseThrow(() -> new RuntimeException("khong tim thay"));
        if (yeuCau.getTrangThaiYeuCau() != TrangThaiYeuCau.CHO_DUYET) {
            throw new RuntimeException("Yeu cau da duoc xu ly");
        }
        return yeuCauMapper.convertTochitietDTO(yeuCau);
    }
}
