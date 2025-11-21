package BuldingWeb.example.nhom13.Model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoiMkDTO {

    @NotBlank(message = "Mật khẩu hiện tại không được để trống")
    private String matKhauHienTai;

    @NotBlank(message = "Mật khẩu mới không được để trống")
    private String matKhauMoi;

    @NotBlank(message = "Xác nhận mật khẩu không được để trống")
    private String xacNhanMatKhau;
}
