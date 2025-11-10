package BuldingWeb.example.nhom13.Model.Reponse;

import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Enums.VaiTro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReponse {
    private Integer userId;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String anhDaiDien;
    private VaiTro vaiTro;
    private boolean isBanned;
    public static UserReponse fromEntity(User user) {
        return UserReponse.builder()
                .userId(user.getUserId())
                .hoTen(user.getHoTen())
                .email(user.getEmail())
                .soDienThoai(user.getSoDienThoai())
                .anhDaiDien(user.getAnhDaiDien())
                .vaiTro(user.getVaiTro())
                .isBanned(user.isBanned())
                .build();
    }
}
