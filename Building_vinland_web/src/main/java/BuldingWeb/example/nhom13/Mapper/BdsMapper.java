package BuldingWeb.example.nhom13.Mapper;

import BuldingWeb.example.nhom13.Entity.BatDongSan;
import BuldingWeb.example.nhom13.Entity.YeuCauDangTin;
import BuldingWeb.example.nhom13.Model.YeuCauDTO;
import org.springframework.stereotype.Component;

@Component
public class BdsMapper {
    public BatDongSan mapToBds(YeuCauDTO dto){
        BatDongSan bds = new BatDongSan();
        bds.setTieuDe(dto.getTieuDe());
        bds.setMoTa(dto.getMoTa());
        bds.setGia(dto.getGia());
        bds.setDonViTien(dto.getDonViTien());
        bds.setDienTich(dto.getDienTich());
        bds.setViTri(dto.getViTri());
        bds.setQuanHuyen(dto.getQuanHuyen());
        bds.setThanhPho(dto.getThanhPho());
        bds.setLoaiBds(dto.getLoaiBds());
        bds.setTrangThai(dto.getMucDichTinDang());
        bds.setSoPhongNgu(dto.getSoPhongNgu());
        bds.setSoPhongTam(dto.getSoPhongTam());
        bds.setTang(dto.getTang());
        bds.setTongTang(dto.getTongTang());
        bds.setNoiThat(dto.getNoiThat());
        bds.setNamXayDung(dto.getNamXayDung());
        bds.setBaiDoXe(dto.getBaiDoXe());
        bds.setBanCong(dto.getBanCong());
        bds.setThangMay(dto.getThangMay());
        return bds;
    }
    public YeuCauDangTin mapToYeuCauDt(YeuCauDTO dto){
        YeuCauDangTin yeuCau = new YeuCauDangTin();
        yeuCau.setTieuDe(dto.getTieuDe());
        yeuCau.setMoTa(dto.getMoTa());
        yeuCau.setGia(dto.getGia());
        yeuCau.setDonViTien(dto.getDonViTien());
        yeuCau.setDienTich(dto.getDienTich());
        yeuCau.setViTri(dto.getViTri());
        yeuCau.setQuanHuyen(dto.getQuanHuyen());
        yeuCau.setThanhPho(dto.getThanhPho());
        yeuCau.setLoaiBds(dto.getLoaiBds());
        yeuCau.setTrangThai(dto.getMucDichTinDang());
        yeuCau.setSoPhongNgu(dto.getSoPhongNgu());
        yeuCau.setSoPhongTam(dto.getSoPhongTam());
        yeuCau.setTang(dto.getTang());
        yeuCau.setTongTang(dto.getTongTang());
        yeuCau.setNoiThat(dto.getNoiThat());
        yeuCau.setNamXayDung(dto.getNamXayDung());
        yeuCau.setBaiDoXe(dto.getBaiDoXe());
        yeuCau.setBanCong(dto.getBanCong());
        yeuCau.setThangMay(dto.getThangMay());
        return yeuCau;
    }
}
