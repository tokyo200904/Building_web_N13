package BuldingWeb.example.nhom13.Model;

import BuldingWeb.example.nhom13.Enums.*;
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
public class ctbdsDTO {
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

    private String anhDaiDien;
    private String hoTen;
    private VaiTro vaiTro;
    private String soDienThoai;

    private List<String> duongDan;
}
