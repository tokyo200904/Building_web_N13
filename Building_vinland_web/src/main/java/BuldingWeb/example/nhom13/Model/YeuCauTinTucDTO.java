package BuldingWeb.example.nhom13.Model;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YeuCauTinTucDTO {
    private Integer maYeuCauTt;
    private String tieuDe;
    private String anhDaiDien;
    private String tenNguoiGui;
    private LocalDateTime ngayTaoYeuCauTt;
}
