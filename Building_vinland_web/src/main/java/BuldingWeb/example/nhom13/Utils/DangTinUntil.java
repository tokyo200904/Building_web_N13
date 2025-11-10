package BuldingWeb.example.nhom13.Utils;

import BuldingWeb.example.nhom13.Entity.*;
import BuldingWeb.example.nhom13.Enums.TrangThaiYeuCau;
import BuldingWeb.example.nhom13.Mapper.BdsMapper;
import BuldingWeb.example.nhom13.Model.YeuCauDTO;
import BuldingWeb.example.nhom13.Repository.BdsRepository;
import BuldingWeb.example.nhom13.Repository.HinhAnhRepository;
import BuldingWeb.example.nhom13.Repository.HinhAnhYcRepository;
import BuldingWeb.example.nhom13.Repository.YeuCauDtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DangTinUntil {
    @Autowired
    private BdsRepository bdsRepository;
    @Autowired
    private YeuCauDtRepository yeuCauDtRepository;
    @Autowired
    private HinhAnhRepository hinhAnhRepository;
    @Autowired
    private HinhAnhYcRepository hinhAnhYcRepository;
    @Autowired
    private BdsMapper bdsMapper;

    @Transactional
    public void taoBds(YeuCauDTO dto, String anhChinh, List<String> anhPhuList, User user){
        BatDongSan bds = bdsMapper.mapToBds(dto);

        bds.setAnhChinh(anhChinh);
        bds.setUser(user);
        bds.setNgayTao(LocalDateTime.now());

        BatDongSan savedBds = bdsRepository.save(bds);
        if(!anhPhuList.isEmpty()){
            List<HinhAnh> hinhAnhs = anhPhuList.stream().map(anhPhu -> {
                HinhAnh hinhAnh = new HinhAnh();
                hinhAnh.setDuongDan(anhPhu);
                hinhAnh.setBatDongSan(savedBds);
                return hinhAnh;
            }).collect(Collectors.toList());
            hinhAnhRepository.saveAll(hinhAnhs);
        }
    }
    @Transactional
    public void taoYeuCauDt(YeuCauDTO dto, String anhChinh, List<String> anhPhuList, User user){
        YeuCauDangTin yeuCau = bdsMapper.mapToYeuCauDt(dto);
        yeuCau.setAnhChinh(anhChinh);
        yeuCau.setUserGuiYeuCau(user);
        yeuCau.setNgayTaoYeuCau(LocalDateTime.now());
        yeuCau.setTrangThaiYeuCau(TrangThaiYeuCau.CHO_DUYET);

        YeuCauDangTin savedYeuCau = yeuCauDtRepository.save(yeuCau);
        if (!anhPhuList.isEmpty()){
            List<HinhAnhYeuCau> hinhAnhYeuCaus = anhPhuList.stream().map(anhPhu -> {
                HinhAnhYeuCau ha = new HinhAnhYeuCau();
                ha.setDuongDan(anhPhu);
                ha.setYeuCauDangTin(savedYeuCau);
                return ha;
            }).collect(Collectors.toList());
            hinhAnhYcRepository.saveAll(hinhAnhYeuCaus);
        }
    }
}
