package BuldingWeb.example.nhom13.Model;

import BuldingWeb.example.nhom13.Enums.VaiTro;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDkDTO {
    @NotBlank(message = "Email khong duoc de trong")
    @Email(message = "định dạng Email khong hop le")
    private String email;
    @NotBlank(message = "Mat khau khong duoc de trong")
    private String matKhau;
    @NotBlank(message = "Vai tro khong duoc de trong")
    @Size(min = 3, max = 100, message = "Họ tên phải từ 3 đến 100 ký tự")
    private String hoTen;

}
