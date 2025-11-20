package BuldingWeb.example.nhom13.Mapper;

import BuldingWeb.example.nhom13.Entity.MoiGioi;
import BuldingWeb.example.nhom13.Model.MoiGioiDTO;
import BuldingWeb.example.nhom13.Model.Reponse.NhanVienReponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MoiGioiMapper {
    public MoiGioiDTO toDTO(MoiGioi entity) {
        MoiGioiDTO dto = new MoiGioiDTO();
        dto.setMaMoiGioi(entity.getMaMoiGioi());
        dto.setTenCongTy(entity.getTenCongTy());
        dto.setSoGiayPhep(entity.getSoGiayPhep());
        dto.setSoDienThoai(entity.getSoDienThoai());
        dto.setEmail(entity.getEmail());
        dto.setDiaChi(entity.getDiaChi());
        dto.setGioiThieu(entity.getGioiThieu());
        dto.setHinhAnh(entity.getHinhAnh());
        if (entity.getUser() != null) {
            List<NhanVienReponse> listNv = entity.getUser().stream()
                    .map(user -> {
                        NhanVienReponse nv = new NhanVienReponse();
                        nv.setUserId(user.getUserId());
                        nv.setHoTen(user.getHoTen());
                        nv.setEmail(user.getEmail());
                        nv.setSoDienThoai(user.getSoDienThoai());
                        nv.setAnhDaiDien(user.getAnhDaiDien());
                        return nv;
                    })
                    .collect(Collectors.toList());

            dto.setDanhSachNhanVien(listNv);
        } else {
            dto.setDanhSachNhanVien(new ArrayList<>());
        }
        return dto;
    }

    public MoiGioi toEntity(MoiGioiDTO dto) {
        MoiGioi entity = new MoiGioi();
        entity.setTenCongTy(dto.getTenCongTy());
        entity.setSoGiayPhep(dto.getSoGiayPhep());
        entity.setSoDienThoai(dto.getSoDienThoai());
        entity.setEmail(dto.getEmail());
        entity.setDiaChi(dto.getDiaChi());
        entity.setGioiThieu(dto.getGioiThieu());
        return entity;
    }
}
