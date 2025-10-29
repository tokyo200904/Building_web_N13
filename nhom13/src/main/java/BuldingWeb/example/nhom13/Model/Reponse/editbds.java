package BuldingWeb.example.nhom13.Model.Reponse;

import BuldingWeb.example.nhom13.Enums.DonViTien;
import BuldingWeb.example.nhom13.Enums.LoaiBDS;
import BuldingWeb.example.nhom13.Enums.NoiThat;
import BuldingWeb.example.nhom13.Enums.TrangThaiBDS;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class editbds{
    private int maBds;
    private String tieuDe;
    private String moTa;
    private BigDecimal gia;
    private DonViTien donViTien;
    private LoaiBDS loaiBds;
    private TrangThaiBDS trangThai;
    private String viTri;
    private BigDecimal dienTich;
    private Integer soPhongNgu;
    private Integer soPhongTam;
    private Integer tongTang;
    private NoiThat noiThat;
    private Integer namXayDung;
    private Boolean baiDoXe;
    private Boolean banCong;
    private Boolean thangMay;
    private String anhChinh;
    private LocalDateTime ngayTao;

    private List<String> duongDan;
}
