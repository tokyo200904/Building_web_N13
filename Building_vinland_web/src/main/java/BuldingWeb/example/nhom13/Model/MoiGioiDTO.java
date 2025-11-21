package BuldingWeb.example.nhom13.Model;

import BuldingWeb.example.nhom13.Model.Reponse.NhanVienReponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Tên công ty không được để trống")
    @Size(min = 3, max = 100, message = "Tên công ty phải từ 3 đến 100 ký tự")
    private String tenCongTy;

    private String soGiayPhep;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^\\d{10,11}$", message = "Số điện thoại phải có 10 hoặc 11 số")
    private String soDienThoai;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Định dạng email không hợp lệ")
    private String email;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;
    private String gioiThieu;
    private String hinhAnh;

    private List<NhanVienReponse> danhSachNhanVien;
}
