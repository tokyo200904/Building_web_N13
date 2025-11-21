package BuldingWeb.example.nhom13.Model.Reponse;


import BuldingWeb.example.nhom13.Enums.VaiTro;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileReponse {
    private Integer userId;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private String gioiThieu;
    private String anhDaiDien;
    private VaiTro vaiTro;
    private String tenCongTy;
    private String facebookLink;
    private String zaloLink;
}
