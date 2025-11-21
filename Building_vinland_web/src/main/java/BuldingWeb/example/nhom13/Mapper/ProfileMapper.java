package BuldingWeb.example.nhom13.Mapper;

import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Enums.VaiTro;
import BuldingWeb.example.nhom13.Model.Reponse.ProfileReponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProfileMapper {
    @Autowired
    private ObjectMapper objectMapper;
    public ProfileReponse mapUserToProfileDTO(User user){
        String fb = "";
        String zalo = "";

        if (user.getLienKetMxh() != null && !user.getLienKetMxh().isEmpty()) {
            try {

                Map<String, String> links = objectMapper.readValue(user.getLienKetMxh(), Map.class);

                fb = links.getOrDefault("facebook", "");
                zalo = links.getOrDefault("zalo", "");

            } catch (Exception e) {
            }
        }
        String tenCty = "Chưa cập nhật";
        if (user.getMoiGioi() != null) {
            tenCty = user.getMoiGioi().getTenCongTy();
        } else if (user.getVaiTro() == VaiTro.ADMIN) {
            tenCty = "Quản trị hệ thống";
        } else if (user.getVaiTro() == VaiTro.CUSTOMER) {
            tenCty = "Khách hàng cá nhân";
        }
        return ProfileReponse.builder()
                .userId(user.getUserId())
                .hoTen(user.getHoTen())
                .email(user.getEmail())
                .soDienThoai(user.getSoDienThoai())
                .diaChi(user.getDiaChi())
                .gioiThieu(user.getGioiThieu())
                .anhDaiDien(user.getAnhDaiDien())
                .vaiTro(user.getVaiTro())
                .facebookLink(fb)
                .zaloLink(zalo)
                .tenCongTy(tenCty)
                .build();
    }
}
