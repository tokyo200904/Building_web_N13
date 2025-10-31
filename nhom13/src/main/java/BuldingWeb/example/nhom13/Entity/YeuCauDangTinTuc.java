package BuldingWeb.example.nhom13.Entity;

import BuldingWeb.example.nhom13.Enums.TrangThaiYeuCauTinTuc; // Import enum mới
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tin_tuc_yc")
public class YeuCauDangTinTuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_yctt")
    private Integer maYeuCauTt;

    @Column(name = "ma_cm")
    private Integer maCm;

    @Column(name = "tieu_de", nullable = false, length = 255)
    private String tieuDe;

    @Column(name = "duong_dan", unique = true, nullable = false, length = 255)
    private String duongDan;

    @Column(name = "noi_dung", columnDefinition = "LONGTEXT", nullable = false)
    private String noiDung;

    @Column(name = "anh_dai_dien", length = 500)
    private String anhDaiDien;

    @Column(name = "ngay_xuat_ban")
    private LocalDateTime ngayXuatBan;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai", nullable = false)
    private TrangThaiYeuCauTinTuc trangThaiYeuCauTt;

    @Column(name = "loi_nhan", columnDefinition = "TEXT")
    private String loiNhanTuChoi;

    @CreationTimestamp
    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTaoYeuCauTt;

    @UpdateTimestamp
    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhatYeuCauTt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_gui", nullable = false)
    private User userGuiYeuCau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_duyet")
    private User userDuyet;

    @OneToMany(mappedBy = "yeuCauDangTinTuc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HinhAnhYeuCauTinTuc> hinhAnhYeuCauTinTucList;
}