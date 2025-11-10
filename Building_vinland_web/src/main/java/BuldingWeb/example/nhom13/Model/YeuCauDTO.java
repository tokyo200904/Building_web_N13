package BuldingWeb.example.nhom13.Model;

import BuldingWeb.example.nhom13.Enums.DonViTien;
import BuldingWeb.example.nhom13.Enums.LoaiBDS;
import BuldingWeb.example.nhom13.Enums.NoiThat;
import BuldingWeb.example.nhom13.Enums.TrangThaiBDS;
import lombok.*;

import java.math.BigDecimal;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YeuCauDTO {
    private String tieuDe;
    private String moTa;
    private LoaiBDS loaiBds;
    private TrangThaiBDS mucDichTinDang;
    private BigDecimal gia;
    private DonViTien donViTien;
    private BigDecimal dienTich;
    private Integer soPhongNgu;
    private Integer soPhongTam;
    private Integer tang;
    private Integer tongTang;
    private Boolean baiDoXe;
    private Boolean banCong;
    private Boolean thangMay;
    private String viTri;
    private String quanHuyen;
    private String thanhPho;
    private NoiThat noiThat;
    private Integer namXayDung;
}
