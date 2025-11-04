package BuldingWeb.example.nhom13.Model.Reponse;

import BuldingWeb.example.nhom13.Enums.TrangThaiBDS;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YeuCauDtReponse {
    private Integer maYeuCauBds;
    private String tieuDe;
    private String tenNguoiGui;
    private LocalDateTime ngayTaoYeuCau;
    private BigDecimal gia;
    private BigDecimal dienTich;
    private String diaChi;
    private String anhChinh;
    private TrangThaiBDS trangThai;

}
