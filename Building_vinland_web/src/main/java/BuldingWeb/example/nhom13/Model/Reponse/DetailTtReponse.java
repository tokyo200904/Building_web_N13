package BuldingWeb.example.nhom13.Model.Reponse;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailTtReponse {
    private Integer maYeuCauTt;
    private String tieuDe;
    private String duongDan;
    private String noiDung;
    private String anhDaiDien;
    private LocalDateTime ngayXuatBan;
    private LocalDateTime ngayTaoYeuCauTt;


    private String tenNguoiGui;
    private String emailNguoiGui;
    private String sdtNguoiGui;
}
