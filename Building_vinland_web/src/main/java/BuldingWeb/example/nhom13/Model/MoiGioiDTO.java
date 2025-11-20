package BuldingWeb.example.nhom13.Model;

import BuldingWeb.example.nhom13.Model.Reponse.NhanVienReponse;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoiGioiDTO {
    private Integer maMoiGioi;
    private String tenCongTy;
    private String soGiayPhep;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private String gioiThieu;
    private String hinhAnh;

    private List<NhanVienReponse> danhSachNhanVien;
}
