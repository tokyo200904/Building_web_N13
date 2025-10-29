package BuldingWeb.example.nhom13.Model;

import BuldingWeb.example.nhom13.Enums.TrangThaiBDS;
import lombok.*;

import java.math.BigDecimal;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class bdsDTO {
    private Integer maBds;
    private String anhChinh;
    private String tieuDe;
    private BigDecimal dienTich;
    private String viTri;
    private BigDecimal gia;
    private TrangThaiBDS trangThai;
}
