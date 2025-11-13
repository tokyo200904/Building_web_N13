package BuldingWeb.example.nhom13.Model.Reponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import lombok.Data;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class dangTinTucReponse {
    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 255, message = "Tiêu đề không quá 255 ký tự")
    private String tieuDe;

    @NotBlank(message = "Đường dẫn (slug) không được để trống")
    @Size(max = 255, message = "Đường dẫn không quá 255 ký tự")
    private String duongDan;

    @NotBlank(message = "Nội dung không được để trống")
    private String noiDung;

    private LocalDateTime ngayXuatBan;
}
