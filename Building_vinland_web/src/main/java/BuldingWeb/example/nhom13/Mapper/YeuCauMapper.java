package BuldingWeb.example.nhom13.Mapper;

import BuldingWeb.example.nhom13.Entity.HinhAnh;
import BuldingWeb.example.nhom13.Entity.HinhAnhYeuCau;
import BuldingWeb.example.nhom13.Entity.YeuCauDangTin;
import BuldingWeb.example.nhom13.Model.Reponse.YeuCauDtReponse;
import BuldingWeb.example.nhom13.Model.Reponse.chitietYcDtReponse;

public class YeuCauMapper {
    public YeuCauDtReponse convertToDTO(YeuCauDangTin yeuCau) {
        YeuCauDtReponse dto = new YeuCauDtReponse();
        dto.setMaYeuCauBds(yeuCau.getMaYeuCauBds());
        dto.setTieuDe(yeuCau.getTieuDe());
        dto.setNgayTaoYeuCau(yeuCau.getNgayTaoYeuCau());
        if (yeuCau.getUserGuiYeuCau() != null){
            dto.setTenNguoiGui(yeuCau.getUserGuiYeuCau().getHoTen());
        }
        else {
            dto.setTenNguoiGui("N/A");
        }
        dto.setGia(yeuCau.getGia());
        dto.setDienTich(yeuCau.getDienTich());
        dto.setDiaChi(yeuCau.getQuanHuyen()+", "+yeuCau.getThanhPho());
        dto.setAnhChinh(yeuCau.getAnhChinh());
        return dto;
    }
    public chitietYcDtReponse convertTochitietDTO(YeuCauDangTin yeuCau) {
        chitietYcDtReponse dto = new chitietYcDtReponse();
        dto.setMaYeuCauBds(yeuCau.getMaYeuCauBds());
        dto.setTieuDe(yeuCau.getTieuDe());
        dto.setMoTa(yeuCau.getMoTa());
        dto.setNgayTaoYeuCau(yeuCau.getNgayTaoYeuCau());
        if(yeuCau.getUserGuiYeuCau()!= null){
            dto.setTenNguoiGui(yeuCau.getUserGuiYeuCau().getHoTen());
            dto.setEmailNguoiGui(yeuCau.getUserGuiYeuCau().getEmail());
            dto.setSdtNguoiGui(yeuCau.getUserGuiYeuCau().getSoDienThoai());
        }
        dto.setGia(yeuCau.getGia());
        dto.setDonViTien(String.valueOf(yeuCau.getDonViTien()));
        dto.setDienTich(yeuCau.getDienTich());
        dto.setViTri(yeuCau.getViTri());
        dto.setQuanHuyen(yeuCau.getQuanHuyen());
        dto.setThanhPho(yeuCau.getThanhPho());
        dto.setLoaiBds(yeuCau.getLoaiBds());
        dto.setMucDichTinDang(yeuCau.getTrangThai());
        dto.setSoPhongNgu(yeuCau.getSoPhongNgu());
        dto.setSoPhongTam(yeuCau.getSoPhongTam());
        dto.setTang(yeuCau.getTang());
        dto.setTongTang(dto.getTongTang());
        dto.setNoiThat(yeuCau.getNoiThat());
        dto.setNamXayDung(yeuCau.getNamXayDung());
        dto.setAnhChinh(yeuCau.getAnhChinh());
        dto.setAnhPhu(
        yeuCau.getHinhAnhYeuCauList()
                        .stream()
                        .map(HinhAnhYeuCau::getDuongDan)
                        .toList()
        );
        return dto;
    }
}
