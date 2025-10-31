package BuldingWeb.example.nhom13.Entity;

import BuldingWeb.example.nhom13.Enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bds_yeu_cau")
public class YeuCauDangTin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mayc_bds")
    private Integer maYeuCauBds;

    @Column(name = "tieu_de", nullable = false, length = 255)
    private String tieuDe;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(nullable = false)
    private BigDecimal gia;

    @Enumerated(EnumType.STRING)
    @Column(name = "don_vi_tien", nullable = false)
    private DonViTien donViTien;

    @Enumerated(EnumType.STRING)
    @Column(name = "loai_bds", nullable = false)
    private LoaiBDS loaiBds;

    @Column(name = "vi_tri", nullable = false, length = 500)
    private String viTri;

    @Column(name = "quan_huyen", nullable = false, length = 100)
    private String quanHuyen;

    @Column(name = "thanh_pho", nullable = false, length = 100)
    private String thanhPho;

    @Column(name = "dien_tich", nullable = false)
    private BigDecimal dienTich;

    @Column(name = "so_phong_ngu")
    private Integer soPhongNgu;

    @Column(name = "so_phong_tam")
    private Integer soPhongTam;

    private Integer tang;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai")
    private TrangThaiBDS trangThai;

    @Column(name = "tong_tang")
    private Integer tongTang;

    @Enumerated(EnumType.STRING)
    @Column(name = "noi_that")
    private NoiThat noiThat;

    @Column(name = "nam_xay_dung")
    private Integer namXayDung;

    @Column(name = "bai_do_xe")
    private Boolean baiDoXe = false;

    @Column(name = "ban_cong")
    private Boolean banCong = false;

    @Column(name = "thang_may")
    private Boolean thangMay = false;

    @Column(name = "anh_chinh", nullable = false, length = 1024)
    private String anhChinh;


    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai_yeu_cau", nullable = false)
    private TrangThaiYeuCau trangThaiYeuCau = TrangThaiYeuCau.CHO_DUYET;

    @Column(name = "loi_nhan_tu_choi", columnDefinition = "TEXT")
    private String loiNhanTuChoi;

    @CreationTimestamp
    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTaoYeuCau;

    @UpdateTimestamp
    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhatYeuCau;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_gui", nullable = false)
    private User userGuiYeuCau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_duyet")
    private User userDuyet;

    @OneToMany(mappedBy = "yeuCauDangTin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HinhAnhYeuCau> hinhAnhYeuCauList;
}