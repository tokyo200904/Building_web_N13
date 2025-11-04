package BuldingWeb.example.nhom13.Model.Reponse;

import BuldingWeb.example.nhom13.Enums.LoaiBDS;
import BuldingWeb.example.nhom13.Enums.TrangThaiBDS;
import lombok.*;

import java.math.BigDecimal;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class tkbdsReponse {
    private String searchTerm;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private BigDecimal minArea;
    private BigDecimal maxArea;
    private String loaiBds;
    private String trangThai;
    private String viTri;
}
